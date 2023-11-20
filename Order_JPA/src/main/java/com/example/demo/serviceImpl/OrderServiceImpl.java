package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Orders;
import com.example.demo.repository.OrdersRepository;
import com.example.demo.service.OrdersService;

@Service
public class OrderServiceImpl implements OrdersService {

	@Autowired 
	private OrdersRepository Orepo;
	@Override
	public List<Orders> all_Orders() {
		return Orepo.findAll();
	}
//	@Override
//	public List<OrderDAO> all_OrdersD() {
//	   List<Orders> orders = Orepo.findAllDetails();
//	   List<OrderDAO> daos = (List<OrderDAO>) new OrderDAO(orders);
//	return daos;
//	}
	
	@Override
	public List<Orders> all_OrdersD() {
		// TODO Auto-generated method stub
		return Orepo.findAllDetails();
	}
	@Override
	public List<Object[]> all_OrdersDs() {
		// TODO Auto-generated method stub
		return Orepo.findAllOrders();
	}
}
