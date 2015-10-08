package com.harry0000.fit.vo;

public enum SourceType implements ValueObject<Integer> {
    ANT(0),
    ANTPLUS(1),
    BLUETOOTH(2),
    BLUETOOTH_LOW_ENERGY(3),
    WIFI(4),
    LOCAL(5);

    /**
     * @param value
     * @return
     */
    public static SourceType get(final Integer value) {
        return VoUtils.get(SourceType.values(), value);
    }

    private final int value;

    /**
     * @param value
     */
    private SourceType(final int value) {
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
