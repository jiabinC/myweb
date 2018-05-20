package com.sale.myweb.entity;
/**
 * @author abin
 * @date 2018/5/19 23:07
 * @version 1.0
 */


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Cloth implements Serializable {

    public Cloth(String clothImage,String clothDiscount,String clothName,String clothPrice,String clothStore,String clothType) {
        this.clothDiscount = clothDiscount;
        this.clothImage = clothImage;
        this.clothName = clothName;
        this.clothPrice = clothPrice;
        this.clothStore = clothStore;
        this.clothType = clothType;
    }

    Cloth() {}

    @Id
    @GeneratedValue
    private String clothId;

    @Column(nullable = false)
    private  String clothImage;

    @Column(nullable = false)
    private String clothName;

    @Column(nullable = false)
    private  String clothPrice;

    @Column(nullable = false)
    private  String clothDiscount;

    @Column(nullable = false)
    private  String clothStore;

    @Column(nullable = false)
    private String clothType;


    public String getClothDiscount() {
        return clothDiscount;
    }

    public String getClothId() {
        return clothId;
    }

    public String getClothImage() {
        return clothImage;
    }

    public String getClothName() {
        return clothName;
    }

    public String getClothPrice() {
        return clothPrice;
    }

    public String getClothStore() {
        return clothStore;
    }

    public void setClothDiscount(String cDiscount) {
        this.clothDiscount = cDiscount;
    }

    public void setClothImage(String cImage) {
        this.clothImage = cImage;
    }

    public void setClothId(String cId) {
        this.clothId = cId;
    }

    public void setClothName(String cName) {
        this.clothName = cName;
    }

    public void setClothPrice(String cPrice) {
        this.clothPrice = cPrice;
    }

    public void setClothStore(String cStore) {
        this.clothStore = cStore;
    }

    public String getClothType() {
        return clothType;
    }

    public void setClothType(String clothType) {
        this.clothType = clothType;
    }
}
