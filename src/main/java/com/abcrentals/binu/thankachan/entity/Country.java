package com.abcrentals.binu.thankachan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Country entity definition for Hibernate ORM mapping to database table
 * 
 * 
 * 
 */


@Entity
@Table(name="country")
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="country_code")
	private Integer  countryCode;

	
	@Column(name="country_name")
	private String countryName;


	public Country() {
		super();
	}


	public Country(String countryName) {
		super();
		this.countryName = countryName;
	}


	public Integer getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	@Override
	public String toString() {
		return "Country [countryCode=" + countryCode + ", countryName=" + countryName + "]";
	}
	

	
}
