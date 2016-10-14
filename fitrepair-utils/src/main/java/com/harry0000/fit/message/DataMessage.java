package com.harry0000.fit.message;

import static com.harry0000.fit.Constants.COMPRESSED_TIMESTAMP;
import static com.harry0000.fit.Constants.COMPRESSED_TIMESTAMP_TYPE_MASK;
import static com.harry0000.fit.Constants.DATA_MESSAGE;
import static com.harry0000.fit.Constants.FIELD_TIMESTAMP;
import static com.harry0000.fit.Constants.LOCAL_MESSAGE_TYPE_MASK;
import static com.harry0000.fit.Constants.RECORD_HEADER_TYPE_MASK;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private static Optional<Long> toDateTime(final Number fitTimestamp) {
        return Optional.ofNullable(fitTimestamp)
                       .map(t -> t.longValue() * 1000L + TIMESTAMP_OFFSET);
    }

    /**
     * @param unixTime
     * @return
     */
    protected static Optional<Long> toFitTimestamp(final Long unixTime) {
        return Optional.ofNullable(unixTime)
                       .map(t -> (t - TIMESTAMP_OFFSET) / 1000L);
    }

    private final byte header;
    private final Optional<Long> timestamp;
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
        this.timestamp = Optional.ofNullable(timestamp);
    }

    /**
     * @param msg
     */
    DataMessage(final DataMessage msg) {
        this.header = msg.header;
        this.timestamp = msg.timestamp;
        this.fields.addAll(msg.fields);
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
        return getFieldOpt(definitionNumber).orElse(null);
    }

    /**
     * @param definitionNumber
     * @return
     */
    public Optional<Field<?>> getFieldOpt(final byte definitionNumber) {
        return fields
                .stream()
                .filter(f -> f.getDefinitionNumber() == definitionNumber)
                .findFirst();
    }

    /**
     * @param fieldType
     * @return
     */
    protected Optional<Field<?>> getField(final FieldProfile fieldType) {
        return getFieldOpt(fieldType.getDefinitionNumber());
    }

    /**
     * @param definitionNumber
     * @param baseType
     * @return
     */
    protected Field<?> getOrAddField(final byte definitionNumber, final BaseType baseType) {
        return getFieldOpt(definitionNumber)
                .orElseGet(() -> {
                    final Field<?> newField = FieldFactory.build(new FieldDefinition(definitionNumber, baseType));
                    fields.add(newField);
                    return newField;
                });
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
    protected Optional<Number> getFieldToNumber(final byte definitionNumber) {
        return getFieldOpt(definitionNumber).map(Field::toNumber);
    }

    /**
     * @param fieldType
     * @return
     */
    protected Optional<Number> getFieldToNumber(final FieldProfile fieldType) {
        return getFieldToNumber(fieldType.getDefinitionNumber());
    }

    /**
     * @param definitionNumber
     * @return
     */
    protected Optional<String> getFieldToString(final byte definitionNumber) {
        return getFieldOpt(definitionNumber).map(Field::toString);
    }

    /**
     * @param fieldType
     * @return
     */
    protected Optional<String> getFieldToString(final FieldProfile fieldType) {
        return getFieldToString(fieldType.getDefinitionNumber());
    }

    /**
     * @param definitionNumber
     * @return
     */
    protected Optional<Long> getFieldToUnixTime(final byte definitionNumber) {
        return getFieldToNumber(definitionNumber).flatMap(DataMessage::toDateTime);
    }

    /**
     * @param fieldType
     * @return
     */
    protected Optional<Long> getFieldToUnixTime(final FieldProfile fieldType) {
        return getFieldToUnixTime(fieldType.getDefinitionNumber());
    }

    /**
     * @return
     */
    public Long getTimestamp() {
        return (isCompressedTimestamp() ? timestamp : getFieldToUnixTime(FIELD_TIMESTAMP)).orElse(null);
    }

    /**
     * @param unixTime
     */
    public void setTimestamp(final Long unixTime) {
        if (isCompressedTimestamp()) {
            return;
        }

        getOrAddField(FIELD_TIMESTAMP, BaseType.UINT32).setValue(toFitTimestamp(unixTime).orElse(null));
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
