package com.abcrentals.binu.thankachan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcrentals.binu.thankachan.dao.RentalPaymentDao;
import com.abcrentals.binu.thankachan.entity.RentalPayment;

@Service
public class RentalPaymentServiceImpl implements RentalPaymentService{

	//@Autowired
	private RentalPaymentDao rentalPaymentDao;
	
	
	
	// constructor to allow injecting dao for mocking 
	@Autowired
	public RentalPaymentServiceImpl(RentalPaymentDao rentalPaymentDao) {
		this.rentalPaymentDao = rentalPaymentDao;
	}

	// method for Rental Payment find by id service 
	@Override
	@Transactional
	public RentalPayment findById(long id) {
		 
		return rentalPaymentDao.findById(id);
	}

	// method for Rental Payment find all rental payments by renter user id service
	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByRenterUserId(long renterUserId) {
		 
		return rentalPaymentDao.findAllRentalPaymentsByRenterUserId(renterUserId);
	}

	// method for Rental Payment find all rental payments by rental property id and rental unit no service
	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNo(long rentalPropertyId,
			int rentalUnitNo) {

		return rentalPaymentDao.findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNo(rentalPropertyId, rentalUnitNo);
	}

	// method for Rental Payment find all rental payments by rental property id and rental unit no and year and month service
	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonth(
			long rentalPropertyId, int rentalUnitNo, String year, String month) {

		return rentalPaymentDao.findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonth(rentalPropertyId, rentalUnitNo, year, month);
	}

	// method for Rental Payment find all rental payments by rental property id and rental unit no and year service
	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYear(long rentalPropertyId,
			int rentalUnitNo, String year) {

		return rentalPaymentDao.findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYear(rentalPropertyId, rentalUnitNo, year);
	}
	
	
	
	// method for Rental Payment find all rental payments by rental property id and rental unit no and year and month and renter user id service
	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonthAndRenterUserId(
			long rentalPropertyId, int rentalUnitNo, String year, String month, long renterUserId) {
		 
		return rentalPaymentDao.findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonthAndRenterUserId(rentalPropertyId, rentalUnitNo, year, month, renterUserId);
	}

	// method for Rental Payment find all rental payments by year and month and renter user id service
	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByYearAndMonthAndRenterUserId(String year, String month,
			long renterUserId) {
		 
		return rentalPaymentDao.findAllRentalPaymentsByYearAndMonthAndRenterUserId(year, month, renterUserId);
	}

	// method for Rental Payment find all rental payments by year and month service
	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByYearAndMonth(String year, String month) {
		 
		return rentalPaymentDao.findAllRentalPaymentsByYearAndMonth(year, month);
	}
	
	// method for Rental Payment find all rental payments by month and renter user id service
	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByMonthAndRenterUserId(String month, long renterUserId) {
		// TODO Auto-generated method stub
		return rentalPaymentDao.findAllRentalPaymentsByMonthAndRenterUserId(month, renterUserId);
	}
	
	// method for Rental Payment find all rental payments by year and rental unit no service
	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByYearAndRentalUnitNo(String year, int rentalUnitNo) {
		 
		return rentalPaymentDao.findAllRentalPaymentsByYearAndRentalUnitNo(year, rentalUnitNo);
	}

	// method for Rental Payment find all rental payments by year service
	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByYear(String year) {
		 
		return rentalPaymentDao.findAllRentalPaymentsByYear(year);
	}

	// method for Rental Payment find all rental payments by month service
	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByMonth(String month) {
		 
		return rentalPaymentDao.findAllRentalPaymentsByMonth(month);
	}
	
	// method for Rental Payment find all rental payments by rental unit no service
	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByRentalUnitNo(int rentalUnitNo) {
		 
		return rentalPaymentDao.findAllRentalPaymentsByRentalUnitNo(rentalUnitNo);
	}	
	
	
	
	
	// method for Rental Payment find all rental payments by rental property id service
	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPaymentsByRentalPropertyId(long rentalPropertyId) {
		 
		return rentalPaymentDao.findAllRentalPaymentsByRentalPropertyId(rentalPropertyId);
	}

	// method for Rental Payment find all rental payments service
	@Override
	@Transactional
	public List<RentalPayment> findAllRentalPayments() {
		 
		return rentalPaymentDao.findAllRentalPayments();
	}

	// method for Rental Payment save service
	@Override
	@Transactional
	public void save(RentalPayment rentalPayment) {
		 
		rentalPaymentDao.save(rentalPayment);
	}

	// method for Rental Payment update service
	@Override
	@Transactional
	public void update(RentalPayment rentalPayment) {
		rentalPaymentDao.update(rentalPayment);
		
	}

	// method for Rental Payment delete service
	@Override
	@Transactional
	public void delete(RentalPayment rentalPayment) {
		 
		rentalPaymentDao.delete(rentalPayment);
	}








	
	
}
