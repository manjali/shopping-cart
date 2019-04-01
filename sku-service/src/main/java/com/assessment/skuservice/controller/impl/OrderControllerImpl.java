package com.assessment.skuservice.controller.impl;

import com.assessment.skuservice.controller.OrderController;
import com.assessment.skuservice.entity.OrderInfo;
import com.assessment.skuservice.service.impl.OrderServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger LOGGER = LogManager.getLogger(OrderControllerImpl.class);

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
            LOGGER.info("Creating a new Order");
            response = orderService.addOrder(orderInfo);
            if (response.equals("Success")) {
                return new ResponseEntity("Created Order", HttpStatus.CREATED);
            }
        } catch (Exception e) {
            LOGGER.error(e.toString());
        }
            return new ResponseEntity("Order Creation Failed", HttpStatus.INTERNAL_SERVER_ERROR);


    }

    @Override
    //TBD
    public ResponseEntity getCustomerOrders(String custId) {
        return null;
    }

    @Override
    //TBD
    public ResponseEntity viewOrder(String custId) {
        return null;
    }
}
