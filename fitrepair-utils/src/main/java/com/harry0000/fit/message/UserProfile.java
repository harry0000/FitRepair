package com.harry0000.fit.message;

import static com.harry0000.fit.Constants.FIELD_MESSAGE_INDEX;

import com.harry0000.fit.field.Field;
import com.harry0000.fit.vo.BaseType;

public class UserProfile extends DataMessage {

    public enum Fields implements FieldProfile {
        FRIENDLY_NAME                 (0,  BaseType.STRING),
        GENDER                        (1,  BaseType.ENUM),
        AGE                           (2,  BaseType.UINT8),
        HEIGHT                        (3,  BaseType.UINT8),
        WEIGHT                        (4,  BaseType.UINT16),
        LANGUAGE                      (5,  BaseType.ENUM),
        ELEV_SETTING                  (6,  BaseType.ENUM),
        WEIGHT_SETTING                (7,  BaseType.ENUM),
        RESTING_HEART_RATE            (8,  BaseType.UINT8),
        DEFAULT_MAX_RUNNING_HEART_RATE(9,  BaseType.UINT8),
        DEFAULT_MAX_BIKING_HEART_RATE (10, BaseType.UINT8),
        DEFAULT_MAX_HEART_RATE        (11, BaseType.UINT8),
        HR_SETTING                    (12, BaseType.ENUM),
        SPEED_SETTING                 (13, BaseType.ENUM),
        DIST_SETTING                  (14, BaseType.ENUM),
        POWER_SETTING                 (16, BaseType.ENUM),
        ACTIVITY_CLASS                (17, BaseType.ENUM),
        POSITION_SETTING              (18, BaseType.ENUM),
        TEMPERATURE_SETTING           (21, BaseType.ENUM),
        LOCAL_ID                      (22, BaseType.UINT16),
        GLOBAL_ID                     (23, BaseType.BYTE),
        HEIGHT_SETTING                (30, BaseType.ENUM);

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
    public UserProfile(final DataMessage msg) {
        super(msg);
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
    public String getFriendlyName() {
        return getFieldToString(Fields.FRIENDLY_NAME);
    }

    /**
     * @param friendlyName
     */
    public void setFriendlyName(final String friendlyName) {
        final Field<?> f = getOrAddField(Fields.FRIENDLY_NAME);
        f.setValue(friendlyName);
    }

    /**
     * @return
     */
    public Integer getGender() {
        final Number value = getFieldToNumber(Fields.GENDER);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param gender
     */
    public void setGender(final Integer gender) {
        final Field<?> f = getOrAddField(Fields.GENDER);
        f.setValue(gender);
    }

    /**
     * @return
     */
    public Integer getAge() {
        final Number value = getFieldToNumber(Fields.AGE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param age
     */
    public void setAge(final Integer age) {
        final Field<?> f = getOrAddField(Fields.AGE);
        f.setValue(age);
    }

    /**
     * @return
     */
    public Integer getHeight() {
        final Number value = getFieldToNumber(Fields.HEIGHT);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param height
     */
    public void setHeight(final Integer height) {
        final Field<?> f = getOrAddField(Fields.HEIGHT);
        f.setValue(height);
    }

    /**
     * @return
     */
    public Integer getWeight() {
        final Number value = getFieldToNumber(Fields.WEIGHT);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param weight
     */
    public void setWeight(final Integer weight) {
        final Field<?> f = getOrAddField(Fields.WEIGHT);
        f.setValue(weight);
    }

    /**
     * @return
     */
    public Integer getLanguage() {
        final Number value = getFieldToNumber(Fields.LANGUAGE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param language
     */
    public void setLanguage(final Integer language) {
        final Field<?> f = getOrAddField(Fields.LANGUAGE);
        f.setValue(language);
    }

    /**
     * @return
     */
    public Integer getElevSetting() {
        final Number value = getFieldToNumber(Fields.ELEV_SETTING);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param elevSetting
     */
    public void setElevSetting(final Integer elevSetting) {
        final Field<?> f = getOrAddField(Fields.ELEV_SETTING);
        f.setValue(elevSetting);
    }

    /**
     * @return
     */
    public Integer getWeightSetting() {
        final Number value = getFieldToNumber(Fields.WEIGHT_SETTING);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param weightSetting
     */
    public void setWeightSetting(final Integer weightSetting) {
        final Field<?> f = getOrAddField(Fields.WEIGHT_SETTING);
        f.setValue(weightSetting);
    }

    /**
     * @return
     */
    public Integer getRestingHeartRate() {
        final Number value = getFieldToNumber(Fields.RESTING_HEART_RATE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param restingHeartRate
     */
    public void setRestingHeartRate(final Integer restingHeartRate) {
        final Field<?> f = getOrAddField(Fields.RESTING_HEART_RATE);
        f.setValue(restingHeartRate);
    }

    /**
     * @return
     */
    public Integer getDefaultMaxRunningHeartRate() {
        final Number value = getFieldToNumber(Fields.DEFAULT_MAX_RUNNING_HEART_RATE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param defaultMaxRunningHeartRate
     */
    public void setDefaultMaxRunningHeartRate(final Integer defaultMaxRunningHeartRate) {
        final Field<?> f = getOrAddField(Fields.DEFAULT_MAX_RUNNING_HEART_RATE);
        f.setValue(defaultMaxRunningHeartRate);
    }

    /**
     * @return
     */
    public Integer getDefaultMaxBikingHeartRate() {
        final Number value = getFieldToNumber(Fields.DEFAULT_MAX_BIKING_HEART_RATE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param defaultMaxBikingHeartRate
     */
    public void setDefaultMaxBikingHeartRate(final Integer defaultMaxBikingHeartRate) {
        final Field<?> f = getOrAddField(Fields.DEFAULT_MAX_BIKING_HEART_RATE);
        f.setValue(defaultMaxBikingHeartRate);
    }

    /**
     * @return
     */
    public Integer getDefaultMaxHeartRate() {
        final Number value = getFieldToNumber(Fields.DEFAULT_MAX_HEART_RATE);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param defaultMaxHeartRate
     */
    public void setDefaultMaxHeartRate(final Integer defaultMaxHeartRate) {
        final Field<?> f = getOrAddField(Fields.DEFAULT_MAX_HEART_RATE);
        f.setValue(defaultMaxHeartRate);
    }

    /**
     * @return
     */
    public Integer getHrSetting() {
        final Number value = getFieldToNumber(Fields.HR_SETTING);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param hrSetting
     */
    public void setHrSetting(final Integer hrSetting) {
        final Field<?> f = getOrAddField(Fields.HR_SETTING);
        f.setValue(hrSetting);
    }

    /**
     * @return
     */
    public Integer getSpeedSetting() {
        final Number value = getFieldToNumber(Fields.SPEED_SETTING);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param speedSetting
     */
    public void setSpeedSetting(final Integer speedSetting) {
        final Field<?> f = getOrAddField(Fields.SPEED_SETTING);
        f.setValue(speedSetting);
    }

    /**
     * @return
     */
    public Integer getDistSetting() {
        final Number value = getFieldToNumber(Fields.DIST_SETTING);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param distSetting
     */
    public void setDistSetting(final Integer distSetting) {
        final Field<?> f = getOrAddField(Fields.DIST_SETTING);
        f.setValue(distSetting);
    }

    /**
     * @return
     */
    public Integer getPowerSetting() {
        final Number value = getFieldToNumber(Fields.POWER_SETTING);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param powerSetting
     */
    public void setPowerSetting(final Integer powerSetting) {
        final Field<?> f = getOrAddField(Fields.POWER_SETTING);
        f.setValue(powerSetting);
    }

    /**
     * @return
     */
    public Integer getActivityClass() {
        final Number value = getFieldToNumber(Fields.ACTIVITY_CLASS);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param activityClass
     */
    public void setActivityClass(final Integer activityClass) {
        final Field<?> f = getOrAddField(Fields.ACTIVITY_CLASS);
        f.setValue(activityClass);
    }

    /**
     * @return
     */
    public Integer getPositionSetting() {
        final Number value = getFieldToNumber(Fields.POSITION_SETTING);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param positionSetting
     */
    public void setPositionSetting(final Integer positionSetting) {
        final Field<?> f = getOrAddField(Fields.POSITION_SETTING);
        f.setValue(positionSetting);
    }

    /**
     * @return
     */
    public Integer getTemperatureSetting() {
        final Number value = getFieldToNumber(Fields.TEMPERATURE_SETTING);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param temperatureSetting
     */
    public void setTemperatureSetting(final Integer temperatureSetting) {
        final Field<?> f = getOrAddField(Fields.TEMPERATURE_SETTING);
        f.setValue(temperatureSetting);
    }

    /**
     * @return
     */
    public Integer getLocalId() {
        final Number value = getFieldToNumber(Fields.LOCAL_ID);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param localId
     */
    public void setLocalId(final Integer localId) {
        final Field<?> f = getOrAddField(Fields.LOCAL_ID);
        f.setValue(localId);
    }

    /**
     * @return
     */
    public Integer getGlobalId() {
        final Number value = getFieldToNumber(Fields.GLOBAL_ID);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param globalId
     */
    public void setGlobalId(final Integer globalId) {
        final Field<?> f = getOrAddField(Fields.GLOBAL_ID);
        f.setValue(globalId);
    }

    /**
     * @return
     */
    public Integer getHeightSetting() {
        final Number value = getFieldToNumber(Fields.HEIGHT_SETTING);

        return value != null ? value.intValue() : null;
    }

    /**
     * @param heightSetting
     */
    public void setHeightSetting(final Integer heightSetting) {
        final Field<?> f = getOrAddField(Fields.HEIGHT_SETTING);
        f.setValue(heightSetting);
    }

}
