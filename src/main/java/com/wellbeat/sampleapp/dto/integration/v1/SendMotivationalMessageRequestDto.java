package com.wellbeat.sampleapp.dto.integration.v1;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request to send motivation message for participant")
public class SendMotivationalMessageRequestDto {
    @Schema(description = "Motivational target value", required = true)
    private String messageValue;

    public String getMessageValue() {
        return messageValue;
    }

    public void setMessageValue(String messageValue) {
        this.messageValue = messageValue;
    }
}
