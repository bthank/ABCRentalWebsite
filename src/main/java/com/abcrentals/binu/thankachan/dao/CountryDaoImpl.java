package com.abcrentals.binu.thankachan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abcrentals.binu.thankachan.entity.Country;

/*
 * Class used for DAO access method definition for Country entity class
 * 
 * 
 * 
 */



@Repository
public class CountryDaoImpl implements CountryDao{


	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	// dao method for country find by country code service
	@Override
	public Country findByCountryCode(int theCountryCode) {
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using theCountryCode
		Query<Country> theQuery = currentSession.createQuery("from Country where countryCode=:cntryCd", Country.class);
		theQuery.setParameter("cntryCd", theCountryCode);
		Country theCountry = null;
		try {
			theCountry = (Country)theQuery.getSingleResult();
			 
		} catch (Exception e) {
			theCountry = null;
		}

		return theCountry;	
	
	}
	
	// dao method for country find all countries service
	@Override
	public List<Country> findAllCountries() {
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database
		Query<Country> theQuery = currentSession.createQuery("from Country where countryCode > 0", Country.class);
		List<Country> theCountries = null;
		try {
			theCountries = (List<Country>)theQuery.getResultList();
			 
		} catch (Exception e) {
			theCountries = null;
		}

		System.out.println("In CountryDaoImpl  findAllCountries() method:  " + theCountries);
		
		
		return theCountries;	
	}

	// dao method for save country service
	@Override
	public void save(Country theCountry) {
		// get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the Country  
		currentSession.saveOrUpdate(theCountry);
	}

	// dao method for delete country service
	@Override
	public void delete(Country theCountry) {
		// get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete the Country  
		currentSession.delete(theCountry);
	}





	
	
	
	
	
	
}
