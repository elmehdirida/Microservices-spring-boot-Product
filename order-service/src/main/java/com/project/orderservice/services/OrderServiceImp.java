package com.project.orderservice.services;

import com.project.orderservice.dao.OrderDao;
import com.project.orderservice.dto.OrderDto;
import com.project.orderservice.dto.OrderitemsDto;
import com.project.orderservice.model.Order;
import com.project.orderservice.model.Orderitems;
import com.project.orderservice.request.OrderRequest;
import com.project.orderservice.response.InventoryResponse;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    OrderDao dao ;
    @Autowired
    WebClient.Builder webClientBuilder;

    @Override
    public OrderDto placeOrder(OrderRequest orderRequest) {
        BigDecimal totalPrice = BigDecimal.valueOf(0);
        Order order = new Order();
        OrderDto dto = OrderDto.builder().build();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<Orderitems> orderitems = new ArrayList<>();
        List<OrderitemsDto> orderitemsDtoList = orderRequest.getOrderitemsdto();
        for (OrderitemsDto orderitemsDto: orderitemsDtoList
             ) {
            Orderitems orderitems1 = new Orderitems();
            BeanUtils.copyProperties(orderitemsDto,orderitems1);
            orderitems.add(orderitems1);
            totalPrice =totalPrice.add(orderitemsDto.getPrice());
        }
        order.setPrice(totalPrice);
        order.setOrderitems(orderitems);
        List<String> list = new ArrayList<>();
        for (Orderitems orderitems1 : order.getOrderitems()) {
            String skucode = orderitems1.getSkucode();
            list.add(skucode);
        }
        InventoryResponse[] inventoryResponses = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventorys",uriBuilder -> uriBuilder
                        .queryParam("skuCode",list)
                        .build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();
        boolean instock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);
        if(instock)
            dao.save(order);
        else
            throw new IllegalArgumentException("product is not in Stock");
        BeanUtils.copyProperties(order,dto);
        return dto;
    }
}
