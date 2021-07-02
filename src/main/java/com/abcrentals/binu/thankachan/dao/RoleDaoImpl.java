package com.abcrentals.binu.thankachan.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abcrentals.binu.thankachan.entity.Role;

/*
 * Class used for DAO access method definition for Role entity class
 * 
 * 
 * 
 */


@Repository
public class RoleDaoImpl implements RoleDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	// dao method for role find by role id service
	@Override
	public Role findRoleById(long id) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using id
		Query<Role> theQuery = currentSession.createQuery("from Role where id=:roleId", Role.class);
		theQuery.setParameter("roleId", id);
		
		Role theRole = null;
		
		try {
			theRole = (Role)theQuery.getSingleResult();
		} catch (Exception e) {
			theRole = null;
		}
		
		return theRole;
	}

	// dao method for role find by role name service
	@Override
	public Role findRoleByName(String theRoleName) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using role name
		Query<Role> theQuery = currentSession.createQuery("from Role where name=:roleName", Role.class);
		theQuery.setParameter("roleName", theRoleName);
		
		Role theRole = null;
		
		try {
			theRole = (Role)theQuery.getSingleResult();
		} catch (Exception e) {
			theRole = null;
		}
		
		return theRole;
	}

	// dao method for role save service
	@Override
	public void save(Role role) {
   	
		// get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the role
		currentSession.saveOrUpdate(role);
	}

	// dao method for role delete service
	@Override
	public void delete(Role role) {
	   	
			// get current Hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// delete the role
			currentSession.delete(role);
	}

}
