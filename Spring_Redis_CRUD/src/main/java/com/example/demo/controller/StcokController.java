package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Stock;
import com.example.demo.service.StockService;


@RestController
@RequestMapping("/stock")
@EnableCaching
public class StcokController {
	
	@Autowired
	private StockService stockService;

	@PostMapping
	public Stock save(@RequestBody Stock stock) {
		return stockService.save(stock);
	}

	@GetMapping
	@Cacheable("stock")
	public List<Stock> getAllProducts() {
		System.out.println("getAllProducts");
		return stockService.findAll();

	}
	@GetMapping("/{id}")
	public Optional<Stock> findStock(@PathVariable int id) {
		return stockService.findProductById(id);

	}
	@DeleteMapping("/{id}")
	public String deleteStock(@PathVariable int id) {
		return stockService.deleteProduct(id);

	}

}
