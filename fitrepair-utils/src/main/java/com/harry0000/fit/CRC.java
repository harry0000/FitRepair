package com.harry0000.fit;

public class CRC {   
    private static final int[] CRC_TABLE = { 0x0000, 0xCC01, 0xD801, 0x1400, 0xF001, 0x3C00, 0x2800, 0xE401,
                                             0xA001, 0x6C00, 0x7800, 0xB401, 0x5000, 0x9C01, 0x8801, 0x4400 };

    private int value;

    public CRC() {
    }

    /**
     * @param crc
     * @param data
     * @return
     */
    private static int update(final int crc, final byte data) {
        int temp = crc;

       // compute checksum of lower four bits of byte
       final int lower = CRC_TABLE[temp & 0x0F];
       temp = (temp >> 4) & 0x0FFF;
       temp = temp ^ lower ^ CRC_TABLE[data & 0x0F];

       // now compute checksum of upper four bits of byte
       final int upper = CRC_TABLE[temp & 0x0F];
       temp = (temp >> 4) & 0x0FFF;
       temp = temp ^ upper ^ CRC_TABLE[(data >> 4) & 0x0F];

       return temp;
    }

    /**
     * @param data
     */
    public void update(final byte data) {
        value = update(value, data);
    }

    /**
     * @param data
     */
    public void update(final byte[] data) {
        for (final byte b : data) {
            value = update(value, b);
        }
    }

    /**
     * @param data
     * @param length
     */
    public void update(final byte[] data, final int length) {
        for (int i = 0; i < length; i++) {
            value = update(value, data[i]);
        }
    }

    /**
     * 
     */
    public void reset() {
        value = 0;
    }

    /**
     * @return
     */
    public int getValue() {
        return value;
    }

}
