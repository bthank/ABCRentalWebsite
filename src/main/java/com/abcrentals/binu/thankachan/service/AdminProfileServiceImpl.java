package com.abcrentals.binu.thankachan.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcrentals.binu.thankachan.dao.AdminProfileDao;
import com.abcrentals.binu.thankachan.entity.AdminProfile;

@Service
public class AdminProfileServiceImpl implements AdminProfileService{

	@Autowired 
	AdminProfileDao adminProfileDao;
	
	// method for Admin Profile find by id service
	@Override
	@Transactional
	public AdminProfile findById(long id) {
		 
		return adminProfileDao.findById(id);
	}

	// method for Admin Profile find by user id service
	@Override
	@Transactional
	public AdminProfile findByUserId(long userId) {
		
		return adminProfileDao.findByUserId(userId);
	}

	// method for Admin Profile save service
	@Override
	@Transactional
	public void save(AdminProfile adminProfile) {
		 
		adminProfileDao.save(adminProfile);
		
	}
	
	// method for Admin Profile delete service
	@Override
	@Transactional
	public void delete(AdminProfile adminProfile) {
		 
		adminProfileDao.delete(adminProfile);
		
	}

}
