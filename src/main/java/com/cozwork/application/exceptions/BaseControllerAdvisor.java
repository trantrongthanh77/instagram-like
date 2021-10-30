package com.cozwork.application.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global handler of exceptions
 */
@ControllerAdvice
public class BaseControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<Object> handleException(ExceptionZ ex, WebRequest request) {
        return new ResponseEntity<>(ex.bodyBuild(), ex.getHttpStatus());
    }
}