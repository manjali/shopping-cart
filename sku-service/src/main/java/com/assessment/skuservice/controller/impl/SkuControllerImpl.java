package com.assessment.skuservice.controller.impl;

import com.assessment.skuservice.controller.SkuController;
import com.assessment.skuservice.entity.OrderInfo;
import com.assessment.skuservice.entity.StockUnit;
import com.assessment.skuservice.service.impl.SkuServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SkuControllerImpl implements SkuController{

@Autowired
SkuServiceImpl skuService;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public ResponseEntity viewAllSkuDetails() {
        List<StockUnit> stockUnits = skuService.getInventory();
        if(stockUnits!=null) {
            try {
                return new ResponseEntity(this.sendResponseList(stockUnits), HttpStatus.OK);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                //handle this excpetion
            }
        }
        return new ResponseEntity<>("No stock units are available",HttpStatus.NO_CONTENT);

    }

    @Override
    public ResponseEntity viewSkuDetails(String skuId) {
        StockUnit stockUnit = skuService.getSkuDetails(skuId);
        if(stockUnit.getNameofItem()!=null){
            return this.sendResponse(stockUnit);
        }
        else {
            return new ResponseEntity<>("No stockWithId", HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public ResponseEntity addSkuDetails(StockUnit provider) {
        return null;
    }
    /*
    1. to create an order first check if customer id is present from other service
    2. check quatity of each item in list<stockunits>. maintain that list into a hashmap.
    3. if all are available then success. else throw right exception.
     */

    @Override
    public ResponseEntity createOrder(OrderInfo orderInfo) {
        return null;
    }

    @Override
    public ResponseEntity getCustomerOrders(String custId) {
        return null;
    }

    public ResponseEntity sendResponse(StockUnit stUnit){
        return new ResponseEntity<>(stUnit, HttpStatus.OK);
    }

    public String sendResponseList(List<StockUnit> stUnits) throws JsonProcessingException {
        if (stUnits != null && stUnits.size() > 0) {
            return objectMapper.writeValueAsString(stUnits);

        }
        else{
            System.out.println("----------");//generate error
        }
        return null;
    }
}
