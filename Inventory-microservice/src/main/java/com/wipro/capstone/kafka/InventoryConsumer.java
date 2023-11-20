package com.wipro.capstone.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.wipro.capstone.entity.Inventory;
import com.wipro.capstone.repository.InventoryRepository;
import com.wipro.capstone.service.util.AppConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InventoryConsumer {

	@Autowired
	private InventoryRepository repository;
	
	
	@KafkaListener(topics = AppConstants.TOPIC_ADDPRODUCT, groupId = AppConstants.GROUP_ID)
	public void consume(String input) {
		log.info(String.format("Product id, quantity recived -> %s", input));
		String[] inputs = input.split(",");
		System.out.println(inputs[0]);
		int productid = Integer.parseInt(inputs[0]);
		int quantity = Integer.parseInt(inputs[1]);
		repository.save(new Inventory(productid,quantity));

	}
	@KafkaListener(topics = AppConstants.TOPIC_DELETEPRODUCT, groupId = AppConstants.GROUP_ID)
	public void deleteInventory(String input) {
		log.info(String.format("Product id, quantity recived -> %s", input));
//		String[] inputs = input;
//		System.out.println(inputs[0]);
		int productid = Integer.parseInt(input);
//		int quantity = Integer.parseInt(inputs[1]);
		Inventory inventory = repository.findByProductId(productid);
		repository.deleteById(inventory.getInventoryid());

	}
}
