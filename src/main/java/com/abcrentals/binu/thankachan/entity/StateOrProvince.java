package com.abcrentals.binu.thankachan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * StateOrProvince entity definition for Hibernate ORM mapping to database table
 * 
 * 
 * 
 */


@Entity
@Table(name="states_or_provinces")
public class StateOrProvince {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="country")
	private String country;
	
	@Column(name="state_or_province")
	private String stateOrProvince;

	public StateOrProvince() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StateOrProvince(String country, String stateOrProvince) {
		super();
		this.country = country;
		this.stateOrProvince = stateOrProvince;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStateOrProvince() {
		return stateOrProvince;
	}

	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}

	@Override
	public String toString() {
		return "StatesOrProvinces [id=" + id + ", country=" + country + ", stateOrProvince=" + stateOrProvince + "]";
	}
	
	
	
}
