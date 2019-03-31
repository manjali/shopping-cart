package com.assessment.skuservice.exception;

public class InsufficientNumberException extends Exception {
    public InsufficientNumberException() {
    }

    public InsufficientNumberException(String message) {
        super(message);
    }
}
