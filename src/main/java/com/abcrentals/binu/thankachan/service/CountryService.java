package com.abcrentals.binu.thankachan.service;

import java.util.List;

import com.abcrentals.binu.thankachan.entity.Country;

/*
 * Interface used for DAO service method declaration for Country entity class
 * 
 * 
 * 
 */


public interface CountryService {

	Country findByCountryCode(int theCountryCode);
	
	List<Country> findAllCountries();

	void save(Country theCountry);
	
	void delete(Country theCountry);

}
