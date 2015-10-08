package com.harry0000.fitrepair;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.harry0000.fit.CRC;
import com.harry0000.fit.Reader;
import com.harry0000.fit.Writer;
import com.harry0000.fit.message.Record;
import com.harry0000.fit.vo.FileType;

public class Repair {
    private static final Logger logger = LoggerFactory.getLogger(Repair.class);

    private int maxPower;
    private long powerDataCount;
    /** accumlated power (exclude invalid power) */
    private long accumlated;
    /** last lap accumlated power */
    private long lastAccumlated;
    /** accumlated invalid power */
    private long accumlatedInvalid;
    /** last lap accumlated invalid power */
    private long lastAccumlatedInvalid;

    private List<Integer> lapMaxPower = new ArrayList<>();
    private List<Long> lapPowerDataCount = new ArrayList<>();

    /**
     * 
     */
    public Repair() {
    }

    /**
     * @param fitFile
     * @param repairedFile
     * @param invalids
     * @return
     */
    public boolean repair(final File fitFile,
                          final File repairedFile,
                          final List<Record> invalids) {
        if (invalids == null || invalids.isEmpty()) {
            logger.warn("No Invalid power datas.");
            return false;
        }

        final Set<Long> targetTimestamps = new HashSet<>(invalids.size());
        for (final Record r : invalids) {
            targetTimestamps.add(r.getTimestamp());
        }

        final boolean result;
        final Reader reader = new Reader();
        try (final InputStream in = new FileInputStream(fitFile);
             final OutputStream out = new FileOutputStream(repairedFile)) {
            reader.getDispatcher().setHeaderLintener(
                (header) -> {
                    try {
                        Writer.writeHeader(header, out);
                    } catch (final IOException e) {
                        logger.error("Error while writing header.", e);
                        reader.stop();
                    }
                });
            reader.getDispatcher().setDefinitionMsgListener(
                (defMsg) -> {
                    try {
                        Writer.writeDefinitionMessage(defMsg, out);
                    } catch (final IOException e) {
                        logger.error("Error while writing definition message.", e);
                        reader.stop();
                    }
                });
            reader.getDispatcher().setDataMsgListener(
                (defMsg, msg) -> {
                    try {
                        Writer.writeDataMessage(defMsg, msg, out);
                    } catch (final IOException e) {
                        logger.error("Error while writing data message.", e);
                        reader.stop();
                    }
                });
            reader.getDispatcher().setFileIdListener(
                (defMsg, msg) -> {
                    final FileType type = FileType.get(msg.getFileType());
                    if (type != FileType.ACTIVITY) {
                        logger.warn("Fit file is not an activity file. fileType: {}", msg.getFileType());
                        reader.stop();
                        return;
                    }

                    try {
                        Writer.writeDataMessage(defMsg, msg, out);
                    } catch (final IOException e) {
                        logger.error("Error while writing fileId message.", e);
                        reader.stop();
                    }
                });
            reader.getDispatcher().setRecordListener(
                (defMsg, msg) -> {
                    final Integer value = msg.getPower();
                    if (value != null && value != 0xFFFF) {
                        powerDataCount++;

                        final int power = value.intValue();
                        if (targetTimestamps.remove(msg.getTimestamp())) {
                            // Repair power to 0 Watt.
                            msg.setPower(0);
                            accumlatedInvalid += power;
                        } else {
                            // Update max power.
                            maxPower = Math.max(maxPower, power);
                        }
                    }

                    accumlated = msg.getAccumulatedPower() - accumlatedInvalid;
                    msg.setAccumulatedPower(accumlated);

                    try {
                        Writer.writeDataMessage(defMsg, msg, out);
                    } catch (final IOException e) {
                        logger.error("Error while writing record message.", e);
                        reader.stop();
                    }
                });
            reader.getDispatcher().setLapListener(
                (defMsg, msg) -> {
                    final long sumPower = accumlated - lastAccumlated;
                    final int avgPower = powerDataCount != 0 ?
                                             (int)Math.round((double)sumPower / powerDataCount) :
                                             0;
                    msg.setAvgPower(avgPower);
                    msg.setMaxPower(maxPower);

                    logger.info("---   Lap   ---");
                    logger.info("Record Count    : {}", powerDataCount);
                    logger.info("SumPower        : {} (-{})", sumPower, accumlatedInvalid - lastAccumlatedInvalid);
                    logger.info("AvgPower        : {}", msg.getAvgPower());
                    logger.info("MaxPower        : {}", msg.getMaxPower());
                    logger.info("NormalizedPower : {}", msg.getNormalizedPower());

                    try {
                        Writer.writeDataMessage(defMsg, msg, out);
                    } catch (final IOException e) {
                        logger.error("Error while writing lap message.", e);
                        reader.stop();
                    }

                    lapMaxPower.add(maxPower);
                    lapPowerDataCount.add(powerDataCount);

                    lastAccumlated = accumlated;
                    lastAccumlatedInvalid = accumlatedInvalid;

                    maxPower = 0;
                    powerDataCount = 0L;
                });
            reader.getDispatcher().setSessionListener(
                (defMsg, msg) -> {
                    final Integer maxPower = lapMaxPower.stream().reduce(Math::max).get();
                    final Long recordCount = lapPowerDataCount.stream().reduce(Long::sum).get();

                    final int avgPower = recordCount != 0 ?
                                             (int)Math.round((double)accumlated / recordCount) :
                                             0;
                    msg.setMaxPower(maxPower);
                    msg.setAvgPower(avgPower);

                    logger.info("--- Session ---");
                    logger.info("Record Count    : {}", recordCount);
                    logger.info("SumPower        : {} (-{})", accumlated, accumlatedInvalid);
                    logger.info("AvgPower        : {}", msg.getAvgPower());
                    logger.info("MaxPower        : {}", msg.getMaxPower());
                    logger.info("NormalizedPower : {}", msg.getNormalizedPower());

                    try {
                        Writer.writeDataMessage(defMsg, msg, out);
                    } catch (final IOException e) {
                        logger.error("Error while writing session message.", e);
                        reader.stop();
                    }
                });

            result = reader.read(in);
        } catch (final IOException e) {
            logger.error("Error while reading fit file.", e);
            return false;
        } finally {
            maxPower = 0;
            powerDataCount = 0L;
            accumlated = 0L;
            lastAccumlated = 0L;
            accumlatedInvalid = 0L;
            lastAccumlatedInvalid = 0L;
            lapMaxPower.clear();
            lapPowerDataCount.clear();
            reader.getDispatcher().removeListeners();
        }

        if (!result) {
            logger.warn("Failed to read fit file.");
            return false;
        }

        // Write CRC.
        try (final RandomAccessFile dest = new RandomAccessFile(repairedFile, "rw")) {
            final CRC crc = new CRC();
            int data;
            while ((data = dest.read()) > -1) {
                crc.update((byte) data);
            }
            dest.write((int) (crc.getValue()        & 0xFF));
            dest.write((int) ((crc.getValue() >> 8) & 0xFF));
        } catch (final IOException e) {
            logger.error("Error while writing CRC.", e);
            return false;
        }

        return true;
    }

}
