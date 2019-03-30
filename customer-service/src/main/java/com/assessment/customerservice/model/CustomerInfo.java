package com.assessment.customerservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerInfo {

    @Id
    private String customerId;

    private String customerName;

    private int contactNumber;

    private String address;

    public CustomerInfo() {
        super();
    }

    public CustomerInfo(String customerId, String cusomterName, int contactNumber, String address) {
        this.customerId = customerId;
        this.customerName = cusomterName;
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
        return customerName;
    }

    public void setCustomerName(String cusomterName) {
        this.customerName = cusomterName;
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
