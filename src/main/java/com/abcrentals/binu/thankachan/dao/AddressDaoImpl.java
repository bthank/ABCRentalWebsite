package com.abcrentals.binu.thankachan.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abcrentals.binu.thankachan.entity.Address;
import com.abcrentals.binu.thankachan.entity.User;

/*
 * Class used for DAO access method definition for Address entity class
 * 
 * 
 * 
 */


@Repository
public class AddressDaoImpl implements AddressDao{

	// need to inject the session factory
		@Autowired
		private SessionFactory sessionFactory;
	
		
	// dao method for find by address id service
	   public Address findByAddressId(int addressId) {
		   
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// now retrieve/read from database using addressId
			Query<Address> theQuery = currentSession.createQuery("from Address where id=:addrId", Address.class);
			theQuery.setParameter("addrId", addressId);
			Address theAddress = null;
			try {
				theAddress = (Address)theQuery.getSingleResult();
			} catch (Exception e) {
				theAddress = null;
			}

			return theAddress;		   
		   
	   }

	   // dao method for save address service
	    public void save(Address theAddress) {
	    	
			// get current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// create the address
			currentSession.saveOrUpdate(theAddress);
	    	
	    }

		// dao method for delete address service
		@Override
		public void delete(Address address) {
	    	
			// get current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// delete the address
			currentSession.delete(address);
	    	
		}
	
	
	
}
