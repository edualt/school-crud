package com.example.school.services.impl;

import com.example.school.entities.Subject;
import com.example.school.mappers.ISubjectMapper;
import com.example.school.repositories.ISubjectRepository;
import com.example.school.services.ISubjectService;
import com.example.school.web.dtos.requests.CreateSubjectRequest;
import com.example.school.web.dtos.responses.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements ISubjectService {

    private final ISubjectRepository repository;
    private final ISubjectMapper subjectMapper;

    public SubjectServiceImpl(ISubjectRepository repository, ISubjectMapper subjectMapper) {
        this.repository = repository;
        this.subjectMapper = subjectMapper;
    }

    @Override
    public BaseResponse create(CreateSubjectRequest request) {
        Subject subject = new Subject();
        subject.setName(request.getName());

        repository.save(subject);

        return BaseResponse.builder()
                .data(subjectMapper.toCreateSubjectResponse(subject))
                .message("Subject created successfully")
                .success(true)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    @Override
    public BaseResponse get(Long id) {
        Subject subject = this.findAndEnsureExists(id);

        return BaseResponse.builder()
                .data(subjectMapper.toCreateSubjectResponse(subject))
                .message("Subject retrieved successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public Subject findAndEnsureExists(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found"));
    }
}
