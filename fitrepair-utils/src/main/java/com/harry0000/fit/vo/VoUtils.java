package com.harry0000.fit.vo;

class VoUtils {

    /**
     * @param values
     * @param value
     * @return
     */
    public static <T extends Number, E extends ValueObject<T>> E get(final E[] values, final T value) {
        if (value == null) {
            return null;
        }

        for (final E e : values) {
            if (e.getValue() == value) {
                return e;
            }
        }
        return null;
    }

    private VoUtils() {}
}
