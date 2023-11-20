package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, String>{

	
	@Query(nativeQuery = true ,value = "SELECT Orders.order_id, Customers.coustomer_name, Hotel_details.hotel_name, Orders.order_amount\n" + 
			"FROM Orders\n" + 
			"INNER JOIN Customers ON Orders.coustomer_id = Customers.coustomer_id\n" + 
			"INNER JOIN Hotel_details ON Orders.hotel_id = Hotel_details.hotel_id\n" + 
			"ORDER BY Orders.order_id ASC")
	List<Orders> findAllDetails();
	
	@Query(nativeQuery = true ,value = "SELECT o.order_id, c.coustomer_name, h.hotel_name, o.order_amount" + 
			"FROM Orders o" + 
			"JOIN o.customers c" + 
			"JOIN o.Hotel_details h" + 
			"ORDER BY o.id ASC")
	List<Object[]> findAllOrders();

}
