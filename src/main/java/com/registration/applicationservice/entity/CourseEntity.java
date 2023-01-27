package com.registration.applicationservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String courseName;
    @OneToMany(mappedBy = "course")
    private Set<ApplicationEntity> applications;
    @ManyToMany(mappedBy = "courses")
    private Set<ReqSubjectEntity> reqSubjects;
}
