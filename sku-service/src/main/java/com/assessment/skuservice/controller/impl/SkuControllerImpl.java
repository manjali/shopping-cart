package com.assessment.skuservice.controller.impl;

import com.assessment.skuservice.controller.SkuController;
import com.assessment.skuservice.entity.StockUnit;
import com.assessment.skuservice.service.impl.SkuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkuControllerImpl implements SkuController{

@Autowired
SkuServiceImpl skuService;

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
}
