package com.registration.applicationservice.service;

import com.registration.applicationservice.dto.EmailDto;
import com.registration.applicationservice.entity.ApplicationEntity;
import com.registration.applicationservice.entity.CourseEntity;
import com.registration.applicationservice.feignClient.MailServiceClient;
import com.registration.applicationservice.model.ApplicationStatus;
import com.registration.applicationservice.model.SendEmailsRequest;
import com.registration.applicationservice.repository.ApplicationRepository;
import com.registration.applicationservice.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RankingService {
    private final ApplicationRepository applicationRepository;
    private final CourseRepository courseRepository;
    private final MailService mailService;
    private final MailServiceClient mailServiceClient;

    @Value("${course.max.users}")
    private Integer maxStudents;

    @Scheduled(cron = "${recrutation.results.date}")
    public void announceResults() {
        updateStatusToAccepted(createRankingForEachCourse());
        updateStatusToRejected();
        List<EmailDto> accepted = mailService.findEmailsForAcceptedApps().getBody();
        List<EmailDto> rejected = mailService.findEmailsForRejectedApps().getBody();
        mailServiceClient.sendEmails(new SendEmailsRequest(accepted, rejected));
    }

    private Map<CourseEntity, List<ApplicationEntity>> createRankingForEachCourse() {
        List<CourseEntity> courses = courseRepository.findAll();
        Map<CourseEntity, List<ApplicationEntity>> applicationRankings = new HashMap<>();
        for (CourseEntity course : courses) {
            applicationRankings.put(course, applicationRepository.findAllByCourse(course).subList(0, maxStudents));
        }
        return applicationRankings;
    }

    private void updateStatusToAccepted(Map<CourseEntity, List<ApplicationEntity>> acceptedApplications) {
        List<ApplicationEntity> applications = acceptedApplications.entrySet()
                .stream().flatMap(a -> a.getValue().stream()).toList();
        for (ApplicationEntity application : applications) {
            application.setStatus(ApplicationStatus.ACCEPTED);
            applicationRepository.save(application);
        }
    }

    private void updateStatusToRejected() {
        List<ApplicationEntity> applications = applicationRepository.findAllByStatus(ApplicationStatus.PENDING);
        for (ApplicationEntity application : applications) {
            application.setStatus(ApplicationStatus.REJECTED);
            applicationRepository.save(application);
        }
    }
}
