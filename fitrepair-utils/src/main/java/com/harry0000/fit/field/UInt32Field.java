package com.harry0000.fit.field;

import java.math.BigDecimal;
import java.nio.ByteBuffer;

import com.harry0000.fit.vo.BaseType;

public class UInt32Field extends NumberField<Long> {

    /**
     * @param fieldDefinition
     */
    UInt32Field(final FieldDefinition fieldDefinition) {
        super(fieldDefinition);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#getBaseType()
     */
    @Override
    public BaseType getBaseType() {
        return BaseType.UINT32;
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#addValue(java.lang.Number)
     */
    @Override
    public void addValue(final Number value) {
        addValue(value != null ? Integer.toUnsignedLong(value.intValue()) : null);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#setValue(int, java.lang.Number)
     */
    @Override
    public void setValue(final int index, final Number value) {
        if (index < 0 || index >= getValues().size()) {
            return;
        }

        setValue(index, value != null ? Integer.toUnsignedLong(value.intValue()) : null);
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
    protected Long convertValue(final ByteBuffer value) {
        return Integer.toUnsignedLong(value.getInt());
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.NumberField#convertValue(java.math.BigDecimal)
     */
    @Override
    protected Long convertValue(final BigDecimal value) {
        return Integer.toUnsignedLong(value.intValue());
    }

}
