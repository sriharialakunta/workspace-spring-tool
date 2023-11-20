package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Mobiles;
import com.example.demo.repository.MobilesRepository;
import com.example.demo.service.MobilesService;
@Service
public class MobilesServiceImpl implements MobilesService {

	@Autowired
	private MobilesRepository mobilesRepository;
	
	@Override
	public String addMobile(Mobiles mobiles) {
		 mobilesRepository.save(mobiles);
		 return "New Mobile ADDED...";
	}

	@Override
	public List<Mobiles> getAllMobiles() {
		return mobilesRepository.findAll();
		}

//	@Override
//	public String updateMobile(Mobiles mobiles, int id) {
//		 mobilesRepository.updateMobile(mobiles.getBrand(), mobiles.getModel(), id);
//		 return "Mobile Data updated...";
//	}

	@Override
	public String deleteMobile(int id) {
		mobilesRepository.deleteById(id);
		return "deleted Mobile data"+id+" successfully..";
	}

	@Override
	public Mobiles getOneMobile(int id) {
		return mobilesRepository.getOneById(id);
	}

}
