package com.assessment.skuservice.controller;

import com.assessment.skuservice.entity.OrderInfo;
import com.assessment.skuservice.entity.StockUnit;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@RequestMapping("/sku")
public interface SkuController {

    @GetMapping(value="/viewAll", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity viewAllSkuDetails();

    @GetMapping(value="/view", params = {"skuId"}, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity viewSkuDetails(String skuId);

    @PostMapping(value="/addSku", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity addSkuDetails(@RequestBody StockUnit provider);

    @PostMapping(value="/createOrder", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity createOrder(@RequestBody OrderInfo orderInfo);

    @GetMapping(value="/viewOrderPerCustomer", params = {"custId"},produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity getCustomerOrders(String custId);
}
