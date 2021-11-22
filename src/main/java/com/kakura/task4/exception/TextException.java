package com.kakura.task4.exception;

import java.lang.Exception;

public class TextException extends Exception {
    public TextException() {
        super();
    }

    public TextException(String message) {
        super(message);
    }

    public TextException(Exception e) {
        super(e);
    }

    public TextException(String message, Exception e) {
        super(message, e);
    }
}
