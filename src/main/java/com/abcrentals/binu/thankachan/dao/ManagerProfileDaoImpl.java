package com.abcrentals.binu.thankachan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abcrentals.binu.thankachan.entity.ManagerProfile;
import com.abcrentals.binu.thankachan.entity.OwnerProfile;

/*
 * Class used for DAO access method definition for ManagerProfile entity class
 * 
 * 
 * 
 */


@Repository
public class ManagerProfileDaoImpl implements ManagerProfileDao{
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
		
	// dao method for manager profile find by id service
	@Override
	public ManagerProfile findById(long id) {
		   
			// get the current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// now retrieve/read from database using id
			Query<ManagerProfile> theQuery = currentSession.createQuery("from ManagerProfile where id=:managerProfId", ManagerProfile.class);
			theQuery.setParameter("managerProfId", id);
			ManagerProfile theManagerProfile = null;
			try {
				theManagerProfile = (ManagerProfile)theQuery.getSingleResult();
			} catch (Exception e) {
				theManagerProfile = null;
			}

			return theManagerProfile;		   
		   
	}

	// dao method for manager profile find by user id service
	@Override
	public ManagerProfile findByUserId(long userId) {
		
			System.out.println("a1:  Entering ManagerProfileDaoImpl  findByUserId() method");
		   
			// get the current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// now retrieve/read from database using userId
			Query<ManagerProfile> theQuery = currentSession.createQuery("FROM ManagerProfile where user.id=:user_id", ManagerProfile.class);
			theQuery.setParameter("user_id", userId);

			ManagerProfile theManagerProfile = null;
			List<ManagerProfile> managerProfiles = null;
			try {

				theManagerProfile = (ManagerProfile)theQuery.getSingleResult();
			} catch (Exception e) {
				theManagerProfile = null;
			}

			if (theManagerProfile != null) {
				System.out.println("z90:  Exiting ManagerProfileDaoImpl  findByUserId() method   theManagerProfile: " + theManagerProfile.getId() + " | " + theManagerProfile.getTypeOfProfile());
				System.out.println("z91:  Exiting ManagerProfileDaoImpl  findByUserId() method   theManagerProfile.toString(): " + theManagerProfile.toString());
				System.out.println("z92:  Exiting ManagerProfileDaoImpl  findByUserId() method   theManagerProfile: " + theManagerProfile.getId() + " | " + theManagerProfile.getTypeOfProfile() + " | " + theManagerProfile.getContactInfo().getId() + " | " + theManagerProfile.getContactInfo().getFirstName() + " " + theManagerProfile.getContactInfo().getLastName() + " |HPhno: " + theManagerProfile.getContactInfo().getHomePhoneNo() + " |WPhNo: " + theManagerProfile.getContactInfo().getWorkPhoneNo());				
			} else {
				System.out.println("z93:  Exiting ManagerProfileDaoImpl  findByUserId() method   theManagerProfile: is null");
			}
			
			System.out.println("z99:  Exiting ManagerProfileDaoImpl  findByUserId() method");

			return theManagerProfile;		   
		   
	}
	
	// dao method for manager profile find all manager profiles service
	@Override
	public List<ManagerProfile> findAllManagerProfiles() {
		
		System.out.println("a1:  Entering ManagerProfileDaoImpl  findAllManagerProfiles() method");
		   
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read all ManagerProfiles from database
		Query<ManagerProfile> theQuery = currentSession.createQuery("from ManagerProfile", ManagerProfile.class);

		List<ManagerProfile> managerProfileList = null;
		try {

			managerProfileList = (List<ManagerProfile>)theQuery.getResultList();
		} catch (Exception e) {
			managerProfileList = null;
		}

		if (managerProfileList != null) {
			System.out.println("z90:  Exiting ManagerProfileDaoImpl  findAllManagerProfiles() method   managerProfileList[0]: " + managerProfileList.get(0).getUser().getId() );
			System.out.println("z90:  Exiting ManagerProfileDaoImpl  findAllManagerProfiles() method   managerProfileList[0]: " + managerProfileList.toString() );

		} else {
			System.out.println("z93:  Exiting ManagerProfileDaoImpl  findAllManagerProfiles() method   theManagerProfile: is null");
		}
		
		System.out.println("z99:  Exiting ManagerProfileDaoImpl  findAllManagerProfiles() method");

		return managerProfileList;		   

		
	}
	
	// dao method for manager profile save service
	@Override
	public void save(ManagerProfile managerProfile) {
	   	
			// get current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// create the Manager Profile
			currentSession.saveOrUpdate(managerProfile);
	    			 
	}

	// dao method for manager profile delete service
	@Override
	public void delete(ManagerProfile managerProfile) {
	   	
			// get current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// delete the Manager Profile
			currentSession.delete(managerProfile);
	    			 
	}


}
