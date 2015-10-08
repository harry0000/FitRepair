package com.harry0000.fit.vo;

public enum Sport implements ValueObject<Integer> {
    GENERIC(0),
    RUNNING(1),
    CYCLING(2),
    TRANSITION(3),
    FITNESS_EQUIPMENT(4),
    SWIMMING(5),
    BASKETBALL(6),
    SOCCER(7),
    TENNIS(8),
    AMERICAN_FOOTBALL(9),
    TRAINING(10),
    WALKING(11),
    CROSS_COUNTRY_SKIING(12),
    ALPINE_SKIING(13),
    SNOWBOARDING(14),
    ROWING(15),
    MOUNTAINEERING(16),
    HIKING(17),
    MULTISPORT(18),
    PADDLING(19),
    FLYING(20),
    E_BIKING(21),
    MOTORCYCLING(22),
    BOATING(23),
    DRIVING(24),
    GOLF(25),
    HANG_GLIDING(26),
    HORSEBACK_RIDING(27),
    HUNTING(28),
    FISHING(29),
    INLINE_SKATING(30),
    ROCK_CLIMBING(31),
    SAILING(32),
    ICE_SKATING(33),
    SKY_DIVING(34),
    SNOWSHOEING(35),
    SNOWMOBILING(36),
    STAND_UP_PADDLEBOARDING(37),
    SURFING(38),
    WAKEBOARDING(39),
    WATER_SKIING(40),
    KAYAKING(41),
    RAFTING(42),
    WINDSURFING(43),
    KITESURFING(44),
    ALL(254);

    /**
     * @param value
     * @return
     */
    public static Sport get(final Integer value) {
        return VoUtils.get(Sport.values(), value);
    }

    private final int value;

    /**
     * @param value
     */
    private Sport(final int value) {
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
