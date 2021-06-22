package com.abcrentals.binu.thankachan.user;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import com.abcrentals.binu.thankachan.validation.EmailConstraint2;

/*
 * RenterUser class for form backing when entering RenterUser data
 * 
 * 
 * 
 */


@Entity
@Table(name="renter_user_profile")
public class RenterUserProfile {

	
	/*  CONTACTINFO FIELDS */
	
	private Integer contactInfoId;
	
	@NotBlank
	private String contactInfoFirstName;
	
	@NotBlank
	private String contactInfoLastName;
	
	@EmailConstraint2
	@NotBlank(message="Required field")
	private String contactInfoPrimaryEmail;
	
	@EmailConstraint2
	private String contactInfoSecondaryEmail;
	
	@Min(1_000_000_000) @Max(9_999_999_999L)
	@NotNull(message="Required field")
	private Long contactInfoHomePhoneNo;
	
	@Min(1_000_000_000) @Max(9_999_999_999L)
	@NotNull(message="Required field")
	private Long contactInfoCellPhoneNo;
	
	@Min(1_000_000_000) @Max(9_999_999_999L)
	@NotNull(message="Required field")
	private Long contactInfoWorkPhoneNo;
	
	/*  CONTACTINFO HOME ADDRESS FIELDS */
	
	private Integer contactInfoHomeAddressId;
 	private Integer contactInfoHomeAddressType; // 1=Home, 2=Work, 3=Rental Property
 	@NotBlank(message="Required field")
 	private String 	contactInfoHomeAddrLine1;
 	private String 	contactInfoHomeAddrLine2;
 	private String 	contactInfoHomeAddrLine3;
 	private String 	contactInfoHomeAddrLine4;
 	@NotBlank(message="Required field")
 	private String 	contactInfoHomeCity;

 	@Min(value=1,message="Must select a value")
 	private Integer 	contactInfoHomeState;
 	@NotBlank(message="Required field")
 	private String 	contactInfoHomePostalCode;
 
 	@Min(value=1,message="Must select a value")
 	private Integer contactInfoHomeCountry;   
	
 	
	/*  EMPLOYERINFO FIELDS */
 	
 	private Integer employerInfoId;
	 
 	private Integer employerInfoEmployerAddressId;
 	@NotBlank(message="Required field")
	private String 	employerInfoEmployerName;
 	@NotNull(message="Required field")
	private Long 	employerInfoEmployerPhoneNo;
 	
	/*  EMPLOYERINFO EMPLOYER ADDRESS FIELDS */
	 
 	private Integer employerInfoEmployerAddressType; // 1=Home, 2=Work, 3=Rental Property
 	@NotBlank(message="Required field")
 	private String 	employerInfoEmployerAddrLine1;
 	private String 	employerInfoEmployerAddrLine2;
 	private String 	employerInfoEmployerAddrLine3;
 	private String 	employerInfoEmployerAddrLine4;
 	@NotBlank(message="Required field")
 	private String 	employerInfoEmployerCity;
 	@Min(value=1,message="Must select a value")
 	private Integer 	employerInfoEmployerState;
 	@NotBlank(message="Required field")
 	private String 	employerInfoEmployerPostalCode;
 	@Min(value=1,message="Must select a value")
 	private Integer employerInfoEmployerCountry;   

	
	/*  PRIVATEINFO FIELDS */
 	
 	private Integer privateInfoId;
 	
	private Integer privateInfoGender; 
	
	private Integer privateInfoEthnicity;

	//@Pattern(regexp="^(?!666|000|9\\d{2})\\d{3}-(?!00)\\d{2}-(?!0{4})\\d{4}$",message="Must be a valid SSN in ###-##-#### format")
	@NotNull(message="Required field")
	private Long privateInfoSsn;

	
	@NotNull(message="Required field")
//	@Pattern(regexp="[0-9]{16}",message="Must be a 16 digit number")
	private Long privateInfoCreditCardNo;
	
	@NotNull(message="Required field")
	@Min(value=1,message="Must select a value")
	private Integer privateInfoCreditCardNoExpMonth;
	
	@NotNull(message="Required field")
	@Min(value=1,message="Must select a value")
	private Integer privateInfoCreditCardNoExpYear;
	
	@NotNull(message="Required field")
	private Integer privateInfoCreditCardNoCCVCode;
	
	/*  PRIVATEINFO CC BILLING ADDRESS FIELDS */
	 
	private Integer privateInfoCCBillingAddressId;
 	private Integer privateInfoCCBillingAddressType; // 1=Home, 2=Work, 3=Rental Property, 4=Billing Address
 	@NotBlank(message="Required field")
 	private String 	privateInfoCCBillingAddrLine1;
 	private String 	privateInfoCCBillingAddrLine2;
 	private String 	privateInfoCCBillingAddrLine3;
 	private String 	privateInfoCCBillingAddrLine4;
 	@NotBlank(message="Required field")
 	private String 	privateInfoCCBillingCity;
 	@Min(value=1,message="Must select a value")
 	private Integer 	privateInfoCCBillingState;
 	@NotBlank(message="Required field")
 	private String 	privateInfoCCBillingPostalCode;
 	@Min(value=1,message="Must select a value")
 	private Integer privateInfoCCBillingCountry;   

 	
 	
 	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	//@DateTimeFormat(pattern="MM/dd/yyyy")
	@NotNull(message="Required field") 
	@Past
	//@DateOfBirthConstraint
	private LocalDate privateInfoDob;
	
	private Integer privateInfoCreditScore;


	public RenterUserProfile() {
		
	}


	public Integer getContactInfoId() {
		return contactInfoId;
	}


	public void setContactInfoId(Integer contactInfoId) {
		this.contactInfoId = contactInfoId;
	}


	public String getContactInfoFirstName() {
		return contactInfoFirstName;
	}


	public void setContactInfoFirstName(String contactInfoFirstName) {
		this.contactInfoFirstName = contactInfoFirstName;
	}


	public String getContactInfoLastName() {
		return contactInfoLastName;
	}


	public void setContactInfoLastName(String contactInfoLastName) {
		this.contactInfoLastName = contactInfoLastName;
	}


	public String getContactInfoPrimaryEmail() {
		return contactInfoPrimaryEmail;
	}


	public void setContactInfoPrimaryEmail(String contactInfoPrimaryEmail) {
		this.contactInfoPrimaryEmail = contactInfoPrimaryEmail;
	}


	public String getContactInfoSecondaryEmail() {
		return contactInfoSecondaryEmail;
	}


	public void setContactInfoSecondaryEmail(String contactInfoSecondaryEmail) {
		this.contactInfoSecondaryEmail = contactInfoSecondaryEmail;
	}


	public Long getContactInfoHomePhoneNo() {
		return contactInfoHomePhoneNo;
	}


	public void setContactInfoHomePhoneNo(Long contactInfoHomePhoneNo) {
		this.contactInfoHomePhoneNo = contactInfoHomePhoneNo;
	}


	public Long getContactInfoCellPhoneNo() {
		return contactInfoCellPhoneNo;
	}


	public void setContactInfoCellPhoneNo(Long contactInfoCellPhoneNo) {
		this.contactInfoCellPhoneNo = contactInfoCellPhoneNo;
	}


	public Long getContactInfoWorkPhoneNo() {
		return contactInfoWorkPhoneNo;
	}


	public void setContactInfoWorkPhoneNo(Long contactInfoWorkPhoneNo) {
		this.contactInfoWorkPhoneNo = contactInfoWorkPhoneNo;
	}


	public Integer getContactInfoHomeAddressId() {
		return contactInfoHomeAddressId;
	}


	public void setContactInfoHomeAddressId(Integer contactInfoHomeAddressId) {
		this.contactInfoHomeAddressId = contactInfoHomeAddressId;
	}


	public Integer getContactInfoHomeAddressType() {
		return contactInfoHomeAddressType;
	}


	public void setContactInfoHomeAddressType(Integer contactInfoHomeAddressType) {
		this.contactInfoHomeAddressType = contactInfoHomeAddressType;
	}


	public String getContactInfoHomeAddrLine1() {
		return contactInfoHomeAddrLine1;
	}


	public void setContactInfoHomeAddrLine1(String contactInfoHomeAddrLine1) {
		this.contactInfoHomeAddrLine1 = contactInfoHomeAddrLine1;
	}


	public String getContactInfoHomeAddrLine2() {
		return contactInfoHomeAddrLine2;
	}


	public void setContactInfoHomeAddrLine2(String contactInfoHomeAddrLine2) {
		this.contactInfoHomeAddrLine2 = contactInfoHomeAddrLine2;
	}


	public String getContactInfoHomeAddrLine3() {
		return contactInfoHomeAddrLine3;
	}


	public void setContactInfoHomeAddrLine3(String contactInfoHomeAddrLine3) {
		this.contactInfoHomeAddrLine3 = contactInfoHomeAddrLine3;
	}


	public String getContactInfoHomeAddrLine4() {
		return contactInfoHomeAddrLine4;
	}


	public void setContactInfoHomeAddrLine4(String contactInfoHomeAddrLine4) {
		this.contactInfoHomeAddrLine4 = contactInfoHomeAddrLine4;
	}


	public String getContactInfoHomeCity() {
		return contactInfoHomeCity;
	}


	public void setContactInfoHomeCity(String contactInfoHomeCity) {
		this.contactInfoHomeCity = contactInfoHomeCity;
	}


	public Integer getContactInfoHomeState() {
		return contactInfoHomeState;
	}


	public void setContactInfoHomeState(Integer contactInfoHomeState) {
		this.contactInfoHomeState = contactInfoHomeState;
	}


	public String getContactInfoHomePostalCode() {
		return contactInfoHomePostalCode;
	}


	public void setContactInfoHomePostalCode(String contactInfoHomePostalCode) {
		this.contactInfoHomePostalCode = contactInfoHomePostalCode;
	}


	public Integer getContactInfoHomeCountry() {
		return contactInfoHomeCountry;
	}


	public void setContactInfoHomeCountry(Integer contactInfoHomeCountry) {
		this.contactInfoHomeCountry = contactInfoHomeCountry;
	}


	public Integer getEmployerInfoId() {
		return employerInfoId;
	}


	public void setEmployerInfoId(Integer employerInfoId) {
		this.employerInfoId = employerInfoId;
	}


	public Integer getEmployerInfoEmployerAddressId() {
		return employerInfoEmployerAddressId;
	}


	public void setEmployerInfoEmployerAddressId(Integer employerInfoEmployerAddressId) {
		this.employerInfoEmployerAddressId = employerInfoEmployerAddressId;
	}


	public String getEmployerInfoEmployerName() {
		return employerInfoEmployerName;
	}


	public void setEmployerInfoEmployerName(String employerInfoEmployerName) {
		this.employerInfoEmployerName = employerInfoEmployerName;
	}


	public Long getEmployerInfoEmployerPhoneNo() {
		return employerInfoEmployerPhoneNo;
	}


	public void setEmployerInfoEmployerPhoneNo(Long employerInfoEmployerPhoneNo) {
		this.employerInfoEmployerPhoneNo = employerInfoEmployerPhoneNo;
	}


	public Integer getEmployerInfoEmployerAddressType() {
		return employerInfoEmployerAddressType;
	}


	public void setEmployerInfoEmployerAddressType(Integer employerInfoEmployerAddressType) {
		this.employerInfoEmployerAddressType = employerInfoEmployerAddressType;
	}


	public String getEmployerInfoEmployerAddrLine1() {
		return employerInfoEmployerAddrLine1;
	}


	public void setEmployerInfoEmployerAddrLine1(String employerInfoEmployerAddrLine1) {
		this.employerInfoEmployerAddrLine1 = employerInfoEmployerAddrLine1;
	}


	public String getEmployerInfoEmployerAddrLine2() {
		return employerInfoEmployerAddrLine2;
	}


	public void setEmployerInfoEmployerAddrLine2(String employerInfoEmployerAddrLine2) {
		this.employerInfoEmployerAddrLine2 = employerInfoEmployerAddrLine2;
	}


	public String getEmployerInfoEmployerAddrLine3() {
		return employerInfoEmployerAddrLine3;
	}


	public void setEmployerInfoEmployerAddrLine3(String employerInfoEmployerAddrLine3) {
		this.employerInfoEmployerAddrLine3 = employerInfoEmployerAddrLine3;
	}


	public String getEmployerInfoEmployerAddrLine4() {
		return employerInfoEmployerAddrLine4;
	}


	public void setEmployerInfoEmployerAddrLine4(String employerInfoEmployerAddrLine4) {
		this.employerInfoEmployerAddrLine4 = employerInfoEmployerAddrLine4;
	}


	public String getEmployerInfoEmployerCity() {
		return employerInfoEmployerCity;
	}


	public void setEmployerInfoEmployerCity(String employerInfoEmployerCity) {
		this.employerInfoEmployerCity = employerInfoEmployerCity;
	}


	public Integer getEmployerInfoEmployerState() {
		return employerInfoEmployerState;
	}


	public void setEmployerInfoEmployerState(Integer employerInfoEmployerState) {
		this.employerInfoEmployerState = employerInfoEmployerState;
	}


	public String getEmployerInfoEmployerPostalCode() {
		return employerInfoEmployerPostalCode;
	}


	public void setEmployerInfoEmployerPostalCode(String employerInfoEmployerPostalCode) {
		this.employerInfoEmployerPostalCode = employerInfoEmployerPostalCode;
	}


	public Integer getEmployerInfoEmployerCountry() {
		return employerInfoEmployerCountry;
	}


	public void setEmployerInfoEmployerCountry(Integer employerInfoEmployerCountry) {
		this.employerInfoEmployerCountry = employerInfoEmployerCountry;
	}


	public Integer getPrivateInfoId() {
		return privateInfoId;
	}


	public void setPrivateInfoId(Integer privateInfoId) {
		this.privateInfoId = privateInfoId;
	}


	public Integer getPrivateInfoGender() {
		return privateInfoGender;
	}


	public void setPrivateInfoGender(Integer privateInfoGender) {
		this.privateInfoGender = privateInfoGender;
	}


	public Integer getPrivateInfoEthnicity() {
		return privateInfoEthnicity;
	}


	public void setPrivateInfoEthnicity(Integer privateInfoEthnicity) {
		this.privateInfoEthnicity = privateInfoEthnicity;
	}


	public Long getPrivateInfoSsn() {
		return privateInfoSsn;
	}


	public void setPrivateInfoSsn(Long privateInfoSsn) {
		this.privateInfoSsn = privateInfoSsn;
	}


	public Long getPrivateInfoCreditCardNo() {
		return privateInfoCreditCardNo;
	}


	public void setPrivateInfoCreditCardNo(Long privateInfoCreditCardNo) {
		this.privateInfoCreditCardNo = privateInfoCreditCardNo;
	}


	public Integer getPrivateInfoCreditCardNoExpMonth() {
		return privateInfoCreditCardNoExpMonth;
	}


	public void setPrivateInfoCreditCardNoExpMonth(Integer privateInfoCreditCardNoExpMonth) {
		this.privateInfoCreditCardNoExpMonth = privateInfoCreditCardNoExpMonth;
	}


	public Integer getPrivateInfoCreditCardNoExpYear() {
		return privateInfoCreditCardNoExpYear;
	}


	public void setPrivateInfoCreditCardNoExpYear(Integer privateInfoCreditCardNoExpYear) {
		this.privateInfoCreditCardNoExpYear = privateInfoCreditCardNoExpYear;
	}


	public Integer getPrivateInfoCreditCardNoCCVCode() {
		return privateInfoCreditCardNoCCVCode;
	}


	public void setPrivateInfoCreditCardNoCCVCode(Integer privateInfoCreditCardNoCCVCode) {
		this.privateInfoCreditCardNoCCVCode = privateInfoCreditCardNoCCVCode;
	}


	public Integer getPrivateInfoCCBillingAddressId() {
		return privateInfoCCBillingAddressId;
	}


	public void setPrivateInfoCCBillingAddressId(Integer privateInfoCCBillingAddressId) {
		this.privateInfoCCBillingAddressId = privateInfoCCBillingAddressId;
	}


	public Integer getPrivateInfoCCBillingAddressType() {
		return privateInfoCCBillingAddressType;
	}


	public void setPrivateInfoCCBillingAddressType(Integer privateInfoCCBillingAddressType) {
		this.privateInfoCCBillingAddressType = privateInfoCCBillingAddressType;
	}


	public String getPrivateInfoCCBillingAddrLine1() {
		return privateInfoCCBillingAddrLine1;
	}


	public void setPrivateInfoCCBillingAddrLine1(String privateInfoCCBillingAddrLine1) {
		this.privateInfoCCBillingAddrLine1 = privateInfoCCBillingAddrLine1;
	}


	public String getPrivateInfoCCBillingAddrLine2() {
		return privateInfoCCBillingAddrLine2;
	}


	public void setPrivateInfoCCBillingAddrLine2(String privateInfoCCBillingAddrLine2) {
		this.privateInfoCCBillingAddrLine2 = privateInfoCCBillingAddrLine2;
	}


	public String getPrivateInfoCCBillingAddrLine3() {
		return privateInfoCCBillingAddrLine3;
	}


	public void setPrivateInfoCCBillingAddrLine3(String privateInfoCCBillingAddrLine3) {
		this.privateInfoCCBillingAddrLine3 = privateInfoCCBillingAddrLine3;
	}


	public String getPrivateInfoCCBillingAddrLine4() {
		return privateInfoCCBillingAddrLine4;
	}


	public void setPrivateInfoCCBillingAddrLine4(String privateInfoCCBillingAddrLine4) {
		this.privateInfoCCBillingAddrLine4 = privateInfoCCBillingAddrLine4;
	}


	public String getPrivateInfoCCBillingCity() {
		return privateInfoCCBillingCity;
	}


	public void setPrivateInfoCCBillingCity(String privateInfoCCBillingCity) {
		this.privateInfoCCBillingCity = privateInfoCCBillingCity;
	}


	public Integer getPrivateInfoCCBillingState() {
		return privateInfoCCBillingState;
	}


	public void setPrivateInfoCCBillingState(Integer privateInfoCCBillingState) {
		this.privateInfoCCBillingState = privateInfoCCBillingState;
	}


	public String getPrivateInfoCCBillingPostalCode() {
		return privateInfoCCBillingPostalCode;
	}


	public void setPrivateInfoCCBillingPostalCode(String privateInfoCCBillingPostalCode) {
		this.privateInfoCCBillingPostalCode = privateInfoCCBillingPostalCode;
	}


	public Integer getPrivateInfoCCBillingCountry() {
		return privateInfoCCBillingCountry;
	}


	public void setPrivateInfoCCBillingCountry(Integer privateInfoCCBillingCountry) {
		this.privateInfoCCBillingCountry = privateInfoCCBillingCountry;
	}


	public LocalDate getPrivateInfoDob() {
		return privateInfoDob;
	}


	public void setPrivateInfoDob(LocalDate privateInfoDob) {
		this.privateInfoDob = privateInfoDob;
	}


	public Integer getPrivateInfoCreditScore() {
		return privateInfoCreditScore;
	}


	public void setPrivateInfoCreditScore(Integer privateInfoCreditScore) {
		this.privateInfoCreditScore = privateInfoCreditScore;
	}


	@Override
	public String toString() {
		return "RenterUserProfile [contactInfoId=" + contactInfoId + ", contactInfoFirstName=" + contactInfoFirstName
				+ ", contactInfoLastName=" + contactInfoLastName + ", contactInfoPrimaryEmail="
				+ contactInfoPrimaryEmail + ", contactInfoSecondaryEmail=" + contactInfoSecondaryEmail
				+ ", contactInfoHomePhoneNo=" + contactInfoHomePhoneNo + ", contactInfoCellPhoneNo="
				+ contactInfoCellPhoneNo + ", contactInfoWorkPhoneNo=" + contactInfoWorkPhoneNo
				+ ", contactInfoHomeAddressId=" + contactInfoHomeAddressId + ", contactInfoHomeAddressType="
				+ contactInfoHomeAddressType + ", contactInfoHomeAddrLine1=" + contactInfoHomeAddrLine1
				+ ", contactInfoHomeAddrLine2=" + contactInfoHomeAddrLine2 + ", contactInfoHomeAddrLine3="
				+ contactInfoHomeAddrLine3 + ", contactInfoHomeAddrLine4=" + contactInfoHomeAddrLine4
				+ ", contactInfoHomeCity=" + contactInfoHomeCity + ", contactInfoHomeState=" + contactInfoHomeState
				+ ", contactInfoHomePostalCode=" + contactInfoHomePostalCode + ", contactInfoHomeCountry="
				+ contactInfoHomeCountry + ", employerInfoId=" + employerInfoId + ", employerInfoEmployerAddressId="
				+ employerInfoEmployerAddressId + ", employerInfoEmployerName=" + employerInfoEmployerName
				+ ", employerInfoEmployerPhoneNo=" + employerInfoEmployerPhoneNo + ", employerInfoEmployerAddressType="
				+ employerInfoEmployerAddressType + ", employerInfoEmployerAddrLine1=" + employerInfoEmployerAddrLine1
				+ ", employerInfoEmployerAddrLine2=" + employerInfoEmployerAddrLine2
				+ ", employerInfoEmployerAddrLine3=" + employerInfoEmployerAddrLine3
				+ ", employerInfoEmployerAddrLine4=" + employerInfoEmployerAddrLine4 + ", employerInfoEmployerCity="
				+ employerInfoEmployerCity + ", employerInfoEmployerState=" + employerInfoEmployerState
				+ ", employerInfoEmployerPostalCode=" + employerInfoEmployerPostalCode
				+ ", employerInfoEmployerCountry=" + employerInfoEmployerCountry + ", privateInfoId=" + privateInfoId
				+ ", privateInfoGender=" + privateInfoGender + ", privateInfoEthnicity=" + privateInfoEthnicity
				+ ", privateInfoSsn=" + privateInfoSsn + ", privateInfoCreditCardNo=" + privateInfoCreditCardNo
				+ ", privateInfoCreditCardNoExpMonth=" + privateInfoCreditCardNoExpMonth
				+ ", privateInfoCreditCardNoExpYear=" + privateInfoCreditCardNoExpYear
				+ ", privateInfoCreditCardNoCCVCode=" + privateInfoCreditCardNoCCVCode
				+ ", privateInfoCCBillingAddressId=" + privateInfoCCBillingAddressId
				+ ", privateInfoCCBillingAddressType=" + privateInfoCCBillingAddressType
				+ ", privateInfoCCBillingAddrLine1=" + privateInfoCCBillingAddrLine1
				+ ", privateInfoCCBillingAddrLine2=" + privateInfoCCBillingAddrLine2
				+ ", privateInfoCCBillingAddrLine3=" + privateInfoCCBillingAddrLine3
				+ ", privateInfoCCBillingAddrLine4=" + privateInfoCCBillingAddrLine4 + ", privateInfoCCBillingCity="
				+ privateInfoCCBillingCity + ", privateInfoCCBillingState=" + privateInfoCCBillingState
				+ ", privateInfoCCBillingPostalCode=" + privateInfoCCBillingPostalCode
				+ ", privateInfoCCBillingCountry=" + privateInfoCCBillingCountry + ", privateInfoDob=" + privateInfoDob
				+ ", privateInfoCreditScore=" + privateInfoCreditScore + "]";
	}


	
	
	
	
	
	
	
}
