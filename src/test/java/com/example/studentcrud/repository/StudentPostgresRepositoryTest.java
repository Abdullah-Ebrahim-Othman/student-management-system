package com.example.studentcrud.repository;

import com.example.studentcrud.model.Student;
import com.example.studentcrud.repository.postgres.StudentPostgresRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class StudentPostgresRepositoryTest {

    @Autowired
    private StudentPostgresRepository studentPostgresRepository;

    @Test
    void shouldSaveAndRetrieveStudent() {

        Student student = new Student(1,"Abdullah", "Grade 10", 23, "male");
        student = studentPostgresRepository.save(student);

        Student retrievedStudent = studentPostgresRepository.findById(student.getId()).orElse(null);

        assertNotNull(retrievedStudent);
        assertEquals("Alice", retrievedStudent.getName());
    }
}
