package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository repository;

	@Override
	public List<Customer> getCustomers() {
		return repository.findAll();
	}

	@Override
	public Customer getCustomerById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public String deleteCustomerById(int id) {
		repository.deleteById(id);
		return "deleted customer with id : "+id;
	}

	@Override
	public String deleteAllCustomers() {
		repository.deleteAll();
		return "deleted All Customers";
	}

}
