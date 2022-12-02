package com.jiomart.shop.entity;

import javax.persistence.*;

@Entity
@Table(name="Shipper_10709314")
public class Shipper {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int shipperID;
    private String ShipperName;
    private int phone;

    public Shipper() {
    }

    public Shipper(int shipperID, String shipperName, int phone) {
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
