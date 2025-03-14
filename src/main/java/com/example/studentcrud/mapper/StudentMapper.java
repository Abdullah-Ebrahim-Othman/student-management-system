package com.example.studentcrud.mapper;

import com.example.studentcrud.dto.StudentDTO;
import com.example.studentcrud.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student map(StudentDTO studentDTO);

    StudentDTO map(Student student);

    List<StudentDTO> map(List<Student> students);

    @Mapping(target = "id", ignore = true)
    void updateStudentFromDto(StudentDTO studentDTO, @MappingTarget Student student);

}
