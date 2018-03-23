/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.mycompany.Model.Product;
import com.mycompany.Model.Stock;
import com.mycompany.Repositories.StockRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tee
 */
@Service
public class StockService {
    
    @Autowired
    private StockRepository stRep;
    
    public List<Stock> listStock(){
        List<Stock> allStock = new ArrayList<>();
        stRep.findAll().forEach(allStock::add);
        return allStock;
    }
    
    public void requestStock(Stock st){
        stRep.save(st);
    }
    
     public String DeleteStock(String stName) {
        
        List<Stock> list = new ArrayList<>();
        
        
        Iterable<Stock> findAll = stRep.findAll();
        findAll.forEach(list::add);
        
        int sizeBefore = list.size();
        
      Stock st = stRep.findByName(stName);
        
        stRep.delete(st);
        
        Iterable<Stock> findAllAfter = stRep.findAll();
        findAllAfter.forEach(list::add);
        
        int sizeAfter = list.size();
        
        if(sizeAfter <sizeBefore ){
            return "Deleted";
        }else{
            return "Fail to delete";
        }
    }
     	//update Product using product id
	public void updateRequest(Stock stock) {
		
		
		stRep.save(stock);
                
		
	}

} 

