package com.harry0000.fit.vo;

public enum ActivityType implements ValueObject<Integer> {
    GENERIC(0),
    RUNNING(1),
    CYCLING(2),
    TRANSITION(3),
    FITNESS_EQUIPMENT(4),
    SWIMMING(5),
    WALKING(6),
    ALL(254);

    /**
     * @param value
     * @return
     */
    public static ActivityType get(final int value) {
        return VoUtils.get(ActivityType.values(), value);
    }

    private final int value;

    /**
     * @param value
     */
    private ActivityType(final int value) {
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
