package com.registration.applicationservice.controller;

import com.registration.applicationservice.dto.CourseDto;
import com.registration.applicationservice.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseDto>> getCoursesWithReqSubjects() {
        return ResponseEntity.ok(courseService.getCoursesWithReqSubjects());
    }
}
