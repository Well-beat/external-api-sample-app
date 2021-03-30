package com.wellbeat.sampleapp.dto.integration.v1;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Participant toolbar values")
public class ParticipantToolbarDto {
    @Schema(required = true, description = "External identifier")
    private String participantExternalId;
    @Schema(description = "Internal wellbeat code")
    private String participantCode;
    @Schema(description = "Toolbar values")
    private List<ToolbarEntryDto> values;

    public String getParticipantExternalId() {
        return participantExternalId;
    }

    public void setParticipantExternalId(String participantExternalId) {
        this.participantExternalId = participantExternalId;
    }

    public String getParticipantCode() {
        return participantCode;
    }

    public void setParticipantCode(String participantCode) {
        this.participantCode = participantCode;
    }

    public List<ToolbarEntryDto> getValues() {
        return values;
    }

    public void setValues(List<ToolbarEntryDto> values) {
        this.values = values;
    }
}
