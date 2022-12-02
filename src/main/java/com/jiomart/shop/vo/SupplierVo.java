package com.jiomart.shop.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class SupplierVo {

    private int supplierID;
    @NotBlank(message = "SupplierName should not be empty !")
    private String supplierName;
    @NotBlank(message = "Address should not be empty !")
    private String address;
    @NotBlank(message = "City should not be empty !")
    private String city;
    private int postalCode;
    @Size(min=10,max=10)
    private int phone;

    public SupplierVo() {
    }

    public SupplierVo(int supplierID, String supplierName, String address, String city, int postalCode, int phone) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.phone = phone;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierID=" + supplierID +
                ", supplierName='" + supplierName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postalCode=" + postalCode +
                ", phone=" + phone +
                '}';
    }
}
