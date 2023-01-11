package com.jiomart.shop.controller;

import com.jiomart.shop.services.OrderService;
import com.jiomart.shop.entity.Order;
import com.jiomart.shop.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
@CrossOrigin
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
    ResponseEntity<String> saveOrder(@RequestBody @Valid OrderVo order) throws ParseException {
        orderService.saveOrder(order);
        return new ResponseEntity<>("Added !",HttpStatus.OK);
    }
}