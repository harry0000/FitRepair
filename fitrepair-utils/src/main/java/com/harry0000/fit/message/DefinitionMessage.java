package com.harry0000.fit.message;

import static com.harry0000.fit.Constants.BIG_ENDIAN;
import static com.harry0000.fit.Constants.LITTLE_ENDIAN;
import static com.harry0000.fit.Constants.LOCAL_MESSAGE_TYPE_MASK;

import java.nio.ByteOrder;
import java.util.List;

import com.harry0000.fit.field.FieldDefinition;

public class DefinitionMessage {

    private final int localMessageType;
    private final byte header;
    private byte reserved;
    private byte architecture;
    private short fitMessageNumber;
    private byte numOfFields;
    private List<FieldDefinition> fields;

    /**
     * @param header
     */
    public DefinitionMessage(final byte header) {
        this.header = header;
        this.localMessageType = header & LOCAL_MESSAGE_TYPE_MASK;
    }

    /**
     * @return the localMessageType
     */
    public int getLocalMessageType() {
        return localMessageType;
    }

    /**
     * @return the header
     */
    public byte getHeader() {
        return header;
    }

    /**
     * @return the reserved
     */
    public byte getReserved() {
        return reserved;
    }

    /**
     * @param reserved the reserved to set
     */
    public void setReserved(byte reserved) {
        this.reserved = reserved;
    }

    /**
     * @return the architecture
     */
    public byte getArchitecture() {
        return architecture;
    }

    /**
     * @param architecture the architecture to set
     */
    public void setArchitecture(byte architecture) {
        this.architecture = architecture;
    }

    /**
     * @return the fitMessageNumber
     */
    public short getFitMessageNumber() {
        return fitMessageNumber;
    }

    /**
     * @param fitMessageNumber the fitMessageNumber to set
     */
    public void setFitMessageNumber(short fitMessageNumber) {
        this.fitMessageNumber = fitMessageNumber;
    }

    /**
     * @return the numOfFields
     */
    public byte getNumOfFields() {
        return numOfFields;
    }

    /**
     * @param numOfFields the numOfFields to set
     */
    public void setNumOfFields(byte numOfFields) {
        this.numOfFields = numOfFields;
    }

    /**
     * @return the fields
     */
    public List<FieldDefinition> getFields() {
        return fields;
    }

    /**
     * @param fields the fields to set
     */
    public void setFields(List<FieldDefinition> fields) {
        this.fields = fields;
    }

    /**
     * @param byteOrder
     */
    public void setByteOrder(final ByteOrder byteOrder) {
        setArchitecture(
            byteOrder == ByteOrder.LITTLE_ENDIAN ?
                LITTLE_ENDIAN :
                BIG_ENDIAN
        );
    }

    /**
     * @return
     */
    public ByteOrder getByteOrder() {
        return architecture == LITTLE_ENDIAN ?
                   ByteOrder.LITTLE_ENDIAN :
                   ByteOrder.BIG_ENDIAN;
    }

}
