package com.example.school.services;

import com.example.school.entities.Student;
import com.example.school.entities.Subject;
import com.example.school.entities.pivots.StudentSubject;
import com.example.school.web.dtos.responses.BaseResponse;

public interface IStudentSubjectService {

    StudentSubject create(Student student, Subject subject);
    BaseResponse listAllSubjectsByStudentId(Long studentId);
    BaseResponse listAllStudentsBySubjectId(Long subjectId);
}
