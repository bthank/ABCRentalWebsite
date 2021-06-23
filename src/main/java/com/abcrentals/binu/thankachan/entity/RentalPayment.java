package com.abcrentals.binu.thankachan.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * RentalPayment entity definition for Hibernate ORM mapping to database table
 * 
 * 
 * 
 */


@Entity
@Table(name="rental_payment")
public class RentalPayment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rental_payment_id")
	private Long id;
	
	@NotNull(message="Required field")
	@Column(name = "renter_user_id")
	private Long renterUserId;
	
	@NotNull(message="Required value")
	@Column(name="rental_property_id")
	private Long rentalPropertyId;
	
	@NotNull(message="Required value")
	@Column(name="rental_unit_no")
	private Integer rentalUnitNo;
	
	@NotNull(message="Required value")		
	@Column(name="rental_year")	
	private String rentalYear;
	
	@NotNull(message="Required value")
	@Column(name="rental_month")
	private String rentalMonth;

	@NotNull(message="Required value")
	@Column(name="payment_made")
	private Boolean paymentMade;
	
 	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name="date_of_payment")
	private LocalDate dateOfPayment;
	
	@NotNull(message="Required value")
	@Column(name="monthly_rent_amt")
	private Double monthsRentAmt;
	
	@Column(name="note")
	private String note;

	public RentalPayment() {
		super();
		 
	}
	
	

	public RentalPayment(Long renterUserId,
			Long rentalPropertyId,
			Integer rentalUnitNo,
			String rentalYear,
			String rentalMonth,
			Boolean paymentMade, LocalDate dateOfPayment,
			Double monthsRentAmt, String note) {
		super();
		this.id = id;
		this.renterUserId = renterUserId;
		this.rentalPropertyId = rentalPropertyId;
		this.rentalUnitNo = rentalUnitNo;
		this.rentalYear = rentalYear;
		this.rentalMonth = rentalMonth;
		this.paymentMade = paymentMade;
		this.dateOfPayment = dateOfPayment;
		this.monthsRentAmt = monthsRentAmt;
		this.note = note;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRenterUserId() {
		return renterUserId;
	}

	public void setRenterUserId(Long renterUserId) {
		this.renterUserId = renterUserId;
	}

	public Long getRentalPropertyId() {
		return rentalPropertyId;
	}

	public void setRentalPropertyId(Long rentalPropertyId) {
		this.rentalPropertyId = rentalPropertyId;
	}

	public Integer getRentalUnitNo() {
		return rentalUnitNo;
	}

	public void setRentalUnitNo(Integer rentalUnitNo) {
		this.rentalUnitNo = rentalUnitNo;
	}

	public String getRentalYear() {
		return rentalYear;
	}

	public void setRentalYear(String rentalYear) {
		this.rentalYear = rentalYear;
	}

	public String getRentalMonth() {
		return rentalMonth;
	}

	public void setRentalMonth(String rentalMonth) {
		this.rentalMonth = rentalMonth;
	}

	public Boolean getPaymentMade() {
		return paymentMade;
	}

	public void setPaymentMade(Boolean paymentMade) {
		this.paymentMade = paymentMade;
	}

	public LocalDate getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(LocalDate dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	public Double getMonthsRentAmt() {
		return monthsRentAmt;
	}

	public void setMonthsRentAmt(Double monthsRentAmt) {
		this.monthsRentAmt = monthsRentAmt;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "RentalPayment [id=" + id + ", renterUserId=" + renterUserId + ", rentalPropertyId=" + rentalPropertyId
				+ ", rentalUnitNo=" + rentalUnitNo + ", rentalYear=" + rentalYear + ", rentalMonth=" + rentalMonth
				+ ", paymentMade=" + paymentMade + ", dateOfPayment=" + dateOfPayment + ", monthsRentAmt="
				+ monthsRentAmt + ", note=" + note + "]";
	}
	
	
}
