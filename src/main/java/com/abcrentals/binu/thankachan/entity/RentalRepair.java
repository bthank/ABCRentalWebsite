package com.abcrentals.binu.thankachan.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * RentalRepair entity definition for Hibernate ORM mapping to database table
 * 
 * 
 * 
 */


@Entity
@Table(name="rental_repair")
public class RentalRepair {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rental_repair_id")
	private Long id;
	
	@Column(name = "submitted_by_user_id")
	private Long submittedByUserId;
	
 	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "submitted_date")
	private LocalDate submittedDate;
	
 	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "completion_date")
	private LocalDate completionDate;
	
	@NotNull(message="Required value")
	@Column(name="rental_property_id")
	private Long rentalPropertyId;
	
	@NotNull(message="Required value")
	@Column(name="rental_unit_no")
	private Integer rentalUnitNo;
	
	@NotNull(message="Required value")
	@Column(name="rental_repair_type")
	private Integer rentalRepairType;
	
	@Column(name="repair_status")
	private Integer repairStatus; // 0=N/A, 1=Unassigned, 2=Assigned, 3=Completed, 4=Issue Found After Fix, 5=Closed

	@NotBlank(message="Required value")
	@Column(name="description")
	private String description;

	@Column(name="comment")
	private String comment;
	
	@Column(name="root_cause")
	private Integer rootCause;
	
	@Column(name="repair_cost_estimate")
	private Double repairCostEstimate;
	
	@Column(name="repair_cost_actual")
	private Double repairCostActual;
	
	@Column(name="assigned_to_contractor_id")
	private Integer assignedToContractorId;

	
	
	public RentalRepair() {
		super();
		 
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getSubmittedByUserId() {
		return submittedByUserId;
	}



	public void setSubmittedByUserId(Long submittedByUserId) {
		this.submittedByUserId = submittedByUserId;
	}



	public LocalDate getSubmittedDate() {
		return submittedDate;
	}



	public void setSubmittedDate(LocalDate submittedDate) {
		this.submittedDate = submittedDate;
	}



	public LocalDate getCompletionDate() {
		return completionDate;
	}



	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
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



	public Integer getRentalRepairType() {
		return rentalRepairType;
	}



	public void setRentalRepairType(Integer rentalRepairType) {
		this.rentalRepairType = rentalRepairType;
	}



	public Integer getRepairStatus() {
		return repairStatus;
	}



	public void setRepairStatus(Integer repairStatus) {
		this.repairStatus = repairStatus;
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



	public Integer getRootCause() {
		return rootCause;
	}



	public void setRootCause(Integer rootCause) {
		this.rootCause = rootCause;
	}



	public Double getRepairCostEstimate() {
		return repairCostEstimate;
	}



	public void setRepairCostEstimate(Double repairCostEstimate) {
		this.repairCostEstimate = repairCostEstimate;
	}



	public Double getRepairCostActual() {
		return repairCostActual;
	}



	public void setRepairCostActual(Double repairCostActual) {
		this.repairCostActual = repairCostActual;
	}



	public Integer getAssignedToContractorId() {
		return assignedToContractorId;
	}



	public void setAssignedToContractorId(Integer assignedToContractorId) {
		this.assignedToContractorId = assignedToContractorId;
	}

	
	/*
	 * public String getRepairIdPlusPropertyIdPlusUnitNo() {
	 * 
	 * String combinationString = "";
	 * 
	 * combinationString = "Repair id: " + getId() + " | Property: " +
	 * getRentalPropertyId() + " | Unit no: " + getRentalUnitNo(); System.out.
	 * println("In RentalRepair   method  getRepairIdPlusPropertyIdPlusUnitNo()   combinationString= "
	 * + combinationString +"\n\n");
	 * 
	 * return combinationString;
	 * 
	 * }
	 */


	@Override
	public String toString() {
		return "RentalRepair [id=" + id + ", submittedByUserId=" + submittedByUserId + ", submittedDate="
				+ submittedDate + ", completionDate=" + completionDate + ", rentalPropertyId=" + rentalPropertyId
				+ ", rentalUnitNo=" + rentalUnitNo + ", rentalRepairType=" + rentalRepairType + ", repairStatus="
				+ repairStatus + ", description=" + description + ", comment=" + comment + ", rootCause=" + rootCause
				+ ", repairCostEstimate=" + repairCostEstimate + ", repairCostActual=" + repairCostActual
				+ ", assignedToContractorId=" + assignedToContractorId + "]";
	}
	
	

}
