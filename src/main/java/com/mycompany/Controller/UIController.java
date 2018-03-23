package com.mycompany.Controller;

import com.mycompany.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author Tee
 */
@Controller
public class UIController {
    
    @Autowired
    private ProductService productService; 
    
    @RequestMapping(value="/",method=RequestMethod.GET)
    public String index(){
        return "index";
    }
    @RequestMapping(value="/home",method=RequestMethod.GET)
    public String home(){
        return "home";
    }
    @RequestMapping(value="/registration",method=RequestMethod.GET)
    public String registration(){
        return "registration";
    }
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value="/admin",method=RequestMethod.GET)
    public String admin(){
        return "admin";
    }
    
    @RequestMapping(value="/addProduct",method=RequestMethod.GET)
    public String addProduct(){
        return "addProduct";
    }
    @RequestMapping(value="/products",method=RequestMethod.GET)
    public String products(){
        return "products";
    }
    @RequestMapping(value="/adminProducts",method = RequestMethod.GET)
    public String adminProducts(){
        return "adminProducts";
    }
//    @RequestMapping(value="/cart",method=RequestMethod.GET)
//    public String cart(){
//        return "cart";
//    }
      @RequestMapping(value="/customersList",method=RequestMethod.GET)
    public String custView(){
        return "customersList";
    }
         @RequestMapping(value="/customerProducts",method=RequestMethod.GET)
    public String custProducts(){
        return "customerProducts";
    }
        @RequestMapping(value="/customerPromotions",method=RequestMethod.GET)
    public String custPromotions(){
        return "customerPromotions";
    }
    
         @RequestMapping(value="/contactUs",method=RequestMethod.GET)
    public String contactUs(){
        return "contactUs";
    }
      @RequestMapping(value="/supplier",method=RequestMethod.GET)
    public String supplier(){
        return "supplier";
    }
      @RequestMapping(value="/driver",method=RequestMethod.GET)
    public String driver(){
        return "driver";
    }
      @RequestMapping(value="/updateProduct",method=RequestMethod.GET)
    public String update(){
        return "admin";
    }
     @RequestMapping(value="/promotions",method=RequestMethod.GET)
    public String promotions(){
        return "promotions";
    }
      @RequestMapping(value="/addPromotions",method=RequestMethod.GET)
    public String addPromotions(){
        return "addPromotions";
    }
      @RequestMapping(value="/requestStock",method=RequestMethod.GET)
    public String requestStock(){
        return "requestStock";
    }
      @RequestMapping(value="/replyRequest",method=RequestMethod.GET)
    public String replyRequest(){
        return "replyRequest";
    }
      @RequestMapping(value="/supplyProducts",method=RequestMethod.GET)
    public String supplyProduct(){
        return "supplyProducts";
    }

       @RequestMapping(value="/checkout",method=RequestMethod.GET)
    public String checkout(){
        return "checkout";
    }
    
    @RequestMapping(value="/updateProd",method=RequestMethod.GET)
    public String updateProd(){
        return "updateProd";
    }
    
     @RequestMapping(value="/updateRequest",method=RequestMethod.GET)
    public String updateRequest(){
        return "updateRequest";
    }
     @RequestMapping(value="/supplyRespond",method=RequestMethod.GET)
    public String supplyRespond(){
        return "supplyRespond";
    }
      
     @RequestMapping(value="/updateStatus",method=RequestMethod.GET)
    public String updateStatus(){
        return "updateStatus";
    }
      @RequestMapping(value="/adminOrders",method=RequestMethod.GET)
    public String adminOrders(){
        return "adminOrders";
    }
      @RequestMapping(value="/addProd",method=RequestMethod.GET)
    public String addProd(){
        return "addProd";
    }
    
      @RequestMapping(value="/adminRequest",method=RequestMethod.GET)
    public String adminRequest(){
        return "adminRequest";
    }
//    @RequestMapping(value="/{pageName}",method=RequestMethod.GET)
//    public String redirect(@PathVariable("pageName") String pageName){
//        System.out.println("++++++++++");
//        return pageName;
//    }
    
}
