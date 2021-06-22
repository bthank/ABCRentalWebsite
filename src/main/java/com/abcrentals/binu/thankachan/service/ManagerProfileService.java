package com.abcrentals.binu.thankachan.service;

import java.util.List;

import com.abcrentals.binu.thankachan.entity.ManagerProfile;

/*
 * Interface used for DAO service method declaration for ManagerProfile entity class
 * 
 * 
 * 
 */


public interface ManagerProfileService {

	ManagerProfile findById(long id);
	
	ManagerProfile findByUserId(long userId);
	
	List<ManagerProfile> findAllManagerProfiles();
    
    void save(ManagerProfile managerProfile);
    
    void delete(ManagerProfile managerProfile);

}