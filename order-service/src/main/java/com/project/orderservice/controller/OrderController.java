package com.project.orderservice.controller;

import com.project.orderservice.request.OrderRequest;
import com.project.orderservice.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    OrderService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  String placeOrder(@RequestBody OrderRequest orderRequest){
        service.placeOrder(orderRequest);
        return  "Order Placed Successfully ";
    }

}
