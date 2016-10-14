package com.harry0000.fit.message;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        return getFieldToNumber(Fields.FIELD_TIME).map(Number::intValue).orElse(null);
    }

    /**
     * @param time
     */
    public void setTime(final Integer time) {
        getOrAddField(Fields.FIELD_TIME).setValue(time);
    }

    /**
     * @param index
     * @return
     */
    public Integer getTime(final int index) {
        return getField(Fields.FIELD_TIME)
                .flatMap(f -> Optional.ofNullable(f.toNumber(index)))
                .map(Number::intValue)
                .orElse(null);
    }

    /**
     * @param index
     * @param time
     */
    public void setTime(final int index, final Integer time) {
        getOrAddField(Fields.FIELD_TIME).setValue(index, time);
    }

    /**
     * @return
     */
    public List<Integer> getTimes() {
        return getField(Fields.FIELD_TIME)
                .map(f ->
                    Stream.iterate(0, i -> i + 1)
                          .limit(f.getValues().size())
                          .map(i -> Optional.ofNullable(f.toNumber(i)).map(Number::intValue).orElseGet(null))
                          .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    /**
     * @param times
     */
    public void setTimes(final List<Integer> times) {
        final Field<?> f = getOrAddField(Fields.FIELD_TIME);
        f.getValues().clear();
        times.forEach(f::addValue);
    }

}
