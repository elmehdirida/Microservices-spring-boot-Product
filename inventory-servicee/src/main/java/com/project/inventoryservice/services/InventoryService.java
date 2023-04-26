package com.project.inventoryservice.services;

import com.project.inventoryservice.Response.InventoryResponse;
import com.project.inventoryservice.model.Inventory;

import java.util.List;

public interface InventoryService {
    public  List<InventoryResponse> isInStock(List<String> skuCode);
}
