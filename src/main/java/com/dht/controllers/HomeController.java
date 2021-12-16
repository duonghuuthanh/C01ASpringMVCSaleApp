/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.controllers;

import com.dht.pojo.Cart;
import com.dht.service.CategoryService;
import com.dht.service.ProductService;
import com.dht.sunsaleapp.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public void commonAttributes(Model model, HttpSession session) {
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("cartStats", Utils.countCart((Map<Integer, Cart>) session.getAttribute("cart")));
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
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
}
