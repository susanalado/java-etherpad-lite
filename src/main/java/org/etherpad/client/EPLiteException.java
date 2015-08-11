package org.etherpad.client;

public class EPLiteException extends RuntimeException {
    public EPLiteException(String message) {
        super(message);
    }

    public EPLiteException(String message, Throwable cause) {
        super(cause);
    }
}