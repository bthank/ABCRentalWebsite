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
	
	
	@Override
	@Transactional
	public EmployeeProfile findById(long id) {
		 
		return employeeProfileDao.findById(id);
	}

	@Override
	@Transactional
	public EmployeeProfile findByUserId(long userId) {
		System.out.println("c1a:  In EmployeeProfileServiceImpl  method findByUserId()   userId= " + userId);
		return employeeProfileDao.findByUserId(userId);
	}

	@Override
	@Transactional
	public void save(EmployeeProfile employeeProfile) {
		 
		employeeProfileDao.save(employeeProfile);
	}

	@Override
	@Transactional
	public void delete(EmployeeProfile employeeProfile) {
		 
		employeeProfileDao.delete(employeeProfile);
	}
}
