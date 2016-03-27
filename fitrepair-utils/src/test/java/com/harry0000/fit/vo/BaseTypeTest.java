package com.harry0000.fit.vo;

import static org.junit.Assert.*;

import java.nio.ByteOrder;
import org.junit.Test;

import com.harry0000.fit.vo.BaseType;

public class BaseTypeTest {

    @Test
    public void testGetInvalidEnum_BigEndian() {
        assertArrayEquals(BaseType.ENUM.getInvalid(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0xFF });
    }

    @Test
    public void testGetInvalidEnum_LittleEndian() {
        assertArrayEquals(BaseType.ENUM.getInvalid(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0xFF });
    }

    @Test
    public void testGetInvalidSInt8_BigEndian() {
        assertArrayEquals(BaseType.SINT8.getInvalid(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0x7F });
    }

    @Test
    public void testGetInvalidSInt8_LittleEndian() {
        assertArrayEquals(BaseType.SINT8.getInvalid(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0x7F });
    }

    @Test
    public void testGetInvalidUInt8_BigEndian() {
        assertArrayEquals(BaseType.UINT8.getInvalid(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0xFF });
    }

    @Test
    public void testGetInvalidUInt8_LittleEndian() {
        assertArrayEquals(BaseType.UINT8.getInvalid(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0xFF });
    }

    @Test
    public void testGetInvalidSInt16_BigEndian() {
        assertArrayEquals(BaseType.SINT16.getInvalid(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0x7F, (byte) 0xFF });
    }

    @Test
    public void testGetInvalidSInt16_LittleEndian() {
        assertArrayEquals(BaseType.SINT16.getInvalid(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0xFF, (byte) 0x7F });
    }

    @Test
    public void testGetInvalidUInt16_BigEndian() {
        assertArrayEquals(BaseType.UINT16.getInvalid(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0xFF, (byte) 0xFF });
    }

    @Test
    public void testGetInvalidUInt16_LittleEndian() {
        assertArrayEquals(BaseType.UINT16.getInvalid(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0xFF, (byte) 0xFF });
    }

    @Test
    public void testGetInvalidSInt32_BigEndian() {
        assertArrayEquals(BaseType.SINT32.getInvalid(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0x7F, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF });
    }

    @Test
    public void testGetInvalidSInt32_LittleEndian() {
        assertArrayEquals(BaseType.SINT32.getInvalid(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0x7F });
    }

    @Test
    public void testGetInvalidUInt32_BigEndian() {
        assertArrayEquals(BaseType.UINT32.getInvalid(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF });
    }

    @Test
    public void testGetInvalidUInt32_LittleEndian() {
        assertArrayEquals(BaseType.UINT32.getInvalid(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF });
    }

    @Test
    public void testGetInvalidString_BigEndian() {
        assertArrayEquals(BaseType.STRING.getInvalid(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0x00 });
    }

    @Test
    public void testGetInvalidString_LittleEndian() {
        assertArrayEquals(BaseType.STRING.getInvalid(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0x00 });
    }

    @Test
    public void testGetInvalidFloat32_BigEndian() {
        assertArrayEquals(BaseType.FLOAT32.getInvalid(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF });
    }

    @Test
    public void testGetInvalidFloat32_LittleEndian() {
        assertArrayEquals(BaseType.FLOAT32.getInvalid(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF });
    }

    @Test
    public void testGetInvalidFloat64_BigEndian() {
        assertArrayEquals(BaseType.FLOAT64.getInvalid(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF });
    }

    @Test
    public void testGetInvalidFloat64_LittleEndian() {
        assertArrayEquals(BaseType.FLOAT64.getInvalid(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF });
    }

    @Test
    public void testGetInvalidUInt8z_BigEndian() {
        assertArrayEquals(BaseType.UINT8Z.getInvalid(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0x00 });
    }

    @Test
    public void testGetInvalidUInt8z_LittleEndian() {
        assertArrayEquals(BaseType.UINT8Z.getInvalid(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0x00 });
    }

    @Test
    public void testGetInvalidUInt16z_BigEndian() {
        assertArrayEquals(BaseType.UINT16Z.getInvalid(ByteOrder.BIG_ENDIAN),    new byte[]{ (byte) 0x00, (byte) 0x00 });
    }

    @Test
    public void testGetInvalidUInt16z_LittleEndian() {
        assertArrayEquals(BaseType.UINT16Z.getInvalid(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0x00, (byte) 0x00 });
    }

    @Test
    public void testGetInvalidUInt32z_BigEndian() {
        assertArrayEquals(BaseType.UINT32Z.getInvalid(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00 });
    }

    @Test
    public void testGetInvalidUInt32z_LittleEndian() {
        assertArrayEquals(BaseType.UINT32Z.getInvalid(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00 });
    }

    @Test
    public void testGetInvalidByte_BigEndian() {
        assertArrayEquals(BaseType.BYTE.getInvalid(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0xFF });
    }

    @Test
    public void testGetInvalidByte_LittleEndian() {
        assertArrayEquals(BaseType.BYTE.getInvalid(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0xFF });
    }

}
