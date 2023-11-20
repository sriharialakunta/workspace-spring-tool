package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Box;
import com.example.demo.repository.BoxRepository;
import com.example.demo.service.BoxService;


@Service
public class BoxServiceImpl implements BoxService {

	@Autowired
	private BoxRepository boxRepo;
	
	@Override
	public Box addBox(Box box) {
		return boxRepo.save(box);
	}

	@Override
	public List<Box> getAllBoxes() {
		return boxRepo.findAll();
	}

}
