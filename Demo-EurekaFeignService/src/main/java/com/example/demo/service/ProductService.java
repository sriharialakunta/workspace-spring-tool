package com.example.demo.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name="DemoEurekaProductService",url="${productService}")
public interface ProductService {
	
	@GetMapping("/productdetails")
	public Object  getProductDetailsFromConfigServer();
	
	@GetMapping
	public ResponseEntity<List<Object>> getAllProducts();

	@GetMapping("{productId}")
	public Object getProduct(@PathVariable("productId") int id);

	@PostMapping
	public Object addProduct(@RequestBody Object product);

	@PutMapping("{productId}")
	public Object updateProduct(@PathVariable("productId") int id,@RequestBody Object product);

	@DeleteMapping("{productId}")
	public String deleteProduct(@PathVariable("productId") int id);

	@DeleteMapping
	public String deleteAllProducts();


}
