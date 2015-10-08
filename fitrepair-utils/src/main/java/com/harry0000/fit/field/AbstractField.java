package com.harry0000.fit.field;

import static com.harry0000.fit.Constants.FIELD_TIMESTAMP;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractField<T> implements Field<T> {

    private final FieldDefinition fieldDefinition;
    private List<T> values = new ArrayList<>();

    /**
     * @param fieldDefinition
     */
    AbstractField(final FieldDefinition fieldDefinition) {
        this.fieldDefinition = fieldDefinition;
    }

    /**
     * @return
     * @see com.harry0000.fit.field.FieldDefinition#getDefinitionNumber()
     */
    public byte getDefinitionNumber() {
        return fieldDefinition.getDefinitionNumber();
    }

    /**
     * @return
     * @see com.harry0000.fit.field.FieldDefinition#getSize()
     */
    public byte getSize() {
        return fieldDefinition.getSize();
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#getValues()
     */
    @Override
    public List<T> getValues() {
        return values;
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#setValues(java.util.List)
     */
    @Override
    public void setValues(final List<T> values) {
        this.values = values;
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#getValue(int)
     */
    @Override
    public T getValue(final int index) {
        if (index < 0 || index >= values.size()) {
            return null;
        }
        return values.get(index);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#getValue()
     */
    @Override
    public T getValue() {
        return getValue(0);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#addValue(java.lang.Object)
     */
    @Override
    public void addValue(final T value) {
        values.add(value);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#setValue(int, java.lang.Object)
     */
    @Override
    public void setValue(final int index, final T value) {
        if (index < 0 || index >= values.size()) {
            return;
        }
        values.set(index, value);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#setValue(java.lang.Object)
     */
    @Override
    public void setValue(final T value) {
        if (getValues().isEmpty()) {
            addValue((T) null);
        }
        setValue(0, value);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#isTimestamp()
     */
    @Override
    public boolean isTimestamp() {
        return getDefinitionNumber() == FIELD_TIMESTAMP;
    }

}
