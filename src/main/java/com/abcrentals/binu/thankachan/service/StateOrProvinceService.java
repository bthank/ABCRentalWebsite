package com.abcrentals.binu.thankachan.service;

import java.util.List;

import com.abcrentals.binu.thankachan.entity.StateOrProvince;

/*
 * Interface used for DAO service method declaration for StateOrProvince entity class
 * 
 * 
 * 
 */


public interface StateOrProvinceService {

	int findStateOrProvinceIndex(String stateOrProvince);
	
	StateOrProvince findById(int id);
	
	List<StateOrProvince> findByCountry(String theCountry);

	void save(StateOrProvince theStateOrProvince);

	void delete(StateOrProvince theStateOrProvince);
	
}
