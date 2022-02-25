package com.adilmx.aopcustomannotations.service;

import com.adilmx.aopcustomannotations.model.Product;

public interface ProductService {
    public double getTotalPrice(Product product, int quantity);
    public double getTotalPriceTax(Product product,int quantity,double tax);
}
