package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Orders;
import com.example.demo.service.OrdersService;
@RestController
@RequestMapping("/")
public class OrderController {
	
	@Autowired
	private OrdersService ordersService;
	
	@GetMapping("all_Orders/")
	public List<Orders> all_Orders() {
		return ordersService.all_Orders();
	}

//	@GetMapping("all_OrdersD/")
//	public List<OrderDAO> all_OrdersD() {
//		return ordersService.all_OrdersD();
//	}
	@GetMapping("all_OrdersD/")
	public List<Orders> all_OrdersD() {
		return ordersService.all_OrdersD();
	}
	@GetMapping("all_OrdersDs/")
	public List<Object[]> all_OrdersDs() {
		return ordersService.all_OrdersDs();
	}
}
