package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Customer {
	
	@Value("${cid}")
	private int cid;
	@Value("${cname}")
	private String cname;
	
	@Autowired
	@Qualifier("orders")
	private Orders orders;

	public Customer() {
		super();
	}

	public Customer(int cid, String cname, Orders orders) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.orders = orders;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", orders=" + orders + "]";
	}


}
