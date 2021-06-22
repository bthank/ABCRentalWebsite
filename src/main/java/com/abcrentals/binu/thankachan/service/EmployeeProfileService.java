package com.abcrentals.binu.thankachan.service;

import com.abcrentals.binu.thankachan.entity.EmployeeProfile;

/*
 * Interface used for DAO service method declaration for EmployeeProfile entity class
 * 
 * 
 * 
 */


public interface EmployeeProfileService {
	
	EmployeeProfile findById(long id);
	
	EmployeeProfile findByUserId(long userId);
    
    void save(EmployeeProfile employeeProfile);
    
    void delete(EmployeeProfile employeeProfile);

}
