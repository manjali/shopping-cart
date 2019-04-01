package com.assessment.skuservice.service;

import com.assessment.skuservice.entity.StockUnit;

import java.util.List;

public interface SkuService {

     StockUnit getSkuDetails(String skuId);
     List<StockUnit> getInventory();
    int getProductNumber(String skuId);
    StockUnit addSku(StockUnit stUnit);
}
