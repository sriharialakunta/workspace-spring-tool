package com.wipro.topgear.Hiber_Assign_3.entity;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyJoinColumn;

	@Entity
	public class Continent {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String cname;

	    @ElementCollection
	    @CollectionTable(name = "country_capital")
	    @MapKeyJoinColumn(name = "country_id")
	    @JoinColumn(name = "capital_id")
	    private Map<Country, Capital> countries;

	    public Continent() {}

	    public Continent(String cname, Map<Country, Capital> countries) {
	        this.cname = cname;
	        this.countries = countries;
	    }

	    public String getCname() {
	        return cname;
	    }

	    public void setCname(String cname) {
	        this.cname = cname;
	    }

	    public Map<Country, Capital> getCountries() {
	        return countries;
	    }

	    public void setCountries(Map<Country, Capital> countries) {
	        this.countries = countries;
	    }
	
}
