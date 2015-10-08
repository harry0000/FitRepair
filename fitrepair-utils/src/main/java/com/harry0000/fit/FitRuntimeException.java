package com.harry0000.fit;

public class FitRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * @param message
     */
    public FitRuntimeException(final String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public FitRuntimeException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
