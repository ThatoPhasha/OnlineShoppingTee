/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Tee
 */
@Entity
@Table(name="delivery")
public class Delivery implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="delivery_id")
    private Integer delivery_id;
    @Column(name="delivery_houseNo")
    private String houseNo;
    @Column(name="delivery_streetName")
    private String streetName;
    @Column(name="delivery_suburb")
    private String suburb; 
    @Column(name="delivery_province")
    private String province;
     

    public Delivery() {
    }

    public Integer getDelivery_id() {
        return delivery_id;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getProvince() {
        return province;
    }

    public void setDelivery_id(Integer delivery_id) {
        this.delivery_id = delivery_id;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public void setProvince(String province) {
        this.province = province;
    }
     public Delivery(Integer delivery_id, String houseNo, String streetName, String suburb, String province) {
        this.delivery_id = delivery_id;
        this.houseNo = houseNo;
        this.streetName = streetName;
        this.suburb = suburb;
        this.province= province;
    }

}
