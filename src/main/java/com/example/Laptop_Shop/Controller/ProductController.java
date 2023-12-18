package com.example.Laptop_Shop.Controller;


import com.example.Laptop_Shop.Entity.Product;
import com.example.Laptop_Shop.Entity.ResponseObject;
import com.example.Laptop_Shop.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
    // request is: http://localhost:8080/api/v1/product/{id}
    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id){
        Optional<Product> foundProduct= repository.findById(id);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Query Product Successfully", foundProduct)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed","Cannot find product with id = "+id, "" )
                );
//        if (foundProduct.isPresent()){
//            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Query Product Successfully", foundProduct));
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false","Cannot find product with id = "+id, "" ));
//        }

    }
}
