package com.harry0000.fit.vo;

public enum SessionTrigger implements ValueObject<Integer> {
    ACTIVITY_END(0),
    MANUAL(1),
    AUTO_MULTI_SPORT(2),
    FITNESS_EQUIPMENT(3);

    /**
     * @param value
     * @return
     */
    public static SessionTrigger get(final int value) {
        return VoUtils.get(SessionTrigger.values(), value);
    }

    private final int value;

    /**
     * @param value
     */
    private SessionTrigger(final int value) {
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
