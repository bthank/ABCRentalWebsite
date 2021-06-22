package com.abcrentals.binu.thankachan.dao;

import java.util.List;

import com.abcrentals.binu.thankachan.entity.Country;

/*
 * Interface used for DAO access method declaration for Country entity class
 * 
 * 
 * 
 */


public interface CountryDao {

	Country findByCountryCode(int theCountryCode);
	
	List<Country> findAllCountries();

	void save(Country theCountry);
	
	void delete(Country theCountry);

}
