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
@Table(name="promotions")
public class Promotions implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="promo_id")
    private Integer promo_id;
    @Column(name="promotion_image")
    private String image;
    @Column(name="promo_name")
    private String name;
    @Column(name="promo_description")
    private String description; 
    @Column(name="promo_price")
    private float price;
     @Column(name="promo_category")
    private String category;

    public Promotions() {
    }

    public Integer getPromo_id() {
        return promo_id;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void setPromo_id(Integer promo_id) {
        this.promo_id = promo_id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }
  public Promotions(Integer promo_id, String image, String name, String description, float price, String category) {
        this.promo_id = promo_id;
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }   

}