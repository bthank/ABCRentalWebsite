package com.abcrentals.binu.thankachan.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * PrivateInfo entity definition for Hibernate ORM mapping to database table
 * 
 * 
 * 
 */


@Entity
@Table(name="private_info")
public class PrivateInfo {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="private_info_id")
	private Integer id;
	
	@Column(name="gender")
	private Integer gender;    // 0=N/A, 1=Male, 2=Female, 3=Other
	
	@Column(name="ethnicity")
	private Integer ethnicity; // 0=N/A, 1=American Indian or Alaska Native, 2=Asian, 3=Black or African American, 4=Hispanic or Latino, 
							   //5=Native Hawaiian or Other Pacific Islander, 6=White

	/*
	 * 
	 * regular expression to check valid SSN (Social Security Number) is:
	 * 
			regex = "^(?!666|000|9\\d{2})\\d{3}-(?!00)\\d{2}-(?!0{4})\\d{4}$";
	 * 
	 * Where: 
		^ represents the starting of the string.
		(?!666|000|9\\d{2})\\d{3} represents the first 3 digits should not start with 000, 666, or between 900 and 999.
		– represents the string followed by a hyphen (-).
		(?!00)\\d{2} represents the next 2 digits should not start with 00 and it should be any from 01-99.
		– represents the string followed by a hyphen (-).
		(?!0{4})\\d{4} represents the next 4 digits can’t 0000 and it should be any from 0001-9999.
		$ represents the ending of the string.
	 * 
	 * 
	 */
	//@Pattern(regexp="^(?!666|000|9\\d{2})\\d{3}-(?!00)\\d{2}-(?!0{4})\\d{4}$",message="Must be a valid SSN in ###-##-#### format")
	//@NotNull(message="Required field")
	@Column(name="ssn")
	private String ssn;

	
 	@Column(name="credit_card_no")
	private String creditCardNo;
	
 	@Column(name="credit_card_no_exp_month")
	private Integer creditCardNoExpMonth;
	
	@Column(name="credit_card_no_exp_year")
	private Integer creditCardNoExpYear;
	
 	@Column(name="credit_card_no_ccv_code")
	private Integer creditCardNoCCVCode;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Address> creditCardBillingAddresses = new ArrayList<Address>();
	

 	@Column(name="date_of_birth")
	private LocalDate dob;
	
	@Column(name="credit_score")
	private Integer creditScore;
	
	public PrivateInfo() {
		super();
		 
	}

	public PrivateInfo(Integer gender, Integer ethnicity, String ssn, String creditCardNo, Integer creditCardNoExpMonth,
			Integer creditCardNoExpYear, Integer creditCardNoCCVCode, List<Address> creditCardBillingAddresses,
			LocalDate dob, Integer creditScore) {
		super();
		this.gender = gender;
		this.ethnicity = ethnicity;
		this.ssn = ssn;
		this.creditCardNo = creditCardNo;
		this.creditCardNoExpMonth = creditCardNoExpMonth;
		this.creditCardNoExpYear = creditCardNoExpYear;
		this.creditCardNoCCVCode = creditCardNoCCVCode;
		this.creditCardBillingAddresses = creditCardBillingAddresses;
		this.dob = dob;
		this.creditScore = creditScore;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(Integer ethnicity) {
		this.ethnicity = ethnicity;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getCreditCardNo() {
		return creditCardNo;
	}

	public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}

	public Integer getCreditCardNoExpMonth() {
		return creditCardNoExpMonth;
	}

	public void setCreditCardNoExpMonth(Integer creditCardNoExpMonth) {
		this.creditCardNoExpMonth = creditCardNoExpMonth;
	}

	public Integer getCreditCardNoExpYear() {
		return creditCardNoExpYear;
	}

	public void setCreditCardNoExpYear(Integer creditCardNoExpYear) {
		this.creditCardNoExpYear = creditCardNoExpYear;
	}

	public Integer getCreditCardNoCCVCode() {
		return creditCardNoCCVCode;
	}

	public void setCreditCardNoCCVCode(Integer creditCardNoCCVCode) {
		this.creditCardNoCCVCode = creditCardNoCCVCode;
	}

	public List<Address> getCreditCardBillingAddresses() {
		return creditCardBillingAddresses;
	}

	public void setCreditCardBillingAddresses(List<Address> creditCardBillingAddresses) {
		this.creditCardBillingAddresses = creditCardBillingAddresses;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	
	public Integer getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(Integer creditScore) {
		this.creditScore = creditScore;
	}

	@Override
	public String toString() {
		return "PrivateInfo [id=" + id + ", gender=" + gender + ", ethnicity=" + ethnicity + ", ssn=" + ssn
				+ ", creditCardNo=" + creditCardNo + ", creditCardNoExpMonth=" + creditCardNoExpMonth
				+ ", creditCardNoExpYear=" + creditCardNoExpYear + ", creditCardNoCCVCode=" + creditCardNoCCVCode
				+ ", creditCardBillingAddresses=" + creditCardBillingAddresses + ", dob=" + dob + ", creditScore="
				+ creditScore + "]";
	}






	
}
