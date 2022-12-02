package com.jiomart.shop.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

public class OrderVo {

    private int orderID;
    @NotNull(message = "Date is required") @Pattern(regexp = "^(2[0-9]{3})-(0[1-9]|1[012])-(0[1-9]|[12][1-9]|[3][01])", message = "date should be in yyyy-mm-dd format and should be valid")
    private String orderDate;
    @NotNull(message = "CustomerID is required")
    private int customerID;
    @NotNull(message = "ShipperID is required")
    private int shipperID;
    @NotNull(message = "Details Missing !")
    private List<OrderDetailsVo> orderDetails;

    public OrderVo() {
    }

    public OrderVo(int orderID, int customerID, String orderDate, int shipperID) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.shipperID = shipperID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getShipperID() {
        return shipperID;
    }

    public void setShipperID(int shipperID) {
        this.shipperID = shipperID;
    }


//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public Shipper getShipper() {
//        return shipper;
//    }
//
//    public void setShipper(Shipper shipper) {
//        this.shipper = shipper;
//    }

    public List<OrderDetailsVo> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailsVo> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderID=" + orderID +
                ", customerID=" + customerID +
                ", orderDate=" + orderDate +
                ", shipperID=" + shipperID +
                '}';
    }
}
