package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	

	private ProductRepository productrepository;
	
	public ProductServiceImpl(ProductRepository productrepository) {
		super();
		this.productrepository = productrepository;
	}

	@Override
	public List<Product> getAllProducts() {
		return productrepository.findAll();
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productrepository.save(product);
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productrepository.findById(id).get();
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productrepository.save(product);
	}

	@Override
	public void deleteProductbyId(int pid) {
		// TODO Auto-generated method stub
		productrepository.deleteById(pid);
		
	}

}
