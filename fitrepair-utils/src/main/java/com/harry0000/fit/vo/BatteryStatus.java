package com.harry0000.fit.vo;

public enum BatteryStatus implements ValueObject<Integer> {
    NEW(1),
    GOOD(2),
    OK(3),
    LOW(4),
    CRITICAL(5),
    UNKNOWN(7);

    /**
     * @param value
     * @return
     */
    public static BatteryStatus get(final Integer value) {
        return VoUtils.get(BatteryStatus.values(), value);
    }

    private final int value;

    /**
     * @param value
     */
    private BatteryStatus(final int value) {
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
