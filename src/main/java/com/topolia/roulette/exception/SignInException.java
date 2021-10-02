package com.topolia.roulette.exception;

public class SignInException extends Exception{
    public SignInException() {
    }

    public SignInException(String message) {
        super(message);
    }

    public SignInException(String message, Throwable cause) {
        super(message, cause);
    }

    public SignInException(Throwable cause) {
        super(cause);
    }

    public SignInException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
