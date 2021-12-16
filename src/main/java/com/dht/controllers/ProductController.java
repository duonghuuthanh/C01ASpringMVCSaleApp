/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dht.pojo.Product;
import com.dht.service.ProductService;
import com.dht.validators.ProductNameValidator;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author duonghuuthanh
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private ProductNameValidator productNameValidator;
   
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(productNameValidator);
    }
    
    @GetMapping("/admin/products")
    public String manageProducts(Model model) {
        model.addAttribute("product", new Product());
        
        return "product-admin";
    }
    
    @PostMapping("/admin/products")
    public String addProduct(Model model,
            @ModelAttribute("product") @Valid Product product,
            BindingResult result) {
        if (result.hasErrors())
            return "product-admin";
        
        if (product.getFile() != null) {
            try {
                Map res = this.cloudinary.uploader().upload(product.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                product.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (this.productService.addOrUpdate(product) == true)
            return "redirect:/";
        
        model.addAttribute("errMsg", "He thong da xay ra loi! Vui long quay lai sau!");
        return "product-admin";
    }
}
