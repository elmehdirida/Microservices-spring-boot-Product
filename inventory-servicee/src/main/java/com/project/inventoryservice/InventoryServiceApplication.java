package com.project.inventoryservice;

import com.project.inventoryservice.dao.InventoryDao;
import com.project.inventoryservice.model.Inventory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner loadData(InventoryDao inventoryDao){
		return  args ->  {
			Inventory inventory1=new Inventory();
			Inventory inventory2 = new Inventory();
			inventory1.setSkuCode("redmi 6");
			inventory1.setQuantite(10);
			inventory2.setSkuCode("redmi note 8");
			inventory2.setQuantite(100);
			inventoryDao.save(inventory1);
			inventoryDao.save(inventory2);
		};
	}
}
