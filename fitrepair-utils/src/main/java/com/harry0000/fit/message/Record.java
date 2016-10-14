package com.harry0000.fit.message;

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
        return getFieldToNumber(Fields.POSITION_LAT).map(Number::intValue).orElse(null);
    }

    /**
     * @param positionLat
     */
    public void setPositionLat(final Integer positionLat) {
        getOrAddField(Fields.POSITION_LAT).setValue(positionLat);
    }

    /**
     * @return
     */
    public Integer getPositionLong() {
        return getFieldToNumber(Fields.POSITION_LONG).map(Number::intValue).orElse(null);
    }

    /**
     * @param positionLong
     */
    public void setPositionLong(final Integer positionLong) {
        getOrAddField(Fields.POSITION_LONG).setValue(positionLong);
    }

    /**
     * @return
     */
    public Integer getAltitude() {
        return getFieldToNumber(Fields.ALTITUDE).map(Number::intValue).orElse(null);
    }

    /**
     * @param altitude
     */
    public void setAltitude(final Integer altitude) {
        getOrAddField(Fields.ALTITUDE).setValue(altitude);
    }

    /**
     * @return
     */
    public Integer getHeartRate() {
        return getFieldToNumber(Fields.HEART_RATE).map(Number::intValue).orElse(null);
    }

    /**
     * @param heartRate
     */
    public void setHeartRate(final Integer heartRate) {
        getOrAddField(Fields.HEART_RATE).setValue(heartRate);
    }

    /**
     * @return
     */
    public Integer getCadence() {
        return getFieldToNumber(Fields.CADENCE).map(Number::intValue).orElse(null);
    }

    /**
     * @param cadence
     */
    public void setCadence(final Integer cadence) {
        getOrAddField(Fields.CADENCE).setValue(cadence);
    }

    /**
     * @return
     */
    public Long getDistance() {
        return getFieldToNumber(Fields.DISTANCE).map(Number::longValue).orElse(null);
    }

    /**
     * @param distance
     */
    public void setDistance(final Long distance) {
        getOrAddField(Fields.DISTANCE).setValue(distance);
    }

    /**
     * @return
     */
    public Integer getSpeed() {
        return getFieldToNumber(Fields.SPEED).map(Number::intValue).orElse(null);
    }

    /**
     * @param speed
     */
    public void setSpeed(final Integer speed) {
        getOrAddField(Fields.SPEED).setValue(speed);
    }

    /**
     * @return
     */
    public Integer getPower() {
        return getFieldToNumber(Fields.POWER).map(Number::intValue).orElse(null);
    }

    /**
     * @param power
     */
    public void setPower(final Integer power) {
        getOrAddField(Fields.POWER).setValue(power);
    }

    /**
     * @return
     */
    public Integer getCompressedSpeedDistance() {
        return getFieldToNumber(Fields.COMPRESSED_SPEED_DISTANCE).map(Number::intValue).orElse(null);
    }

    /**
     * @param compressedSpeedDistance
     */
    public void setCompressedSpeedDistance(final Integer compressedSpeedDistance) {
        getOrAddField(Fields.COMPRESSED_SPEED_DISTANCE).setValue(compressedSpeedDistance);
    }

    /**
     * @return
     */
    public Short getGrade() {
        return getFieldToNumber(Fields.GRADE).map(Number::shortValue).orElse(null);
    }

    /**
     * @param grade
     */
    public void setGrade(final Short grade) {
        getOrAddField(Fields.GRADE).setValue(grade);
    }

    /**
     * @return
     */
    public Integer getResistance() {
        return getFieldToNumber(Fields.RESISTANCE).map(Number::intValue).orElse(null);
    }

    /**
     * @param resistance
     */
    public void setResistance(final Integer resistance) {
        getOrAddField(Fields.RESISTANCE).setValue(resistance);
    }

    /**
     * @return
     */
    public Integer getTimeFromCourse() {
        return getFieldToNumber(Fields.TIME_FROM_COURSE).map(Number::intValue).orElse(null);
    }

    /**
     * @param timeFromCourse
     */
    public void setTimeFromCourse(final Integer timeFromCourse) {
        getOrAddField(Fields.TIME_FROM_COURSE).setValue(timeFromCourse);
    }

    /**
     * @return
     */
    public Integer getCycleLength() {
        return getFieldToNumber(Fields.CYCLE_LENGTH).map(Number::intValue).orElse(null);
    }

    /**
     * @param cycleLength
     */
    public void setCycleLength(final Integer cycleLength) {
        getOrAddField(Fields.CYCLE_LENGTH).setValue(cycleLength);
    }

    /**
     * @return
     */
    public Byte getTemperature() {
        return getFieldToNumber(Fields.TEMPERATURE).map(Number::byteValue).orElse(null);
    }

    /**
     * @param temperature
     */
    public void setTemperature(final Byte temperature) {
        getOrAddField(Fields.TEMPERATURE).setValue(temperature);
    }

    /**
     * @return
     */
    public Integer getSpeed1s() {
        return getFieldToNumber(Fields.SPEED_1S).map(Number::intValue).orElse(null);
    }

    /**
     * @param speed1s
     */
    public void setSpeed1s(final Integer speed1s) {
        getOrAddField(Fields.SPEED_1S).setValue(speed1s);
    }

    /**
     * @return
     */
    public Integer getCycles() {
        return getFieldToNumber(Fields.CYCLES).map(Number::intValue).orElse(null);
    }

    /**
     * @param cycles
     */
    public void setCycles(final Integer cycles) {
        getOrAddField(Fields.CYCLES).setValue(cycles);
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
    public Integer getCompressedAccumulatedPower() {
        return getFieldToNumber(Fields.COMPRESSED_ACCUMULATED_POWER).map(Number::intValue).orElse(null);
    }

    /**
     * @param compressedAccumulatedPower
     */
    public void setCompressedAccumulatedPower(final Integer compressedAccumulatedPower) {
        getOrAddField(Fields.COMPRESSED_ACCUMULATED_POWER).setValue(compressedAccumulatedPower);
    }

    /**
     * @return
     */
    public Long getAccumulatedPower() {
        return getFieldToNumber(Fields.ACCUMULATED_POWER).map(Number::longValue).orElse(null);
    }

    /**
     * @param accumulatedPower
     */
    public void setAccumulatedPower(final Long accumulatedPower) {
        getOrAddField(Fields.ACCUMULATED_POWER).setValue(accumulatedPower);
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
    public Short getVerticalSpeed() {
        return getFieldToNumber(Fields.VERTICAL_SPEED).map(Number::shortValue).orElse(null);
    }

    /**
     * @param verticalSpeed
     */
    public void setVerticalSpeed(final Short verticalSpeed) {
        getOrAddField(Fields.VERTICAL_SPEED).setValue(verticalSpeed);
    }

    /**
     * @return
     */
    public Integer getCalories() {
        return getFieldToNumber(Fields.CALORIES).map(Number::intValue).orElse(null);
    }

    /**
     * @param calories
     */
    public void setCalories(final Integer calories) {
        getOrAddField(Fields.CALORIES).setValue(calories);
    }

    /**
     * @return
     */
    public Integer getVerticalOscillation() {
        return getFieldToNumber(Fields.VERTICAL_OSCILLATION).map(Number::intValue).orElse(null);
    }

    /**
     * @param verticalOscillation
     */
    public void setVerticalOscillation(final Integer verticalOscillation) {
        getOrAddField(Fields.VERTICAL_OSCILLATION).setValue(verticalOscillation);
    }

    /**
     * @return
     */
    public Integer getStanceTimePercent() {
        return getFieldToNumber(Fields.STANCE_TIME_PERCENT).map(Number::intValue).orElse(null);
    }

    /**
     * @param stanceTimePercent
     */
    public void setStanceTimePercent(final Integer stanceTimePercent) {
        getOrAddField(Fields.STANCE_TIME_PERCENT).setValue(stanceTimePercent);
    }

    /**
     * @return
     */
    public Integer getStanceTime() {
        return getFieldToNumber(Fields.STANCE_TIME).map(Number::intValue).orElse(null);
    }

    /**
     * @param stanceTime
     */
    public void setStanceTime(final Integer stanceTime) {
        getOrAddField(Fields.STANCE_TIME).setValue(stanceTime);
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
    public Integer getLeftTorqueEffectiveness() {
        return getFieldToNumber(Fields.LEFT_TORQUE_EFFECTIVENESS).map(Number::intValue).orElse(null);
    }

    /**
     * @param leftTorqueEffectiveness
     */
    public void setLeftTorqueEffectiveness(final Integer leftTorqueEffectiveness) {
        getOrAddField(Fields.LEFT_TORQUE_EFFECTIVENESS).setValue(leftTorqueEffectiveness);
    }

    /**
     * @return
     */
    public Integer getRightTorqueEffectiveness() {
        return getFieldToNumber(Fields.RIGHT_TORQUE_EFFECTIVENESS).map(Number::intValue).orElse(null);
    }

    /**
     * @param rightTorqueEffectiveness
     */
    public void setRightTorqueEffectiveness(final Integer rightTorqueEffectiveness) {
        getOrAddField(Fields.RIGHT_TORQUE_EFFECTIVENESS).setValue(rightTorqueEffectiveness);
    }

    /**
     * @return
     */
    public Integer getLeftPedalSmoothness() {
        return getFieldToNumber(Fields.LEFT_PEDAL_SMOOTHNESS).map(Number::intValue).orElse(null);
    }

    /**
     * @param leftPedalSmoothness
     */
    public void setLeftPedalSmoothness(final Integer leftPedalSmoothness) {
        getOrAddField(Fields.LEFT_PEDAL_SMOOTHNESS).setValue(leftPedalSmoothness);
    }

    /**
     * @return
     */
    public Integer getRightPedalSmoothness() {
        return getFieldToNumber(Fields.RIGHT_PEDAL_SMOOTHNESS).map(Number::intValue).orElse(null);
    }

    /**
     * @param rightPedalSmoothness
     */
    public void setRightPedalSmoothness(final Integer rightPedalSmoothness) {
        getOrAddField(Fields.RIGHT_PEDAL_SMOOTHNESS).setValue(rightPedalSmoothness);
    }

    /**
     * @return
     */
    public Integer getCombinedPedalSmoothness() {
        return getFieldToNumber(Fields.COMBINED_PEDAL_SMOOTHNESS).map(Number::intValue).orElse(null);
    }

    /**
     * @param combinedPedalSmoothness
     */
    public void setCombinedPedalSmoothness(final Integer combinedPedalSmoothness) {
        getOrAddField(Fields.COMBINED_PEDAL_SMOOTHNESS).setValue(combinedPedalSmoothness);
    }

    /**
     * @return
     */
    public Integer getTime128() {
        return getFieldToNumber(Fields.TIME128).map(Number::intValue).orElse(null);
    }

    /**
     * @param time128
     */
    public void setTime128(final Integer time128) {
        getOrAddField(Fields.TIME128).setValue(time128);
    }

    /**
     * @return
     */
    public Integer getStrokeType() {
        return getFieldToNumber(Fields.STROKE_TYPE).map(Number::intValue).orElse(null);
    }

    /**
     * @param strokeType
     */
    public void setStrokeType(final Integer strokeType) {
        getOrAddField(Fields.STROKE_TYPE).setValue(strokeType);
    }

    /**
     * @return
     */
    public Integer getZone() {
        return getFieldToNumber(Fields.ZONE).map(Number::intValue).orElse(null);
    }

    /**
     * @param zone
     */
    public void setZone(final Integer zone) {
        getOrAddField(Fields.ZONE).setValue(zone);
    }

    /**
     * @return
     */
    public Integer getBallSpeed() {
        return getFieldToNumber(Fields.BALL_SPEED).map(Number::intValue).orElse(null);
    }

    /**
     * @param ballSpeed
     */
    public void setBallSpeed(final Integer ballSpeed) {
        getOrAddField(Fields.BALL_SPEED).setValue(ballSpeed);
    }

    /**
     * @return
     */
    public Integer getCadence256() {
        return getFieldToNumber(Fields.CADENCE256).map(Number::intValue).orElse(null);
    }

    /**
     * @param cadence256
     */
    public void setCadence256(final Integer cadence256) {
        getOrAddField(Fields.CADENCE256).setValue(cadence256);
    }

    /**
     * @return
     */
    public Integer getFractionalCadence() {
        return getFieldToNumber(Fields.FRACTIONAL_CADENCE).map(Number::intValue).orElse(null);
    }

    /**
     * @param fractionalCadence
     */
    public void setFractionalCadence(final Integer fractionalCadence) {
        getOrAddField(Fields.FRACTIONAL_CADENCE).setValue(fractionalCadence);
    }

    /**
     * @return
     */
    public Integer getTotalHemoglobinConc() {
        return getFieldToNumber(Fields.TOTAL_HEMOGLOBIN_CONC).map(Number::intValue).orElse(null);
    }

    /**
     * @param totalHemoglobinConc
     */
    public void setTotalHemoglobinConc(final Integer totalHemoglobinConc) {
        getOrAddField(Fields.TOTAL_HEMOGLOBIN_CONC).setValue(totalHemoglobinConc);
    }

    /**
     * @return
     */
    public Integer getTotalHemoglobinConcMin() {
        return getFieldToNumber(Fields.TOTAL_HEMOGLOBIN_CONC_MIN).map(Number::intValue).orElse(null);
    }

    /**
     * @param totalHemoglobinConcMin
     */
    public void setTotalHemoglobinConcMin(final Integer totalHemoglobinConcMin) {
        getOrAddField(Fields.TOTAL_HEMOGLOBIN_CONC_MIN).setValue(totalHemoglobinConcMin);
    }

    /**
     * @return
     */
    public Integer getTotalHemoglobinConcMax() {
        return getFieldToNumber(Fields.TOTAL_HEMOGLOBIN_CONC_MAX).map(Number::intValue).orElse(null);
    }

    /**
     * @param totalHemoglobinConcMax
     */
    public void setTotalHemoglobinConcMax(final Integer totalHemoglobinConcMax) {
        getOrAddField(Fields.TOTAL_HEMOGLOBIN_CONC_MAX).setValue(totalHemoglobinConcMax);
    }

    /**
     * @return
     */
    public Integer getSaturatedHemoglobinPercent() {
        return getFieldToNumber(Fields.SATURATED_HEMOGLOBIN_PERCENT).map(Number::intValue).orElse(null);
    }

    /**
     * @param saturatedHemoglobinPercent
     */
    public void setSaturatedHemoglobinPercent(final Integer saturatedHemoglobinPercent) {
        getOrAddField(Fields.SATURATED_HEMOGLOBIN_PERCENT).setValue(saturatedHemoglobinPercent);
    }

    /**
     * @return
     */
    public Integer getSaturatedHemoglobinPercentMin() {
        return getFieldToNumber(Fields.SATURATED_HEMOGLOBIN_PERCENT_MIN).map(Number::intValue).orElse(null);
    }

    /**
     * @param saturatedHemoglobinPercentMin
     */
    public void setSaturatedHemoglobinPercentMin(final Integer saturatedHemoglobinPercentMin) {
        getOrAddField(Fields.SATURATED_HEMOGLOBIN_PERCENT_MIN).setValue(saturatedHemoglobinPercentMin);
    }

    /**
     * @return
     */
    public Integer getSaturatedHemoglobinPercentMax() {
        return getFieldToNumber(Fields.SATURATED_HEMOGLOBIN_PERCENT_MAX).map(Number::intValue).orElse(null);
    }

    /**
     * @param saturatedHemoglobinPercentMax
     */
    public void setSaturatedHemoglobinPercentMax(final Integer saturatedHemoglobinPercentMax) {
        getOrAddField(Fields.SATURATED_HEMOGLOBIN_PERCENT_MAX).setValue(saturatedHemoglobinPercentMax);
    }

    /**
     * @return
     */
    public Integer getDeviceIndex() {
        return getFieldToNumber(Fields.DEVICE_INDEX).map(Number::intValue).orElse(null);
    }

    /**
     * @param deviceIndex
     */
    public void setDeviceIndex(final Integer deviceIndex) {
        getOrAddField(Fields.DEVICE_INDEX).setValue(deviceIndex);
    }

    /**
     * @return
     */
    public Byte getLeftPco() {
        return getFieldToNumber(Fields.LEFT_PCO).map(Number::byteValue).orElse(null);
    }

    /**
     * @param leftPco
     */
    public void setLeftPco(final Byte leftPco) {
        getOrAddField(Fields.LEFT_PCO).setValue(leftPco);
    }

    /**
     * @return
     */
    public Byte getRightPco() {
        return getFieldToNumber(Fields.RIGHT_PCO).map(Number::byteValue).orElse(null);
    }

    /**
     * @param rightPco
     */
    public void setRightPco(final Byte rightPco) {
        getOrAddField(Fields.RIGHT_PCO).setValue(rightPco);
    }

    /**
     * @return
     */
    public Integer getLeftPowerPhase() {
        return getFieldToNumber(Fields.LEFT_POWER_PHASE).map(Number::intValue).orElse(null);
    }

    /**
     * @param leftPowerPhase
     */
    public void setLeftPowerPhase(final Integer leftPowerPhase) {
        getOrAddField(Fields.LEFT_POWER_PHASE).setValue(leftPowerPhase);
    }

    /**
     * @return
     */
    public Integer getLeftPowerPhasePeak() {
        return getFieldToNumber(Fields.LEFT_POWER_PHASE_PEAK).map(Number::intValue).orElse(null);
    }

    /**
     * @param leftPowerPhasePeak
     */
    public void setLeftPowerPhasePeak(final Integer leftPowerPhasePeak) {
        getOrAddField(Fields.LEFT_POWER_PHASE_PEAK).setValue(leftPowerPhasePeak);
    }

    /**
     * @return
     */
    public Integer getRightPowerPhase() {
        return getFieldToNumber(Fields.RIGHT_POWER_PHASE).map(Number::intValue).orElse(null);
    }

    /**
     * @param rightPowerPhase
     */
    public void setRightPowerPhase(final Integer rightPowerPhase) {
        getOrAddField(Fields.RIGHT_POWER_PHASE).setValue(rightPowerPhase);
    }

    /**
     * @return
     */
    public Integer getRightPowerPhasePeak() {
        return getFieldToNumber(Fields.RIGHT_POWER_PHASE_PEAK).map(Number::intValue).orElse(null);
    }

    /**
     * @param rightPowerPhasePeak
     */
    public void setRightPowerPhasePeak(final Integer rightPowerPhasePeak) {
        getOrAddField(Fields.RIGHT_POWER_PHASE_PEAK).setValue(rightPowerPhasePeak);
    }

    /**
     * @return
     */
    public Long getEnhancedSpeed() {
        return getFieldToNumber(Fields.ENHANCED_SPEED).map(Number::longValue).orElse(null);
    }

    /**
     * @param enhancedSpeed
     */
    public void setEnhancedSpeed(final Long enhancedSpeed) {
        getOrAddField(Fields.ENHANCED_SPEED).setValue(enhancedSpeed);
    }

    /**
     * @return
     */
    public Long getEnhancedAltitude() {
        return getFieldToNumber(Fields.ENHANCED_ALTITUDE).map(Number::longValue).orElse(null);
    }

    /**
     * @param enhancedAltitude
     */
    public void setEnhancedAltitude(final Long enhancedAltitude) {
        getOrAddField(Fields.ENHANCED_ALTITUDE).setValue(enhancedAltitude);
    }

    /**
     * @return
     */
    public Integer getBatterySoc() {
        return getFieldToNumber(Fields.BATTERY_SOC).map(Number::intValue).orElse(null);
    }

    /**
     * @param batterySoc
     */
    public void setBatterySoc(final Integer batterySoc) {
        getOrAddField(Fields.BATTERY_SOC).setValue(batterySoc);
    }

    /**
     * @return
     */
    public Integer getMotorPower() {
        return getFieldToNumber(Fields.MOTOR_POWER).map(Number::intValue).orElse(null);
    }

    /**
     * @param motorPower
     */
    public void setMotorPower(final Integer motorPower) {
        getOrAddField(Fields.MOTOR_POWER).setValue(motorPower);
    }

}
