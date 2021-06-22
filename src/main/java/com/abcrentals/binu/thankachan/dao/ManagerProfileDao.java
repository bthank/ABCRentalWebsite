package com.abcrentals.binu.thankachan.dao;

import java.util.List;

import com.abcrentals.binu.thankachan.entity.ManagerProfile;

/*
 * Interface used for DAO access method declaration for ManagerProfile entity class
 * 
 * 
 * 
 */


public interface ManagerProfileDao {
	
	ManagerProfile findById(long id);
	
	ManagerProfile findByUserId(long userId);
	
	List<ManagerProfile> findAllManagerProfiles();
    
    void save(ManagerProfile managerProfile);
    
    void delete(ManagerProfile managerProfile);
}
