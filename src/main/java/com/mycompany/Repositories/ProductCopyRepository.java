
package com.mycompany.Repositories;

import com.mycompany.Model.ProductsCopy;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Tee
 */

public interface ProductCopyRepository extends CrudRepository<ProductsCopy, Integer>{
    
}
