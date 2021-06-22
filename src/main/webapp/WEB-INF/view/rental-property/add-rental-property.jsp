<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.abcrentals.binu.thankachan.entity.StateOrProvince,java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>ABC Rental Property Management - Add Rental Property</title>
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
									<h3 class="mb-4 pb-2">Add Rental Property</h3>







									<form:form action="${pageContext.request.contextPath}/rental-property/processAddRentalPropertyForm" modelAttribute="rentalProperty" method="POST">




										<div class="row">
											<div class="col-md-6 mb-4">

												<div class="form-outline">
													<form:input type="text" path="rentalPropertyName"
														class="form-control" />
													<form:label class="form-label"
														path="rentalPropertyName">Rental Property Name/Nickname</form:label><br>
													<form:errors path="rentalPropertyName"
														cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">

												<div class="form-outline">
												
 													 <form:label class="form-label" path="ownerUserId">Owner</form:label>
												
													 <form:select path="ownerUserId" >
        												<form:option value="0">-- Select --</form:option>
															<c:if test="${not empty ownerProfileList}" >
        														<form:options items="${ownerProfileList}" itemValue="user.id" itemLabel= "user.firstAndLastName"/>
															</c:if>
   													 </form:select><br>
													<form:errors path="ownerUserId"
														cssClass="error" />
										
												</div>
											</div>
										</div>


										<div class="row">
										
											<div class="col-md-6 mb-4">
												<div class="form-outline">
												
													 <form:label class="form-label" path="managerUserId">Manager</form:label>
												
													 <form:select path="managerUserId" >
        												<form:option value="0">-- Select --</form:option>
															<c:if test="${not empty managerProfileList}" >
        														<form:options items="${managerProfileList}" itemValue="user.id" itemLabel= "user.firstAndLastName"/>
															</c:if>
   													 </form:select><br>
													<form:errors path="managerUserId"
														cssClass="error" />
												
												</div>

											</div>
											<div class="col-md-6 mb-4">

												<div class="form-outline">
												
													<form:input type="url" path="imageUrl"
														class="form-control" />
													<form:label class="form-label"
														path="imageUrl">Rental Property Photo Url</form:label><br>
													<form:errors path="imageUrl"
														cssClass="error" />
	
												</div>

											</div>
										</div>



										<!-- RENTAL PROPERTY ADDRESS  -->
										
										<div class="row">
											<div class="col-md-12 mb-8">
												<hr>
												<h4 class="col-md-12 mb-8">Rental Property Address</h4>
												<br>
											</div>

											<div class="col-md-6 mb-4">
												<div class="form-outline">
													<form:hidden path="rentalPropertyAddress.addressType" value="3" />
													<!-- 1=Home Address -->

													<form:input type="text" path="rentalPropertyAddress.addrLine1"
														class="form-control" maxlength="50"/>
													<form:label class="form-label"
														path="rentalPropertyAddress.addrLine1">Address Line 1</form:label><br>
													<form:errors path="rentalPropertyAddress.addrLine1"
														cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline">
													<form:input type="text" path="rentalPropertyAddress.city"
														class="form-control" maxlength="50"/>
													<form:label class="form-label" path="rentalPropertyAddress.city">City</form:label><br>
													<form:errors path="rentalPropertyAddress.city" cssClass="error" />

												</div>

											</div>
										</div>

										<div class="row">
											<div class="col-md-6 mb-4">

												<div class="form-outline">
													<form:input type="text" path="rentalPropertyAddress.addrLine2"
														class="form-control" maxlength="50"/>
													<form:label class="form-label"
														path="rentalPropertyAddress.addrLine2">Address Line 2</form:label><br>
													<form:errors path="rentalPropertyAddress.addrLine2"
														cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline">
	
 													 <form:label class="form-label" path="rentalPropertyAddress.state">State</form:label>
												
													 <form:select path="rentalPropertyAddress.state" >
        												<form:option value="0">-- Select --</form:option>
															<c:if test="${not empty statesOrProvincesForRentalProperty}" >
        														<form:options items="${statesOrProvincesForRentalProperty}" itemValue="stateOrProvince" itemLabel= "stateOrProvince"/>
															</c:if>
   													 </form:select><br>
													<form:errors path="rentalPropertyAddress.state"
														cssClass="error" />
 													                          
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-6 mb-4">

												<div class="form-outline">
													<form:input type="text" path="rentalPropertyAddress.addrLine3"
														class="form-control" maxlength="50"/>
													<form:label class="form-label"
														path="rentalPropertyAddress.addrLine3">Address Line 3</form:label><br>
													<form:errors path="rentalPropertyAddress.addrLine3"
														cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline">
													<form:input type="text" path="rentalPropertyAddress.postalCode"
														class="form-control" maxlength="5" />
													<form:label class="form-label"
														path="rentalPropertyAddress.postalCode">Postal Code</form:label><br>
													<form:errors path="rentalPropertyAddress.postalCode"
														cssClass="error" />

												</div>

											</div>
										</div>

										<div class="row">
											<div class="col-md-6 mb-4">

												<div class="form-outline">
													<form:input type="text" path="rentalPropertyAddress.addrLine4"
														class="form-control" maxlength="50"/>
													<form:label class="form-label"
														path="rentalPropertyAddress.addrLine4">Address Line 4</form:label><br>
													<form:errors path="rentalPropertyAddress.addrLine4"
														cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline">
												
 													<form:label class="form-label select-label"
														path="rentalPropertyAddress.country">Country&nbsp;</form:label>
													<form:select path="rentalPropertyAddress.country" class="select">
														<form:option value="0">-- Select --</form:option>
														<form:options items="${countries}" itemValue="countryName" itemLabel = "countryName" />
	 												</form:select><br>											
													<form:errors path="rentalPropertyAddress.country"
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