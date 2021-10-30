package com.cozwork.application.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class ExceptionZ extends Exception {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionZ.class);

    private LocalDateTime timestamp;
    private Integer code;
    private String message;
    private String debugMessage;
    private ExceptionType exceptionType;
    private HttpStatus httpStatus;

    public ExceptionZ() {
        logger.info("[EXCEPTION Z] default.");
        this.timestamp = LocalDateTime.now();
        this.exceptionType = ExceptionType.UNKNOWN_EXCEPTION;
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public ExceptionZ(Integer code, String message) {
        this();
        logger.info("[EXCEPTION Z] code: {}, message: {}", code, message);
        this.code = code;
        this.message = message;
    }



    public ExceptionZ(String message) {
        this();
        logger.info("[EXCEPTION Z] message: {}", message);
        this.message = message;
    }

    public ExceptionZ(String message, String debugMessage) {
        this(message);
        logger.info("[EXCEPTION Z] debugMessage: {}", debugMessage);
        this.debugMessage = debugMessage;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public ExceptionType getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    public Map<String, Object> bodyBuild() {
        Map<String, Object> body = new LinkedHashMap<>();
        Map<String, Object> error = new LinkedHashMap<>();
        error.put("timestamp", this.getTimestamp().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));
        error.put("error_code", this.getCode());
        error.put("message", this.getMessage());
        error.put("debug_message", this.getDebugMessage());
        error.put("exception_type", this.getExceptionType().name());
        body.put("error", error);
        return body;
    }
}
