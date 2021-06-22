package com.abcrentals.binu.thankachan.dao;

import java.util.List;

import com.abcrentals.binu.thankachan.entity.OwnerProfile;

/*
 * Interface used for DAO access method declaration for OwnerProfile entity class
 * 
 * 
 * 
 */


public interface OwnerProfileDao {

	OwnerProfile findById(long id);
	
	OwnerProfile findByUserId(long userId);
	
	List<OwnerProfile> findAllOwnerProfiles();
    
    void save(OwnerProfile ownerProfile);
    
    void delete(OwnerProfile ownerProfile);
    
}
