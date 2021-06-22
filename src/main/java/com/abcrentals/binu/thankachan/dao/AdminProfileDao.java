package com.abcrentals.binu.thankachan.dao;

import com.abcrentals.binu.thankachan.entity.AdminProfile;

/*
 * Interface used for DAO access method declaration for AdminProfile entity class
 * 
 * 
 * 
 */


public interface AdminProfileDao {

	AdminProfile findById(long id);
	
	AdminProfile findByUserId(long userId);
    
    void save(AdminProfile adminProfile);
    
    void delete(AdminProfile adminProfile);
    
}
