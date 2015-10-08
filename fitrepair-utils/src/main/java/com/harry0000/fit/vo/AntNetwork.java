package com.harry0000.fit.vo;

public enum AntNetwork implements ValueObject<Integer> {
    PUBLIC(0),
    ANTPLUS(1),
    ANTFS(2),
    PRIVATE(3);

    /**
     * @param value
     * @return
     */
    public static AntNetwork get(final Integer value) {
        return VoUtils.get(AntNetwork.values(), value);
    }

    private final int value;

    /**
     * @param value
     */
    private AntNetwork(final int value) {
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
