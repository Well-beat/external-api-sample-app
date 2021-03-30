package com.wellbeat.sampleapp.dto.integration.v1;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class ErrorResponseDto {
    @Schema(description = "Error code")
    private String code;
    @Schema(description = "User friendly message")
    private String message;
    @Schema(description = "Timestamp of error")
    private Date timestamp;
    @Schema(description = "Application trace identifier")
    private String traceId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
