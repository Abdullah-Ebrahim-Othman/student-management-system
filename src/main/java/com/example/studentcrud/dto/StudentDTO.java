package com.example.studentcrud.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Integer id;
    private String name;
    private String level;
    private Integer gpa;
    private Integer age;
    private String gender;

}