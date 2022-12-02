package com.jiomart.shop.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Order_10709314")
public class Order {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int orderID;
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @ManyToOne @JoinColumn(name = "customerId")
    private Customer customer;
    @ManyToOne @JoinColumn(name = "shipperId")
    private Shipper shipper;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) @JoinColumn(name = "orderId")
    private List<OrderDetails> orderDetails;

    public Order() {
    }

    public Order(int orderID, int customerID, Date orderDate, int shipperID) {
        this.orderID = orderID;
        //this.customerID = customerID;
        this.orderDate = orderDate;
        //this.shipperID = shipperID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

//    public int getCustomerID() {
//        return customerID;
//    }
//
//    public void setCustomerID(int customerID) {
//        this.customerID = customerID;
//    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

//    public int getShipperID() {
//        return shipperID;
//    }
//
//    public void setShipperID(int shipperID) {
//        this.shipperID = shipperID;
//    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderID=" + orderID +
//                ", customerID=" + customerID +
                ", orderDate=" + orderDate +
//                ", shipperID=" + shipperID +
                '}';
    }
}
