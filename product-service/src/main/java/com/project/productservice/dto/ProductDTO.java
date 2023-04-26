package com.project.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
public class ProductDTO {
    private String name;
    private  String description;
    private BigDecimal price;
}
