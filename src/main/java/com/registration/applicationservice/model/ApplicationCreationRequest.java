package com.registration.applicationservice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationCreationRequest {
    @Schema(example = "Medycyna")
    private String courseName;
    @Schema(example = "[]")
    private Set<Subject> subjectsWithScore;
}
