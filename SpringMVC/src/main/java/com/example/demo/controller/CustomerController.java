package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.CustomerService;

@Controller
@ResponseBody
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/hello")
	public String name() {
		return "Hello";
	}
	@RequestMapping("/count")
	public int count() {
		return customerService.rowCount();
	}

}
