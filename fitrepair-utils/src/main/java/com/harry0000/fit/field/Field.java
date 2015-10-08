package com.harry0000.fit.field;

import java.nio.ByteOrder;
import java.util.List;

import com.harry0000.fit.vo.BaseType;

public interface Field<T> {

    /**
     * @return
     */
    byte getDefinitionNumber();

    /**
     * @return
     */
    byte getSize();

    /**
     * @return
     */
    BaseType getBaseType();

    /**
     * @return
     */
    List<T> getValues();

    /**
     * @param values
     */
    void setValues(final List<T> values);

    /**
     * @param values
     * @param bo
     */
    void setValues(final byte[] values, final ByteOrder bo);

    /**
     * @param value
     */
    void addValue(final T value);

    /**
     * @param value
     */
    void addValue(final Number value);

    /**
     * @return
     */
    T getValue(final int index);

    /**
     * @return
     */
    T getValue();

    /**
     * @param index
     * @param value
     */
    void setValue(final int index, final T value);

    /**
     * @param value
     */
    void setValue(final T value);

    /**
     * @param index
     * @param value
     */
    void setValue(final int index, final Number value);

    /**
     * @param value
     */
    void setValue(final Number value);

    /**
     * @param index
     * @param value
     */
    void setValue(final int index, final String value);

    /**
     * @param value
     */
    void setValue(final String value);

    /**
     * @param index
     * @return
     */
    Number toNumber(final int index);

    /**
     * @return
     */
    Number toNumber();

    /**
     * @param index
     * @return
     */
    String toString(final int index);

    /**
     * @return
     */
    String toString();

    /**
     * @param index
     * @return
     */
    boolean isInvalid(final int index);

    /**
     * @return
     */
    default boolean isInvalid() {
        return isInvalid(0);
    };

    /**
     * @return
     */
    boolean isTimestamp();

}
