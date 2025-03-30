package com.example.studentcrud.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "archived_students")
public class ArchivedStudent  {
    private String id;
    private String name;
    private String level;
    private String gender;
    private Double gpa;
    private Integer age;
    private Integer version;

    public ArchivedStudent(Student student) {
        this.id = String.valueOf(student.getId());
        this.name = student.getName();
        this.level = student.getLevel();
        this.gender = student.getGender();
        this.version = student.getVersion();
        this.age = student.getAge();
        this.gpa = student.getGpa();
    }
}
