package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.topics.AppConstants;
@Service
public class KafkaConsumer1 {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer1.class);

	@KafkaListener(topics=AppConstants.TOPIC_NAME, groupId=AppConstants.GROUP_ID)
	public void consume(Product product) {
		LOGGER.info(String.format("Message received -> %s", product.toString()));
	}
}
