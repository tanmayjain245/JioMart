package com.jiomart.shop.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;


@Entity
@Table(name="OrderDetails_10709314")
public class OrderDetails {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int orderDetailID;
   // private int orderID;
    @ManyToOne @JoinColumn(name = "productId")
    private Product product;
    @Min(value = 1, message = "Minimum 1 quantity is required")
    private int quantity;

    public OrderDetails() {
    }

    public OrderDetails(int orderDetailID, int orderID, int productID, int quantity) {
        this.orderDetailID = orderDetailID;
       // this.orderID = orderID;
       // this.productID = productID;
        this.quantity = quantity;
    }

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

//    public int getOrderID() {
//        return orderID;
//    }
//
//    public void setOrderID(int orderID) {
//        this.orderID = orderID;
//    }
//
//    public int getProductID() {
//        return productID;
//    }
//
//    public void setProductID(int productID) {
//        this.productID = productID;
//    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderDetailID=" + orderDetailID +
//                ", orderID=" + orderID +
//                ", productID=" + productID +
                ", quantity=" + quantity +
                '}';
    }
}
