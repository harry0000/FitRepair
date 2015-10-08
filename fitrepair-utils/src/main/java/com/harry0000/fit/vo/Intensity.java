package com.harry0000.fit.vo;

public enum Intensity implements ValueObject<Integer> {
    ACTIVE(0),
    REST(1),
    WARMUP(2),
    COOLDOWN(3);

    /**
     * @param value
     * @return
     */
    public static Intensity get(final int value) {
        return VoUtils.get(Intensity.values(), value);
    }

    private final int value;

    /**
     * @param value
     */
    private Intensity(final int value) {
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
