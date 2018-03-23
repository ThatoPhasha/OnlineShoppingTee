/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.mycompany.Model.BankDetails;
import com.mycompany.Repositories.BankDetailsRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tee
 */
@Service
public class BankDetailsService {
    
    @Autowired
    private BankDetailsRepository bankRep;
   
    public void saveBank(BankDetails bank){
        bankRep.save(bank);
    }
    
    private static List<BankDetails> bank;
    
    public List<BankDetails> findAll(){
        bank = new ArrayList<>();
      bankRep.findAll().forEach(bank::add);
      return bank;
    }
    
    public BankDetails pay(Integer bank_id,Integer accNo, String holder, Integer pin)
    {
        BankDetails bank = null;
        List<BankDetails> bankList = findAll();
        for(int i = 0 ; i < bankList.size() ; i++)
        {
           if(bankList.get(i).getBank_id().equals(bank_id) && bankList.get(i).getAccNo().equals(accNo) && bankList.get(i).getHolder().equals(holder) && bankList.get(i).getPin().equals(pin)){
               bank = bankList.get(i);
               break;
           }else{
               
           }
        }
        return bank;
    }

    public void saveBankDetails(BankDetails bank) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}