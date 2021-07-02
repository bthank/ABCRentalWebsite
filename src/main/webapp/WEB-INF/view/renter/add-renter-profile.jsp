<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.abcrentals.binu.thankachan.entity.StateOrProvince,java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>ABC Rental Property Management - Add Renter Profile Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.12.4.js"></script>
  <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	
	
	
	
<script>
 

  
</script>

<style>
.fakeimg {
	height: 200px;
	background: #aaa;
}

.box img {
	width: 100%;
	height: 100%;
}

.box1 img {
	object-fit: cover;
}

.box2 img {
	object-fit: contain;
}

.box3 img {
	object-fit: fill;
}

.ifont {
	color: white;
}

.fas {
	background: radial-gradient(white 50%, transparent 50%);
}

li {
	font-weight: bold;
	color: white;
}

nav {
	text-align: center;
}

.intro {
	height: 100%;
	margin: 20px 20px 20px 20px;
}

.gradient-custom {
	/* fallback for old browsers */
	
}

.error {
	color:	red;
	font-weight: bold;
}
</style>
</head>
<body>
 
	<%@include file="../common/common-header1.jsp"%>




	<div class="bg-image h-100"
		style="background-image: url('https://mdbootstrap.com/img/Photos/new-templates/search-box/img4.jpg');">


		<section class="intro">
			<div class="mask d-flex align-items-center h-100 gradient-custom">
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-12 col-lg-9 col-xl-7">
							<div class="card">
								<div class="card-body p-4 p-md-5">
									<h3 class="mb-4 pb-2">Add Renter Profile</h3>







									<form:form action="${pageContext.request.contextPath}/renter/processAddRenterProfileForm" modelAttribute="renterUserProfile" method="POST">

										<div class="row">
											<div class="col-md-6 mb-4">




<!--   ###########################   CONTACT INFO and ADDRESS   ###########################   -->


												<div class="form-outline">
													<form:input type="text" path="contactInfoFirstName"
														class="form-control" value="${user.firstName}" readonly="true"/>
													<form:label class="form-label" path="contactInfoFirstName">First Name</form:label><br>
													<form:errors path="contactInfoFirstName" cssClass="error" />
												</div>

											</div>
											<div class="col-md-6 mb-4">

												<div class="form-outline">
													<form:input type="text" path="contactInfoLastName"
														class="form-control" value="${user.lastName}" readonly="true"/>
													<form:label class="form-label" path="contactInfoLastName">Last Name</form:label><br>
													<form:errors path="contactInfoLastName" cssClass="error" />

												</div>

											</div>
										</div>



										<div class="row">
											<div class="col-md-6 mb-4">

												<div class="form-outline">
													<form:input type="email" path="contactInfoPrimaryEmail"
														class="form-control" />
													<form:label class="form-label"
														path="contactInfoPrimaryEmail">Primary Email</form:label><br>
													<form:errors path="contactInfoPrimaryEmail"
														cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">

												<div class="form-outline">
													<form:input type="tel" path="contactInfoHomePhoneNo"
														class="form-control" />
													<form:label class="form-label"
														path="contactInfoHomePhoneNo">Home Phone Number</form:label><br>
													<form:errors path="contactInfoHomePhoneNo" cssClass="error" />

												</div>

											</div>
										</div>


										<div class="row">
											<div class="col-md-6 mb-4">

												<div class="form-outline">
													<form:input type="email" path="contactInfoSecondaryEmail"
														class="form-control" />
													<form:label class="form-label"
														path="contactInfoSecondaryEmail">Secondary Email</form:label><br>
													<form:errors path="contactInfoSecondaryEmail"
														cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">

												<div class="form-outline">
													<form:input type="tel" path="contactInfoCellPhoneNo"
														class="form-control" />
													<form:label class="form-label"
														path="contactInfoCellPhoneNo">Cell Phone Number</form:label><br>
													<form:errors path="contactInfoCellPhoneNo" cssClass="error" />

												</div>

											</div>
										</div>



										<div class="row">
											<div class="col-md-6 mb-4">

												<div class="form-outline"></div>

											</div>
											<div class="col-md-6 mb-4">

												<div class="form-outline">
													<form:input type="tel" path="contactInfoWorkPhoneNo"
														class="form-control" />
													<form:label class="form-label"
														path="contactInfoWorkPhoneNo">Work Phone Number</form:label><br>
													<form:errors path="contactInfoWorkPhoneNo" cssClass="error" />

												</div>

											</div>
										</div>


						<!-- HOME ADDRESS  -->
										
										<div class="row">
											<div class="col-md-12 mb-8">
												<hr>
												<h4 class="col-md-12 mb-8">Home Address</h4>
												<br>
											</div>

											<div class="col-md-6 mb-4">
												<div class="form-outline">
													<form:hidden path="contactInfoHomeAddressType" value="1" />
													<!-- 1=Home Address -->

													<form:input type="text" path="contactInfoHomeAddrLine1"
														class="form-control" maxlength="50"/>
													<form:label class="form-label"
														path="contactInfoHomeAddrLine1">Address Line 1</form:label><br>
													<form:errors path="contactInfoHomeAddrLine1"
														cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline">
													<form:input type="text" path="contactInfoHomeCity"
														class="form-control" maxlength="50"/>
													<form:label class="form-label" path="contactInfoHomeCity">City</form:label><br>
													<form:errors path="contactInfoHomeCity" cssClass="error" />

												</div>

											</div>
										</div>

										<div class="row">
											<div class="col-md-6 mb-4">

												<div class="form-outline">
													<form:input type="text" path="contactInfoHomeAddrLine2"
														class="form-control" maxlength="50"/>
													<form:label class="form-label"
														path="contactInfoHomeAddrLine2">Address Line 2</form:label><br>
													<form:errors path="contactInfoHomeAddrLine2"
														cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline">
	
													 <form:label class="form-label" path="contactInfoHomeState">State</form:label>
												
													 <form:select path="contactInfoHomeState" >
        												<form:option value="0">-- Select --</form:option>
															<c:if test="${not empty statesOrProvincesForHomeAddress}" >
        														<form:options items="${statesOrProvincesForHomeAddress}" itemValue="id" itemLabel= "stateOrProvince"/>
															</c:if>
   													 </form:select><br>
													<form:errors path="contactInfoHomeState"
														cssClass="error" />
													                          
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-6 mb-4">

												<div class="form-outline">
													<form:input type="text" path="contactInfoHomeAddrLine3"
														class="form-control" maxlength="50"/>
													<form:label class="form-label"
														path="contactInfoHomeAddrLine3">Address Line 3</form:label><br>
													<form:errors path="contactInfoHomeAddrLine3"
														cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline">
													<form:input type="text" path="contactInfoHomePostalCode"
														class="form-control" maxlength="5" />
													<form:label class="form-label"
														path="contactInfoHomePostalCode">Postal Code</form:label><br>
													<form:errors path="contactInfoHomePostalCode"
														cssClass="error" />

												</div>

											</div>
										</div>

										<div class="row">
											<div class="col-md-6 mb-4">

												<div class="form-outline">
													<form:input type="text" path="contactInfoHomeAddrLine4"
														class="form-control" maxlength="50"/>
													<form:label class="form-label"
														path="contactInfoHomeAddrLine4">Address Line 4</form:label><br>
													<form:errors path="contactInfoHomeAddrLine4"
														cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline">
												
													<form:label class="form-label select-label"
														path="contactInfoHomeCountry">Country&nbsp;</form:label>
													<form:select path="contactInfoHomeCountry" class="select">
														<form:option value="0">-- Select --</form:option>
														<form:options items="${countries}" itemValue="countryCode" itemLabel = "countryName" />
	 												</form:select><br>											
													<form:errors path="contactInfoHomeCountry"
															cssClass="error" />
												
												</div>
											</div>
										</div>






<!--   ###########################   EMPLOYER INFO and ADDRESS   ###########################   -->


										<div class="row">
											<div class="col-md-12 mb-8">
												<hr>
												<h4 class="col-md-12 mb-8">Employer</h4>
												<br>
											</div>


											<div class="col-md-6 mb-4">

												<div class="form-outline">

													<form:input type="text" path="employerInfoEmployerName"
														class="form-control" maxlength="50"/>
													<form:label class="form-label"
														path="employerInfoEmployerName">Employer Name</form:label><br>
													<form:errors path="employerInfoEmployerName"
														cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline">
													<form:input type="tel" path="employerInfoEmployerPhoneNo"
														class="form-control"/>
													<form:label class="form-label"
														path="employerInfoEmployerPhoneNo">Employer Phone Number</form:label><br>
													<form:errors path="employerInfoEmployerPhoneNo"
														cssClass="error" />

												</div>

											</div>
										</div>




					<!--   EMPLOYER ADDRESS   -->

										<div class="row">
											<div class="col-md-12 mb-8">
												<hr>
												<h4 class="col-md-12 mb-8">Employer Address</h4>
												<br>
											</div>

											<div class="col-md-6 mb-4">
												<div class="form-outline">
												
													<form:hidden path="employerInfoEmployerAddressType"
														value="2" />
													<!-- 2=Work Address -->

												
												
													<form:input type="text"
														path="employerInfoEmployerAddrLine1" class="form-control" maxlength="50"/>
													<form:label class="form-label"
														path="employerInfoEmployerAddrLine1">Address Line 1</form:label><br>
													<form:errors path="employerInfoEmployerAddrLine1"
														cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline">
													<form:input type="text" path="employerInfoEmployerCity"
														class="form-control" maxlength="50"/>
													<form:label class="form-label"
														path="employerInfoEmployerCity">City</form:label><br>
													<form:errors path="employerInfoEmployerCity"
														cssClass="error" />

												</div>

											</div>
										</div>

										<div class="row">
											<div class="col-md-6 mb-4">

												<div class="form-outline">
													<form:input type="text"
														path="employerInfoEmployerAddrLine2" class="form-control" maxlength="50"/>
													<form:label class="form-label"
														path="employerInfoEmployerAddrLine2">Address Line 2</form:label><br>
													<form:errors path="employerInfoEmployerAddrLine2"
														cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline">
		
													 <form:label class="form-label" path="employerInfoEmployerState">State</form:label>
												
													 <form:select path="employerInfoEmployerState" >
        												<form:option value="0">-- Select --</form:option>
															<c:if test="${not empty statesOrProvincesForEmployerAddress}" >
        														<form:options items="${statesOrProvincesForEmployerAddress}" itemValue="id" itemLabel= "stateOrProvince"/>
															</c:if>
   													 </form:select><br>
													<form:errors path="employerInfoEmployerState"
														cssClass="error" />

												</div>

											</div>
										</div>

										<div class="row">
											<div class="col-md-6 mb-4">

												<div class="form-outline">
													<form:input type="text"
														path="employerInfoEmployerAddrLine3" class="form-control" maxlength="50"/>
													<form:label class="form-label"
														path="employerInfoEmployerAddrLine3">Address Line 3</form:label><br>
													<form:errors path="employerInfoEmployerAddrLine3"
														cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline">
													<form:input type="text"
														path="employerInfoEmployerPostalCode" class="form-control" maxlength="5" />
													<form:label class="form-label"
														path="employerInfoEmployerPostalCode">Postal Code</form:label><br>
													<form:errors path="employerInfoEmployerPostalCode"
														cssClass="error" />

												</div>

											</div>
										</div>

										<div class="row">
											<div class="col-md-6 mb-4">

												<div class="form-outline">
													<form:input type="text"
														path="employerInfoEmployerAddrLine4" class="form-control" maxlength="50"/>
													<form:label class="form-label"
														path="employerInfoEmployerAddrLine4">Address Line 4</form:label><br>
													<form:errors path="employerInfoEmployerAddrLine4"
														cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline">
												
													<form:label class="form-label select-label"
														path="employerInfoEmployerCountry">Country&nbsp;</form:label>
													<form:select path="employerInfoEmployerCountry" class="select">
														<form:option value="0">-- Select --</form:option>
														<form:options items="${countries}" itemValue="countryCode" itemLabel = "countryName" />
	 												</form:select><br>
													<form:errors path="employerInfoEmployerCountry"
															cssClass="error" />
																									
												</div>											
											</div>
										</div>






<!--   ###########################   PRIVATE INFO and ADDRESS   ###########################   -->


										<div class="row">
											<div class="col-md-12 mb-8">
												<hr>
												<h4 class="col-md-12 mb-8">Personal Information</h4>
												<br>
											</div>
										</div>



										<div class="row">

											<div class="col-md-6 mb-4">

												<div class="form-outline">

													<form:label class="form-label" path="privateInfoGender">Gender&nbsp;&nbsp;</form:label>
													<br>
													<form:radiobutton path="privateInfoGender" value="1"/>&nbsp;Male 
													<form:radiobutton path="privateInfoGender" value="2"/>&nbsp;Female 
													<form:radiobutton path="privateInfoGender" value="3"/>&nbsp;Other 

												</div>

											</div>

											<div class="col-md-6 mb-4">
												<div class="form-outline">

													<label class="form-label select-label">Ethnicity</label>
													<form:select path="privateInfoEthnicity" class="select">
														<form:option value="0">-- Select --</form:option>
														<form:option value="1">American Indian or Alaska Native</form:option>
														<form:option value="2">Asian</form:option>
														<form:option value="3">Black or African American</form:option>
														<form:option value="4">Hispanic or Latino</form:option>
														<form:option value="5">Native Hawaiian or Other Pacific Islander</form:option>
														<form:option value="6">White</form:option>
													</form:select>

												</div>

											</div>
										</div>

										<div class="row">
											<div class="col-md-6 mb-4">
	
												<div class="form-outline">
	
													<form:input type="number" path="privateInfoSsn"
														class="form-control" maxlength="9" />
													<form:label class="form-label" path="privateInfoSsn">SSN Number</form:label><br>
													<form:errors path="privateInfoSsn" cssClass="error" />
	
												</div>
	
											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline"></div>
											
 														<form:label class="form-label" path="privateInfoDob">Date of Birth</form:label>
 														<form:input type="date" id="privateInfoDob" path="privateInfoDob" value=""/><br>
 														<form:errors  path="privateInfoDob" cssClass="error" />
 														
												</div>
											</div>
										
										

						<!--  CREDIT CARD INFO  -->

										<div class="row">

											<div class="col-md-12 mb-8">
												<hr>
												<h4 class="col-md-12 mb-8">Credit Card</h4>
												<br>
											</div>
										</div>

										<div class="row">

											<div class="col-md-6 mb-4">

												<div class="form-outline">
													<form:hidden path="privateInfoCreditScore"
														value="0" />
												
												
												
													<form:input type="number" path="privateInfoCreditCardNo"
														class="form-control" maxlength="16" />
													<form:label class="form-label"
														path="privateInfoCreditCardNo">CC Number</form:label><br>
													<form:errors path="privateInfoCreditCardNo"
														cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline">
												
													<label class="form-label select-label">CC Exp Month</label>
													<form:select path="privateInfoCreditCardNoExpMonth" class="select">
														<form:option value="0">-- Select --</form:option>
														<form:option value="1">01 - January</form:option>
														<form:option value="2">02 - February</form:option>
														<form:option value="3">03 - March</form:option>
														<form:option value="4">04 - April</form:option>
														<form:option value="5">05 - May</form:option>
														<form:option value="6">06 - June</form:option>
														<form:option value="7">07 - July</form:option>
														<form:option value="8">08 - August</form:option>
														<form:option value="9">09 - September</form:option>
														<form:option value="10">10 - October</form:option>
														<form:option value="11">11 - November</form:option>
														<form:option value="12">12 - December</form:option>
													</form:select><br>
													<form:errors path="privateInfoCreditCardNoExpMonth"
														cssClass="error" />

												</div>

											</div>
										</div>


										<div class="row">

											<div class="col-md-6 mb-4">

												<div class="form-outline">
																								
													<label class="form-label select-label">CC Exp Year</label>
													<form:select path="privateInfoCreditCardNoExpYear" class="select">
														<form:option value="0">-- Select --</form:option>
														<form:option value="2021">2021</form:option>
														<form:option value="2022">2022</form:option>
														<form:option value="2023">2023</form:option>
														<form:option value="2024">2024</form:option>
														<form:option value="2025">2025</form:option>
														<form:option value="2026">2026</form:option>
													</form:select><br>
													<form:errors path="privateInfoCreditCardNoExpYear"
														cssClass="error" />
												
												</div>

											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline">
													<form:input type="number"
														path="privateInfoCreditCardNoCCVCode" class="form-control"
														maxlength="3" />
													<form:label class="form-label"
														path="privateInfoCreditCardNoCCVCode">CC CCV Code</form:label><br>
													<form:errors path="privateInfoCreditCardNoCCVCode"
														cssClass="error" />

												</div>

											</div>
										</div>



				<!-- CREDIT CARD BILLING ADDRESS  -->
							

										<div class="row">
											<div class="col-md-12 mb-8">
												<hr>
												<h4 class="col-md-12 mb-8">Billing Address</h4>
												<br>
											</div>
										</div>
			
										<div class="row">

											<div class="col-md-6 mb-4">
												<div class="form-outline">
													<form:hidden path="privateInfoCCBillingAddressType"
														value="3" />
													<!-- 4=Billing Address -->

													<form:input type="text"
														path="privateInfoCCBillingAddrLine1" class="form-control" maxlength="50"/>
													<form:label class="form-label"
														path="privateInfoCCBillingAddrLine1">Address Line 1</form:label><br>
													<form:errors path="privateInfoCCBillingAddrLine1"
														cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline">
													<form:input type="text" path="privateInfoCCBillingCity"
														class="form-control" maxlength="50"/>
													<form:label class="form-label"
														path="privateInfoCCBillingCity">City</form:label><br>
													<form:errors path="privateInfoCCBillingCity"
														cssClass="error" />

												</div>

											</div>
										</div>

										<div class="row">
											<div class="col-md-6 mb-4">

												<div class="form-outline">
													<form:input type="text" path="privateInfoCCBillingAddrLine2" class="form-control" maxlength="50"/>
													<form:label class="form-label"
														path="privateInfoCCBillingAddrLine2">Address Line 2</form:label><br>
													<form:errors path="privateInfoCCBillingAddrLine2"
														cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline">
		
													 <form:label class="form-label" path="privateInfoCCBillingState">State</form:label>
												
													 <form:select path="privateInfoCCBillingState" >
        												<form:option value="0">-- Select --</form:option>
															<c:if test="${not empty statesOrProvincesForBillingAddress}" >
        														<form:options items="${statesOrProvincesForBillingAddress}" itemValue="id" itemLabel= "stateOrProvince"/>
															</c:if>
   													 </form:select><br>
											  		<form:errors path="privateInfoCCBillingState"
														cssClass="error" />

												</div>

											</div>
										</div>

										<div class="row">
											<div class="col-md-6 mb-4">

												<div class="form-outline">
													<form:input type="text"
														path="privateInfoCCBillingAddrLine3" class="form-control" maxlength="50"/>
													<form:label class="form-label"
														path="privateInfoCCBillingAddrLine3">Address Line 3</form:label><br>
													<form:errors path="privateInfoCCBillingAddrLine3"
														cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline">
													<form:input type="text"
														path="privateInfoCCBillingPostalCode" class="form-control" maxlength="5" />
													<form:label class="form-label"
														path="privateInfoCCBillingPostalCode">Postal Code</form:label><br>
													<form:errors path="privateInfoCCBillingPostalCode"
														cssClass="error" />

												</div>

											</div>
										</div>

										<div class="row">
											<div class="col-md-6 mb-4">

												<div class="form-outline">
													<form:input type="text"
														path="privateInfoCCBillingAddrLine4" class="form-control" maxlength="50"/>
													<form:label class="form-label"
														path="privateInfoCCBillingAddrLine4">Address Line 4</form:label><br>
													<form:errors path="privateInfoCCBillingAddrLine4"
														cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline">
													
													<form:label class="form-label select-label"
														path="privateInfoCCBillingCountry">Country&nbsp;</form:label>
													<form:select path="privateInfoCCBillingCountry" class="select">
														<form:option value="0">-- Select --</form:option>
														<form:options items="${countries}" itemValue="countryCode" itemLabel = "countryName"/>
	 												</form:select><br>											
												  	<form:errors path="privateInfoCCBillingCountry"
															cssClass="error" />
																									
												</div>
											</div>
										</div>



										<div class="row">
											<div class="col-12">

												<div class="mt-4">
													<input class="btn btn-warning btn-lg" type="submit"
														value="Submit" />
												</div>

											</div>
										</div>
								</div>


								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
	</div>
	</section>



	</div>



	<%@include file="../common/common-footer1.jsp"%>
	

     



<script>
  $( "#privateInfoDob" ).datepicker();  
 
</script>



</body>
</html>