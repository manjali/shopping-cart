package com.assessment.skuservice.repository;

import com.assessment.skuservice.entity.StockUnit;
import com.assessment.skuservice.entity.StockUnitRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SkuRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public StockUnit findById(String id){
        return jdbcTemplate.queryForObject("select * from stock_unit where id=?", new Object[] { id },
                new BeanPropertyRowMapper<StockUnit>(StockUnit.class));
    }

    public List<StockUnit> findAll(){
        List<StockUnit> stockunits= jdbcTemplate.query("select * from stock_unit",new StockUnitRowMapper());
        return stockunits;
    }
}
