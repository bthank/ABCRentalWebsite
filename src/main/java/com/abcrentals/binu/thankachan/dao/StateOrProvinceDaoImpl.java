package com.abcrentals.binu.thankachan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abcrentals.binu.thankachan.entity.StateOrProvince;

/*
 * Class used for DAO access method definition for StateOrProvince entity class
 * 
 * 
 * 
 */



@Repository
public class StateOrProvinceDaoImpl implements StateOrProvinceDao{


	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	
	// dao method for StateOrProvince find by stateOrProvince index service
	@Override
	public int findStateOrProvinceIndex(String theStateOrProvince) {
		 
		System.out.println("a1:  Entering StateOrProvinceDaoImpl  findStateOrProvinceIndex() method    theStateOrProvince= " + theStateOrProvince);
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using theStateOrProvince
		Query<StateOrProvince> theQuery = currentSession.createQuery("from StateOrProvince where stateOrProvince=:st_prov", StateOrProvince.class);
		theQuery.setParameter("st_prov", theStateOrProvince);
		StateOrProvince stateOrProvince = null;
		try {
			stateOrProvince = (StateOrProvince)theQuery.getSingleResult();
			 
		} catch (Exception e) {
			stateOrProvince = null;
		}

		System.out.println("z99:  Exiting StateOrProvinceDaoImpl  findStateOrProvinceIndex() method    stateOrProvince.getId()= " + stateOrProvince.getId());
		return stateOrProvince.getId();		
		
		
	}

	// dao method for StateOrProvince find by id service
	@Override
	public StateOrProvince findById(int id) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using theStateOrProvince
		Query<StateOrProvince> theQuery = currentSession.createQuery("from StateOrProvince where id=:st_prov_id", StateOrProvince.class);
		theQuery.setParameter("st_prov_id", id);
		StateOrProvince stateOrProvince = null;
		try {
			stateOrProvince = (StateOrProvince)theQuery.getSingleResult();
			 
		} catch (Exception e) {
			stateOrProvince = null;
		}

		return stateOrProvince;		
	}
	
	
	
	// dao method for StateOrProvince find by country service
	@Override
	public List<StateOrProvince> findByCountry(String theCountry) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using theCountry
		Query<StateOrProvince> theQuery = currentSession.createQuery("from StateOrProvince where country=:cntry", StateOrProvince.class);
		theQuery.setParameter("cntry", theCountry);
		List<StateOrProvince> theStatesOrProvinces = null;
		try {
			theStatesOrProvinces = (List<StateOrProvince>)theQuery.getResultList();
			 
		} catch (Exception e) {
			theStatesOrProvinces = null;
		}

		return theStatesOrProvinces;
	}

	// dao method for StateOrProvince save service
	@Override
	public void save(StateOrProvince theStateOrProvince) {
		// get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the StateOrProvince  
		currentSession.saveOrUpdate(theStateOrProvince);
	}

	// dao method for StateOrProvince delete service
	@Override
	public void delete(StateOrProvince theStateOrProvince) {
		// get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete the StateOrProvince  
		currentSession.delete(theStateOrProvince);
	}




	
	
}
