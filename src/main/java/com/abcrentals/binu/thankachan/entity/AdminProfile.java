package com.abcrentals.binu.thankachan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * AdminProfile entity definition for Hibernate ORM mapping to database table
 * 
 * 
 * 
 */



@Entity
@Table(name="admin_profile")
public class AdminProfile {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="admin_profile_id")
	private Long id;
	
	@Column(name="type_of_profile")
	private String typeOfProfile;
	
	@OneToOne 
	private User user;
	
	 
	@OneToOne(fetch = FetchType.EAGER) 
	private ContactInfo contactInfo;
	
	//@Valid
	@OneToOne(fetch = FetchType.EAGER) 
	private EmployerInfo employerInfo;
	




	public AdminProfile() {
		super();
		 
	}



	public AdminProfile(String typeOfProfile, User user, ContactInfo contactInfo,
			             EmployerInfo employerInfo) {
		super();
		this.typeOfProfile = typeOfProfile;
		this.user = user;
		this.contactInfo = contactInfo;
		this.employerInfo = employerInfo;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
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




	@Override
	public String toString() {
		return "AdminProfile [id=" + id + ", typeOfProfile=" + typeOfProfile + ", user=" + user + ", contactInfo="
				+ contactInfo + ", employerInfo=" + employerInfo + "]";
	}




	
}