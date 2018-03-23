
package com.mycompany.RestController;

//import com.mycompany.Model.BankDetails;
import com.mycompany.Model.CustomerOrder;
import com.mycompany.Service.CustomersOrderService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tee
 */
@RestController
public class CustomerOrderController {
    
    
    @Autowired
    private CustomersOrderService customerOrderService;
    
    private List<CustomerOrder> customerOrdersList;
    
    @RequestMapping(method = RequestMethod.POST,value = "/placeOrder")
    public CustomerOrder saveOrder(@RequestBody CustomerOrder customerOrder)
    {
        customerOrderService.saveCustomerOrder(customerOrder);
        return customerOrder;
    }
    
// @RequestMapping(method = RequestMethod.POST,value = "/driver")
//    public CustomerOrder viewOrder(@RequestBody CustomerOrder customerOrder)
//    {
//       customerOrderService.customerOrder(customerOrder);
//        return customerOrder;
//   }
    
    @RequestMapping(method = RequestMethod.GET,value = "/customerOrder/all")
    public List<CustomerOrder> findAllcustomerOrders()
    {
        customerOrdersList = customerOrderService.findAllcustomerOrders();
        
        return customerOrdersList;
        
    }
    
  
}
