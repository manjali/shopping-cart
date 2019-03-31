package com.assessment.customerservice.util;

import com.assessment.customerservice.model.CustomerInfo;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerUnitRowMapper implements RowMapper<CustomerInfo> {


@Nullable
@Override
public CustomerInfo mapRow(ResultSet rs, int i) throws SQLException {
    CustomerInfo custInfo = new CustomerInfo();
    custInfo.setCustomerId(rs.getString("customer_id"));
    custInfo.setCustomerName(rs.getString("customer_name"));
    custInfo.setAddress(rs.getString("address"));
    custInfo.setContactNumber(rs.getInt("contact_number"));
        return custInfo;
        }
}
