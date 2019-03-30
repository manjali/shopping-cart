package com.assessment.customerservice.service;

import com.assessment.customerservice.model.CustomerInfo;

import java.util.List;

public interface CustomerService {

    public CustomerInfo getCustomerDetails(String skuId);
    public List<CustomerInfo> getCustomerInventory();
}

