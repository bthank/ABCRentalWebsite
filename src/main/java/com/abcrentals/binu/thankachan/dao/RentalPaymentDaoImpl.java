package com.abcrentals.binu.thankachan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abcrentals.binu.thankachan.entity.RentalPayment;
import com.abcrentals.binu.thankachan.entity.RentalRepair;

/*
 * Class used for DAO access method definition for RentalPayment entity class
 * 
 * 
 * 
 */


@Repository
public class RentalPaymentDaoImpl implements RentalPaymentDao{
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
		
	
	
	@Override
	public RentalPayment findById(long id) {
		
		System.out.println("a1:  Entering RentalPaymentDaoImpl  findById() method    id: " + id);
		   
		   
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using id
		Query<RentalPayment> theQuery = currentSession.createQuery("from RentalPayment where id=:rentalPaymntId", RentalPayment.class);
		theQuery.setParameter("rentalPaymntId", id);
		RentalPayment theRentalPayment = null;
		try {
			theRentalPayment = (RentalPayment)theQuery.getSingleResult();
		} catch (Exception e) {
			theRentalPayment = null;
		}

		if (theRentalPayment != null) {
			System.out.println("a90:  Exiting RentalPaymentDaoImpl  findById() method   theRentalPayment:   id: " + theRentalPayment.getId() + " | property id: " + theRentalPayment.getRentalPropertyId() + " | unit no: " + theRentalPayment.getRentalUnitNo()  + " | mgr id: " + theRentalPayment.getRentalYear() + " | mgr id: " + theRentalPayment.getRentalMonth());
		} else {
			System.out.println("a92:  Exiting RentalPaymentDaoImpl  findById() method   theRentalPayment: is null" );								
		}
		
		System.out.println("a99:  Exiting RentalPaymentDaoImpl  findById() method\\n\\n");

		return theRentalPayment;	
		
	}

	@Override
	public List<RentalPayment> findAllRentalPaymentsByRenterUserId(long renterUserId) {
		
		System.out.println("b1:  Entering RentalPaymentDaoImpl   findAllRentalPaymentsByRenterUserId() method    renterUserId: " + renterUserId);
		   
		   
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using renterUserId
		Query<RentalPayment> theQuery = currentSession.createQuery("from RentalPayment where renterUserId=:rentalUsrId", RentalPayment.class);
		theQuery.setParameter("rentalUsrId", renterUserId);
		List<RentalPayment> theRentalPaymentList = null;
		try {
			theRentalPaymentList = (List<RentalPayment>)theQuery.getResultList();
		} catch (Exception e) {
			theRentalPaymentList = null;
		}

		if (!theRentalPaymentList.isEmpty()) {
			System.out.println("b90:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByRenterUserId() method   theRentalPaymentList:   id: " + theRentalPaymentList.get(0).getId() + " | property id: " + theRentalPaymentList.get(0).getRentalPropertyId() + " | unit no: " + theRentalPaymentList.get(0).getRentalUnitNo()  + " | mgr id: " + theRentalPaymentList.get(0).getRentalYear() + " | mgr id: " + theRentalPaymentList.get(0).getRentalMonth());
		} else {
			System.out.println("b92:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByRenterUserId() method   theRentalPaymentList is empty" );								
		}
		
		System.out.println("b99:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByRenterUserId() method\\n\\n");

		return theRentalPaymentList;	
		
	}

	@Override
	public List<RentalPayment> findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNo(long rentalPropertyId,
			int rentalUnitNo) {
		
		System.out.println("c1:  Entering RentalPaymentDaoImpl   findAllRentalPaymentsByRenterUserId() method    rentalPropertyId= " + rentalPropertyId + "  |  rentalUnitNo= " + rentalUnitNo);
		   
		   
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using renterUserId
		Query<RentalPayment> theQuery = currentSession.createQuery("FROM RentalPayment WHERE rentalPropertyId=:rentalProprtyId AND rentalUnitNo=:rentalUntNo", RentalPayment.class);
		theQuery.setParameter("rentalProprtyId", rentalPropertyId);
		theQuery.setParameter("rentalUntNo", rentalUnitNo);

		List<RentalPayment> theRentalPaymentList = null;
		try {
			theRentalPaymentList = (List<RentalPayment>)theQuery.getResultList();
		} catch (Exception e) {
			theRentalPaymentList = null;
		}

		if (!theRentalPaymentList.isEmpty()) {
			System.out.println("c90:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByRenterUserId() method   theRentalPaymentList:   id: " + theRentalPaymentList.get(0).getId() + " | property id: " + theRentalPaymentList.get(0).getRentalPropertyId() + " | unit no: " + theRentalPaymentList.get(0).getRentalUnitNo()  + " | mgr id: " + theRentalPaymentList.get(0).getRentalYear() + " | mgr id: " + theRentalPaymentList.get(0).getRentalMonth());
		} else {
			System.out.println("c92:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByRenterUserId() method   theRentalPaymentList is empty" );								
		}
		
		System.out.println("c99:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByRenterUserId() method\\n\\n");

		return theRentalPaymentList;	
		
	}

	@Override
	public List<RentalPayment> findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonth(
			long rentalPropertyId, int rentalUnitNo, String year, String month) {
		
		System.out.println("d1:  Entering RentalPaymentDaoImpl   findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonth() method    rentalPropertyId= " + rentalPropertyId + "  |  rentalUnitNo= " + rentalUnitNo + "  |  year= " + year + "  |  month= " + month);
		   
		   
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using renterUserId
		Query<RentalPayment> theQuery = currentSession.createQuery("FROM RentalPayment WHERE rentalPropertyId=:rentalProprtyId AND rentalUnitNo=:rentalUntNo AND rentalYear=:rentalYr AND rentalMonth=:rentalMnth", RentalPayment.class);
		theQuery.setParameter("rentalProprtyId", rentalPropertyId);
		theQuery.setParameter("rentalUntNo", rentalUnitNo);
		theQuery.setParameter("rentalYr", year);
		theQuery.setParameter("rentalMnth", month);

		List<RentalPayment> theRentalPaymentList = null;
		try {
			theRentalPaymentList = (List<RentalPayment>)theQuery.getResultList();
		} catch (Exception e) {
			theRentalPaymentList = null;
		}

		if (!theRentalPaymentList.isEmpty()) {
			System.out.println("d90:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonth() method   theRentalPaymentList:   id: " + theRentalPaymentList.get(0).getId() + " | property id: " + theRentalPaymentList.get(0).getRentalPropertyId() + " | unit no: " + theRentalPaymentList.get(0).getRentalUnitNo()  + " | mgr id: " + theRentalPaymentList.get(0).getRentalYear() + " | mgr id: " + theRentalPaymentList.get(0).getRentalMonth());
		} else {
			System.out.println("d92:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonth() method   theRentalPaymentList is empty" );								
		}
		
		System.out.println("d99:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonth() method\\n\\n");

		return theRentalPaymentList;	
		
	}

	@Override
	public List<RentalPayment> findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYear(long rentalPropertyId,
			int rentalUnitNo, String year) {
		
		System.out.println("e1:  Entering RentalPaymentDaoImpl   findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYear() method    rentalPropertyId= " + rentalPropertyId + "  |  rentalUnitNo= " + rentalUnitNo + "  |  year= " + year);
		   
		   
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using renterUserId
		Query<RentalPayment> theQuery = currentSession.createQuery("FROM RentalPayment WHERE rentalPropertyId=:rentalProprtyId AND rentalUnitNo=:rentalUntNo AND rentalYear=:rentalYr", RentalPayment.class);
		theQuery.setParameter("rentalProprtyId", rentalPropertyId);
		theQuery.setParameter("rentalUntNo", rentalUnitNo);
		theQuery.setParameter("rentalYr", year);

		List<RentalPayment> theRentalPaymentList = null;
		try {
			theRentalPaymentList = (List<RentalPayment>)theQuery.getResultList();
		} catch (Exception e) {
			theRentalPaymentList = null;
		}

		if (!theRentalPaymentList.isEmpty()) {
			System.out.println("e90:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYear() method   theRentalPaymentList:   id: " + theRentalPaymentList.get(0).getId() + " | property id: " + theRentalPaymentList.get(0).getRentalPropertyId() + " | unit no: " + theRentalPaymentList.get(0).getRentalUnitNo()  + " | mgr id: " + theRentalPaymentList.get(0).getRentalYear() + " | mgr id: " + theRentalPaymentList.get(0).getRentalMonth());
		} else {
			System.out.println("e92:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYear() method   theRentalPaymentList is empty" );								
		}
		
		System.out.println("e99:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYear() method\\n\\n");

		return theRentalPaymentList;	
		
	}

	
	
	
	

	@Override
	public List<RentalPayment> findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonthAndRenterUserId(
			long rentalPropertyId, int rentalUnitNo, String year, String month, long renterUserId) {
		
		System.out.println("p1:  Entering RentalPaymentDaoImpl   findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonthAndRenterUserId() method    year= " + year + "     month= " + month);
		   
		   
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using renterUserId
		Query<RentalPayment> theQuery = currentSession.createQuery("FROM RentalPayment WHERE rentalPropertyId=:rentalProprtyId AND rentalUnitNo=:rentalUntNo AND rentalYear=:rentalYr AND rentalMonth=:rentalMnth AND renterUserId=:renterUsrId", RentalPayment.class);
		theQuery.setParameter("rentalProprtyId", rentalPropertyId);
		theQuery.setParameter("rentalUntNo", rentalUnitNo);	
		theQuery.setParameter("rentalYr",   year);
		theQuery.setParameter("rentalMnth", month);
		theQuery.setParameter("renterUsrId", renterUserId);

		List<RentalPayment> theRentalPaymentList = null;
		try {
			theRentalPaymentList = (List<RentalPayment>)theQuery.getResultList();
		} catch (Exception e) {
			theRentalPaymentList = null;
		}

		if (!theRentalPaymentList.isEmpty()) {
			System.out.println("p90:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonthAndRenterUserId() method   theRentalPaymentList:   id: " + theRentalPaymentList.get(0).getId() + " | property id: " + theRentalPaymentList.get(0).getRentalPropertyId() + " | unit no: " + theRentalPaymentList.get(0).getRentalUnitNo()  + " | mgr id: " + theRentalPaymentList.get(0).getRentalYear() + " | mgr id: " + theRentalPaymentList.get(0).getRentalMonth());
		} else {
			System.out.println("p92:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonthAndRenterUserId() method   theRentalPaymentList is empty" );								
		}
		
		System.out.println("p99:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonthAndRenterUserId() method\\n\\n");

		return theRentalPaymentList;	
		
	}

	@Override
	public List<RentalPayment> findAllRentalPaymentsByYearAndMonthAndRenterUserId(String year, String month,long renterUserId) {
		
		System.out.println("q1:  Entering RentalPaymentDaoImpl   findAllRentalPaymentsByYearAndMonthAndRenterUserId() method    year= " + year + "     month= " + month);
		   
		   
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using renterUserId
		Query<RentalPayment> theQuery = currentSession.createQuery("FROM RentalPayment WHERE rentalYear=:rentalYr AND rentalMonth=:rentalMnth AND renterUserId=:renterUsrId", RentalPayment.class);
		theQuery.setParameter("rentalYr",   year);
		theQuery.setParameter("rentalMnth", month);
		theQuery.setParameter("renterUsrId", renterUserId);

		List<RentalPayment> theRentalPaymentList = null;
		try {
			theRentalPaymentList = (List<RentalPayment>)theQuery.getResultList();
		} catch (Exception e) {
			theRentalPaymentList = null;
		}

		if (!theRentalPaymentList.isEmpty()) {
			System.out.println("q90:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByYearAndMonthAndRenterUserId() method   theRentalPaymentList:   id: " + theRentalPaymentList.get(0).getId() + " | property id: " + theRentalPaymentList.get(0).getRentalPropertyId() + " | unit no: " + theRentalPaymentList.get(0).getRentalUnitNo()  + " | mgr id: " + theRentalPaymentList.get(0).getRentalYear() + " | mgr id: " + theRentalPaymentList.get(0).getRentalMonth());
		} else {
			System.out.println("q92:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByYearAndMonthAndRenterUserId() method   theRentalPaymentList empty" );								
		}
		
		System.out.println("q99:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByYearAndMonthAndRenterUserId() method\\n\\n");

		return theRentalPaymentList;	
		
	}

	@Override
	public List<RentalPayment> findAllRentalPaymentsByYearAndMonth(String year, String month) {
		
		System.out.println("r1:  Entering RentalPaymentDaoImpl   findAllRentalPaymentsByYearAndMonth() method    year= " + year + "     month= " + month);
		   
		   
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using renterUserId
		Query<RentalPayment> theQuery = currentSession.createQuery("FROM RentalPayment WHERE rentalYear=:rentalYr AND rentalMonth=:rentalMnth", RentalPayment.class);
		theQuery.setParameter("rentalYr",   year);
		theQuery.setParameter("rentalMnth", month);

		List<RentalPayment> theRentalPaymentList = null;
		try {
			theRentalPaymentList = (List<RentalPayment>)theQuery.getResultList();
		} catch (Exception e) {
			theRentalPaymentList = null;
		}

		if (!theRentalPaymentList.isEmpty()) {
			System.out.println("r90:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByYearAndMonth() method   theRentalPaymentList:   id: " + theRentalPaymentList.get(0).getId() + " | property id: " + theRentalPaymentList.get(0).getRentalPropertyId() + " | unit no: " + theRentalPaymentList.get(0).getRentalUnitNo()  + " | mgr id: " + theRentalPaymentList.get(0).getRentalYear() + " | mgr id: " + theRentalPaymentList.get(0).getRentalMonth());
		} else {
			System.out.println("r92:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByYearAndMonth() method   theRentalPaymentList is empty" );								
		}
		
		System.out.println("r99:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByYearAndMonth() method\\n\\n");

		return theRentalPaymentList;	
		
	}
	
	
	

	@Override
	public List<RentalPayment> findAllRentalPaymentsByMonthAndRenterUserId(String month, long renterUserId) {

		System.out.println("r1:  Entering RentalPaymentDaoImpl   findAllRentalPaymentsByMonthAndRenterUserId() method    month= " + month + "     renterUserId= " + renterUserId);
		   
		   
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using renterUserId
		Query<RentalPayment> theQuery = currentSession.createQuery("FROM RentalPayment WHERE rentalMonth=:rentalMnth AND renterUserId=:renterUsrId", RentalPayment.class);
		theQuery.setParameter("rentalMnth", month);
		theQuery.setParameter("renterUsrId", renterUserId);

		List<RentalPayment> theRentalPaymentList = null;
		try {
			theRentalPaymentList = (List<RentalPayment>)theQuery.getResultList();
		} catch (Exception e) {
			theRentalPaymentList = null;
		}

		if (!theRentalPaymentList.isEmpty()) {
			System.out.println("r90:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByMonthAndRenterUserId() method   theRentalPaymentList:   id: " + theRentalPaymentList.get(0).getId() + " | property id: " + theRentalPaymentList.get(0).getRentalPropertyId() + " | unit no: " + theRentalPaymentList.get(0).getRentalUnitNo()  + " | mgr id: " + theRentalPaymentList.get(0).getRentalYear() + " | mgr id: " + theRentalPaymentList.get(0).getRentalMonth());
		} else {
			System.out.println("r92:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByMonthAndRenterUserId() method   theRentalPaymentList is empty" );								
		}
		
		System.out.println("r99:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByMonthAndRenterUserId() method\\n\\n");

		return theRentalPaymentList;	}
	
	
	
	

	@Override
	public List<RentalPayment> findAllRentalPaymentsByYear(String year) {
		
		System.out.println("s1:  Entering RentalPaymentDaoImpl   findAllRentalPaymentsByYear() method    year= " + year);
		   
		   
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using renterUserId
		Query<RentalPayment> theQuery = currentSession.createQuery("FROM RentalPayment WHERE rentalYear=:rentalYr", RentalPayment.class);
		theQuery.setParameter("rentalYr", year);

		List<RentalPayment> theRentalPaymentList = null;
		try {
			theRentalPaymentList = (List<RentalPayment>)theQuery.getResultList();
		} catch (Exception e) {
			theRentalPaymentList = null;
		}

		if (!theRentalPaymentList.isEmpty()) {
			System.out.println("s90:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByYear() method   theRentalPaymentList:   id: " + theRentalPaymentList.get(0).getId() + " | property id: " + theRentalPaymentList.get(0).getRentalPropertyId() + " | unit no: " + theRentalPaymentList.get(0).getRentalUnitNo()  + " | mgr id: " + theRentalPaymentList.get(0).getRentalYear() + " | mgr id: " + theRentalPaymentList.get(0).getRentalMonth());
		} else {
			System.out.println("s92:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByYear() method   theRentalPaymentList is empty" );								
		}
		
		System.out.println("s99:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByYear() method\\n\\n");

		return theRentalPaymentList;	
		
	}

	@Override
	public List<RentalPayment> findAllRentalPaymentsByMonth(String month) {
		
		System.out.println("t1:  Entering RentalPaymentDaoImpl   findAllRentalPaymentsByMonth() method    month= " + month);
		   
		   
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using renterUserId
		Query<RentalPayment> theQuery = currentSession.createQuery("FROM RentalPayment WHERE rentalMonth=:rentalMnth", RentalPayment.class);
		theQuery.setParameter("rentalMnth", month);

		List<RentalPayment> theRentalPaymentList = null;
		try {
			theRentalPaymentList = (List<RentalPayment>)theQuery.getResultList();
		} catch (Exception e) {
			theRentalPaymentList = null;
		}
		System.out.println("t89:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByMonth() method   theRentalPaymentList: " + theRentalPaymentList.toString());
		if (!theRentalPaymentList.isEmpty()) {
			System.out.println("t90:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByMonth() method   theRentalPaymentList:   id: " + theRentalPaymentList.get(0).getId() + " | property id: " + theRentalPaymentList.get(0).getRentalPropertyId() + " | unit no: " + theRentalPaymentList.get(0).getRentalUnitNo()  + " | mgr id: " + theRentalPaymentList.get(0).getRentalYear() + " | mgr id: " + theRentalPaymentList.get(0).getRentalMonth());
		} else {
			System.out.println("t92:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByMonth() method   theRentalPaymentList: is empty" );								
		}
		
		System.out.println("t99:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByMonth() method\\n\\n");

		return theRentalPaymentList;	
		
	}

	
	@Override
	public List<RentalPayment> findAllRentalPaymentsByRentalUnitNo(int rentalUnitNo) {
		
		System.out.println("t1:  Entering RentalPaymentDaoImpl   findAllRentalPaymentsByRentalUnitNo() method    rentalUnitNo= " + rentalUnitNo);
		   
		   
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using renterUserId
		Query<RentalPayment> theQuery = currentSession.createQuery("FROM RentalPayment WHERE rentalUnitNo=:rentalUntNo", RentalPayment.class);
		theQuery.setParameter("rentalUntNo", rentalUnitNo);

		List<RentalPayment> theRentalPaymentList = null;
		try {
			theRentalPaymentList = (List<RentalPayment>)theQuery.getResultList();
		} catch (Exception e) {
			theRentalPaymentList = null;
		}
		System.out.println("t89:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByRentalUnitNo() method   theRentalPaymentList: " + theRentalPaymentList.toString());
		if (!theRentalPaymentList.isEmpty()) {
			System.out.println("t90:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByRentalUnitNo() method   theRentalPaymentList:   id: " + theRentalPaymentList.get(0).getId() + " | property id: " + theRentalPaymentList.get(0).getRentalPropertyId() + " | unit no: " + theRentalPaymentList.get(0).getRentalUnitNo()  + " | mgr id: " + theRentalPaymentList.get(0).getRentalYear() + " | mgr id: " + theRentalPaymentList.get(0).getRentalMonth());
		} else {
			System.out.println("t92:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByRentalUnitNo() method   theRentalPaymentList: is empty" );								
		}
		
		System.out.println("t99:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByRentalUnitNo() method\\n\\n");

		return theRentalPaymentList;	
		
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<RentalPayment> findAllRentalPaymentsByRentalPropertyId(long rentalPropertyId) {
		
		System.out.println("f1:  Entering RentalPaymentDaoImpl   findAllRentalPaymentsByRentalPropertyId() method    rentalPropertyId= " + rentalPropertyId);
		   
		   
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using renterUserId
		Query<RentalPayment> theQuery = currentSession.createQuery("FROM RentalPayment WHERE rentalPropertyId=:rentalProprtyId", RentalPayment.class);
		theQuery.setParameter("rentalProprtyId", rentalPropertyId);

		List<RentalPayment> theRentalPaymentList = null;
		try {
			theRentalPaymentList = (List<RentalPayment>)theQuery.getResultList();
		} catch (Exception e) {
			theRentalPaymentList = null;
		}

		if (!theRentalPaymentList.isEmpty()) {
			System.out.println("f90:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByRentalPropertyId() method   theRentalPaymentList:   id: " + theRentalPaymentList.get(0).getId() + " | property id: " + theRentalPaymentList.get(0).getRentalPropertyId() + " | unit no: " + theRentalPaymentList.get(0).getRentalUnitNo()  + " | mgr id: " + theRentalPaymentList.get(0).getRentalYear() + " | mgr id: " + theRentalPaymentList.get(0).getRentalMonth());
		} else {
			System.out.println("f92:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByRentalPropertyId() method   theRentalPaymentList is empty" );								
		}  
		
		System.out.println("f99:  Exiting RentalPaymentDaoImpl  findAllRentalPaymentsByRentalPropertyId() method\\n\\n");

		return theRentalPaymentList;	
		
	}

	@Override
	public List<RentalPayment> findAllRentalPayments() {
		
		System.out.println("g1:  Entering RentalPaymentDaoImpl   findAllRentalPayments() method");
		   
		   
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using renterUserId
		Query<RentalPayment> theQuery = currentSession.createQuery("FROM RentalPayment", RentalPayment.class);

		List<RentalPayment> theRentalPaymentList = null;
		try {
			theRentalPaymentList = (List<RentalPayment>)theQuery.getResultList();
		} catch (Exception e) {
			theRentalPaymentList = null;
		}

		if (!theRentalPaymentList.isEmpty()) {
	// 		System.out.println("g90:  Exiting RentalPaymentDaoImpl  findAllRentalPayments() method   theRentalPaymentList:   id: " + theRentalPaymentList.get(0).getId() + " | property id: " + theRentalPaymentList.get(0).getRentalPropertyId() + " | unit no: " + theRentalPaymentList.get(0).getRentalUnitNo()  + " | mgr id: " + theRentalPaymentList.get(0).getRentalYear() + " | mgr id: " + theRentalPaymentList.get(0).getRentalMonth());
		} else {
			System.out.println("g92:  Exiting RentalPaymentDaoImpl  findAllRentalPayments() method   theRentalPaymentList is empty" );								
		}
		
		System.out.println("g99:  Exiting RentalPaymentDaoImpl  findAllRentalPayments() method\\n\\n");

		return theRentalPaymentList;
		
	}

	@Override
	public void save(RentalPayment rentalPayment) {
		 
			// get current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// save or update the record
			currentSession.saveOrUpdate(rentalPayment);

	}

	@Override
	public void delete(RentalPayment rentalPayment) {
		 
			// get current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// delete the record
			currentSession.delete(rentalPayment);

	}




}
