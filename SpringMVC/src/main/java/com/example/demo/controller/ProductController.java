package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.ProductService;

@Controller
@ResponseBody
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping("/helloProduct")
	public String name() {
		return "Hello";
	}
	
	@RequestMapping("/countProduct")
	public int count() {
		return productService.rowCount();
	}

}
