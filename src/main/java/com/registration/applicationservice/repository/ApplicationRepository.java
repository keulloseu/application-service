package com.registration.applicationservice.repository;

import com.registration.applicationservice.entity.ApplicationEntity;
import com.registration.applicationservice.entity.CourseEntity;
import com.registration.applicationservice.model.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {
    List<ApplicationEntity> findAllByUserId(Long userId);

    @Query("select a from ApplicationEntity a where a.course = ?1 order by a.totalScore")
    List<ApplicationEntity> findAllByCourse(CourseEntity course);

    List<ApplicationEntity> findAllByStatus(ApplicationStatus status);

}
