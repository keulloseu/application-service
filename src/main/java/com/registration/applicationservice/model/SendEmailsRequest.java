package com.registration.applicationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SendEmailsRequest {
    private List<String> emails;
}
