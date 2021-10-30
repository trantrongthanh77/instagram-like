package com.cozwork.application.exceptions;

import com.cozwork.application.RequestIdentifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

public class UnauthorizedException extends OAuth2Exception {

    private RequestIdentifier requestIdentifier;
    private LocalDateTime timestamp;
    private Integer code;
    private String message;
    private String debugMessage;
    private HttpStatus httpStatus;

    public UnauthorizedException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.code = exceptionCode.getCode();
        this.message = exceptionCode.getMessage();
        this.httpStatus = HttpStatus.UNAUTHORIZED;
        this.timestamp = LocalDateTime.now();
        this.requestIdentifier = RequestIdentifier.randRequestIdentifier();
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public RequestIdentifier getRequestIdentifier() {
        return requestIdentifier;
    }

    public void setRequestIdentifier(RequestIdentifier requestIdentifier) {
        this.requestIdentifier = requestIdentifier;
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


    public Map<String, Object> bodyBuild() {
        Map<String, Object> body = new LinkedHashMap<>();
        Map<String, Object> error = new LinkedHashMap<>();
        error.put("timestamp", this.getTimestamp().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));
        error.put("error_code", this.getCode());
        error.put("message", this.getMessage());
        error.put("debug_message", this.getDebugMessage());
        body.put("request_id", requestIdentifier.getRequestId());
        body.put("error", error);
        return body;
    }
}