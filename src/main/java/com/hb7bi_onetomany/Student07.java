package com.hb7bi_onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student07")
public class Student07 {
    @Id
    private int id;
    @Column(name="st_name")
    private String name;

    @OneToMany(mappedBy = "student",orphanRemoval = true)
    private List<Book02> bookList=new ArrayList<>();//when we create entity there will be new ArrayList created

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

    public List<Book02> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book02> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student07{" +
                "id=" + id +
                ", name='" + name + '\'' +
               // ", bookList=" + bookList +
                '}';
    }
}
