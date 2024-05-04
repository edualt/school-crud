package com.example.school.web.dtos.responses;

import com.example.school.entities.Tutor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetStudentResponse {

    private String fullName;
    private String tutorName;
    private List<String> subjects;
}
