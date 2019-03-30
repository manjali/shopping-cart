package com.assessment.customerservice.controller.impl;

import com.assessment.customerservice.controller.CustomerController;
import com.assessment.customerservice.model.CustomerInfo;
import com.assessment.customerservice.service.impl.CustomerServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerControllerImpl implements CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public ResponseEntity viewAllCustomerInfo() {
        List<CustomerInfo> custUnits = customerService.getCustomerInventory();
        if(custUnits!=null && custUnits.size()>0) {
            try {
                return new ResponseEntity(this.sendResponseList(custUnits), HttpStatus.OK);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                //handle this excpetion
            }
        }
        return new ResponseEntity<>("No stock units are available",HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity viewCustomerInfo(String customerId) {

        CustomerInfo customerInfo = customerService.getCustomerDetails(customerId);

        if(customerInfo!=null && customerInfo.getCustomerId()!=null){
            return this.sendResponse(customerInfo);
        }
        else {
            return new ResponseEntity<>("No stockWithId", HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public ResponseEntity addCustomerDetails(CustomerInfo customerinfo) {
        return null;
    }

    public String sendResponseList(List<CustomerInfo> custUnits) throws JsonProcessingException {
        if (custUnits != null && custUnits.size() > 0) {
            return objectMapper.writeValueAsString(custUnits);

        }
        else{
            System.out.println("----------");//generate error
        }
        return null;
    }

    public ResponseEntity sendResponse(CustomerInfo cstUnit){
        return new ResponseEntity<>(cstUnit, HttpStatus.OK);
    }

}
