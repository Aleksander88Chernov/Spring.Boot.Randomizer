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

    public List<Student> findAll(String keyword) {

        return studentRepository.findAll();
    }

}

