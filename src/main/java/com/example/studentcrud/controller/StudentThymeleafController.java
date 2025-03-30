package com.example.studentcrud.controller;

import com.example.studentcrud.dto.StudentDTO;
import com.example.studentcrud.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/web/students")
public class StudentThymeleafController {

    private final StudentService studentService;

    public StudentThymeleafController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String listStudents(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size,
                               Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<StudentDTO> studentPage = studentService.getAllStudents(pageable);

        model.addAttribute("students", studentPage.getContent());
        model.addAttribute("currentPage", studentPage.getNumber());
        model.addAttribute("totalPages", studentPage.getTotalPages());
        model.addAttribute("size", size);

        System.out.println(studentPage.getContent());

        return "list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("student", new StudentDTO());
        return "form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute StudentDTO studentDTO) {
        studentService.addStudent(studentDTO);
        return "redirect:/web/students";
    }

    @GetMapping("/{id}")
    public String viewStudent(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.getStudent(id));
        return "details";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable int id, Model model) {
        StudentDTO studentDTO = studentService.getStudent(id);
        model.addAttribute("student", studentDTO);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "redirect:/web/students";
    }
}