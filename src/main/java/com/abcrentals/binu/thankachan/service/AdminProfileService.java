package com.abcrentals.binu.thankachan.service;

import com.abcrentals.binu.thankachan.entity.AdminProfile;

/*
 * Interface used for DAO service method declaration for AdminProfile entity class
 * 
 * 
 * 
 */


public interface AdminProfileService {

	AdminProfile findById(long id);
	
	AdminProfile findByUserId(long userId);
    
    void save(AdminProfile adminProfile);
    
    void delete(AdminProfile adminProfile);
}