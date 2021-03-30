package com.wellbeat.sampleapp.rest;

import com.wellbeat.sampleapp.dto.integration.v1.ParticipantDto;
import com.wellbeat.sampleapp.services.RestApiService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/v1/participant")
@RequiredArgsConstructor
public class ParticipantSearchRestController {
    private static final String DEFAULT_PAGE_SIZE = "20";
    private final RestApiService restApiService;

    @GetMapping
    public ResponseEntity<Page<ParticipantDto>> search(@Schema(description = "Page size") @RequestParam(value = "size", required = false, defaultValue = DEFAULT_PAGE_SIZE) Integer pageSize,
                                                       @Schema(description = "Page number") @RequestParam(value = "page", required = false, defaultValue = "0") Integer pageNumber,
                                                       @Schema(description = "Search query") @RequestParam(value = "q", required = false, defaultValue = "") String criteria,
                                                       @Schema(description = "Sort property") @RequestParam(value = "sortBy", required = false, defaultValue = "") String sortBy,
                                                       @Schema(description = "Sort direction") @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        return ResponseEntity.ok(restApiService.searchParticipants(criteria, pageNumber, pageSize, sortBy, direction));

    }

}