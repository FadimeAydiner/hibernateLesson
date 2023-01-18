package com.hb8manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_student08")
public class Student08 {

    @Id
    private int id;
    @Column(name="st_name")
    private String name;

   @ManyToMany
    @JoinTable(name="student08_book03",//name of join table
            joinColumns = {@JoinColumn(name="std_id")},//name of column for owner of relation
            inverseJoinColumns = {@JoinColumn(name="book_id")}//name of column where id of other table will be stored
    )
    private List<Book03> bookList=new ArrayList<>();

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

    public List<Book03> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book03> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
