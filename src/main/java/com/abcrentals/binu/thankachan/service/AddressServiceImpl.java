package com.abcrentals.binu.thankachan.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcrentals.binu.thankachan.dao.AddressDao;
import com.abcrentals.binu.thankachan.entity.Address;

@Service
public class AddressServiceImpl implements AddressService{

	// need to inject address dao
	@Autowired
	private AddressDao addressDao;

	// method for Address find by address id service
	@Override
	@Transactional
	public Address findByAddressId(int addressId) {
		
		return addressDao.findByAddressId(addressId);

	}

	// method for Address save service
	@Override
	@Transactional
	public void save(Address address) {
		
		addressDao.save(address);	
		
	}

	// method for Address delete service
	@Override
	@Transactional
	public void delete(Address address) {
		 
		addressDao.delete(address);
		
	}

}
