package com.harry0000.fit.message;

import com.harry0000.fit.field.Field;
import com.harry0000.fit.vo.BaseType;
import com.harry0000.fit.vo.FitMessage;

public class Event extends DataMessage {

    private enum Fields implements FieldProfile {
        EVENT         (0,  BaseType.ENUM),
        EVENT_TYPE    (1,  BaseType.ENUM),
        DATA16        (2,  BaseType.UINT16),
        DATA          (3,  BaseType.UINT32),
        EVENT_GROUP   (4,  BaseType.UINT8),
        SCORE         (7,  BaseType.UINT16),
        OPPONENT_SCORE(8,  BaseType.UINT16),
        FRONT_GEAR_NUM(9,  BaseType.UINT8Z),
        FRONT_GEAR    (10, BaseType.UINT8Z),
        REAR_GEAR_NUM (11, BaseType.UINT8Z),
        REAR_GEAR     (12, BaseType.UINT8Z),
        DEVICE_INDEX  (13, BaseType.UINT8);

        private final byte definitionNumber;
        private final BaseType baseType;

        /**
         * @param definitionNumber
         * @param baseType
         */
        private Fields(final int definitionNumber,
                       final BaseType baseType) {
            this.definitionNumber = (byte) definitionNumber;
            this.baseType = baseType;
        }

        /* (non-Javadoc)
         * @see com.harry0000.Fit.message.FieldType#getDefinitionNumber()
         */
        @Override
        public byte getDefinitionNumber() {
            return definitionNumber;
        }

        /* (non-Javadoc)
         * @see com.harry0000.Fit.message.FieldType#getBaseType()
         */
        @Override
        public BaseType getBaseType() {
            return baseType;
        }
    }

    /**
     * @param msg
     */
    public Event(final DataMessage msg) {
        super(msg);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.message.DataMessage#getGlobalFitMessage()
     */
    @Override
    public FitMessage getFitMessage() {
        return FitMessage.EVENT;
    }

    /**
     * @return
     */
    public Integer getEvent() {
        final Number value = getFieldToNumber(Fields.EVENT);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param event
     */
    public void setEvent(final Integer event) {
        final Field<?> f = getOrAddField(Fields.EVENT);
        f.setValue(event);
    }

    /**
     * @return
     */
    public Integer getEventType() {
        final Number value = getFieldToNumber(Fields.EVENT_TYPE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param eventType
     */
    public void setEventType(final Integer eventType) {
        final Field<?> f = getOrAddField(Fields.EVENT_TYPE);
        f.setValue(eventType);
    }

    /**
     * @return
     */
    public Integer getData16() {
        final Number value = getFieldToNumber(Fields.DATA16);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param data16
     */
    public void setData16(final Integer data16) {
        final Field<?> f = getOrAddField(Fields.DATA16);
        f.setValue(data16);
    }

    /**
     * @return
     */
    public Long getData() {
        final Number value = getFieldToNumber(Fields.DATA);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param data
     */
    public void setData(final Long data) {
        final Field<?> f = getOrAddField(Fields.DATA);
        f.setValue(data);
    }

    /**
     * @return
     */
    public Integer getEventGroup() {
        final Number value = getFieldToNumber(Fields.EVENT_GROUP);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param eventGroup
     */
    public void setEventGroup(final Integer eventGroup) {
        final Field<?> f = getOrAddField(Fields.EVENT_GROUP);
        f.setValue(eventGroup);
    }

    /**
     * @return
     */
    public Integer getScore() {
        final Number value = getFieldToNumber(Fields.SCORE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param score
     */
    public void setScore(final Integer score) {
        final Field<?> f = getOrAddField(Fields.SCORE);
        f.setValue(score);
    }

    /**
     * @return
     */
    public Integer getOpponentScore() {
        final Number value = getFieldToNumber(Fields.OPPONENT_SCORE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param opponentScore
     */
    public void setOpponentScore(final Integer opponentScore) {
        final Field<?> f = getOrAddField(Fields.OPPONENT_SCORE);
        f.setValue(opponentScore);
    }

    /**
     * @return
     */
    public Integer getFrontGearNum() {
        final Number value = getFieldToNumber(Fields.FRONT_GEAR_NUM);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param frontGearNum
     */
    public void setFrontGearNum(final Integer frontGearNum) {
        final Field<?> f = getOrAddField(Fields.FRONT_GEAR_NUM);
        f.setValue(frontGearNum);
    }

    /**
     * @return
     */
    public Integer getFrontGear() {
        final Number value = getFieldToNumber(Fields.FRONT_GEAR);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param frontGear
     */
    public void setFrontGear(final Integer frontGear) {
        final Field<?> f = getOrAddField(Fields.FRONT_GEAR);
        f.setValue(frontGear);
    }

    /**
     * @return
     */
    public Integer getRearGearNum() {
        final Number value = getFieldToNumber(Fields.REAR_GEAR_NUM);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param rearGearNum
     */
    public void setRearGearNum(final Integer rearGearNum) {
        final Field<?> f = getOrAddField(Fields.REAR_GEAR_NUM);
        f.setValue(rearGearNum);
    }

    /**
     * @return
     */
    public Integer getRearGear() {
        final Number value = getFieldToNumber(Fields.REAR_GEAR);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param rearGear
     */
    public void setRearGear(final Integer rearGear) {
        final Field<?> f = getOrAddField(Fields.REAR_GEAR);
        f.setValue(rearGear);
    }

    /**
     * @return
     */
    public Integer getDeviceIndex() {
        final Number value = getFieldToNumber(Fields.DEVICE_INDEX);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param deviceIndex
     */
    public void setDeviceIndex(final Integer deviceIndex) {
        final Field<?> f = getOrAddField(Fields.DEVICE_INDEX);
        f.setValue(deviceIndex);
    }

}
