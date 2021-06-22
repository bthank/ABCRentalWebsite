package com.abcrentals.binu.thankachan.service;

import java.util.List;

import com.abcrentals.binu.thankachan.entity.OwnerProfile;

/*
 * Interface used for DAO service method declaration for OwnerProfile entity class
 * 
 * 
 * 
 */


public interface OwnerProfileService {

	OwnerProfile findById(long id);
	
	OwnerProfile findByUserId(long userId);
	
	List<OwnerProfile> findAllOwnerProfiles();
    
    void save(OwnerProfile ownerProfile);
    
    void delete(OwnerProfile ownerProfile);
}