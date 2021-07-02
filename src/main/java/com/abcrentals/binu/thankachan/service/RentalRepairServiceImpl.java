package com.abcrentals.binu.thankachan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcrentals.binu.thankachan.dao.RentalRepairDao;
import com.abcrentals.binu.thankachan.entity.RentalRepair;

@Service
public class RentalRepairServiceImpl implements RentalRepairService{

	@Autowired
	private RentalRepairDao rentalRepairDao;
	
	
	// method for Rental Repair find by id service
	@Override
	@Transactional
	public RentalRepair findById(long id) {
		 
		return rentalRepairDao.findById(id);
	}

	// method for Rental Repair find by rental unit id and rental unit no service
	@Override
	@Transactional
	public RentalRepair findByRentalUnitIdAndRentalUnitNo(int rentalUnitId, int rentalUnitNo) {
		 
		return rentalRepairDao.findByRentalUnitIdAndRentalUnitNo(rentalUnitId, rentalUnitNo);
	}

	// method for Rental Repair find all rental repairs by repair status service
	@Override
	@Transactional
	public List<RentalRepair> findAllRentalRepairsByRepairStatus(int repairStatus) {
		 
		return rentalRepairDao.findAllRentalRepairsByRepairStatus(repairStatus);
	}

	// method for Rental Repair find all rental repairs service
	@Override
	@Transactional
	public List<RentalRepair> findAllRentalRepairs() {
		 
		return rentalRepairDao.findAllRentalRepairs();
	}
	
	// method for Rental Repair save service
	@Override
	@Transactional
	public void save(RentalRepair rentalRepair) {
		 
		rentalRepairDao.save(rentalRepair);
		
	}

	// method for Rental Repair delete service
	@Override
	@Transactional
	public void delete(RentalRepair rentalRepair) {
		 
		rentalRepairDao.delete(rentalRepair);
		
	}


}
