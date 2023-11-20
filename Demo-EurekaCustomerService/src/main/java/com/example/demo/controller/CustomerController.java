package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@Value("${message}")
	String message;
	@Value("${company}")
	String company;
	
	@GetMapping("/message")
	public String  getMessageFromConfigServer()
	{
		return "You are in company "+company+"   "+message;
	}
	
	@GetMapping
	public List<Customer> getAllCustomers() {
		return service.getCustomers();

	}

	@GetMapping("{customerId}")
	public Customer getCustomer(@PathVariable("customerId") int id) {
		return service.getCustomerById(id);

	}

	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		return service.addCustomer(customer);

	}
	@PutMapping("{customerId}")
	public Customer updateCustomer(@PathVariable("customerId") int id,@RequestBody Customer customer) {
		customer.setCustomerId(id);
		return service.addCustomer(customer);

	}
	@DeleteMapping("{customerId}")
	public String deleteCustomer(@PathVariable("customerId") int id) {
		return service.deleteCustomerById(id);

	}

	@DeleteMapping
	public String deleteAllCustomers() {
		return service.deleteAllCustomers();

	}
}
