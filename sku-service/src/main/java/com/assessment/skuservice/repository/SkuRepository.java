package com.assessment.skuservice.repository;

import com.assessment.skuservice.entity.StockUnit;
import com.assessment.skuservice.entity.StockUnitRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface SkuRepository extends JpaRepository<StockUnit,String> {

    /*@Autowired
    JdbcTemplate jdbcTemplate;

    public StockUnit findById(String id){
        return jdbcTemplate.queryForObject("select * from stock_unit where id=?", new Object[] { id },
                new BeanPropertyRowMapper<StockUnit>(StockUnit.class));
    }

    public List<StockUnit> findAll(){
        List<StockUnit> stockunits= jdbcTemplate.query("select * from stock_unit",new StockUnitRowMapper());
        return stockunits;
    }*/

    @Query(value ="select number_of_items from stock_unit where id=?1",nativeQuery = true)
    Integer getProductNumber(String id);
        /*return jdbcTemplate.queryForObject("select number_of_items from stock_unit where id=?", new Object[] { id },
                new BeanPropertyRowMapper<HashMap>(HashMap.class));}*/


}
