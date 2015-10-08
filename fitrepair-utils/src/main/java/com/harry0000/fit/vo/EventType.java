package com.harry0000.fit.vo;

public enum EventType implements ValueObject<Integer> {
    START(0),
    STOP(1),
    CONSECUTIVE_DEPRECIATED(2),
    MARKER(3),
    STOP_ALL(4),
    BEGIN_DEPRECIATED(5),
    END_DEPRECIATED(6),
    END_ALL_DEPRECIATED(7),
    STOP_DISABLE(8),
    STOP_DISABLE_ALL(9);

    /**
     * @param value
     * @return
     */
    public static EventType get(final Integer value) {
        return VoUtils.get(EventType.values(), value);
    }

    private final int value;

    /**
     * @param value
     */
    private EventType(final int value) {
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
