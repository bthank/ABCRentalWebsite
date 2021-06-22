package com.abcrentals.binu.thankachan.service;

import java.util.List;

import com.abcrentals.binu.thankachan.entity.RentalRepair;

/*
 * Interface used for DAO service method declaration for RentalRepair entity class
 * 
 * 
 * 
 */


public interface RentalRepairService {
	
	RentalRepair findById(long id);
	
	RentalRepair findByRentalUnitIdAndRentalUnitNo(int rentalUnitId, int rentalUnitNo);
	
	List<RentalRepair> findAllRentalRepairsByRepairStatus(int repairStatus);

	List<RentalRepair> findAllRentalRepairs();
    
    void save(RentalRepair rentalRepair);
    
    void delete(RentalRepair rentalRepair);
}
