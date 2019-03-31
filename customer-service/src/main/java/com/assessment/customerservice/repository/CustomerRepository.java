package com.assessment.customerservice.repository;

import com.assessment.customerservice.model.CustomerInfo;
import com.assessment.customerservice.util.CustomerUnitRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public CustomerInfo findById(String id){
        return jdbcTemplate.queryForObject("select * from customer_info where customer_id=?", new Object[] { id },
                new CustomerUnitRowMapper());
    }

    public List<CustomerInfo> findAll(){
        List<CustomerInfo> customerInfos= jdbcTemplate.query("select * from customer_info",new CustomerUnitRowMapper());
        return customerInfos;
    }

    public int save(CustomerInfo cInfo){
        return jdbcTemplate.update("insert into customer_info(customer_id,address,contact_number,customer_name)"+" values(?,?,?,? )",
                new Object[] { cInfo.getCustomerId(), cInfo.getAddress(), cInfo.getContactNumber(),cInfo.getCusomterName()});
    }

    public int update(CustomerInfo cInfo){
        return jdbcTemplate.update("update customer_info set customer_id = ?,"+"address = ?,"+ " contact_number = ?,"+"customer_name = ?"+"where customer_id=?",
                new Object[] { cInfo.getCustomerId(), cInfo.getAddress(), cInfo.getContactNumber(),cInfo.getCusomterName(),cInfo.getCustomerId()});
    }
}
