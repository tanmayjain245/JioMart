package com.jiomart.shop.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name="Product_10709314")
@Entity
public class Product {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int productID;

    @ManyToOne @JoinColumn(name = "supplierId")
    private Supplier supplier;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    private int unit;
    @NotNull
    private int Price;
    private String productName;

    public Product() {}

    public Product(int productID, int supplierID, int unit, int price, String productName) {
        this.productID = productID;
        //this.supplierID = supplierID;
        this.unit = unit;
        Price = price;
        this.productName = productName;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

//    public int getSupplierID() {
//        return supplierID;
//    }
//
//    public void setSupplierID(int supplierID) {
//        this.supplierID = supplierID;
//    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", Unit=" + unit +
                ", Price=" + Price +
                ", productName='" + productName + '\'' +
                '}';
    }
}
