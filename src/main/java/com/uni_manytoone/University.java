package com.uni_manytoone;

import jdk.jfr.Enabled;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_university")
public class University {
    @Id
    private int id;

    @Column(name="uni_name",nullable = false,unique = true)
    private  String name;

}
