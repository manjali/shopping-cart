package com.assessment.skuservice.repository;

import com.assessment.skuservice.entity.CustomerProductRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCustomerRepository extends JpaRepository<CustomerProductRelation,String> {
}
