package com.example.Laptop_Shop.Db;

import com.example.Laptop_Shop.Entity.Product;
import com.example.Laptop_Shop.Repository.ProductRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConnect {
    private static final Logger logger = LoggerFactory.getLogger(DbConnect.class);//hiện thông tin chi tiết function trong class
    @Bean
    CommandLineRunner initDB(ProductRepository productRepository){
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {
                Product productA= new Product( "Macbook pro 15", 2020, 2200.0, "");
                Product productB= new Product( "Iphone 15 pro max", 2023, 600.0, "");
                logger.info("insert data: "+productRepository.save(productA));
                logger.info("insert data: "+productRepository.save(productB));
            }
        };
    }
}
