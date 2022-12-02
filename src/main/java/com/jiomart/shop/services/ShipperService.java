package com.jiomart.shop.services;


import com.jiomart.shop.repository.ShipperRepository;
import com.jiomart.shop.entity.Shipper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipperService {

    @Autowired
    ShipperRepository shipperRepository;

    public ResponseEntity<List<Shipper>> getShipper(){
        return new ResponseEntity<>(shipperRepository.findAll(), HttpStatus.OK);
    }
}
