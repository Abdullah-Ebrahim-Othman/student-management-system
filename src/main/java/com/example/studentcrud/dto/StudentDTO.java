package com.example.studentcrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private int id;
    private String name;
    private String level;
    private int age;
    private String gender;

}
