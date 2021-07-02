package com.abcrentals.binu.thankachan.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcrentals.binu.thankachan.dao.ContactInfoDao;
import com.abcrentals.binu.thankachan.entity.ContactInfo;

@Service
public class ContactInfoServiceImpl implements ContactInfoService{


	// need to inject address dao
	@Autowired
	private ContactInfoDao contactInfoDao;

	// method for Contact Info find contact info by id service
	@Override
	@Transactional
	public ContactInfo findContactInfoById(int id) {
		
		// check the database if the contactInfo already exists
		return contactInfoDao.findContactInfoById(id);

	}

	// method for Contact Info save service
	@Override
	@Transactional
	public void save(ContactInfo contactInfo) {
		
		contactInfoDao.save(contactInfo);	

	}

	// method for Contact Info delete service
	@Override
	@Transactional
	public void delete(ContactInfo contactInfo) {
		 
		contactInfoDao.delete(contactInfo);
		
	}


	
	
}
