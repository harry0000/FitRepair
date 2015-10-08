package com.harry0000.fit.vo;

public enum LengthType implements ValueObject<Integer> {
    IDLE(0),
    ACTIVE(1);

    /**
     * @param value
     * @return
     */
    public static LengthType get(final Integer value) {
        return VoUtils.get(LengthType.values(), value);
    }

    private final int value;

    /**
     * @param value
     */
    private LengthType(final int value) {
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
