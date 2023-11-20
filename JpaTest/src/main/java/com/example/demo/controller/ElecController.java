package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ElectrictySlab;
import com.example.demo.repo.ElecRepo;

@RestController
public class ElecController {
	@Autowired
	private ElecRepo elecRepo;
	
//	public int getBillOfOne(int id) {
//		ElectrictySlab electrictySlab = elecRepo.findById(id);
//		return 0;
//	}
	public List<String> getBills() {
		ElectrictySlab electrictySlab = (ElectrictySlab) elecRepo.findAll();
		
		return null;
	}

}
