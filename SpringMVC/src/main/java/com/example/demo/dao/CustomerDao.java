package com.example.demo.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int rowCount() {
		int rowCount = this.jdbcTemplate.queryForObject("Select count(*)from customer", Integer.class);
		return  rowCount;
		
	}
	public String insert() {
			this.jdbcTemplate.execute("INSERT INTO customer values('Clean','Eriser')");
			return "New Data Inserted";

	}
	
	
	
}
