package com.assessment.skuservice.controller.impl;

import com.assessment.skuservice.controller.SkuController;
import com.assessment.skuservice.entity.OrderInfo;
import com.assessment.skuservice.entity.StockUnit;
import com.assessment.skuservice.service.impl.SkuServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SkuControllerImpl implements SkuController{

    private static final Logger LOGGER = LogManager.getLogger(SkuControllerImpl.class);

@Autowired
SkuServiceImpl skuService;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public ResponseEntity viewAllSkuDetails() {
        List<StockUnit> stockUnits = skuService.getInventory();
        if(stockUnits!=null) {
            try {
                LOGGER.info("View all current records");
                return new ResponseEntity(this.sendResponseList(stockUnits), HttpStatus.OK);
            } catch (JsonProcessingException e) {
                LOGGER.error("Exception caught: "+e);
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


    public ResponseEntity sendResponse(StockUnit stUnit){
        return new ResponseEntity<>(stUnit, HttpStatus.OK);
    }

    public String sendResponseList(List<StockUnit> stUnits) throws JsonProcessingException {
        if (stUnits != null && stUnits.size() > 0) {
            return objectMapper.writeValueAsString(stUnits);

        }
        else{
            LOGGER.error("NO stock units available");//generate error
        }
        return null;
    }
}
