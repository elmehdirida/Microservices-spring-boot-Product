package com.project.orderservice.request;

import com.project.orderservice.dto.OrderitemsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    List<OrderitemsDto> orderitemsdto;
}
