package com.registration.applicationservice.controller;

import com.registration.applicationservice.dto.ApplicationDto;
import com.registration.applicationservice.model.ApplicationCreationRequest;
import com.registration.applicationservice.repository.ApplicationRepository;
import com.registration.applicationservice.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/application")
public class ApplicationController {

    private final ApplicationService applicationService;
    private final ApplicationRepository applicationRepository;

    @GetMapping
    public ResponseEntity<List<ApplicationDto>> getUserApplications(@RequestParam(value = "userId") Long userId) {
        return ResponseEntity.ok(applicationService.getUserApplications(userId));
    }

    @PostMapping
    public ResponseEntity<String> postApplication(@RequestBody ApplicationCreationRequest request, @RequestParam Long userId) {
        return applicationService.postApplication(request, userId);
    }

    @DeleteMapping
    public void deleteApplication(@RequestParam("appId") Long appId) {
        applicationRepository.deleteById(appId);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ApplicationDto>> getAllApplications() {
        return ResponseEntity.ok(applicationService.getAllApplications());
    }
}
