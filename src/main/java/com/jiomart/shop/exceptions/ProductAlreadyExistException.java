package com.jiomart.shop.exceptions;

public class ProductAlreadyExistException extends Exception{

    public ProductAlreadyExistException(Integer pid) {
        super("Product Already Exist with pid : "+pid);
    }
}
