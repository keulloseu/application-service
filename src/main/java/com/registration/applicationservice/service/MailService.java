package com.registration.applicationservice.service;

import com.registration.applicationservice.dto.EmailDto;
import com.registration.applicationservice.entity.ApplicationEntity;
import com.registration.applicationservice.feignClient.UserServiceClient;
import com.registration.applicationservice.model.ApplicationStatus;
import com.registration.applicationservice.model.EmailListRequest;
import com.registration.applicationservice.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MailService {
    private final UserServiceClient userServiceClient;
    private final ApplicationRepository applicationRepository;

    public ResponseEntity<List<EmailDto>> findEmailsForRejectedApps() {
        EmailListRequest userIds = new EmailListRequest(applicationRepository
                .findAllByStatus(ApplicationStatus.REJECTED)
                .stream()
                .map(ApplicationEntity::getUserId).toList());
        return userServiceClient.getEmails(userIds);
    }

    public ResponseEntity<List<EmailDto>> findEmailsForAcceptedApps() {
        EmailListRequest userIds = new EmailListRequest(applicationRepository
                .findAllByStatus(ApplicationStatus.ACCEPTED)
                .stream()
                .map(ApplicationEntity::getUserId).toList());
        return userServiceClient.getEmails(userIds);
    }
}
