package com.abcrentals.binu.thankachan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abcrentals.binu.thankachan.dao.StateOrProvinceDao;
import com.abcrentals.binu.thankachan.entity.StateOrProvince;

@Service
public class StateOrProvinceServiceImpl implements StateOrProvinceService {


	// need to inject StateOrProvince dao
	@Autowired
	private StateOrProvinceDao stateOrProvinceDao;


	@Override
	@Transactional
	public int findStateOrProvinceIndex(String stateOrProvince) {
		 
		return stateOrProvinceDao.findStateOrProvinceIndex(stateOrProvince);
		
	}

	@Override
	@Transactional
	public StateOrProvince findById(int id) {
		 
		return stateOrProvinceDao.findById(id);
		
	}
	
	@Override
	@Transactional
	public List<StateOrProvince> findByCountry(String theCountry){
		
		return stateOrProvinceDao.findByCountry(theCountry);
		 
	}

	@Override
	@Transactional
	public void save(StateOrProvince theStateOrProvince){
		
		// save theStateOrProvince in the database
		stateOrProvinceDao.save(theStateOrProvince);
		
	}

	@Override
	@Transactional
	public void delete(StateOrProvince theStateOrProvince) {
		
		// delete theStateOrProvince in the database
		stateOrProvinceDao.delete(theStateOrProvince);
		
	}



}
