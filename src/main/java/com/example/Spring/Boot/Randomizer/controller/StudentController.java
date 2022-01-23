package com.example.Spring.Boot.Randomizer.controller;

import com.example.Spring.Boot.Randomizer.model.Student;
import com.example.Spring.Boot.Randomizer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    @GetMapping("/student")
    public String findAll(Model model , @Param("keyword") String keyword){

        List<Student> students = studentService.findAll(keyword);
        model.addAttribute("students",students );
        return "student_list";
    }


}
