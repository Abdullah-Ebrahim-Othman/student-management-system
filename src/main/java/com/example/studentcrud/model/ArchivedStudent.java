package com.example.studentcrud.model;

import com.example.studentcrud.audit.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "archived_students")
public class ArchivedStudent  {
    private int id;
    private String name;
    private Level level;
    private Gender gender;
    private int age;
    private Integer version;

    public ArchivedStudent(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.level = student.getLevel();
        this.gender = student.getGender();
        this.age = student.getAge();
        this.version = student.getVersion();
    }
}
