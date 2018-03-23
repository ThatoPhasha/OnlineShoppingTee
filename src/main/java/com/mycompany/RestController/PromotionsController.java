/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.RestController;
import com.mycompany.Model.Promotions;
import com.mycompany.Service.PromotionsService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tee
 */
@RestController
public class PromotionsController {

    @Autowired
    private PromotionsService promoService;

    List<Promotions> promoList = new ArrayList<>();

    @RequestMapping(value = "/promotions/all", method = RequestMethod.GET)
    public List<Promotions> allPromotions() {
        return promoService.listPromotions();
    }

    @RequestMapping(value = "/addPromotions", method = RequestMethod.POST)
    public void addPromotions(@RequestBody Promotions promo) {
        promoService.addPromotions(promo);
    }
     @RequestMapping(value = "/DeletePromotions/{name}", method = RequestMethod.GET)
    public String DeletePromotions(@PathVariable("name") String promoName) {
        System.out.println("=========== " + promoName);

        String message = promoService.DeletePromotions(promoName);
        
        System.out.println("=========== " + message);
        return message;
    }
}


