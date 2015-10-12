package com.harry0000.fit.message;

import com.harry0000.fit.field.Field;
import com.harry0000.fit.vo.BaseType;
import com.harry0000.fit.vo.FitMessage;

public class DeviceInfo extends DataMessage {

    public enum Fields implements FieldProfile {
        DEVICE_INDEX         (0,  BaseType.UINT8),
        DEVICE_TYPE          (1,  BaseType.UINT8),
        MANUFACTURER         (2,  BaseType.UINT16),
        SERIAL_NUMBER        (3,  BaseType.UINT32Z),
        PRODUCT              (4,  BaseType.UINT16),
        SOFTWARE_VERSION     (5,  BaseType.UINT16),
        HARDWARE_VERSION     (6,  BaseType.UINT8),
        CUM_OPERATING_TIME   (7,  BaseType.UINT32),
        BATTERY_VOLTAGE      (10, BaseType.UINT16),
        BATTERY_STATUS       (11, BaseType.UINT8),
        SENSOR_POSITION      (18, BaseType.ENUM),
        DESCRIPTOR           (19, BaseType.STRING),
        ANT_TRANSMISSION_TYPE(20, BaseType.UINT8Z),
        ANT_DEVICE_NUMBER    (21, BaseType.UINT16Z),
        ANT_NETWORK          (22, BaseType.ENUM),
        SOURCE_TYPE          (25, BaseType.ENUM),
        PRODUCT_NAME         (27, BaseType.STRING);

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
    public DeviceInfo(final DataMessage msg) {
        super(msg);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.message.DataMessage#getGlobalFitMessage()
     */
    @Override
    public FitMessage getFitMessage() {
        return FitMessage.DEVICE_INFO;
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

    /**
     * @return
     */
    public Integer getDeviceType() {
        final Number value = getFieldToNumber(Fields.DEVICE_TYPE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param deviceType
     */
    public void setDeviceType(final Integer deviceType) {
        final Field<?> f = getOrAddField(Fields.DEVICE_TYPE);
        f.setValue(deviceType);
    }

    /**
     * @return
     */
    public Integer getManufacturer() {
        final Number value = getFieldToNumber(Fields.MANUFACTURER);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param manufacturer
     */
    public void setManufacturer(final Integer manufacturer) {
        final Field<?> f = getOrAddField(Fields.MANUFACTURER);
        f.setValue(manufacturer);
    }

    /**
     * @return
     */
    public Long getSerialNumber() {
        final Number value = getFieldToNumber(Fields.SERIAL_NUMBER);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param serialNumber
     */
    public void setSerialNumber(final Long serialNumber) {
        final Field<?> f = getOrAddField(Fields.SERIAL_NUMBER);
        f.setValue(serialNumber);
    }

    /**
     * @return
     */
    public Integer getProduct() {
        final Number value = getFieldToNumber(Fields.PRODUCT);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param product
     */
    public void setProduct(final Integer product) {
        final Field<?> f = getOrAddField(Fields.PRODUCT);
        f.setValue(product);
    }

    /**
     * @return
     */
    public Integer getSoftwareVersion() {
        final Number value = getFieldToNumber(Fields.SOFTWARE_VERSION);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param softwareVersion
     */
    public void setSoftwareVersion(final Integer softwareVersion) {
        final Field<?> f = getOrAddField(Fields.SOFTWARE_VERSION);
        f.setValue(softwareVersion);
    }

    /**
     * @return
     */
    public Integer getHardwareVersion() {
        final Number value = getFieldToNumber(Fields.HARDWARE_VERSION);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param hardwareVersion
     */
    public void setHardwareVersion(final Integer hardwareVersion) {
        final Field<?> f = getOrAddField(Fields.HARDWARE_VERSION);
        f.setValue(hardwareVersion);
    }

    /**
     * @return
     */
    public Long getCumOperatingTime() {
        final Number value = getFieldToNumber(Fields.CUM_OPERATING_TIME);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param cumOperatingTime
     */
    public void setCumOperatingTime(final Long cumOperatingTime) {
        final Field<?> f = getOrAddField(Fields.CUM_OPERATING_TIME);
        f.setValue(cumOperatingTime);
    }

    /**
     * @return
     */
    public Integer getBatteryVoltage() {
        final Number value = getFieldToNumber(Fields.BATTERY_VOLTAGE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param batteryVoltage
     */
    public void setBatteryVoltage(final Integer batteryVoltage) {
        final Field<?> f = getOrAddField(Fields.BATTERY_VOLTAGE);
        f.setValue(batteryVoltage);
    }

    /**
     * @return
     */
    public Integer getBatteryStatus() {
        final Number value = getFieldToNumber(Fields.BATTERY_STATUS);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param batteryStatus
     */
    public void setBatteryStatus(final Integer batteryStatus) {
        final Field<?> f = getOrAddField(Fields.BATTERY_STATUS);
        f.setValue(batteryStatus);
    }

    /**
     * @return
     */
    public Integer getSensorPosition() {
        final Number value = getFieldToNumber(Fields.SENSOR_POSITION);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param sensorPosition
     */
    public void setSensorPosition(final Integer sensorPosition) {
        final Field<?> f = getOrAddField(Fields.SENSOR_POSITION);
        f.setValue(sensorPosition);
    }

    /**
     * @return
     */
    public String getDescriptor() {
        return getFieldToString(Fields.DESCRIPTOR);
    }

    /**
     * @param descriptor
     */
    public void setDescriptor(final String descriptor) {
        final Field<?> f = getOrAddField(Fields.DESCRIPTOR);
        f.setValue(descriptor);
    }

    /**
     * @return
     */
    public Integer getAntTransmissionType() {
        final Number value = getFieldToNumber(Fields.ANT_TRANSMISSION_TYPE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param antTransmissionType
     */
    public void setAntTransmissionType(final Integer antTransmissionType) {
        final Field<?> f = getOrAddField(Fields.ANT_TRANSMISSION_TYPE);
        f.setValue(antTransmissionType);
    }

    /**
     * @return
     */
    public Integer getAntDeviceNumber() {
        final Number value = getFieldToNumber(Fields.ANT_DEVICE_NUMBER);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param antDeviceNumber
     */
    public void setAntDeviceNumber(final Integer antDeviceNumber) {
        final Field<?> f = getOrAddField(Fields.ANT_DEVICE_NUMBER);
        f.setValue(antDeviceNumber);
    }

    /**
     * @return
     */
    public Integer getAntNetwork() {
        final Number value = getFieldToNumber(Fields.ANT_NETWORK);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param antNetwork
     */
    public void setAntNetwork(final Integer antNetwork) {
        final Field<?> f = getOrAddField(Fields.ANT_NETWORK);
        f.setValue(antNetwork);
    }

    /**
     * @return
     */
    public Integer getSourceType() {
        final Number value = getFieldToNumber(Fields.SOURCE_TYPE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param sourceType
     */
    public void setSourceType(final Integer sourceType) {
        final Field<?> f = getOrAddField(Fields.SOURCE_TYPE);
        f.setValue(sourceType);
    }

    /**
     * @return
     */
    public String getProductName() {
        return getFieldToString(Fields.PRODUCT_NAME);
    }

    /**
     * @param productName
     */
    public void setProductName(final String productName) {
        final Field<?> f = getOrAddField(Fields.PRODUCT_NAME);
        f.setValue(productName);
    }

}
