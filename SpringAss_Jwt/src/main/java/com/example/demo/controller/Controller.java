package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.JwtAuthentication;
import com.example.demo.service.JwtService;

@RestController
@RequestMapping("/")
public class Controller {
	
	@Autowired
	private JwtService jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("welcome")
	public String welcome() {
		return "Welcome";
	}

	@GetMapping("jwt/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("jwt/hi")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String printHi() {
		return "Hi";
	}
	
	@GetMapping("jwt/1")
	public String printnumber() {
		return "1";
	}
	@GetMapping("jwt/2")
	public String printnum() {
		return "2453";
	}
	
	@PostMapping("auth")
	public String authenticateAndGetToken(@RequestBody JwtAuthentication authentication) {
      if(authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						authentication.getuName(), authentication.getuPassword()))
    		  .isAuthenticated())
		return jwtService.generateTokens(authentication.getuName());
      else
    	  throw new UsernameNotFoundException("UserNotFound"+authentication.getuName());
	}


}
