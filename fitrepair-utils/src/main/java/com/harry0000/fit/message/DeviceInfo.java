package com.harry0000.fit.message;

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
        return getFieldToNumber(Fields.DEVICE_INDEX).map(Number::intValue).orElse(null);
    }

    /**
     * @param deviceIndex
     */
    public void setDeviceIndex(final Integer deviceIndex) {
        getOrAddField(Fields.DEVICE_INDEX).setValue(deviceIndex);
    }

    /**
     * @return
     */
    public Integer getDeviceType() {
        return getFieldToNumber(Fields.DEVICE_TYPE).map(Number::intValue).orElse(null);
    }

    /**
     * @param deviceType
     */
    public void setDeviceType(final Integer deviceType) {
        getOrAddField(Fields.DEVICE_TYPE).setValue(deviceType);
    }

    /**
     * @return
     */
    public Integer getManufacturer() {
        return getFieldToNumber(Fields.MANUFACTURER).map(Number::intValue).orElse(null);
    }

    /**
     * @param manufacturer
     */
    public void setManufacturer(final Integer manufacturer) {
        getOrAddField(Fields.MANUFACTURER).setValue(manufacturer);
    }

    /**
     * @return
     */
    public Long getSerialNumber() {
        return getFieldToNumber(Fields.SERIAL_NUMBER).map(Number::longValue).orElse(null);
    }

    /**
     * @param serialNumber
     */
    public void setSerialNumber(final Long serialNumber) {
        getOrAddField(Fields.SERIAL_NUMBER).setValue(serialNumber);
    }

    /**
     * @return
     */
    public Integer getProduct() {
        return getFieldToNumber(Fields.PRODUCT).map(Number::intValue).orElse(null);
    }

    /**
     * @param product
     */
    public void setProduct(final Integer product) {
        getOrAddField(Fields.PRODUCT).setValue(product);
    }

    /**
     * @return
     */
    public Integer getSoftwareVersion() {
        return getFieldToNumber(Fields.SOFTWARE_VERSION).map(Number::intValue).orElse(null);
    }

    /**
     * @param softwareVersion
     */
    public void setSoftwareVersion(final Integer softwareVersion) {
        getOrAddField(Fields.SOFTWARE_VERSION).setValue(softwareVersion);
    }

    /**
     * @return
     */
    public Integer getHardwareVersion() {
        return getFieldToNumber(Fields.HARDWARE_VERSION).map(Number::intValue).orElse(null);
    }

    /**
     * @param hardwareVersion
     */
    public void setHardwareVersion(final Integer hardwareVersion) {
        getOrAddField(Fields.HARDWARE_VERSION).setValue(hardwareVersion);
    }

    /**
     * @return
     */
    public Long getCumOperatingTime() {
        return getFieldToNumber(Fields.CUM_OPERATING_TIME).map(Number::longValue).orElse(null);
    }

    /**
     * @param cumOperatingTime
     */
    public void setCumOperatingTime(final Long cumOperatingTime) {
        getOrAddField(Fields.CUM_OPERATING_TIME).setValue(cumOperatingTime);
    }

    /**
     * @return
     */
    public Integer getBatteryVoltage() {
        return getFieldToNumber(Fields.BATTERY_VOLTAGE).map(Number::intValue).orElse(null);
    }

    /**
     * @param batteryVoltage
     */
    public void setBatteryVoltage(final Integer batteryVoltage) {
        getOrAddField(Fields.BATTERY_VOLTAGE).setValue(batteryVoltage);
    }

    /**
     * @return
     */
    public Integer getBatteryStatus() {
        return getFieldToNumber(Fields.BATTERY_STATUS).map(Number::intValue).orElse(null);
    }

    /**
     * @param batteryStatus
     */
    public void setBatteryStatus(final Integer batteryStatus) {
        getOrAddField(Fields.BATTERY_STATUS).setValue(batteryStatus);
    }

    /**
     * @return
     */
    public Integer getSensorPosition() {
        return getFieldToNumber(Fields.SENSOR_POSITION).map(Number::intValue).orElse(null);
    }

    /**
     * @param sensorPosition
     */
    public void setSensorPosition(final Integer sensorPosition) {
        getOrAddField(Fields.SENSOR_POSITION).setValue(sensorPosition);
    }

    /**
     * @return
     */
    public String getDescriptor() {
        return getFieldToString(Fields.DESCRIPTOR).orElse(null);
    }

    /**
     * @param descriptor
     */
    public void setDescriptor(final String descriptor) {
        getOrAddField(Fields.DESCRIPTOR).setValue(descriptor);
    }

    /**
     * @return
     */
    public Integer getAntTransmissionType() {
        return getFieldToNumber(Fields.ANT_TRANSMISSION_TYPE).map(Number::intValue).orElse(null);
    }

    /**
     * @param antTransmissionType
     */
    public void setAntTransmissionType(final Integer antTransmissionType) {
        getOrAddField(Fields.ANT_TRANSMISSION_TYPE).setValue(antTransmissionType);
    }

    /**
     * @return
     */
    public Integer getAntDeviceNumber() {
        return getFieldToNumber(Fields.ANT_DEVICE_NUMBER).map(Number::intValue).orElse(null);
    }

    /**
     * @param antDeviceNumber
     */
    public void setAntDeviceNumber(final Integer antDeviceNumber) {
        getOrAddField(Fields.ANT_DEVICE_NUMBER).setValue(antDeviceNumber);
    }

    /**
     * @return
     */
    public Integer getAntNetwork() {
        return getFieldToNumber(Fields.ANT_NETWORK).map(Number::intValue).orElse(null);
    }

    /**
     * @param antNetwork
     */
    public void setAntNetwork(final Integer antNetwork) {
        getOrAddField(Fields.ANT_NETWORK).setValue(antNetwork);
    }

    /**
     * @return
     */
    public Integer getSourceType() {
        return getFieldToNumber(Fields.SOURCE_TYPE).map(Number::intValue).orElse(null);
    }

    /**
     * @param sourceType
     */
    public void setSourceType(final Integer sourceType) {
        getOrAddField(Fields.SOURCE_TYPE).setValue(sourceType);
    }

    /**
     * @return
     */
    public String getProductName() {
        return getFieldToString(Fields.PRODUCT_NAME).orElse(null);
    }

    /**
     * @param productName
     */
    public void setProductName(final String productName) {
        getOrAddField(Fields.PRODUCT_NAME).setValue(productName);
    }

}
