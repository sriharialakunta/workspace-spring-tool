package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Inventory;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.service.util.AppConstants;

@Service
public class InventoryConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InventoryConsumer.class);

	@Autowired
	private InventoryRepository repository;
	
	@KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)
	public void consume(String input) {
		LOGGER.info(String.format("Product id, quantity recived -> %s", input));
		String[] inputs = input.split(",");
		System.out.println(inputs[0]);
		int id = Integer.parseInt(inputs[0]);
		int qty = Integer.parseInt(inputs[1]);
		repository.save(new Inventory(id, qty));

	}
	
	public List<Inventory> consume() {
		return repository.findAll();
	}

}
