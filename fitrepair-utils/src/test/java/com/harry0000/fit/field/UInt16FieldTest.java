package com.harry0000.fit.field;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.junit.Test;

import com.harry0000.fit.field.FieldDefinition;
import com.harry0000.fit.field.UInt16Field;
import com.harry0000.fit.vo.BaseType;

public class UInt16FieldTest {

    private static final FieldDefinition FIELD_DEF = new FieldDefinition((byte) 0, BaseType.UINT16);
    private final UInt16Field field = new UInt16Field(FIELD_DEF);

    @Test
    public void setValueFieldIsNotInvalid() {
        field.setValue(1);
        assertThat(field.isInvalid(), is(false));
    }

    @Test
    public void notSetValueFieldIsInvalid() {
        assertThat(field.isInvalid(), is(true));
    }

    @Test
    public void setNullValueFieldIsInvalid() {
        final Integer value = null;
        field.setValue(value);
        assertThat(field.isInvalid(), is(true));
    }

    @Test
    public void setInvalidValueFieldIsInvalid() {
        final int invalid = Short.toUnsignedInt(
                                ByteBuffer.wrap(
                                    field.getBaseType().getInvalidValue(ByteOrder.BIG_ENDIAN)
                                ).getShort()
                            );
        field.setValue(invalid);
        assertThat(field.isInvalid(), is(true));
    }

}
