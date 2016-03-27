package com.harry0000.fit.vo;

import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum BaseType {

    ENUM   (0x00, 1, DataType.UNSIGNED,        0xFF),
    SINT8  (0x01, 1, DataType.SIGNED,          (byte) 0x7F),
    UINT8  (0x02, 1, DataType.UNSIGNED,        0xFF),
    SINT16 (0x83, 2, DataType.SIGNED,          (short) 0x7FFF),
    UINT16 (0x84, 2, DataType.UNSIGNED,        0xFFFF),
    SINT32 (0x85, 4, DataType.SIGNED,          0x7FFFFFFF),
    UINT32 (0x86, 4, DataType.UNSIGNED,        0xFFFFFFFFL),
    STRING (0x07, 1, DataType.NULL_TERMINATED, (byte)0x00),
    FLOAT32(0x88, 4, DataType.UNSIGNED,        Float.intBitsToFloat(0xFFFFFFFF)),
    FLOAT64(0x89, 8, DataType.UNSIGNED,        Double.longBitsToDouble(0xFFFFFFFFFFFFFFFFL)),
    UINT8Z (0x0A, 1, DataType.NULL_TERMINATED, 0x00),
    UINT16Z(0x8B, 2, DataType.NULL_TERMINATED, 0x00),
    UINT32Z(0x8C, 4, DataType.NULL_TERMINATED, 0x00L),
    BYTE   (0x0D, 1, DataType.UNSIGNED,        0xFF);

    public static int    INVALID_ENUM    = ENUM.getInvalid().intValue();
    public static byte   INVALID_SINT8   = SINT8.getInvalid().byteValue();
    public static int    INVALID_UINT8   = UINT8.getInvalid().intValue();
    public static short  INVALID_SINT16  = SINT16.getInvalid().shortValue();
    public static int    INVALID_UINT16  = UINT16.getInvalid().intValue();
    public static int    INVALID_SINT32  = SINT32.getInvalid().intValue();
    public static long   INVALID_UINT32  = UINT32.getInvalid().longValue();
    public static float  INVALID_FLOAT32 = FLOAT32.getInvalid().floatValue();
    public static double INVALID_FLOAT64 = FLOAT64.getInvalid().doubleValue();
    public static int    INVALID_UINT8Z  = UINT8Z.getInvalid().intValue();
    public static int    INVALID_UINT16Z = UINT16Z.getInvalid().intValue();
    public static long   INVALID_UINT32Z = UINT32Z.getInvalid().longValue();
    public static int    INVALID_BYTE    = BYTE.getInvalid().intValue();

    private enum DataType {
        SIGNED,
        UNSIGNED,
        NULL_TERMINATED;
    }

    private static final Map<Byte, BaseType> BASE_TYPES;
    static {
        final BaseType[] types = BaseType.values();
        final Map<Byte, BaseType> m = new HashMap<>(types.length);
        for (final BaseType type : types) {
            m.put(type.getType(), type);
        }
        BASE_TYPES = Collections.unmodifiableMap(m);
    }

    /**
     * @param size
     * @param dataType
     * @param byteOrder
     * @return
     */
    private static byte[] getInvalidValue(final int size,
                                          final DataType dataType,
                                          final ByteOrder byteOrder) {
        final byte[] value = new byte[size];
        if (dataType == DataType.NULL_TERMINATED) {
            return value;
        }

        Arrays.fill(value, (byte) 0xFF);

        if (dataType == DataType.SIGNED) {
            final int offset = byteOrder == ByteOrder.BIG_ENDIAN ?
                                   0 :
                                   size - 1;
            value[offset] = 0x7F;
        }

        return value;
    }

    /**
     * @param type
     * @return
     */
    public static BaseType get(final Byte type) {
        if (type == null) {
            return null;
        }
        return BASE_TYPES.get(type);
    }

    private final byte type;
    private final int size;
    private final DataType dataType;
    private final Number invalid;

    /**
     * @param type
     * @param size
     * @param dataType
     * @param invalid
     */
    private BaseType(final int type,
                     final int size,
                     final DataType dataType,
                     final Number invalid) {
        this.type = (byte) type;
        this.size = size;
        this.dataType = dataType;
        this.invalid = invalid;
    }

    /**
     * @return the type
     */
    public Byte getType() {
        return type;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @return the invalid
     */
    public Number getInvalid() {
        return invalid;
    }

    /**
     * @param byteOrder
     * @return
     */
    public byte[] getInvalid(final ByteOrder byteOrder) {
        return getInvalidValue(size, dataType, byteOrder);
    }

}
