/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.RestController;

import com.mycompany.Model.BankDetails;
import com.mycompany.Service.BankDetailsService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tee
 */
@RestController
public class BankDetailsController {

    @Autowired
    private BankDetailsService bankService;

   @RequestMapping(value="/bankdetails",method=RequestMethod.POST)
    public void placeBANK(@RequestBody BankDetails bank){
        bankService.saveBankDetails(bank);
    }
     
    @RequestMapping(method = RequestMethod.GET, value = "/pay",produces = {MediaType.APPLICATION_JSON_VALUE})
    public BankDetails accessBank(@RequestParam Integer bank_id,Integer accNo, String holder, Integer pin) {
        return bankService.pay(bank_id,accNo,holder, pin);
    }
}
