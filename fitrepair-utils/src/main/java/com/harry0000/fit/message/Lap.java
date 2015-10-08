package com.harry0000.fit.message;

import static com.harry0000.fit.Constants.FIELD_MESSAGE_INDEX;

import com.harry0000.fit.field.Field;
import com.harry0000.fit.vo.BaseType;
import com.harry0000.fit.vo.FitMessage;

public class Lap extends DataMessage {

    private enum Fields implements FieldProfile {
        EVENT                           (0,   BaseType.ENUM),
        EVENT_TYPE                      (1,   BaseType.ENUM),
        START_TIME                      (2,   BaseType.UINT32),
        START_POSITION_LAT              (3,   BaseType.SINT32),
        START_POSITION_LONG             (4,   BaseType.SINT32),
        END_POSITION_LAT                (5,   BaseType.SINT32),
        END_POSITION_LONG               (6,   BaseType.SINT32),
        TOTAL_ELAPSED_TIME              (7,   BaseType.UINT32),
        TOTAL_TIMER_TIME                (8,   BaseType.UINT32),
        TOTAL_DISTANCE                  (9,   BaseType.UINT32),
        TOTAL_CYCLES                    (10,  BaseType.UINT32),
        TOTAL_CALORIES                  (11,  BaseType.UINT16),
        TOTAL_FAT_CALORIES              (12,  BaseType.UINT16),
        AVG_SPEED                       (13,  BaseType.UINT16),
        MAX_SPEED                       (14,  BaseType.UINT16),
        AVG_HEART_RATE                  (15,  BaseType.UINT8),
        MAX_HEART_RATE                  (16,  BaseType.UINT8),
        AVG_CADENCE                     (17,  BaseType.UINT8),
        MAX_CADENCE                     (18,  BaseType.UINT8),
        AVG_POWER                       (19,  BaseType.UINT16),
        MAX_POWER                       (20,  BaseType.UINT16),
        TOTAL_ASCENT                    (21,  BaseType.UINT16),
        TOTAL_DESCENT                   (22,  BaseType.UINT16),
        INTENSITY                       (23,  BaseType.ENUM),
        LAP_TRIGGER                     (24,  BaseType.ENUM),
        SPORT                           (25,  BaseType.ENUM),
        EVENT_GROUP                     (26,  BaseType.UINT8),
        NUM_LENGTHS                     (32,  BaseType.UINT16),
        NORMALIZED_POWER                (33,  BaseType.UINT16),
        LEFT_RIGHT_BALANCE              (34,  BaseType.UINT16),
        FIRST_LENGTH_INDEX              (35,  BaseType.UINT16),
        AVG_STROKE_DISTANCE             (37,  BaseType.UINT16),
        SWIM_STROKE                     (38,  BaseType.ENUM),
        SUB_SPORT                       (39,  BaseType.ENUM),
        NUM_ACTIVE_LENGTHS              (40,  BaseType.UINT16),
        TOTAL_WORK                      (41,  BaseType.UINT32),
        AVG_ALTITUDE                    (42,  BaseType.UINT16),
        MAX_ALTITUDE                    (43,  BaseType.UINT16),
        GPS_ACCURACY                    (44,  BaseType.UINT8),
        AVG_GRADE                       (45,  BaseType.SINT16),
        AVG_POS_GRADE                   (46,  BaseType.SINT16),
        AVG_NEG_GRADE                   (47,  BaseType.SINT16),
        MAX_POS_GRADE                   (48,  BaseType.SINT16),
        MAX_NEG_GRADE                   (49,  BaseType.SINT16),
        AVG_TEMPERATURE                 (50,  BaseType.SINT8),
        MAX_TEMPERATURE                 (51,  BaseType.SINT8),
        TOTAL_MOVING_TIME               (52,  BaseType.UINT32),
        AVG_POS_VERTICAL_SPEED          (53,  BaseType.SINT16),
        AVG_NEG_VERTICAL_SPEED          (54,  BaseType.SINT16),
        MAX_POS_VERTICAL_SPEED          (55,  BaseType.SINT16),
        MAX_NEG_VERTICAL_SPEED          (56,  BaseType.SINT16),
        TIME_IN_HR_ZONE                 (57,  BaseType.UINT32),
        TIME_IN_SPEED_ZONE              (58,  BaseType.UINT32),
        TIME_IN_CADENCE_ZONE            (59,  BaseType.UINT32),
        TIME_IN_POWER_ZONE              (60,  BaseType.UINT32),
        REPETITION_NUM                  (61,  BaseType.UINT16),
        MIN_ALTITUDE                    (62,  BaseType.UINT16),
        MIN_HEART_RATE                  (63,  BaseType.UINT8),
        WKT_STEP_INDEX                  (71,  BaseType.UINT16),
        OPPONENT_SCORE                  (74,  BaseType.UINT16),
        STROKE_COUNT                    (75,  BaseType.UINT16),
        ZONE_COUNT                      (76,  BaseType.UINT16),
        AVG_VERTICAL_OSCILLATION        (77,  BaseType.UINT16),
        AVG_STANCE_TIME_PERCENT         (78,  BaseType.UINT16),
        AVG_STANCE_TIME                 (79,  BaseType.UINT16),
        AVG_FRACTIONAL_CADENCE          (80,  BaseType.UINT8),
        MAX_FRACTIONAL_CADENCE          (81,  BaseType.UINT8),
        TOTAL_FRACTIONAL_CYCLES         (82,  BaseType.UINT8),
        PLAYER_SCORE                    (83,  BaseType.UINT16),
        AVG_TOTAL_HEMOGLOBIN_CONC       (84,  BaseType.UINT16),
        MIN_TOTAL_HEMOGLOBIN_CONC       (85,  BaseType.UINT16),
        MAX_TOTAL_HEMOGLOBIN_CONC       (86,  BaseType.UINT16),
        AVG_SATURATED_HEMOGLOBIN_PERCENT(87,  BaseType.UINT16),
        MIN_SATURATED_HEMOGLOBIN_PERCENT(88,  BaseType.UINT16),
        MAX_SATURATED_HEMOGLOBIN_PERCENT(89,  BaseType.UINT16),
        AVG_LEFT_TORQUE_EFFECTIVENESS   (91,  BaseType.UINT8),
        AVG_RIGHT_TORQUE_EFFECTIVENESS  (92,  BaseType.UINT8),
        AVG_LEFT_PEDAL_SMOOTHNESS       (93,  BaseType.UINT8),
        AVG_RIGHT_PEDAL_SMOOTHNESS      (94,  BaseType.UINT8),
        AVG_COMBINED_PEDAL_SMOOTHNESS   (95,  BaseType.UINT8),
        TIME_STANDING                   (98,  BaseType.UINT32),
        STAND_COUNT                     (99,  BaseType.UINT16),
        AVG_LEFT_PCO                    (100, BaseType.SINT8),
        AVG_RIGHT_PCO                   (101, BaseType.SINT8),
        AVG_LEFT_POWER_PHASE            (102, BaseType.UINT8),
        AVG_LEFT_POWER_PHASE_PEAK       (103, BaseType.UINT8),
        AVG_RIGHT_POWER_PHASE           (104, BaseType.UINT8),
        AVG_RIGHT_POWER_PHASE_PEAK      (105, BaseType.UINT8),
        AVG_POWER_POSITION              (106, BaseType.UINT16),
        MAX_POWER_POSITION              (107, BaseType.UINT16),
        AVG_CADENCE_POSITION            (108, BaseType.UINT8),
        MAX_CADENCE_POSITION            (109, BaseType.UINT8),
        ENHANCED_AVG_SPEED              (110, BaseType.UINT32),
        ENHANCED_MAX_SPEED              (111, BaseType.UINT32),
        ENHANCED_AVG_ALTITUDE           (112, BaseType.UINT32),
        ENHANCED_MIN_ALTITUDE           (113, BaseType.UINT32),
        ENHANCED_MAX_ALTITUDE           (114, BaseType.UINT32),
        AVG_LEV_MOTOR_POWER             (115, BaseType.UINT16),
        MAX_LEV_MOTOR_POWER             (116, BaseType.UINT16),
        LEV_BATTERY_CONSUMPTION         (117, BaseType.UINT8);

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
    public Lap(final DataMessage msg) {
        super(msg);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.message.DataMessage#getGlobalFitMessage()
     */
    @Override
    public FitMessage getFitMessage() {
        return FitMessage.LAP;
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
    public Integer getStartPositionLat() {
        final Number value = getFieldToNumber(Fields.START_POSITION_LAT);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param startPositionLat
     */
    public void setStartPositionLat(final Integer startPositionLat) {
        final Field<?> f = getOrAddField(Fields.START_POSITION_LAT);
        f.setValue(startPositionLat);
    }

    /**
     * @return
     */
    public Integer getStartPositionLong() {
        final Number value = getFieldToNumber(Fields.START_POSITION_LONG);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param startPositionLong
     */
    public void setStartPositionLong(final Integer startPositionLong) {
        final Field<?> f = getOrAddField(Fields.START_POSITION_LONG);
        f.setValue(startPositionLong);
    }

    /**
     * @return
     */
    public Integer getEndPositionLat() {
        final Number value = getFieldToNumber(Fields.END_POSITION_LAT);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param endPositionLat
     */
    public void setEndPositionLat(final Integer endPositionLat) {
        final Field<?> f = getOrAddField(Fields.END_POSITION_LAT);
        f.setValue(endPositionLat);
    }

    /**
     * @return
     */
    public Integer getEndPositionLong() {
        final Number value = getFieldToNumber(Fields.END_POSITION_LONG);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param endPositionLong
     */
    public void setEndPositionLong(final Integer endPositionLong) {
        final Field<?> f = getOrAddField(Fields.END_POSITION_LONG);
        f.setValue(endPositionLong);
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
    public Long getTotalDistance() {
        final Number value = getFieldToNumber(Fields.TOTAL_DISTANCE);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param totalDistance
     */
    public void setTotalDistance(final Long totalDistance) {
        final Field<?> f = getOrAddField(Fields.TOTAL_DISTANCE);
        f.setValue(totalDistance);
    }

    /**
     * @return
     */
    public Long getTotalCycles() {
        final Number value = getFieldToNumber(Fields.TOTAL_CYCLES);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param totalCycles
     */
    public void setTotalCycles(final Long totalCycles) {
        final Field<?> f = getOrAddField(Fields.TOTAL_CYCLES);
        f.setValue(totalCycles);
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
    public Integer getTotalFatCalories() {
        final Number value = getFieldToNumber(Fields.TOTAL_FAT_CALORIES);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param totalFatCalories
     */
    public void setTotalFatCalories(final Integer totalFatCalories) {
        final Field<?> f = getOrAddField(Fields.TOTAL_FAT_CALORIES);
        f.setValue(totalFatCalories);
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
    public Integer getMaxSpeed() {
        final Number value = getFieldToNumber(Fields.MAX_SPEED);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param maxSpeed
     */
    public void setMaxSpeed(final Integer maxSpeed) {
        final Field<?> f = getOrAddField(Fields.MAX_SPEED);
        f.setValue(maxSpeed);
    }

    /**
     * @return
     */
    public Integer getAvgHeartRate() {
        final Number value = getFieldToNumber(Fields.AVG_HEART_RATE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgHeartRate
     */
    public void setAvgHeartRate(final Integer avgHeartRate) {
        final Field<?> f = getOrAddField(Fields.AVG_HEART_RATE);
        f.setValue(avgHeartRate);
    }

    /**
     * @return
     */
    public Integer getMaxHeartRate() {
        final Number value = getFieldToNumber(Fields.MAX_HEART_RATE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param maxHeartRate
     */
    public void setMaxHeartRate(final Integer maxHeartRate) {
        final Field<?> f = getOrAddField(Fields.MAX_HEART_RATE);
        f.setValue(maxHeartRate);
    }

    /**
     * @return
     */
    public Integer getAvgCadence() {
        final Number value = getFieldToNumber(Fields.AVG_CADENCE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgCadence
     */
    public void setAvgCadence(final Integer avgCadence) {
        final Field<?> f = getOrAddField(Fields.AVG_CADENCE);
        f.setValue(avgCadence);
    }

    /**
     * @return
     */
    public Integer getMaxCadence() {
        final Number value = getFieldToNumber(Fields.MAX_CADENCE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param maxCadence
     */
    public void setMaxCadence(final Integer maxCadence) {
        final Field<?> f = getOrAddField(Fields.MAX_CADENCE);
        f.setValue(maxCadence);
    }

    /**
     * @return
     */
    public Integer getAvgPower() {
        final Number value = getFieldToNumber(Fields.AVG_POWER);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgPower
     */
    public void setAvgPower(final Integer avgPower) {
        final Field<?> f = getOrAddField(Fields.AVG_POWER);
        f.setValue(avgPower);
    }

    /**
     * @return
     */
    public Integer getMaxPower() {
        final Number value = getFieldToNumber(Fields.MAX_POWER);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param maxPower
     */
    public void setMaxPower(final Integer maxPower) {
        final Field<?> f = getOrAddField(Fields.MAX_POWER);
        f.setValue(maxPower);
    }

    /**
     * @return
     */
    public Integer getTotalAscent() {
        final Number value = getFieldToNumber(Fields.TOTAL_ASCENT);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param totalAscent
     */
    public void setTotalAscent(final Integer totalAscent) {
        final Field<?> f = getOrAddField(Fields.TOTAL_ASCENT);
        f.setValue(totalAscent);
    }

    /**
     * @return
     */
    public Integer getTotalDescent() {
        final Number value = getFieldToNumber(Fields.TOTAL_DESCENT);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param totalDescent
     */
    public void setTotalDescent(final Integer totalDescent) {
        final Field<?> f = getOrAddField(Fields.TOTAL_DESCENT);
        f.setValue(totalDescent);
    }

    /**
     * @return
     */
    public Integer getIntensity() {
        final Number value = getFieldToNumber(Fields.INTENSITY);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param intensity
     */
    public void setIntensity(final Integer intensity) {
        final Field<?> f = getOrAddField(Fields.INTENSITY);
        f.setValue(intensity);
    }

    /**
     * @return
     */
    public Integer getLapTrigger() {
        final Number value = getFieldToNumber(Fields.LAP_TRIGGER);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param lapTrigger
     */
    public void setLapTrigger(final Integer lapTrigger) {
        final Field<?> f = getOrAddField(Fields.LAP_TRIGGER);
        f.setValue(lapTrigger);
    }

    /**
     * @return
     */
    public Integer getSport() {
        final Number value = getFieldToNumber(Fields.SPORT);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param sport
     */
    public void setSport(final Integer sport) {
        final Field<?> f = getOrAddField(Fields.SPORT);
        f.setValue(sport);
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
    public Integer getNumLengths() {
        final Number value = getFieldToNumber(Fields.NUM_LENGTHS);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param numLengths
     */
    public void setNumLengths(final Integer numLengths) {
        final Field<?> f = getOrAddField(Fields.NUM_LENGTHS);
        f.setValue(numLengths);
    }

    /**
     * @return
     */
    public Integer getNormalizedPower() {
        final Number value = getFieldToNumber(Fields.NORMALIZED_POWER);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param normalizedPower
     */
    public void setNormalizedPower(final Integer normalizedPower) {
        final Field<?> f = getOrAddField(Fields.NORMALIZED_POWER);
        f.setValue(normalizedPower);
    }

    /**
     * @return
     */
    public Integer getLeftRightBalance() {
        final Number value = getFieldToNumber(Fields.LEFT_RIGHT_BALANCE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param leftRightBalance
     */
    public void setLeftRightBalance(final Integer leftRightBalance) {
        final Field<?> f = getOrAddField(Fields.LEFT_RIGHT_BALANCE);
        f.setValue(leftRightBalance);
    }

    /**
     * @return
     */
    public Integer getFirstLengthIndex() {
        final Number value = getFieldToNumber(Fields.FIRST_LENGTH_INDEX);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param firstLengthIndex
     */
    public void setFirstLengthIndex(final Integer firstLengthIndex) {
        final Field<?> f = getOrAddField(Fields.FIRST_LENGTH_INDEX);
        f.setValue(firstLengthIndex);
    }

    /**
     * @return
     */
    public Integer getAvgStrokeDistance() {
        final Number value = getFieldToNumber(Fields.AVG_STROKE_DISTANCE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgStrokeDistance
     */
    public void setAvgStrokeDistance(final Integer avgStrokeDistance) {
        final Field<?> f = getOrAddField(Fields.AVG_STROKE_DISTANCE);
        f.setValue(avgStrokeDistance);
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
    public Integer getSubSport() {
        final Number value = getFieldToNumber(Fields.SUB_SPORT);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param subSport
     */
    public void setSubSport(final Integer subSport) {
        final Field<?> f = getOrAddField(Fields.SUB_SPORT);
        f.setValue(subSport);
    }

    /**
     * @return
     */
    public Integer getNumActiveLengths() {
        final Number value = getFieldToNumber(Fields.NUM_ACTIVE_LENGTHS);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param numActiveLengths
     */
    public void setNumActiveLengths(final Integer numActiveLengths) {
        final Field<?> f = getOrAddField(Fields.NUM_ACTIVE_LENGTHS);
        f.setValue(numActiveLengths);
    }

    /**
     * @return
     */
    public Long getTotalWork() {
        final Number value = getFieldToNumber(Fields.TOTAL_WORK);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param totalWork
     */
    public void setTotalWork(final Long totalWork) {
        final Field<?> f = getOrAddField(Fields.TOTAL_WORK);
        f.setValue(totalWork);
    }

    /**
     * @return
     */
    public Integer getAvgAltitude() {
        final Number value = getFieldToNumber(Fields.AVG_ALTITUDE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgAltitude
     */
    public void setAvgAltitude(final Integer avgAltitude) {
        final Field<?> f = getOrAddField(Fields.AVG_ALTITUDE);
        f.setValue(avgAltitude);
    }

    /**
     * @return
     */
    public Integer getMaxAltitude() {
        final Number value = getFieldToNumber(Fields.MAX_ALTITUDE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param maxAltitude
     */
    public void setMaxAltitude(final Integer maxAltitude) {
        final Field<?> f = getOrAddField(Fields.MAX_ALTITUDE);
        f.setValue(maxAltitude);
    }

    /**
     * @return
     */
    public Integer getGpsAccuracy() {
        final Number value = getFieldToNumber(Fields.GPS_ACCURACY);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param gpsAccuracy
     */
    public void setGpsAccuracy(final Integer gpsAccuracy) {
        final Field<?> f = getOrAddField(Fields.GPS_ACCURACY);
        f.setValue(gpsAccuracy);
    }

    /**
     * @return
     */
    public Short getAvgGrade() {
        final Number value = getFieldToNumber(Fields.AVG_GRADE);

        return value != null ? value.shortValue() : null;
    }

    /**
     * @param avgGrade
     */
    public void setAvgGrade(final Short avgGrade) {
        final Field<?> f = getOrAddField(Fields.AVG_GRADE);
        f.setValue(avgGrade);
    }

    /**
     * @return
     */
    public Short getAvgPosGrade() {
        final Number value = getFieldToNumber(Fields.AVG_POS_GRADE);

        return value != null ? value.shortValue() : null;
    }

    /**
     * @param avgPosGrade
     */
    public void setAvgPosGrade(final Short avgPosGrade) {
        final Field<?> f = getOrAddField(Fields.AVG_POS_GRADE);
        f.setValue(avgPosGrade);
    }

    /**
     * @return
     */
    public Short getAvgNegGrade() {
        final Number value = getFieldToNumber(Fields.AVG_NEG_GRADE);

        return value != null ? value.shortValue() : null;
    }

    /**
     * @param avgNegGrade
     */
    public void setAvgNegGrade(final Short avgNegGrade) {
        final Field<?> f = getOrAddField(Fields.AVG_NEG_GRADE);
        f.setValue(avgNegGrade);
    }

    /**
     * @return
     */
    public Short getMaxPosGrade() {
        final Number value = getFieldToNumber(Fields.MAX_POS_GRADE);

        return value != null ? value.shortValue() : null;
    }

    /**
     * @param maxPosGrade
     */
    public void setMaxPosGrade(final Short maxPosGrade) {
        final Field<?> f = getOrAddField(Fields.MAX_POS_GRADE);
        f.setValue(maxPosGrade);
    }

    /**
     * @return
     */
    public Short getMaxNegGrade() {
        final Number value = getFieldToNumber(Fields.MAX_NEG_GRADE);

        return value != null ? value.shortValue() : null;
    }

    /**
     * @param maxNegGrade
     */
    public void setMaxNegGrade(final Short maxNegGrade) {
        final Field<?> f = getOrAddField(Fields.MAX_NEG_GRADE);
        f.setValue(maxNegGrade);
    }

    /**
     * @return
     */
    public Byte getAvgTemperature() {
        final Number value = getFieldToNumber(Fields.AVG_TEMPERATURE);

        return value != null ? value.byteValue() : null;
    }

    /**
     * @param avgTemperature
     */
    public void setAvgTemperature(final Byte avgTemperature) {
        final Field<?> f = getOrAddField(Fields.AVG_TEMPERATURE);
        f.setValue(avgTemperature);
    }

    /**
     * @return
     */
    public Byte getMaxTemperature() {
        final Number value = getFieldToNumber(Fields.MAX_TEMPERATURE);

        return value != null ? value.byteValue() : null;
    }

    /**
     * @param maxTemperature
     */
    public void setMaxTemperature(final Byte maxTemperature) {
        final Field<?> f = getOrAddField(Fields.MAX_TEMPERATURE);
        f.setValue(maxTemperature);
    }

    /**
     * @return
     */
    public Long getTotalMovingTime() {
        final Number value = getFieldToNumber(Fields.TOTAL_MOVING_TIME);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param totalMovingTime
     */
    public void setTotalMovingTime(final Long totalMovingTime) {
        final Field<?> f = getOrAddField(Fields.TOTAL_MOVING_TIME);
        f.setValue(totalMovingTime);
    }

    /**
     * @return
     */
    public Short getAvgPosVerticalSpeed() {
        final Number value = getFieldToNumber(Fields.AVG_POS_VERTICAL_SPEED);

        return value != null ? value.shortValue() : null;
    }

    /**
     * @param avgPosVerticalSpeed
     */
    public void setAvgPosVerticalSpeed(final Short avgPosVerticalSpeed) {
        final Field<?> f = getOrAddField(Fields.AVG_POS_VERTICAL_SPEED);
        f.setValue(avgPosVerticalSpeed);
    }

    /**
     * @return
     */
    public Short getAvgNegVerticalSpeed() {
        final Number value = getFieldToNumber(Fields.AVG_NEG_VERTICAL_SPEED);

        return value != null ? value.shortValue() : null;
    }

    /**
     * @param avgNegVerticalSpeed
     */
    public void setAvgNegVerticalSpeed(final Short avgNegVerticalSpeed) {
        final Field<?> f = getOrAddField(Fields.AVG_NEG_VERTICAL_SPEED);
        f.setValue(avgNegVerticalSpeed);
    }

    /**
     * @return
     */
    public Short getMaxPosVerticalSpeed() {
        final Number value = getFieldToNumber(Fields.MAX_POS_VERTICAL_SPEED);

        return value != null ? value.shortValue() : null;
    }

    /**
     * @param maxPosVerticalSpeed
     */
    public void setMaxPosVerticalSpeed(final Short maxPosVerticalSpeed) {
        final Field<?> f = getOrAddField(Fields.MAX_POS_VERTICAL_SPEED);
        f.setValue(maxPosVerticalSpeed);
    }

    /**
     * @return
     */
    public Short getMaxNegVerticalSpeed() {
        final Number value = getFieldToNumber(Fields.MAX_NEG_VERTICAL_SPEED);

        return value != null ? value.shortValue() : null;
    }

    /**
     * @param maxNegVerticalSpeed
     */
    public void setMaxNegVerticalSpeed(final Short maxNegVerticalSpeed) {
        final Field<?> f = getOrAddField(Fields.MAX_NEG_VERTICAL_SPEED);
        f.setValue(maxNegVerticalSpeed);
    }

    /**
     * @return
     */
    public Long getTimeInHrZone() {
        final Number value = getFieldToNumber(Fields.TIME_IN_HR_ZONE);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param timeInHrZone
     */
    public void setTimeInHrZone(final Long timeInHrZone) {
        final Field<?> f = getOrAddField(Fields.TIME_IN_HR_ZONE);
        f.setValue(timeInHrZone);
    }

    /**
     * @return
     */
    public Long getTimeInSpeedZone() {
        final Number value = getFieldToNumber(Fields.TIME_IN_SPEED_ZONE);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param timeInSpeedZone
     */
    public void setTimeInSpeedZone(final Long timeInSpeedZone) {
        final Field<?> f = getOrAddField(Fields.TIME_IN_SPEED_ZONE);
        f.setValue(timeInSpeedZone);
    }

    /**
     * @return
     */
    public Long getTimeInCadenceZone() {
        final Number value = getFieldToNumber(Fields.TIME_IN_CADENCE_ZONE);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param timeInCadenceZone
     */
    public void setTimeInCadenceZone(final Long timeInCadenceZone) {
        final Field<?> f = getOrAddField(Fields.TIME_IN_CADENCE_ZONE);
        f.setValue(timeInCadenceZone);
    }

    /**
     * @return
     */
    public Long getTimeInPowerZone() {
        final Number value = getFieldToNumber(Fields.TIME_IN_POWER_ZONE);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param timeInPowerZone
     */
    public void setTimeInPowerZone(final Long timeInPowerZone) {
        final Field<?> f = getOrAddField(Fields.TIME_IN_POWER_ZONE);
        f.setValue(timeInPowerZone);
    }

    /**
     * @return
     */
    public Integer getRepetitionNum() {
        final Number value = getFieldToNumber(Fields.REPETITION_NUM);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param repetitionNum
     */
    public void setRepetitionNum(final Integer repetitionNum) {
        final Field<?> f = getOrAddField(Fields.REPETITION_NUM);
        f.setValue(repetitionNum);
    }

    /**
     * @return
     */
    public Integer getMinAltitude() {
        final Number value = getFieldToNumber(Fields.MIN_ALTITUDE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param minAltitude
     */
    public void setMinAltitude(final Integer minAltitude) {
        final Field<?> f = getOrAddField(Fields.MIN_ALTITUDE);
        f.setValue(minAltitude);
    }

    /**
     * @return
     */
    public Integer getMinHeartRate() {
        final Number value = getFieldToNumber(Fields.MIN_HEART_RATE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param minHeartRate
     */
    public void setMinHeartRate(final Integer minHeartRate) {
        final Field<?> f = getOrAddField(Fields.MIN_HEART_RATE);
        f.setValue(minHeartRate);
    }

    /**
     * @return
     */
    public Integer getWktStepIndex() {
        final Number value = getFieldToNumber(Fields.WKT_STEP_INDEX);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param wktStepIndex
     */
    public void setWktStepIndex(final Integer wktStepIndex) {
        final Field<?> f = getOrAddField(Fields.WKT_STEP_INDEX);
        f.setValue(wktStepIndex);
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

    /**
     * @return
     */
    public Integer getAvgVerticalOscillation() {
        final Number value = getFieldToNumber(Fields.AVG_VERTICAL_OSCILLATION);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgVerticalOscillation
     */
    public void setAvgVerticalOscillation(final Integer avgVerticalOscillation) {
        final Field<?> f = getOrAddField(Fields.AVG_VERTICAL_OSCILLATION);
        f.setValue(avgVerticalOscillation);
    }

    /**
     * @return
     */
    public Integer getAvgStanceTimePercent() {
        final Number value = getFieldToNumber(Fields.AVG_STANCE_TIME_PERCENT);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgStanceTimePercent
     */
    public void setAvgStanceTimePercent(final Integer avgStanceTimePercent) {
        final Field<?> f = getOrAddField(Fields.AVG_STANCE_TIME_PERCENT);
        f.setValue(avgStanceTimePercent);
    }

    /**
     * @return
     */
    public Integer getAvgStanceTime() {
        final Number value = getFieldToNumber(Fields.AVG_STANCE_TIME);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgStanceTime
     */
    public void setAvgStanceTime(final Integer avgStanceTime) {
        final Field<?> f = getOrAddField(Fields.AVG_STANCE_TIME);
        f.setValue(avgStanceTime);
    }

    /**
     * @return
     */
    public Integer getAvgFractionalCadence() {
        final Number value = getFieldToNumber(Fields.AVG_FRACTIONAL_CADENCE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgFractionalCadence
     */
    public void setAvgFractionalCadence(final Integer avgFractionalCadence) {
        final Field<?> f = getOrAddField(Fields.AVG_FRACTIONAL_CADENCE);
        f.setValue(avgFractionalCadence);
    }

    /**
     * @return
     */
    public Integer getMaxFractionalCadence() {
        final Number value = getFieldToNumber(Fields.MAX_FRACTIONAL_CADENCE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param maxFractionalCadence
     */
    public void setMaxFractionalCadence(final Integer maxFractionalCadence) {
        final Field<?> f = getOrAddField(Fields.MAX_FRACTIONAL_CADENCE);
        f.setValue(maxFractionalCadence);
    }

    /**
     * @return
     */
    public Integer getTotalFractionalCycles() {
        final Number value = getFieldToNumber(Fields.TOTAL_FRACTIONAL_CYCLES);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param totalFractionalCycles
     */
    public void setTotalFractionalCycles(final Integer totalFractionalCycles) {
        final Field<?> f = getOrAddField(Fields.TOTAL_FRACTIONAL_CYCLES);
        f.setValue(totalFractionalCycles);
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
    public Integer getAvgTotalHemoglobinConc() {
        final Number value = getFieldToNumber(Fields.AVG_TOTAL_HEMOGLOBIN_CONC);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgTotalHemoglobinConc
     */
    public void setAvgTotalHemoglobinConc(final Integer avgTotalHemoglobinConc) {
        final Field<?> f = getOrAddField(Fields.AVG_TOTAL_HEMOGLOBIN_CONC);
        f.setValue(avgTotalHemoglobinConc);
    }

    /**
     * @return
     */
    public Integer getMinTotalHemoglobinConc() {
        final Number value = getFieldToNumber(Fields.MIN_TOTAL_HEMOGLOBIN_CONC);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param minTotalHemoglobinConc
     */
    public void setMinTotalHemoglobinConc(final Integer minTotalHemoglobinConc) {
        final Field<?> f = getOrAddField(Fields.MIN_TOTAL_HEMOGLOBIN_CONC);
        f.setValue(minTotalHemoglobinConc);
    }

    /**
     * @return
     */
    public Integer getMaxTotalHemoglobinConc() {
        final Number value = getFieldToNumber(Fields.MAX_TOTAL_HEMOGLOBIN_CONC);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param maxTotalHemoglobinConc
     */
    public void setMaxTotalHemoglobinConc(final Integer maxTotalHemoglobinConc) {
        final Field<?> f = getOrAddField(Fields.MAX_TOTAL_HEMOGLOBIN_CONC);
        f.setValue(maxTotalHemoglobinConc);
    }

    /**
     * @return
     */
    public Integer getAvgSaturatedHemoglobinPercent() {
        final Number value = getFieldToNumber(Fields.AVG_SATURATED_HEMOGLOBIN_PERCENT);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgSaturatedHemoglobinPercent
     */
    public void setAvgSaturatedHemoglobinPercent(final Integer avgSaturatedHemoglobinPercent) {
        final Field<?> f = getOrAddField(Fields.AVG_SATURATED_HEMOGLOBIN_PERCENT);
        f.setValue(avgSaturatedHemoglobinPercent);
    }

    /**
     * @return
     */
    public Integer getMinSaturatedHemoglobinPercent() {
        final Number value = getFieldToNumber(Fields.MIN_SATURATED_HEMOGLOBIN_PERCENT);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param minSaturatedHemoglobinPercent
     */
    public void setMinSaturatedHemoglobinPercent(final Integer minSaturatedHemoglobinPercent) {
        final Field<?> f = getOrAddField(Fields.MIN_SATURATED_HEMOGLOBIN_PERCENT);
        f.setValue(minSaturatedHemoglobinPercent);
    }

    /**
     * @return
     */
    public Integer getMaxSaturatedHemoglobinPercent() {
        final Number value = getFieldToNumber(Fields.MAX_SATURATED_HEMOGLOBIN_PERCENT);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param maxSaturatedHemoglobinPercent
     */
    public void setMaxSaturatedHemoglobinPercent(final Integer maxSaturatedHemoglobinPercent) {
        final Field<?> f = getOrAddField(Fields.MAX_SATURATED_HEMOGLOBIN_PERCENT);
        f.setValue(maxSaturatedHemoglobinPercent);
    }

    /**
     * @return
     */
    public Integer getAvgLeftTorqueEffectiveness() {
        final Number value = getFieldToNumber(Fields.AVG_LEFT_TORQUE_EFFECTIVENESS);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgLeftTorqueEffectiveness
     */
    public void setAvgLeftTorqueEffectiveness(final Integer avgLeftTorqueEffectiveness) {
        final Field<?> f = getOrAddField(Fields.AVG_LEFT_TORQUE_EFFECTIVENESS);
        f.setValue(avgLeftTorqueEffectiveness);
    }

    /**
     * @return
     */
    public Integer getAvgRightTorqueEffectiveness() {
        final Number value = getFieldToNumber(Fields.AVG_RIGHT_TORQUE_EFFECTIVENESS);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgRightTorqueEffectiveness
     */
    public void setAvgRightTorqueEffectiveness(final Integer avgRightTorqueEffectiveness) {
        final Field<?> f = getOrAddField(Fields.AVG_RIGHT_TORQUE_EFFECTIVENESS);
        f.setValue(avgRightTorqueEffectiveness);
    }

    /**
     * @return
     */
    public Integer getAvgLeftPedalSmoothness() {
        final Number value = getFieldToNumber(Fields.AVG_LEFT_PEDAL_SMOOTHNESS);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgLeftPedalSmoothness
     */
    public void setAvgLeftPedalSmoothness(final Integer avgLeftPedalSmoothness) {
        final Field<?> f = getOrAddField(Fields.AVG_LEFT_PEDAL_SMOOTHNESS);
        f.setValue(avgLeftPedalSmoothness);
    }

    /**
     * @return
     */
    public Integer getAvgRightPedalSmoothness() {
        final Number value = getFieldToNumber(Fields.AVG_RIGHT_PEDAL_SMOOTHNESS);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgRightPedalSmoothness
     */
    public void setAvgRightPedalSmoothness(final Integer avgRightPedalSmoothness) {
        final Field<?> f = getOrAddField(Fields.AVG_RIGHT_PEDAL_SMOOTHNESS);
        f.setValue(avgRightPedalSmoothness);
    }

    /**
     * @return
     */
    public Integer getAvgCombinedPedalSmoothness() {
        final Number value = getFieldToNumber(Fields.AVG_COMBINED_PEDAL_SMOOTHNESS);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgCombinedPedalSmoothness
     */
    public void setAvgCombinedPedalSmoothness(final Integer avgCombinedPedalSmoothness) {
        final Field<?> f = getOrAddField(Fields.AVG_COMBINED_PEDAL_SMOOTHNESS);
        f.setValue(avgCombinedPedalSmoothness);
    }

    /**
     * @return
     */
    public Long getTimeStanding() {
        final Number value = getFieldToNumber(Fields.TIME_STANDING);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param timeStanding
     */
    public void setTimeStanding(final Long timeStanding) {
        final Field<?> f = getOrAddField(Fields.TIME_STANDING);
        f.setValue(timeStanding);
    }

    /**
     * @return
     */
    public Integer getStandCount() {
        final Number value = getFieldToNumber(Fields.STAND_COUNT);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param standCount
     */
    public void setStandCount(final Integer standCount) {
        final Field<?> f = getOrAddField(Fields.STAND_COUNT);
        f.setValue(standCount);
    }

    /**
     * @return
     */
    public Byte getAvgLeftPco() {
        final Number value = getFieldToNumber(Fields.AVG_LEFT_PCO);

        return value != null ? value.byteValue() : null;
    }

    /**
     * @param avgLeftPco
     */
    public void setAvgLeftPco(final Byte avgLeftPco) {
        final Field<?> f = getOrAddField(Fields.AVG_LEFT_PCO);
        f.setValue(avgLeftPco);
    }

    /**
     * @return
     */
    public Byte getAvgRightPco() {
        final Number value = getFieldToNumber(Fields.AVG_RIGHT_PCO);

        return value != null ? value.byteValue() : null;
    }

    /**
     * @param avgRightPco
     */
    public void setAvgRightPco(final Byte avgRightPco) {
        final Field<?> f = getOrAddField(Fields.AVG_RIGHT_PCO);
        f.setValue(avgRightPco);
    }

    /**
     * @return
     */
    public Integer getAvgLeftPowerPhase() {
        final Number value = getFieldToNumber(Fields.AVG_LEFT_POWER_PHASE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgLeftPowerPhase
     */
    public void setAvgLeftPowerPhase(final Integer avgLeftPowerPhase) {
        final Field<?> f = getOrAddField(Fields.AVG_LEFT_POWER_PHASE);
        f.setValue(avgLeftPowerPhase);
    }

    /**
     * @return
     */
    public Integer getAvgLeftPowerPhasePeak() {
        final Number value = getFieldToNumber(Fields.AVG_LEFT_POWER_PHASE_PEAK);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgLeftPowerPhasePeak
     */
    public void setAvgLeftPowerPhasePeak(final Integer avgLeftPowerPhasePeak) {
        final Field<?> f = getOrAddField(Fields.AVG_LEFT_POWER_PHASE_PEAK);
        f.setValue(avgLeftPowerPhasePeak);
    }

    /**
     * @return
     */
    public Integer getAvgRightPowerPhase() {
        final Number value = getFieldToNumber(Fields.AVG_RIGHT_POWER_PHASE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgRightPowerPhase
     */
    public void setAvgRightPowerPhase(final Integer avgRightPowerPhase) {
        final Field<?> f = getOrAddField(Fields.AVG_RIGHT_POWER_PHASE);
        f.setValue(avgRightPowerPhase);
    }

    /**
     * @return
     */
    public Integer getAvgRightPowerPhasePeak() {
        final Number value = getFieldToNumber(Fields.AVG_RIGHT_POWER_PHASE_PEAK);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgRightPowerPhasePeak
     */
    public void setAvgRightPowerPhasePeak(final Integer avgRightPowerPhasePeak) {
        final Field<?> f = getOrAddField(Fields.AVG_RIGHT_POWER_PHASE_PEAK);
        f.setValue(avgRightPowerPhasePeak);
    }

    /**
     * @return
     */
    public Integer getAvgPowerPosition() {
        final Number value = getFieldToNumber(Fields.AVG_POWER_POSITION);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgPowerPosition
     */
    public void setAvgPowerPosition(final Integer avgPowerPosition) {
        final Field<?> f = getOrAddField(Fields.AVG_POWER_POSITION);
        f.setValue(avgPowerPosition);
    }

    /**
     * @return
     */
    public Integer getMaxPowerPosition() {
        final Number value = getFieldToNumber(Fields.MAX_POWER_POSITION);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param maxPowerPosition
     */
    public void setMaxPowerPosition(final Integer maxPowerPosition) {
        final Field<?> f = getOrAddField(Fields.MAX_POWER_POSITION);
        f.setValue(maxPowerPosition);
    }

    /**
     * @return
     */
    public Integer getAvgCadencePosition() {
        final Number value = getFieldToNumber(Fields.AVG_CADENCE_POSITION);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgCadencePosition
     */
    public void setAvgCadencePosition(final Integer avgCadencePosition) {
        final Field<?> f = getOrAddField(Fields.AVG_CADENCE_POSITION);
        f.setValue(avgCadencePosition);
    }

    /**
     * @return
     */
    public Integer getMaxCadencePosition() {
        final Number value = getFieldToNumber(Fields.MAX_CADENCE_POSITION);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param maxCadencePosition
     */
    public void setMaxCadencePosition(final Integer maxCadencePosition) {
        final Field<?> f = getOrAddField(Fields.MAX_CADENCE_POSITION);
        f.setValue(maxCadencePosition);
    }

    /**
     * @return
     */
    public Long getEnhancedAvgSpeed() {
        final Number value = getFieldToNumber(Fields.ENHANCED_AVG_SPEED);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param enhancedAvgSpeed
     */
    public void setEnhancedAvgSpeed(final Long enhancedAvgSpeed) {
        final Field<?> f = getOrAddField(Fields.ENHANCED_AVG_SPEED);
        f.setValue(enhancedAvgSpeed);
    }

    /**
     * @return
     */
    public Long getEnhancedMaxSpeed() {
        final Number value = getFieldToNumber(Fields.ENHANCED_MAX_SPEED);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param enhancedMaxSpeed
     */
    public void setEnhancedMaxSpeed(final Long enhancedMaxSpeed) {
        final Field<?> f = getOrAddField(Fields.ENHANCED_MAX_SPEED);
        f.setValue(enhancedMaxSpeed);
    }

    /**
     * @return
     */
    public Long getEnhancedAvgAltitude() {
        final Number value = getFieldToNumber(Fields.ENHANCED_AVG_ALTITUDE);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param enhancedAvgAltitude
     */
    public void setEnhancedAvgAltitude(final Long enhancedAvgAltitude) {
        final Field<?> f = getOrAddField(Fields.ENHANCED_AVG_ALTITUDE);
        f.setValue(enhancedAvgAltitude);
    }

    /**
     * @return
     */
    public Long getEnhancedMinAltitude() {
        final Number value = getFieldToNumber(Fields.ENHANCED_MIN_ALTITUDE);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param enhancedMinAltitude
     */
    public void setEnhancedMinAltitude(final Long enhancedMinAltitude) {
        final Field<?> f = getOrAddField(Fields.ENHANCED_MIN_ALTITUDE);
        f.setValue(enhancedMinAltitude);
    }

    /**
     * @return
     */
    public Long getEnhancedMaxAltitude() {
        final Number value = getFieldToNumber(Fields.ENHANCED_MAX_ALTITUDE);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param enhancedMaxAltitude
     */
    public void setEnhancedMaxAltitude(final Long enhancedMaxAltitude) {
        final Field<?> f = getOrAddField(Fields.ENHANCED_MAX_ALTITUDE);
        f.setValue(enhancedMaxAltitude);
    }

    /**
     * @return
     */
    public Integer getAvgLevMotorPower() {
        final Number value = getFieldToNumber(Fields.AVG_LEV_MOTOR_POWER);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param avgLevMotorPower
     */
    public void setAvgLevMotorPower(final Integer avgLevMotorPower) {
        final Field<?> f = getOrAddField(Fields.AVG_LEV_MOTOR_POWER);
        f.setValue(avgLevMotorPower);
    }

    /**
     * @return
     */
    public Integer getMaxLevMotorPower() {
        final Number value = getFieldToNumber(Fields.MAX_LEV_MOTOR_POWER);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param maxLevMotorPower
     */
    public void setMaxLevMotorPower(final Integer maxLevMotorPower) {
        final Field<?> f = getOrAddField(Fields.MAX_LEV_MOTOR_POWER);
        f.setValue(maxLevMotorPower);
    }

    /**
     * @return
     */
    public Integer getLevBatteryConsumption() {
        final Number value = getFieldToNumber(Fields.LEV_BATTERY_CONSUMPTION);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param levBatteryConsumption
     */
    public void setLevBatteryConsumption(final Integer levBatteryConsumption) {
        final Field<?> f = getOrAddField(Fields.LEV_BATTERY_CONSUMPTION);
        f.setValue(levBatteryConsumption);
    }

}
