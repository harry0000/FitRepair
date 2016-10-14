package com.harry0000.fit.message;

import static com.harry0000.fit.Constants.FIELD_MESSAGE_INDEX;

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
    public String getFriendlyName() {
        return getFieldToString(Fields.FRIENDLY_NAME).orElse(null);
    }

    /**
     * @param friendlyName
     */
    public void setFriendlyName(final String friendlyName) {
        getOrAddField(Fields.FRIENDLY_NAME).setValue(friendlyName);
    }

    /**
     * @return
     */
    public Integer getGender() {
        return getFieldToNumber(Fields.GENDER).map(Number::intValue).orElse(null);
    }

    /**
     * @param gender
     */
    public void setGender(final Integer gender) {
        getOrAddField(Fields.GENDER).setValue(gender);
    }

    /**
     * @return
     */
    public Integer getAge() {
        return getFieldToNumber(Fields.AGE).map(Number::intValue).orElse(null);
    }

    /**
     * @param age
     */
    public void setAge(final Integer age) {
        getOrAddField(Fields.AGE).setValue(age);
    }

    /**
     * @return
     */
    public Integer getHeight() {
        return getFieldToNumber(Fields.HEIGHT).map(Number::intValue).orElse(null);
    }

    /**
     * @param height
     */
    public void setHeight(final Integer height) {
        getOrAddField(Fields.HEIGHT).setValue(height);
    }

    /**
     * @return
     */
    public Integer getWeight() {
        return getFieldToNumber(Fields.WEIGHT).map(Number::intValue).orElse(null);
    }

    /**
     * @param weight
     */
    public void setWeight(final Integer weight) {
        getOrAddField(Fields.WEIGHT).setValue(weight);
    }

    /**
     * @return
     */
    public Integer getLanguage() {
        return getFieldToNumber(Fields.LANGUAGE).map(Number::intValue).orElse(null);
    }

    /**
     * @param language
     */
    public void setLanguage(final Integer language) {
        getOrAddField(Fields.LANGUAGE).setValue(language);
    }

    /**
     * @return
     */
    public Integer getElevSetting() {
        return getFieldToNumber(Fields.ELEV_SETTING).map(Number::intValue).orElse(null);
    }

    /**
     * @param elevSetting
     */
    public void setElevSetting(final Integer elevSetting) {
        getOrAddField(Fields.ELEV_SETTING).setValue(elevSetting);
    }

    /**
     * @return
     */
    public Integer getWeightSetting() {
        return getFieldToNumber(Fields.WEIGHT_SETTING).map(Number::intValue).orElse(null);
    }

    /**
     * @param weightSetting
     */
    public void setWeightSetting(final Integer weightSetting) {
        getOrAddField(Fields.WEIGHT_SETTING).setValue(weightSetting);
    }

    /**
     * @return
     */
    public Integer getRestingHeartRate() {
        return getFieldToNumber(Fields.RESTING_HEART_RATE).map(Number::intValue).orElse(null);
    }

    /**
     * @param restingHeartRate
     */
    public void setRestingHeartRate(final Integer restingHeartRate) {
        getOrAddField(Fields.RESTING_HEART_RATE).setValue(restingHeartRate);
    }

    /**
     * @return
     */
    public Integer getDefaultMaxRunningHeartRate() {
        return getFieldToNumber(Fields.DEFAULT_MAX_RUNNING_HEART_RATE).map(Number::intValue).orElse(null);
    }

    /**
     * @param defaultMaxRunningHeartRate
     */
    public void setDefaultMaxRunningHeartRate(final Integer defaultMaxRunningHeartRate) {
        getOrAddField(Fields.DEFAULT_MAX_RUNNING_HEART_RATE).setValue(defaultMaxRunningHeartRate);
    }

    /**
     * @return
     */
    public Integer getDefaultMaxBikingHeartRate() {
        return getFieldToNumber(Fields.DEFAULT_MAX_BIKING_HEART_RATE).map(Number::intValue).orElse(null);
    }

    /**
     * @param defaultMaxBikingHeartRate
     */
    public void setDefaultMaxBikingHeartRate(final Integer defaultMaxBikingHeartRate) {
        getOrAddField(Fields.DEFAULT_MAX_BIKING_HEART_RATE).setValue(defaultMaxBikingHeartRate);
    }

    /**
     * @return
     */
    public Integer getDefaultMaxHeartRate() {
        return getFieldToNumber(Fields.DEFAULT_MAX_HEART_RATE).map(Number::intValue).orElse(null);
    }

    /**
     * @param defaultMaxHeartRate
     */
    public void setDefaultMaxHeartRate(final Integer defaultMaxHeartRate) {
        getOrAddField(Fields.DEFAULT_MAX_HEART_RATE).setValue(defaultMaxHeartRate);
    }

    /**
     * @return
     */
    public Integer getHrSetting() {
        return getFieldToNumber(Fields.HR_SETTING).map(Number::intValue).orElse(null);
    }

    /**
     * @param hrSetting
     */
    public void setHrSetting(final Integer hrSetting) {
        getOrAddField(Fields.HR_SETTING).setValue(hrSetting);
    }

    /**
     * @return
     */
    public Integer getSpeedSetting() {
        return getFieldToNumber(Fields.SPEED_SETTING).map(Number::intValue).orElse(null);
    }

    /**
     * @param speedSetting
     */
    public void setSpeedSetting(final Integer speedSetting) {
        getOrAddField(Fields.SPEED_SETTING).setValue(speedSetting);
    }

    /**
     * @return
     */
    public Integer getDistSetting() {
        return getFieldToNumber(Fields.DIST_SETTING).map(Number::intValue).orElse(null);
    }

    /**
     * @param distSetting
     */
    public void setDistSetting(final Integer distSetting) {
        getOrAddField(Fields.DIST_SETTING).setValue(distSetting);
    }

    /**
     * @return
     */
    public Integer getPowerSetting() {
        return getFieldToNumber(Fields.POWER_SETTING).map(Number::intValue).orElse(null);
    }

    /**
     * @param powerSetting
     */
    public void setPowerSetting(final Integer powerSetting) {
        getOrAddField(Fields.POWER_SETTING).setValue(powerSetting);
    }

    /**
     * @return
     */
    public Integer getActivityClass() {
        return getFieldToNumber(Fields.ACTIVITY_CLASS).map(Number::intValue).orElse(null);
    }

    /**
     * @param activityClass
     */
    public void setActivityClass(final Integer activityClass) {
        getOrAddField(Fields.ACTIVITY_CLASS).setValue(activityClass);
    }

    /**
     * @return
     */
    public Integer getPositionSetting() {
        return getFieldToNumber(Fields.POSITION_SETTING).map(Number::intValue).orElse(null);
    }

    /**
     * @param positionSetting
     */
    public void setPositionSetting(final Integer positionSetting) {
        getOrAddField(Fields.POSITION_SETTING).setValue(positionSetting);
    }

    /**
     * @return
     */
    public Integer getTemperatureSetting() {
        return getFieldToNumber(Fields.TEMPERATURE_SETTING).map(Number::intValue).orElse(null);
    }

    /**
     * @param temperatureSetting
     */
    public void setTemperatureSetting(final Integer temperatureSetting) {
        getOrAddField(Fields.TEMPERATURE_SETTING).setValue(temperatureSetting);
    }

    /**
     * @return
     */
    public Integer getLocalId() {
        return getFieldToNumber(Fields.LOCAL_ID).map(Number::intValue).orElse(null);
    }

    /**
     * @param localId
     */
    public void setLocalId(final Integer localId) {
        getOrAddField(Fields.LOCAL_ID).setValue(localId);
    }

    /**
     * @return
     */
    public Integer getGlobalId() {
        return getFieldToNumber(Fields.GLOBAL_ID).map(Number::intValue).orElse(null);
    }

    /**
     * @param globalId
     */
    public void setGlobalId(final Integer globalId) {
        getOrAddField(Fields.GLOBAL_ID).setValue(globalId);
    }

    /**
     * @return
     */
    public Integer getHeightSetting() {
        return getFieldToNumber(Fields.HEIGHT_SETTING).map(Number::intValue).orElse(null);
    }

    /**
     * @param heightSetting
     */
    public void setHeightSetting(final Integer heightSetting) {
        getOrAddField(Fields.HEIGHT_SETTING).setValue(heightSetting);
    }

}
