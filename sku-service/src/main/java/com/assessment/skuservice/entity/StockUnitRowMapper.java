package com.assessment.skuservice.entity;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StockUnitRowMapper implements RowMapper<StockUnit> {


    @Nullable
    @Override
    public StockUnit mapRow(ResultSet rs, int i) throws SQLException {
        StockUnit stockUnit = new StockUnit();
        stockUnit.setId(rs.getString("id"));
        stockUnit.setNameofItem(rs.getString("nameof_Item"));
        stockUnit.setPrice(rs.getLong("price"));
        stockUnit.setNumberOfItems(rs.getInt("number_Of_Items"));
        return stockUnit;
    }
}
