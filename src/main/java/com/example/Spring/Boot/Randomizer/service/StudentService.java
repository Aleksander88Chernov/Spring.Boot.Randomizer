package com.example.Spring.Boot.Randomizer.service;

import com.example.Spring.Boot.Randomizer.model.Student;
import com.example.Spring.Boot.Randomizer.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService   {

    private final StudentRepository studentRepository;

@Autowired
    public StudentService(StudentRepository studentRepository){

    this.studentRepository = studentRepository;
    }

    public Student findById(Long id){

        return studentRepository.getById(Math.toIntExact(id));
    }

    public List<Student> findAll(String keyword) {
        if (keyword != null)
            return studentRepository.listAll(keyword);
        else

        return studentRepository.findAll();
    }

    public Student saveStudent(Student student){

        return studentRepository.save(student);
    }

    public void deleteById(Long id){

        studentRepository.deleteById(Math.toIntExact(id));
    }
}


