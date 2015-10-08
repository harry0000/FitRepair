package com.harry0000.fitrepair;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.harry0000.fit.Reader;
import com.harry0000.fit.message.Record;
import com.harry0000.fit.vo.FileType;

public class Checker {
    private static final Logger logger = LoggerFactory.getLogger(Checker.class);
    private static final double THRESHOLD = 0.5D;

    private Record lastMsg;
    private int increase;

    /**
     * 
     */
    public Checker() {
    }

    /**
     * @param fitFile
     * @return
     */
    public List<Record> check(final File fitFile) {
        final List<Record> invalids = new ArrayList<>();

        final Reader reader = new Reader();
        reader.getDispatcher().setFileIdListener(
            (defMsg, msg) -> {
                final FileType type = FileType.get(msg.getFileType());
                if (type != FileType.ACTIVITY) {
                    logger.warn("Fit file is not an activity file. fileType: {}", msg.getFileType());
                    reader.stop();
                }
            });
        reader.getDispatcher().setRecordListener(
            (defMsg, msg) -> {
                final Integer power = msg.getPower();
                if (power == null || power.equals(0xFFFF)) {
                    increase = 0;
                    lastMsg = msg;
                    return;
                }

                if (increase != 0 && power != 0) {
                    // Calc dropped power.
                    final int doropped = (power - lastMsg.getPower()) * -1;
                    if (doropped > increase * THRESHOLD) {
                        // Sharp drop.
                        logger.info("Timestamp: {}", new Date(lastMsg.getTimestamp()));
                        logger.info("Power    : 0 -> {} -> {}", lastMsg.getPower(),   power);
                        logger.info("Cadence  : - -> {} -> {}", lastMsg.getCadence(), msg.getCadence());

                        invalids.add(lastMsg);
                    }
                    increase = 0;
                } else {
                    if (lastMsg != null &&
                        lastMsg.getPower() != null &&
                        lastMsg.getPower() == 0) {
                        // Store increase power from 0 Watt.
                        increase = power;
                    } else {
                        // Reset increase power.
                        increase = 0;
                    }
                }

                lastMsg = msg;
            });

        final boolean result;
        try (final InputStream in = new FileInputStream(fitFile)) {
            result = reader.read(in);
        } catch (final IOException e) {
            logger.warn("Error while reading fit file.", e);
            return Collections.emptyList();
        } finally {
            increase = 0;
            lastMsg = null;
            reader.getDispatcher().removeListeners();
        }

        if (!result) {
            logger.warn("Failed to read fit file.");
            return Collections.emptyList();
        }

        return invalids;
    }

}
