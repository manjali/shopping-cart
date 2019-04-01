package com.assessment.skuservice.service.impl;

import com.assessment.skuservice.entity.StockUnit;
import com.assessment.skuservice.repository.SkuRepository;
import com.assessment.skuservice.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkuServiceImpl implements SkuService {


    @Autowired
    SkuRepository skuRepository;

    @Override
    public StockUnit getSkuDetails(String skuId) {
        Optional<StockUnit> stUnit = skuRepository.findById(skuId);
        return stUnit.get();
    }

    @Override
    public List<StockUnit> getInventory() {
        return skuRepository.findAll();
    }

    @Override
    public int getProductNumber(String skuId) {
        return 0;
    }

    @Override
    public StockUnit addSku(StockUnit stUnit) {
        return skuRepository.save(stUnit);
    }

}
