package com.adilmx.aopcustomannotations;

import com.adilmx.aopcustomannotations.model.Product;
import com.adilmx.aopcustomannotations.service.ProductService;
import com.adilmx.aopcustomannotations.service.impl.ProductServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class AopCustomAnnotationsApplication {

    public static void main(String[] args) {
        /*SpringApplication.run(AopCustomAnnotationsApplication.class, args);*/
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ProductService productService = context.getBean(ProductService.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("insert your product :");
        System.out.print("reference : ");
        Long ref = scanner.nextLong();
        System.out.print("product name : ");
        String libelle = scanner.next();
        System.out.print("price : ");
        double price = scanner.nextDouble();
        Product product = new Product();
        product.setId(ref);
        product.setPrice(price);
        product.setLibelle(libelle);
        System.out.println("product saved temporary");
        System.out.println("------------------------------------------------------------------------------");
        System.out.print("quantity : ");
        int quantity = scanner.nextInt();
        System.out.print("TVA : ");
        double tax = scanner.nextDouble();
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("verify the creation of proxy with its name ************************************");
        System.out.println(productService.getClass().getName());
        System.out.println("*******************************************************************************");
        System.out.println("start the get total price process from main...");
        double totalPrice = productService.getTotalPrice(product,quantity);
        System.out.println("the total price of the product "+product.getLibelle()+" is "+totalPrice+" MAD");
        double totalPriceTax = productService.getTotalPriceTax(product,quantity,tax);
        System.out.println("the total price(+TVA) of the product "+product.getLibelle()+" is "+totalPriceTax+" MAD");

    }

}
