package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product addProduct(Product product);

	Optional<Product> findById(int id);

	String deleteById(int id);

	Optional<Product> updateProduct(Product product, int id);
	

}
