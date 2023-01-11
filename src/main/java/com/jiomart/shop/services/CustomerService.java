package com.jiomart.shop.services;


import com.jiomart.shop.exception.CustomerException;
import com.jiomart.shop.repository.CustomerRepository;
import com.jiomart.shop.entity.Customer;
//import com.example.demo.entity.Product;
import com.jiomart.shop.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public ResponseEntity<List<Customer>> getCustomer(){
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    public void saveCustomer(List<CustomerVo> customer)  {
        for (CustomerVo cust : customer) {
            if (customerRepository.findById(cust.getCustomerID()).isPresent()) {
                throw new CustomerException("Customer already exist with id: "+cust.getCustomerID());
            }
            customerRepository.save(getEntity(cust));
        }
    }

    public void updateCustomer(List<CustomerVo> customer) {
        for (CustomerVo c : customer) {
            if (customerRepository.findById(c.getCustomerID()).isEmpty()) {
                throw new CustomerException("Customer not found with id: "+c.getCustomerID());
            }
            customerRepository.save(getEntity(c));
        }
    }
    public Customer getEntity(CustomerVo customer){
        Customer c1=new Customer();
        c1.setCustomerID(customer.getCustomerID());
        c1.setCity(customer.getCity());
        c1.setAddress(customer.getAddress());
        c1.setCustomerName(customer.getCustomerName());
        c1.setCountry(customer.getCountry());
        c1.setPostalCode(customer.getPostalCode());
        return c1;
    }
}
