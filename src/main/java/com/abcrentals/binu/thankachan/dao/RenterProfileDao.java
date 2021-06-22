package com.abcrentals.binu.thankachan.dao;

import java.util.List;

import com.abcrentals.binu.thankachan.entity.RenterProfile;

/*
 * Interface used for DAO access method declaration for RenterProfile entity class
 * 
 * 
 * 
 */


public interface RenterProfileDao {

	RenterProfile findById(long id);
	
	RenterProfile findByUserId(long userId);
	
	List<RenterProfile> findAllRenterProfiles();
    
    void save(RenterProfile renterProfile);
    
    void delete(RenterProfile renterProfile);
}
