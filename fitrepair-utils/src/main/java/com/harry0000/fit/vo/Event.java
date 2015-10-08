package com.harry0000.fit.vo;

public enum Event implements ValueObject<Integer> {
    TIMER(0),
    WORKOUT(3),
    WORKOUT_STEP(4),
    POWER_DOWN(5),
    POWER_UP(6),
    OFF_COURSE(7),
    SESSION(8),
    LAP(9),
    COURSE_POINT(10),
    BATTERY(11),
    VIRTUAL_PARTNER_PACE(12),
    HR_HIGH_ALERT(13),
    HR_LOW_ALERT(14),
    SPEED_HIGH_ALERT(15),
    SPEED_LOW_ALERT(16),
    CAD_HIGH_ALERT(17),
    CAD_LOW_ALERT(18),
    POWER_HIGH_ALERT(19),
    POWER_LOW_ALERT(20),
    RECOVERY_HR(21),
    BATTERY_LOW(22),
    TIME_DURATION_ALERT(23),
    DISTANCE_DURATION_ALERT(24),
    CALORIE_DURATION_ALERT(25),
    ACTIVITY(26),
    FITNESS_EQUIPMENT(27),
    LENGTH(28),
    USER_MARKER(32),
    SPORT_POINT(33),
    CALIBRATION(36),
    FRONT_GEAR_CHANGE(42),
    REAR_GEAR_CHANGE(43),
    RIDER_POSITION_CHANGE(44),
    ELEV_HIGH_ALERT(45),
    ELEV_LOW_ALERT(46),
    COMM_TIMEOUT(47);

    /**
     * @param value
     * @return
     */
    public static Event get(final Integer value) {
        return VoUtils.get(Event.values(), value);
    }

    private final int value;

    /**
     * @param value
     */
    private Event(final int value) {
        this.value = value;
    }

    /* (non-Javadoc)
     * @see com.harry0000.Fit.vo.ValueObject#getValue()
     */
    @Override
    public Integer getValue() {
        return value;
    }

}
