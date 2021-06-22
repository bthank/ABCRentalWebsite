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
	
	
	
	
	@Override
	@Transactional
	public Role findRoleById(long id) {
		 
		return roleDao.findRoleById(id);
		
	}

	@Override
	@Transactional
	public Role findRoleByName(String theRoleName) {
		 
		return roleDao.findRoleByName(theRoleName);
		
	}

	@Override
	@Transactional
	public void save(Role role) {

		roleDao.save(role);
		
	}

	@Override
	@Transactional
	public void delete(Role role) {

		roleDao.delete(role);
		
	}

	
	
	
	
}
