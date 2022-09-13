package com.microservices.orderservice.service;

import com.microservices.orderservice.domain.Order;

public interface OrderService {
    public Order saveOrder(Order order);
}
