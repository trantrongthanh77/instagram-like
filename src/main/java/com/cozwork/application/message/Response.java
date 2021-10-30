package com.cozwork.application.message;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Response {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}