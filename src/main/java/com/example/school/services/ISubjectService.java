package com.example.school.services;

import com.example.school.entities.Subject;
import com.example.school.web.dtos.requests.CreateSubjectRequest;
import com.example.school.web.dtos.responses.BaseResponse;

public interface ISubjectService {
    BaseResponse create(CreateSubjectRequest request);
    BaseResponse get(Long id);

    Subject findAndEnsureExists(Long id);
}
