/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.controllers;

import com.dht.pojo.Product;
import com.dht.pojo.User;
import com.dht.service.CategoryService;
import com.dht.service.ProductService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.validation.Valid;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author duonghuuthanh
 */
@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    
    @ModelAttribute
    public void commonAttributes(Model model) {
        model.addAttribute("categories", this.categoryService.getCategories());
    }
    
    @RequestMapping("/")
    public String index(Model model, 
            @RequestParam(value="kw", required = false) String kw,
            @RequestParam(value="cateId", required = false) Integer cateId) {
        if (cateId == null)
            model.addAttribute("products", this.productService.getProducts(kw));
        else
            model.addAttribute("products", this.productService.getProducts(cateId));
        
        return "index";
    }
    
    @GetMapping("/admin/products")
    public String manageProducts(Model model) {
        model.addAttribute("product", new Product());
        
        return "product-admin";
    }
    
    @PostMapping("/admin/products")
    public String addProduct(Model model,
            @ModelAttribute(value = "product") @Valid Product product,
            BindingResult result) {
        if (result.hasErrors())
            return "product-admin";
        
        if (this.productService.addOrUpdate(product) == true)
            return "redirect:/";
        
        model.addAttribute("errMsg", "He thong da xay ra loi! Vui long quay lai sau!");
        return "product-admin";
    }
}
