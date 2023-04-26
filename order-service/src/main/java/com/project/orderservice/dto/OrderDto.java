package com.project.orderservice.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderDto {
    private String orderNumber;
    private BigDecimal price;
}
