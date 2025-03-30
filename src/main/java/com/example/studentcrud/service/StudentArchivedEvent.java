package com.example.studentcrud.service;

import com.example.studentcrud.model.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class StudentArchivedEvent extends ApplicationEvent {
    private final Student student;
    private final String action;

    public StudentArchivedEvent(Student student, String action) {
        super(student);
        this.student = student;
        this.action = action;
    }
}
