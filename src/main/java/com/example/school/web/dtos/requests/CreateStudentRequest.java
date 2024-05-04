package com.example.school.web.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CreateStudentRequest {

    private String fullName;

    private Long tutorId;

    private List<Long> subjectsIds;

}
