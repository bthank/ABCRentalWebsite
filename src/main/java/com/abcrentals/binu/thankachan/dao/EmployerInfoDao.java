package com.abcrentals.binu.thankachan.dao;

import com.abcrentals.binu.thankachan.entity.EmployerInfo;

/*
 * Interface used for DAO access method declaration for EmployerInfo entity class
 * 
 * 
 * 
 */


public interface EmployerInfoDao {

	EmployerInfo findEmployerInfoById(int id);
   
    void save(EmployerInfo employerInfo);
    
    void delete(EmployerInfo employerInfo);

}
