package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Mobiles;

@Repository
public interface MobilesRepository extends JpaRepository<Mobiles,Integer>{

	Mobiles getOneById(int id);

//	@Modifying(clearAutomatically = true)
//	@Transactional
//	@Query(nativeQuery = true , value="update mobiles set model='?1',brand='?2' where id=?3")
//	void updateMobile(String model, String brand, int id);
}
