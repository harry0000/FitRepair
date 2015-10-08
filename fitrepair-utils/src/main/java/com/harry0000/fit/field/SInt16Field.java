package com.harry0000.fit.field;

import java.math.BigDecimal;
import java.nio.ByteBuffer;

import com.harry0000.fit.vo.BaseType;

public class SInt16Field extends NumberField<Short> {

    /**
     * @param fieldDefinition
     */
    SInt16Field(final FieldDefinition fieldDefinition) {
        super(fieldDefinition);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.FieldBean#getBaseType()
     */
    @Override
    public BaseType getBaseType() {
        return BaseType.SINT16;
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#addValue(java.lang.Number)
     */
    @Override
    public void addValue(final Number value) {
        addValue(value != null ? value.shortValue() : null);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#setValue(int, java.lang.Number)
     */
    @Override
    public void setValue(final int index, final Number value) {
        if (index < 0 || index >= getValues().size()) {
            return;
        }

        setValue(index, value != null ? value.shortValue() : null);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#setValue(java.lang.Number)
     */
    @Override
    public void setValue(final Number value) {
        if (getValues().isEmpty()) {
            addValue(null);
        }
        setValue(0, value);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.NumberField#convertValue(java.nio.ByteBuffer)
     */
    @Override
    protected Short convertValue(final ByteBuffer value) {
        return value.getShort();
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.NumberField#convertValue(java.math.BigDecimal)
     */
    @Override
    protected Short convertValue(final BigDecimal value) {
        return value.shortValue();
    }

}
