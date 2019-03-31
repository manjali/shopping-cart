package com.assessment.skuservice.entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CombinedKey implements Serializable{

    @Column(name="order_id")
    private String orderId;

    @Column(name="product_id")
    private String productId;

    public CombinedKey() {
        super();
    }

    public CombinedKey(String orderId, String customerId) {
        this.orderId = orderId;
        this.productId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return productId;
    }

    public void setCustomerId(String customerId) {
        this.productId = customerId;
    }
}
