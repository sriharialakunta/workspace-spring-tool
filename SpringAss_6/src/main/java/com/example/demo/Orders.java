package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

public class Orders {
	
	@Value("#{'${Olist}'.split(',')}")
	private List<String> orders;
	
	@Value("#{new java.text.SimpleDateFormat('dd-MM-yyyy').parse('${ODate}')}")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date;
	public List<String> getOrders() {
		return orders;
	}
	public void setOrders(List<String> orders) {
		this.orders = orders;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Orders [orders=" + orders + ", date=" + date + "]";
	}


	
}
