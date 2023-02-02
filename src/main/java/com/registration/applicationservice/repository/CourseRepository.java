package com.registration.applicationservice.repository;

import com.registration.applicationservice.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
    Optional<CourseEntity> findCourseEntityByCourseName(String courseName);
}
