package com.jiomart.shop.repository;

import com.jiomart.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}



//TODO : procedure,function calling