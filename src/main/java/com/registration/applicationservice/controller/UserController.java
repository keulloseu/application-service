package com.registration.applicationservice.controller;

import com.registration.applicationservice.dto.EmailDto;
import com.registration.applicationservice.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class UserController {
    private final MailService mailService;

    @PostMapping("/rejected")
    public ResponseEntity<List<EmailDto>> getEmailsForRejected() {
        return mailService.findEmailsForRejectedApps();
    }

    @PostMapping("/accepted")
    public ResponseEntity<List<EmailDto>> getEmailsForAccepted() {
        return mailService.findEmailsForAcceptedApps();
    }
}
