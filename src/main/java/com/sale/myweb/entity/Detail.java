package com.sale.myweb.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(DetailId.class)
public class Detail {

    Detail(){}
    public Detail(String clothId,String clothNum) {
        this.clothId = clothId;
        this.clothNum = clothNum;
    }
    public Detail(String detailId,String clothId,String clothNum) {
        this.detailId = detailId;
        this.clothId = clothId;
        this.clothNum = clothNum;
    }

    @Id
    private String detailId;

    @Id
    private String clothId;

    @Column
    private String clothNum;


    public String getDetailId() {
        return detailId;
    }

    public String getClothId() {
        return clothId;
    }

    public void setClothId(String clothId) {
        this.clothId = clothId;
    }

    public void setClothNum(String clothNum) {
        this.clothNum = clothNum;
    }

    public String getClothNum() {
        return clothNum;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }
}


class DetailId implements Serializable {
    String detailId;
    String clothId;
}
