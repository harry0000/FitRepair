package com.harry0000.fit.message;

import com.harry0000.fit.field.Field;
import com.harry0000.fit.vo.BaseType;
import com.harry0000.fit.vo.FitMessage;

public class Activity extends DataMessage {

    public enum Fields implements FieldProfile {
        TOTAL_TIMER_TIME(0, BaseType.UINT32),
        NUM_SESSIONS    (1, BaseType.UINT16),
        ACTIVITY_TYPE   (2, BaseType.ENUM),
        EVENT           (3, BaseType.ENUM),
        EVENT_TYPE      (4, BaseType.ENUM),
        LOCAL_TIMESTAMP (5, BaseType.UINT32),
        EVENT_GROUP     (6, BaseType.UINT8);

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
    public Activity(final DataMessage msg) {
        super(msg);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.message.DataMessage#getGlobalFitMessage()
     */
    @Override
    public FitMessage getFitMessage() {
        return FitMessage.ACTIVITY;
    }

    /**
     * @return
     */
    public Long getTotalTimerTime() {
        final Number value = getFieldToNumber(Fields.TOTAL_TIMER_TIME);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param totalTimerTime
     */
    public void setTotalTimerTime(final Long totalTimerTime) {
        final Field<?> f = getOrAddField(Fields.TOTAL_TIMER_TIME);
        f.setValue(totalTimerTime);
    }

    /**
     * @return
     */
    public Integer getNumSessions() {
        final Number value = getFieldToNumber(Fields.NUM_SESSIONS);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param numSessions
     */
    public void setNumSessions(final Integer numSessions) {
        final Field<?> f = getOrAddField(Fields.NUM_SESSIONS);
        f.setValue(numSessions);
    }

    /**
     * @return
     */
    public Integer getActivityType() {
        final Number value = getFieldToNumber(Fields.ACTIVITY_TYPE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param activityType
     */
    public void setActivityType(final Integer activityType) {
        final Field<?> f = getOrAddField(Fields.ACTIVITY_TYPE);
        f.setValue(activityType);
    }

    /**
     * @return
     */
    public Integer getEvent() {
        final Number value = getFieldToNumber(Fields.EVENT);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param event
     */
    public void setEvent(final Integer event) {
        final Field<?> f = getOrAddField(Fields.EVENT);
        f.setValue(event);
    }

    /**
     * @return
     */
    public Integer getEventType() {
        final Number value = getFieldToNumber(Fields.EVENT_TYPE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param eventType
     */
    public void setEventType(final Integer eventType) {
        final Field<?> f = getOrAddField(Fields.EVENT_TYPE);
        f.setValue(eventType);
    }

    /**
     * @return
     */
    public Long getLocalTimestamp() {
        final Number value = getFieldToNumber(Fields.LOCAL_TIMESTAMP);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param localTimestamp
     */
    public void setLocalTimestamp(final Long localTimestamp) {
        final Field<?> f = getOrAddField(Fields.LOCAL_TIMESTAMP);
        f.setValue(localTimestamp);
    }

    /**
     * @return
     */
    public Integer getEventGroup() {
        final Number value = getFieldToNumber(Fields.EVENT_GROUP);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param eventGroup
     */
    public void setEventGroup(final Integer eventGroup) {
        final Field<?> f = getOrAddField(Fields.EVENT_GROUP);
        f.setValue(eventGroup);
    }

}
