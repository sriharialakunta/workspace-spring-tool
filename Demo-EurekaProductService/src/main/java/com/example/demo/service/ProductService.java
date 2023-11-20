package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {

	List<Product> getProducts();

	Product getProductById(int id);

	Product addProduct(Product product);

	String deleteProductById(int id);

	String deleteProducts();

}
