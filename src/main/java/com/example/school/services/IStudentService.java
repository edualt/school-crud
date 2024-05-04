package com.example.school.services;

import com.example.school.entities.Student;
import com.example.school.web.dtos.requests.CreateStudentRequest;
import com.example.school.web.dtos.requests.UpdateStudentRequest;
import com.example.school.web.dtos.responses.BaseResponse;

import java.util.List;

public interface IStudentService {

    BaseResponse create(CreateStudentRequest request);
    BaseResponse get(Long id);
    BaseResponse get();
    BaseResponse update(Long id, UpdateStudentRequest request);
    List<Student> getStudentsByIds(List<Long> ids);
}
