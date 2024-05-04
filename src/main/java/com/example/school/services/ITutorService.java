package com.example.school.services;

import com.example.school.entities.Tutor;
import com.example.school.web.dtos.requests.CreateTutorRequest;
import com.example.school.web.dtos.responses.BaseResponse;

public interface ITutorService {

    BaseResponse create(CreateTutorRequest request);
    BaseResponse get(Long id);
    BaseResponse get();
    Tutor findAndEnsureExists(Long id);
}
