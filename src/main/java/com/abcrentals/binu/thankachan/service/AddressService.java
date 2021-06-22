package com.abcrentals.binu.thankachan.service;

import com.abcrentals.binu.thankachan.entity.Address;

/*
 * Interface used for DAO service method declaration for Address entity class
 * 
 * 
 * 
 */


public interface AddressService {

    Address findByAddressId(int addressId);
    
    void save(Address address);

    void delete(Address address);
}
