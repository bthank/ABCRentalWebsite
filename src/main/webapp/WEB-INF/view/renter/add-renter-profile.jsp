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
    // Run on page load
    window.onload = function() {

        // If sessionStorage is storing default values (ex. name), exit the function and do not restore data
//         if (sessionStorage.getItem('contactInfoFirstName') == "contactInfoFirstName") {
//             return;
//         }

        // If values are not blank, restore them to the fields
/*         var contactInfoFirstName = sessionStorage.getItem('contactInfoFirstName');
        if (contactInfoFirstName !== null) $('#contactInfoFirstName').val(contactInfoFirstName);

        var contactInfoLastName = sessionStorage.getItem('contactInfoLastName');
        if (contactInfoLastName !== null) $('#contactInfoLastName').val(contactInfoLastName);

        var contactInfoPrimaryEmail = sessionStorage.getItem('contactInfoPrimaryEmail');
        if (contactInfoPrimaryEmail !== null) $('#contactInfoPrimaryEmail').val(contactInfoPrimaryEmail);

        var contactInfoHomePhoneNo = sessionStorage.getItem('contactInfoHomePhoneNo');
        if (contactInfoHomePhoneNo !== null) $('#contactInfoHomePhoneNo').val(contactInfoHomePhoneNo);
        
        var contactInfoSecondaryEmail = sessionStorage.getItem('contactInfoSecondaryEmail');
        if (contactInfoSecondaryEmail !== null) $('#contactInfoSecondaryEmail').val(contactInfoSecondaryEmail);

        var contactInfoCellPhoneNo = sessionStorage.getItem('contactInfoCellPhoneNo');
        if (contactInfoCellPhoneNo !== null) $('#contactInfoCellPhoneNo').val(contactInfoCellPhoneNo);
        
        var contactInfoWorkPhoneNo = sessionStorage.getItem('contactInfoWorkPhoneNo');
        if (contactInfoWorkPhoneNo !== null) $('#contactInfoWorkPhoneNo').val(contactInfoWorkPhoneNo);
        
        var contactInfoHomeAddressType = sessionStorage.getItem('contactInfoHomeAddressType');
        if (contactInfoHomeAddressType !== null) $('#contactInfoHomeAddressType').val(contactInfoHomeAddressType);       
        
        var contactInfoHomeAddrLine1 = sessionStorage.getItem('contactInfoHomeAddrLine1');
        if (contactInfoHomeAddrLine1 !== null) $('#contactInfoHomeAddrLine1').val(contactInfoHomeAddrLine1);

        var contactInfoHomeCity = sessionStorage.getItem('contactInfoHomeCity');
        if (contactInfoHomeCity !== null) $('#contactInfoHomeCity').val(contactInfoHomeCity);
        
        var contactInfoHomeAddrLine2 = sessionStorage.getItem('contactInfoHomeAddrLine2');
        if (contactInfoHomeAddrLine2 !== null) $('#contactInfoHomeAddrLine2').val(contactInfoHomeAddrLine2);
         
        var contactInfoHomeState = sessionStorage.getItem('contactInfoHomeState');
        if (contactInfoHomeState !== null) $('#contactInfoHomeState').val(contactInfoHomeState);
        
        var contactInfoHomeAddrLine3 = sessionStorage.getItem('contactInfoHomeAddrLine3');
        if (contactInfoHomeAddrLine3 !== null) $('#contactInfoHomeAddrLine3').val(contactInfoHomeAddrLine3);

        var contactInfoHomePostalCode = sessionStorage.getItem('contactInfoHomePostalCode');
        if (contactInfoHomePostalCode !== null) $('#contactInfoHomePostalCode').val(contactInfoHomePostalCode);
        
        var contactInfoHomeAddrLine4 = sessionStorage.getItem('contactInfoHomeAddrLine4');
        if (contactInfoHomeAddrLine4 !== null) $('#contactInfoHomeAddrLine4').val(contactInfoHomeAddrLine4);
       
        var contactInfoHomeCountry = sessionStorage.getItem('contactInfoHomeCountry');
        if (contactInfoHomeCountry !== null) $('#contactInfoHomeCountry').val(contactInfoHomeCountry);

        var employerInfoEmployerName = sessionStorage.getItem('employerInfoEmployerName');
        if (employerInfoEmployerName !== null) $('#employerInfoEmployerName').val(employerInfoEmployerName);        
        
        var employerInfoEmployerPhoneNo = sessionStorage.getItem('employerInfoEmployerPhoneNo');
        if (employerInfoEmployerPhoneNo !== null) $('#employerInfoEmployerPhoneNo').val(employerInfoEmployerPhoneNo);
        
        var employerInfoEmployerAddressType = sessionStorage.getItem('employerInfoEmployerAddressType');
        if (employerInfoEmployerAddressType !== null) $('#employerInfoEmployerAddressType').val(employerInfoEmployerAddressType);
        
        var employerInfoEmployerAddrLine1 = sessionStorage.getItem('employerInfoEmployerAddrLine1');
        if (employerInfoEmployerAddrLine1 !== null) $('#employerInfoEmployerAddrLine1').val(employerInfoEmployerAddrLine1);
        
        var employerInfoEmployerCity = sessionStorage.getItem('employerInfoEmployerCity');
        if (employerInfoEmployerCity !== null) $('#employerInfoEmployerCity').val(employerInfoEmployerCity);

        var employerInfoEmployerAddrLine2 = sessionStorage.getItem('employerInfoEmployerAddrLine2');
        if (employerInfoEmployerAddrLine2 !== null) $('#employerInfoEmployerAddrLine2').val(employerInfoEmployerAddrLine2);   

        var employerInfoEmployerState = sessionStorage.getItem('employerInfoEmployerState');
        if (employerInfoEmployerState !== null) $('#employerInfoEmployerState').val(employerInfoEmployerState);   
         
        var employerInfoEmployerAddrLine3 = sessionStorage.getItem('employerInfoEmployerAddrLine3');
        if (employerInfoEmployerAddrLine3 !== null) $('#employerInfoEmployerAddrLine3').val(employerInfoEmployerAddrLine3);

        var employerInfoEmployerPostalCode = sessionStorage.getItem('employerInfoEmployerPostalCode');
        if (employerInfoEmployerPostalCode !== null) $('#employerInfoEmployerPostalCode').val(employerInfoEmployerPostalCode);        
       
        var employerInfoEmployerAddrLine4 = sessionStorage.getItem('employerInfoEmployerAddrLine4');
        if (employerInfoEmployerAddrLine4 !== null) $('#employerInfoEmployerAddrLine4').val(employerInfoEmployerAddrLine4);
        
        var employerInfoEmployerCountry = sessionStorage.getItem('employerInfoEmployerCountry');
        if (employerInfoEmployerCountry !== null) $('#employerInfoEmployerCountry').val(employerInfoEmployerCountry);

        var privateInfoGender = sessionStorage.getItem('privateInfoGender');
        if (privateInfoGender !== null) $('#privateInfoGender').val(privateInfoGender);       
        
        var privateInfoEthnicity = sessionStorage.getItem('privateInfoEthnicity');
        if (privateInfoEthnicity !== null) $('#privateInfoEthnicity').val(privateInfoEthnicity);
        
        var privateInfoSsn = sessionStorage.getItem('privateInfoSsn');
        if (privateInfoSsn !== null) $('#privateInfoSsn').val(privateInfoSsn);   
        
        var privateInfoDob = sessionStorage.getItem('privateInfoDob');
        if (privateInfoDob !== null) $('#privateInfoDob').val(privateInfoDob);        
        
        var privateInfoCreditCardNo = sessionStorage.getItem('privateInfoCreditCardNo');
        if (privateInfoCreditCardNo !== null) $('#privateInfoCreditCardNo').val(privateInfoCreditCardNo);  
        
        var privateInfoCreditCardNoExpMonth = sessionStorage.getItem('privateInfoCreditCardNoExpMonth');
        if (privateInfoCreditCardNoExpMonth !== null) $('#privateInfoCreditCardNoExpMonth').val(privateInfoCreditCardNoExpMonth);        
        
        var privateInfoCreditCardNoExpYear = sessionStorage.getItem('privateInfoCreditCardNoExpYear');
        if (privateInfoCreditCardNoExpYear !== null) $('#privateInfoCreditCardNoExpYear').val(privateInfoCreditCardNoExpYear);        
        
        var privateInfoCreditCardNoCCVCode = sessionStorage.getItem('privateInfoCreditCardNoCCVCode');
        if (privateInfoCreditCardNoCCVCode !== null) $('#privateInfoCreditCardNoCCVCode').val(privateInfoCreditCardNoCCVCode);          
        
        var privateInfoCCBillingAddressType = sessionStorage.getItem('privateInfoCCBillingAddressType');
        if (privateInfoCCBillingAddressType !== null) $('#privateInfoCCBillingAddressType').val(privateInfoCCBillingAddressType);     
        
        var privateInfoCCBillingAddrLine1 = sessionStorage.getItem('privateInfoCCBillingAddrLine1');
        if (privateInfoCCBillingAddrLine1 !== null) $('#privateInfoCCBillingAddrLine1').val(privateInfoCCBillingAddrLine1); 
        
        var privateInfoCCBillingCity = sessionStorage.getItem('privateInfoCCBillingCity');
        if (privateInfoCCBillingCity !== null) $('#privateInfoCCBillingCity').val(privateInfoCCBillingCity);        
       
        var privateInfoCCBillingAddrLine2 = sessionStorage.getItem('privateInfoCCBillingAddrLine2');
        if (privateInfoCCBillingAddrLine2 !== null) $('#privateInfoCCBillingAddrLine2').val(privateInfoCCBillingAddrLine2);     
        
        var privateInfoCCBillingState = sessionStorage.getItem('privateInfoCCBillingState');
        if (privateInfoCCBillingState !== null) $('#privateInfoCCBillingState').val(privateInfoCCBillingState);     
        
        var privateInfoCCBillingAddrLine3 = sessionStorage.getItem('privateInfoCCBillingAddrLine3');
        if (privateInfoCCBillingAddrLine3 !== null) $('#privateInfoCCBillingAddrLine3').val(privateInfoCCBillingAddrLine3); 

        var privateInfoCCBillingPostalCode = sessionStorage.getItem('privateInfoCCBillingPostalCode');
        if (privateInfoCCBillingPostalCode !== null) $('#privateInfoCCBillingPostalCode').val(privateInfoCCBillingPostalCode);        
        
        var privateInfoCCBillingAddrLine4 = sessionStorage.getItem('privateInfoCCBillingAddrLine4');
        if (privateInfoCCBillingAddrLine4 !== null) $('#privateInfoCCBillingAddrLine4').val(privateInfoCCBillingAddrLine4);        
        
        var privateInfoCCBillingCountry = sessionStorage.getItem('privateInfoCCBillingCountry');
        if (privateInfoCCBillingCountry !== null) $('#privateInfoCCBillingCountry').val(privateInfoCCBillingCountry);        
  */       
        
        
        
  
    }

    // Before refreshing the page, save the form data to sessionStorage
    window.onbeforeunload = function() {
/*         sessionStorage.setItem("contactInfoFirstName", $('#contactInfoFirstName').val());
        sessionStorage.setItem("contactInfoLastName", $('#contactInfoLastName').val());
        sessionStorage.setItem("contactInfoPrimaryEmail", $('#contactInfoPrimaryEmail').val());
        sessionStorage.setItem("contactInfoHomePhoneNo", $('#contactInfoHomePhoneNo').val());        
        sessionStorage.setItem("contactInfoSecondaryEmail", $('#contactInfoSecondaryEmail').val());
        sessionStorage.setItem("contactInfoCellPhoneNo", $('#contactInfoCellPhoneNo').val());
        sessionStorage.setItem("contactInfoWorkPhoneNo", $('#contactInfoWorkPhoneNo').val());
        sessionStorage.setItem("contactInfoHomeAddressType", $('#contactInfoHomeAddressType').val());
        sessionStorage.setItem("contactInfoHomeAddrLine1", $('#contactInfoHomeAddrLine1').val());
        sessionStorage.setItem("contactInfoHomeCity", $('#contactInfoHomeCity').val());
        sessionStorage.setItem("contactInfoHomeAddrLine2", $('#contactInfoHomeAddrLine2').val());  
        sessionStorage.setItem("contactInfoHomeState", $('#contactInfoHomeState').val());         
        sessionStorage.setItem("contactInfoHomeAddrLine3", $('#contactInfoHomeAddrLine3').val());
        sessionStorage.setItem("contactInfoHomePostalCode", $('#contactInfoHomePostalCode').val());
        sessionStorage.setItem("contactInfoHomeAddrLine4", $('#contactInfoHomeAddrLine4').val());        
        sessionStorage.setItem("contactInfoHomeCountry", $('#contactInfoHomeCountry').val());
        sessionStorage.setItem("employerInfoEmployerName", $('#employerInfoEmployerName').val());        
        sessionStorage.setItem("employerInfoEmployerPhoneNo", $('#employerInfoEmployerPhoneNo').val());
        sessionStorage.setItem("employerInfoEmployerAddressType", $('#employerInfoEmployerAddressType').val());
        sessionStorage.setItem("employerInfoEmployerAddrLine1", $('#employerInfoEmployerAddrLine1').val());
        sessionStorage.setItem("employerInfoEmployerCity", $('#employerInfoEmployerCity').val());
        sessionStorage.setItem("employerInfoEmployerAddrLine2", $('#employerInfoEmployerAddrLine2').val());
        sessionStorage.setItem("employerInfoEmployerState", $('#employerInfoEmployerState').val());
        sessionStorage.setItem("employerInfoEmployerAddrLine3", $('#employerInfoEmployerAddrLine3').val());
        sessionStorage.setItem("employerInfoEmployerPostalCode", $('#employerInfoEmployerPostalCode').val());
        sessionStorage.setItem("employerInfoEmployerAddrLine4", $('#employerInfoEmployerAddrLine4').val());
        sessionStorage.setItem("employerInfoEmployerCountry", $('#employerInfoEmployerCountry').val());        
        sessionStorage.setItem("privateInfoGender", $('#privateInfoGender').val());
        sessionStorage.setItem("privateInfoEthnicity", $('#privateInfoEthnicity').val());
        sessionStorage.setItem("privateInfoSsn", $('#privateInfoSsn').val());
        sessionStorage.setItem("privateInfoDob", $('#privateInfoDob').val());
        sessionStorage.setItem("privateInfoCreditCardNo", $('#privateInfoCreditCardNo').val());        
        sessionStorage.setItem("privateInfoCreditCardNoExpMonth", $('#privateInfoCreditCardNoExpMonth').val());
        sessionStorage.setItem("privateInfoCreditCardNoExpYear", $('#privateInfoCreditCardNoExpYear').val());
        sessionStorage.setItem("privateInfoCreditCardNoCCVCode", $('#privateInfoCreditCardNoCCVCode').val());
        sessionStorage.setItem("privateInfoCCBillingAddressType", $('#privateInfoCCBillingAddressType').val());        
        sessionStorage.setItem("privateInfoCCBillingAddrLine1", $('#privateInfoCCBillingAddrLine1').val());
        sessionStorage.setItem("privateInfoCCBillingCity", $('#privateInfoCCBillingCity').val());
        sessionStorage.setItem("privateInfoCCBillingAddrLine2", $('#privateInfoCCBillingAddrLine2').val());    
        sessionStorage.setItem("privateInfoCCBillingState", $('#privateInfoCCBillingState').val());                  
        sessionStorage.setItem("privateInfoCCBillingAddrLine3", $('#privateInfoCCBillingAddrLine3').val());
        sessionStorage.setItem("privateInfoCCBillingPostalCode", $('#privateInfoCCBillingPostalCode').val());
        sessionStorage.setItem("privateInfoCCBillingAddrLine4", $('#privateInfoCCBillingAddrLine4').val());        
        sessionStorage.setItem("privateInfoCCBillingCountry", $('#privateInfoCCBillingCountry').val());
        
        
        */
        
        
        
        
        
        
        
        

     }
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
<%-- 	 <%List<StateOrProvince> statesOrProvincesForHomeAddress1     = (List<StateOrProvince>) session.getAttribute("statesOrProvincesForHomeAddress"); %> 
	 <%List<StateOrProvince> statesOrProvincesForEmployerAddress1 = (List<StateOrProvince>) session.getAttribute("statesOrProvincesForEmployerAddress"); %> 
	 <%List<StateOrProvince> statesOrProvincesForBillingAddress1  = (List<StateOrProvince>) session.getAttribute("statesOrProvincesForBillingAddress"); %> 
 --%>	
<%-- 	<% --%>
<%--  		String pageTitle = "Renter"; --%>
<%-- 	%> --%>
<%-- 	<jsp:param name="pageTitle" value="<%=pageTitle%>>" /> --%>
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
<%-- 													<form:label class="form-label" path="privateInfoDob">Date of Birth</form:label>
													<form:errors path="privateInfoDob" cssClass="error" />
													
													<form:input type="date" path="privateInfoDob" />
 --%>													
 														<form:label class="form-label" path="privateInfoDob">Date of Birth</form:label>
 														<form:input type="date" id="privateInfoDob" path="privateInfoDob" value=""/><br>
 														<form:errors  path="privateInfoDob" cssClass="error" />
 														
<!--  														<label class="form-label" for="privateInfoDob">Date of Birth</label> -->
<!--  													    <input type="text" id="privateInfoDob" />  -->
 											 
	
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
	
<!-- 	<script type="text/javascript">
     function getStatesOrProvincesForHomeAddress(selectedCountry)
     {
    	window.location.href='${pageContext.request.contextPath}/statesOrProvinces/getStatesOrProvincesForHomeAddress?country='+selectedCountry; 
     }
     function getStatesOrProvincesForEmployerAddress(selectedCountry)
     {
    	window.location.href='${pageContext.request.contextPath}/statesOrProvinces/getStatesOrProvincesForEmployerAddress?country='+selectedCountry; 
     }
     function getStatesOrProvincesForBillingAddress(selectedCountry)
     {
    	window.location.href='${pageContext.request.contextPath}/statesOrProvinces/getStatesOrProvincesForBillingAddress?country='+selectedCountry; 
     }

     </script> -->
     


<!-- 	<script>
		$( function() {
		    $.datepicker.setDefaults({
		        showOn: "both",
		        buttonImageOnly: true,
		        buttonImage: "calender.gif",
		        buttonText: "Calendar"
		        changeDay: true,
		        changeMonth: true,
		        changeYear: true,
		        dateFormat: "M-dd-yy",		
		        onClose:function(date, inst){
		            $("#selectedDateVal").html(date);
		        }
		    });
		
		    $( "#datepicker" ).datepicker();
		});
	</script> -->
<script>
  $( "#privateInfoDob" ).datepicker();  
 
</script>



</body>
</html>