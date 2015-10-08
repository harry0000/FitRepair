package com.harry0000.fit.message;

import static com.harry0000.fit.Constants.COMPRESSED_TIMESTAMP;
import static com.harry0000.fit.Constants.COMPRESSED_TIMESTAMP_TYPE_MASK;
import static com.harry0000.fit.Constants.DATA_MESSAGE;
import static com.harry0000.fit.Constants.FIELD_TIMESTAMP;
import static com.harry0000.fit.Constants.LOCAL_MESSAGE_TYPE_MASK;
import static com.harry0000.fit.Constants.RECORD_HEADER_TYPE_MASK;

import java.util.ArrayList;
import java.util.List;

import com.harry0000.fit.field.Field;
import com.harry0000.fit.field.FieldDefinition;
import com.harry0000.fit.field.FieldFactory;
import com.harry0000.fit.vo.BaseType;
import com.harry0000.fit.vo.FitMessage;

public class DataMessage {

    /** Offset between Garmin (FIT) time (00:00:00.000 Dec 31 1989). */
    private static final long TIMESTAMP_OFFSET = 631065600000L;

    /**
     * @param fitTimestamp
     * @return
     */
    private static Long toDateTime(final Number fitTimestamp) {
        if (fitTimestamp == null) {
            return null;
        }

        return fitTimestamp.longValue() * 1000 + TIMESTAMP_OFFSET;
    }

    /**
     * @param unixTime
     * @return
     */
    protected static Long toFitTimestamp(final Long unixTime) {
        if (unixTime == null) {
            return null;
        }

        return (unixTime - TIMESTAMP_OFFSET) / 1000;
    }

    private final byte header;
    private final Long timestamp;
    private List<Field<?>> fields = new ArrayList<>();

    /**
     * @param header
     */
    public DataMessage(final byte header) {
        this(header, null);
    }

    /**
     * @param header
     * @param timestamp
     */
    public DataMessage(final byte header, final Long timestamp) {
        this.header = header;
        this.timestamp = timestamp;
    }

    /**
     * @param msg
     */
    DataMessage(final DataMessage msg) {
        this.header = msg.header;
        this.timestamp = msg.timestamp;
        for (final Field<?> field : msg.fields) {
            this.fields.add(field);
        }
    }

    /**
     * @return the name
     */
    public final String getName() {
        return getFitMessage().name().toLowerCase();
    }

    /**
     * @return the fitMessage
     */
    public FitMessage getFitMessage() {
        return FitMessage.UNKNOWN;
    }

    /**
     * @return
     */
    public int getLocalMessageType() {
        if (isCompressedTimestamp()) {
            return (header & COMPRESSED_TIMESTAMP_TYPE_MASK) >> 5;
        }

        return header & LOCAL_MESSAGE_TYPE_MASK;
    }

    /**
     * @return the header
     */
    public byte getHeader() {
        return header;
    }

    /**
     * @return the fields
     */
    public List<Field<?>> getFields() {
        return fields;
    }

    /**
     * @param fields the fields to set
     */
    public void setFields(final List<Field<?>> fields) {
        this.fields = fields;
    }

    /**
     * @param definitionNumber
     * @return
     */
    public Field<?> getField(final byte definitionNumber) {
        for (final Field<?> f : fields) {
            if (definitionNumber == f.getDefinitionNumber()) {
                return f;
            }
        }

        return null;
    }

    /**
     * @param fieldType
     * @return
     */
    protected Field<?> getField(final FieldProfile fieldType) {
        return getField(fieldType.getDefinitionNumber());
    }

    /**
     * @param definitionNumber
     * @param baseType
     * @return
     */
    protected Field<?> getOrAddField(final byte definitionNumber, final BaseType baseType) {
        final Field<?> field = getField(definitionNumber);
        if (field != null) {
            return field;
        }

        final Field<?> newField = FieldFactory.build(new FieldDefinition(definitionNumber, baseType));
        fields.add(newField);
        return newField;
    }

    /**
     * @param fieldType
     * @return
     */
    protected Field<?> getOrAddField(final FieldProfile fieldType) {
        return getOrAddField(fieldType.getDefinitionNumber(), fieldType.getBaseType());
    }

    /**
     * @param definitionNumber
     * @return
     */
    protected Number getFieldToNumber(final byte definitionNumber) {
        final Field<?> field = getField(definitionNumber);
        if (field == null) {
            return null;
        }

        return field.toNumber();
    }

    /**
     * @param fieldType
     * @return
     */
    protected Number getFieldToNumber(final FieldProfile fieldType) {
        return getFieldToNumber(fieldType.getDefinitionNumber());
    }

    /**
     * @param definitionNumber
     * @return
     */
    protected String getFieldToString(final byte definitionNumber) {
        final Field<?> field = getField(definitionNumber);
        if (field == null) {
            return null;
        }

        return field.toString();
    }

    /**
     * @param fieldType
     * @return
     */
    protected String getFieldToString(final FieldProfile fieldType) {
        return getFieldToString(fieldType.getDefinitionNumber());
    }

    /**
     * @param definitionNumber
     * @return
     */
    protected Long getFieldToUnixTime(final byte definitionNumber) {
        return toDateTime(getFieldToNumber(definitionNumber));
    }

    /**
     * @param fieldType
     * @return
     */
    protected Long getFieldToUnixTime(final FieldProfile fieldType) {
        return getFieldToUnixTime(fieldType.getDefinitionNumber());
    }

    /**
     * @return
     */
    public Long getTimestamp() {
        if (isCompressedTimestamp()) {
            return timestamp;
        }

        return getFieldToUnixTime(FIELD_TIMESTAMP);
    }

    /**
     * @param unixTime
     */
    public void setTimestamp(final Long unixTime) {
        if (isCompressedTimestamp()) {
            return;
        }

        final Field<?> field = getOrAddField(FIELD_TIMESTAMP, BaseType.UINT32);
        field.setValue(toFitTimestamp(unixTime));
    }

    /**
     * @return
     */
    public boolean isCompressedTimestamp() {
        return (header & RECORD_HEADER_TYPE_MASK) == COMPRESSED_TIMESTAMP;
    }

    /**
     * @return
     */
    public boolean isNormalMessage() {
        return (header & RECORD_HEADER_TYPE_MASK) == DATA_MESSAGE;
    }

}
