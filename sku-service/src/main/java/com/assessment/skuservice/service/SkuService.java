package com.assessment.skuservice.service;

import com.assessment.skuservice.entity.StockUnit;

public interface SkuService {

    public StockUnit getSkuDetails(String skuId);
}
