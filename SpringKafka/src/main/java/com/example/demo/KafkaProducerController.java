package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {
	
	private KafkaProducer kafkaProducer;
	
	
	public KafkaProducerController(KafkaProducer kafkaProducer) {
		super();
		this.kafkaProducer = kafkaProducer;
	}
	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message){
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok ("Message sent to kafka topic");
	}
	
	@GetMapping("/publish/obj")
	public ResponseEntity<String> publish(@RequestBody Product product){
		kafkaProducer.sendMessage(product);
		return ResponseEntity.ok("Message sent to kafka topic");
	}
}
