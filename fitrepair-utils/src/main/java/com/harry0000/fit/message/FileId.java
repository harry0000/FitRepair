package com.harry0000.fit.message;

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
        return getFieldToNumber(Fields.FILE_TYPE).map(Number::intValue).orElse(null);
    }

    /**
     * @param fileType
     */
    public void setFileType(final Integer fileType) {
        getOrAddField(Fields.FILE_TYPE).setValue(fileType);
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
    public Long getTimeCreated() {
        return getFieldToUnixTime(Fields.TIME_CREATED).orElse(null);
    }

    /**
     * @param timeCreated
     */
    public void setTimeCreated(final Long timeCreated) {
        getOrAddField(Fields.TIME_CREATED).setValue(toFitTimestamp(timeCreated).orElse(null));
    }

    /**
     * @return
     */
    public Integer getNumber() {
        return getFieldToNumber(Fields.NUMBER).map(Number::intValue).orElse(null);
    }

    /**
     * @param number
     */
    public void setNumber(final Integer number) {
        getOrAddField(Fields.NUMBER).setValue(number);
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
