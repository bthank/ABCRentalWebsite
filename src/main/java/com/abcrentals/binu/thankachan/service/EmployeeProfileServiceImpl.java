package com.abcrentals.binu.thankachan.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcrentals.binu.thankachan.dao.EmployeeProfileDao;
import com.abcrentals.binu.thankachan.entity.EmployeeProfile;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

	@Autowired 
	EmployeeProfileDao employeeProfileDao;
	
	
	// method for Employee Profile find by id service
	@Override
	@Transactional
	public EmployeeProfile findById(long id) {
		 
		return employeeProfileDao.findById(id);
	}

	// method for Employee Profile find by user id service
	@Override
	@Transactional
	public EmployeeProfile findByUserId(long userId) {
		System.out.println("c1a:  In EmployeeProfileServiceImpl  method findByUserId()   userId= " + userId);
		return employeeProfileDao.findByUserId(userId);
	}

	// method for Employee Profile save service
	@Override
	@Transactional
	public void save(EmployeeProfile employeeProfile) {
		 
		employeeProfileDao.save(employeeProfile);
	}

	// method for Employee Profile delete service
	@Override
	@Transactional
	public void delete(EmployeeProfile employeeProfile) {
		 
		employeeProfileDao.delete(employeeProfile);
	}
}
