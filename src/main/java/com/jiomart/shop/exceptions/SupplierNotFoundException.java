package com.jiomart.shop.exceptions;

public class SupplierNotFoundException extends Exception{

    public SupplierNotFoundException(Integer id) {
        super("No supplier found with id " + id);
    }
}
