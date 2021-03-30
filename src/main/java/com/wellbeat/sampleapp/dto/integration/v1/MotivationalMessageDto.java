package com.wellbeat.sampleapp.dto.integration.v1;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Motivational message with specific target")
public class MotivationalMessageDto {
    @Schema(description = "Message target value")
    private String value;
    @Schema(description = "Message target description")
    private String description;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
