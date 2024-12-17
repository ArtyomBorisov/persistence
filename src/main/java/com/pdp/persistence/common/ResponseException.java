package com.pdp.persistence.common;

import org.springframework.http.HttpStatus;

public record ResponseException(HttpStatus status,
                                String message) {
}
