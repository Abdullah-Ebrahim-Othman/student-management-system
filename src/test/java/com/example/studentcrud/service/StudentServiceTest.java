package com.example.studentcrud.service;

import com.example.studentcrud.dto.StudentDTO;
import com.example.studentcrud.model.Student;
import com.example.studentcrud.repository.postgres.StudentPostgresRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentPostgresRepository studentPostgresRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void shouldCreateStudentSuccessfully() {

        StudentDTO studentDTO = new StudentDTO(1,"Abdullah", "Grade 10", 23, "male");
        Student student = new Student(1,"Abdullah", "Grade 10", 23, "male");

        when(studentPostgresRepository.save(any(Student.class))).thenReturn(student);

        StudentDTO savedStudent = studentService.addStudent(studentDTO);

        assertNotNull(savedStudent);
        assertEquals("John Doe", savedStudent.getName());
        verify(studentPostgresRepository, times(1)).save(any(Student.class));
    }
}
