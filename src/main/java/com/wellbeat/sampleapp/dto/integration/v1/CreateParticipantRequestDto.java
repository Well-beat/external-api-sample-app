package com.wellbeat.sampleapp.dto.integration.v1;


import com.wellbeat.sampleapp.util.validators.EnumValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "Participant Create Request", description = "Request to create Wellbeat participant")
@Schema
public class CreateParticipantRequestDto {
    @Schema(required = true, description = "Participant external identifier")
    @NotNull
    @Size(min = 2)
    private String participantExternalId;
    @Schema(required = true, description = "Gender value: MALE or FEMALE")
    @NotNull
    @EnumValidator(
            enumClazz = Gender.class,
            message = "Invalid gender value."
    )
    private String gender;
    @Schema(required = true, description = "Participant communication language")
    @NotNull
    @EnumValidator(
            enumClazz = Language.class,
            message = "Invalid language value."
    )
    private String language;
    @Schema(required = false, description = "First name")
    private String firstName;
    @Schema(required = false, description = "Last name")
    private String lastName;
    @Schema(required = false, description = "Phone number")
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getParticipantExternalId() {
        return participantExternalId;
    }

    public void setParticipantExternalId(String participantExternalId) {
        this.participantExternalId = participantExternalId;
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
}
