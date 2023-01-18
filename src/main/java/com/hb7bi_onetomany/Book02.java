package com.hb7bi_onetomany;

import javax.persistence.*;

@Entity
@Table(name = "t_book02")
public class Book02 {
@Id
private int id;
private String name;

@ManyToOne
@JoinColumn
private Student07 student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student07 getStudent() {
        return student;
    }

    public void setStudent(Student07 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
