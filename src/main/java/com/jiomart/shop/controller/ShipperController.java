package com.jiomart.shop.controller;

import com.jiomart.shop.services.ShipperService;
import com.jiomart.shop.entity.Shipper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class ShipperController {

    @Autowired
    ShipperService shipperService;

    @GetMapping("/api/v1/shipper")
    ResponseEntity<List<Shipper>> getShipper(){
        return shipperService.getShipper();
    }
}
