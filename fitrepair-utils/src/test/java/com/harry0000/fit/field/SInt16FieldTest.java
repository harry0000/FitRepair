package com.harry0000.fit.field;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.harry0000.fit.field.FieldDefinition;
import com.harry0000.fit.field.SInt16Field;
import com.harry0000.fit.vo.BaseType;

public class SInt16FieldTest {

    private static final FieldDefinition FIELD_DEF = new FieldDefinition((byte) 0, BaseType.SINT16);
    private final SInt16Field field = new SInt16Field(FIELD_DEF);

    @Test
    public void setValueFieldIsNotInvalid() {
        final Short value = 1;
        field.setValue(value);
        assertThat(field.isInvalid(), is(false));
    }

    @Test
    public void notSetValueFieldIsInvalid() {
        assertThat(field.isInvalid(), is(true));
    }

    @Test
    public void setNullValueFieldIsInvalid() {
        final Short value = null;
        field.setValue(value);
        assertThat(field.isInvalid(), is(true));
    }

    @Test
    public void setInvalidValueFieldIsInvalid() {
        field.setValue(BaseType.INVALID_SINT16);
        assertThat(field.isInvalid(), is(true));
    }

}
