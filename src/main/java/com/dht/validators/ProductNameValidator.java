/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.validators;

import com.dht.pojo.Product;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author duonghuuthanh
 */
@Component
public class ProductNameValidator implements Validator {
    @Autowired
    private javax.validation.Validator beanValidator;

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // Chay bean validate
        Set<ConstraintViolation<Object>> contraints 
                = this.beanValidator.validate(target);
        for (ConstraintViolation<Object> obj: contraints)
            errors.rejectValue(obj.getPropertyPath().toString(), 
                    obj.getMessageTemplate(), obj.getMessage());
        
        
        // Chay spring validate
        Product p = (Product) target;
        
        if (p.getName().contains("DHT") == false)
            errors.rejectValue("name", "product.name.containsError");
    }
    
}
