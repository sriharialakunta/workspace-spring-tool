package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ProductService;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/feignprod")
public class FeignProductController {

	@Autowired
	private ProductService service;

	private Logger log = LoggerFactory.getLogger(FeignProductController.class);
	@GetMapping("/productdetails")
	@Retry(name = "defult")
	public Object getProductDetailsFromConfigServer() {
		log.info("______----______RETRY_______----_____");
		return service.getProductDetailsFromConfigServer();
	}

	@GetMapping
	public ResponseEntity<List<Object>> getAllProducts() {
		return service.getAllProducts();

	}

	@GetMapping("{productId}")
	public Object getProduct(@PathVariable("productId") int id) {
		return service.getProduct(id);

	}

	@PostMapping
	public Object addProduct(@RequestBody Object product) {
		return service.addProduct(product);

	}

	@PutMapping("{productId}")
	public Object updateProduct(@PathVariable("productId") int id, @RequestBody Object product) {
		return service.addProduct(product);

	}

	@DeleteMapping("{productId}")
	public String deleteProduct(@PathVariable("productId") int id) {
		return service.deleteProduct(id);

	}

	@DeleteMapping
	public String deleteAllProducts() {
		return service.deleteAllProducts();

	}
}
