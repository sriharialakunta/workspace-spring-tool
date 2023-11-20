package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductProducer;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/kafka")
@AllArgsConstructor
public class ProductProducerController {
	
	private ProductProducer producer;
	
	@PostMapping("/publish/obj")
	public ResponseEntity<String> publish(@RequestBody Product product){
		producer.sendMessage(product);
		return ResponseEntity.ok("Message sent to kafka topic");
	}
}