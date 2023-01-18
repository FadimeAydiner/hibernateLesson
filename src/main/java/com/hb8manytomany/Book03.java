package com.hb8manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_book03")
public class Book03 {
    @Id
    private int id;
    private String name;

    @ManyToMany(mappedBy = "bookList")
    private List<Student08> students=new ArrayList<>();


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

    public List<Student08> getStudents() {
        return students;
    }

    public void setStudents(List<Student08> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Book03{" +
                "id=" + id +
                ", name='" + name + '\'' +
               // ", students=" + students +
                '}';
    }
}
