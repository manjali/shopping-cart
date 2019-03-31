package com.assessment.skuservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerProductRelation {


    @Id
    private String customerId;

    private String orderId;

    public CustomerProductRelation() {
        super();
    }

    public CustomerProductRelation(String customerId, String orderId) {
        this.customerId = customerId;
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
