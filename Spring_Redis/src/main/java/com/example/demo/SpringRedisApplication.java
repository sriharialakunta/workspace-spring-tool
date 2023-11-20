package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductDao;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class SpringRedisApplication {
	
	@Autowired
	private ProductDao productDao;

	@PostMapping
	private Product save(@RequestBody Product product) {
		return productDao.save(product);

	}

	@GetMapping
	private List<Product> getAllProducts() {
		return productDao.findAll();

	}
	@GetMapping("/{id}")
	private Product findProduct(@PathVariable int id) {
		return productDao.findProductById(id);

	}
	@DeleteMapping("/{id}")
	private String deleteProduct(@PathVariable int id) {
		return productDao.deleteProduct(id);

	}
	public static void main(String[] args) {
		SpringApplication.run(SpringRedisApplication.class, args);
	}

}
