package com.abcrentals.binu.thankachan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcrentals.binu.thankachan.dao.ManagerProfileDao;
import com.abcrentals.binu.thankachan.entity.ManagerProfile;

@Service
public class ManagerProfileServiceImpl implements ManagerProfileService{

	@Autowired 
	ManagerProfileDao managerProfileDao;
	
	
	// method for Manager Profile find by id service
	@Override
	@Transactional
	public ManagerProfile findById(long id) {
		 
		return managerProfileDao.findById(id);
	}

	// method for Manager Profile find by user id service
	@Override
	@Transactional
	public ManagerProfile findByUserId(long userId) {
		
		return managerProfileDao.findByUserId(userId);
	}

	// method for Manager Profile find all manager profiles service
	@Override
	@Transactional
	public List<ManagerProfile> findAllManagerProfiles() {
		 
		return managerProfileDao.findAllManagerProfiles();
	}
	
	// method for Manager Profile save service
	@Override
	@Transactional
	public void save(ManagerProfile managerProfile) {
		 
		managerProfileDao.save(managerProfile);
		
	}

	// method for Manager Profile delete service
	@Override
	@Transactional
	public void delete(ManagerProfile managerProfile) {
		 
		managerProfileDao.delete(managerProfile);
		
	}


}
