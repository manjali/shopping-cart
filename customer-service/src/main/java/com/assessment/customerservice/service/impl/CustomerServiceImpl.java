package com.assessment.customerservice.service.impl;

import com.assessment.customerservice.exception.InvalidResponseFromServiceException;
import com.assessment.customerservice.model.CustomerInfo;
import com.assessment.customerservice.repository.CustomerRepository;
import com.assessment.customerservice.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    private static final Logger LOGGER = LogManager.getLogger(CustomerServiceImpl.class);

    @Override
    public CustomerInfo getCustomerDetails(String custId) throws InvalidResponseFromServiceException{
        CustomerInfo cInfo = customerRepository.findById(custId);
         if(cInfo !=null){
            return cInfo;

        }
        else
            throw new InvalidResponseFromServiceException();
    }

    @Override
    public List<CustomerInfo> getCustomerInventory() {
        return customerRepository.findAll();
    }

    @Override
    public int saveCustomer(CustomerInfo customerInfo) {
        LOGGER.info("Saving Customer Information :: "+customerInfo.getCustomerId());
       return customerRepository.save(customerInfo);
    }

    @Override

    public int update(CustomerInfo customerInfo) {
        LOGGER.info("Updating Customer Information ::"+customerInfo.getCustomerId());
        return customerRepository.update(customerInfo);
    }
}
