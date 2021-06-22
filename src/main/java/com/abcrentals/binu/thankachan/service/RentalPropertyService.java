package com.abcrentals.binu.thankachan.service;

import java.util.List;

import com.abcrentals.binu.thankachan.entity.RentalProperty;

/*
 * Interface used for DAO service method declaration for RentalProperty entity class
 * 
 * 
 * 
 */


public interface RentalPropertyService {
	
	RentalProperty findById(long id);
	
	List<RentalProperty> findByOwnerUserId(long ownerUserId);

	List<RentalProperty> findByManagerUserId(long managerUserId);
	
	List<RentalProperty> findAllRentalProperties();

    void save(RentalProperty rentalProperty);
    
    void delete(RentalProperty rentalProperty);
}
