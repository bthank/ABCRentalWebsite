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
	
	
	@Override
	@Transactional
	public ManagerProfile findById(long id) {
		 
		return managerProfileDao.findById(id);
	}

	@Override
	@Transactional
	public ManagerProfile findByUserId(long userId) {
		
		return managerProfileDao.findByUserId(userId);
	}

	@Override
	@Transactional
	public List<ManagerProfile> findAllManagerProfiles() {
		 
		return managerProfileDao.findAllManagerProfiles();
	}
	
	@Override
	@Transactional
	public void save(ManagerProfile managerProfile) {
		 
		managerProfileDao.save(managerProfile);
		
	}

	@Override
	@Transactional
	public void delete(ManagerProfile managerProfile) {
		 
		managerProfileDao.delete(managerProfile);
		
	}


}
