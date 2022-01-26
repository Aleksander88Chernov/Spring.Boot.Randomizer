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

        List<Student> student = studentService.findAll(keyword);
        model.addAttribute("student",student );
        return "student_list";
    }
    @GetMapping("/student-create")
    public String createStudentForm(Student student){

        return "student-create";
    }

    @PostMapping("/student-create")
    public String createStudent(Student student){
        studentService.saveStudent(student);
        return "redirect:/student";
    }

    @GetMapping("/book-delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteById(id);
        return "redirect:/student";
    }

    @GetMapping("/student-update/{id}")
    public String updateStudentForm(@PathVariable("id") Long id, Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "student-update";
    }

    @PostMapping("/student-update")
    public String updateStudent(Student student){
        studentService.saveStudent(student);
        return "redirect:/student";
    }
}



