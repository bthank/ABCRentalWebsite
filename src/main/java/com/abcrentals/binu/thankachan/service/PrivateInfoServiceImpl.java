package com.abcrentals.binu.thankachan.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcrentals.binu.thankachan.dao.PrivateInfoDao;
import com.abcrentals.binu.thankachan.entity.PrivateInfo;

@Service
public class PrivateInfoServiceImpl implements PrivateInfoService{


	// need to inject address dao
	@Autowired
	private PrivateInfoDao privateInfoDao;
	
	@Override
	@Transactional
	public PrivateInfo findPrivateInfoById(int id) {
		
		// check the database if the PrivateInfo already exists
		return privateInfoDao.findPrivateInfoById(id);

	}

	@Override
	@Transactional
	public void save(PrivateInfo privateInfo) {
		
		privateInfoDao.save(privateInfo);	
			
	}

	@Override
	@Transactional
	public void delete(PrivateInfo privateInfo) {

		privateInfoDao.delete(privateInfo);
		
	}

	
	
	
	
	
}
