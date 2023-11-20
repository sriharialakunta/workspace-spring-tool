package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public void selectAll() {
	}

	@Override
	public int rowCount() {
		return productDao.rowCount();
	}

	@Override
	public String insert() {
		return productDao.insert();
	}
	
	
	

}
