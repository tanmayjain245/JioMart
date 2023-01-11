package com.jiomart.shop.exception.handler;

import com.jiomart.shop.exception.*;
import org.hsqldb.HsqlException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(ProductException.class)
    ResponseEntity<String> productNotFound(ProductException productException){
        return new ResponseEntity<>(productException.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CustomerException.class)
    ResponseEntity<String> customerNotFound(CustomerException customerException){
        return new ResponseEntity<>(customerException.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SupplierException.class)
    ResponseEntity<String> supplierNotFound(SupplierException supplierException){
        return new ResponseEntity<>(supplierException.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ShipperException.class)
    ResponseEntity<String> shipperNotFound(ShipperException shipperException){
        return new ResponseEntity<>(shipperException.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<String> methodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException){
        StringBuilder sb = new StringBuilder();
        methodArgumentNotValidException.getFieldErrors().forEach(err-> sb.append(err.getDefaultMessage()).append("\n"));
        return new ResponseEntity<>(sb.toString(),HttpStatus.valueOf(406));
    }

    @ExceptionHandler(HsqlException.class)
    ResponseEntity<String> HsqlDb(HsqlException hsqlException){
        return new ResponseEntity<>(hsqlException.getMessage(),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<String> constraintviolation(ConstraintViolationException constraintViolationException){
        return new ResponseEntity<>(constraintViolationException.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
//    @ExceptionHandler(JsonProcessingException.class)
//    ResponseEntity<String>jsonException(JsonProcessingException jsonProcessingException){
//        return new ResponseEntity<>(jsonProcessingException.getMessage(),HttpStatus.NOT_ACCEPTABLE);
//    }