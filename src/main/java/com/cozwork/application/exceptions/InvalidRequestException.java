package com.cozwork.application.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class InvalidRequestException extends ExceptionZ {

    private static final Logger logger = LoggerFactory.getLogger(InvalidRequestException.class);

    public InvalidRequestException(String message) {
        super(message);
        logger.info("[INVALID REQUEST EXCEPTION]: {}", message);
        this.setExceptionType(ExceptionType.INVALID_REQUEST_EXCEPTION);
        this.setHttpStatus(HttpStatus.BAD_REQUEST);
    }

    public InvalidRequestException(ExceptionCode errorCode) {
        super(errorCode.getCode(), errorCode.getMessage());
        logger.info("[INVALID REQUEST EXCEPTION] -> code: {}, message: {}", errorCode.getCode(), errorCode.getMessage());
        this.setExceptionType(ExceptionType.INVALID_REQUEST_EXCEPTION);
        this.setHttpStatus(HttpStatus.BAD_REQUEST);
    }

    public InvalidRequestException(ExceptionCode errorCode, String message) {
        super(errorCode.getCode(), message);
        logger.info("[INVALID REQUEST EXCEPTION] -> code: {}, message: {}", errorCode.getCode(), message);
        this.setExceptionType(ExceptionType.INVALID_REQUEST_EXCEPTION);
        this.setHttpStatus(HttpStatus.BAD_REQUEST);
    }
}

