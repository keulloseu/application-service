package com.registration.applicationservice.controller;

import com.registration.applicationservice.dto.EmailDto;
import com.registration.applicationservice.model.EmailListRequest;
import com.registration.applicationservice.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class UserController {
    private final MailService mailService;

    @PostMapping
    public ResponseEntity<List<EmailDto>> getEmailsToSend() {
        return mailService.findEmailsByUserIds();
    }
}
