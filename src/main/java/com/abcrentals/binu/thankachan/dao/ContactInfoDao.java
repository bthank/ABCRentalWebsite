package com.abcrentals.binu.thankachan.dao;

import com.abcrentals.binu.thankachan.entity.ContactInfo;

/*
 * Interface used for DAO access method declaration for ContactInfo entity class
 * 
 * 
 * 
 */


public interface ContactInfoDao {

    ContactInfo findContactInfoById(int id);
    
    void save(ContactInfo contactInfo);
    
    void delete(ContactInfo contactInfo);

}
