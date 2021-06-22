package com.abcrentals.binu.thankachan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcrentals.binu.thankachan.dao.RentalPaymentDao;
import com.abcrentals.binu.thankachan.entity.RentalPayment;

@Service
public class RentalPaymentServiceImpl implements RentalPaymentService{

	@Autowired
	private RentalPaymentDao rentalPaymentDao;
	
	
	@Override
	@Transactional
	public RentalPayment findById(long id) {
		 
		return rentalPaymentDao.findById(id);
	}

	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByRenterUserId(long renterUserId) {
		 
		return rentalPaymentDao.findAllRentalPaymentsByRenterUserId(renterUserId);
	}

	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNo(long rentalPropertyId,
			int rentalUnitNo) {

		return rentalPaymentDao.findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNo(rentalPropertyId, rentalUnitNo);
	}

	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonth(
			long rentalPropertyId, int rentalUnitNo, String year, String month) {

		return rentalPaymentDao.findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonth(rentalPropertyId, rentalUnitNo, year, month);
	}

	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYear(long rentalPropertyId,
			int rentalUnitNo, String year) {

		return rentalPaymentDao.findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYear(rentalPropertyId, rentalUnitNo, year);
	}
	
	
	
	
	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonthAndRenterUserId(
			long rentalPropertyId, int rentalUnitNo, String year, String month, long renterUserId) {
		 
		return rentalPaymentDao.findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonthAndRenterUserId(rentalPropertyId, rentalUnitNo, year, month, renterUserId);
	}

	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByYearAndMonthAndRenterUserId(String year, String month,
			long renterUserId) {
		 
		return rentalPaymentDao.findAllRentalPaymentsByYearAndMonthAndRenterUserId(year, month, renterUserId);
	}

	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByYearAndMonth(String year, String month) {
		 
		return rentalPaymentDao.findAllRentalPaymentsByYearAndMonth(year, month);
	}
	

	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByMonthAndRenterUserId(String month, long renterUserId) {
		// TODO Auto-generated method stub
		return rentalPaymentDao.findAllRentalPaymentsByMonthAndRenterUserId(month, renterUserId);
	}

	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByYear(String year) {
		 
		return rentalPaymentDao.findAllRentalPaymentsByYear(year);
	}

	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByMonth(String month) {
		 
		return rentalPaymentDao.findAllRentalPaymentsByMonth(month);
	}
	

	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByRentalUnitNo(int rentalUnitNo) {
		 
		return rentalPaymentDao.findAllRentalPaymentsByRentalUnitNo(rentalUnitNo);
	}	
	
	
	
	

	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByRentalPropertyId(long rentalPropertyId) {
		 
		return rentalPaymentDao.findAllRentalPaymentsByRentalPropertyId(rentalPropertyId);
	}

	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPayments() {
		 
		return rentalPaymentDao.findAllRentalPayments();
	}

	@Override
	@Transactional
	public void save(RentalPayment rentalPayment) {
		 
		rentalPaymentDao.save(rentalPayment);
	}

	@Override
	@Transactional
	public void delete(RentalPayment rentalPayment) {
		 
		rentalPaymentDao.delete(rentalPayment);
	}





	
	
}
