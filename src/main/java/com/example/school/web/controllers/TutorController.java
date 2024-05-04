package com.example.school.web.controllers;

import com.example.school.services.ITutorService;
import com.example.school.web.dtos.requests.CreateTutorRequest;
import com.example.school.web.dtos.responses.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutors")
public class TutorController {

    private final ITutorService tutorService;

    public TutorController(ITutorService tutorService) {
        this.tutorService = tutorService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CreateTutorRequest request) {
        BaseResponse response = tutorService.create(request);
        return response.apply();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> get(@PathVariable Long id) {
        BaseResponse response = tutorService.get(id);
        return response.apply();
    }

    @GetMapping
    public ResponseEntity<BaseResponse> get() {
        BaseResponse response = tutorService.get();
        return response.apply();
    }
}
