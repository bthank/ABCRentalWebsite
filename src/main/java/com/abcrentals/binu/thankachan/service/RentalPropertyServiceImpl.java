package com.abcrentals.binu.thankachan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcrentals.binu.thankachan.dao.RentalPropertyDao;
import com.abcrentals.binu.thankachan.entity.RentalProperty;

@Service
public class RentalPropertyServiceImpl implements RentalPropertyService{


	// need to inject address dao
	@Autowired
	private RentalPropertyDao rentalPropertyDao;
	
	@Override
	@Transactional
	public RentalProperty findById(long id) {
		
		// check the database if the RentalPropert already exists
		return rentalPropertyDao.findById(id);

	}

	@Override
	@Transactional
	public List<RentalProperty> findByOwnerUserId(long ownerUserId) {
		
		return rentalPropertyDao.findByOwnerUserId(ownerUserId);
	}

	@Override
	@Transactional
	public List<RentalProperty> findByManagerUserId(long managerUserId) {
		 
		return rentalPropertyDao.findByManagerUserId(managerUserId);
	}
	
	@Override
	@Transactional
	public List<RentalProperty> findAllRentalProperties() {
		 
		return rentalPropertyDao.findAllRentalProperties();
	}	

	@Override
	@Transactional
	public void save(RentalProperty rentalProperty) {

		rentalPropertyDao.save(rentalProperty);
		
	}

	@Override
	@Transactional
	public void delete(RentalProperty rentalProperty) {

		rentalPropertyDao.delete(rentalProperty);
		
	}


	
	
	
}
