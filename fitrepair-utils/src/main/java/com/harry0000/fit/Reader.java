package com.harry0000.fit;

import static com.harry0000.fit.Constants.COMPRESSED_TIMESTAMP;
import static com.harry0000.fit.Constants.COMPRESSED_TIMESTAMP_MASK;
import static com.harry0000.fit.Constants.DATA_MESSAGE;
import static com.harry0000.fit.Constants.DEFINITION_MESSAGE;
import static com.harry0000.fit.Constants.MAX_LOCAL_MESSAGE_NUMS;
import static com.harry0000.fit.Constants.RECORD_HEADER_TYPE_MASK;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.harry0000.fit.event.MessageEventDispatcher;
import com.harry0000.fit.field.Field;
import com.harry0000.fit.field.FieldDefinition;
import com.harry0000.fit.field.FieldFactory;
import com.harry0000.fit.message.DataMessage;
import com.harry0000.fit.message.DefinitionMessage;

public class Reader {
    private static final Logger logger = LoggerFactory.getLogger(Reader.class);

    /**
     * @param fitFile
     * @return
     */
    public static boolean isVaild(final File fitFile) {
        final InputStream in;
        try {
            in = new FileInputStream(fitFile);
        } catch (final FileNotFoundException e) {
            logger.info("Fit file does not exist.", e);
            return false;
        }

        final Header header = new Header();
        try {
            header.readHeader(in);
        } catch (final IOException e) {
            logger.info("Error while reading fit file header.", e);
            return false;
        }

        if (!header.isValid()) {
            logger.info("Fit file header is not valid.");
            return false;
        }

        final byte[] data = new byte[header.getDataSize() + 2];
        try {
            in.read(data);
        } catch (final IOException e) {
            logger.info("Error while reading fit records and CRC.", e);
            return false;
        }

        final CRC crc = new CRC();
        crc.update(header.getHeader(), header.getHeaderSize());
        crc.update(data);

        if (crc.getValue() != 0x0000) {
            logger.info("Fit file CRC error.");
            return false;
        }

        return true;
    }

    protected static class TimestampOffset {
        private long timestamp;
        private int lastTimeOffset;

        /**
         * 
         */
        public TimestampOffset() {
        }

        /**
         * @param timestamp
         */
        public void updateTimestamp(final long timestamp) {
            this.timestamp = timestamp;
            this.lastTimeOffset = (int) (timestamp & COMPRESSED_TIMESTAMP_MASK);
        }

        /**
         * @param offset
         */
        public void setOffset(final int offset) {
            this.timestamp += (offset - lastTimeOffset) & COMPRESSED_TIMESTAMP_MASK;
            this.lastTimeOffset = offset;
        }

        /**
         * @return the timestamp
         */
        public long getTimestamp() {
            return timestamp;
        }
    }

    private int readBytes;
    private boolean stop;

    private final CRC crc = new CRC();
    private final TimestampOffset timestampOffset = new TimestampOffset();
    private final MessageEventDispatcher dispatcher;

    /**
     * 
     */
    public Reader() {
        this.dispatcher = new MessageEventDispatcher();
    }

    /**
     * @param dispatcher
     */
    public Reader(final MessageEventDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    /**
     * @param in
     * @return
     * @throws IOException 
     */
    public boolean read(InputStream in) throws IOException {
        // Read header.
        final Header header = new Header();
        header.readHeader(in);

        if (!header.isValid()) {
            logger.error("Fit file header is not valid.");
            return false;
        }

        crc.reset();
        readBytes = 0;
        stop = false;
        for (int i = 0; i < header.getHeaderSize(); i++) {
            crc.update(header.getHeader()[i]);
        }

        dispatcher.onHeader(header);

        // Read data records.
        final DefinitionMessage[] definitions = new DefinitionMessage[MAX_LOCAL_MESSAGE_NUMS];
        final int dataSize = header.getDataSize();

        int data = -1;
        while (readBytes < dataSize && (data = in.read()) > -1) {
            // Record header byte was read.
            readBytes++;

            final int recordType = data & RECORD_HEADER_TYPE_MASK;

            if (recordType == DEFINITION_MESSAGE) {
                final DefinitionMessage defMsg = new DefinitionMessage((byte) data);
                readDefinitionMessage(defMsg, in);

                // Store new definition message.
                definitions[defMsg.getLocalMessageType()] = defMsg;

                dispatcher.onDefinitionMessage(defMsg);
            } else {
                final DataMessage msg;
                if (recordType == COMPRESSED_TIMESTAMP) {
                    final int timeOffset = data & COMPRESSED_TIMESTAMP_MASK;
                    timestampOffset.setOffset(timeOffset);

                    msg = new DataMessage((byte) data, timestampOffset.getTimestamp());
                } else if (recordType == DATA_MESSAGE) {
                    msg = new DataMessage((byte) data);
                } else {
                    logger.error("Unknown message header type. message header: 0x{}", Integer.toHexString(data));
                    return false;
                }

                final DefinitionMessage defMsg = definitions[msg.getLocalMessageType()];
                if (defMsg == null) {
                    logger.error(
                        "Definition message does not exists. message header: {}, read: {} bytes",
                        data,
                        header.getHeaderSize() + readBytes
                    );
                    return false;
                }

                readDataMessage(defMsg, msg, in);

                dispatcher.onDataMessage(defMsg, msg);
            }

            if (stop) {
                logger.info("Stop reading. read: {} bytes", header.getHeaderSize() + readBytes);
                return false;
            }
        }

        if (readBytes != dataSize) {
            logger.error(
                "A mismatch between read message size and defined size of the header. read: {} bytes, defined: {} bytes",
                readBytes,
                dataSize
            );
            return false;
        }

        // read crc(2 bytes).
        for (int i = 0; i < 2; i++) {
            final int d = in.read();
            if (d < 0) {
                logger.error("Unexpected EOF while reading crc. read: {} bytes", header.getHeaderSize() + readBytes + i + 1);
                return false;
            }
            crc.update((byte) d);
        }

        if (crc.getValue() != 0) {
            logger.error("Fit file CRC error.");
            return false;
        }

        // check EOF.
        if (in.read() > 0) {
            logger.error("Unexpected data exists after crc. read: {} bytes", header.getHeaderSize() + readBytes + 2);
            return false;
        }

        return true;
    }

    /**
     * @param defMsg
     * @param in
     * @throws IOException
     */
    protected void readDefinitionMessage(final DefinitionMessage defMsg,
                                         InputStream in) throws IOException {
        final byte[] params = new byte[5];
        readBytes += in.read(params);

        crc.update(defMsg.getHeader());
        crc.update(params);

        defMsg.setReserved(params[0]);
        defMsg.setArchitecture(params[1]);
        defMsg.setFitMessageNumber(ByteBuffer.wrap(params, 2, 2).order(defMsg.getByteOrder()).getShort());
        defMsg.setNumOfFields(params[4]);

        final List<FieldDefinition> fields = new ArrayList<>();
        for (int i = 0; i < defMsg.getNumOfFields(); i++) {
            final byte[] fieldDef = new byte[3];
            readBytes += in.read(fieldDef);
            crc.update(fieldDef);

            fields.add(new FieldDefinition(fieldDef[0], fieldDef[1], fieldDef[2]));
        }
        defMsg.setFields(fields);
    }

    /**
     * @param recordHeader
     * @param defMsg
     * @param msg
     * @param in
     * @throws IOException
     */
    protected void readDataMessage(final DefinitionMessage defMsg,
                                   final DataMessage msg,
                                   InputStream in) throws IOException {
        crc.update(msg.getHeader());

        final ByteOrder bo = defMsg.getByteOrder();
        for (final FieldDefinition def : defMsg.getFields()) {
            final byte[] value = new byte[def.getSize()];
            readBytes += in.read(value);
            crc.update(value);

            final Field<?> field = FieldFactory.build(def, value, bo);
            msg.getFields().add(field);

            // Update timestamp.
            if (field.isTimestamp() && field.toNumber() != null)  {
                timestampOffset.updateTimestamp(field.toNumber().longValue());
            }
        }
    }

    /**
     * 
     */
    public void stop() {
        this.stop = true;
    }

    /**
     * @return the dispatcher
     */
    public MessageEventDispatcher getDispatcher() {
        return dispatcher;
    }

}
