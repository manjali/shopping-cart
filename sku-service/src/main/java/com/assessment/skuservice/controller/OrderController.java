package com.assessment.skuservice.controller;

import com.assessment.skuservice.entity.OrderInfo;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@RequestMapping("/order")
public interface OrderController {

    @PostMapping(value="/createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity createOrder(@RequestBody OrderInfo orderInfo);

    @GetMapping(value="/viewOrderPerCustomer", params = {"custId"},produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity getCustomerOrders(String custId);

    @GetMapping(value="/viewOrder", params = {"orderId"},produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity viewOrder(String orderId);
}
