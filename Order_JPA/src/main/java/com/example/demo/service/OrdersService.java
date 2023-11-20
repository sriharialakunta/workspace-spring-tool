package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Orders;

public interface OrdersService {

	List<Orders> all_Orders();

	List<Orders> all_OrdersD();

	List<Object[]> all_OrdersDs();

//	List<OrderDAO> all_OrdersD();

}
