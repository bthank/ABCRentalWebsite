package com.abcrentals.binu.thankachan.dao;

import java.util.List;

import com.abcrentals.binu.thankachan.entity.StateOrProvince;

/*
 * Interface used for DAO access method declaration for StateOrProvince entity class
 * 
 * 
 * 
 */


public interface StateOrProvinceDao {

	int findStateOrProvinceIndex(String stateOrProvince);
	
	StateOrProvince findById(int id);
	
	List<StateOrProvince> findByCountry(String theCountry);

	void save(StateOrProvince theStateOrProvince);

	void delete(StateOrProvince theStateOrProvince);

}
