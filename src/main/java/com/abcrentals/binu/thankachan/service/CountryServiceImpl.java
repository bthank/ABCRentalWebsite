package com.abcrentals.binu.thankachan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abcrentals.binu.thankachan.dao.CountryDao;
import com.abcrentals.binu.thankachan.entity.Country;

@Service
public class CountryServiceImpl implements CountryService{


	// need to inject StateOrProvince dao
	@Autowired
	private CountryDao countryDao;

	// method for Country find by country code service
	@Override
	@Transactional
	public Country findByCountryCode(int theCountryCode) {
		 
		return countryDao.findByCountryCode(theCountryCode);
	}
	
	
	// method for Country find all countries service
	@Override
	@Transactional
	public List<Country> findAllCountries() {
		 
		return countryDao.findAllCountries();
	}
	
	// method for Country save service 
	@Override
	@Transactional
	public void save(Country theCountry) {
		 
		countryDao.save(theCountry);
		
	}

	// method for Country delete service 
	@Override
	@Transactional
	public void delete(Country theCountry) {
		 
		countryDao.delete(theCountry);
		
	}



	
	
	
	
}
