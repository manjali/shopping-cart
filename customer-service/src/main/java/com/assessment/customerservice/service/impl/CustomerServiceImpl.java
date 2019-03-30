package com.assessment.customerservice.service.impl;

import com.assessment.customerservice.model.CustomerInfo;
import com.assessment.customerservice.repository.CustomerRepository;
import com.assessment.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public CustomerInfo getCustomerDetails(String custId) {
        return customerRepository.findById(custId);
    }

    @Override
    public List<CustomerInfo> getCustomerInventory() {
        return customerRepository.findAll();


    }
}
