package com.example.studentcrud.model;

import com.example.studentcrud.service.StudentListener;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(StudentListener.class)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String level;
    private int age;
    private String gender;
}


