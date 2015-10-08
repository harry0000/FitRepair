package com.harry0000.fit.vo;

public enum SubSport implements ValueObject<Integer> {
    GENERIC(0),
    TREADMILL(1),
    STREET(2),
    TRAIL(3),
    TRACK(4),
    SPIN(5),
    INDOOR_CYCLING(6),
    ROAD(7),
    MOUNTAIN(8),
    DOWNHILL(9),
    RECUMBENT(10),
    CYCLOCROSS(11),
    HAND_CYCLING(12),
    TRACK_CYCLING(13),
    INDOOR_ROWING(14),
    ELLIPTICAL(15),
    STAIR_CLIMBING(16),
    LAP_SWIMMING(17),
    OPEN_WATER(18),
    FLEXIBILITY_TRAINING(19),
    STRENGTH_TRAINING(20),
    WARM_UP(21),
    MATCH(22),
    EXERCISE(23),
    CHALLENGE(24),
    INDOOR_SKIING(25),
    CARDIO_TRAINING(26),
    INDOOR_WALKING(27),
    E_BIKE_FITNESS(28),
    BMX(29),
    CASUAL_WALKING(30),
    SPEED_WALKING(31),
    BIKE_TO_RUN_TRANSITION(32),
    RUN_TO_BIKE_TRANSITION(33),
    SWIM_TO_BIKE_TRANSITION(34),
    ATV(35),
    MOTOCROSS(36),
    BACKCOUNTRY(37),
    RESORT(38),
    RC_DRONE(39),
    WINGSUIT(40),
    WHITEWATER(41),
    ALL(254);

    /**
     * @param value
     * @return
     */
    public static SubSport get(final int value) {
        return VoUtils.get(SubSport.values(), value);
    }

    private final int value;

    /**
     * @param value
     */
    private SubSport(final int value) {
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
