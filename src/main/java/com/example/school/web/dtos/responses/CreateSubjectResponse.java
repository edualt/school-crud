package com.example.school.web.dtos.responses;

import com.example.school.entities.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateSubjectResponse {
        private String name;
        private List<Student> students;
}
