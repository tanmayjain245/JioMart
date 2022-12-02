package com.jiomart.shop.controller;

import com.jiomart.shop.entity.Product;
import com.jiomart.shop.exceptions.ProductAlreadyExistException;
import com.jiomart.shop.exceptions.SupplierNotFoundException;
import com.jiomart.shop.services.ProductService;
import com.jiomart.shop.exceptions.ProductNotFoundException;
//import com.example.demo.services.ProductService;
import com.jiomart.shop.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
@Validated
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/api/v1/products")
    ResponseEntity<List<Product>> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/api/v1/products/{pid}")
    ResponseEntity<Product> getProductByPid(@PathVariable Integer pid) throws ProductNotFoundException {
        return productService.getProductByPid(pid);
    }

    @PostMapping("/api/v1/products")
    ResponseEntity<String> saveProduct(@RequestBody @Valid List<ProductVo> products) throws ProductAlreadyExistException, SupplierNotFoundException, ConstraintViolationException {
        productService.saveProduct(products);
        return new ResponseEntity<>("Added !",HttpStatus.OK);
    }

    @PutMapping("/api/v1/product")
    ResponseEntity<String> updateProduct(@RequestBody @Valid List<ProductVo> products) throws ProductNotFoundException, SupplierNotFoundException, ConstraintViolationException {
        productService.updateProduct(products);
        return new ResponseEntity<>("Updated !",HttpStatus.OK);
    }


  //             ---------------- via json  -------------

//    @GetMapping("/api/v1/products")
//    ResponseEntity<List<Product>> getProducts() {
//        return new ResponseEntity<List<Product>>(ProductUtils.getProductsList(), HttpStatus.OK);
//    }
//
//    @GetMapping("/api/v1/products/{pid}")
//    ResponseEntity<Product> getProductByPid(@PathVariable Integer pid) throws ProductNotFoundException {
//        return new ResponseEntity<Product>(ProductUtils.getProductByPid(pid), HttpStatus.OK);
//    }
//
//    @PostMapping("/api/v1/products")
//    ResponseEntity<String> saveProduct(@Validated @RequestBody List<Product> products) throws ResourceAlreadyExistException, JsonProcessingException {
//        for (Product product : products) {
//            if (product != null) {
//                ProductUtils.saveProduct(product);
//            }
//        }
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @PutMapping("/api/v1/products")
//    ResponseEntity<String> updateProducts(@Validated @RequestBody List<Product> products) throws ProductNotFoundException, JsonProcessingException {
//        ProductUtils.updateProducts(products);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
