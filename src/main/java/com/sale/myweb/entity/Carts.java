package com.sale.myweb.entity;

import org.springframework.data.repository.query.Param;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author abin
 * @version 1.0
 * @date 2018/5/20 18:09
 */


@Entity
public class Carts {
    @Id
    private String cartId;

    @Column
    private String clothId;

    @Column
    private String clothNum;

    public String getCartId() {
        return cartId;
    }

    public String getClothId() {
        return clothId;
    }

    public String getClothNum() {
        return clothNum;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public void setClothId(String clothId) {
        this.clothId = clothId;
    }

    public void setClothNum(String clothNum) {
        this.clothNum = clothNum;
    }

}
