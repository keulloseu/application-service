package com.registration.applicationservice.service;

import com.registration.applicationservice.dto.ApplicationDto;
import com.registration.applicationservice.entity.ApplicationEntity;
import com.registration.applicationservice.entity.CourseEntity;
import com.registration.applicationservice.mapper.ApplicationEntityMapper;
import com.registration.applicationservice.model.ApplicationCreationRequest;
import com.registration.applicationservice.model.ApplicationStatus;
import com.registration.applicationservice.model.Subject;
import com.registration.applicationservice.repository.ApplicationRepository;
import com.registration.applicationservice.repository.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final CourseRepository courseRepository;
    private final ApplicationRepository applicationRepository;
    private final ApplicationEntityMapper applicationEntityMapper;

    public ResponseEntity<String> postApplication(ApplicationCreationRequest request, Long userId) {
        applicationRepository.save(createApplication(request, userId));
        return ResponseEntity.ok("Created successfully.");
    }

    public List<ApplicationDto> getUserApplications(Long userId) {
        return applicationRepository.findAllByUserId(userId).stream().map(applicationEntityMapper::applicationToDto).toList();
    }

    public List<ApplicationDto> getAllApplications() {
        return applicationRepository.findAll().stream().map(applicationEntityMapper::applicationToDto).toList();
    }

    private ApplicationEntity createApplication(ApplicationCreationRequest request, Long userId) {
        return ApplicationEntity.builder()
                .totalScore(calculateScore(request.getSubjectsWithScore()))
                .status(ApplicationStatus.PENDING)
                .course(getCourse(request.getCourseName()))
                .userId(userId)
                .build();
    }

    private Double calculateScore(Set<Subject> subjectsWithScore) {
        Double totalScore = 0.0;
        for (Subject subject : subjectsWithScore) {
            totalScore = totalScore + subject.getScore() * subject.getRate();
        }
        return totalScore;
    }

    private CourseEntity getCourse(String courseName) {
        return courseRepository.findCourseEntityByCourseName(courseName)
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));
    }

}
