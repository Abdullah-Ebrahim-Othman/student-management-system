package com.example.studentcrud.model;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "students_archive")
@Data
public class ArchivedStudent {

    @Id
    private String id;
    private String name;
    private String level;
    private int age;
    private String gender;

    public ArchivedStudent(Student student) {
        this.id = String.valueOf(student.getId());
        this.name = student.getName();
        this.level = student.getLevel();
        this.age = student.getAge();
        this.gender = student.getGender();
    }

}