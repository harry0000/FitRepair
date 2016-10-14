package com.harry0000.fit.message;

import static com.harry0000.fit.Constants.FIELD_MESSAGE_INDEX;

import com.harry0000.fit.vo.BaseType;
import com.harry0000.fit.vo.FitMessage;

public class Length extends DataMessage {

    public enum Fields implements FieldProfile {
        EVENT               (0,  BaseType.ENUM),
        EVENT_TYPE          (1,  BaseType.ENUM),
        START_TIME          (2,  BaseType.UINT32),
        TOTAL_ELAPSED_TIME  (3,  BaseType.UINT32),
        TOTAL_TIMER_TIME    (4,  BaseType.UINT32),
        TOTAL_STROKES       (5,  BaseType.UINT16),
        AVG_SPEED           (6,  BaseType.UINT16),
        SWIM_STROKE         (7,  BaseType.ENUM),
        AVG_SWIMMING_CADENCE(9,  BaseType.UINT8),
        EVENT_GROUP         (10, BaseType.UINT8),
        TOTAL_CALORIES      (11, BaseType.UINT16),
        LENGTH_TYPE         (12, BaseType.ENUM),
        PLAYER_SCORE        (18, BaseType.UINT16),
        OPPONENT_SCORE      (19, BaseType.UINT16),
        STROKE_COUNT        (20, BaseType.UINT16),
        ZONE_COUNT          (21, BaseType.UINT16);

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
    public Length(final DataMessage msg) {
        super(msg);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.message.DataMessage#getGlobalFitMessage()
     */
    @Override
    public FitMessage getFitMessage() {
        return FitMessage.LENGTH;
    }

    /**
     * @return
     */
    public Integer getMessageIndex() {
        return getFieldToNumber(FIELD_MESSAGE_INDEX).map(Number::intValue).orElse(null);
    }

    /**
     * @param messageIndex
     */
    public void setMessageIndex(final Integer messageIndex) {
        getOrAddField(FIELD_MESSAGE_INDEX, BaseType.UINT16).setValue(messageIndex);
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
    public Long getStartTime() {
        return getFieldToUnixTime(Fields.START_TIME).orElse(null);
    }

    /**
     * @param startTime
     */
    public void setStartTime(final Long startTime) {
        getOrAddField(Fields.START_TIME).setValue(toFitTimestamp(startTime).orElse(null));
    }

    /**
     * @return
     */
    public Long getTotalElapsedTime() {
        return getFieldToNumber(Fields.TOTAL_ELAPSED_TIME).map(Number::longValue).orElse(null);
    }

    /**
     * @param totalElapsedTime
     */
    public void setTotalElapsedTime(final Long totalElapsedTime) {
        getOrAddField(Fields.TOTAL_ELAPSED_TIME).setValue(totalElapsedTime);
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
    public Integer getTotalStrokes() {
        return getFieldToNumber(Fields.TOTAL_STROKES).map(Number::intValue).orElse(null);
    }

    /**
     * @param totalStrokes
     */
    public void setTotalStrokes(final Integer totalStrokes) {
        getOrAddField(Fields.TOTAL_STROKES).setValue(totalStrokes);
    }

    /**
     * @return
     */
    public Integer getAvgSpeed() {
        return getFieldToNumber(Fields.AVG_SPEED).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgSpeed
     */
    public void setAvgSpeed(final Integer avgSpeed) {
        getOrAddField(Fields.AVG_SPEED).setValue(avgSpeed);
    }

    /**
     * @return
     */
    public Integer getSwimStroke() {
        return getFieldToNumber(Fields.SWIM_STROKE).map(Number::intValue).orElse(null);
    }

    /**
     * @param swimStroke
     */
    public void setSwimStroke(final Integer swimStroke) {
        getOrAddField(Fields.SWIM_STROKE).setValue(swimStroke);
    }

    /**
     * @return
     */
    public Integer getAvgSwimmingCadence() {
        return getFieldToNumber(Fields.AVG_SWIMMING_CADENCE).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgSwimmingCadence
     */
    public void setAvgSwimmingCadence(final Integer avgSwimmingCadence) {
        getOrAddField(Fields.AVG_SWIMMING_CADENCE).setValue(avgSwimmingCadence);
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

    /**
     * @return
     */
    public Integer getTotalCalories() {
        return getFieldToNumber(Fields.TOTAL_CALORIES).map(Number::intValue).orElse(null);
    }

    /**
     * @param totalCalories
     */
    public void setTotalCalories(final Integer totalCalories) {
        getOrAddField(Fields.TOTAL_CALORIES).setValue(totalCalories);
    }

    /**
     * @return
     */
    public Integer getLengthType() {
        return getFieldToNumber(Fields.LENGTH_TYPE).map(Number::intValue).orElse(null);
    }

    /**
     * @param lengthType
     */
    public void setLengthType(final Integer lengthType) {
        getOrAddField(Fields.LENGTH_TYPE).setValue(lengthType);
    }

    /**
     * @return
     */
    public Integer getPlayerScore() {
        return getFieldToNumber(Fields.PLAYER_SCORE).map(Number::intValue).orElse(null);
    }

    /**
     * @param playerScore
     */
    public void setPlayerScore(final Integer playerScore) {
        getOrAddField(Fields.PLAYER_SCORE).setValue(playerScore);
    }

    /**
     * @return
     */
    public Integer getOpponentScore() {
        return getFieldToNumber(Fields.OPPONENT_SCORE).map(Number::intValue).orElse(null);
    }

    /**
     * @param opponentScore
     */
    public void setOpponentScore(final Integer opponentScore) {
        getOrAddField(Fields.OPPONENT_SCORE).setValue(opponentScore);
    }

    /**
     * @return
     */
    public Integer getStrokeCount() {
        return getFieldToNumber(Fields.STROKE_COUNT).map(Number::intValue).orElse(null);
    }

    /**
     * @param strokeCount
     */
    public void setStrokeCount(final Integer strokeCount) {
        getOrAddField(Fields.STROKE_COUNT).setValue(strokeCount);
    }

    /**
     * @return
     */
    public Integer getZoneCount() {
        return getFieldToNumber(Fields.ZONE_COUNT).map(Number::intValue).orElse(null);
    }

    /**
     * @param zoneCount
     */
    public void setZoneCount(final Integer zoneCount) {
        getOrAddField(Fields.ZONE_COUNT).setValue(zoneCount);
    }

}
