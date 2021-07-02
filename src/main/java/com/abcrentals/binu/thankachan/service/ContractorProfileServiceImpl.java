package com.abcrentals.binu.thankachan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcrentals.binu.thankachan.dao.ContractorProfileDao;
import com.abcrentals.binu.thankachan.entity.ContractorProfile;

@Service
public class ContractorProfileServiceImpl implements ContractorProfileService{

	@Autowired 
	ContractorProfileDao contractorProfileDao;
	
	
	// method for Contractor Profile find by id service 
	@Override
	@Transactional
	public ContractorProfile findById(long id) {
		 
		return contractorProfileDao.findById(id);
	}

	// method for Contractor Profile find by user id service
	@Override
	@Transactional
	public ContractorProfile findByUserId(long userId) {
		
		return contractorProfileDao.findByUserId(userId);
	}

	// method for Contractor Profile find all contractor pofiles service
	@Override
	@Transactional
	public List<ContractorProfile> findAllContractorProfiles() {
		 
		return contractorProfileDao.findAllContractorProfiles();
	}
	
	// method for Contractor Profile save service
	@Override
	@Transactional
	public void save(ContractorProfile contractorProfile) {
		 
		contractorProfileDao.save(contractorProfile);
		
	}

	// method for Contractor Profile delete service
	@Override
	@Transactional
	public void delete(ContractorProfile contractorProfile) {
		 
		contractorProfileDao.delete(contractorProfile);
		
	}


}
