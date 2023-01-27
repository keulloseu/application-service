package com.registration.applicationservice.repository;

import com.registration.applicationservice.entity.CourseEntity;
import com.registration.applicationservice.entity.ReqSubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ReqSubjectRepository extends JpaRepository<ReqSubjectEntity, Long> {
    List<ReqSubjectEntity> findAllByCourses(Set<CourseEntity> courses);
}
