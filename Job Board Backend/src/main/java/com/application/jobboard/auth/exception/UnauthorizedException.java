package com.application.jobboard.auth.exception;

public class UnauthorizedException extends RuntimeException{

    public static final String MESSAGE = "Unauthorized";

    public UnauthorizedException() {
        super(MESSAGE);
    }

    public UnauthorizedException(Exception e) {
        super(MESSAGE, e);
    }


}
