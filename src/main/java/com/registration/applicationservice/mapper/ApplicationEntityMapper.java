package com.registration.applicationservice.mapper;

import com.registration.applicationservice.dto.ApplicationDto;
import com.registration.applicationservice.entity.ApplicationEntity;
import com.registration.applicationservice.entity.CourseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class ApplicationEntityMapper {

    @Mapping(target = "applicationId", source = "applicationId")
    @Mapping(target = "totalScore", source = "totalScore")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "courseName", source = "course", qualifiedByName = "mapCourseName")
    public abstract ApplicationDto applicationToDto(ApplicationEntity application);

    @Named("mapCourseName")
    String mapCourseName(CourseEntity course) {
        return course.getCourseName();
    }
}
