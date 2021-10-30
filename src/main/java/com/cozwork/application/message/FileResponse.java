package com.cozwork.application.message;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileResponse extends Response {

    @JsonProperty("path")
    private String path;

    public FileResponse() {
    }

    public FileResponse(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}