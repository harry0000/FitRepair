package com.harry0000.fit.message;

import com.harry0000.fit.vo.BaseType;
import com.harry0000.fit.vo.FitMessage;

public class Event extends DataMessage {

    public enum Fields implements FieldProfile {
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
        return getFieldToNumber(Fields.EVENT).map(Number::intValue).orElse(null);
    }

    /**
     * @param event
     */
    public void setEvent(final Integer event) {
        getOrAddField(Fields.EVENT).setValue(event);
    }

    /**
     * @return
     */
    public Integer getEventType() {
        return getFieldToNumber(Fields.EVENT_TYPE).map(Number::intValue).orElse(null);
    }

    /**
     * @param eventType
     */
    public void setEventType(final Integer eventType) {
        getOrAddField(Fields.EVENT_TYPE).setValue(eventType);
    }

    /**
     * @return
     */
    public Integer getData16() {
        return getFieldToNumber(Fields.DATA16).map(Number::intValue).orElse(null);
    }

    /**
     * @param data16
     */
    public void setData16(final Integer data16) {
        getOrAddField(Fields.DATA16).setValue(data16);
    }

    /**
     * @return
     */
    public Long getData() {
        return getFieldToNumber(Fields.DATA).map(Number::longValue).orElse(null);
    }

    /**
     * @param data
     */
    public void setData(final Long data) {
        getOrAddField(Fields.DATA).setValue(data);
    }

    /**
     * @return
     */
    public Integer getEventGroup() {
        return getFieldToNumber(Fields.EVENT_GROUP).map(Number::intValue).orElse(null);
    }

    /**
     * @param eventGroup
     */
    public void setEventGroup(final Integer eventGroup) {
        getOrAddField(Fields.EVENT_GROUP).setValue(eventGroup);
    }

    /**
     * @return
     */
    public Integer getScore() {
        return getFieldToNumber(Fields.SCORE).map(Number::intValue).orElse(null);
    }

    /**
     * @param score
     */
    public void setScore(final Integer score) {
        getOrAddField(Fields.SCORE).setValue(score);
    }

    /**
     * @return
     */
    public Integer getOpponentScore() {
        return getFieldToNumber(Fields.OPPONENT_SCORE).map(Number::intValue).orElse(null);
    }

    /**
     * @param opponentScore
     */
    public void setOpponentScore(final Integer opponentScore) {
        getOrAddField(Fields.OPPONENT_SCORE).setValue(opponentScore);
    }

    /**
     * @return
     */
    public Integer getFrontGearNum() {
        return getFieldToNumber(Fields.FRONT_GEAR_NUM).map(Number::intValue).orElse(null);
    }

    /**
     * @param frontGearNum
     */
    public void setFrontGearNum(final Integer frontGearNum) {
        getOrAddField(Fields.FRONT_GEAR_NUM).setValue(frontGearNum);
    }

    /**
     * @return
     */
    public Integer getFrontGear() {
        return getFieldToNumber(Fields.FRONT_GEAR).map(Number::intValue).orElse(null);
    }

    /**
     * @param frontGear
     */
    public void setFrontGear(final Integer frontGear) {
        getOrAddField(Fields.FRONT_GEAR).setValue(frontGear);
    }

    /**
     * @return
     */
    public Integer getRearGearNum() {
        return getFieldToNumber(Fields.REAR_GEAR_NUM).map(Number::intValue).orElse(null);
    }

    /**
     * @param rearGearNum
     */
    public void setRearGearNum(final Integer rearGearNum) {
        getOrAddField(Fields.REAR_GEAR_NUM).setValue(rearGearNum);
    }

    /**
     * @return
     */
    public Integer getRearGear() {
        return getFieldToNumber(Fields.REAR_GEAR).map(Number::intValue).orElse(null);
    }

    /**
     * @param rearGear
     */
    public void setRearGear(final Integer rearGear) {
        getOrAddField(Fields.REAR_GEAR).setValue(rearGear);
    }

    /**
     * @return
     */
    public Integer getDeviceIndex() {
        return getFieldToNumber(Fields.DEVICE_INDEX).map(Number::intValue).orElse(null);
    }

    /**
     * @param deviceIndex
     */
    public void setDeviceIndex(final Integer deviceIndex) {
        getOrAddField(Fields.DEVICE_INDEX).setValue(deviceIndex);
    }

}
