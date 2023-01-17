package com.uni_manytoone;

import javax.persistence.*;

@Entity
@Table(name="t_student05")
public class Student05 {
    @Id
    private int id;
    @Column(name="std_name")
    private String name;
    private int grade;

    @ManyToOne
    @JoinColumn(name="uni_name")
    private University university;
}
