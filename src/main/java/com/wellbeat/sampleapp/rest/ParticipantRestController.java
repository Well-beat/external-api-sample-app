package com.wellbeat.sampleapp.rest;


import com.wellbeat.sampleapp.dto.integration.sqs.CustomDataMessageDto;
import com.wellbeat.sampleapp.dto.integration.v1.*;
import com.wellbeat.sampleapp.services.RestApiService;
import com.wellbeat.sampleapp.services.SqsMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/rest/api/v1/account/{accountCode}/participant/{participantId}")
@RequiredArgsConstructor
public class ParticipantRestController {
    private final RestApiService restApiService;
    private final SqsMessageService sqsMessageService;
    @GetMapping
    public ParticipantDto getParticipantDetail(@PathVariable String accountCode, @PathVariable String participantId) throws URISyntaxException {
        return restApiService.getParticipant(accountCode, participantId);
    }
    @GetMapping(value = "toolbar")
    public ParticipantToolbarDto getParticipantToolbar(@PathVariable String accountCode, @PathVariable String participantId) throws URISyntaxException {
        return restApiService.getParticipantToolbar(accountCode, participantId);
    }
    @GetMapping(value = "status")
    public ParticipantStatusDto getParticipantStatus(@PathVariable String accountCode, @PathVariable String participantId) throws URISyntaxException {
        return restApiService.getParticipantStatus(accountCode, participantId);
    }
    @PostMapping(value = "custom-data")
    public void postCustomData(@PathVariable String accountCode, @PathVariable String participantId, @RequestBody @Valid CustomDataRequestDto messageDto) {
        messageDto.setAccountCode(accountCode);
        messageDto.setParticipantExternalId(participantId);
        sqsMessageService.sendCustomData(messageDto);
    }

    @PostMapping(value = "message/motivational")
    public void sendMotivationalMessage(@PathVariable String accountCode, @PathVariable String participantId, @RequestBody @Valid SendMotivationalMessageRequestDto requestDto) throws URISyntaxException {
        restApiService.sendMotivationalMessage(accountCode, participantId, requestDto);
    }
}
