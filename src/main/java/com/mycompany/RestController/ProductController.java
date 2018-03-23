/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.RestController;

import com.mycompany.Model.Product;
import com.mycompany.Service.ProductService;
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
public class ProductController {

    @Autowired
    private ProductService prodService;

    List<Product> prodList = new ArrayList<>();

    @RequestMapping(value = "/products/all", method = RequestMethod.GET)
    public List<Product> allProducts() {
        return prodService.listProducts();
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public void addProduct(@RequestBody Product prod) {
        prodService.addProduct(prod);
    }

    @RequestMapping(value = "/DeleteProduct/{name}", method = RequestMethod.GET)
    public String DeleteProduct(@PathVariable("name") String prodName) {
        System.out.println("=========== " + prodName);

        String message = prodService.DeleteProduct(prodName);
        
        System.out.println("=========== " + message);
        return message;
    }
    
	
	@RequestMapping(method = RequestMethod.POST,value = "/updateProduct")
	public void updateProduct(@RequestBody Product product)
	{
		
		prodService.updateProduct(product);
		
	}
        
        
	@RequestMapping(method = RequestMethod.POST,value = "/supplier")
	public void updateQuantity(@RequestBody Product prod)
	{
		
		prodService.updateQuantity(prod);
		
	}
}

