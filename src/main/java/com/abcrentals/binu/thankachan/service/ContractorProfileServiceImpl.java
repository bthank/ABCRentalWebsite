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
	
	
	@Override
	@Transactional
	public ContractorProfile findById(long id) {
		 
		return contractorProfileDao.findById(id);
	}

	@Override
	@Transactional
	public ContractorProfile findByUserId(long userId) {
		
		return contractorProfileDao.findByUserId(userId);
	}

	@Override
	@Transactional
	public List<ContractorProfile> findAllContractorProfiles() {
		 
		return contractorProfileDao.findAllContractorProfiles();
	}
	
	@Override
	@Transactional
	public void save(ContractorProfile contractorProfile) {
		 
		contractorProfileDao.save(contractorProfile);
		
	}

	@Override
	@Transactional
	public void delete(ContractorProfile contractorProfile) {
		 
		contractorProfileDao.delete(contractorProfile);
		
	}


}
