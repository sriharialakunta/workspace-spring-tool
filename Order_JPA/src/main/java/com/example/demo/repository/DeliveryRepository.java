package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Delivery_partners;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery_partners, String>{

}
