package com.wellbeat.sampleapp.dto.integration.v1;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;

public class CustomDataRequestDto {
    @NotNull
    @Size(min = 2)
    private String version;
    @NotNull
    @Size(min = 2)
    private String participantExternalId;
    @NotNull
    @Size(min = 2)
    private String accountCode;
    @NotNull
    @Size(min = 2)
    private String documentType;
    private Map<String, Object> data;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getParticipantExternalId() {
        return participantExternalId;
    }

    public void setParticipantExternalId(String participantExternalId) {
        this.participantExternalId = participantExternalId;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
