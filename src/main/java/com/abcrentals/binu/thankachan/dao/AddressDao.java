package com.abcrentals.binu.thankachan.dao;

import com.abcrentals.binu.thankachan.entity.Address;

/*
 * Interface used for DAO access method declaration for Address entity class
 * 
 * 
 * 
 */


public interface AddressDao {

    Address findByAddressId(int addressId);
    
    void save(Address address);
    
    void delete(Address address);
}
