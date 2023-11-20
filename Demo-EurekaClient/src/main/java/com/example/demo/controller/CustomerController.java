package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	private static final String CUSTOMERS = "/customers";

	@Autowired
	private EurekaClient client;
	
	@Autowired
	private RestTemplateBuilder builder;
	
	InstanceInfo instanceinfo;
	String baseUrl;
	RestTemplate resttemplate;
	
	private void setup() {
		
	instanceinfo=client.getNextServerFromEureka("DemoEurekaCustomerService", false);
	baseUrl=instanceinfo.getHomePageUrl()+CUSTOMERS;
	resttemplate=builder.build();
	}
	
	@GetMapping
	public Object getCustomers() {
		setup();
		return resttemplate.getForObject(baseUrl,Object.class);
	}
	
	@GetMapping("{customerId}")
	public Object getCustomerById(@PathVariable("customerId") int id) {
		setup();
		return resttemplate.getForObject(baseUrl.concat("/"+id),Object.class);
	}
	
	@PostMapping
	public Object addCustomer(@RequestBody Object product) {
		setup();
		return resttemplate.postForObject(baseUrl,product, Object.class);
	}
	
	@PutMapping("{customerId}")
	public Object updateCustomerById(@PathVariable("customerId") int id, @RequestBody Object product) {
		setup();
		resttemplate.put(baseUrl.concat("/"+id), product, Object.class);
		return getCustomerById(id);
	}
	
	@DeleteMapping("{customerId}")
	public String deleteCustomerById(@PathVariable("customerId") int id) {
		setup();
		resttemplate.delete(baseUrl.concat("/"+id));
		return "deleted customer with id : "+id;
	}
	
	@DeleteMapping
	public String deleteAllCustomers() {
		setup();
		resttemplate.delete(baseUrl);
		return "deleted all customers";
	}
}
