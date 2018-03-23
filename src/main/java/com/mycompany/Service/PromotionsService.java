/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;
import com.mycompany.Model.Product;
import com.mycompany.Model.Promotions;
import com.mycompany.Repositories.PromotionsRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Tee
 */
@Service
public class PromotionsService {
    
    @Autowired
    private PromotionsRepository promoRep;
    
    public List<Promotions> listPromotions(){
        List<Promotions> allPromotions = new ArrayList<>();
        promoRep.findAll().forEach(allPromotions::add);
        return allPromotions;
    }
    
    public void addPromotions(Promotions promo){
        promoRep.save(promo);
    }
     public String DeletePromotions(String promoName) {
        
        List<Promotions> list = new ArrayList<>();
        
        
        Iterable<Promotions> findAll = promoRep.findAll();
        findAll.forEach(list::add);
        
        int sizeBefore = list.size();
        
        Promotions promo = promoRep.findByName(promoName);
        
        promoRep.delete(promo);
        
        Iterable<Promotions> findAllAfter = promoRep.findAll();
        findAllAfter.forEach(list::add);
        
        int sizeAfter = list.size();
        
        if(sizeAfter <sizeBefore ){
            return "Deleted";
        }else{
            return "Fail to delete";
        }
     }
}
