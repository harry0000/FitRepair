package com.harry0000.fit.message;

import static com.harry0000.fit.Constants.FIELD_MESSAGE_INDEX;

import com.harry0000.fit.vo.BaseType;
import com.harry0000.fit.vo.FitMessage;

public class Lap extends DataMessage {

    public enum Fields implements FieldProfile {
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
    public Integer getStartPositionLat() {
        return getFieldToNumber(Fields.START_POSITION_LAT).map(Number::intValue).orElse(null);
    }

    /**
     * @param startPositionLat
     */
    public void setStartPositionLat(final Integer startPositionLat) {
        getOrAddField(Fields.START_POSITION_LAT).setValue(startPositionLat);
    }

    /**
     * @return
     */
    public Integer getStartPositionLong() {
        return getFieldToNumber(Fields.START_POSITION_LONG).map(Number::intValue).orElse(null);
    }

    /**
     * @param startPositionLong
     */
    public void setStartPositionLong(final Integer startPositionLong) {
        getOrAddField(Fields.START_POSITION_LONG).setValue(startPositionLong);
    }

    /**
     * @return
     */
    public Integer getEndPositionLat() {
        return getFieldToNumber(Fields.END_POSITION_LAT).map(Number::intValue).orElse(null);
    }

    /**
     * @param endPositionLat
     */
    public void setEndPositionLat(final Integer endPositionLat) {
        getOrAddField(Fields.END_POSITION_LAT).setValue(endPositionLat);
    }

    /**
     * @return
     */
    public Integer getEndPositionLong() {
        return getFieldToNumber(Fields.END_POSITION_LONG).map(Number::intValue).orElse(null);
    }

    /**
     * @param endPositionLong
     */
    public void setEndPositionLong(final Integer endPositionLong) {
        getOrAddField(Fields.END_POSITION_LONG).setValue(endPositionLong);
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
    public Long getTotalDistance() {
        return getFieldToNumber(Fields.TOTAL_DISTANCE).map(Number::longValue).orElse(null);
    }

    /**
     * @param totalDistance
     */
    public void setTotalDistance(final Long totalDistance) {
        getOrAddField(Fields.TOTAL_DISTANCE).setValue(totalDistance);
    }

    /**
     * @return
     */
    public Long getTotalCycles() {
        return getFieldToNumber(Fields.TOTAL_CYCLES).map(Number::longValue).orElse(null);
    }

    /**
     * @param totalCycles
     */
    public void setTotalCycles(final Long totalCycles) {
        getOrAddField(Fields.TOTAL_CYCLES).setValue(totalCycles);
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
    public Integer getTotalFatCalories() {
        return getFieldToNumber(Fields.TOTAL_FAT_CALORIES).map(Number::intValue).orElse(null);
    }

    /**
     * @param totalFatCalories
     */
    public void setTotalFatCalories(final Integer totalFatCalories) {
        getOrAddField(Fields.TOTAL_FAT_CALORIES).setValue(totalFatCalories);
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
    public Integer getMaxSpeed() {
        return getFieldToNumber(Fields.MAX_SPEED).map(Number::intValue).orElse(null);
    }

    /**
     * @param maxSpeed
     */
    public void setMaxSpeed(final Integer maxSpeed) {
        getOrAddField(Fields.MAX_SPEED).setValue(maxSpeed);
    }

    /**
     * @return
     */
    public Integer getAvgHeartRate() {
        return getFieldToNumber(Fields.AVG_HEART_RATE).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgHeartRate
     */
    public void setAvgHeartRate(final Integer avgHeartRate) {
        getOrAddField(Fields.AVG_HEART_RATE).setValue(avgHeartRate);
    }

    /**
     * @return
     */
    public Integer getMaxHeartRate() {
        return getFieldToNumber(Fields.MAX_HEART_RATE).map(Number::intValue).orElse(null);
    }

    /**
     * @param maxHeartRate
     */
    public void setMaxHeartRate(final Integer maxHeartRate) {
        getOrAddField(Fields.MAX_HEART_RATE).setValue(maxHeartRate);
    }

    /**
     * @return
     */
    public Integer getAvgCadence() {
        return getFieldToNumber(Fields.AVG_CADENCE).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgCadence
     */
    public void setAvgCadence(final Integer avgCadence) {
        getOrAddField(Fields.AVG_CADENCE).setValue(avgCadence);
    }

    /**
     * @return
     */
    public Integer getMaxCadence() {
        return getFieldToNumber(Fields.MAX_CADENCE).map(Number::intValue).orElse(null);
    }

    /**
     * @param maxCadence
     */
    public void setMaxCadence(final Integer maxCadence) {
        getOrAddField(Fields.MAX_CADENCE).setValue(maxCadence);
    }

    /**
     * @return
     */
    public Integer getAvgPower() {
        return getFieldToNumber(Fields.AVG_POWER).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgPower
     */
    public void setAvgPower(final Integer avgPower) {
        getOrAddField(Fields.AVG_POWER).setValue(avgPower);
    }

    /**
     * @return
     */
    public Integer getMaxPower() {
        return getFieldToNumber(Fields.MAX_POWER).map(Number::intValue).orElse(null);
    }

    /**
     * @param maxPower
     */
    public void setMaxPower(final Integer maxPower) {
        getOrAddField(Fields.MAX_POWER).setValue(maxPower);
    }

    /**
     * @return
     */
    public Integer getTotalAscent() {
        return getFieldToNumber(Fields.TOTAL_ASCENT).map(Number::intValue).orElse(null);
    }

    /**
     * @param totalAscent
     */
    public void setTotalAscent(final Integer totalAscent) {
        getOrAddField(Fields.TOTAL_ASCENT).setValue(totalAscent);
    }

    /**
     * @return
     */
    public Integer getTotalDescent() {
        return getFieldToNumber(Fields.TOTAL_DESCENT).map(Number::intValue).orElse(null);
    }

    /**
     * @param totalDescent
     */
    public void setTotalDescent(final Integer totalDescent) {
        getOrAddField(Fields.TOTAL_DESCENT).setValue(totalDescent);
    }

    /**
     * @return
     */
    public Integer getIntensity() {
        return getFieldToNumber(Fields.INTENSITY).map(Number::intValue).orElse(null);
    }

    /**
     * @param intensity
     */
    public void setIntensity(final Integer intensity) {
        getOrAddField(Fields.INTENSITY).setValue(intensity);
    }

    /**
     * @return
     */
    public Integer getLapTrigger() {
        return getFieldToNumber(Fields.LAP_TRIGGER).map(Number::intValue).orElse(null);
    }

    /**
     * @param lapTrigger
     */
    public void setLapTrigger(final Integer lapTrigger) {
        getOrAddField(Fields.LAP_TRIGGER).setValue(lapTrigger);
    }

    /**
     * @return
     */
    public Integer getSport() {
        return getFieldToNumber(Fields.SPORT).map(Number::intValue).orElse(null);
    }

    /**
     * @param sport
     */
    public void setSport(final Integer sport) {
        getOrAddField(Fields.SPORT).setValue(sport);
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
    public Integer getNumLengths() {
        return getFieldToNumber(Fields.NUM_LENGTHS).map(Number::intValue).orElse(null);
    }

    /**
     * @param numLengths
     */
    public void setNumLengths(final Integer numLengths) {
        getOrAddField(Fields.NUM_LENGTHS).setValue(numLengths);
    }

    /**
     * @return
     */
    public Integer getNormalizedPower() {
        return getFieldToNumber(Fields.NORMALIZED_POWER).map(Number::intValue).orElse(null);
    }

    /**
     * @param normalizedPower
     */
    public void setNormalizedPower(final Integer normalizedPower) {
        getOrAddField(Fields.NORMALIZED_POWER).setValue(normalizedPower);
    }

    /**
     * @return
     */
    public Integer getLeftRightBalance() {
        return getFieldToNumber(Fields.LEFT_RIGHT_BALANCE).map(Number::intValue).orElse(null);
    }

    /**
     * @param leftRightBalance
     */
    public void setLeftRightBalance(final Integer leftRightBalance) {
        getOrAddField(Fields.LEFT_RIGHT_BALANCE).setValue(leftRightBalance);
    }

    /**
     * @return
     */
    public Integer getFirstLengthIndex() {
        return getFieldToNumber(Fields.FIRST_LENGTH_INDEX).map(Number::intValue).orElse(null);
    }

    /**
     * @param firstLengthIndex
     */
    public void setFirstLengthIndex(final Integer firstLengthIndex) {
        getOrAddField(Fields.FIRST_LENGTH_INDEX).setValue(firstLengthIndex);
    }

    /**
     * @return
     */
    public Integer getAvgStrokeDistance() {
        return getFieldToNumber(Fields.AVG_STROKE_DISTANCE).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgStrokeDistance
     */
    public void setAvgStrokeDistance(final Integer avgStrokeDistance) {
        getOrAddField(Fields.AVG_STROKE_DISTANCE).setValue(avgStrokeDistance);
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
    public Integer getSubSport() {
        return getFieldToNumber(Fields.SUB_SPORT).map(Number::intValue).orElse(null);
    }

    /**
     * @param subSport
     */
    public void setSubSport(final Integer subSport) {
        getOrAddField(Fields.SUB_SPORT).setValue(subSport);
    }

    /**
     * @return
     */
    public Integer getNumActiveLengths() {
        return getFieldToNumber(Fields.NUM_ACTIVE_LENGTHS).map(Number::intValue).orElse(null);
    }

    /**
     * @param numActiveLengths
     */
    public void setNumActiveLengths(final Integer numActiveLengths) {
        getOrAddField(Fields.NUM_ACTIVE_LENGTHS).setValue(numActiveLengths);
    }

    /**
     * @return
     */
    public Long getTotalWork() {
        return getFieldToNumber(Fields.TOTAL_WORK).map(Number::longValue).orElse(null);
    }

    /**
     * @param totalWork
     */
    public void setTotalWork(final Long totalWork) {
        getOrAddField(Fields.TOTAL_WORK).setValue(totalWork);
    }

    /**
     * @return
     */
    public Integer getAvgAltitude() {
        return getFieldToNumber(Fields.AVG_ALTITUDE).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgAltitude
     */
    public void setAvgAltitude(final Integer avgAltitude) {
        getOrAddField(Fields.AVG_ALTITUDE).setValue(avgAltitude);
    }

    /**
     * @return
     */
    public Integer getMaxAltitude() {
        return getFieldToNumber(Fields.MAX_ALTITUDE).map(Number::intValue).orElse(null);
    }

    /**
     * @param maxAltitude
     */
    public void setMaxAltitude(final Integer maxAltitude) {
        getOrAddField(Fields.MAX_ALTITUDE).setValue(maxAltitude);
    }

    /**
     * @return
     */
    public Integer getGpsAccuracy() {
        return getFieldToNumber(Fields.GPS_ACCURACY).map(Number::intValue).orElse(null);
    }

    /**
     * @param gpsAccuracy
     */
    public void setGpsAccuracy(final Integer gpsAccuracy) {
        getOrAddField(Fields.GPS_ACCURACY).setValue(gpsAccuracy);
    }

    /**
     * @return
     */
    public Short getAvgGrade() {
        return getFieldToNumber(Fields.AVG_GRADE).map(Number::shortValue).orElse(null);
    }

    /**
     * @param avgGrade
     */
    public void setAvgGrade(final Short avgGrade) {
        getOrAddField(Fields.AVG_GRADE).setValue(avgGrade);
    }

    /**
     * @return
     */
    public Short getAvgPosGrade() {
        return getFieldToNumber(Fields.AVG_POS_GRADE).map(Number::shortValue).orElse(null);
    }

    /**
     * @param avgPosGrade
     */
    public void setAvgPosGrade(final Short avgPosGrade) {
        getOrAddField(Fields.AVG_POS_GRADE).setValue(avgPosGrade);
    }

    /**
     * @return
     */
    public Short getAvgNegGrade() {
        return getFieldToNumber(Fields.AVG_NEG_GRADE).map(Number::shortValue).orElse(null);
    }

    /**
     * @param avgNegGrade
     */
    public void setAvgNegGrade(final Short avgNegGrade) {
        getOrAddField(Fields.AVG_NEG_GRADE).setValue(avgNegGrade);
    }

    /**
     * @return
     */
    public Short getMaxPosGrade() {
        return getFieldToNumber(Fields.MAX_POS_GRADE).map(Number::shortValue).orElse(null);
    }

    /**
     * @param maxPosGrade
     */
    public void setMaxPosGrade(final Short maxPosGrade) {
        getOrAddField(Fields.MAX_POS_GRADE).setValue(maxPosGrade);
    }

    /**
     * @return
     */
    public Short getMaxNegGrade() {
        return getFieldToNumber(Fields.MAX_NEG_GRADE).map(Number::shortValue).orElse(null);
    }

    /**
     * @param maxNegGrade
     */
    public void setMaxNegGrade(final Short maxNegGrade) {
        getOrAddField(Fields.MAX_NEG_GRADE).setValue(maxNegGrade);
    }

    /**
     * @return
     */
    public Byte getAvgTemperature() {
        return getFieldToNumber(Fields.AVG_TEMPERATURE).map(Number::byteValue).orElse(null);
    }

    /**
     * @param avgTemperature
     */
    public void setAvgTemperature(final Byte avgTemperature) {
        getOrAddField(Fields.AVG_TEMPERATURE).setValue(avgTemperature);
    }

    /**
     * @return
     */
    public Byte getMaxTemperature() {
        return getFieldToNumber(Fields.MAX_TEMPERATURE).map(Number::byteValue).orElse(null);
    }

    /**
     * @param maxTemperature
     */
    public void setMaxTemperature(final Byte maxTemperature) {
        getOrAddField(Fields.MAX_TEMPERATURE).setValue(maxTemperature);
    }

    /**
     * @return
     */
    public Long getTotalMovingTime() {
        return getFieldToNumber(Fields.TOTAL_MOVING_TIME).map(Number::longValue).orElse(null);
    }

    /**
     * @param totalMovingTime
     */
    public void setTotalMovingTime(final Long totalMovingTime) {
        getOrAddField(Fields.TOTAL_MOVING_TIME).setValue(totalMovingTime);
    }

    /**
     * @return
     */
    public Short getAvgPosVerticalSpeed() {
        return getFieldToNumber(Fields.AVG_POS_VERTICAL_SPEED).map(Number::shortValue).orElse(null);
    }

    /**
     * @param avgPosVerticalSpeed
     */
    public void setAvgPosVerticalSpeed(final Short avgPosVerticalSpeed) {
        getOrAddField(Fields.AVG_POS_VERTICAL_SPEED).setValue(avgPosVerticalSpeed);
    }

    /**
     * @return
     */
    public Short getAvgNegVerticalSpeed() {
        return getFieldToNumber(Fields.AVG_NEG_VERTICAL_SPEED).map(Number::shortValue).orElse(null);
    }

    /**
     * @param avgNegVerticalSpeed
     */
    public void setAvgNegVerticalSpeed(final Short avgNegVerticalSpeed) {
        getOrAddField(Fields.AVG_NEG_VERTICAL_SPEED).setValue(avgNegVerticalSpeed);
    }

    /**
     * @return
     */
    public Short getMaxPosVerticalSpeed() {
        return getFieldToNumber(Fields.MAX_POS_VERTICAL_SPEED).map(Number::shortValue).orElse(null);
    }

    /**
     * @param maxPosVerticalSpeed
     */
    public void setMaxPosVerticalSpeed(final Short maxPosVerticalSpeed) {
        getOrAddField(Fields.MAX_POS_VERTICAL_SPEED).setValue(maxPosVerticalSpeed);
    }

    /**
     * @return
     */
    public Short getMaxNegVerticalSpeed() {
        return getFieldToNumber(Fields.MAX_NEG_VERTICAL_SPEED).map(Number::shortValue).orElse(null);
    }

    /**
     * @param maxNegVerticalSpeed
     */
    public void setMaxNegVerticalSpeed(final Short maxNegVerticalSpeed) {
        getOrAddField(Fields.MAX_NEG_VERTICAL_SPEED).setValue(maxNegVerticalSpeed);
    }

    /**
     * @return
     */
    public Long getTimeInHrZone() {
        return getFieldToNumber(Fields.TIME_IN_HR_ZONE).map(Number::longValue).orElse(null);
    }

    /**
     * @param timeInHrZone
     */
    public void setTimeInHrZone(final Long timeInHrZone) {
        getOrAddField(Fields.TIME_IN_HR_ZONE).setValue(timeInHrZone);
    }

    /**
     * @return
     */
    public Long getTimeInSpeedZone() {
        return getFieldToNumber(Fields.TIME_IN_SPEED_ZONE).map(Number::longValue).orElse(null);
    }

    /**
     * @param timeInSpeedZone
     */
    public void setTimeInSpeedZone(final Long timeInSpeedZone) {
        getOrAddField(Fields.TIME_IN_SPEED_ZONE).setValue(timeInSpeedZone);
    }

    /**
     * @return
     */
    public Long getTimeInCadenceZone() {
        return getFieldToNumber(Fields.TIME_IN_CADENCE_ZONE).map(Number::longValue).orElse(null);
    }

    /**
     * @param timeInCadenceZone
     */
    public void setTimeInCadenceZone(final Long timeInCadenceZone) {
        getOrAddField(Fields.TIME_IN_CADENCE_ZONE).setValue(timeInCadenceZone);
    }

    /**
     * @return
     */
    public Long getTimeInPowerZone() {
        return getFieldToNumber(Fields.TIME_IN_POWER_ZONE).map(Number::longValue).orElse(null);
    }

    /**
     * @param timeInPowerZone
     */
    public void setTimeInPowerZone(final Long timeInPowerZone) {
        getOrAddField(Fields.TIME_IN_POWER_ZONE).setValue(timeInPowerZone);
    }

    /**
     * @return
     */
    public Integer getRepetitionNum() {
        return getFieldToNumber(Fields.REPETITION_NUM).map(Number::intValue).orElse(null);
    }

    /**
     * @param repetitionNum
     */
    public void setRepetitionNum(final Integer repetitionNum) {
        getOrAddField(Fields.REPETITION_NUM).setValue(repetitionNum);
    }

    /**
     * @return
     */
    public Integer getMinAltitude() {
        return getFieldToNumber(Fields.MIN_ALTITUDE).map(Number::intValue).orElse(null);
    }

    /**
     * @param minAltitude
     */
    public void setMinAltitude(final Integer minAltitude) {
        getOrAddField(Fields.MIN_ALTITUDE).setValue(minAltitude);
    }

    /**
     * @return
     */
    public Integer getMinHeartRate() {
        return getFieldToNumber(Fields.MIN_HEART_RATE).map(Number::intValue).orElse(null);
    }

    /**
     * @param minHeartRate
     */
    public void setMinHeartRate(final Integer minHeartRate) {
        getOrAddField(Fields.MIN_HEART_RATE).setValue(minHeartRate);
    }

    /**
     * @return
     */
    public Integer getWktStepIndex() {
        return getFieldToNumber(Fields.WKT_STEP_INDEX).map(Number::intValue).orElse(null);
    }

    /**
     * @param wktStepIndex
     */
    public void setWktStepIndex(final Integer wktStepIndex) {
        getOrAddField(Fields.WKT_STEP_INDEX).setValue(wktStepIndex);
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

    /**
     * @return
     */
    public Integer getAvgVerticalOscillation() {
        return getFieldToNumber(Fields.AVG_VERTICAL_OSCILLATION).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgVerticalOscillation
     */
    public void setAvgVerticalOscillation(final Integer avgVerticalOscillation) {
        getOrAddField(Fields.AVG_VERTICAL_OSCILLATION).setValue(avgVerticalOscillation);
    }

    /**
     * @return
     */
    public Integer getAvgStanceTimePercent() {
        return getFieldToNumber(Fields.AVG_STANCE_TIME_PERCENT).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgStanceTimePercent
     */
    public void setAvgStanceTimePercent(final Integer avgStanceTimePercent) {
        getOrAddField(Fields.AVG_STANCE_TIME_PERCENT).setValue(avgStanceTimePercent);
    }

    /**
     * @return
     */
    public Integer getAvgStanceTime() {
        return getFieldToNumber(Fields.AVG_STANCE_TIME).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgStanceTime
     */
    public void setAvgStanceTime(final Integer avgStanceTime) {
        getOrAddField(Fields.AVG_STANCE_TIME).setValue(avgStanceTime);
    }

    /**
     * @return
     */
    public Integer getAvgFractionalCadence() {
        return getFieldToNumber(Fields.AVG_FRACTIONAL_CADENCE).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgFractionalCadence
     */
    public void setAvgFractionalCadence(final Integer avgFractionalCadence) {
        getOrAddField(Fields.AVG_FRACTIONAL_CADENCE).setValue(avgFractionalCadence);
    }

    /**
     * @return
     */
    public Integer getMaxFractionalCadence() {
        return getFieldToNumber(Fields.MAX_FRACTIONAL_CADENCE).map(Number::intValue).orElse(null);
    }

    /**
     * @param maxFractionalCadence
     */
    public void setMaxFractionalCadence(final Integer maxFractionalCadence) {
        getOrAddField(Fields.MAX_FRACTIONAL_CADENCE).setValue(maxFractionalCadence);
    }

    /**
     * @return
     */
    public Integer getTotalFractionalCycles() {
        return getFieldToNumber(Fields.TOTAL_FRACTIONAL_CYCLES).map(Number::intValue).orElse(null);
    }

    /**
     * @param totalFractionalCycles
     */
    public void setTotalFractionalCycles(final Integer totalFractionalCycles) {
        getOrAddField(Fields.TOTAL_FRACTIONAL_CYCLES).setValue(totalFractionalCycles);
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
    public Integer getAvgTotalHemoglobinConc() {
        return getFieldToNumber(Fields.AVG_TOTAL_HEMOGLOBIN_CONC).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgTotalHemoglobinConc
     */
    public void setAvgTotalHemoglobinConc(final Integer avgTotalHemoglobinConc) {
        getOrAddField(Fields.AVG_TOTAL_HEMOGLOBIN_CONC).setValue(avgTotalHemoglobinConc);
    }

    /**
     * @return
     */
    public Integer getMinTotalHemoglobinConc() {
        return getFieldToNumber(Fields.MIN_TOTAL_HEMOGLOBIN_CONC).map(Number::intValue).orElse(null);
    }

    /**
     * @param minTotalHemoglobinConc
     */
    public void setMinTotalHemoglobinConc(final Integer minTotalHemoglobinConc) {
        getOrAddField(Fields.MIN_TOTAL_HEMOGLOBIN_CONC).setValue(minTotalHemoglobinConc);
    }

    /**
     * @return
     */
    public Integer getMaxTotalHemoglobinConc() {
        return getFieldToNumber(Fields.MAX_TOTAL_HEMOGLOBIN_CONC).map(Number::intValue).orElse(null);
    }

    /**
     * @param maxTotalHemoglobinConc
     */
    public void setMaxTotalHemoglobinConc(final Integer maxTotalHemoglobinConc) {
        getOrAddField(Fields.MAX_TOTAL_HEMOGLOBIN_CONC).setValue(maxTotalHemoglobinConc);
    }

    /**
     * @return
     */
    public Integer getAvgSaturatedHemoglobinPercent() {
        return getFieldToNumber(Fields.AVG_SATURATED_HEMOGLOBIN_PERCENT).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgSaturatedHemoglobinPercent
     */
    public void setAvgSaturatedHemoglobinPercent(final Integer avgSaturatedHemoglobinPercent) {
        getOrAddField(Fields.AVG_SATURATED_HEMOGLOBIN_PERCENT).setValue(avgSaturatedHemoglobinPercent);
    }

    /**
     * @return
     */
    public Integer getMinSaturatedHemoglobinPercent() {
        return getFieldToNumber(Fields.MIN_SATURATED_HEMOGLOBIN_PERCENT).map(Number::intValue).orElse(null);
    }

    /**
     * @param minSaturatedHemoglobinPercent
     */
    public void setMinSaturatedHemoglobinPercent(final Integer minSaturatedHemoglobinPercent) {
        getOrAddField(Fields.MIN_SATURATED_HEMOGLOBIN_PERCENT).setValue(minSaturatedHemoglobinPercent);
    }

    /**
     * @return
     */
    public Integer getMaxSaturatedHemoglobinPercent() {
        return getFieldToNumber(Fields.MAX_SATURATED_HEMOGLOBIN_PERCENT).map(Number::intValue).orElse(null);
    }

    /**
     * @param maxSaturatedHemoglobinPercent
     */
    public void setMaxSaturatedHemoglobinPercent(final Integer maxSaturatedHemoglobinPercent) {
        getOrAddField(Fields.MAX_SATURATED_HEMOGLOBIN_PERCENT).setValue(maxSaturatedHemoglobinPercent);
    }

    /**
     * @return
     */
    public Integer getAvgLeftTorqueEffectiveness() {
        return getFieldToNumber(Fields.AVG_LEFT_TORQUE_EFFECTIVENESS).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgLeftTorqueEffectiveness
     */
    public void setAvgLeftTorqueEffectiveness(final Integer avgLeftTorqueEffectiveness) {
        getOrAddField(Fields.AVG_LEFT_TORQUE_EFFECTIVENESS).setValue(avgLeftTorqueEffectiveness);
    }

    /**
     * @return
     */
    public Integer getAvgRightTorqueEffectiveness() {
        return getFieldToNumber(Fields.AVG_RIGHT_TORQUE_EFFECTIVENESS).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgRightTorqueEffectiveness
     */
    public void setAvgRightTorqueEffectiveness(final Integer avgRightTorqueEffectiveness) {
        getOrAddField(Fields.AVG_RIGHT_TORQUE_EFFECTIVENESS).setValue(avgRightTorqueEffectiveness);
    }

    /**
     * @return
     */
    public Integer getAvgLeftPedalSmoothness() {
        return getFieldToNumber(Fields.AVG_LEFT_PEDAL_SMOOTHNESS).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgLeftPedalSmoothness
     */
    public void setAvgLeftPedalSmoothness(final Integer avgLeftPedalSmoothness) {
        getOrAddField(Fields.AVG_LEFT_PEDAL_SMOOTHNESS).setValue(avgLeftPedalSmoothness);
    }

    /**
     * @return
     */
    public Integer getAvgRightPedalSmoothness() {
        return getFieldToNumber(Fields.AVG_RIGHT_PEDAL_SMOOTHNESS).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgRightPedalSmoothness
     */
    public void setAvgRightPedalSmoothness(final Integer avgRightPedalSmoothness) {
        getOrAddField(Fields.AVG_RIGHT_PEDAL_SMOOTHNESS).setValue(avgRightPedalSmoothness);
    }

    /**
     * @return
     */
    public Integer getAvgCombinedPedalSmoothness() {
        return getFieldToNumber(Fields.AVG_COMBINED_PEDAL_SMOOTHNESS).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgCombinedPedalSmoothness
     */
    public void setAvgCombinedPedalSmoothness(final Integer avgCombinedPedalSmoothness) {
        getOrAddField(Fields.AVG_COMBINED_PEDAL_SMOOTHNESS).setValue(avgCombinedPedalSmoothness);
    }

    /**
     * @return
     */
    public Long getTimeStanding() {
        return getFieldToNumber(Fields.TIME_STANDING).map(Number::longValue).orElse(null);
    }

    /**
     * @param timeStanding
     */
    public void setTimeStanding(final Long timeStanding) {
        getOrAddField(Fields.TIME_STANDING).setValue(timeStanding);
    }

    /**
     * @return
     */
    public Integer getStandCount() {
        return getFieldToNumber(Fields.STAND_COUNT).map(Number::intValue).orElse(null);
    }

    /**
     * @param standCount
     */
    public void setStandCount(final Integer standCount) {
        getOrAddField(Fields.STAND_COUNT).setValue(standCount);
    }

    /**
     * @return
     */
    public Byte getAvgLeftPco() {
        return getFieldToNumber(Fields.AVG_LEFT_PCO).map(Number::byteValue).orElse(null);
    }

    /**
     * @param avgLeftPco
     */
    public void setAvgLeftPco(final Byte avgLeftPco) {
        getOrAddField(Fields.AVG_LEFT_PCO).setValue(avgLeftPco);
    }

    /**
     * @return
     */
    public Byte getAvgRightPco() {
        return getFieldToNumber(Fields.AVG_RIGHT_PCO).map(Number::byteValue).orElse(null);
    }

    /**
     * @param avgRightPco
     */
    public void setAvgRightPco(final Byte avgRightPco) {
        getOrAddField(Fields.AVG_RIGHT_PCO).setValue(avgRightPco);
    }

    /**
     * @return
     */
    public Integer getAvgLeftPowerPhase() {
        return getFieldToNumber(Fields.AVG_LEFT_POWER_PHASE).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgLeftPowerPhase
     */
    public void setAvgLeftPowerPhase(final Integer avgLeftPowerPhase) {
        getOrAddField(Fields.AVG_LEFT_POWER_PHASE).setValue(avgLeftPowerPhase);
    }

    /**
     * @return
     */
    public Integer getAvgLeftPowerPhasePeak() {
        return getFieldToNumber(Fields.AVG_LEFT_POWER_PHASE_PEAK).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgLeftPowerPhasePeak
     */
    public void setAvgLeftPowerPhasePeak(final Integer avgLeftPowerPhasePeak) {
        getOrAddField(Fields.AVG_LEFT_POWER_PHASE_PEAK).setValue(avgLeftPowerPhasePeak);
    }

    /**
     * @return
     */
    public Integer getAvgRightPowerPhase() {
        return getFieldToNumber(Fields.AVG_RIGHT_POWER_PHASE).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgRightPowerPhase
     */
    public void setAvgRightPowerPhase(final Integer avgRightPowerPhase) {
        getOrAddField(Fields.AVG_RIGHT_POWER_PHASE).setValue(avgRightPowerPhase);
    }

    /**
     * @return
     */
    public Integer getAvgRightPowerPhasePeak() {
        return getFieldToNumber(Fields.AVG_RIGHT_POWER_PHASE_PEAK).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgRightPowerPhasePeak
     */
    public void setAvgRightPowerPhasePeak(final Integer avgRightPowerPhasePeak) {
        getOrAddField(Fields.AVG_RIGHT_POWER_PHASE_PEAK).setValue(avgRightPowerPhasePeak);
    }

    /**
     * @return
     */
    public Integer getAvgPowerPosition() {
        return getFieldToNumber(Fields.AVG_POWER_POSITION).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgPowerPosition
     */
    public void setAvgPowerPosition(final Integer avgPowerPosition) {
        getOrAddField(Fields.AVG_POWER_POSITION).setValue(avgPowerPosition);
    }

    /**
     * @return
     */
    public Integer getMaxPowerPosition() {
        return getFieldToNumber(Fields.MAX_POWER_POSITION).map(Number::intValue).orElse(null);
    }

    /**
     * @param maxPowerPosition
     */
    public void setMaxPowerPosition(final Integer maxPowerPosition) {
        getOrAddField(Fields.MAX_POWER_POSITION).setValue(maxPowerPosition);
    }

    /**
     * @return
     */
    public Integer getAvgCadencePosition() {
        return getFieldToNumber(Fields.AVG_CADENCE_POSITION).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgCadencePosition
     */
    public void setAvgCadencePosition(final Integer avgCadencePosition) {
        getOrAddField(Fields.AVG_CADENCE_POSITION).setValue(avgCadencePosition);
    }

    /**
     * @return
     */
    public Integer getMaxCadencePosition() {
        return getFieldToNumber(Fields.MAX_CADENCE_POSITION).map(Number::intValue).orElse(null);
    }

    /**
     * @param maxCadencePosition
     */
    public void setMaxCadencePosition(final Integer maxCadencePosition) {
        getOrAddField(Fields.MAX_CADENCE_POSITION).setValue(maxCadencePosition);
    }

    /**
     * @return
     */
    public Long getEnhancedAvgSpeed() {
        return getFieldToNumber(Fields.ENHANCED_AVG_SPEED).map(Number::longValue).orElse(null);
    }

    /**
     * @param enhancedAvgSpeed
     */
    public void setEnhancedAvgSpeed(final Long enhancedAvgSpeed) {
        getOrAddField(Fields.ENHANCED_AVG_SPEED).setValue(enhancedAvgSpeed);
    }

    /**
     * @return
     */
    public Long getEnhancedMaxSpeed() {
        return getFieldToNumber(Fields.ENHANCED_MAX_SPEED).map(Number::longValue).orElse(null);
    }

    /**
     * @param enhancedMaxSpeed
     */
    public void setEnhancedMaxSpeed(final Long enhancedMaxSpeed) {
        getOrAddField(Fields.ENHANCED_MAX_SPEED).setValue(enhancedMaxSpeed);
    }

    /**
     * @return
     */
    public Long getEnhancedAvgAltitude() {
        return getFieldToNumber(Fields.ENHANCED_AVG_ALTITUDE).map(Number::longValue).orElse(null);
    }

    /**
     * @param enhancedAvgAltitude
     */
    public void setEnhancedAvgAltitude(final Long enhancedAvgAltitude) {
        getOrAddField(Fields.ENHANCED_AVG_ALTITUDE).setValue(enhancedAvgAltitude);
    }

    /**
     * @return
     */
    public Long getEnhancedMinAltitude() {
        return getFieldToNumber(Fields.ENHANCED_MIN_ALTITUDE).map(Number::longValue).orElse(null);
    }

    /**
     * @param enhancedMinAltitude
     */
    public void setEnhancedMinAltitude(final Long enhancedMinAltitude) {
        getOrAddField(Fields.ENHANCED_MIN_ALTITUDE).setValue(enhancedMinAltitude);
    }

    /**
     * @return
     */
    public Long getEnhancedMaxAltitude() {
        return getFieldToNumber(Fields.ENHANCED_MAX_ALTITUDE).map(Number::longValue).orElse(null);
    }

    /**
     * @param enhancedMaxAltitude
     */
    public void setEnhancedMaxAltitude(final Long enhancedMaxAltitude) {
        getOrAddField(Fields.ENHANCED_MAX_ALTITUDE).setValue(enhancedMaxAltitude);
    }

    /**
     * @return
     */
    public Integer getAvgLevMotorPower() {
        return getFieldToNumber(Fields.AVG_LEV_MOTOR_POWER).map(Number::intValue).orElse(null);
    }

    /**
     * @param avgLevMotorPower
     */
    public void setAvgLevMotorPower(final Integer avgLevMotorPower) {
        getOrAddField(Fields.AVG_LEV_MOTOR_POWER).setValue(avgLevMotorPower);
    }

    /**
     * @return
     */
    public Integer getMaxLevMotorPower() {
        return getFieldToNumber(Fields.MAX_LEV_MOTOR_POWER).map(Number::intValue).orElse(null);
    }

    /**
     * @param maxLevMotorPower
     */
    public void setMaxLevMotorPower(final Integer maxLevMotorPower) {
        getOrAddField(Fields.MAX_LEV_MOTOR_POWER).setValue(maxLevMotorPower);
    }

    /**
     * @return
     */
    public Integer getLevBatteryConsumption() {
        return getFieldToNumber(Fields.LEV_BATTERY_CONSUMPTION).map(Number::intValue).orElse(null);
    }

    /**
     * @param levBatteryConsumption
     */
    public void setLevBatteryConsumption(final Integer levBatteryConsumption) {
        getOrAddField(Fields.LEV_BATTERY_CONSUMPTION).setValue(levBatteryConsumption);
    }

}
