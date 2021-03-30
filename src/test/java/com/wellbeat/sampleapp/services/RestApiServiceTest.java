package com.wellbeat.sampleapp.services;

import com.wellbeat.sampleapp.dto.integration.v1.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestApiServiceTest {
    @Autowired
    private RestApiService restApiService;

    @Test
    void getOrganisation() throws URISyntaxException {
        OrganisationDto organisationDto = restApiService.getOrganisation();
        System.currentTimeMillis();
    }

    @Test
    void getOrganisationAccounts() throws URISyntaxException {
        List<AccountDto> organisationAccounts = restApiService.getOrganisationAccounts();
        System.currentTimeMillis();
    }

    @Test
    void getAccountMotivationalMessages() throws URISyntaxException {
        String accountCode = "EXTAPI";
        List<MotivationalMessageDto> organisationAccounts = restApiService.getAccountMotivationalMessages(accountCode);
        System.currentTimeMillis();
    }

    @Test
    void searchParticipants() throws URISyntaxException {
        Page<ParticipantDto> participantDtos = restApiService.searchParticipants("", 0, 20, "id", Sort.Direction.ASC);
        System.currentTimeMillis();
    }

    @Test
    void getParticipant() throws URISyntaxException {
        String accountCode = "EXTAPI";
        String participantId= "X1";
        ParticipantDto participantDto = restApiService.getParticipant(accountCode, participantId);
        System.currentTimeMillis();
    }

    @Test
    void getParticipantToolbar() throws URISyntaxException {
        String accountCode = "EXTAPI";
        String participantId= "X1";
        ParticipantToolbarDto participantDto = restApiService.getParticipantToolbar(accountCode, participantId);
        System.currentTimeMillis();
    }

    @Test
    void getParticipantStatus() throws URISyntaxException {
        String accountCode = "EXTAPI";
        String participantId= "X1";
        ParticipantStatusDto participantDto = restApiService.getParticipantStatus(accountCode, participantId);
        System.currentTimeMillis();
    }
}