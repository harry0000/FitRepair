package com.harry0000.fit.field;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.junit.Test;

import com.harry0000.fit.field.FieldDefinition;
import com.harry0000.fit.field.UInt32zField;
import com.harry0000.fit.vo.BaseType;

public class UInt32zFieldTest {

    private static final FieldDefinition FIELD_DEF = new FieldDefinition((byte) 0, BaseType.UINT32Z);
    private final UInt32zField field = new UInt32zField(FIELD_DEF);

    @Test
    public void setValueFieldIsNotInvalid() {
        field.setValue(1L);
        assertThat(field.isInvalid(), is(false));
    }

    @Test
    public void notSetValueFieldIsInvalid() {
        assertThat(field.isInvalid(), is(true));
    }

    @Test
    public void setNullValueFieldIsInvalid() {
        final Long value = null;
        field.setValue(value);
        assertThat(field.isInvalid(), is(true));
    }

    @Test
    public void setInvalidValueFieldIsInvalid() {
        final long invalid = Integer.toUnsignedLong(
                                 ByteBuffer.wrap(
                                     field.getBaseType().getInvalidValue(ByteOrder.BIG_ENDIAN)
                                 ).getInt()
                             );
        field.setValue(invalid);
        assertThat(field.isInvalid(), is(true));
    }

}
