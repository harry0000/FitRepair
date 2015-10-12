package com.harry0000.fit.message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.harry0000.fit.field.Field;
import com.harry0000.fit.vo.BaseType;
import com.harry0000.fit.vo.FitMessage;

public class Hrv extends DataMessage {

    public enum Fields implements FieldProfile {
        FIELD_TIME(0, BaseType.UINT16);

        private final byte definitionNumber;
        private final BaseType baseType;

        /**
         * @param definitionNumber
         * @param baseType
         */
        private Fields(final int definitionNumber,
                       final BaseType baseType) {
            this.definitionNumber = (byte) definitionNumber;
            this.baseType = baseType;
        }

        /* (non-Javadoc)
         * @see com.harry0000.Fit.message.FieldType#getDefinitionNumber()
         */
        @Override
        public byte getDefinitionNumber() {
            return definitionNumber;
        }

        /* (non-Javadoc)
         * @see com.harry0000.Fit.message.FieldType#getBaseType()
         */
        @Override
        public BaseType getBaseType() {
            return baseType;
        }
    }

    /**
     * @param msg
     */
    public Hrv(final DataMessage msg) {
        super(msg);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.message.DataMessage#getGlobalFitMessage()
     */
    @Override
    public FitMessage getFitMessage() {
        return FitMessage.HRV;
    }

    /**
     * @return
     */
    public Integer getTime() {
        final Number value = getFieldToNumber(Fields.FIELD_TIME);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param time
     */
    public void setTime(final Integer time) {
        final Field<?> f = getOrAddField(Fields.FIELD_TIME);
        f.setValue(time);
    }

    /**
     * @param index
     * @return
     */
    public Integer getTime(final int index) {
        final Field<?> field = getField(Fields.FIELD_TIME);
        if (field == null) {
            return null;
        }

        final Number value = field.toNumber(index);
        return value != null ? value.intValue() : null;
    }

    /**
     * @param index
     * @param time
     */
    public void setTime(final int index, final Integer time) {
        final Field<?> f = getOrAddField(Fields.FIELD_TIME);
        f.setValue(index, time);
    }

    /**
     * @return
     */
    public List<Integer> getTimes() {
        final Field<?> field = getField(Fields.FIELD_TIME);
        if (field == null) {
            return Collections.emptyList();
        }

        final int size = field.getValues().size();
        final List<Integer> times = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            final Number value = field.toNumber(i);
            times.add(value != null ? value.intValue() : null);
        }
        return times;
    }

    /**
     * @param times
     */
    public void setTimes(final List<Integer> times) {
        final Field<?> f = getOrAddField(Fields.FIELD_TIME);
        f.getValues().clear();

        for (final Integer time : times) {
            f.addValue(time);
        }
    }

}
