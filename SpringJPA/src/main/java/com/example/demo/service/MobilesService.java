package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Mobiles;

public interface MobilesService {

	String addMobile(Mobiles mobiles);

	List<Mobiles> getAllMobiles();

//	String updateMobile(Mobiles mobiles, int id);

	String deleteMobile(int id);

	Mobiles getOneMobile(int id);


}
