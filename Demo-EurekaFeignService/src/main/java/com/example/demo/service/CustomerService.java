package com.example.demo.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name="DemoEurekaCustomerService",url="${customerService}")
public interface CustomerService {
	
	@GetMapping("/message")
	public String  getMessageFromConfigServer();
	
	@GetMapping
	public List<Object> getAllCustomers();

	@GetMapping("{customerId}")
	public Object getCustomer(@PathVariable("customerId") int id);
	
	@PostMapping
	public Object addCustomer(@RequestBody Object customer);

	@PutMapping("{customerId}")
	public Object updateCustomer(@PathVariable("customerId") int id,@RequestBody Object customer);

	@DeleteMapping("{customerId}")
	public String deleteCustomer(@PathVariable("customerId") int id);
	
	@DeleteMapping
	public String deleteAllCustomers();


}
