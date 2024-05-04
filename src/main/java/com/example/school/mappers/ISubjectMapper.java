package com.example.school.mappers;

import com.example.school.entities.Subject;
import com.example.school.web.dtos.responses.CreateSubjectResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISubjectMapper {

    CreateSubjectResponse toCreateSubjectResponse(Subject subject);
}
