package com.sale.myweb.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Users implements Serializable {

    public  Users(String u_name,String u_age,String u_address,String u_password,String u_sex,String u_tel){
        this.userAddress=u_address;
        this.userAge=u_age;
        this.userName=u_name;
        this.userPassword=u_password;
        this.userSex=u_sex;
        this.userTel=u_tel;
    }
    Users(){

    }

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userAge;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private String userSex;

    @Column(nullable = false)
    private String userTel;

    @Column(nullable = false)
    private String userAddress;


    public String getUserAge() {
        return userAge;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserAddress(String u_address) {
        this.userAddress = u_address;
    }

    public void setUserId(String u_id) {
        this.userId = u_id;
    }

    public void setUserAge(String u_age) {
        this.userAge = u_age;
    }

    public void setUserName(String u_name) {
        this.userName = u_name;
    }

    public void setUserPassword(String u_password) {
        this.userPassword = u_password;
    }

    public void setUserSex(String u_sex) {
        this.userSex = u_sex;
    }

    public void setUserTel(String u_tel) {
        this.userTel = u_tel;
    }

}

