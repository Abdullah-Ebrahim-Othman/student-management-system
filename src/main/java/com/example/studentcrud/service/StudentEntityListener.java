package com.example.studentcrud.service;

import com.example.studentcrud.model.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import jakarta.persistence.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class StudentEntityListener {

    private final ApplicationEventPublisher eventPublisher;

    @PostPersist
    public void afterCreate(Student student) {
        eventPublisher.publishEvent(new StudentArchivedEvent(student, "Created"));
    }

    @PostUpdate
    public void afterUpdate(Student student) {
        eventPublisher.publishEvent(new StudentArchivedEvent(student, "Updated"));
    }

    @PreRemove
    public void beforeDelete(Student student) {
        eventPublisher.publishEvent(new StudentArchivedEvent(student, "Deleted"));
    }
}
