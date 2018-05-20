package com.sale.myweb.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Orders {
    @Id
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String orderId;

    @Column
    private String orderAddress;

    @Column
    private String orderTel;
    @Column
    private String orderState;
    @Column
    private String orderTran;
    @Column
    private String orderName;

    public String getOrderAddress() {
        return orderAddress;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public String getOrderState() {
        return orderState;
    }

    public String getOrderTel() {
        return orderTel;
    }

    public String getOrderTran() {
        return orderTran;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel;
    }

    public void setOrderTran(String orderTran) {
        this.orderTran = orderTran;
    }

}
