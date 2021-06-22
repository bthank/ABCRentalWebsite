package com.abcrentals.binu.thankachan.dao;

import com.abcrentals.binu.thankachan.entity.Role;

/*
 * Interface used for DAO access method declaration for Role entity class
 * 
 * 
 * 
 */


public interface RoleDao {

	Role findRoleById(long id);

	Role findRoleByName(String theRoleName);
	   
    void save(Role role);
    
    void delete(Role role);
	
}
