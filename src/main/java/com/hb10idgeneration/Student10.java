package com.hb10idgeneration;

import javax.persistence.*;

@Entity
@Table(name = "t_student10")
public class Student10 {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name="st_name")
    private String name;

    public int getId() {
        return id;
    }

  /*  public void setId(int id) {
        this.id = id;
    }
*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
