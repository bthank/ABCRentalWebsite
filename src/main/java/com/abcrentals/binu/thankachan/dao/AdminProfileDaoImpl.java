package com.abcrentals.binu.thankachan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abcrentals.binu.thankachan.entity.AdminProfile;

/*
 * Class used for DAO access method definition for AdminProfile entity class
 * 
 * 
 * 
 */


@Repository
public class AdminProfileDaoImpl implements AdminProfileDao{
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	public AdminProfile findById(long id) {
		   
			// get the current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// now retrieve/read from database using id
			Query<AdminProfile> theQuery = currentSession.createQuery("from AdminProfile where id=:adminProfId", AdminProfile.class);
			theQuery.setParameter("adminProfId", id);
			AdminProfile theAdminProfile = null;
			try {
				theAdminProfile = (AdminProfile)theQuery.getSingleResult();
			} catch (Exception e) {
				theAdminProfile = null;
			}

			return theAdminProfile;		   
		   
	}

	@Override
	public AdminProfile findByUserId(long userId) {
		
			System.out.println("a1:  Entering AdminProfileDaoImpl  findByUserId() method");
		   
			// get the current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// now retrieve/read from database using userId
			Query<AdminProfile> theQuery = currentSession.createQuery("FROM AdminProfile where user.id=:user_id", AdminProfile.class);
			theQuery.setParameter("user_id", userId);

			AdminProfile theAdminProfile = null;
			List<AdminProfile> adminProfiles = null;
			try {

				theAdminProfile = (AdminProfile)theQuery.getSingleResult();
			} catch (Exception e) {
				theAdminProfile = null;
			}

			if (theAdminProfile != null) {
				System.out.println("z90:  Exiting AdminProfileDaoImpl  findByUserId() method   theAdminProfile: " + theAdminProfile.getId() + " | " + theAdminProfile.getTypeOfProfile());
				System.out.println("z91:  Exiting AdminProfileDaoImpl  findByUserId() method   theAdminProfile.toString(): " + theAdminProfile.toString());
				System.out.println("z92:  Exiting AdminProfileDaoImpl  findByUserId() method   theAdminProfile: " + theAdminProfile.getId() + " | " + theAdminProfile.getTypeOfProfile() + " | " + theAdminProfile.getContactInfo().getId() + " | " + theAdminProfile.getContactInfo().getFirstName() + " " + theAdminProfile.getContactInfo().getLastName() + " |HPhno: " + theAdminProfile.getContactInfo().getHomePhoneNo() + " |WPhNo: " + theAdminProfile.getContactInfo().getWorkPhoneNo());				
			} else {
				System.out.println("z93:  Exiting AdminProfileDaoImpl  findByUserId() method   theAdminProfile: is null");
			}
			
			System.out.println("z99:  Exiting AdminProfileDaoImpl  findByUserId() method");

			return theAdminProfile;		   
		   
	}
	

	@Override
	public void save(AdminProfile adminProfile) {
	   	
			// get current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// create the Admin Profile
			currentSession.saveOrUpdate(adminProfile);
	    			 
		
	}

	@Override
	public void delete(AdminProfile adminProfile) {
    	
		// get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete the adminProfile
		currentSession.delete(adminProfile);
    	
	}

}
