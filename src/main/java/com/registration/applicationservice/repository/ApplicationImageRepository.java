package com.registration.applicationservice.repository;

import com.registration.applicationservice.entity.ApplicationImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationImageRepository extends JpaRepository<ApplicationImageEntity, Long> {
}
