package com.cozwork.application.exceptions;

public enum ExceptionCode {
    INVALID_USERNAME(ErrorCode.CD_8282_001, "User name not found"),
    INVALID_PASSWORD(ErrorCode.CD_8282_002, "Password is incorrect"),
    USER_INACTIVE(ErrorCode.CD_8282_003, "User is inactive"),
    USERNAME_EXIST(ErrorCode.CD_8282_004, "Username is already exist"),
    INVALID_UPLOAD_FILE_TYPE(ErrorCode.CD_8282_005, "Only image upload are allowed");

    private final Integer code;
    private final String message;

    ExceptionCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
