package com.abcrentals.binu.thankachan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abcrentals.binu.thankachan.entity.OwnerProfile;

/*
 * Class used for DAO access method definition for OwnerProfile entity class
 * 
 * 
 * 
 */


@Repository
public class OwnerProfileDaoImpl implements OwnerProfileDao{
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	public OwnerProfile findById(long id) {
		   
			// get the current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// now retrieve/read from database using id
			Query<OwnerProfile> theQuery = currentSession.createQuery("from OwnerProfile where id=:ownerProfId", OwnerProfile.class);
			theQuery.setParameter("ownerProfId", id);
			OwnerProfile theOwnerProfile = null;
			try {
				theOwnerProfile = (OwnerProfile)theQuery.getSingleResult();
			} catch (Exception e) {
				theOwnerProfile = null;
			}

			return theOwnerProfile;		   
		   
	}

	@Override
	public OwnerProfile findByUserId(long userId) {
		
			System.out.println("a1:  Entering OwnerProfileDaoImpl  findByUserId() method");
		   
			// get the current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// now retrieve/read from database using userId
			Query<OwnerProfile> theQuery = currentSession.createQuery("FROM OwnerProfile where user.id=:user_id", OwnerProfile.class);
			theQuery.setParameter("user_id", userId);

			OwnerProfile theOwnerProfile = null;
			List<OwnerProfile> ownerProfiles = null;
			try {

				theOwnerProfile = (OwnerProfile)theQuery.getSingleResult();
			} catch (Exception e) {
				theOwnerProfile = null;
			}

			if (theOwnerProfile != null) {
				System.out.println("z90:  Exiting OwnerProfileDaoImpl  findByUserId() method   theOwnerProfile: " + theOwnerProfile.getId() + " | " + theOwnerProfile.getTypeOfProfile());
				System.out.println("z91:  Exiting OwnerProfileDaoImpl  findByUserId() method   theOwnerProfile.toString(): " + theOwnerProfile.toString());
				System.out.println("z92:  Exiting OwnerProfileDaoImpl  findByUserId() method   theOwnerProfile: " + theOwnerProfile.getId() + " | " + theOwnerProfile.getTypeOfProfile() + " | " + theOwnerProfile.getContactInfo().getId() + " | " + theOwnerProfile.getContactInfo().getFirstName() + " " + theOwnerProfile.getContactInfo().getLastName() + " |HPhno: " + theOwnerProfile.getContactInfo().getHomePhoneNo() + " |WPhNo: " + theOwnerProfile.getContactInfo().getWorkPhoneNo());				
			} else {
				System.out.println("z93:  Exiting OwnerProfileDaoImpl  findByUserId() method   theOwnerProfile: is null");
			}
			
			System.out.println("z99:  Exiting OwnerProfileDaoImpl  findByUserId() method");

			return theOwnerProfile;		   
		   
	}

	@Override
	public List<OwnerProfile> findAllOwnerProfiles() {
		
		System.out.println("a1:  Entering OwnerProfileDaoImpl  findAllOwnerProfiles() method");
		   
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read all OwnerProfiles from database
		Query<OwnerProfile> theQuery = currentSession.createQuery("from OwnerProfile", OwnerProfile.class);

		List<OwnerProfile> ownerProfileList = null;
		try {

			ownerProfileList = (List<OwnerProfile>)theQuery.getResultList();
		} catch (Exception e) {
			ownerProfileList = null;
		}

		if (ownerProfileList != null) {
			System.out.println("z90:  Exiting OwnerProfileDaoImpl  findAllOwnerProfiles() method   theOwnerProfile[0]: " + ownerProfileList.get(0).getUser().getId() );
			System.out.println("z90:  Exiting OwnerProfileDaoImpl  findAllOwnerProfiles() method   theOwnerProfile[0]: " + ownerProfileList.toString() );

		} else {
			System.out.println("z93:  Exiting OwnerProfileDaoImpl  findAllOwnerProfiles() method   theOwnerProfile: is null");
		}
		
		System.out.println("z99:  Exiting OwnerProfileDaoImpl  findAllOwnerProfiles() method");

		return ownerProfileList;		   
	}
	

	@Override
	public void save(OwnerProfile ownerProfile) {
	   	
			// get current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// delete the Owner Profile
			currentSession.saveOrUpdate(ownerProfile);
	    			 		
	}

	@Override
	public void delete(OwnerProfile ownerProfile) {
	   	
			// get current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// delete the Owner Profile
			currentSession.delete(ownerProfile);
	    			 
	}


}
