package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class SimpleController {
	@Autowired
	private EurekaClient client;
	
	@Autowired
	private RestTemplateBuilder builder;
	
	@GetMapping("/invoke")
	public String invoke() {
		
		InstanceInfo instanceinfo=client.getNextServerFromEureka("DemoEurekaClientService1", false);
		String baseUrl=instanceinfo.getHomePageUrl();
		RestTemplate resttemplate=builder.build();
		baseUrl=baseUrl+"/message";
		
		return resttemplate.getForObject(baseUrl, String.class);
		
	}
	@GetMapping("/productdetails")
	public Object productFromConfigserver() {
		
		InstanceInfo instanceinfo=client.getNextServerFromEureka("DemoEurekaProductService", false);
		String baseUrl=instanceinfo.getHomePageUrl();
		RestTemplate resttemplate=builder.build();
		baseUrl=baseUrl+"/products/productdetails";
		
		return resttemplate.getForObject(baseUrl, Object.class);
		
	}
	@GetMapping("/customermessage")
	public String customerMessage() {
		
		InstanceInfo instanceinfo=client.getNextServerFromEureka("DemoEurekaCustomerService", false);
		String baseUrl=instanceinfo.getHomePageUrl();
		RestTemplate resttemplate=builder.build();
		baseUrl=baseUrl+"/customers/message";
		
		return resttemplate.getForObject(baseUrl, String.class);
		
	}
}
