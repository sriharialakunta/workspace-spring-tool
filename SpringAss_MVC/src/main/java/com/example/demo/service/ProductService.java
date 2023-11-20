package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {
	
	List<Product> getAllProducts();

	Product saveProduct(Product product);

	Product getProductById(int id);

	Product updateProduct(Product product);

	void deleteProductbyId(int pid);

}
