package com.example.Spring.Boot.Randomizer.controller;

import com.example.Spring.Boot.Randomizer.model.Student;
import com.example.Spring.Boot.Randomizer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    @GetMapping("/student")
    public String findAll(Model model , @Param("keyword") String keyword){

        java.util.List<Student> students = studentService.findAll(keyword);
        model.addAttribute("students",students );
        return "student_list";
    }

    @GetMapping("/random")
    public String random(Model model,@Param("keyword") String keyword){
        List<Student> studentList = studentService.findAll(keyword);
        Map<Student,Student> student=new HashMap<>();


        student.put(studentList.get(0),studentList.get(1));
        student.put(studentList.get(1),studentList.get(2));
        student.put(studentList.get(2),studentList.get(3));
        model.addAttribute("students",student);
        return "random";
    }
    @GetMapping("/student-add")
    public String createStudentForm(Student student){

        return "student-add";
    }

    @PostMapping("/student-add")
    public String createUser(Student student){
        studentService.saveBook(student);
        return "redirect:/student";
    }



}
