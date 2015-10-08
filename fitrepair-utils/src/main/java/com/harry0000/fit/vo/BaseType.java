package com.harry0000.fit.vo;

import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum BaseType {

    ENUM   (0x00, 1, DataType.UNSIGNED),
    SINT8  (0x01, 1, DataType.SIGNED),
    UINT8  (0x02, 1, DataType.UNSIGNED),
    SINT16 (0x83, 2, DataType.SIGNED),
    UINT16 (0x84, 2, DataType.UNSIGNED),
    SINT32 (0x85, 4, DataType.SIGNED),
    UINT32 (0x86, 4, DataType.UNSIGNED),
    STRING (0x07, 1, DataType.NULL_TERMINATED),
    FLOAT32(0x88, 4, DataType.UNSIGNED),
    FLOAT64(0x89, 8, DataType.UNSIGNED),
    UINT8Z (0x0A, 1, DataType.NULL_TERMINATED),
    UINT16Z(0x8B, 2, DataType.NULL_TERMINATED),
    UINT32Z(0x8C, 4, DataType.NULL_TERMINATED),
    BYTE   (0x0D, 1, DataType.UNSIGNED);

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
            Arrays.fill(value, (byte) 0x00);
        } else {
            Arrays.fill(value, (byte) 0xFF);

            if (dataType == DataType.SIGNED) {
                final int offset = byteOrder == ByteOrder.BIG_ENDIAN ?
                                       0 :
                                       size - 1;
                value[offset] = (byte) 0x7F;
            }
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

    /**
     * @param type
     * @param size
     * @param dataType
     */
    private BaseType(final int type,
                     final int size,
                     final DataType dataType) {
        this.type = (byte) type;
        this.size = size;
        this.dataType = dataType;
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
     * @param byteOrder
     * @return
     */
    public byte[] getInvalidValue(final ByteOrder byteOrder) {
        return getInvalidValue(size, dataType, byteOrder);
    }

}
