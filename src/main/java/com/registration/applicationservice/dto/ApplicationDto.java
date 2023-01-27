package com.registration.applicationservice.dto;

import com.registration.applicationservice.model.ApplicationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApplicationDto {
    private Double totalScore;
    private ApplicationStatus status;
    private String courseName;
}
