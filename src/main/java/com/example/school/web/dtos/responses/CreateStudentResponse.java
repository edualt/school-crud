package com.example.school.web.dtos.responses;

import com.example.school.entities.Subject;
import com.example.school.entities.Tutor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CreateStudentResponse {

    private String fullName;

    private String tutorName;

    private List<String> subjects;
}
