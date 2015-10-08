package com.harry0000.fit.field;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.junit.Test;

import com.harry0000.fit.field.FieldDefinition;
import com.harry0000.fit.field.SInt8Field;
import com.harry0000.fit.vo.BaseType;

public class SInt8FieldTest {

    private static final FieldDefinition FIELD_DEF = new FieldDefinition((byte) 0, BaseType.SINT8);
    private final SInt8Field field = new SInt8Field(FIELD_DEF);

    @Test
    public void setValueFieldIsNotInvalid() {
        final Byte value = 1;
        field.setValue(value);
        assertThat(field.isInvalid(), is(false));
    }

    @Test
    public void notSetValueFieldIsInvalid() {
        assertThat(field.isInvalid(), is(true));
    }

    @Test
    public void setNullValueFieldIsInvalid() {
        final Byte value = null;
        field.setValue(value);
        assertThat(field.isInvalid(), is(true));
    }

    @Test
    public void setInvalidValueFieldIsInvalid() {
        final byte invalid = ByteBuffer.wrap(
                                 field.getBaseType().getInvalidValue(ByteOrder.BIG_ENDIAN)
                             ).get();
        field.setValue(invalid);
        assertThat(field.isInvalid(), is(true));
    }

}
