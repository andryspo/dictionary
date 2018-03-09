package com.andryspo.exception;

public class SessionExpiredException extends RuntimeException {

    public SessionExpiredException() {
    }

    public SessionExpiredException(String message) {
        super(message);
    }
}
