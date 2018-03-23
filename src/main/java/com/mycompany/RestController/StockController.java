/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.RestController;

import com.mycompany.Model.Product;
import com.mycompany.Model.Stock;
import com.mycompany.Service.StockService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tee
 */
@RestController
public class StockController {

    @Autowired
    private StockService stService;

    List<Stock> stList = new ArrayList<>();

    @RequestMapping(value = "/stock/all", method = RequestMethod.GET)
    public List<Stock> allStock() {
        return stService.listStock();
    }

    @RequestMapping(value = "/requestStock", method = RequestMethod.POST)
    public void requestStock(@RequestBody Stock st) {
        stService.requestStock(st);
    }
      @RequestMapping(value = "/DeleteStock/{name}", method = RequestMethod.GET)
    public String DeleteStock(@PathVariable("name") String stName) {
        System.out.println("=========== " + stName);

        String message = stService.DeleteStock(stName);
        
        System.out.println("=========== " + message);
        return message;
    }
    
    @RequestMapping(method = RequestMethod.POST,value = "/updateRequest")
	public void updateRequest(@RequestBody Stock stock)
	{
		
		stService.updateRequest(stock);
		
	}
}
