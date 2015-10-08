package com.harry0000.fit.vo;

public enum FileType implements ValueObject<Integer> {
    DEVICE(1), 
    SETTINGS(2), 
    SPORT(3), 
    ACTIVITY(4), 
    WORKOUT(5), 
    COURSE(6), 
    SCHEDULES(7), 
    WEIGHT(9), 
    TOTALS(10), 
    GOALS(11), 
    BLOOD_PRESSURE(14), 
    MONITORING_A(15), 
    ACTIVITY_SUMMARY(20), 
    MONITORING_DAILY(28), 
    MONITORING_B(32), 
    SEGMENT(34), 
    SEGMENT_LIST(35);
/*
    MFG_RANGE_MIN(0x00F7), 
    MFG_RANGE_MAX(0x00FE), 
    INVALID(-1);
*/

    /**
     * @param value
     * @return
     */
    public static FileType get(final Integer value) {
        return VoUtils.get(FileType.values(), value);
    }

    private final int value;

    /**
     * @param value
     */
    private FileType(final int value) {
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
