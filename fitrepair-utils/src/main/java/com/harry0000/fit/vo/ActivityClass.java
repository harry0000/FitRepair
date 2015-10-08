package com.harry0000.fit.vo;

public enum ActivityClass implements ValueObject<Integer> {
    LEVEL_MAX(100),
    LEVEL(0x7F),
    ATHLETE(0x80);

    /**
     * @param value
     * @return
     */
    public static ActivityClass get(final Integer value) {
        return VoUtils.get(ActivityClass.values(), value);
    }

    private final int value;

    /**
     * @param value
     */
    private ActivityClass(final int value) {
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
