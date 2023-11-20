package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.JwtAuthentication;
import com.example.demo.service.JwtService;

@RestController
@RequestMapping("/jwt/")
public class JwtController {

	@Autowired
	private JwtService jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("auth/")
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
