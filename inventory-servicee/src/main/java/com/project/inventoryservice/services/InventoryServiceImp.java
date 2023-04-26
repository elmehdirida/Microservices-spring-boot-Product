package com.project.inventoryservice.services;

import com.project.inventoryservice.Response.InventoryResponse;
import com.project.inventoryservice.dao.InventoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class InventoryServiceImp implements InventoryService {
    @Autowired
    InventoryDao inventoryDao ;
    @Override
    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) {
      return   inventoryDao.findBySkuCodeIn(skuCode).
              stream().map(inventory ->
                  InventoryResponse.builder()
                          .skuCode(inventory.getSkuCode())
                          .isInStock(inventory.getQuantite()>0)
                          .build()

              ).toList();

    }
}
