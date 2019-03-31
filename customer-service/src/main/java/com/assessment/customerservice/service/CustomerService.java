package com.assessment.customerservice.service;

import com.assessment.customerservice.model.CustomerInfo;

import java.util.List;

public interface CustomerService {

     CustomerInfo getCustomerDetails(String skuId);
     List<CustomerInfo> getCustomerInventory();
    int saveCustomer(CustomerInfo customerInfo);
    int update(CustomerInfo customerInfo);
}

