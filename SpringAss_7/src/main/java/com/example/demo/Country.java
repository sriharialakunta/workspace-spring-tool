package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Country {

	private String countryId;
	private String countryName;
	@Autowired
	private List<Player> players;
	
	public Country() {
		super();
	}

	public Country(String countryId, String countryName, List<Player> players) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.players = players;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<Player> getPlayer() {
		return players;
	}

	public void setPlayer(List<Player> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + ", \n players=" + players + "]\n";
	}

	
}
