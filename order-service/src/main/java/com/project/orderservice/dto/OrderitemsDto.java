package com.project.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderitemsDto {
    private String skucode;
    private BigDecimal price;
    private Integer quantite;
}
