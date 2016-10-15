package com.harry0000.fit.message;

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
        return getFieldToNumber(Fields.TOTAL_TIMER_TIME).map(Number::longValue).orElse(null);
    }

    /**
     * @param totalTimerTime
     */
    public void setTotalTimerTime(final Long totalTimerTime) {
        getOrAddField(Fields.TOTAL_TIMER_TIME).setValue(totalTimerTime);
    }

    /**
     * @return
     */
    public Integer getNumSessions() {
        return getFieldToNumber(Fields.NUM_SESSIONS).map(Number::intValue).orElse(null);
    }

    /**
     * @param numSessions
     */
    public void setNumSessions(final Integer numSessions) {
        getOrAddField(Fields.NUM_SESSIONS).setValue(numSessions);
    }

    /**
     * @return
     */
    public Integer getActivityType() {
        return getFieldToNumber(Fields.ACTIVITY_TYPE).map(Number::intValue).orElse(null);
    }

    /**
     * @param activityType
     */
    public void setActivityType(final Integer activityType) {
        getOrAddField(Fields.ACTIVITY_TYPE).setValue(activityType);
    }

    /**
     * @return
     */
    public Integer getEvent() {
        return getFieldToNumber(Fields.EVENT).map(Number::intValue).orElse(null);
    }

    /**
     * @param event
     */
    public void setEvent(final Integer event) {
        getOrAddField(Fields.EVENT).setValue(event);
    }

    /**
     * @return
     */
    public Integer getEventType() {
        return getFieldToNumber(Fields.EVENT_TYPE).map(Number::intValue).orElse(null);
    }

    /**
     * @param eventType
     */
    public void setEventType(final Integer eventType) {
        getOrAddField(Fields.EVENT_TYPE).setValue(eventType);
    }

    /**
     * @return
     */
    public Long getLocalTimestamp() {
        return getFieldToNumber(Fields.LOCAL_TIMESTAMP).map(Number::longValue).orElse(null);
    }

    /**
     * @param localTimestamp
     */
    public void setLocalTimestamp(final Long localTimestamp) {
        getOrAddField(Fields.LOCAL_TIMESTAMP).setValue(localTimestamp);
    }

    /**
     * @return
     */
    public Integer getEventGroup() {
        return getFieldToNumber(Fields.EVENT_GROUP).map(Number::intValue).orElse(null);
    }

    /**
     * @param eventGroup
     */
    public void setEventGroup(final Integer eventGroup) {
        getOrAddField(Fields.EVENT_GROUP).setValue(eventGroup);
    }

}
