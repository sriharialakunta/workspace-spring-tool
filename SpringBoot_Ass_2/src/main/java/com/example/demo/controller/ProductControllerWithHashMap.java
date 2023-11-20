package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@RestController
@RequestMapping("/hashmap/products")
public class ProductControllerWithHashMap {

	    private Map<Integer, Product> products = new HashMap<>();
	    
	    @PostMapping("/addproduct")
	    public ResponseEntity<?> createProduct(@RequestBody Product product) {
	        products.put(product.getId(), product);
	        return ResponseEntity.ok().build();
	    }
	    
	    @GetMapping("/product/{id}")
	    public ResponseEntity<Product> getProductById(@PathVariable int id) {
	        Product product = products.get(id);
	        if (product == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(product);
	    }
	    
	    @GetMapping
	    public ResponseEntity<List<Product>> getAllProducts() {
	        List<Product> productList = new ArrayList<>(products.values());
	        return ResponseEntity.ok(productList);
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody Product product) {
	        if (!products.containsKey(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        products.put(id, product);
	        return ResponseEntity.ok().build();
	    }
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
	        if (!products.containsKey(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        products.remove(id);
	        return ResponseEntity.ok().build();
	    }

}
