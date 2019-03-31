package com.assessment.skuservice.service;

import com.assessment.skuservice.entity.OrderInfo;
import com.assessment.skuservice.exception.InsufficientNumberException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface OrderService {

    public String addOrder(OrderInfo order) throws InsufficientNumberException, Exception;

    public OrderInfo viewOrder(String orderId);


}
