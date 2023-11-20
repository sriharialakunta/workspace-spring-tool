package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Box;

public interface BoxService {

	Box addBox(Box box);

	List<Box> getAllBoxes();

}
