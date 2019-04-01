package com.assessment.skuservice.repository;

import com.assessment.skuservice.entity.CustomerProductRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCustomerRepository extends JpaRepository<CustomerProductRelation,String> {

    @Query(value = "select customer_id from customer_product_relation where order_id = ?1",nativeQuery = true)
    String findCustomer(String orderId);
}
