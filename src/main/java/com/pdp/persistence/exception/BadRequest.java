package com.pdp.persistence.exception;

public class BadRequest extends RuntimeException {

    public BadRequest(String message) {
        super(message);
    }
}
