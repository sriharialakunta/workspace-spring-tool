package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.util.AppConstants;

@Service
public class ProductProducer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductProducer.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private ProductRepository repository;
	
	public void sendMessage(Product p) {
		LOGGER.info(String.format("Message sent -> %s", p));
		repository.save(p);
		String inventoryInput = p.getId()+","+p.getQty();
		kafkaTemplate.send(AppConstants.TOPIC_NAME, inventoryInput);
	}

}
