package com.harry0000.fit.field;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.harry0000.fit.field.FieldDefinition;
import com.harry0000.fit.field.StringField;
import com.harry0000.fit.vo.BaseType;

public class StringFieldTest {

    private final FieldDefinition definition = new FieldDefinition((byte) 0, BaseType.STRING);
    private final StringField field = new StringField(definition);

    @Test
    public void setNullThenReturnNull() {
        final String value = null;
        definition.setSize((byte) 8);

        field.setValue(value);

        assertThat(field.toString(), nullValue());
    }

    @Test
    public void setEmptyStringThenReturnInvalidValue() {
        final String value    = "";
        final String expected = "\0\0\0\0\0\0\0\0";
        definition.setSize((byte) expected.length());

        field.setValue(value);

        assertThat(field.toString(), is(expected));
    }

    @Test
    public void setAsciiStringLowerThanSizeThenNotTrimmed() {
        final String value    = "abcd";
        final String expected = "abcd\0\0\0\0";
        definition.setSize((byte) expected.length());

        field.setValue(value);

        assertThat(field.toString(), is(expected));
    }

    @Test
    public void setAsciiStringGreaterThanSizeThenTrimmed() {
        final String value    = "abcdefg";
        final String expected = "abc\0";
        definition.setSize((byte) expected.length());

        field.setValue(value);

        assertThat(field.toString(), is(expected));
    }

    @Test
    public void set3bytesStringLowerThanSizeThenNotTrimmed() {
        // 'あ' is 3bytes(0xE3, 0x81, 0x82)
        final String value    = "ああああ"; // 3 * 4 (= 12) bytes
        final String expected = "ああああ\0\0\0\0";
        definition.setSize((byte) (3 * 4 + 4)); // = 16 bytes

        field.setValue(value);

        assertThat(field.toString(), is(expected));
    }

    @Test
    public void set3bytesStringGreaterThanSizeThenTrimmed() {
        // 'あ' is 3bytes(0xE3, 0x81, 0x82)
        final String value    = "ああああ"; // 3 * 4 (= 12) bytes
        final String expected = "ああ\0\0";
        definition.setSize((byte) (3 * 2 + 2)); // = 8 bytes

        field.setValue(value);

        assertThat(field.toString(), is(expected));
    }

    @Test
    public void setInvalidStringThenReplaceCharacterTo_U_FFFD() {
        // 0xE080AF(1110 0000 1000 0000 1010 1111) is invalid bytes of U+002F('/')
        final byte[] bytes = new byte[]{(byte) 0xE0, (byte) 0x80, (byte) 0xAF};
        definition.setSize((byte) 10);

        field.setValues(bytes, null);

        assertThat(field.toString(), is("���\0"));
    }

    @Test
    public void setValueFieldIsNotInvalid() {
        final String value = "abc\0";
        definition.setSize((byte) value.length());

        field.setValue(value);

        assertThat(field.isInvalid(), is(false));
    }

    @Test
    public void notSetValueFieldIsInvalid() {
        assertThat(field.isInvalid(), is(true));
    }

    @Test
    public void setNullValueFieldIsInvalid() {
        final String value = null;

        field.setValue(value);

        assertThat(field.isInvalid(), is(true));
    }

    @Test
    public void setInvalidValueFieldIsInvalid() {
        field.setValue("\0");

        assertThat(field.isInvalid(), is(true));
    }

}
