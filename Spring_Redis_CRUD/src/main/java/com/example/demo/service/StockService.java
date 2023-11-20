package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Stock;
import com.example.demo.repository.StockRepository;
@Service
public class StockService {
	
	@Autowired
	private StockRepository stockRepository;
	
	public Stock save(Stock stock) {
		return stockRepository.save(stock);
	}

	public List<Stock> findAll() {
		return (List<Stock>) stockRepository.findAll();
	}

	public Optional<Stock> findProductById(int id) {
		return stockRepository.findById(id);
	}

	public String deleteProduct(int id) {
		stockRepository.deleteById(id);;
		return "Stock Deleted With id : "+id;
	}

}
