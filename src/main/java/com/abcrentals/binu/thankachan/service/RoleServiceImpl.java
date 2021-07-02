package com.abcrentals.binu.thankachan.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcrentals.binu.thankachan.dao.RoleDao;
import com.abcrentals.binu.thankachan.entity.Role;

@Service
public class RoleServiceImpl implements RoleService{

	

	@Autowired 
	RoleDao roleDao;
	
	
	
	// method for Role find by id service
	@Override
	@Transactional
	public Role findRoleById(long id) {
		 
		return roleDao.findRoleById(id);
		
	}

	// method for Role find by role name service
	@Override
	@Transactional
	public Role findRoleByName(String theRoleName) {
		 
		return roleDao.findRoleByName(theRoleName);
		
	}

	// method for Role save service
	@Override
	@Transactional
	public void save(Role role) {

		roleDao.save(role);
		
	}

	// method for Role delete service
	@Override
	@Transactional
	public void delete(Role role) {

		roleDao.delete(role);
		
	}

	
	
	
	
}
