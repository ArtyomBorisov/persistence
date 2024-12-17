package com.pdp.persistence.controller.advice;

import com.pdp.persistence.common.ResponseException;
import com.pdp.persistence.exception.NotFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseException missedRequestParamHandler(MissingServletRequestParameterException e) {
        final var message = String.format("Пропущен request param %s", e.getParameterName());
        return buildResponseException(HttpStatus.BAD_REQUEST, message);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFound.class, HttpMessageNotReadableException.class})
    public ResponseException notFoundHandler(RuntimeException e) {
        return buildResponseException(HttpStatus.NOT_FOUND, e.getMessage());
    }

    private ResponseException buildResponseException(HttpStatus status, String message) {
        log.error(message);
        return new ResponseException(status, message);
    }
}
