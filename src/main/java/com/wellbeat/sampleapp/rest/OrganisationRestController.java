package com.wellbeat.sampleapp.rest;

import com.wellbeat.sampleapp.dto.integration.v1.OrganisationDto;
import com.wellbeat.sampleapp.services.RestApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/rest/api/v1/organisation")
@RequiredArgsConstructor
public class OrganisationRestController {
    private final RestApiService restApiService;

    @GetMapping
    public OrganisationDto getOrganisation() throws URISyntaxException {
        return restApiService.getOrganisation();
    }
    
}
