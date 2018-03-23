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
@Table(name="stock")
public class Stock implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="stock_id")
    private Integer stock_id;
    @Column(name="stock_image")
    private String image;
    @Column(name="stock_name")
    private String name;
    @Column(name="stock_price")
    private float price; 
    @Column(name="stock_category")
    private String category;
     @Column(name="stock_quantity")
    private Integer quantity;

    public Stock() {
    }

    public Integer getStock_id() {
        return stock_id;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setStock_id(Integer stock_id) {
        this.stock_id = stock_id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Stock(Integer stock_id, String image, String name, float price, String category, Integer quantity) {
        this.stock_id = stock_id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }
    
}   

