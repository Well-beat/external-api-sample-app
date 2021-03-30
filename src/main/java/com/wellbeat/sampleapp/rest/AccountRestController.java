package com.wellbeat.sampleapp.rest;


import com.wellbeat.sampleapp.dto.integration.v1.AccountDto;
import com.wellbeat.sampleapp.dto.integration.v1.CreateParticipantRequestDto;
import com.wellbeat.sampleapp.dto.integration.v1.MotivationalMessageDto;
import com.wellbeat.sampleapp.dto.integration.v1.ParticipantDto;
import com.wellbeat.sampleapp.services.RestApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/rest/api/v1/account")
@RequiredArgsConstructor
public class AccountRestController {
    private final RestApiService restApiService;

    @GetMapping
    public List<AccountDto> getAccounts() throws URISyntaxException {
        return restApiService.getOrganisationAccounts();
    }

    @GetMapping(value = "{accountCode}/message/motivational")
    public List<MotivationalMessageDto> getAccountMotivationalMessages(@PathVariable String accountCode) throws URISyntaxException {
        return restApiService.getAccountMotivationalMessages(accountCode);
    }
    @PostMapping
    public ParticipantDto createParticipant(@PathVariable String accountCode, @RequestBody @Valid CreateParticipantRequestDto requestDto) throws URISyntaxException {
        return restApiService.createParticipant(accountCode, requestDto);
    }
}
