package com.uni_manytoone;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="t_student05")
public class Student05 {
    @Id
    private int id;
    @Column(name="std_name")
    private String name;
    private int grade;
    private LocalDate createDate;

    @ManyToOne
    @JoinColumn(name="uni_name")
    private University university;

    @PrePersist//this annotation makes this method run when we save data to database
    public void prePersist(){
        createDate=LocalDate.now();
    }

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }
/*
we used the PrePersist annotation we do not need to set date
    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
*/
    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createDate=" + createDate +
                ", university=" + university +
                '}';
    }
}
