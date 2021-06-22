package com.abcrentals.binu.thankachan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/*
 * RentalUnitAmenity entity definition for Hibernate ORM mapping to database table
 * 
 * 
 * 
 */


@Entity
@Table(name="rental_unit_amenity")
public class RentalUnitAmenity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rental_unit_amenity_id")
	private Integer id;
	
	@NotNull(message="Required value")
	@Column(name="rental_property_id")
	private Long rentalPropertyId;
	
	@NotNull(message="Required value")
	@Column(name="rental_unit_no")
	private Integer rentalUnitNo;
	
	@Column(name = "amenity_type")
	private Integer amenityType; //1=Dish Washer, 2=Washer, 3=Dryer, 4=Central A/C, 5=Jacuzzi, 6=Swimming Pool, 7=One Car Garage, 
	                             //8=Two Car Garage, 9=Exercise Equipment, 10=Granite Countertops in Kitchen, 11=Concierge
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "comment")
	private String comment;
	
	

	public RentalUnitAmenity() {
		super();
		 
	}
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getRentalPropertyId() {
		return rentalPropertyId;
	}

	public void setRentalPropertyId(Long rentalPropertyId) {
		this.rentalPropertyId = rentalPropertyId;
	}

	public Integer getRentalUnitNo() {
		return rentalUnitNo;
	}

	public void setRentalUnitNo(Integer rentalUnitNo) {
		this.rentalUnitNo = rentalUnitNo;
	}

	public Integer getAmenityType() {
		return amenityType;
	}

	public void setAmenityType(Integer amenityType) {
		this.amenityType = amenityType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "RentalUnitAmenity [id=" + id + ", rentalPropertyId=" + rentalPropertyId + ", rentalUnitNo="
				+ rentalUnitNo + ", amenityType=" + amenityType + ", description=" + description + ", comment="
				+ comment + "]";
	}


	
	
	
}
