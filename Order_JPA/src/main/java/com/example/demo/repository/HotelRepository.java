package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Hotel_details;

@Repository
public interface HotelRepository extends JpaRepository<Hotel_details, String> {

}
