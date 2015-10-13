package com.harry0000.fit.field;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.harry0000.fit.field.EnumField;
import com.harry0000.fit.field.FieldDefinition;
import com.harry0000.fit.vo.BaseType;

public class EnumFieldTest {

    private static final FieldDefinition FIELD_DEF = new FieldDefinition((byte) 0, BaseType.ENUM);
    private final EnumField field = new EnumField(FIELD_DEF);

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
        field.setValue(BaseType.INVALID_ENUM);
        assertThat(field.isInvalid(), is(true));
    }

}
