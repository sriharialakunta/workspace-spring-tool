package com.wipro.capstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryMicroservicesApplication.class, args);
	}

}
