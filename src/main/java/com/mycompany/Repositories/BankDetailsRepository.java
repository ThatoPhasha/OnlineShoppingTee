/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Repositories;

import com.mycompany.Model.BankDetails;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Tee
 */
public interface BankDetailsRepository extends CrudRepository<BankDetails, Long>{
  
}