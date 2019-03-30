package com.assessment.skuservice.service;

import com.assessment.skuservice.entity.StockUnit;

import java.util.List;

public interface SkuService {

    public StockUnit getSkuDetails(String skuId);
    public List<StockUnit> getInventory();
}
