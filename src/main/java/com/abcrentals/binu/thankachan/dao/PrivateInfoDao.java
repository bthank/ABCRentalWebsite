package com.abcrentals.binu.thankachan.dao;

import com.abcrentals.binu.thankachan.entity.PrivateInfo;

/*
 * Interface used for DAO access method declaration for PrivateInfo entity class
 * 
 * 
 * 
 */


public interface PrivateInfoDao {

	PrivateInfo findPrivateInfoById(int id);
   
    void save(PrivateInfo privateInfo);
    
    void delete(PrivateInfo privateInfo);

}
