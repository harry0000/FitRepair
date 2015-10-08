package com.harry0000.fit.field;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.junit.Test;

import com.harry0000.fit.field.FieldDefinition;
import com.harry0000.fit.field.Float32Field;
import com.harry0000.fit.vo.BaseType;

public class Float32FieldTest {

    private static final FieldDefinition FIELD_DEF = new FieldDefinition((byte) 0, BaseType.FLOAT32);
    private final Float32Field field = new Float32Field(FIELD_DEF);

    @Test
    public void setValueFieldIsNotInvalid() {
        field.setValue(1.0F);
        assertThat(field.isInvalid(), is(false));
    }

    @Test
    public void notSetValueFieldIsInvalid() {
        assertThat(field.isInvalid(), is(true));
    }

    @Test
    public void setNullValueFieldIsInvalid() {
        final Float value = null;
        field.setValue(value);
        assertThat(field.isInvalid(), is(true));
    }

    @Test
    public void setInvalidValueFieldIsInvalid() {
        final float invalid = ByteBuffer.wrap(
                                  field.getBaseType().getInvalidValue(ByteOrder.BIG_ENDIAN)
                              ).getFloat();
        field.setValue(invalid);
        assertThat(field.isInvalid(), is(true));
    }

}
