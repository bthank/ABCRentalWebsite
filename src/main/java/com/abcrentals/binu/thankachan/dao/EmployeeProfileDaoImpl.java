package com.abcrentals.binu.thankachan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abcrentals.binu.thankachan.entity.EmployeeProfile;

/*
 * Class used for DAO access method definition for EmployeeProfile entity class
 * 
 * 
 * 
 */


@Repository
public class EmployeeProfileDaoImpl implements EmployeeProfileDao {

	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	// dao method for employee profile find by id service
	@Override
	public EmployeeProfile findById(long id) {
		   
			// get the current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// now retrieve/read from database using id
			Query<EmployeeProfile> theQuery = currentSession.createQuery("from EmployeeProfile where id=:employeeProfId", EmployeeProfile.class);
			theQuery.setParameter("employeeProfId", id);
			EmployeeProfile theEmployeeProfile = null;
			try {
				theEmployeeProfile = (EmployeeProfile)theQuery.getSingleResult();
				System.out.println("a5:  In EmployeeProfileDaoImpl  in findById() method   theEmployeeProfile.toString()= " + theEmployeeProfile.toString());
			} catch (Exception e) {
				theEmployeeProfile = null;
			}

			return theEmployeeProfile;		   
		   
	}

	// dao method for employee profile find by user id service
	@Override
	public EmployeeProfile findByUserId(long userId) {
		
			System.out.println("c1:  Entering EmployeeProfileDaoImpl  findByUserId() method    userId= " + userId);
		   
			// get the current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// now retrieve/read from database using userId
			Query<EmployeeProfile> theQuery = currentSession.createQuery("FROM EmployeeProfile where user.id=:user_id", EmployeeProfile.class);
			theQuery.setParameter("user_id", userId);
			


			EmployeeProfile theEmployeeProfile = null;
			List<EmployeeProfile> employeeProfiles = null;
			try {
				//System.out.println("c7a:  In EmployeeProfileDaoImpl  in findByUserId() method   theEmployeeProfile.toString()= " + theEmployeeProfile.toString());
				theEmployeeProfile = (EmployeeProfile)theQuery.getSingleResult();
				if (theEmployeeProfile != null) {
					System.out.println("c7b:  In EmployeeProfileDaoImpl  in findByUserId() method   theEmployeeProfile.toString()= " + theEmployeeProfile.toString());
				} else {
					System.out.println("c7c:  In EmployeeProfileDaoImpl  in findByUserId() method   theEmployeeProfile is null:  ");
					
				}
			} catch (Exception e) {
				theEmployeeProfile = null;
			}

			if (theEmployeeProfile != null) {
				System.out.println("c90:  Exiting EmployeeProfileDaoImpl  findByUserId() method   theEmployeeProfile: " + theEmployeeProfile.getId() + " | " + theEmployeeProfile.getTypeOfProfile());
				System.out.println("c91:  Exiting EmployeeProfileDaoImpl  findByUserId() method   theEmployeeProfile.toString(): " + theEmployeeProfile.toString());
				System.out.println("c92:  Exiting EmployeeProfileDaoImpl  findByUserId() method   theEmployeeProfile: " + theEmployeeProfile.getId() + " | " + theEmployeeProfile.getTypeOfProfile() + " | " + theEmployeeProfile.getContactInfo().getId() + " | " + theEmployeeProfile.getContactInfo().getFirstName() + " " + theEmployeeProfile.getContactInfo().getLastName() + " |HPhno: " + theEmployeeProfile.getContactInfo().getHomePhoneNo() + " |WPhNo: " + theEmployeeProfile.getContactInfo().getWorkPhoneNo());
			}
			
			System.out.println("c99:  Exiting EmployeeProfileDaoImpl  findByUserId() method");

			return theEmployeeProfile;		   
		   
	}

	// dao method for employee profile save service
	@Override
	public void save(EmployeeProfile employeeProfile) {
	   	
			// get current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// create the Employee Profile
			currentSession.saveOrUpdate(employeeProfile);
	    			 
		
	}
	
	
	// dao method for employee profile delete service	
	@Override
	public void delete(EmployeeProfile employeeProfile) {
	   	
			// get current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// delete the Employee Profile
			currentSession.delete(employeeProfile);
	    			 
		
	}



}
