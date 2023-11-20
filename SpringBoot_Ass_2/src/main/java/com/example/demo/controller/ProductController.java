package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public Optional<Product> getProductById(@PathVariable int id) {
		return productService.findById(id);
	}
	
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@PutMapping("/updateproduct/{id}")
	public Optional<Product> updateProduct(@RequestBody Product product,@PathVariable int id ) {
		return productService.updateProduct(product,id);
	}

	@DeleteMapping("/deleteproduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		return productService.deleteById(id);
	}

}
