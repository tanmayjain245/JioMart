package com.jiomart.shop.controller;

import com.jiomart.shop.exceptions.CustomerNotFoundException;
import com.jiomart.shop.exceptions.ShipperNotFoundException;
import com.jiomart.shop.services.OrderService;
import com.jiomart.shop.entity.Order;
import com.jiomart.shop.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@Validated
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;


    @GetMapping("/api/v1/order")
    ResponseEntity<List<Order>> getOrder() {
        return orderService.getOrder();

    }
    @PostMapping("/api/v1/order")
    ResponseEntity<String> saveOrder(@RequestBody @Valid OrderVo order) throws CustomerNotFoundException, ParseException, ShipperNotFoundException {
        orderService.saveOrder(order);
        return new ResponseEntity<>("Added !",HttpStatus.OK);
    }
}