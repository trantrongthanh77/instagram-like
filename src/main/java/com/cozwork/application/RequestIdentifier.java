package com.cozwork.application;

import java.io.Serializable;
import java.util.UUID;

public class RequestIdentifier implements Serializable {

    private String correlationId;
    private String requestId;

    public RequestIdentifier() {
    }

    /**
     * Set random request identifier (only if the values of request id and correlation id are null)
     */
    public static RequestIdentifier randRequestIdentifier() {
        RequestIdentifier requestIdentifier = new RequestIdentifier();
        requestIdentifier.setRequestId(UUID.randomUUID().toString());
        requestIdentifier.setCorrelationId(UUID.randomUUID().toString());
        return requestIdentifier;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}