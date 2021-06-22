package com.abcrentals.binu.thankachan.dao;

import com.abcrentals.binu.thankachan.entity.EmployeeProfile;

/*
 * Interface used for DAO access method declaration for EmployerProfile entity class
 * 
 * 
 * 
 */


public interface EmployeeProfileDao {
	
	EmployeeProfile findById(long id);
	
	EmployeeProfile findByUserId(long userId);
    
    void save(EmployeeProfile employeeProfile);
    
    void delete(EmployeeProfile employeeProfile);

}
