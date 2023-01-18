package com.hb9fetchTypes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_student09")
public class Student09 {
    @Id
    private int id;
    @Column(name="st_name")
    private String name;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Book04> bookList=new ArrayList<>();

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

    public List<Book04> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book04> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
