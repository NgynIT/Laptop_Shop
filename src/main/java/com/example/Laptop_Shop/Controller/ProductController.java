package com.example.Laptop_Shop.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
    @GetMapping("")
    // request is: http://localhost:8080/api/v1/product
    List<String> getAllProduct(){
        return List.of("iphone", "ipad");
    }
}
