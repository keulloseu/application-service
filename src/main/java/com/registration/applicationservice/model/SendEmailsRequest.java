package com.registration.applicationservice.model;

import com.registration.applicationservice.dto.EmailDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SendEmailsRequest {
    private List<EmailDto> accepted;
    private List<EmailDto> rejected;
}
