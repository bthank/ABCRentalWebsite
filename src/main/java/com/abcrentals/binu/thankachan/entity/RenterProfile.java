package com.abcrentals.binu.thankachan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

/*
 * RenterProfile entity definition for Hibernate ORM mapping to database table
 * 
 * 
 * 
 */


@Entity
@Table(name="renter_profile")
public class RenterProfile {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="renter_profile_id")
	private Integer id;
	
	@Column(name="type_of_profile")
	private String typeOfProfile;
	
	@OneToOne 
	private User user;
	
	//@Valid
	@OneToOne 
	private ContactInfo contactInfo;
	
	//@Valid
	@OneToOne 
	private EmployerInfo employerInfo;
	
	//@Valid
	@OneToOne 
	private PrivateInfo privateInfo;



	public RenterProfile() {
		super();
		 
	}



	public RenterProfile(String typeOfProfile, User user, ContactInfo contactInfo,
			             EmployerInfo employerInfo, PrivateInfo privateInfo) {
		super();
		this.typeOfProfile = typeOfProfile;
		this.user = user;
		this.contactInfo = contactInfo;
		this.employerInfo = employerInfo;
		this.privateInfo = privateInfo;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getTypeOfProfile() {
		return typeOfProfile;
	}



	public void setTypeOfProfile(String typeOfProfile) {
		this.typeOfProfile = typeOfProfile;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public ContactInfo getContactInfo() {
		return contactInfo;
	}



	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}



	public EmployerInfo getEmployerInfo() {
		return employerInfo;
	}



	public void setEmployerInfo(EmployerInfo employerInfo) {
		this.employerInfo = employerInfo;
	}



	public PrivateInfo getPrivateInfo() {
		return privateInfo;
	}



	public void setPrivateInfo(PrivateInfo privateInfo) {
		this.privateInfo = privateInfo;
	}



	@Override
	public String toString() {
		return "RenterProfile [id=" + id + ", typeOfProfile=" + typeOfProfile + ", user=" + user + ", contactInfo="
				+ contactInfo + ", employerInfo=" + employerInfo + ", privateInfo=" + privateInfo + "]";
	}




	
}
