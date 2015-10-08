package com.harry0000.fit.vo;

public enum LapTrigger implements ValueObject<Integer> {
    MANUAL(0),
    TIME(1),
    DISTANCE(2),
    POSITION_START(3),
    POSITION_LAP(4),
    POSITION_WAYPOINT(5),
    POSITION_MARKED(6),
    SESSION_END(7),
    FITNESS_EQUIPMENT(8);

    /**
     * @param value
     * @return
     */
    public static LapTrigger get(final int value) {
        return VoUtils.get(LapTrigger.values(), value);
    }

    private int value;

    /**
     * @param value
     */
    private LapTrigger(final int value) {
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
