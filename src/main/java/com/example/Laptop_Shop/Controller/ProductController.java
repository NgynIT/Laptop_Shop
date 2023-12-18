package com.example.Laptop_Shop.Controller;


import com.example.Laptop_Shop.Entity.Product;
import com.example.Laptop_Shop.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
    @Autowired
    private ProductRepository repository;
    @GetMapping("")
    // request is: http://localhost:8080/api/v1/product
    List<Product> getAllProduct(){

        return repository.findAll();
    }
    @GetMapping("/{id}")
    Product findById(@PathVariable Long id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Cannot find product with id = "+id));
    }
}
