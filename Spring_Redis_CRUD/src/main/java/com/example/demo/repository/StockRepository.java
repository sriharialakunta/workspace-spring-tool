package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock, Integer>{

}
