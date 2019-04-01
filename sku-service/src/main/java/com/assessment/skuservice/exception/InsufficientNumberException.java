package com.assessment.skuservice.exception;

public class InsufficientNumberException extends Exception {
    public InsufficientNumberException() {
        super();
    }

    public InsufficientNumberException(String message) {
        super(message);
    }

    public InsufficientNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsufficientNumberException(Throwable cause) {
        super(cause);
    }

    protected InsufficientNumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
