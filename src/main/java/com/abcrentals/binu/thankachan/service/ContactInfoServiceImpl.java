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

	@Override
	@Transactional
	public ContactInfo findContactInfoById(int id) {
		
		// check the database if the contactInfo already exists
		return contactInfoDao.findContactInfoById(id);

	}

	@Override
	@Transactional
	public void save(ContactInfo contactInfo) {
		
		contactInfoDao.save(contactInfo);	

	}

	@Override
	@Transactional
	public void delete(ContactInfo contactInfo) {
		 
		contactInfoDao.delete(contactInfo);
		
	}


	
	
}
