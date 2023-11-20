package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CustomerService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/feigncust")
public class FeignCustomerController {

	@Autowired
	private CustomerService service;
	
	private Logger log = LoggerFactory.getLogger(FeignCustomerController.class);
	
	@GetMapping("/message")
	@CircuitBreaker(fallbackMethod="defaultMessage", name = "servicess")
	public String  getMessageFromConfigServer()
	{
		log.info(".........Feign Coustomer.......");
		return service.getMessageFromConfigServer();
	}
	
	@GetMapping
	public List<Object> getAllCustomers() {
		return service.getAllCustomers();

	}

	@GetMapping("{customerId}")
	public Object getCustomer(@PathVariable("customerId") int id) {
		return service.getCustomer(id);
	}

	@PostMapping
	public Object addCustomer(@RequestBody Object customer) {
		return service.addCustomer(customer);

	}
	@PutMapping("{customerId}")
	public Object updateCustomer(@PathVariable("customerId") int id,@RequestBody Object customer) {
		return service.addCustomer(customer);

	}
	@DeleteMapping("{customerId}")
	public String deleteCustomer(@PathVariable("customerId") int id) {
		return service.deleteCustomer(id);

	}

	@DeleteMapping
	public String deleteAllCustomers() {
		return service.deleteAllCustomers();

	}
	
	public String  defaultMessage(RuntimeException e)
	{
		log.info("____________RETRY_____________");
		return "faild Case ";
	}

}
