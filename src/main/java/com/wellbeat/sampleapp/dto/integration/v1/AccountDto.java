package com.wellbeat.sampleapp.dto.integration.v1;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Wellbeat Account")
public class AccountDto {
    @Schema(description = "Unique Code")
    private String accountCode;
    @Schema(description = "Name")
    private String accountName;

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
