package com.example.Spring.Boot.Randomizer.controller;

import com.example.Spring.Boot.Randomizer.model.Student;
import com.example.Spring.Boot.Randomizer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedHashMap;

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
    public String random(Model model){
        LinkedHashMap<Student,Student> student = studentService.getMap();
        model.addAttribute("students",student);
        return "random";
    }

    @GetMapping("/student-delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id){
        studentService.deleteById(id);
        return "redirect:/student";
    }

    @GetMapping("/student-add")
    public String createStudentForm(Student student){
        return "student-add";
    }

    @PostMapping("/student-add")
    public String createUser(Student student){
        studentService.saveStudent(student);
        return "redirect:/student";
    }

    @GetMapping("/grade/{id}")
    public String updateBookForm(@PathVariable("id") Integer id, Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "grade-student";
    }

    @PostMapping("/grade-student")
    public String updateStudent(Student student){
        studentService.saveStudent(student);
        return "redirect:/random";
    }

    @GetMapping("/edit-student/{id}")
    public String updateStudentForm(@PathVariable("id") Integer id, Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "student-edit";
    }

    @PostMapping("/edit-student")
    public String editStudent(Student student){
        studentService.saveStudent(student);
        return "redirect:/student";
    }

}
