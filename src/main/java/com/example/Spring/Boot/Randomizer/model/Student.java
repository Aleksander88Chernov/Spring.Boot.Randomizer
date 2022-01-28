package com.example.Spring.Boot.Randomizer.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "team")
    private int team;

    @Column(name = "grade")
    private double grade;

    @Column(name = "homework")
    private String homework;
}
