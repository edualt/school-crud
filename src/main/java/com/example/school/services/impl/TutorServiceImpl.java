package com.example.school.services.impl;

import com.example.school.entities.Tutor;
import com.example.school.mappers.ITutorMapper;
import com.example.school.repositories.ITutorRepository;
import com.example.school.services.ITutorService;
import com.example.school.web.dtos.requests.CreateTutorRequest;
import com.example.school.web.dtos.responses.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorServiceImpl implements ITutorService {

    private final ITutorMapper tutorMapper;
    private final ITutorRepository repository;

    public TutorServiceImpl(ITutorMapper tutorMapper, ITutorRepository repository) {
        this.tutorMapper = tutorMapper;
        this.repository = repository;
    }

    @Override
    public BaseResponse create(CreateTutorRequest request) {
        Tutor tutor = new Tutor();
        tutor.setFullName(request.getFullName());

        repository.save(tutor);

        return BaseResponse.builder()
                .data(tutorMapper.toCreateTutorResponse(tutor))
                .message("Tutor created successfully")
                .success(true)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    @Override
    public BaseResponse get(Long id) {
        Tutor tutor = this.findAndEnsureExists(id);

        return BaseResponse.builder()
                .data(tutorMapper.toCreateTutorResponse(tutor))
                .message("Tutor retrieved successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse get() {
        List<Tutor> tutors = repository.findAll();

        return BaseResponse.builder()
                .data(tutors.stream().map(tutorMapper::toCreateTutorResponse).toList())
                .message("Tutors retrieved successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public Tutor findAndEnsureExists(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Tutor not found"));
    }
}
