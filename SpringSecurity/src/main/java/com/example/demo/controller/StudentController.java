package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin
@RequestMapping("/stu")
public class StudentController {

//	@Autowired
//	private StudentServiceImp service;

	@GetMapping("/greeting")
	public String greeting() {
		return "Welcome to Spring Security";
	}
	
	@GetMapping("/welcome")
	public ModelAndView homePage() {
		return new ModelAndView("Welcome");
	}


	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/admin")
	public ModelAndView studentsDetails() {
		return new ModelAndView("admin");
	}
	

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping("/student")
	public ModelAndView studentDetails() {
		return new ModelAndView("student");
	}
	

}
