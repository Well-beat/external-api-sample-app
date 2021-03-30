package com.wellbeat.sampleapp.dto.integration.v1;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Participant toolbar entry such as: 'watch out', 'motivation', 'barrier' etc")
public class ToolbarEntryDto {
    @Schema(description = "Entry type")
    private ToolbarEntryType type;
    @Schema(description = "Entry name")
    private String name;
    @Schema(description = "Entry value")
    private String value;

    public ToolbarEntryType getType() {
        return type;
    }

    public void setType(ToolbarEntryType type) {
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
