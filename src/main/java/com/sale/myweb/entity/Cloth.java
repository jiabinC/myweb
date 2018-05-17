package com.sale.myweb.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Cloth implements Serializable {



    @Id
    @GeneratedValue
    private String cId;

    @Column(nullable = false)
    private  String cImage;

    @Column(nullable = false)
    private String cName;

    @Column(nullable = false)
    private  String cPrice;

    @Column(nullable = false)
    private  String cDiscount;

    @Column(nullable = false)
    private  String cStore;


    public String getcDiscount() {
        return cDiscount;
    }

    public String getcId() {
        return cId;
    }

    public String getcImage() {
        return cImage;
    }

    public String getcName() {
        return cName;
    }

    public String getcPrice() {
        return cPrice;
    }

    public String getcStore() {
        return cStore;
    }

    public void setcDiscount(String cDiscount) {
        this.cDiscount = cDiscount;
    }

    public void setcImage(String cImage) {
        this.cImage = cImage;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public void setcPrice(String cPrice) {
        this.cPrice = cPrice;
    }

    public void setcStore(String cStore) {
        this.cStore = cStore;
    }
}
