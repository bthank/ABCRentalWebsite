package com.abcrentals.binu.thankachan.service;

import java.util.List;

import com.abcrentals.binu.thankachan.entity.ContractorProfile;

/*
 * Interface used for DAO service method declaration for ContractorProfile entity class
 * 
 * 
 * 
 */


public interface ContractorProfileService {
	
	ContractorProfile findById(long id);
	
	ContractorProfile findByUserId(long userId);
	
	List<ContractorProfile> findAllContractorProfiles();
    
    void save(ContractorProfile contractorProfile);
    
    void delete(ContractorProfile contractorProfile);
}
