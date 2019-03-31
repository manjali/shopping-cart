package com.assessment.customerservice.controller.impl;

import com.assessment.customerservice.controller.CustomerController;
import com.assessment.customerservice.model.CustomerInfo;
import com.assessment.customerservice.service.impl.CustomerServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@RestController
public class CustomerControllerImpl implements CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    private static final Logger LOGGER = LogManager.getLogger(CustomerControllerImpl.class);

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public ResponseEntity viewAllCustomerInfo() {
        List<CustomerInfo> custUnits = customerService.getCustomerInventory();
        if(custUnits!=null && custUnits.size()>0) {
            try {
                return new ResponseEntity(this.sendResponseList(custUnits), HttpStatus.OK);
            } catch (JsonProcessingException e) {
                LOGGER.error("Error Processing Json::"+e);
                //handle this excpetion
            }
        }
        return new ResponseEntity<>("No stock units are available",HttpStatus.NO_CONTENT);
    }

    @Override
    public CustomerInfo viewCustomerInfo(String customerId) {

        CustomerInfo customerInfo = customerService.getCustomerDetails(customerId);

        if(customerInfo!=null && customerInfo.getCustomerId()!=null){
            LOGGER.info("Customer Info Found");
            return customerInfo;
        }
        else {
            LOGGER.info("No Customer Info Found with given CustomerId");
            return null;
            //return new ResponseEntity<>("No stockWithId", HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public ResponseEntity addCustomerDetails(CustomerInfo customerinfo) {
        return null;
    }

    @Override
    public Integer addDummyCustomer(@RequestBody String customerid) {
        CustomerInfo custInfo = new CustomerInfo(customerid,"",000,"");
        int customerInserted = customerService.saveCustomer(custInfo);
        return new Integer(customerInserted);
    }

    @Override
    public ResponseEntity editCustomerDetails(CustomerInfo customerinfo) {
        int customerInserted = customerService.update(customerinfo);
        if(customerInserted > 0){
            return new ResponseEntity("Customer Info successfully updated",HttpStatus.CREATED);
        }
        else
            return new ResponseEntity("Customer Info not updated",HttpStatus.INTERNAL_SERVER_ERROR);

    }

    public String sendResponseList(List<CustomerInfo> custUnits) throws JsonProcessingException {
        if (custUnits != null && custUnits.size() > 0) {
            return objectMapper.writeValueAsString(custUnits);

        }
        else{
            LOGGER.info("Generate ERROR.........");;//generate error
        }
        return null;
    }

    public ResponseEntity sendResponse(CustomerInfo cstUnit){
        return new ResponseEntity<>(cstUnit, HttpStatus.OK);
    }

}
