package com.harry0000.fit.field;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.junit.Test;

import com.harry0000.fit.field.FieldDefinition;
import com.harry0000.fit.field.Float64Field;
import com.harry0000.fit.vo.BaseType;

public class Float64FieldTest {

    private static final FieldDefinition FIELD_DEF = new FieldDefinition((byte) 0, BaseType.FLOAT64);
    private final Float64Field field = new Float64Field(FIELD_DEF);

    @Test
    public void setValueFieldIsNotInvalid() {
        field.setValue(1.0D);
        assertThat(field.isInvalid(), is(false));
    }

    @Test
    public void notSetValueFieldIsInvalid() {
        assertThat(field.isInvalid(), is(true));
    }

    @Test
    public void setNullValueFieldIsInvalid() {
        final Double value = null;
        field.setValue(value);
        assertThat(field.isInvalid(), is(true));
    }

    @Test
    public void setInvalidValueFieldIsInvalid() {
        final double invalid = ByteBuffer.wrap(
                                   field.getBaseType().getInvalidValue(ByteOrder.BIG_ENDIAN)
                               ).getDouble();
        field.setValue(invalid);
        assertThat(field.isInvalid(), is(true));
    }

}
