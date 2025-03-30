package com.example.studentcrud.service;

import com.example.studentcrud.model.ArchivedStudent;
import com.example.studentcrud.repository.mongo.StudentMongoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentArchiveListener {

    private final StudentMongoRepository mongoRepository;

    @EventListener
    @Async
    public void handleStudentArchivedEvent(StudentArchivedEvent event) {
        ArchivedStudent archivedStudent = new ArchivedStudent(event.getStudent());
        mongoRepository.save(archivedStudent);
        log.info("Archived student with action: {}", event.getAction());
    }
}
