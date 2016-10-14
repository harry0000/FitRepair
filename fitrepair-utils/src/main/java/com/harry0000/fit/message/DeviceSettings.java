package com.harry0000.fit.message;

import com.harry0000.fit.vo.BaseType;

public class DeviceSettings extends DataMessage {

    public enum Fields implements FieldProfile {
        ACTIVE_TIME_ZONE(0, BaseType.UINT8),
        UTC_OFFSET      (1, BaseType.UINT32),
        TIME_ZONE_OFFSET(5, BaseType.SINT8);

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
    public DeviceSettings(final DataMessage msg) {
        super(msg);
    }

    /**
     * @return
     */
    public Integer getActiveTimeZone() {
        return getFieldToNumber(Fields.ACTIVE_TIME_ZONE).map(Number::intValue).orElse(null);
    }

    /**
     * @param activeTimeZone
     */
    public void setActiveTimeZone(final Integer activeTimeZone) {
        getOrAddField(Fields.ACTIVE_TIME_ZONE).setValue(activeTimeZone);
    }

    /**
     * @return
     */
    public Long getUtcOffset() {
        return getFieldToNumber(Fields.UTC_OFFSET).map(Number::longValue).orElse(null);
    }

    /**
     * @param utcOffset
     */
    public void setUtcOffset(final Long utcOffset) {
        getOrAddField(Fields.UTC_OFFSET).setValue(utcOffset);
    }

    /**
     * @return
     */
    public Byte getTimeZoneOffset() {
        return getFieldToNumber(Fields.TIME_ZONE_OFFSET).map(Number::byteValue).orElse(null);
    }

    /**
     * @param timeZoneOffset
     */
    public void setTimeZoneOffset(final Byte timeZoneOffset) {
        getOrAddField(Fields.TIME_ZONE_OFFSET).setValue(timeZoneOffset);
    }

}
