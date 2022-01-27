package controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import servise.StudentService;

import java.util.List;

@Controller
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String findAll(Model model , @Param("keyword") String keyword){

        List<Student> students = studentService.findAll(keyword);
        model.addAttribute("students",students );
        return "student_list";
    }
    @GetMapping("/student-create")
    public String createStudentForm(Student student){

        return "student-create";
    }

    @PostMapping("/student-create")
    public String createStudent(Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/student-delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id){
        studentService.deleteById(id);
        return "redirect:/students";
    }

    @GetMapping("/student-update/{id}")
    public String updateStudentForm(@PathVariable("id") Integer id, Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "student-update";
    }

    @PostMapping("/student-update")
    public String updateStudent(Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }
}

