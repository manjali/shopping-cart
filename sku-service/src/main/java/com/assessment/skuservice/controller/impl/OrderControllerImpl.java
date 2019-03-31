package com.assessment.skuservice.controller.impl;

import com.assessment.skuservice.controller.OrderController;
import com.assessment.skuservice.entity.OrderInfo;
import com.assessment.skuservice.service.impl.OrderServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerImpl implements OrderController
{
    @Autowired
    OrderServiceImpl orderService;

    /*
   1. to create an order first check if customer id is present from other service
   2. check quatity of each item in list<stockunits>. maintain that list into a hashmap.
   3. if all are available then success. else throw right exception.
    */
    @Override
    public ResponseEntity createOrder(@RequestBody OrderInfo orderInfo) {
        String response = null;
        try {
            /*ObjectMapper objectMapper = new ObjectMapper();
            OrderInfo orderInfo = objectMapper.readValue(order, OrderInfo.class);*/
            response = orderService.addOrder(orderInfo);
            if (response.equals("Success")) {
                return new ResponseEntity("Created Order", HttpStatus.CREATED);
            } else {
                return new ResponseEntity("Order Creation Failed", HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch (Exception e) {
            return new ResponseEntity("Order Creation Failed", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @Override
    public ResponseEntity getCustomerOrders(String custId) {
        return null;
    }

    @Override
    public ResponseEntity viewOrder(String custId) {
        return null;
    }
}
