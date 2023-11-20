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
@RequestMapping("/products")
public class ProductController {
	private static final String PRODUCTS = "/products";

	@Autowired
	private EurekaClient client;
	
	@Autowired
	private RestTemplateBuilder builder;
	
	InstanceInfo instanceinfo;
	String baseUrl;
	RestTemplate resttemplate;
	
	private void setup() {
		
	instanceinfo=client.getNextServerFromEureka("DemoEurekaProductService", false);
	baseUrl=instanceinfo.getHomePageUrl()+PRODUCTS;
	resttemplate=builder.build();
	
	}
	
	@GetMapping
	public Object getProducts() {
		setup();
		return resttemplate.getForObject(baseUrl,Object.class);
	}
	
	@GetMapping("{productId}")
	public Object getProductById(@PathVariable("productId") int id) {
		setup();
		return resttemplate.getForObject(baseUrl.concat("/"+id),Object.class);
	}
	
	@PostMapping
	public Object addProduct(@RequestBody Object product) {
		setup();
		return resttemplate.postForObject(baseUrl,product, Object.class);
	}
	
	@PutMapping("{productId}")
	public Object updateProductById(@PathVariable("productId") int id, @RequestBody Object product) {
		setup();
		resttemplate.put(baseUrl.concat("/"+id), product, Object.class);
		return getProductById(id);
	}
	
	@DeleteMapping("{productId}")
	public String deleteProductById(@PathVariable("productId") int id) {
		setup();
		resttemplate.delete(baseUrl.concat("/"+id));
		return "deleted product with id : "+id;
	}
	
	@DeleteMapping
	public String deleteAllProducts() {
		setup();
		resttemplate.delete(baseUrl);
		return "deleted all products";
	}
}
