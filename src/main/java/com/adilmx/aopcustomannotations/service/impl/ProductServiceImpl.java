package com.adilmx.aopcustomannotations.service.impl;

import com.adilmx.aopcustomannotations.annotation.Log;
import com.adilmx.aopcustomannotations.model.Product;
import com.adilmx.aopcustomannotations.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    @Log
    public double getTotalPrice(Product product, int quantity) {
        System.out.println("getting price process started from inner scope...");
        if (product != null) {
            double unitPrice = product.getPrice();
            double totalPrice = unitPrice * quantity;
            return totalPrice;
        }
        return 0;
    }

    @Override
    public double getTotalPriceTax(Product product, int quantity, double tax) {
        System.out.println("getting price process started from inner scope...");
        if (product != null) {
            double unitPrice = product.getPrice();
            double totalPrice = unitPrice * quantity;
            double taxPrice = totalPrice + totalPrice*tax;
            return taxPrice;
        }
        return 0;
    }

}
