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

	@Override
	@Transactional
	public Country findByCountryCode(int theCountryCode) {
		 
		return countryDao.findByCountryCode(theCountryCode);
	}
	
	

	@Override
	@Transactional
	public List<Country> findAllCountries() {
		 
		return countryDao.findAllCountries();
	}
	

	@Override
	@Transactional
	public void save(Country theCountry) {
		 
		countryDao.save(theCountry);
		
	}


	@Override
	@Transactional
	public void delete(Country theCountry) {
		 
		countryDao.delete(theCountry);
		
	}



	
	
	
	
}
