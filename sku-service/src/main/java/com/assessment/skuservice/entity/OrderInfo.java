package com.assessment.skuservice.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderInfo {

    @JsonProperty(value = "orderId")
    private String orderId;
    @JsonProperty(value = "customerId")
    private String customerId;
    @JsonProperty(value = "stockunits")
    private List<StockUnit> stockunits;

    public OrderInfo() {
        super();
    }

    public OrderInfo(String orderId, String customerId, List<StockUnit> stockunits) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.stockunits = stockunits;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<StockUnit> getStockunits() {
        return stockunits;
    }

    public void setStockunits(List<StockUnit> stockunits) {
        this.stockunits = stockunits;
    }
}
