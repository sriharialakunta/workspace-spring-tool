package com.wipro.topgear.Hiber_Assign_3.service;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wipro.topgear.Hiber_Assign_3.dao.Dao;
import com.wipro.topgear.Hiber_Assign_3.entity.Capital;
import com.wipro.topgear.Hiber_Assign_3.entity.Continent;
import com.wipro.topgear.Hiber_Assign_3.entity.Country;

public class CollectionService {

	public static void addData(String continent, String country, String capital) {
		
		Transaction tnx = null;
		Session session = Dao.sessionConnect();

		tnx = session.beginTransaction();

		Country cou = new Country(country);
		Capital cap = new Capital(capital);

		Map<Country, Capital> CountriesAndCapital = new HashMap<>();
		CountriesAndCapital.put(cou, cap);
		Continent newContinent = new Continent(continent, CountriesAndCapital);

		session.save(newContinent);
		tnx.commit();

		session.close();
		
		
		
	}
	
}
