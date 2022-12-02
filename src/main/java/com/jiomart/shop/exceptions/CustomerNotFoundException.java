package com.jiomart.shop.exceptions;

public class CustomerNotFoundException extends Exception{

    public CustomerNotFoundException(Integer id) {
        super("No customer found with id: "+id);
    }
}
