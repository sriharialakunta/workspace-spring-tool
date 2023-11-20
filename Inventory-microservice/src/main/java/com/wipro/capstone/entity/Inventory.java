package com.wipro.capstone.entity;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Inventory {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int inventoryid;
	@NonNull
	private int productId;
	@NonNull
	private int quantity;
	  
}
