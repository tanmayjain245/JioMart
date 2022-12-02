package com.jiomart.shop.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class CustomerVo {

    private int customerID;

    @NotBlank(message = "CustomerName should not be empty !")
    private String customerName;
    @NotBlank(message = "Address should not be empty !")
    private String address;
    @NotBlank(message = "City should not be empty !")
    private String city;
    @NotNull(message = "Postal Code is required")
    @Min(value = 100000, message = "Must be 6 digits")
    @Max(value = 999999, message = "Must be 6 digits")
    private int postalCode;
    @NotBlank(message = "Country should not be empty !")
    private String country;

    public CustomerVo() {
    }

    public CustomerVo(int customerID, String customerName, String address, String city, int postalCode, String country) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postalCode=" + postalCode +
                ", country='" + country + '\'' +
                '}';
    }
}
