package com.uni_onetoone;

import com.embeddeable.Student02;

import javax.persistence.*;

@Entity
@Table(name="t_diary")
public class Diary {
    @Id
    private int id;

    private String name;

    @OneToOne//in my direct table new column will be added with default name "student_id"
    @JoinColumn(name="std_id")//this will change name
    private Student03 student;

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

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
