package com.registration.applicationservice.mapper;

import com.registration.applicationservice.entity.ReqSubjectEntity;
import com.registration.applicationservice.model.ReqSubject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class ReqSubjectMapper {
    @Mapping(target = "subjectName", source = "subjectName")
    public abstract ReqSubject subjectToDto(ReqSubjectEntity reqSubject);
}
