package org.js.vocaapi.util;

public class CustomJWTException extends RuntimeException {
    public CustomJWTException(String msg) {
        super(msg);
    }
}