package com.abcrentals.binu.thankachan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abcrentals.binu.thankachan.entity.ContractorProfile;

/*
 * Class used for DAO access method definition for ContractorProfile entity class
 * 
 * 
 * 
 */


@Repository
public class ContractorProfileDaoImpl implements ContractorProfileDao{
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	public ContractorProfile findById(long id) {
		   
			// get the current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// now retrieve/read from database using id
			Query<ContractorProfile> theQuery = currentSession.createQuery("from ContractorProfile where id=:contractorProfId", ContractorProfile.class);
			theQuery.setParameter("contractorProfId", id);
			ContractorProfile theContractorProfile = null;
			try {
				theContractorProfile = (ContractorProfile)theQuery.getSingleResult();
			} catch (Exception e) {
				theContractorProfile = null;
			}

			return theContractorProfile;		   
		   
	}

	@Override
	public ContractorProfile findByUserId(long userId) {
		
			System.out.println("a1:  Entering ContractorProfileDaoImpl  findByUserId() method");
		   
			// get the current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// now retrieve/read from database using userId
			Query<ContractorProfile> theQuery = currentSession.createQuery("FROM ContractorProfile where user.id=:user_id", ContractorProfile.class);
			theQuery.setParameter("user_id", userId);
			

			ContractorProfile theContractorProfile = null;
			List<ContractorProfile> contractorProfiles = null;
			try {
				theContractorProfile = (ContractorProfile)theQuery.getSingleResult();
			} catch (Exception e) {
				theContractorProfile = null;
			}

			if (theContractorProfile != null) {
				System.out.println("z90:  Exiting ContractorProfileDaoImpl  findByUserId() method   theContractorProfile: " + theContractorProfile.getId() + " | " + theContractorProfile.getTypeOfProfile());
				System.out.println("z91:  Exiting ContractorProfileDaoImpl  findByUserId() method   theContractorProfile.toString(): " + theContractorProfile.toString());
				System.out.println("z92:  Exiting ContractorProfileDaoImpl  findByUserId() method   theContractorProfile: " + theContractorProfile.getId() + " | " + theContractorProfile.getTypeOfProfile() + " | " + theContractorProfile.getContactInfo().getId() + " | " + theContractorProfile.getContactInfo().getFirstName() + " " + theContractorProfile.getContactInfo().getLastName() + " |HPhno: " + theContractorProfile.getContactInfo().getHomePhoneNo() + " |WPhNo: " + theContractorProfile.getContactInfo().getWorkPhoneNo());				
			} else {
				System.out.println("z92:  Exiting ContractorProfileDaoImpl  findByUserId() method   theContractorProfile: is null" );								
			}
			
			System.out.println("z99:  Exiting ContractorProfileDaoImpl  findByUserId() method");

			return theContractorProfile;		   
		   
	}

	@Override
	public List<ContractorProfile> findAllContractorProfiles() {
		
		System.out.println("a1:  Entering ContractorProfileDaoImpl  findAllContractorProfiles() method");
	   
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database
		Query<ContractorProfile> theQuery = currentSession.createQuery("from ContractorProfile", ContractorProfile.class);
		

		List<ContractorProfile> contractorProfileList = null;
		try {
			contractorProfileList = (List<ContractorProfile>)theQuery.getResultList();
		} catch (Exception e) {
			contractorProfileList = null;
		}

		if (contractorProfileList != null) {
			System.out.println("z90:  Exiting ContractorProfileDaoImpl  findAllContractorProfiles() method   contractorProfileList: " + contractorProfileList.get(0).getId() + " | " + contractorProfileList.get(0).getTypeOfProfile());
			System.out.println("z91:  Exiting ContractorProfileDaoImpl  findAllContractorProfiles() method   contractorProfileList.toString(): " + contractorProfileList.get(0).toString());
		} else {
			System.out.println("z92:  Exiting ContractorProfileDaoImpl  findAllContractorProfiles() method   contractorProfileList is null" );								
		}
		
		System.out.println("z99:  Exiting ContractorProfileDaoImpl  findAllContractorProfiles() method");

		return contractorProfileList;		   
	   
	}
	

	@Override
	public void save(ContractorProfile contractorProfile) {
	   	
			// get current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// create the Contractor Profile
			currentSession.saveOrUpdate(contractorProfile);
	    			 
		
	}

	@Override
	public void delete(ContractorProfile contractorProfile) {
	   	
			// get current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// delete the object
			currentSession.delete(contractorProfile);    
	    			 
	}



	
}
