package com.assessment.skuservice.dao;

import com.assessment.skuservice.entity.StockUnit;

public interface SkuDao {
    public StockUnit getStockUnitById(String id);
}
