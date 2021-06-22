package com.abcrentals.binu.thankachan.service;

import com.abcrentals.binu.thankachan.entity.EmployerInfo;

/*
 * Interface used for DAO service method declaration for EmployerInfo entity class
 * 
 * 
 * 
 */


public interface EmployerInfoService {

	EmployerInfo findEmployerInfoById(int id);
    
    void save(EmployerInfo employerInfo);
    
    void delete(EmployerInfo employerInfo);


}
