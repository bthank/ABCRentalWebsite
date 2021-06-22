package com.abcrentals.binu.thankachan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abcrentals.binu.thankachan.entity.ContractorProfile;
import com.abcrentals.binu.thankachan.entity.RenterProfile;

/*
 * Class used for DAO access method definition for RenterProfile entity class
 * 
 * 
 * 
 */


@Repository
public class RenterProfileDaoImpl implements RenterProfileDao{
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public RenterProfile findById(long id) {
		   
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// now retrieve/read from database using id
			Query<RenterProfile> theQuery = currentSession.createQuery("from RenterProfile where id=:rentalProfId", RenterProfile.class);
			theQuery.setParameter("rentalProfId", id);
			RenterProfile theRenterProfile = null;
			try {
				theRenterProfile = (RenterProfile)theQuery.getSingleResult();
			} catch (Exception e) {
				theRenterProfile = null;
			}

			return theRenterProfile;		   
		   
	}

	@Override
	public RenterProfile findByUserId(long userId) {
		
		System.out.println("b1:  Entering RenterProfileDaoImpl  findByUserId() method");
	   
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using userId
		Query<RenterProfile> theQuery = currentSession.createQuery("FROM RenterProfile where user.id=:user_id", RenterProfile.class);
		theQuery.setParameter("user_id", userId);
		


		RenterProfile theRenterProfile = null;
		List<RenterProfile> renterProfiles = null;
		try {
			theRenterProfile = (RenterProfile)theQuery.getSingleResult();
		} catch (Exception e) {
			theRenterProfile = null;
		}

		System.out.println("b90:  Exiting RenterProfileDaoImpl  findByUserId() method   theRenterProfile: " + theRenterProfile.getId() + " | " + theRenterProfile.getTypeOfProfile());
		System.out.println("b91:  Exiting RenterProfileDaoImpl  findByUserId() method   theRenterProfile.toString(): " + theRenterProfile.toString());
		System.out.println("b92:  Exiting RenterProfileDaoImpl  findByUserId() method   theRenterProfile: " + theRenterProfile.getId() + " | " + theRenterProfile.getTypeOfProfile() + " | " + theRenterProfile.getContactInfo().getId() + " | " + theRenterProfile.getContactInfo().getFirstName() + " " + theRenterProfile.getContactInfo().getLastName() + " |HPhno: " + theRenterProfile.getContactInfo().getHomePhoneNo() + " |WPhNo: " + theRenterProfile.getContactInfo().getWorkPhoneNo());
		
		System.out.println("b99:  Exiting RenterProfileDaoImpl  findByUserId() method");

		return theRenterProfile;		
		
	}

	

	@Override
	public List<RenterProfile> findAllRenterProfiles() {
		
		System.out.println("c1:  Entering RenterProfileDaoImpl  findAllRenterProfiles() method");
	   
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using userId
		Query<RenterProfile> theQuery = currentSession.createQuery("FROM RenterProfile", RenterProfile.class);
	
		List<RenterProfile> theRenterProfileList = null;
		try {
			theRenterProfileList = (List<RenterProfile>)theQuery.getResultList();
		} catch (Exception e) {
			theRenterProfileList = null;
		}

		if (theRenterProfileList != null) {
			System.out.println("c90:  Exiting RenterProfileDaoImpl  findAllRenterProfiles() method   theRenterProfileList: " + theRenterProfileList.get(0).getId() + " | " + theRenterProfileList.get(0).getTypeOfProfile());
			System.out.println("c91:  Exiting RenterProfileDaoImpl  findAllRenterProfiles() method   theRenterProfileList.toString(): " + theRenterProfileList.get(0).toString());
			System.out.println("c92:  Exiting RenterProfileDaoImpl  findAllRenterProfiles() method   theRenterProfileList: " + theRenterProfileList.get(0).getId() + " | " + theRenterProfileList.get(0).getTypeOfProfile() + " | " + theRenterProfileList.get(0).getContactInfo().getId() + " | " + theRenterProfileList.get(0).getContactInfo().getFirstName() + " " + theRenterProfileList.get(0).getContactInfo().getLastName() + " |HPhno: " + theRenterProfileList.get(0).getContactInfo().getHomePhoneNo() + " |WPhNo: " + theRenterProfileList.get(0).getContactInfo().getWorkPhoneNo());		
		} else {
			System.out.println("c90:  Exiting RenterProfileDaoImpl  findAllRenterProfiles() method   theRenterProfileList is null");
		}
		
		System.out.println("c99:  Exiting RenterProfileDaoImpl  findAllRenterProfiles() method");

		return theRenterProfileList;		
		
	}
	
	
	@Override
	public void save(RenterProfile renterProfile) {
    	
		// get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the Renter Profile
		currentSession.saveOrUpdate(renterProfile);
    	
	}

	@Override
	public void delete(RenterProfile renterProfile) {
    	
		// get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete the Renter Profile
		currentSession.delete(renterProfile);
    	
	}

	

}
