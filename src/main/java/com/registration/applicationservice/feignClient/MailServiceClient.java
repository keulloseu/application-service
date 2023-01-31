package com.registration.applicationservice.feignClient;

import com.registration.applicationservice.model.SendEmailsRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "mail-service", url = "${mail_service.url}")
public interface MailServiceClient {
    @PostMapping(value = "/api/email/sender")
    void sendEmails(@RequestBody SendEmailsRequest emails);
}
