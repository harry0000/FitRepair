package com.harry0000.fit.message;

import com.harry0000.fit.field.Field;
import com.harry0000.fit.vo.BaseType;
import com.harry0000.fit.vo.FitMessage;

public class Record extends DataMessage {

    public enum Fields implements FieldProfile {
        POSITION_LAT                    (0,  BaseType.SINT32),
        POSITION_LONG                   (1,  BaseType.SINT32),
        ALTITUDE                        (2,  BaseType.UINT16),
        HEART_RATE                      (3,  BaseType.UINT8),
        CADENCE                         (4,  BaseType.UINT8),
        DISTANCE                        (5,  BaseType.UINT32),
        SPEED                           (6,  BaseType.UINT16),
        POWER                           (7,  BaseType.UINT16),
        COMPRESSED_SPEED_DISTANCE       (8,  BaseType.BYTE),
        GRADE                           (9,  BaseType.SINT16),
        RESISTANCE                      (10, BaseType.UINT8),
        TIME_FROM_COURSE                (11, BaseType.SINT32),
        CYCLE_LENGTH                    (12, BaseType.UINT8),
        TEMPERATURE                     (13, BaseType.SINT8),
        SPEED_1S                        (17, BaseType.UINT8),
        CYCLES                          (18, BaseType.UINT8),
        TOTAL_CYCLES                    (19, BaseType.UINT32),
        COMPRESSED_ACCUMULATED_POWER    (28, BaseType.UINT16),
        ACCUMULATED_POWER               (29, BaseType.UINT32),
        LEFT_RIGHT_BALANCE              (30, BaseType.UINT8),
        GPS_ACCURACY                    (31, BaseType.UINT8),
        VERTICAL_SPEED                  (32, BaseType.SINT16),
        CALORIES                        (33, BaseType.UINT16),
        VERTICAL_OSCILLATION            (39, BaseType.UINT16),
        STANCE_TIME_PERCENT             (40, BaseType.UINT16),
        STANCE_TIME                     (41, BaseType.UINT16),
        ACTIVITY_TYPE                   (42, BaseType.ENUM),
        LEFT_TORQUE_EFFECTIVENESS       (43, BaseType.UINT8),
        RIGHT_TORQUE_EFFECTIVENESS      (44, BaseType.UINT8),
        LEFT_PEDAL_SMOOTHNESS           (45, BaseType.UINT8),
        RIGHT_PEDAL_SMOOTHNESS          (46, BaseType.UINT8),
        COMBINED_PEDAL_SMOOTHNESS       (47, BaseType.UINT8),
        TIME128                         (48, BaseType.UINT8),
        STROKE_TYPE                     (49, BaseType.ENUM),
        ZONE                            (50, BaseType.UINT8),
        BALL_SPEED                      (51, BaseType.UINT16),
        CADENCE256                      (52, BaseType.UINT16),
        FRACTIONAL_CADENCE              (53, BaseType.UINT8),
        TOTAL_HEMOGLOBIN_CONC           (54, BaseType.UINT16),
        TOTAL_HEMOGLOBIN_CONC_MIN       (55, BaseType.UINT16),
        TOTAL_HEMOGLOBIN_CONC_MAX       (56, BaseType.UINT16),
        SATURATED_HEMOGLOBIN_PERCENT    (57, BaseType.UINT16),
        SATURATED_HEMOGLOBIN_PERCENT_MIN(58, BaseType.UINT16),
        SATURATED_HEMOGLOBIN_PERCENT_MAX(59, BaseType.UINT16),
        DEVICE_INDEX                    (62, BaseType.UINT8),
        LEFT_PCO                        (67, BaseType.SINT8),
        RIGHT_PCO                       (68, BaseType.SINT8),
        LEFT_POWER_PHASE                (69, BaseType.UINT8),
        LEFT_POWER_PHASE_PEAK           (70, BaseType.UINT8),
        RIGHT_POWER_PHASE               (71, BaseType.UINT8),
        RIGHT_POWER_PHASE_PEAK          (72, BaseType.UINT8),
        ENHANCED_SPEED                  (73, BaseType.UINT32),
        ENHANCED_ALTITUDE               (78, BaseType.UINT32),
        BATTERY_SOC                     (81, BaseType.UINT8),
        MOTOR_POWER                     (82, BaseType.UINT16);

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
    public Record(final DataMessage msg) {
        super(msg);
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.message.DataMessage#getGlobalFitMessage()
     */
    @Override
    public FitMessage getFitMessage() {
        return FitMessage.RECORD;
    }

    /**
     * @return
     */
    public Integer getPositionLat() {
        final Number value = getFieldToNumber(Fields.POSITION_LAT);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param positionLat
     */
    public void setPositionLat(final Integer positionLat) {
        final Field<?> f = getOrAddField(Fields.POSITION_LAT);
        f.setValue(positionLat);
    }

    /**
     * @return
     */
    public Integer getPositionLong() {
        final Number value = getFieldToNumber(Fields.POSITION_LONG);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param positionLong
     */
    public void setPositionLong(final Integer positionLong) {
        final Field<?> f = getOrAddField(Fields.POSITION_LONG);
        f.setValue(positionLong);
    }

    /**
     * @return
     */
    public Integer getAltitude() {
        final Number value = getFieldToNumber(Fields.ALTITUDE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param altitude
     */
    public void setAltitude(final Integer altitude) {
        final Field<?> f = getOrAddField(Fields.ALTITUDE);
        f.setValue(altitude);
    }

    /**
     * @return
     */
    public Integer getHeartRate() {
        final Number value = getFieldToNumber(Fields.HEART_RATE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param heartRate
     */
    public void setHeartRate(final Integer heartRate) {
        final Field<?> f = getOrAddField(Fields.HEART_RATE);
        f.setValue(heartRate);
    }

    /**
     * @return
     */
    public Integer getCadence() {
        final Number value = getFieldToNumber(Fields.CADENCE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param cadence
     */
    public void setCadence(final Integer cadence) {
        final Field<?> f = getOrAddField(Fields.CADENCE);
        f.setValue(cadence);
    }

    /**
     * @return
     */
    public Long getDistance() {
        final Number value = getFieldToNumber(Fields.DISTANCE);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param distance
     */
    public void setDistance(final Long distance) {
        final Field<?> f = getOrAddField(Fields.DISTANCE);
        f.setValue(distance);
    }

    /**
     * @return
     */
    public Integer getSpeed() {
        final Number value = getFieldToNumber(Fields.SPEED);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param speed
     */
    public void setSpeed(final Integer speed) {
        final Field<?> f = getOrAddField(Fields.SPEED);
        f.setValue(speed);
    }

    /**
     * @return
     */
    public Integer getPower() {
        final Number value = getFieldToNumber(Fields.POWER);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param power
     */
    public void setPower(final Integer power) {
        final Field<?> f = getOrAddField(Fields.POWER);
        f.setValue(power);
    }

    /**
     * @return
     */
    public Integer getCompressedSpeedDistance() {
        final Number value = getFieldToNumber(Fields.COMPRESSED_SPEED_DISTANCE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param compressedSpeedDistance
     */
    public void setCompressedSpeedDistance(final Integer compressedSpeedDistance) {
        final Field<?> f = getOrAddField(Fields.COMPRESSED_SPEED_DISTANCE);
        f.setValue(compressedSpeedDistance);
    }

    /**
     * @return
     */
    public Short getGrade() {
        final Number value = getFieldToNumber(Fields.GRADE);

        return value != null ? value.shortValue() : null;
    }

    /**
     * @param grade
     */
    public void setGrade(final Short grade) {
        final Field<?> f = getOrAddField(Fields.GRADE);
        f.setValue(grade);
    }

    /**
     * @return
     */
    public Integer getResistance() {
        final Number value = getFieldToNumber(Fields.RESISTANCE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param resistance
     */
    public void setResistance(final Integer resistance) {
        final Field<?> f = getOrAddField(Fields.RESISTANCE);
        f.setValue(resistance);
    }

    /**
     * @return
     */
    public Integer getTimeFromCourse() {
        final Number value = getFieldToNumber(Fields.TIME_FROM_COURSE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param timeFromCourse
     */
    public void setTimeFromCourse(final Integer timeFromCourse) {
        final Field<?> f = getOrAddField(Fields.TIME_FROM_COURSE);
        f.setValue(timeFromCourse);
    }

    /**
     * @return
     */
    public Integer getCycleLength() {
        final Number value = getFieldToNumber(Fields.CYCLE_LENGTH);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param cycleLength
     */
    public void setCycleLength(final Integer cycleLength) {
        final Field<?> f = getOrAddField(Fields.CYCLE_LENGTH);
        f.setValue(cycleLength);
    }

    /**
     * @return
     */
    public Byte getTemperature() {
        final Number value = getFieldToNumber(Fields.TEMPERATURE);

        return value != null ? value.byteValue() : null;
    }

    /**
     * @param temperature
     */
    public void setTemperature(final Byte temperature) {
        final Field<?> f = getOrAddField(Fields.TEMPERATURE);
        f.setValue(temperature);
    }

    /**
     * @return
     */
    public Integer getSpeed1s() {
        final Number value = getFieldToNumber(Fields.SPEED_1S);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param speed1s
     */
    public void setSpeed1s(final Integer speed1s) {
        final Field<?> f = getOrAddField(Fields.SPEED_1S);
        f.setValue(speed1s);
    }

    /**
     * @return
     */
    public Integer getCycles() {
        final Number value = getFieldToNumber(Fields.CYCLES);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param cycles
     */
    public void setCycles(final Integer cycles) {
        final Field<?> f = getOrAddField(Fields.CYCLES);
        f.setValue(cycles);
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
    public Integer getCompressedAccumulatedPower() {
        final Number value = getFieldToNumber(Fields.COMPRESSED_ACCUMULATED_POWER);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param compressedAccumulatedPower
     */
    public void setCompressedAccumulatedPower(final Integer compressedAccumulatedPower) {
        final Field<?> f = getOrAddField(Fields.COMPRESSED_ACCUMULATED_POWER);
        f.setValue(compressedAccumulatedPower);
    }

    /**
     * @return
     */
    public Long getAccumulatedPower() {
        final Number value = getFieldToNumber(Fields.ACCUMULATED_POWER);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param accumulatedPower
     */
    public void setAccumulatedPower(final Long accumulatedPower) {
        final Field<?> f = getOrAddField(Fields.ACCUMULATED_POWER);
        f.setValue(accumulatedPower);
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
    public Short getVerticalSpeed() {
        final Number value = getFieldToNumber(Fields.VERTICAL_SPEED);

        return value != null ? value.shortValue() : null;
    }

    /**
     * @param verticalSpeed
     */
    public void setVerticalSpeed(final Short verticalSpeed) {
        final Field<?> f = getOrAddField(Fields.VERTICAL_SPEED);
        f.setValue(verticalSpeed);
    }

    /**
     * @return
     */
    public Integer getCalories() {
        final Number value = getFieldToNumber(Fields.CALORIES);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param calories
     */
    public void setCalories(final Integer calories) {
        final Field<?> f = getOrAddField(Fields.CALORIES);
        f.setValue(calories);
    }

    /**
     * @return
     */
    public Integer getVerticalOscillation() {
        final Number value = getFieldToNumber(Fields.VERTICAL_OSCILLATION);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param verticalOscillation
     */
    public void setVerticalOscillation(final Integer verticalOscillation) {
        final Field<?> f = getOrAddField(Fields.VERTICAL_OSCILLATION);
        f.setValue(verticalOscillation);
    }

    /**
     * @return
     */
    public Integer getStanceTimePercent() {
        final Number value = getFieldToNumber(Fields.STANCE_TIME_PERCENT);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param stanceTimePercent
     */
    public void setStanceTimePercent(final Integer stanceTimePercent) {
        final Field<?> f = getOrAddField(Fields.STANCE_TIME_PERCENT);
        f.setValue(stanceTimePercent);
    }

    /**
     * @return
     */
    public Integer getStanceTime() {
        final Number value = getFieldToNumber(Fields.STANCE_TIME);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param stanceTime
     */
    public void setStanceTime(final Integer stanceTime) {
        final Field<?> f = getOrAddField(Fields.STANCE_TIME);
        f.setValue(stanceTime);
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
    public Integer getLeftTorqueEffectiveness() {
        final Number value = getFieldToNumber(Fields.LEFT_TORQUE_EFFECTIVENESS);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param leftTorqueEffectiveness
     */
    public void setLeftTorqueEffectiveness(final Integer leftTorqueEffectiveness) {
        final Field<?> f = getOrAddField(Fields.LEFT_TORQUE_EFFECTIVENESS);
        f.setValue(leftTorqueEffectiveness);
    }

    /**
     * @return
     */
    public Integer getRightTorqueEffectiveness() {
        final Number value = getFieldToNumber(Fields.RIGHT_TORQUE_EFFECTIVENESS);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param rightTorqueEffectiveness
     */
    public void setRightTorqueEffectiveness(final Integer rightTorqueEffectiveness) {
        final Field<?> f = getOrAddField(Fields.RIGHT_TORQUE_EFFECTIVENESS);
        f.setValue(rightTorqueEffectiveness);
    }

    /**
     * @return
     */
    public Integer getLeftPedalSmoothness() {
        final Number value = getFieldToNumber(Fields.LEFT_PEDAL_SMOOTHNESS);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param leftPedalSmoothness
     */
    public void setLeftPedalSmoothness(final Integer leftPedalSmoothness) {
        final Field<?> f = getOrAddField(Fields.LEFT_PEDAL_SMOOTHNESS);
        f.setValue(leftPedalSmoothness);
    }

    /**
     * @return
     */
    public Integer getRightPedalSmoothness() {
        final Number value = getFieldToNumber(Fields.RIGHT_PEDAL_SMOOTHNESS);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param rightPedalSmoothness
     */
    public void setRightPedalSmoothness(final Integer rightPedalSmoothness) {
        final Field<?> f = getOrAddField(Fields.RIGHT_PEDAL_SMOOTHNESS);
        f.setValue(rightPedalSmoothness);
    }

    /**
     * @return
     */
    public Integer getCombinedPedalSmoothness() {
        final Number value = getFieldToNumber(Fields.COMBINED_PEDAL_SMOOTHNESS);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param combinedPedalSmoothness
     */
    public void setCombinedPedalSmoothness(final Integer combinedPedalSmoothness) {
        final Field<?> f = getOrAddField(Fields.COMBINED_PEDAL_SMOOTHNESS);
        f.setValue(combinedPedalSmoothness);
    }

    /**
     * @return
     */
    public Integer getTime128() {
        final Number value = getFieldToNumber(Fields.TIME128);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param time128
     */
    public void setTime128(final Integer time128) {
        final Field<?> f = getOrAddField(Fields.TIME128);
        f.setValue(time128);
    }

    /**
     * @return
     */
    public Integer getStrokeType() {
        final Number value = getFieldToNumber(Fields.STROKE_TYPE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param strokeType
     */
    public void setStrokeType(final Integer strokeType) {
        final Field<?> f = getOrAddField(Fields.STROKE_TYPE);
        f.setValue(strokeType);
    }

    /**
     * @return
     */
    public Integer getZone() {
        final Number value = getFieldToNumber(Fields.ZONE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param zone
     */
    public void setZone(final Integer zone) {
        final Field<?> f = getOrAddField(Fields.ZONE);
        f.setValue(zone);
    }

    /**
     * @return
     */
    public Integer getBallSpeed() {
        final Number value = getFieldToNumber(Fields.BALL_SPEED);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param ballSpeed
     */
    public void setBallSpeed(final Integer ballSpeed) {
        final Field<?> f = getOrAddField(Fields.BALL_SPEED);
        f.setValue(ballSpeed);
    }

    /**
     * @return
     */
    public Integer getCadence256() {
        final Number value = getFieldToNumber(Fields.CADENCE256);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param cadence256
     */
    public void setCadence256(final Integer cadence256) {
        final Field<?> f = getOrAddField(Fields.CADENCE256);
        f.setValue(cadence256);
    }

    /**
     * @return
     */
    public Integer getFractionalCadence() {
        final Number value = getFieldToNumber(Fields.FRACTIONAL_CADENCE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param fractionalCadence
     */
    public void setFractionalCadence(final Integer fractionalCadence) {
        final Field<?> f = getOrAddField(Fields.FRACTIONAL_CADENCE);
        f.setValue(fractionalCadence);
    }

    /**
     * @return
     */
    public Integer getTotalHemoglobinConc() {
        final Number value = getFieldToNumber(Fields.TOTAL_HEMOGLOBIN_CONC);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param totalHemoglobinConc
     */
    public void setTotalHemoglobinConc(final Integer totalHemoglobinConc) {
        final Field<?> f = getOrAddField(Fields.TOTAL_HEMOGLOBIN_CONC);
        f.setValue(totalHemoglobinConc);
    }

    /**
     * @return
     */
    public Integer getTotalHemoglobinConcMin() {
        final Number value = getFieldToNumber(Fields.TOTAL_HEMOGLOBIN_CONC_MIN);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param totalHemoglobinConcMin
     */
    public void setTotalHemoglobinConcMin(final Integer totalHemoglobinConcMin) {
        final Field<?> f = getOrAddField(Fields.TOTAL_HEMOGLOBIN_CONC_MIN);
        f.setValue(totalHemoglobinConcMin);
    }

    /**
     * @return
     */
    public Integer getTotalHemoglobinConcMax() {
        final Number value = getFieldToNumber(Fields.TOTAL_HEMOGLOBIN_CONC_MAX);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param totalHemoglobinConcMax
     */
    public void setTotalHemoglobinConcMax(final Integer totalHemoglobinConcMax) {
        final Field<?> f = getOrAddField(Fields.TOTAL_HEMOGLOBIN_CONC_MAX);
        f.setValue(totalHemoglobinConcMax);
    }

    /**
     * @return
     */
    public Integer getSaturatedHemoglobinPercent() {
        final Number value = getFieldToNumber(Fields.SATURATED_HEMOGLOBIN_PERCENT);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param saturatedHemoglobinPercent
     */
    public void setSaturatedHemoglobinPercent(final Integer saturatedHemoglobinPercent) {
        final Field<?> f = getOrAddField(Fields.SATURATED_HEMOGLOBIN_PERCENT);
        f.setValue(saturatedHemoglobinPercent);
    }

    /**
     * @return
     */
    public Integer getSaturatedHemoglobinPercentMin() {
        final Number value = getFieldToNumber(Fields.SATURATED_HEMOGLOBIN_PERCENT_MIN);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param saturatedHemoglobinPercentMin
     */
    public void setSaturatedHemoglobinPercentMin(final Integer saturatedHemoglobinPercentMin) {
        final Field<?> f = getOrAddField(Fields.SATURATED_HEMOGLOBIN_PERCENT_MIN);
        f.setValue(saturatedHemoglobinPercentMin);
    }

    /**
     * @return
     */
    public Integer getSaturatedHemoglobinPercentMax() {
        final Number value = getFieldToNumber(Fields.SATURATED_HEMOGLOBIN_PERCENT_MAX);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param saturatedHemoglobinPercentMax
     */
    public void setSaturatedHemoglobinPercentMax(final Integer saturatedHemoglobinPercentMax) {
        final Field<?> f = getOrAddField(Fields.SATURATED_HEMOGLOBIN_PERCENT_MAX);
        f.setValue(saturatedHemoglobinPercentMax);
    }

    /**
     * @return
     */
    public Integer getDeviceIndex() {
        final Number value = getFieldToNumber(Fields.DEVICE_INDEX);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param deviceIndex
     */
    public void setDeviceIndex(final Integer deviceIndex) {
        final Field<?> f = getOrAddField(Fields.DEVICE_INDEX);
        f.setValue(deviceIndex);
    }

    /**
     * @return
     */
    public Byte getLeftPco() {
        final Number value = getFieldToNumber(Fields.LEFT_PCO);

        return value != null ? value.byteValue() : null;
    }

    /**
     * @param leftPco
     */
    public void setLeftPco(final Byte leftPco) {
        final Field<?> f = getOrAddField(Fields.LEFT_PCO);
        f.setValue(leftPco);
    }

    /**
     * @return
     */
    public Byte getRightPco() {
        final Number value = getFieldToNumber(Fields.RIGHT_PCO);

        return value != null ? value.byteValue() : null;
    }

    /**
     * @param rightPco
     */
    public void setRightPco(final Byte rightPco) {
        final Field<?> f = getOrAddField(Fields.RIGHT_PCO);
        f.setValue(rightPco);
    }

    /**
     * @return
     */
    public Integer getLeftPowerPhase() {
        final Number value = getFieldToNumber(Fields.LEFT_POWER_PHASE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param leftPowerPhase
     */
    public void setLeftPowerPhase(final Integer leftPowerPhase) {
        final Field<?> f = getOrAddField(Fields.LEFT_POWER_PHASE);
        f.setValue(leftPowerPhase);
    }

    /**
     * @return
     */
    public Integer getLeftPowerPhasePeak() {
        final Number value = getFieldToNumber(Fields.LEFT_POWER_PHASE_PEAK);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param leftPowerPhasePeak
     */
    public void setLeftPowerPhasePeak(final Integer leftPowerPhasePeak) {
        final Field<?> f = getOrAddField(Fields.LEFT_POWER_PHASE_PEAK);
        f.setValue(leftPowerPhasePeak);
    }

    /**
     * @return
     */
    public Integer getRightPowerPhase() {
        final Number value = getFieldToNumber(Fields.RIGHT_POWER_PHASE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param rightPowerPhase
     */
    public void setRightPowerPhase(final Integer rightPowerPhase) {
        final Field<?> f = getOrAddField(Fields.RIGHT_POWER_PHASE);
        f.setValue(rightPowerPhase);
    }

    /**
     * @return
     */
    public Integer getRightPowerPhasePeak() {
        final Number value = getFieldToNumber(Fields.RIGHT_POWER_PHASE_PEAK);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param rightPowerPhasePeak
     */
    public void setRightPowerPhasePeak(final Integer rightPowerPhasePeak) {
        final Field<?> f = getOrAddField(Fields.RIGHT_POWER_PHASE_PEAK);
        f.setValue(rightPowerPhasePeak);
    }

    /**
     * @return
     */
    public Long getEnhancedSpeed() {
        final Number value = getFieldToNumber(Fields.ENHANCED_SPEED);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param enhancedSpeed
     */
    public void setEnhancedSpeed(final Long enhancedSpeed) {
        final Field<?> f = getOrAddField(Fields.ENHANCED_SPEED);
        f.setValue(enhancedSpeed);
    }

    /**
     * @return
     */
    public Long getEnhancedAltitude() {
        final Number value = getFieldToNumber(Fields.ENHANCED_ALTITUDE);

        return value != null ? value.longValue() : null;
    }

    /**
     * @param enhancedAltitude
     */
    public void setEnhancedAltitude(final Long enhancedAltitude) {
        final Field<?> f = getOrAddField(Fields.ENHANCED_ALTITUDE);
        f.setValue(enhancedAltitude);
    }

    /**
     * @return
     */
    public Integer getBatterySoc() {
        final Number value = getFieldToNumber(Fields.BATTERY_SOC);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param batterySoc
     */
    public void setBatterySoc(final Integer batterySoc) {
        final Field<?> f = getOrAddField(Fields.BATTERY_SOC);
        f.setValue(batterySoc);
    }

    /**
     * @return
     */
    public Integer getMotorPower() {
        final Number value = getFieldToNumber(Fields.MOTOR_POWER);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param motorPower
     */
    public void setMotorPower(final Integer motorPower) {
        final Field<?> f = getOrAddField(Fields.MOTOR_POWER);
        f.setValue(motorPower);
    }

}
