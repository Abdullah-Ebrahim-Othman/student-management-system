package com.example.studentcrud.dto;

import com.example.studentcrud.model.Gender;
import com.example.studentcrud.model.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private int id;
    private String name;
    private Level level;
    private int age;
    private Gender gender;

}
