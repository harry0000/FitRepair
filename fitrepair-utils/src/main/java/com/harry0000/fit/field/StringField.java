package com.harry0000.fit.field;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;

import com.harry0000.fit.vo.BaseType;

public class StringField extends AbstractField<String> {

    protected static final char EOS = '\0';

    /**
     * @param str
     * @param size
     * @return
     */
    protected static String adjustToSize(final String str, final int size) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty() || str.charAt(0) == 0) {
            return new String(new byte[size], UTF_8);
        }

        final ByteBuffer bb = ByteBuffer.allocate(size - 1);
        final CharBuffer cb = CharBuffer.allocate(size);
        str.getChars(0, Math.min(str.length(), size), cb.array(), 0);

        final CharsetEncoder ce = UTF_8.newEncoder();
        ce.reset()
          .onMalformedInput(CodingErrorAction.REPLACE)
          .onUnmappableCharacter(CodingErrorAction.REPLACE)
          .encode(cb, bb, true);
        ce.flush(bb);

        return new String(bb.array(), UTF_8) + EOS;
    }

    /**
     * @param fieldDefinition
     */
    StringField(final FieldDefinition fieldDefinition) {
        super(fieldDefinition);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#getBaseType()
     */
    @Override
    public BaseType getBaseType() {
        return BaseType.STRING;
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#setValues(byte[], java.nio.ByteOrder)
     */
    @Override
    public void setValues(final byte[] values, final ByteOrder bo) {
        if (values == null) {
            setValue((String) null);
            return;
        }

        setValue(adjustToSize(new String(values, UTF_8), getSize()));
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.AbstractField#addValue(java.lang.Object)
     */
    @Override
    public void addValue(final String value) {
        super.addValue(adjustToSize(value, getSize()));
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#addValue(java.lang.Number)
     */
    @Override
    public void addValue(final Number value) {
        addValue(value != null ? value.toString() : null);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#toNumber(int)
     */
    @Override
    public Number toNumber(int index) {
        return null;
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#toNumber()
     */
    @Override
    public Number toNumber() {
        return toNumber(0);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#setValue(int, java.lang.Number)
     */
    @Override
    public void setValue(final int index, final Number value) {
        setValue(index, value != null ? value.toString() : null);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#setValue(java.lang.Number)
     */
    @Override
    public void setValue(final Number value) {
        if (getValues().isEmpty()) {
            addValue((String) null);
        }
        setValue(0, value);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#toString(int)
     */
    @Override
    public String toString(final int index) {
        if (index < 0 || index >= getValues().size()) {
            return null;
        }
        return getValues().get(index);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return toString(0);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.AbstractField#setValue(int, java.lang.Object)
     */
    @Override
    public void setValue(final int index, final String value) {
        super.setValue(index, adjustToSize(value, getSize()));
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#setValue(java.lang.Object)
     */
    @Override
    public void setValue(final String value) {
        if (getValues().isEmpty()) {
            addValue((String) null);
        }
        setValue(0, value);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.field.Field#isInvalid(int)
     */
    @Override
    public boolean isInvalid(final int index) {
        final String value = getValue(index);

        return value == null || value.getBytes()[0] == 0;
    }

}
