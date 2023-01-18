package com.hb4bi_onetoone;

import javax.persistence.*;

@Entity
@Table(name="t_diary02")
public class Diary02 {
    @Id
    private int id;
    private String name;

    @OneToOne
    @JoinColumn
    private Student04 student;

    //Getter-setter


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

    public Student04 getStudent() {
        return student;
    }

    public void setStudent(Student04 student) {
        this.student = student;
    }

    @Override
  public String toString() {
        return "Diary02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
