package com.abcrentals.binu.thankachan.service;

import com.abcrentals.binu.thankachan.dao.RoleDao;
import com.abcrentals.binu.thankachan.dao.UserDao;
import com.abcrentals.binu.thankachan.entity.Role;
import com.abcrentals.binu.thankachan.entity.User;
import com.abcrentals.binu.thankachan.user.CrmUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	// need to inject user dao
	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public User findByUserName(String userName) {
		 
		return userDao.findByUserName(userName);
	}
	
	
	@Override
	@Transactional
	public User findByUserId(Long id) {
		
		return userDao.findByUserId(id);
	}
	

	@Override
	@Transactional
	public List<User> findAllUsers() {
		 
		return userDao.findAllUsers();
	}
	

	@Override
	@Transactional
	public void save(CrmUser crmUser) {
		User user = new User();
		 // assign user details to the user object
		user.setUserName(crmUser.getUserName());
		user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
		
		if(user.getNamePrefix() == null) {
			user.setNamePrefix("");
		} else {
			user.setNamePrefix(crmUser.getNamePrefix());
		}
		
		user.setFirstName(crmUser.getFirstName());
		user.setLastName(crmUser.getLastName());
		
		if(user.getNameSuffix() == null) {
			user.setNameSuffix("");
		} else {
			user.setNameSuffix(crmUser.getNameSuffix());
		}

		user.setEmail(crmUser.getEmail());

		// give user default role of "renter"
		user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_RENTER")));
		// give user a default access level of 1 (Basic)
		user.setAccessLevel(1);
		
		user.setCreationDate(LocalDate.now());
		
		user.setFirstAndLastName(crmUser.getFirstName() + " " + crmUser.getLastName());
		String fullname = crmUser.getNamePrefix() + " " + crmUser.getFirstName() + " " + crmUser.getLastName() + crmUser.getNameSuffix();
 		user.setFullName(fullname.trim());

		 // save user in the database
		userDao.save(user);
	}
	


	@Override
	@Transactional
	public void saveUser(User theUserToSave) {
		 
		userDao.saveUser(theUserToSave);
		
	}
	
	@Override
	@Transactional
	public void delete(User user) {

		 // delete user in the database
		userDao.delete(user);
	}
	
	

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDao.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}








}
