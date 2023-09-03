package com.application.jobboard.auth.exception;



public class NoAuthData extends RuntimeException {

    private static final String MESSAGE = "No auth data provided";

    public NoAuthData() {
        super(MESSAGE);
    }

}
