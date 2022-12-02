package com.jiomart.shop.exceptions;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(Integer id) {
        super("No product found with pid: "+id);
    }
}
