package com.jiomart.shop.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ShipperVo {


    private int shipperID;
    @NotBlank(message = "ShipperName should not be empty !")
    private String ShipperName;
    @NotNull(message = "Phone No. is required")
    @Size(min=10,max=10)
    private int phone;

    public ShipperVo() {
    }

    public ShipperVo(int shipperID, String shipperName, int phone) {
        this.shipperID = shipperID;
        ShipperName = shipperName;
        this.phone = phone;
    }

    public int getShipperID() {
        return shipperID;
    }

    public void setShipperID(int shipperID) {
        this.shipperID = shipperID;
    }

    public String getShipperName() {
        return ShipperName;
    }

    public void setShipperName(String shipperName) {
        ShipperName = shipperName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "shipperID=" + shipperID +
                ", ShipperName='" + ShipperName + '\'' +
                ", phone=" + phone +
                '}';
    }
}
