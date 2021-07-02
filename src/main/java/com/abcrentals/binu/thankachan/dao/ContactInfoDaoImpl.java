package com.abcrentals.binu.thankachan.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abcrentals.binu.thankachan.entity.ContactInfo;

/*
 * Class used for DAO access method definition for ContactInfo entity class
 * 
 * 
 * 
 */


@Repository
public class ContactInfoDaoImpl implements ContactInfoDao{

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	// dao method for contact info find by contact info id service
	@Override
	public ContactInfo findContactInfoById(int id) {
		 
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using id
		Query<ContactInfo> theQuery = currentSession.createQuery("from ContactInfo where id=:contactInfoId", ContactInfo.class);
		theQuery.setParameter("contactInfoId", id);
		ContactInfo theContactInfo = null;
		try {
			theContactInfo = (ContactInfo)theQuery.getSingleResult();
		} catch (Exception e) {
			theContactInfo = null;
		}

		return theContactInfo;		   

	}

	// dao method for contact info service
	@Override
	public void save(ContactInfo contactInfo) {
		 
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the address
		currentSession.saveOrUpdate(contactInfo);
		
	}

	// dao method for contact info service
	@Override
	public void delete(ContactInfo contactInfo) {
		 
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the address
		currentSession.delete(contactInfo);
		
	}
	
	
	
	
	
	
	
}
