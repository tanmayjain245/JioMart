package com.jiomart.shop.controller;

import com.jiomart.shop.exceptions.CustomerAlreadyExistException;
import com.jiomart.shop.exceptions.CustomerNotFoundException;
import com.jiomart.shop.services.CustomerService;
import com.jiomart.shop.entity.Customer;
import com.jiomart.shop.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @GetMapping("/api/v1/customer")
    ResponseEntity<List<Customer>> getCustomer() {

        return customerService.getCustomer();
    }

    @PostMapping("/api/v1/customer")
    ResponseEntity<String> saveCustomer(@RequestBody @Valid List<CustomerVo> customer) throws CustomerAlreadyExistException {
        customerService.saveCustomer(customer);
        return new ResponseEntity<>("Added !",HttpStatus.OK);
    }

    @PutMapping("/api/v1/customer")
    ResponseEntity<String> updateCustomer(@RequestBody @Valid List<CustomerVo> customer) throws CustomerNotFoundException {
        customerService.updateCustomer(customer);
        return new ResponseEntity<>("Updated !",HttpStatus.OK);
    }
}
