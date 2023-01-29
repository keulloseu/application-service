package com.registration.applicationservice.controller;

import com.registration.applicationservice.dto.EmailDto;
import com.registration.applicationservice.model.EmailListRequest;
import com.registration.applicationservice.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-service")
@RequiredArgsConstructor
public class UserController {
    private final MailService mailService;

    @GetMapping
    public ResponseEntity<List<EmailDto>> getEmailsToSend(@RequestBody EmailListRequest emailListRequest) {
        return ResponseEntity.ok(mailService.findEmailsByUserIds());
    }
}
