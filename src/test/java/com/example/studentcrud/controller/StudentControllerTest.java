package com.example.studentcrud.controller;

import com.example.studentcrud.dto.StudentDTO;
import com.example.studentcrud.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
@ExtendWith(SpringExtension.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private StudentService studentService;

    @Test
    void shouldReturnPaginatedStudents() throws Exception {

        List<StudentDTO> students = List.of(
                new StudentDTO(1,"Abdullah", "Grade 10", 23, "male"),
                new StudentDTO(1,"Abdullah", "Grade 10", 23, "male")
        );
        Pageable pageable = PageRequest.of(0, 2);
        Page<StudentDTO> studentPage = new PageImpl<>(students, pageable, students.size());

        when(studentService.geAllStudents(pageable)).thenReturn(studentPage);

        mockMvc.perform(get("/v1/api/students")
                        .param("page", "0")
                        .param("size", "2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.length()").value(2))
                .andExpect(jsonPath("$.content[0].name").value("Abdullah"))
                .andExpect(jsonPath("$.content[1].name").value("Alaa"))
                .andExpect(jsonPath("$.totalElements").value(2))
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.size").value(2));
    }
}
