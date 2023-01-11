package com.jiomart.shop.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


public class ProductVo {

    private int productID;
    private int supplierID;
    @Min(value=1,message ="Minimum 1 unit is required !" )
    private int Unit;

    @Min(value=10,message = "Minimum 10 price is required !")
    private int Price;

    @NotBlank(message = "ProductName should not be empty !")
    private String productName;
    private String productImg;

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public ProductVo() {}

    public ProductVo(int productID, int supplierID, int unit, int price, String productName) {
        this.productID = productID;
        this.supplierID = supplierID;
        Unit = unit;
        Price = price;
        this.productName = productName;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public int getUnit() {
        return Unit;
    }

    public void setUnit(int unit) {
        Unit = unit;
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
                ", supplierID=" + supplierID +
                ", Unit=" + Unit +
                ", Price=" + Price +
                ", productName='" + productName + '\'' +
                '}';
    }
}
