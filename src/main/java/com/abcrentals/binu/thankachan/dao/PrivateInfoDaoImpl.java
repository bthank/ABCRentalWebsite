package com.abcrentals.binu.thankachan.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abcrentals.binu.thankachan.entity.PrivateInfo;

/*
 * Class used for DAO access method definition for PrivateInfo entity class
 * 
 * 
 * 
 */


@Repository
public class PrivateInfoDaoImpl implements PrivateInfoDao{


	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	// dao method for private info find by id service
	@Override
	public PrivateInfo findPrivateInfoById(int id) {
		 
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using id
		Query<PrivateInfo> theQuery = currentSession.createQuery("from PrivateInfo where id=:privateInfoId", PrivateInfo.class);
		theQuery.setParameter("privateInfoId", id);
		PrivateInfo thePrivateInfo = null;
		try {
			thePrivateInfo = (PrivateInfo)theQuery.getSingleResult();
			System.out.println("a4: In PrivateInfoDaoImpl  in findPrivateInfoById() method   thePrivateInfo:  " + thePrivateInfo.getId() + " | " + thePrivateInfo.getCreditCardNo() + " | " + thePrivateInfo.getCreditCardNoExpYear() );
			System.out.println("a5: In PrivateInfoDaoImpl  in findPrivateInfoById() method   thePrivateInfo.toString():  " + thePrivateInfo.toString() );

		} catch (Exception e) {
			thePrivateInfo = null;
		}

		return thePrivateInfo;		   
	}

	// dao method for private info save service
	@Override
	public void save(PrivateInfo privateInfo) {
    	
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the privateInfo record
		currentSession.saveOrUpdate(privateInfo);
		
	}

	// dao method for private info delete service
	@Override
	public void delete(PrivateInfo privateInfo) {
	   	
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// delete the privateInfo record
			currentSession.delete(privateInfo);
			
	}

	
	
	
	
	
}
