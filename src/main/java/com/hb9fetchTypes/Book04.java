package com.hb9fetchTypes;

import javax.persistence.*;

@Entity
@Table(name="t_book04")
public class Book04 {
    @Id
    private  int id;

    private String name;

@ManyToOne
@JoinColumn
    private Student09 student;

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

    public Student09 getStudent() {
        return student;
    }

    public void setStudent(Student09 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book04{" +
                "id=" + id +
                ", name='" + name + '\'' +
              //  ", student=" + student +
                '}';
    }
}
