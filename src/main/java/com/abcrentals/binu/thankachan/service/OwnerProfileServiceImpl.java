package com.abcrentals.binu.thankachan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcrentals.binu.thankachan.dao.OwnerProfileDao;
import com.abcrentals.binu.thankachan.entity.OwnerProfile;

@Service
public class OwnerProfileServiceImpl implements OwnerProfileService{

	@Autowired 
	OwnerProfileDao ownerProfileDao;
	
	// method for Owner Profile find by id service 
	@Override
	@Transactional
	public OwnerProfile findById(long id) {
		 
		return ownerProfileDao.findById(id);
	}

	// method for Owner Profile find by user id service
	@Override
	@Transactional
	public OwnerProfile findByUserId(long userId) {
		
		return ownerProfileDao.findByUserId(userId);
	}

	// method for Owner Profile find all owner profiles service
	@Override
	@Transactional
	public List<OwnerProfile> findAllOwnerProfiles() {
		 
		return ownerProfileDao.findAllOwnerProfiles();
	}
	
	// method for Owner Profile save service
	@Override
	@Transactional
	public void save(OwnerProfile ownerProfile) {
		 
		ownerProfileDao.save(ownerProfile);
		
	}

	// method for Owner Profile delete service
	@Override
	@Transactional
	public void delete(OwnerProfile ownerProfile) {

		ownerProfileDao.delete(ownerProfile);
		
	}


}
