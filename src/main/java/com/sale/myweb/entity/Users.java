package com.sale.myweb.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Users implements Serializable {

    public  Users(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    public void setName(String name) {
        this.name = name;
    }



    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

}

