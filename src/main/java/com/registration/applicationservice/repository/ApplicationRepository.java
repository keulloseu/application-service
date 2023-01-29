package com.registration.applicationservice.repository;

import com.registration.applicationservice.entity.ApplicationEntity;
import com.registration.applicationservice.entity.CourseEntity;
import com.registration.applicationservice.model.ApplicationStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {
    List<ApplicationEntity> findAllByUserId(Long userId);

    @Query("select a from ApplicationEntity a where a.course = ?1 order by a.totalScore limit 30")
    List<ApplicationEntity> findAllByCourse(CourseEntity course);

    List<ApplicationEntity> findAllByStatus(ApplicationStatus status);

    List<ApplicationEntity> findAllByStatusEqualsOrStatusEquals(ApplicationStatus status, ApplicationStatus status1);
}
