package com.example.Spring.Boot.Randomizer.repository;

import com.example.Spring.Boot.Randomizer.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

  //  List<Student> listAll(String keyword);
}
