package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	@NonNull
	private String title;
	private String available;
	@NonNull
	private String language;
	@NonNull
	private String category ;
	@NonNull
    private Date yearOfRelease;
	
}
