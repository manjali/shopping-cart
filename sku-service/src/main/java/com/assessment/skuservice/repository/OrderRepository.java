package com.assessment.skuservice.repository;

import com.assessment.skuservice.entity.CombinedKey;
import com.assessment.skuservice.entity.ProductsPerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<ProductsPerOrder,CombinedKey> {
}
