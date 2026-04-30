package org.plovdev.sgo.exceptions;

public class SGOCleintException extends RuntimeException {
    public SGOCleintException() {
    }

    public SGOCleintException(String message) {
        super(message);
    }

    public SGOCleintException(String message, Throwable cause) {
        super(message, cause);
    }

    public SGOCleintException(Throwable cause) {
        super(cause);
    }

    public SGOCleintException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}