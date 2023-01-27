package com.registration.applicationservice.dto;

import com.registration.applicationservice.entity.ReqSubjectEntity;
import com.registration.applicationservice.model.ReqSubject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseDto {
    private String courseName;
    private List<ReqSubject> reqSubjects;
}
