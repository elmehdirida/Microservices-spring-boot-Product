package com.project.inventoryservice.controller;

import com.project.inventoryservice.Response.InventoryResponse;
import com.project.inventoryservice.model.Inventory;
import com.project.inventoryservice.services.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventorys")
@RequiredArgsConstructor
public class InvetoryController {
    @Autowired
    InventoryService service ;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public  List<InventoryResponse> inStock(@RequestParam List<String> skuCode){
        return  service.isInStock(skuCode);
    }
}
