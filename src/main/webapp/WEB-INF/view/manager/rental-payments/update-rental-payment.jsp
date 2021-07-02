<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page
	import="com.abcrentals.binu.thankachan.entity.StateOrProvince,java.util.List"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>ABC Rental Property Management - Maintenance - Update
	Rental Payment</title>
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


<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">







<!-- <style>
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
	color: red;
	font-weight: bold;
}
</style> -->
</head>
<body>

	<%@include file="../../common/common-header1.jsp"%>




	<div class="bg-image h-100"
		style="background-image: url('https://mdbootstrap.com/img/Photos/new-templates/search-box/img4.jpg');">


		<section class="intro">
			<div class="mask d-flex align-items-center h-100 gradient-custom">
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-12 col-lg-9 col-xl-7">
							<div class="card">
								<div class="card-body p-4 p-md-5">
									<h3 class="mb-4 pb-2">Update Rental Payment</h3>







									<form:form
										action="${pageContext.request.contextPath}/manager/rental-payments/processUpdateRentalPaymentForm"
										modelAttribute="rentalPayment" method="POST">




										<div class="row">

											<div class="col-md-6 mb-4">
												<div class="form-outline">
												
													<form:label class="form-label" path="id">Rental Payment Id</form:label>					 
													<form:input type="text" path="id" class="form-control"
														value="${id}" readonly="true" />
													<br>
													<form:errors path="id" cssClass="error" />								  

												</div>
											</div>

											<div class="col-md-6 mb-4">
												<div class="form-outline">

													<form:label class="form-label" path="renterUserId">Renter User Id</form:label>
													<form:input type="text" path="renterUserId"
														class="form-control" value="${renterUserId}" readonly="true" />
													<br>
 													<form:errors path="renterUserId" cssClass="error" /> 

												</div>
											</div>

										</div>
										
										 
										<div class="row">
											<div class="col-md-12 mb-8">
												<hr>
													<h4 class="col-md-12 mb-8">
												<br>
											</div>
										</div>



										<div class="row">
											<div class="col-md-6 mb-4">
												<div class="form-outline">

													<form:label class="form-label" path="rentalPropertyId">Rental Property</form:label>
													<br>
													<select name="rentalPropertyId">
														<c:forEach items="${rentalPropertyList}"
															var="rentalProp">
															<option value="${rentalProp.id}"
																<c:if test="${rentalProp.id eq origRentalPropertyId}">selected="selected"</c:if>>${rentalProp.rentalPropertyName}</option>
														</c:forEach>
													</select>

												</div>
											</div>

											<div class="col-md-6 mb-4">
												<div class="form-outline">

													<form:label class="form-label" path="rentalUnitNo">Rental Unit No</form:label>
													<form:input type="text" path="rentalUnitNo"
														class="form-control" value="${rentalUnitNo}" />
													<br>
 													<form:errors path="rentalUnitNo" cssClass="error" /> 

												</div>
											</div>

										</div>


										<div class="row">

											<div class="col-md-6 mb-4">
												<div class="form-outline">

													<form:label class="form-label" path="rentalYear">Rental Year</form:label>													
													<form:select path="rentalYear">
														<form:option value="0">-- Select Rental Year --</form:option>
														<c:if test="${not empty rentalYearList}">
															<form:options items="${rentalYearList}"
																/>
														</c:if>
													</form:select>
													<br>
													<form:errors path="rentalYear" cssClass="error" />
													<br>

												</div>
											</div>

											<div class="col-md-6 mb-4">
												<div class="form-outline">
												
													<form:label class="form-label" path="rentalMonth">Rental Month</form:label>
													<form:select path="rentalMonth">
														<form:option value="0">-- Select Rental Month --</form:option>
														<c:if test="${not empty rentalMonthList}">
															<form:options items="${rentalMonthList}"
																/>
														</c:if>
													</form:select>
													<br>
													<form:errors path="rentalMonth" cssClass="error" />
													<br>

												</div>
											</div>

										</div>




										<div class="row">

											<div class="col-md-6 mb-4">
												<div class="form-outline">
												
													<form:label class="form-label" path="paymentMade">Payment Made?&nbsp;</form:label>
													<br>
													<form:radiobutton path="paymentMade" value="true"  />&nbsp;Yes&nbsp;
													<form:radiobutton path="paymentMade" value="false" />&nbsp;No&nbsp;												
													<br>
													<form:errors path="paymentMade" cssClass="error" />

												</div>
											</div>

											<div class="col-md-6 mb-4">
												<div class="form-outline">

													<form:label class="form-label" path="dateOfPayment">Date of Payment</form:label>
													<form:input type="date" path="dateOfPayment" class="form-control"
														value="${dateOfPayment}" />
													<br>
													<form:errors path="dateOfPayment" cssClass="error" />								 

												</div>
											</div>

										</div>


										<div class="row">

											<div class="col-md-6 mb-4">
												<div class="form-outline">

													<form:label class="form-label" path="monthsRentAmt">Month's Rent Amount</form:label>					 
													<form:input type="number" path="monthsRentAmt" class="form-control"
														value="${monthsRentAmt}" />
													<br>
													<form:errors path="monthsRentAmt" cssClass="error" />								 

												</div>
											</div>

											<div class="col-md-6 mb-4">
												<div class="form-outline">

												</div>
											</div>

										</div>



										<div class="row">

											<div class="col-md-12 mb-8">
												<div class="form-outline">

													<form:label class="form-label" path="note">Note</form:label><br>
													<form:textarea path = "note" rows = "5" cols = "40" value="${note}" />													
													<br>
													<form:errors path="note" cssClass="error" />								 

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



	<%@include file="../../common/common-footer1.jsp"%>






	<script>
  $( "#privateInfoDob" ).datepicker();  
 
</script>



</body>
</html>