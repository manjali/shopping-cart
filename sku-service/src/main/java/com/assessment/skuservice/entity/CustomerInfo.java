package com.assessment.skuservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerInfo {


    private String customerId;

    private String cusomterName;

    private int contactNumber;

    private String address;

    public CustomerInfo() {
        super();
    }

    public CustomerInfo(String customerId, String cusomterName, int contactNumber, String address) {
        this.customerId = customerId;
        this.cusomterName = cusomterName;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCusomterName() {
        return cusomterName;
    }

    public void setCustomerName(String cusomterName) {
        this.cusomterName = cusomterName;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
