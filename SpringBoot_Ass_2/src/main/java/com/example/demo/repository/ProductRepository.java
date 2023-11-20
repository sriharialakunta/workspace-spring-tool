package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

import jakarta.transaction.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Modifying
    @Transactional
	@Query(nativeQuery = true,value = "UPDATE product SET name = ?1, price = ?2, qty = ?3 WHERE id = ?4")
	void updateProduct(String name, int price, int qty, int id);

}
