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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * EmployerInfo entity definition for Hibernate ORM mapping to database table
 * 
 * 
 * 
 */


@Entity
@Table(name="employer_info")
public class EmployerInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employer_info_id")
	private Integer id;
	
	@Column(name="employer_name")
	private String employerName;

	@Column(name="employer_phone_no")
	private String employerPhoneNo;


	@OneToMany(fetch = FetchType.LAZY)
	private List<Address> employerAddresses = new ArrayList<Address>();
	
	public EmployerInfo() {
		super();
		
	}

	public EmployerInfo(String employerName, String employerPhoneNo, List<Address> employerAddresses) {
		super();
		this.employerName = employerName;
		this.employerPhoneNo = employerPhoneNo;
		this.employerAddresses = employerAddresses;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getEmployerPhoneNo() {
		return employerPhoneNo;
	}

	public void setEmployerPhoneNo(String employerPhoneNo) {
		this.employerPhoneNo = employerPhoneNo;
	}

	public List<Address> getEmployerAddresses() {
		return employerAddresses;
	}

	public void setEmployerAddresses(List<Address> employerAddresses) {
		this.employerAddresses = employerAddresses;
	}

	@Override
	public String toString() {
		return "EmployerInfo [id=" + id + ", employerName=" + employerName + ", employerPhoneNo=" + employerPhoneNo
				+ ", employerAddresses=" + employerAddresses + "]";
	}


	
	
	

}
