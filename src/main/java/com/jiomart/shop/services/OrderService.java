package com.jiomart.shop.services;


import com.jiomart.shop.entity.Customer;
import com.jiomart.shop.entity.OrderDetails;
import com.jiomart.shop.entity.Shipper;
import com.jiomart.shop.exception.CustomerException;
import com.jiomart.shop.exception.ShipperException;
import com.jiomart.shop.repository.CustomerRepository;
import com.jiomart.shop.repository.OrderDetailsRepository;
import com.jiomart.shop.repository.OrderRepository;
import com.jiomart.shop.entity.Order;
import com.jiomart.shop.repository.ShipperRepository;
import com.jiomart.shop.vo.OrderDetailsVo;
import com.jiomart.shop.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailsRepository orderDetailsRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ShipperRepository shipperRepository;

    public ResponseEntity<List<Order>> getOrder(){
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }

    public void saveOrder(OrderVo order) throws ParseException {
        Order order1 = convertToOrders(order);
        if(customerRepository.findById(order.getCustomerID()).isEmpty())
            throw new CustomerException("Customer not found with id: "+order.getCustomerID());
        if(shipperRepository.findById(order.getShipperID()).isEmpty())
            throw new ShipperException("Shipper not found with id: "+order.getShipperID());
        orderRepository.save(order1);
    }
    static Order convertToOrders(OrderVo orderVo) throws ParseException {
        Order order = new Order();
        order.setOrderDate(new SimpleDateFormat("yyyy-MM-dd").parse(orderVo.getOrderDate()));
        Customer customers = new Customer();
        customers.setCustomerID(orderVo.getCustomerID());
        order.setCustomer(customers);
        Shipper shippers = new Shipper();
        shippers.setShipperID(orderVo.getShipperID());
        order.setShipper(shippers);
        List<OrderDetails> orderDetails = new ArrayList<>();   // Generics
        for(OrderDetailsVo orderDetailsVo : orderVo.getOrderDetails()){   //for-each
            orderDetails.add(OrderDetailsService.convertToOrderDetail(orderDetailsVo));
        }
        order.setOrderDetails(orderDetails);
        return order;
    }
}
