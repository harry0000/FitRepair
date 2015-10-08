package com.harry0000.fit.vo;

public enum Gender implements ValueObject<Integer> {
    FEMALE(0),
    MALE(1);

    /**
     * @param value
     * @return
     */
    public static Gender get(final Integer value) {
        return VoUtils.get(Gender.values(), value);
    }

    private final int value;

    /**
     * @param value
     */
    private Gender(final int value) {
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
