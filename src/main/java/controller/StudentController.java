package controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import servise.StudentService;

import java.util.List;

public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public String findAll(Model model , @Param("keyword") String keyword){
        List<Student> students = studentService.findAll(keyword);
        model.addAttribute("student",students );
        return "student-list";
    }
}
