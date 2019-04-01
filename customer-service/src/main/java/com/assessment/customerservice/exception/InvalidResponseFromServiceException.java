package com.assessment.customerservice.exception;

public class InvalidResponseFromServiceException extends Exception {
    public InvalidResponseFromServiceException() {
        super();
    }

    public InvalidResponseFromServiceException(String message) {
        super(message);
    }

    public InvalidResponseFromServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidResponseFromServiceException(Throwable cause) {
        super(cause);
    }

    protected InvalidResponseFromServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
