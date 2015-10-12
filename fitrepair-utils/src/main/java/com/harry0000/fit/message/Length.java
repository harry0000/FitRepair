package com.harry0000.fit.message;

import static com.harry0000.fit.Constants.FIELD_MESSAGE_INDEX;

import com.harry0000.fit.field.Field;
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
        final Number value = getFieldToNumber(FIELD_MESSAGE_INDEX);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param messageIndex
     */
    public void setMessageIndex(final Integer messageIndex) {
        final Field<?> f = getOrAddField(FIELD_MESSAGE_INDEX, BaseType.UINT16);
        f.setValue(messageIndex);
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
    public Long getStartTime() {
        return getFieldToUnixTime(Fields.START_TIME);
    }

    /**
     * @param startTime
     */
    public void setStartTime(final Long startTime) {
        final Field<?> f = getOrAddField(Fields.START_TIME);
        f.setValue(toFitTimestamp(startTime));
    }

    /**
     * @return
     */
    public Long getTotalElapsedTime() {
        final Number value = getFieldToNumber(Fields.TOTAL_ELAPSED_TIME);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param totalElapsedTime
     */
    public void setTotalElapsedTime(final Long totalElapsedTime) {
        final Field<?> f = getOrAddField(Fields.TOTAL_ELAPSED_TIME);
        f.setValue(totalElapsedTime);
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
    public Integer getTotalStrokes() {
        final Number value = getFieldToNumber(Fields.TOTAL_STROKES);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param totalStrokes
     */
    public void setTotalStrokes(final Integer totalStrokes) {
        final Field<?> f = getOrAddField(Fields.TOTAL_STROKES);
        f.setValue(totalStrokes);
    }

    /**
     * @return
     */
    public Integer getAvgSpeed() {
        final Number value = getFieldToNumber(Fields.AVG_SPEED);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgSpeed
     */
    public void setAvgSpeed(final Integer avgSpeed) {
        final Field<?> f = getOrAddField(Fields.AVG_SPEED);
        f.setValue(avgSpeed);
    }

    /**
     * @return
     */
    public Integer getSwimStroke() {
        final Number value = getFieldToNumber(Fields.SWIM_STROKE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param swimStroke
     */
    public void setSwimStroke(final Integer swimStroke) {
        final Field<?> f = getOrAddField(Fields.SWIM_STROKE);
        f.setValue(swimStroke);
    }

    /**
     * @return
     */
    public Integer getAvgSwimmingCadence() {
        final Number value = getFieldToNumber(Fields.AVG_SWIMMING_CADENCE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgSwimmingCadence
     */
    public void setAvgSwimmingCadence(final Integer avgSwimmingCadence) {
        final Field<?> f = getOrAddField(Fields.AVG_SWIMMING_CADENCE);
        f.setValue(avgSwimmingCadence);
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

    /**
     * @return
     */
    public Integer getTotalCalories() {
        final Number value = getFieldToNumber(Fields.TOTAL_CALORIES);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param totalCalories
     */
    public void setTotalCalories(final Integer totalCalories) {
        final Field<?> f = getOrAddField(Fields.TOTAL_CALORIES);
        f.setValue(totalCalories);
    }

    /**
     * @return
     */
    public Integer getLengthType() {
        final Number value = getFieldToNumber(Fields.LENGTH_TYPE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param lengthType
     */
    public void setLengthType(final Integer lengthType) {
        final Field<?> f = getOrAddField(Fields.LENGTH_TYPE);
        f.setValue(lengthType);
    }

    /**
     * @return
     */
    public Integer getPlayerScore() {
        final Number value = getFieldToNumber(Fields.PLAYER_SCORE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param playerScore
     */
    public void setPlayerScore(final Integer playerScore) {
        final Field<?> f = getOrAddField(Fields.PLAYER_SCORE);
        f.setValue(playerScore);
    }

    /**
     * @return
     */
    public Integer getOpponentScore() {
        final Number value = getFieldToNumber(Fields.OPPONENT_SCORE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param opponentScore
     */
    public void setOpponentScore(final Integer opponentScore) {
        final Field<?> f = getOrAddField(Fields.OPPONENT_SCORE);
        f.setValue(opponentScore);
    }

    /**
     * @return
     */
    public Integer getStrokeCount() {
        final Number value = getFieldToNumber(Fields.STROKE_COUNT);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param strokeCount
     */
    public void setStrokeCount(final Integer strokeCount) {
        final Field<?> f = getOrAddField(Fields.STROKE_COUNT);
        f.setValue(strokeCount);
    }

    /**
     * @return
     */
    public Integer getZoneCount() {
        final Number value = getFieldToNumber(Fields.ZONE_COUNT);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param zoneCount
     */
    public void setZoneCount(final Integer zoneCount) {
        final Field<?> f = getOrAddField(Fields.ZONE_COUNT);
        f.setValue(zoneCount);
    }

}
