package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RefreshScope
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;

	
	@Value("${prductName}")
	String prductName;
	@Value("${prductBrand}")
	String prductBrand;
	@Value("${prductQuantity}")
	int prductQuantity;
	@Value("${prductPrice}")
	Double prductPrice;
	
	@GetMapping("/productdetails")
	public Product  getProductDetailsFromConfigServer(){
		return new Product(1, prductName, prductBrand, prductQuantity, prductPrice);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getProducts());

	}

	@GetMapping("{productId}")
	public Product getProduct(@PathVariable("productId") int id) {
		return service.getProductById(id);

	}

	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return service.addProduct(product);

	}
	@PutMapping("{productId}")
	public Product updateProduct(@PathVariable("productId") int id,@RequestBody Product product) {
		product.setPrductId(id);
		return service.addProduct(product);

	}
	@DeleteMapping("{productId}")
	public String deleteProduct(@PathVariable("productId") int id) {
		return service.deleteProductById(id);

	}

	@DeleteMapping
	public String deleteAllProducts() {
		return service.deleteProducts();

	}
}
