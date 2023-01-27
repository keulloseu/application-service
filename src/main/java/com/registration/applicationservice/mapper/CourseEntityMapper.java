package com.registration.applicationservice.mapper;

import com.registration.applicationservice.dto.CourseDto;
import com.registration.applicationservice.entity.CourseEntity;
import com.registration.applicationservice.entity.ReqSubjectEntity;
import com.registration.applicationservice.model.ReqSubject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class CourseEntityMapper {
    @Mapping(target = "courseName", source = "courseEntity.courseName")
    @Mapping(target = "reqSubjects", source = "reqSubjectEntities")
    public abstract CourseDto courseToDto(CourseEntity course, List<ReqSubject> reqSubjectEntities);
}

