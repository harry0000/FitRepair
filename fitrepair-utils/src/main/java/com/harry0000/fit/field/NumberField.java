package com.harry0000.fit.field;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

abstract class NumberField<T extends Number> extends AbstractField<T> {

    /**
     * @param fieldDefinition
     */
    NumberField(final FieldDefinition fieldDefinition) {
        super(fieldDefinition);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#setValues(byte[], java.nio.ByteOrder)
     */
    @Override
    public void setValues(final byte[] values, final ByteOrder bo) {
        if (values == null) {
            setValue((Number) null);
            return;
        }

        final int length = getBaseType().getSize();
        final int size = values.length / length;

        getValues().clear();
        for (int i = 0; i < size; i++) {
            final ByteBuffer bb = ByteBuffer.wrap(values, i * length, length).order(bo);
            addValue(convertValue(bb));
        }
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#toNumber(int)
     */
    @Override
    public Number toNumber(final int index) {
        return getValue(index);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#toNumber()
     */
    @Override
    public Number toNumber() {
        return toNumber(0);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#toString(int)
     */
    @Override
    public String toString(final int index) {
        if (index < 0 || index >= getValues().size()) {
            return null;
        }

        final T v = getValue(index);
        return v != null ? v.toString() : null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return toString(0);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#setValue(int, java.lang.String)
     */
    @Override
    public void setValue(final int index, final String value) {
        if (index < 0 || index >= getValues().size()) {
            return;
        }

        if (value == null || value.length() == 0) {
            getValues().set(index, null);
            return;
        }

        try {
            getValues().set(index, convertValue(new BigDecimal(value)));
        } catch (final NumberFormatException e) {
        }
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#setValue(java.lang.String)
     */
    @Override
    public void setValue(final String value) {
        if (getValues().isEmpty()) {
            addValue(null);
        }
        setValue(0, value);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#isInvalid(int)
     */
    @Override
    public boolean isInvalid(final int index) {
        final T value = getValue(index);
        return value == null ||
               value.equals(convertValue(ByteBuffer.wrap(getBaseType().getInvalidValue(ByteOrder.BIG_ENDIAN))));
    }

    /**
     * @param value
     * @return
     */
    abstract protected T convertValue(final ByteBuffer value);

    /**
     * @param value
     * @return
     */
    abstract protected T convertValue(final BigDecimal value);

}
