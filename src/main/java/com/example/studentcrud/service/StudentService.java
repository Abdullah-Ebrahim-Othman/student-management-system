package com.example.studentcrud.service;

import com.example.studentcrud.exception.ResourceNotFoundException;
import com.example.studentcrud.mapper.StudentMapper;
import com.example.studentcrud.model.ArchivedStudent;
import com.example.studentcrud.model.Student;
import com.example.studentcrud.dto.StudentDTO;
import com.example.studentcrud.model.StudentSpecification;
import com.example.studentcrud.repository.mongo.StudentMongoRepository;
import com.example.studentcrud.repository.postgres.StudentPostgresRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentPostgresRepository postgresRepository;

    @Autowired
    private StudentMongoRepository mongoRepository;

    @Autowired
    private StudentMapper studentMapper;

    public Page<StudentDTO> geAllStudents(Pageable pageable) {
        return postgresRepository.findAll(pageable).map(studentMapper::map);
    }

    public StudentDTO getStudent(Integer id) {

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
