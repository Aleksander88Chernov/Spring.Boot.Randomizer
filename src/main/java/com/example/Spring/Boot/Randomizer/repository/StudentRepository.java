package com.example.Spring.Boot.Randomizer.repository;

import com.example.Spring.Boot.Randomizer.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {


        @Query("SELECT s FROM Student s WHERE s.student_name LIKE ?1%")

    List<Student> listAll(String keyword);
}
