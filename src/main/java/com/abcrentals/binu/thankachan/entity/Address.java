	package com.abcrentals.binu.thankachan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * Address entity definition for Hibernate ORM mapping to database table
 * 
 * 
 * 
 */


@Entity
@Table(name="address")
public class Address {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	private Integer id;
	
	@Column(name="addr_type")
	private Integer addressType; // 1=Home, 2=Work, 3=Rental Property, 4=Billing Address
	@Column(name="addr_line1")
	private String addrLine1;
	@Column(name="addr_line2")
	private String addrLine2;
	@Column(name="addr_line3")
	private String addrLine3;
	@Column(name="addr_line4")
	private String addrLine4;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="postal_code")
	private String postalCode;
	@Column(name="country")
	private String country;   
	
	public Address() {
		super();
		 
	}

	public Address(Integer addressType, String addrLine1, String addrLine2, String addrLine3, String addrLine4,
			String city, String state, String postalCode, String country) {
		super();
		this.addressType = addressType;
		this.addrLine1 = addrLine1;
		this.addrLine2 = addrLine2;
		this.addrLine3 = addrLine3;
		this.addrLine4 = addrLine4;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAddressType() {
		return addressType;
	}

	public void setAddressType(Integer addressType) {
		this.addressType = addressType;
	}

	public String getAddrLine1() {
		return addrLine1;
	}

	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}

	public String getAddrLine2() {
		return addrLine2;
	}

	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}

	public String getAddrLine3() {
		return addrLine3;
	}

	public void setAddrLine3(String addrLine3) {
		this.addrLine3 = addrLine3;
	}

	public String getAddrLine4() {
		return addrLine4;
	}

	public void setAddrLine4(String addrLine4) {
		this.addrLine4 = addrLine4;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", addressType=" + addressType + ", addrLine1=" + addrLine1 + ", addrLine2="
				+ addrLine2 + ", addrLine3=" + addrLine3 + ", addrLine4=" + addrLine4 + ", city=" + city + ", state="
				+ state + ", postalCode=" + postalCode + ", country=" + country + "]";
	}


	
	

}
