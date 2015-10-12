package com.harry0000.fit.message;

import com.harry0000.fit.field.Field;
import com.harry0000.fit.vo.BaseType;
import com.harry0000.fit.vo.FitMessage;

public class FileId extends DataMessage {

    public enum Fields implements FieldProfile {
        FILE_TYPE    (0, BaseType.ENUM),
        MANUFACTURER (1, BaseType.UINT16),
        PRODUCT      (2, BaseType.UINT16),
        SERIAL_NUMBER(3, BaseType.UINT32Z),
        TIME_CREATED (4, BaseType.UINT32),
        NUMBER       (5, BaseType.UINT16),
        PRODUCT_NAME (8, BaseType.STRING);

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
    public FileId(final DataMessage msg) {
        super(msg);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.message.DataMessage#getGlobalFitMessage()
     */
    @Override
    public FitMessage getFitMessage() {
        return FitMessage.FILE_ID;
    }

    /**
     * @return
     */
    public Integer getFileType() {
        final Number value = getFieldToNumber(Fields.FILE_TYPE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param fileType
     */
    public void setFileType(final Integer fileType) {
        final Field<?> f = getOrAddField(Fields.FILE_TYPE);
        f.setValue(fileType);
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
    public Long getTimeCreated() {
        return getFieldToUnixTime(Fields.TIME_CREATED);
    }

    /**
     * @param timeCreated
     */
    public void setTimeCreated(final Long timeCreated) {
        final Field<?> f = getOrAddField(Fields.TIME_CREATED);
        f.setValue(toFitTimestamp(timeCreated));
    }

    /**
     * @return
     */
    public Integer getNumber() {
        final Number value = getFieldToNumber(Fields.NUMBER);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param number
     */
    public void setNumber(final Integer number) {
        final Field<?> f = getOrAddField(Fields.NUMBER);
        f.setValue(number);
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
