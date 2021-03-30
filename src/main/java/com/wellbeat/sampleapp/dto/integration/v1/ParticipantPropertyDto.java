package com.wellbeat.sampleapp.dto.integration.v1;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Participant property")
public class ParticipantPropertyDto {
    @Schema(description = "Property type")
    private ParticipantPropertyType type;
    @Schema(description = "Property name")
    private String name;
    @Schema(description = "Property value")
    private String value;

    public ParticipantPropertyType getType() {
        return type;
    }

    public void setType(ParticipantPropertyType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
