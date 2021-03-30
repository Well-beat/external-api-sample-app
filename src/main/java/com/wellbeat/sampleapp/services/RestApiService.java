package com.wellbeat.sampleapp.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wellbeat.sampleapp.dto.integration.v1.*;
import com.wellbeat.sampleapp.util.RestResponsePage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestApiService {
    public static final String API_TOKEN_HEADER = "X-API-Key";
    public static final String ORG_PATH = "/integration/rest/api/v1/organisation";
    public static final String ACCOUNT_PATH = "/integration/rest/api/v1/account";
    public static final String PARTICIPANT_PATH = "/integration/rest/api/v1/participant";
    private final RestTemplate restTemplate;

    @Value("${wellbeat.integration.pm-service-url}")
    private String wellbeatUrl;
    @Value("${wellbeat.integration.token}")
    private String token;

    public OrganisationDto getOrganisation() throws URISyntaxException {
        HttpHeaders headers = createHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<OrganisationDto> response = restTemplate.exchange(new URI(wellbeatUrl + ORG_PATH), HttpMethod.GET, requestEntity, OrganisationDto.class);
        return response.getBody();
    }

    public List<AccountDto> getOrganisationAccounts() throws URISyntaxException {
        HttpHeaders headers = createHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<List<AccountDto>> response = restTemplate.exchange(new URI(wellbeatUrl + ACCOUNT_PATH), HttpMethod.GET, requestEntity, new ParameterizedTypeReference<>() {
        });
        return response.getBody();
    }

    public List<MotivationalMessageDto> getAccountMotivationalMessages(String accountCode) throws URISyntaxException {
        HttpHeaders headers = createHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<List<MotivationalMessageDto>> response = restTemplate.exchange(
                new URI(wellbeatUrl + ACCOUNT_PATH+"/"+accountCode+"/message/motivational"), HttpMethod.GET, requestEntity, new ParameterizedTypeReference<>() {
        });
        return response.getBody();
    }

    public ParticipantDto createParticipant(String accountCode, CreateParticipantRequestDto requestDto) throws URISyntaxException {
        HttpHeaders headers = createHeaders();
        HttpEntity<CreateParticipantRequestDto> requestEntity = new HttpEntity<>(requestDto, headers);
        return restTemplate.exchange(new URI(wellbeatUrl + ACCOUNT_PATH+"/"+accountCode+"/participant"), HttpMethod.POST, requestEntity, ParticipantDto.class).getBody();
    }

    public Page<ParticipantDto> searchParticipants(String query, Integer page, Integer countOnPage, String sortBy, Sort.Direction direction) {
        HttpHeaders headers = createHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        HashMap<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("size", countOnPage);
        uriVariables.put("page", page);
        uriVariables.put("q", query);
        uriVariables.put("sortBy", sortBy);
        uriVariables.put("direction", direction.name());
        ResponseEntity<RestResponsePage<ParticipantDto>> response = restTemplate.exchange(wellbeatUrl + PARTICIPANT_PATH, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<>() {
        }, uriVariables);
        return response.getBody();
    }

    public ParticipantDto getParticipant(String accountCode, String participantId) throws URISyntaxException {
        HttpHeaders headers = createHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<ParticipantDto> response = restTemplate.exchange(new URI(getParticipantPath(accountCode, participantId)), HttpMethod.GET, requestEntity, ParticipantDto.class);
        return response.getBody();
    }

    public ParticipantToolbarDto getParticipantToolbar(String accountCode, String participantId) throws URISyntaxException {
        HttpHeaders headers = createHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<ParticipantToolbarDto> response = restTemplate.exchange(new URI(getParticipantPath(accountCode, participantId)+"/toolbar"), HttpMethod.GET, requestEntity, ParticipantToolbarDto.class);
        return response.getBody();

    }

    public ParticipantStatusDto getParticipantStatus(String accountCode, String participantId) throws URISyntaxException {
        HttpHeaders headers = createHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<ParticipantStatusDto> response = restTemplate.exchange(new URI(getParticipantPath(accountCode, participantId)+"/status"), HttpMethod.GET, requestEntity, ParticipantStatusDto.class);
        return response.getBody();

    }

    public void sendMotivationalMessage(String accountCode, String participantId, SendMotivationalMessageRequestDto requestDto) throws URISyntaxException {
        HttpHeaders headers = createHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<>(requestDto, headers);
        ResponseEntity<String> response = restTemplate.exchange(new URI(getParticipantPath(accountCode, participantId)+"/message/motivational"), HttpMethod.POST, requestEntity, String.class);

    }

    private String getParticipantPath(String accountCode, String participantId) {
        return wellbeatUrl + ACCOUNT_PATH+"/"+accountCode+"/participant/"+participantId;
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(API_TOKEN_HEADER, token);
        return headers;
    }

}
