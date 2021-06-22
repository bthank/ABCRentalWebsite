package com.abcrentals.binu.thankachan.user;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.abcrentals.binu.thankachan.validation.EmailConstraint2;

/*
 * ContractorUser form backing bean entity class
 * 
 * 
 * 
 */


@Entity
@Table(name="contractor_user_profile")
public class ContractorUserProfile {

	
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

	

	public ContractorUserProfile() {
		
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



	@Override
	public String toString() {
		return "ContractorUserProfile [contactInfoId=" + contactInfoId + ", contactInfoFirstName="
				+ contactInfoFirstName + ", contactInfoLastName=" + contactInfoLastName + ", contactInfoPrimaryEmail="
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
				+ ", employerInfoEmployerCountry=" + employerInfoEmployerCountry + "]";
	}









	
}
