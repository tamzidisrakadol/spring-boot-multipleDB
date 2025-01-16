package com.example.multipledatabas.springboot.postgresql.Controller;

import com.example.multipledatabas.springboot.postgresql.Entity.Product;
import com.example.multipledatabas.springboot.postgresql.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductRepo productRepo;


    @PostMapping("/saveProduct")
    private void saveProduct(){
        Product product = Product.builder().name("xiaomi").quantity(10).build();
        productRepo.save(product);
        System.out.println("product is saved");
    }
}


