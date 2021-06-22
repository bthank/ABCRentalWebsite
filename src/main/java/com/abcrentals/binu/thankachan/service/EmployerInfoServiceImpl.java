package com.abcrentals.binu.thankachan.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcrentals.binu.thankachan.dao.EmployerInfoDao;
import com.abcrentals.binu.thankachan.entity.EmployerInfo;

@Service
public class EmployerInfoServiceImpl implements EmployerInfoService{


	// need to inject address dao
	@Autowired
	private EmployerInfoDao employerInfoDao;

	@Override
	@Transactional
	public EmployerInfo findEmployerInfoById(int id) {
		
		// check the database if the contactInfo already exists
		return employerInfoDao.findEmployerInfoById(id);

	}

	@Override
	@Transactional
	public void save(EmployerInfo employerInfo) {
		
		employerInfoDao.save(employerInfo);	
		
	}

	@Override
	@Transactional
	public void delete(EmployerInfo employerInfo) {
		
		employerInfoDao.delete(employerInfo);
		
	}


	
}
