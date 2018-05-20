package com.sale.myweb.entity;

import org.springframework.data.repository.query.Param;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * @author abin
 * @version 1.0
 * @date 2018/5/20 18:09
 */


@Entity
@IdClass(CartsIds.class)
public class Carts implements Serializable {
    Carts() {

    }

    public Carts(String userId,String clothId,String clothNum) {
        this.userId = userId;
        this.clothId = clothId;
        this.clothNum = clothNum;
    }

    @Id
    private String userId;

    @Id
    private String clothId;

    @Column
    private String clothNum;

    public String getUserId() {
        return userId;
    }

    public String getClothId() {
        return clothId;
    }

    public String getClothNum() {
        return clothNum;
    }

    public void setUserId(String cartId) {
        this.userId = cartId;
    }

    public void setClothId(String clothId) {
        this.clothId = clothId;
    }

    public void setClothNum(String clothNum) {
        this.clothNum = clothNum;
    }

}


