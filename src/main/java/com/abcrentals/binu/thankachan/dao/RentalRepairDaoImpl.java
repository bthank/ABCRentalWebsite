package com.abcrentals.binu.thankachan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abcrentals.binu.thankachan.entity.RentalRepair;

/*
 * Class used for DAO access method definition for RentalRepair entity class
 * 
 * 
 * 
 */


@Repository
public class RentalRepairDaoImpl implements RentalRepairDao {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
		
	// dao method for rental repair find by id service 
	@Override
	public RentalRepair findById(long id) {
	   	
		System.out.println("a1:  Entering RentalRepairDaoImpl  findById() method    id: " + id);
		   
		   
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using id
		Query<RentalRepair> theQuery = currentSession.createQuery("from RentalRepair where id=:rentalRepairId", RentalRepair.class);
		theQuery.setParameter("rentalRepairId", id);
		RentalRepair theRentalRepair = null;
		try {
			theRentalRepair = (RentalRepair)theQuery.getSingleResult();
		} catch (Exception e) {
			theRentalRepair = null;
		}

		if (theRentalRepair != null) {
			System.out.println("z90:  Exiting RentalRepairDaoImpl  findById() method   theRentalRepair:   id: " + theRentalRepair.getId() + " | property id: " + theRentalRepair.getRentalPropertyId() + " | unit no: " + theRentalRepair.getRentalUnitNo()  + " | description: " + theRentalRepair.getDescription());
		} else {
			System.out.println("z92:  Exiting RentalRepairDaoImpl  findById() method   theRentalRepair: is null" );								
		}
		
		System.out.println("z99:  Exiting RentalRepairDaoImpl  findById() method\\n\\n");

		return theRentalRepair;	
		
	}

	// dao method for rental repair find by rental unit id and rental unit no service
	@Override
	public RentalRepair findByRentalUnitIdAndRentalUnitNo(int rentalUnitId, int rentalUnitNo) {
	   	
		System.out.println("a1:  Entering RentalRepairDaoImpl  findByRentalUnitId() method");
		   
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using rentalUnitId and rentalUnitNo
		Query<RentalRepair> theQuery = currentSession.createQuery("from RentalRepair where rentalUnitId=:unitId AND rentalUnitNo=:unitNo", RentalRepair.class);
		theQuery.setParameter("unitId", rentalUnitId);
		theQuery.setParameter("unitNo", rentalUnitNo);

		RentalRepair theRentalRepair = null;
		try {
			theRentalRepair = (RentalRepair)theQuery.getSingleResult();
		} catch (Exception e) {
			theRentalRepair = null;
		}

		if (theRentalRepair != null) {
			System.out.println("z90:  Exiting RentalRepairDaoImpl  findByRentalUnitIdAndRentalUnitNo() method   theRentalRepair:   id: " + theRentalRepair.getId() + " | unitId: " + theRentalRepair.getRentalPropertyId() + " | unitNo: " + theRentalRepair.getRentalUnitNo()  + " | description: " + theRentalRepair.getDescription());
		} else {
			System.out.println("z92:  Exiting RentalRepairDaoImpl  findByRentalUnitIdAndRentalUnitNo() method   theRentalRepair: is null" );								
		}
		
		System.out.println("z99:  Exiting RentalRepairDaoImpl  findByRentalUnitIdAndRentalUnitNo() method\\n\\n");

		return theRentalRepair;		   
 		
	}
	
	// dao method for rental repair find all rental repairs by repair status service
	@Override
	public List<RentalRepair> findAllRentalRepairsByRepairStatus(int repairStatus){
		
		System.out.println("a1:  Entering RentalRepairDaoImpl  findAllRentalRepairsByRepairStatus() method");

		
		List<RentalRepair> rentailRepairList = null;
		
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using repairStatus
		Query<RentalRepair> theQuery = currentSession.createQuery("from RentalRepair where repairStatus=:rprStatus", RentalRepair.class);
		theQuery.setParameter("rprStatus", repairStatus);

		try {
			rentailRepairList = (List<RentalRepair>)theQuery.getResultList();
		} catch (Exception e) {
			rentailRepairList = null;
		}

		if (rentailRepairList != null) {
			System.out.println("z90:  Exiting RentalRepairDaoImpl  findAllRentalRepairsByRepairStatus() method   theRentalRepair[0]:   id: "  + rentailRepairList.get(0).getId()   + " | repairStatus: " + rentailRepairList.get(0).getRepairStatus() + " | description: " + rentailRepairList.get(0).getDescription());
		} else {
			System.out.println("z92:  Exiting RentalRepairDaoImpl  findAllRentalRepairsByRepairStatus() method   theRentalRepair: is null" );								
		}
		
		
		
		System.out.println("z99:  Exiting RentalRepairDaoImpl  findAllRentalRepairsByRepairStatus() method\n\n");
		
		return rentailRepairList;
	}
	
	// dao method for rental repair find all rental repairs service
	@Override
	public List<RentalRepair> findAllRentalRepairs() {
		
		System.out.println("a1:  Entering RentalRepairDaoImpl  findAllRentalRepairs() method");

		
		List<RentalRepair> rentailRepairList = null;
		
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database
		Query<RentalRepair> theQuery = currentSession.createQuery("from RentalRepair", RentalRepair.class);

		try {
			rentailRepairList = (List<RentalRepair>)theQuery.getResultList();
		} catch (Exception e) {
			rentailRepairList = null;
		}

		if (rentailRepairList != null) {
			System.out.println("z90:  Exiting RentalRepairDaoImpl  findAllRentalRepairs() method   rentailRepairList[0]:   id: "  + rentailRepairList.get(0).getId()   + " | repairStatus: " + rentailRepairList.get(0).getRepairStatus() + " | description: " + rentailRepairList.get(0).getDescription());
		} else {
			System.out.println("z92:  Exiting RentalRepairDaoImpl  findAllRentalRepairs() method   rentailRepairList is null" );								
		}
		
		
		
		System.out.println("z99:  Exiting RentalRepairDaoImpl  findAllRentalRepairs() method\n\n");
		
		return rentailRepairList;
	}
	
	// dao method for rental repair save service
	@Override
	public void save(RentalRepair rentalRepair) {
		 
			// get current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// save or update the record
			currentSession.saveOrUpdate(rentalRepair);

	}

	// dao method for rental repair delete service
	@Override
	public void delete(RentalRepair rentalRepair) {
		 
			// get current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// delete the record
			currentSession.delete(rentalRepair);

	}


}
