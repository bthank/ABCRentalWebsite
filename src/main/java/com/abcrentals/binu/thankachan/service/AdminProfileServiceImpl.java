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
	
	
	@Override
	@Transactional
	public AdminProfile findById(long id) {
		 
		return adminProfileDao.findById(id);
	}

	@Override
	@Transactional
	public AdminProfile findByUserId(long userId) {
		
		return adminProfileDao.findByUserId(userId);
	}

	@Override
	@Transactional
	public void save(AdminProfile adminProfile) {
		 
		adminProfileDao.save(adminProfile);
		
	}
	
	@Override
	@Transactional
	public void delete(AdminProfile adminProfile) {
		 
		adminProfileDao.delete(adminProfile);
		
	}

}
