package com.wellbeat.sampleapp.dto.integration.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;

@ApiModel(value = "Organisation", description = "Wellbeat Organisation")
@Schema
public class OrganisationDto {
    @Schema(description = "Unique identifier", type = "string")
    private String uuid;
    @Schema(description = "Name", type = "string")
    private String name;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
