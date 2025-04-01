package com.example.studentcrud.controller;

import com.example.studentcrud.dto.StudentDTO;
import com.example.studentcrud.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping("${api.base-path}/${api.version}/students")
@Tag(name = "Student API", description = "Endpoints for managing students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @Operation(summary = "Get all students with pagination", description = "Fetch students with pagination support.")
    public ResponseEntity<Page<StudentDTO>> getAllStudents(Pageable pageable) {
        return ResponseEntity.ok(studentService.getAllStudents(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get student", description = "Fetches a student with Specific Id.")
    public ResponseEntity<StudentDTO> geStudent(@PathVariable int id) {
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @PostMapping
    @Operation(summary = "Create a student", description = "Adds a new student to the database.")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(studentService.addStudent(studentDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a student", description = "Updates an existing student's details.")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable int id, @RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(studentService.updateStudent(id, studentDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a student", description = "Removes a student from the database.")
    public ResponseEntity<StudentDTO> deleteStudent(@PathVariable int id) {
        return ResponseEntity.ok(studentService.deleteStudent(id));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<StudentDTO>> searchStudents(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String level,
            @RequestParam(required = false) Double gpa,
            Pageable pageable) {

        return ResponseEntity.ok(studentService.searchStudents(name, level, gpa, pageable));
    }
}