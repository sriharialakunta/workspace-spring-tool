package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Inventory;
import com.example.demo.service.InventoryConsumer;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/kafka")
//@AllArgsConstructor
public class ProductProducerController {
	@Autowired
	private InventoryConsumer consumer;
	
	@GetMapping("/publish/obj")
	private List<Inventory> getAll() {
		return consumer.consume();
	}

}