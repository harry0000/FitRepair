package com.harry0000.fit.vo;

public enum Language implements ValueObject<Integer> {
    ENGLISH(0),
    FRENCH(1),
    ITALIAN(2),
    GERMAN(3),
    SPANISH(4),
    CROATIAN(5),
    CZECH(6),
    DANISH(7),
    DUTCH(8),
    FINNISH(9),
    GREEK(10),
    HUNGARIAN(11),
    NORWEGIAN(12),
    POLISH(13),
    PORTUGUESE(14),
    SLOVAKIAN(15),
    SLOVENIAN(16),
    SWEDISH(17),
    RUSSIAN(18),
    TURKISH(19),
    LATVIAN(20),
    UKRAINIAN(21),
    ARABIC(22),
    FARSI(23),
    BULGARIAN(24),
    ROMANIAN(25),
    CUSTOM(254);

    /**
     * @param value
     * @return
     */
    public static Language get(final Integer value) {
        return VoUtils.get(Language.values(), value);
    }

    private final int value;

    /**
     * @param value
     */
    private Language(final int value) {
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
