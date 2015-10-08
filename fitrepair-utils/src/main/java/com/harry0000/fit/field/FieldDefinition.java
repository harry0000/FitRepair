package com.harry0000.fit.field;

import com.harry0000.fit.vo.BaseType;

public class FieldDefinition {

    private final byte definitionNumber;
    private byte size;
    private byte baseType;

    /**
     * @param definitionNumber
     * @param baseType
     */
    public FieldDefinition(final byte definitionNumber,
                           final BaseType baseType) {
        this(definitionNumber, (byte) baseType.getSize(), baseType.getType());
    }

    /**
     * @param definitionNumber
     * @param size
     * @param baseType
     */
    public FieldDefinition(final byte definitionNumber,
                           final byte size,
                           final byte baseType) {
        this.definitionNumber = definitionNumber;
        this.size = size;
        this.baseType = baseType;
    }

    /**
     * @return the definitionNumber
     */
    public byte getDefinitionNumber() {
        return definitionNumber;
    }

    /**
     * @return the size
     */
    public byte getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(final byte size) {
        this.size = size;
    }

    /**
     * @return the baseType
     */
    public byte getBaseType() {
        return baseType;
    }

    /**
     * @param baseType the baseType to set
     */
    public void setBaseType(final byte baseType) {
        this.baseType = baseType;
    }

}
