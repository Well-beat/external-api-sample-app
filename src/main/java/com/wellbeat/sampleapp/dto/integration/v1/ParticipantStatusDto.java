package com.wellbeat.sampleapp.dto.integration.v1;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Participant status information")
public class ParticipantStatusDto {
    @Schema(required = true, description = "External identifier")
    private String participantExternalId;
    @Schema(description = "Internal wellbeat code")
    private String participantCode;
    @Schema(description = "Metrics values")
    private List<ParticipantPropertyDto> metrics;
    @Schema(description = "Conflict indicators")
    private List<ParticipantPropertyDto> conflicts;
    @Schema(description = "Warnings")
    private List<ParticipantPropertyDto> warnings;

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

    public List<ParticipantPropertyDto> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<ParticipantPropertyDto> metrics) {
        this.metrics = metrics;
    }

    public List<ParticipantPropertyDto> getConflicts() {
        return conflicts;
    }

    public void setConflicts(List<ParticipantPropertyDto> conflicts) {
        this.conflicts = conflicts;
    }

    public List<ParticipantPropertyDto> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<ParticipantPropertyDto> warnings) {
        this.warnings = warnings;
    }
}
