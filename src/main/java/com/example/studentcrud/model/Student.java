package com.example.studentcrud.model;

import com.example.studentcrud.audit.Auditable;
import com.example.studentcrud.service.StudentListener;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EntityListeners(StudentListener.class)
public class Student extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Level level;
    private Gender gender;
    private int age;
    @Version
    private Integer version;
}


