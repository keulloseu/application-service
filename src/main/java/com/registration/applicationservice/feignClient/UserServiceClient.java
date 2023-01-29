package com.registration.applicationservice.feignClient;

import com.registration.applicationservice.dto.EmailDto;
import com.registration.applicationservice.model.EmailListRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "user-service", url = "${user_service.url}")
public interface UserServiceClient {

    @GetMapping(value = "/api/emails")
    ResponseEntity<List<EmailDto>> getEmails(@RequestBody EmailListRequest userIds);
}
