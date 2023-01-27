package com.registration.applicationservice.service;

import com.registration.applicationservice.dto.ApplicationDto;
import com.registration.applicationservice.feignClient.UserServiceClient;
import com.registration.applicationservice.mapper.ApplicationEntityMapper;
import com.registration.applicationservice.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserServiceClient userServiceClient;
    private final ApplicationRepository applicationRepository;
    private final ApplicationEntityMapper applicationEntityMapper;

    public List<ApplicationDto> findAllApplicationsByUserId() {
        return applicationRepository
                .findAllByUserId(userServiceClient.getId())
                .stream()
                .map(applicationEntityMapper::applicationToDto)
                .toList();
    }
}
