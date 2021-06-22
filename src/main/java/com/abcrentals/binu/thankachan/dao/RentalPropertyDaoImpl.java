package com.abcrentals.binu.thankachan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abcrentals.binu.thankachan.entity.RentalProperty;

/*
 * Class used for DAO access method definition for RentalProperty entity class
 * 
 * 
 * 
 */


@Repository
public class RentalPropertyDaoImpl implements RentalPropertyDao{


	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
		@Override
	public RentalProperty findById(long id) {
			 
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// now retrieve/read from database using id
			Query<RentalProperty> theQuery = currentSession.createQuery("from RentalProperty where id=:rentalPropertyId", RentalProperty.class);
			theQuery.setParameter("rentalPropertyId", id);
			RentalProperty theRentalProperty = null;
			try {
				theRentalProperty = (RentalProperty)theQuery.getSingleResult();
				System.out.println("a4: In RentalPropertyDaoImpl  in findById() method   theRentalProperty:  " + theRentalProperty.getId() + " | " + theRentalProperty.getRentalPropertyName() + " | " + theRentalProperty.getOwnerUserId() );
				System.out.println("a5: In RentalPropertyDaoImpl  in findById() method   theRentalProperty.toString():  " + theRentalProperty.toString() );

			} catch (Exception e) {
				theRentalProperty = null;
			}

			return theRentalProperty;		   	}

	@Override
	public List<RentalProperty> findByOwnerUserId(long ownerUserId) {
		 
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using id
		Query<RentalProperty> theQuery = currentSession.createQuery("from RentalProperty where ownerUserId=:theOwnerUserId", RentalProperty.class);
		theQuery.setParameter("theOwnerUserId", ownerUserId);
		List<RentalProperty> rentalPropertyList = null;
		try {
			rentalPropertyList = (List<RentalProperty>)theQuery.getResultList();
			System.out.println("b4: In RentalPropertyDaoImpl  in findByOwnerUserId() method   theRentalProperty:  " + rentalPropertyList.get(0).getId() + " | " + rentalPropertyList.get(0).getRentalPropertyName() + " | " + rentalPropertyList.get(0).getOwnerUserId() );
			System.out.println("b5: In RentalPropertyDaoImpl  in findByOwnerUserId() method   theRentalProperty.toString():  " + rentalPropertyList.get(0).toString() );

		} catch (Exception e) {
			rentalPropertyList = null;
		}

		return rentalPropertyList;		    

	}

	@Override
	public List<RentalProperty> findByManagerUserId(long managerUserId) {
		 
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using id
		Query<RentalProperty> theQuery = currentSession.createQuery("from RentalProperty where managerUserId=:theManagerUserId", RentalProperty.class);
		theQuery.setParameter("theManagerUserId", managerUserId);
		List<RentalProperty> rentalPropertyList = null;
		try {
			rentalPropertyList = (List<RentalProperty>)theQuery.getResultList();
			System.out.println("c4: In RentalPropertyDaoImpl  in findByManagerUserId() method   theRentalProperty:  " + rentalPropertyList.get(0).getId() + " | " + rentalPropertyList.get(0).getRentalPropertyName() + " | " + rentalPropertyList.get(0).getManagerUserId() );
			System.out.println("c5: In RentalPropertyDaoImpl  in findByManagerUserId() method   theRentalProperty.toString():  " + rentalPropertyList.get(0).toString() );

		} catch (Exception e) {
			rentalPropertyList = null;
		}

		return rentalPropertyList;		    

	}

	@Override
	public List<RentalProperty> findAllRentalProperties() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database
		Query<RentalProperty> theQuery = currentSession.createQuery("from RentalProperty", RentalProperty.class);
		List<RentalProperty> rentalPropertyList = null;
		try {
			rentalPropertyList = (List<RentalProperty>)theQuery.getResultList();
			System.out.println("c4: In RentalPropertyDaoImpl  in findAllRentalProperties() method   theRentalProperty:  " + rentalPropertyList.get(0).getId() + " | " + rentalPropertyList.get(0).getRentalPropertyName() + " | " + rentalPropertyList.get(0).getManagerUserId() );
			System.out.println("c5: In RentalPropertyDaoImpl  in findAllRentalProperties() method   theRentalProperty.toString():  " + rentalPropertyList.get(0).toString() );

		} catch (Exception e) {
			rentalPropertyList = null;
		}

		return rentalPropertyList;			}
	
	
	@Override
	public void save(RentalProperty rentalProperty) {
	   	
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// delete the rentalProperty record
			currentSession.saveOrUpdate(rentalProperty);
			
	}

	@Override
	public void delete(RentalProperty rentalProperty) {
	   	
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// delete the rentalProperty record
			currentSession.delete(rentalProperty);
			
	}


}
