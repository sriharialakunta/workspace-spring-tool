package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Mobiles;
import com.example.demo.service.MobilesService;

@RestController
@RequestMapping("/")
public class MobilesController {
	@Autowired
	private MobilesService mobilesService;

	@PostMapping("addmobile/")
	public String addMobile(@RequestBody Mobiles mobiles) {
		return mobilesService.addMobile(mobiles);

	}
	
//	@PostMapping("updatemobile/")
//	public String updateMobile(@RequestBody Mobiles mobiles,@Param(value = "id") int id) {
//		return mobilesService.updateMobile(mobiles,id);
//
//	}
	@PostMapping("deletemobile/")
	public String deleteMobile(@Param(value = "id") int id) {
		return mobilesService.deleteMobile(id);

	}
	
	@GetMapping("allmobiles/")
	public List<Mobiles> getAllMobiles() {
		return mobilesService.getAllMobiles();

	}
	@GetMapping("onemobile/")
	public Mobiles oneMobile(@Param(value="id")int id ) {
		return mobilesService.getOneMobile(id);

	}
}
