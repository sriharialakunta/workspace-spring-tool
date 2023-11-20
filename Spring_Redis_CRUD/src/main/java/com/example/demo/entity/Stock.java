package com.example.demo.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@SuppressWarnings("serial")
@RedisHash("Stock")
public class Stock implements Serializable {

	@Id
	private int id;
	private String stockName;
	private int stockValue;
	
	public Stock() {
		super();
	}

	public Stock(int id, String stockName, int stockValue) {
		super();
		this.id = id;
		this.stockName = stockName;
		this.stockValue = stockValue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getStockValue() {
		return stockValue;
	}

	public void setStockValue(int stockValue) {
		this.stockValue = stockValue;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", stockName=" + stockName + ", stockValue=" + stockValue + "]";
	}
	
	
}
