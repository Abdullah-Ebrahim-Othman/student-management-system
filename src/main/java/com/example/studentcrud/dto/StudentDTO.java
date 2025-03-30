package com.example.studentcrud.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Integer id;
    private String name;
    private String gender;
    private String level;
    private Double gpa;
    private Integer age;
}