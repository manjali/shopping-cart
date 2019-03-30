package com.assessment.skuservice.service.impl;

import com.assessment.skuservice.entity.StockUnit;
import com.assessment.skuservice.repository.SkuRepository;
import com.assessment.skuservice.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkuServiceImpl implements SkuService {


    @Autowired
    SkuRepository skuRepository;

    @Override
    public StockUnit getSkuDetails(String skuId) {
        return skuRepository.findById(skuId);
    }

    @Override
    public List<StockUnit> getInventory() {
        return skuRepository.findAll();
    }
}
