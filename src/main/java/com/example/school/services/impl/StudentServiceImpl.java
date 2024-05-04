package com.example.school.services.impl;

import com.example.school.entities.Student;
import com.example.school.entities.Subject;
import com.example.school.entities.pivots.StudentSubject;
import com.example.school.mappers.IStudentMapper;
import com.example.school.repositories.IStudentRepository;
import com.example.school.services.IStudentService;
import com.example.school.services.IStudentSubjectService;
import com.example.school.services.ISubjectService;
import com.example.school.services.ITutorService;
import com.example.school.web.dtos.requests.CreateStudentRequest;
import com.example.school.web.dtos.requests.UpdateStudentRequest;
import com.example.school.web.dtos.responses.BaseResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    private final IStudentMapper studentMapper;
    private final IStudentRepository repository;
    private final ITutorService tutorService;
    private final ISubjectService subjectService;
    private final IStudentSubjectService studentSubjectService;

    public StudentServiceImpl(IStudentMapper studentMapper, IStudentRepository repository, ITutorService tutorService, ISubjectService subjectService, IStudentSubjectService studentSubjectService) {
        this.studentMapper = studentMapper;
        this.repository = repository;
        this.tutorService = tutorService;
        this.subjectService = subjectService;
        this.studentSubjectService = studentSubjectService;
    }

    @Override
    public BaseResponse create(CreateStudentRequest request) {
        Student student = new Student();
        student.setFullName(request.getFullName());
        student.setTutor(tutorService.findAndEnsureExists(request.getTutorId()));

        repository.save(student);

        if(request.getSubjectsIds() != null) {
            setStudentSubjectsListToUser(request.getSubjectsIds(), student);
        }

        return BaseResponse.builder()
                .data(studentMapper.toCreateStudentResponse(student))
                .message("Student created successfully")
                .success(true)
                .httpStatus(HttpStatus.CREATED)
                .build();

    }

    @Override
    public BaseResponse get(Long id) {
        Student student = this.findAndEnsureExists(id);

        return BaseResponse.builder()
                .data(studentMapper.toCreateStudentResponse(student))
                .message("Student retrieved successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse get() {
        List<Student> students = repository.findAll();

        return BaseResponse.builder()
                .data(students.stream().map(studentMapper::toCreateStudentResponse).toList())
                .message("Students retrieved successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();

    }

    @Override
    public BaseResponse update(Long id, UpdateStudentRequest request) {
        Student student = this.findAndEnsureExists(id);

        student.setFullName(request.getFullName());
        student.setTutor(tutorService.findAndEnsureExists(request.getTutorId()));

        repository.save(student);

        if(request.getSubjectsIds() != null) {
            setStudentSubjectsListToUser(request.getSubjectsIds(), student);
        }

        return BaseResponse.builder()
                .data(studentMapper.toCreateStudentResponse(student))
                .message("Student updated successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public List<Student> getStudentsByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }

    private Student findAndEnsureExists(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    private void setStudentSubjectsListToUser(@NotNull List<Long> studentSubjectsIds, Student student) {
         List<StudentSubject> tempStudentSubjects = new ArrayList<>();

         for(Long subjectId : studentSubjectsIds) {
            Subject subject = subjectService.findAndEnsureExists(subjectId);
            StudentSubject newStudentSubject = studentSubjectService.create(student, subject);
            tempStudentSubjects.add(newStudentSubject);
         }

         student.setStudentSubjects(tempStudentSubjects);

         repository.save(student);
    }
}
