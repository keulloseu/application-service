package com.registration.applicationservice.service;

import com.registration.applicationservice.dto.CourseDto;
import com.registration.applicationservice.mapper.CourseEntityMapper;
import com.registration.applicationservice.mapper.ReqSubjectMapper;
import com.registration.applicationservice.model.ReqSubject;
import com.registration.applicationservice.repository.CourseRepository;
import com.registration.applicationservice.repository.ReqSubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseEntityMapper courseEntityMapper;
    private final CourseRepository courseRepository;
    private final ReqSubjectMapper reqSubjectMapper;
    private final ReqSubjectRepository reqSubjectRepository;

    public List<CourseDto> getCoursesWithReqSubjects() {
        return courseRepository.findAll().stream()
                .map(c -> courseEntityMapper.courseToDto(c, reqSubjectRepository.findAllByCoursesIn(Set.of(c))
                        .stream().map(reqSubjectMapper::subjectToDto).toList())).toList();
    }

    public List<ReqSubject> getCourseSubjects(String name) {
        return courseRepository.findCourseEntityByCourseName(name)
                .orElseThrow(() -> new EntityNotFoundException("Course not found"))
                .getReqSubjects().stream()
                .map(reqSubjectMapper::subjectToDto).toList();
    }
}
