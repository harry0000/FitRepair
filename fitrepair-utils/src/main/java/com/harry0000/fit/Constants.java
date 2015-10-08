package com.harry0000.fit;

public class Constants {

    public static final int RECORD_HEADER_TYPE_MASK        = 0xF0;
    public static final int COMPRESSED_TIMESTAMP           = 0x80;
    public static final int DEFINITION_MESSAGE             = 0x40;
    public static final int DATA_MESSAGE                   = 0x00;

    public static final int COMPRESSED_TIMESTAMP_MASK      = 0x1F;
    public static final int COMPRESSED_TIMESTAMP_TYPE_MASK = 0x60;

    public static final int LOCAL_MESSAGE_TYPE_MASK        = 0x0F;
    public static final int MAX_LOCAL_MESSAGE_NUMS         = LOCAL_MESSAGE_TYPE_MASK + 1;

    public static final byte FIELD_INVALID       = (byte) 0xFF;
    public static final byte FIELD_MESSAGE_INDEX = (byte) 0xFE;
    public static final byte FIELD_TIMESTAMP     = (byte) 0xFD;

    public static final byte LITTLE_ENDIAN = 0;
    public static final byte BIG_ENDIAN    = 1;

    private Constants() {}

}