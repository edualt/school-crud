package com.example.school.mappers;

import com.example.school.entities.Tutor;
import com.example.school.web.dtos.responses.CreateTutorResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITutorMapper {

    CreateTutorResponse toCreateTutorResponse(Tutor tutor);
}
