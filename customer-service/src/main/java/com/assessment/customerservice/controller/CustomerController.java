package com.assessment.customerservice.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.assessment.customerservice.model.CustomerInfo;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.*;

@RestController
@EnableAutoConfiguration
@RequestMapping("/customer")
public interface CustomerController {

    @GetMapping(value="/viewAll",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity viewAllCustomerInfo();

    @GetMapping(value="/view", params = {"customerId"},produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerInfo viewCustomerInfo(String customerId);

    @PostMapping(value="/addCustomer", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity addCustomerDetails(@RequestBody CustomerInfo customerinfo);

    @PostMapping(value="/addCustomerwithId", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity addDummyCustomer(@RequestBody String customerid);

    @PutMapping(value="/editCustomer", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity editCustomerDetails(@RequestBody CustomerInfo customerinfo);

}
