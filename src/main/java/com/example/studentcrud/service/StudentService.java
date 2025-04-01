package com.example.studentcrud.service;

import com.example.studentcrud.exception.ResourceNotFoundException;
import com.example.studentcrud.mapper.StudentMapper;
import com.example.studentcrud.model.Student;
import com.example.studentcrud.dto.StudentDTO;
import com.example.studentcrud.model.StudentSpecification;
import com.example.studentcrud.repository.postgres.StudentPostgresRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
@Transactional
public class StudentService {

    private final StudentPostgresRepository postgresRepository;

    private final StudentMapper studentMapper;

    public StudentService(StudentPostgresRepository postgresRepository, StudentMapper studentMapper) {
        this.postgresRepository = postgresRepository;
        this.studentMapper = studentMapper;
    }

    public Page<StudentDTO> getAllStudents(Pageable pageable) {
        return postgresRepository.findAll(pageable).map(student -> studentMapper.map(student));
    }

    public StudentDTO getStudent(int id) {

        Student existingStudent = postgresRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        return studentMapper.map(existingStudent);
    }

    public StudentDTO addStudent(StudentDTO studentDto) {
        postgresRepository.save(studentMapper.map(studentDto));
        return studentDto;
    }

    public StudentDTO updateStudent(int id, StudentDTO studentDto) {
        Student existingStudent = postgresRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        studentMapper.updateStudentFromDto(studentDto, existingStudent);
        Student updatedStudent = postgresRepository.save(existingStudent);

        return studentMapper.map(updatedStudent);
    }

    public StudentDTO deleteStudent(int id) {

        Student existingStudent = postgresRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        postgresRepository.deleteById(id);

        return studentMapper.map(existingStudent);
    }

    public Page<StudentDTO> searchStudents(String name, String level, Double gpa, Pageable pageable) {
        Specification<Student> spec = Specification.where(null);

        if (name != null) spec = spec.and(StudentSpecification.hasName(name));
        if (level != null) spec = spec.and(StudentSpecification.hasLevel(level));
        if (gpa != null) spec = spec.and(StudentSpecification.hasGpa(gpa));

        return postgresRepository.findAll(spec, pageable).map(studentMapper::map);
    }
}