package model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "new_table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "team")
    private int team;

    @Column(name = "grade")
    private int grade;

    @Column(name = "grade_two")
    private int gradeTwo;

    @Column(name = "visit")
    private String visit;
}
