package org.plovdev.sgoclient.exceptions;

public class SGORequestException extends SGOCleintException {
    public SGORequestException() {
    }

    public SGORequestException(String message) {
        super(message);
    }

    public SGORequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public SGORequestException(Throwable cause) {
        super(cause);
    }

    public SGORequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}