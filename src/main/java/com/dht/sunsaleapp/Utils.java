/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.sunsaleapp;

import com.dht.pojo.Cart;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author duonghuuthanh
 */
public class Utils {
    public static Map<String, Long> countCart(Map<Integer, Cart> cart) {
        Long totalAmount = 0L, totalQuantity = 0L;
        
        if (cart != null) {
            for (Cart c: cart.values()) {
                totalQuantity += c.getQuantity();
                totalAmount += c.getQuantity()*c.getPrice();
            }
        }
        
        
        Map<String, Long> results = new HashMap<>();
        results.put("totalQuantity", totalQuantity);
        results.put("totalAmount", totalAmount);
        
        return results;
    }
}
