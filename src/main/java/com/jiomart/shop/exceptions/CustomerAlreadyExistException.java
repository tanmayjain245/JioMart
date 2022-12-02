package com.jiomart.shop.exceptions;

public class CustomerAlreadyExistException extends Exception{

    public CustomerAlreadyExistException(Integer id) {
        super("Customer already exist with id: "+id);
    }
}
