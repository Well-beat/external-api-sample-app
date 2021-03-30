package com.wellbeat.sampleapp.dto.integration.sqs;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CustomDataMessageDto.class, name = "custom-data")
})
public abstract class AbstractSqsMessage {
    private String version;

    public abstract SqsMessageType getMessageType();

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
