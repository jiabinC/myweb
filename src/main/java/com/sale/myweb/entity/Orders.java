package com.sale.myweb.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Orders implements Serializable {

    Orders(){}
    public Orders(String userAddress,String orderState,String userTel,String orderTran,String detailId,String userId) {
        this.userAddress = userAddress;
        this.detailId = detailId;
        this.orderState = orderState;
        this.userTel = userTel;
        this.orderTran = orderTran;
        this.userId = userId;

    }

    @Id
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String orderId;





    @Column
    private String userAddress;

    @Column
    private String userTel;
    @Column
    private String orderState;
    @Column
    private String orderTran;

    @Column
    private String userId;

    @Column
    private String  detailId;



    public String getUserAddress() {
        return userAddress;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public String getOrderState() {
        return orderState;
    }

    public String getUserTel() {
        return userTel;
    }

    public String getOrderTran() {
        return orderTran;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public void setOrderTran(String orderTran) {
        this.orderTran = orderTran;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getDetailId() {
        return detailId;
    }
}


