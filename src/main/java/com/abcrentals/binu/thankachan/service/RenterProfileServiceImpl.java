package com.abcrentals.binu.thankachan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcrentals.binu.thankachan.dao.RenterProfileDao;
import com.abcrentals.binu.thankachan.entity.RenterProfile;

@Service
public class RenterProfileServiceImpl implements RenterProfileService {

	@Autowired 
	RenterProfileDao renterProfileDao;
	
	
	@Override
	@Transactional
	public RenterProfile findById(long id) {
		 
		return renterProfileDao.findById(id);
	}

	@Override
	@Transactional
	public RenterProfile findByUserId(long userId) {
		 
		return renterProfileDao.findByUserId(userId);
	}

	@Override
	@Transactional
	public List<RenterProfile> findAllRenterProfiles() {
		 
		return renterProfileDao.findAllRenterProfiles();
	}

	@Override
	@Transactional
	public void save(RenterProfile renterProfile) {
		 
		renterProfileDao.save(renterProfile);
	}

	@Override
	@Transactional
	public void delete(RenterProfile renterProfile) {

		renterProfileDao.delete(renterProfile);
	}

}
