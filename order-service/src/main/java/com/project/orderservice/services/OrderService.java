package com.project.orderservice.services;

import com.project.orderservice.dto.OrderDto;
import com.project.orderservice.request.OrderRequest;

public interface OrderService {
     OrderDto placeOrder(OrderRequest orderRequest);

}
