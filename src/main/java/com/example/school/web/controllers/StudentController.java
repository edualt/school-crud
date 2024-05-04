package com.example.school.web.controllers;

import com.example.school.services.IStudentService;
import com.example.school.web.dtos.requests.CreateStudentRequest;
import com.example.school.web.dtos.requests.UpdateStudentRequest;
import com.example.school.web.dtos.responses.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CreateStudentRequest request) {
        BaseResponse response = studentService.create(request);
        return response.apply();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> get(@PathVariable Long id) {
        BaseResponse response = studentService.get(id);
        return response.apply();
    }

    @GetMapping
    public ResponseEntity<BaseResponse> get() {
        BaseResponse response = studentService.get();
        return response.apply();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse> update(@PathVariable Long id, @RequestBody UpdateStudentRequest request) {
        BaseResponse response = studentService.update(id, request);
        return response.apply();
    }
}
