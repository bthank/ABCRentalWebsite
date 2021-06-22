package com.abcrentals.binu.thankachan.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abcrentals.binu.thankachan.entity.EmployerInfo;

/*
 * Class used for DAO access method definition for EmployeeInfo entity class
 * 
 * 
 * 
 */


@Repository
public class EmployerInfoDaoImpl implements EmployerInfoDao {


	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	public EmployerInfo findEmployerInfoById(int id) {
		System.out.println("a1: Entering EmployerInfoDaoImpl  in findEmployerInfoById() method");
		 
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using id
		Query<EmployerInfo> theQuery = currentSession.createQuery("from EmployerInfo where id=:employerInfoId", EmployerInfo.class);
		theQuery.setParameter("employerInfoId", id);
		
		System.out.println("a2: Entering EmployerInfoDaoImpl  in findEmployerInfoById() method");

		
		EmployerInfo theEmployerInfo = null;
		try {
			System.out.println("a3: Entering EmployerInfoDaoImpl  in findEmployerInfoById() method");

			theEmployerInfo = (EmployerInfo)theQuery.getSingleResult();
			System.out.println("a4: Entering EmployerInfoDaoImpl  in findEmployerInfoById() method   theEmployerInfo:  " + theEmployerInfo.getId() + " | " + theEmployerInfo.getEmployerName() + " | " + theEmployerInfo.getEmployerPhoneNo() );
			System.out.println("a5: Entering EmployerInfoDaoImpl  in findEmployerInfoById() method   theEmployerInfo.toString():  " + theEmployerInfo.toString() );

		} catch (Exception e) {
			theEmployerInfo = null;
		}

		System.out.println("z99: Exiting EmployerInfoDaoImpl  in findEmployerInfoById() method");

		return theEmployerInfo;		   

		
	}
    
    public void save(EmployerInfo employerInfo) {
    	
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the employerInfo record
		currentSession.saveOrUpdate(employerInfo);
		
    }

	@Override
	public void delete(EmployerInfo employerInfo) {
	   	
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// delete the employerInfo record
			currentSession.delete(employerInfo);
			
	}


}
