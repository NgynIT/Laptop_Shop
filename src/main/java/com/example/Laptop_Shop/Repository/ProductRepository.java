package com.example.Laptop_Shop.Repository;

import com.example.Laptop_Shop.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
