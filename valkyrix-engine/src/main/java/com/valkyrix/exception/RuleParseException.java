package com.valkyrix.exception;

public class RuleParseException extends RuntimeException {
    public RuleParseException(String message) {
        super(message);
    }

    public RuleParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
