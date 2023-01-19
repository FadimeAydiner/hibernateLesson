package com.hb12hibernatecaching;

import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "t_student12")

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "Student12")
public class Student12 {
    @Id
    @GeneratedValue(generator = "sequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="sequence",//It should be matching @GeneratedValue 's generator attribute
            sequenceName = "std_sequence",//sequence that will be stored in DB
            initialValue = 1001,//initial of id
            allocationSize = 10//Deefault allacation size is 50. but If we dont nedd 50 id we can give new allocation size. so it is used this size in the memeory
    )
    private long id;
    @Column(name="st_name")
    private String name;
    private int grade;

    public long getId() {
        return id;
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

    @Override
    public String toString() {
        return "Student12{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
