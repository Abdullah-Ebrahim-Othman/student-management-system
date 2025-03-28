package com.example.studentcrud.model;

import com.example.studentcrud.audit.Auditable;
import com.example.studentcrud.service.StudentListener;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@EqualsAndHashCode(callSuper = true)
@Entity
@DynamicUpdate
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(StudentListener.class)
public class Student extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String gender;
    private String level;
    private Integer gpa;
    private Integer age;
    @Version
    private Integer version;
}


