package com.abcrentals.binu.thankachan.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.abcrentals.binu.thankachan.validation.EmailConstraint2;

/*
 * ContactInfo entity definition for Hibernate ORM mapping to database table
 * 
 * 
 * 
 */



@Entity
@Table(name="contact_info")
public class ContactInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="contact_info_id")
	private Integer id;
	
	//@NotBlank
	@Column(name="first_name")
	private String firstName;
	
	//@NotBlank
	@Column(name="last_name")
	private String lastName;
	
	//@EmailConstraint2
	@Column(name="primary_email")
	private String primaryEmail;
	
	//@EmailConstraint2
	@Column(name="secondary_email")
	private String secondaryEmail;
	
	//@Min(1_000_000_000) @Max(9_999_999_999L)
	@Column(name="home_phone_no")
	private String homePhoneNo;
	
	//@Min(1_000_000_000) @Max(9_999_999_999L)
	@Column(name="cell_phone_no")
	private String cellPhoneNo;
	
	//@Min(1_000_000_000) @Max(9_999_999_999L)
	@Column(name="work_phone_no")
	private String workPhoneNo;
	

	@OneToMany(fetch = FetchType.EAGER)
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "contactinfo_homeaddress", 
//	joinColumns = @JoinColumn(name = "contact_info"), 
//	inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List<Address> homeAddresses = new ArrayList<Address>();

	
	public ContactInfo() {
		super();
		
	}


	public ContactInfo(Integer id, String firstName, String lastName, String primaryEmail,
			String secondaryEmail,  String homePhoneNo,
			String cellPhoneNo,  String workPhoneNo,
			List<Address> homeAddresses) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.primaryEmail = primaryEmail;
		this.secondaryEmail = secondaryEmail;
		this.homePhoneNo = homePhoneNo;
		this.cellPhoneNo = cellPhoneNo;
		this.workPhoneNo = workPhoneNo;
		this.homeAddresses = homeAddresses;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPrimaryEmail() {
		return primaryEmail;
	}


	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}


	public String getSecondaryEmail() {
		return secondaryEmail;
	}


	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}


	public String getHomePhoneNo() {
		return homePhoneNo;
	}


	public void setHomePhoneNo(String homePhoneNo) {
		this.homePhoneNo = homePhoneNo;
	}


	public String getCellPhoneNo() {
		return cellPhoneNo;
	}


	public void setCellPhoneNo(String cellPhoneNo) {
		this.cellPhoneNo = cellPhoneNo;
	}


	public String getWorkPhoneNo() {
		return workPhoneNo;
	}


	public void setWorkPhoneNo(String workPhoneNo) {
		this.workPhoneNo = workPhoneNo;
	}

	//@OneToMany(cascade = CascadeType.ALL)
	//@JoinTable(name = "contactinfo_homeaddress", joinColumns = { @JoinColumn(name = "contact_info_id") }, inverseJoinColumns = { @JoinColumn(name = "address_id") })
	public List<Address> getHomeAddresses() {
		return homeAddresses;
	}


	public void setHomeAddresses(List<Address> homeAddresses) {
		this.homeAddresses = homeAddresses;
	}


	@Override
	public String toString() {
		return "ContactInfo [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", primaryEmail="
				+ primaryEmail + ", secondaryEmail=" + secondaryEmail + ", homePhoneNo=" + homePhoneNo
				+ ", cellPhoneNo=" + cellPhoneNo + ", workPhoneNo=" + workPhoneNo + ", homeAddresses=" + homeAddresses + "]";
	}






	
}
