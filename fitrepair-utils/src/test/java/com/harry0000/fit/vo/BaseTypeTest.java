package com.harry0000.fit.vo;

import static org.junit.Assert.*;

import java.nio.ByteOrder;
import org.junit.Test;

import com.harry0000.fit.vo.BaseType;

public class BaseTypeTest {

    @Test
    public void testGetInvalidValueEnum_BigEndian() {
        assertArrayEquals(BaseType.ENUM.getInvalidValue(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0xFF });
    }

    @Test
    public void testGetInvalidValueEnum_LittleEndian() {
        assertArrayEquals(BaseType.ENUM.getInvalidValue(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0xFF });
    }

    @Test
    public void testGetInvalidValueSInt8_BigEndian() {
        assertArrayEquals(BaseType.SINT8.getInvalidValue(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0x7F });
    }

    @Test
    public void testGetInvalidValueSInt8_LittleEndian() {
        assertArrayEquals(BaseType.SINT8.getInvalidValue(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0x7F });
    }

    @Test
    public void testGetInvalidValueUInt8_BigEndian() {
        assertArrayEquals(BaseType.UINT8.getInvalidValue(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0xFF });
    }

    @Test
    public void testGetInvalidValueUInt8_LittleEndian() {
        assertArrayEquals(BaseType.UINT8.getInvalidValue(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0xFF });
    }

    @Test
    public void testGetInvalidValueSInt16_BigEndian() {
        assertArrayEquals(BaseType.SINT16.getInvalidValue(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0x7F, (byte) 0xFF });
    }

    @Test
    public void testGetInvalidValueSInt16_LittleEndian() {
        assertArrayEquals(BaseType.SINT16.getInvalidValue(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0xFF, (byte) 0x7F });
    }

    @Test
    public void testGetInvalidValueUInt16_BigEndian() {
        assertArrayEquals(BaseType.UINT16.getInvalidValue(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0xFF, (byte) 0xFF });
    }

    @Test
    public void testGetInvalidValueUInt16_LittleEndian() {
        assertArrayEquals(BaseType.UINT16.getInvalidValue(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0xFF, (byte) 0xFF });
    }

    @Test
    public void testGetInvalidValueSInt32_BigEndian() {
        assertArrayEquals(BaseType.SINT32.getInvalidValue(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0x7F, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF });
    }

    @Test
    public void testGetInvalidValueSInt32_LittleEndian() {
        assertArrayEquals(BaseType.SINT32.getInvalidValue(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0x7F });
    }

    @Test
    public void testGetInvalidValueUInt32_BigEndian() {
        assertArrayEquals(BaseType.UINT32.getInvalidValue(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF });
    }

    @Test
    public void testGetInvalidValueUInt32_LittleEndian() {
        assertArrayEquals(BaseType.UINT32.getInvalidValue(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF });
    }

    @Test
    public void testGetInvalidValueString_BigEndian() {
        assertArrayEquals(BaseType.STRING.getInvalidValue(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0x00 });
    }

    @Test
    public void testGetInvalidValueString_LittleEndian() {
        assertArrayEquals(BaseType.STRING.getInvalidValue(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0x00 });
    }

    @Test
    public void testGetInvalidValueFloat32_BigEndian() {
        assertArrayEquals(BaseType.FLOAT32.getInvalidValue(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF });
    }

    @Test
    public void testGetInvalidValueFloat32_LittleEndian() {
        assertArrayEquals(BaseType.FLOAT32.getInvalidValue(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF });
    }

    @Test
    public void testGetInvalidValueFloat64_BigEndian() {
        assertArrayEquals(BaseType.FLOAT64.getInvalidValue(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF });
    }

    @Test
    public void testGetInvalidValueFloat64_LittleEndian() {
        assertArrayEquals(BaseType.FLOAT64.getInvalidValue(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF });
    }

    @Test
    public void testGetInvalidValueUInt8z_BigEndian() {
        assertArrayEquals(BaseType.UINT8Z.getInvalidValue(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0x00 });
    }

    @Test
    public void testGetInvalidValueUInt8z_LittleEndian() {
        assertArrayEquals(BaseType.UINT8Z.getInvalidValue(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0x00 });
    }

    @Test
    public void testGetInvalidValueUInt16z_BigEndian() {
        assertArrayEquals(BaseType.UINT16Z.getInvalidValue(ByteOrder.BIG_ENDIAN),    new byte[]{ (byte) 0x00, (byte) 0x00 });
    }

    @Test
    public void testGetInvalidValueUInt16z_LittleEndian() {
        assertArrayEquals(BaseType.UINT16Z.getInvalidValue(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0x00, (byte) 0x00 });
    }

    @Test
    public void testGetInvalidValueUInt32z_BigEndian() {
        assertArrayEquals(BaseType.UINT32Z.getInvalidValue(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00 });
    }

    @Test
    public void testGetInvalidValueUInt32z_LittleEndian() {
        assertArrayEquals(BaseType.UINT32Z.getInvalidValue(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00 });
    }

    @Test
    public void testGetInvalidValueByte_BigEndian() {
        assertArrayEquals(BaseType.BYTE.getInvalidValue(ByteOrder.BIG_ENDIAN), new byte[]{ (byte) 0xFF });
    }

    @Test
    public void testGetInvalidValueByte_LittleEndian() {
        assertArrayEquals(BaseType.BYTE.getInvalidValue(ByteOrder.LITTLE_ENDIAN), new byte[]{ (byte) 0xFF });
    }

}
