package com.wellbeat.sampleapp.dto.integration.v1;

import io.swagger.v3.oas.annotations.media.Schema;

public class ParticipantDto {
    @Schema(required = true, description = "External identifier")
    private String participantExternalId;
    @Schema(description = "Internal wellbeat code")
    private String participantCode;
    @Schema(required = true, description = "Gender value")
    private String gender;
    @Schema(required = true, description = "Participant communication language")
    private String language;
    @Schema(required = false, description = "First name")
    private String firstName;
    @Schema(required = false, description = "Last name")
    private String lastName;
    @Schema(required = false, description = "Phone number")
    private String phoneNumber;
    @Schema(description = "Status")
    private ParticipantStatus participantStatus;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ParticipantStatus getParticipantStatus() {
        return participantStatus;
    }

    public void setParticipantStatus(ParticipantStatus participantStatus) {
        this.participantStatus = participantStatus;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
