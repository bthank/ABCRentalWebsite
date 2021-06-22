package com.abcrentals.binu.thankachan.service;

import com.abcrentals.binu.thankachan.entity.ContactInfo;

/*
 * Interface used for DAO service method declaration for ContactInfo entity class
 * 
 * 
 * 
 */


public interface ContactInfoService {

    ContactInfo findContactInfoById(int id);
    
    void save(ContactInfo contactInfo);
    
    void delete(ContactInfo contactInfo);
	
}
