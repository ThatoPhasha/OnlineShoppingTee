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
@Table(name="bank_details")
public class BankDetails implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="bank_id")
    private Integer bank_id;
    @Column(name="bank_acc")
    private Integer accNo;
    @Column(name="bank_holder")
    private String holder;
    @Column(name="bank_pin")
    private Integer pin; 

    public void setBank_id(Integer bank_id) {
        this.bank_id = bank_id;
    }

    public void setAccNo(Integer accNo) {
        this.accNo = accNo;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public Integer getBank_id() {
        return bank_id;
    }

    public Integer getAccNo() {
        return accNo;
    }

    public String getHolder() {
        return holder;
    }

    public Integer getPin() {
        return pin;
    }

}   