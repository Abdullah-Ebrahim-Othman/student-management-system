package com.example.studentcrud.service;

import com.example.studentcrud.model.ArchivedStudent;
import com.example.studentcrud.model.Student;
import com.example.studentcrud.repository.mongo.StudentMongoRepository;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentListener {

    @Autowired
    private StudentMongoRepository mongoRepository;

    @PreRemove
    public void beforeDelete(Student student) {
        ArchivedStudent archivedStudent = new ArchivedStudent(student);
        mongoRepository.save(archivedStudent);
    }

    @PostUpdate
    public void afterUpdate(Student student) {
        ArchivedStudent archivedStudent = new ArchivedStudent(student);
        mongoRepository.save(archivedStudent);
    }
}

