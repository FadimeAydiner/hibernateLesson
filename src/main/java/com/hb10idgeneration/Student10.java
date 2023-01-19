package com.hb10idgeneration;

import javax.persistence.*;

@Entity
@Table(name = "t_student10")
public class Student10 {
    @Id
    @GeneratedValue(generator = "sequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="sequence",//It should be matching @GeneratedValue 's generator attribute
                        sequenceName = "std_sequence",//sequence that will be stored in DB
                        initialValue = 1001,//initial of id
                        allocationSize = 10//Deefault allacation size is 50. but If we dont nedd 50 id we can give new allocation size. so it is used this size in the memeory
    )
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
