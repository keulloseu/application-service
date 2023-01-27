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

    @Mapping(target = "totalScore", source = "applicationEntity.totalScore")
    @Mapping(target = "status", source = "applicationEntity.status")
    @Mapping(target = "courseName", source = "applicationEntity.courseName", qualifiedByName = "mapCourseName")
    @Mapping(target = "userId", source = "applicationEntity.userId")
    public abstract ApplicationDto applicationToDto(ApplicationEntity application);

    @Named("mapCourseName")
    String mapCourseName(CourseEntity course) {
        return course.getCourseName();
    }
}
