package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository  productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Optional<Product> findById(int id) {
		return productRepository.findById(id);
	}

	@Override
	public String deleteById(int id) {
		productRepository.deleteById(id);
		return "product with "+id+" deleted successfully"; 
	}

	@Override
	public Optional<Product> updateProduct(Product product, int id) {
		productRepository.updateProduct(product.getName(), product.getPrice(), product.getQty(),id);
		return findById(id);
	}

}
