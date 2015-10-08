package com.harry0000.fit.field;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.junit.Test;

import com.harry0000.fit.field.FieldDefinition;
import com.harry0000.fit.field.SInt32Field;
import com.harry0000.fit.vo.BaseType;

public class SInt32FieldTest {

    private static final FieldDefinition FIELD_DEF = new FieldDefinition((byte) 0, BaseType.SINT32);
    private final SInt32Field field = new SInt32Field(FIELD_DEF);

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
        final int invalid = ByteBuffer.wrap(
                                field.getBaseType().getInvalidValue(ByteOrder.BIG_ENDIAN)
                            ).getInt();
        field.setValue(invalid);
        assertThat(field.isInvalid(), is(true));
    }

}
