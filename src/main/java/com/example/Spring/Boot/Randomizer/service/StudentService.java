package com.example.Spring.Boot.Randomizer.service;

import com.example.Spring.Boot.Randomizer.model.Student;
import com.example.Spring.Boot.Randomizer.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService   {

    private final StudentRepository studentRepository;

   // public Map<Student, Student> getMap;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

   public Map<Student,Student> getMap(){
    HashMap<Student,Student> map =  new HashMap<>();
     map.put(new Student(),new Student());
 //    map.put(new Student(),new Student());
      return map;
   }


    public List<Student> findAll(String keyword) {
if(keyword !=null)
    return studentRepository.listAll(keyword);
   else
    return studentRepository.findAll();
    }
    public Student saveBook(Student student){

        return studentRepository.save(student);
    }

}

