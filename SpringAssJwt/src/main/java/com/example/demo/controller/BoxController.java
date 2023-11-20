package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Box;
import com.example.demo.entity.UserInfo;
import com.example.demo.repository.UserInfoRepository;
import com.example.demo.service.BoxService;

@RestController
@RequestMapping("/")
public class BoxController {
	
	@Autowired
	private BoxService boxService;
	@Autowired
	private UserInfoRepository uRop;
	
	@Autowired
	private PasswordEncoder pEncoder;
	
	@GetMapping("welcome/")
	public String welcome() {
		return "WELCOME TO BOX PVT.";
	}
	@PostMapping("user/")
	public String addUser(@RequestBody UserInfo uinfo) {
		uinfo.setuPassword(pEncoder.encode(uinfo.getuPassword()));
		uRop.save(uinfo);
		return "new User Added";
	}
	@GetMapping("jwt/well/")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String well() {
		return "Autherized";
	}
	
	@PostMapping("jwt/addBox/")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Box addBox(@RequestBody Box box) {
		return boxService.addBox(box);
	}
	
	@GetMapping("jwt/allBoxes/")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public List<Box> getAllBoxes() {
		return boxService.getAllBoxes();
	}

}
