package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDao;
import com.example.demo.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public void selectAll() {
	}

	@Override
	public int rowCount() {
		return customerDao.rowCount();
	}

	@Override
	public String insert() {
		return customerDao.insert();
	}

}
