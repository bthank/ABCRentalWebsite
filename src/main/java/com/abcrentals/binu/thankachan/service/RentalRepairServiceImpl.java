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
	
	
	@Override
	@Transactional
	public RentalRepair findById(long id) {
		 
		return rentalRepairDao.findById(id);
	}

	@Override
	@Transactional
	public RentalRepair findByRentalUnitIdAndRentalUnitNo(int rentalUnitId, int rentalUnitNo) {
		 
		return rentalRepairDao.findByRentalUnitIdAndRentalUnitNo(rentalUnitId, rentalUnitNo);
	}

	@Override
	@Transactional
	public List<RentalRepair> findAllRentalRepairsByRepairStatus(int repairStatus) {
		 
		return rentalRepairDao.findAllRentalRepairsByRepairStatus(repairStatus);
	}

	@Override
	@Transactional
	public List<RentalRepair> findAllRentalRepairs() {
		 
		return rentalRepairDao.findAllRentalRepairs();
	}
	
	@Override
	@Transactional
	public void save(RentalRepair rentalRepair) {
		 
		rentalRepairDao.save(rentalRepair);
		
	}

	@Override
	@Transactional
	public void delete(RentalRepair rentalRepair) {
		 
		rentalRepairDao.delete(rentalRepair);
		
	}


}
