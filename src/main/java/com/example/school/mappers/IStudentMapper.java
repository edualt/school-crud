package com.example.school.mappers;

import com.example.school.entities.Student;
import com.example.school.entities.Subject;
import com.example.school.entities.pivots.StudentSubject;
import com.example.school.web.dtos.responses.CreateStudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface IStudentMapper {

    @Mapping(source = "tutor.fullName", target = "tutorName")
    @Mapping(source = "studentSubjects", target = "subjects")
    CreateStudentResponse toCreateStudentResponse(Student student);

    default List<String> mapStudentSubjectsToSubjectNames(List<StudentSubject> studentSubjects) {
        return studentSubjects.stream()
                .map(StudentSubject::getSubject)
                .map(Subject::getName)
                .collect(Collectors.toList());
    }
}

