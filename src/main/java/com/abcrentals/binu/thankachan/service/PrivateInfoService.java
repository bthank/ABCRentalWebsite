package com.abcrentals.binu.thankachan.service;

import com.abcrentals.binu.thankachan.entity.PrivateInfo;

/*
 * Interface used for DAO service method declaration for PrivateInfo entity class
 * 
 * 
 * 
 */


public interface PrivateInfoService {

	PrivateInfo findPrivateInfoById(int id);
    
    void save(PrivateInfo privateInfo);
    
    void delete(PrivateInfo privateInfo);


}
