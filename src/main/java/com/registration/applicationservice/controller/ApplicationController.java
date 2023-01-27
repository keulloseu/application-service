package com.registration.applicationservice.controller;

import com.registration.applicationservice.dto.ApplicationDto;
import com.registration.applicationservice.entity.ApplicationEntity;
import com.registration.applicationservice.model.ApplicationCreationRequest;
import com.registration.applicationservice.model.PaginationRequest;
import com.registration.applicationservice.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/application")
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping
    public ResponseEntity<List<ApplicationDto>> getUserApplications(@RequestParam(value = "userId") Long userId) {
        return ResponseEntity.ok(applicationService.getUserApplications(userId));
    }

    @PostMapping
    public ResponseEntity<String> postApplication(@RequestBody ApplicationCreationRequest request, @RequestParam Long userId) {
        return applicationService.postApplication(request, userId);
    }


///////////////////////////////////////////////////////////////

    @GetMapping("/all")
    public ResponseEntity<Page<ApplicationEntity>> getAllApplications(@RequestBody PaginationRequest request) {
        return ResponseEntity.ok(applicationService.getAllApplications(request.getPageNumber(), request.getPageSize()));
    }
}
