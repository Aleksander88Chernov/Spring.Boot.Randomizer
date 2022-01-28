package com.example.Spring.Boot.Randomizer.service;

import com.example.Spring.Boot.Randomizer.model.Student;
import com.example.Spring.Boot.Randomizer.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public LinkedHashMap<Student, Student> getMap() {
       List<Student> list = studentRepository.findAll();
        LinkedHashMap<Student, Student> map = new LinkedHashMap<>();
        for (int i = 0;i<list.size()-1;i++){
            map.put(list.get(i),list.get(i+1));
        }
        return map;
    }

    public List<Student> findAll(String keyword) {
        if (keyword != null)
            return studentRepository.listAll(keyword);
        else
            return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findById(Integer id) {

        return studentRepository.getOne(id);
    }

    public void deleteById(Integer id)
    {
        studentRepository.deleteById(id);
    }
}

