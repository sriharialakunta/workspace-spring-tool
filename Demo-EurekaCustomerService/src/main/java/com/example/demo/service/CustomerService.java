package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Customer;

public interface CustomerService {

	List<Customer> getCustomers();

	Customer getCustomerById(int id);

	Customer addCustomer(Customer product);

	String deleteCustomerById(int id);

	String deleteAllCustomers();

}
