package com.hb6uni_onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student06")
public class Student06 {
    @Id
    private int id;
    @Column(name="st_name")
    private String name;

    @OneToMany
    @JoinColumn
    private List<Book> bookList=new ArrayList<>();//when we create entity there will be new ArrayList created

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

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
