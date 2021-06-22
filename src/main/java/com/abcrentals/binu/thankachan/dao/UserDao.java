package com.abcrentals.binu.thankachan.dao;

import java.util.List;

import com.abcrentals.binu.thankachan.entity.User;

/*
 * Interface used for DAO access method declaration for User entity class
 * 
 * 
 * 
 */


public interface UserDao {

    User findByUserId(Long id);
    
    User findByUserName(String userName);
    
    List<User> findAllUsers();
    
    void save(User user);
    
    void saveUser(User user);
    
    void delete(User user);    
}
