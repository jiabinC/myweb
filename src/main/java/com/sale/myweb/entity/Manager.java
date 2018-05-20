package com.sale.myweb.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Manager {
    @Id
    private  String managerId;
    @Column(nullable = false)
    private  String managerPassword;


    public String getManagerId() {
        return managerId;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }
}

