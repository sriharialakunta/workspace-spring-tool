package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository repository;

	@Override
	public List<Product> getProducts() {
		return repository.findAll();
	}

	@Override
	public Product getProductById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public Product addProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public String deleteProductById(int id) {
		repository.deleteById(id);
		return "deleted Product with : "+id;
	}

	@Override
	public String deleteProducts() {
		repository.deleteAll();
		return "deleted All Products";
	}

}
