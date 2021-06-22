package com.abcrentals.binu.thankachan.entity;

/*
 * RentalProperty entity definition for Hibernate ORM mapping to database table
 * 
 * 
 * 
 */




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="rental_property")
public class RentalProperty {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rental_property_id")
	private Long id;
	
	@Valid
	@OneToOne(fetch = FetchType.EAGER) 
	private Address rentalPropertyAddress;
	
	@NotBlank
	@Column(name = "rental_property_name")
	private String rentalPropertyName;
	
	@NotNull
	@Column(name = "owner_user_id")
	private Long ownerUserId;
	

	@Column(name = "manager_user_id")
	private Long managerUserId;
	
	@Column(name="image_url")
	private String imageUrl;
	
	
	
	public RentalProperty() {
		super();
		
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Address getRentalPropertyAddress() {
		return rentalPropertyAddress;
	}



	public void setRentalPropertyAddress(Address rentalPropertyAddress) {
		this.rentalPropertyAddress = rentalPropertyAddress;
	}



	public String getRentalPropertyName() {
		return rentalPropertyName;
	}



	public void setRentalPropertyName(String rentalPropertyName) {
		this.rentalPropertyName = rentalPropertyName;
	}



	public Long getOwnerUserId() {
		return ownerUserId;
	}



	public void setOwnerUserId(Long ownerUserId) {
		this.ownerUserId = ownerUserId;
	}



	public Long getManagerUserId() {
		return managerUserId;
	}



	public void setManagerUserId(Long managerUserId) {
		this.managerUserId = managerUserId;
	}



	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}



	@Override
	public String toString() {
		return "RentalProperty [id=" + id + ", rentalPropertyAddress=" + rentalPropertyAddress + ", rentalPropertyName="
				+ rentalPropertyName + ", ownerUserId=" + ownerUserId + ", managerUserId=" + managerUserId
				+ ", imageUrl=" + imageUrl + "]";
	}




	
	
	
	
	
}
