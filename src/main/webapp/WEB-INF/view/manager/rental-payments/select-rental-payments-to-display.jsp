<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page
	import="com.abcrentals.binu.thankachan.entity.StateOrProvince,java.util.List"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>ABC Rental Property Management - Select Rental Payments To Display</title>
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
	color: red;
	font-weight: bold;
}
</style>
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
									<h3 class="mb-4 pb-2">Select Rental Payments to Display</h3>







									<form:form
										action="${pageContext.request.contextPath}/manager/rental-payments/showRentalPaymentsToDisplay"
										modelAttribute="rentalPayment" method="POST">



										<!-- USER ACCESS SECTION -->
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
													<form:select path="rentalPropertyId">
														<form:option value="-1">-- Select Rental Property --</form:option>
														<c:if test="${not empty rentalPropertyList}">
															<form:options items="${rentalPropertyList}"
																itemValue="id" itemLabel="rentalPropertyName" />
														</c:if>
													</form:select>
													<br>
													<form:errors path="rentalPropertyId" cssClass="error" />
													

													

												</div>
											</div>

											<div class="col-md-6 mb-4">
												<div class="form-outline">

													<form:label class="form-label" path="rentalUnitNo">Rental Unit #</form:label>
													<br>
													<form:input type="number" path="rentalUnitNo"
														class="form-control" />
													<br>
													<form:errors path="rentalUnitNo" cssClass="error" />
	
												</div>
											</div>
											
										</div>



										<div class="row">
											<div class="col-md-6 mb-4">
												<div class="form-outline">

													<form:label class="form-label" path="rentalYear">Rental Year</form:label>
													<br>
													<form:select path="rentalYear">
														<form:option value="-1">-- Select Year --</form:option>
														<c:if test="${not empty rentalYearList}">
															<form:options items="${rentalYearList}" />
														</c:if>
													</form:select>
													<br>
													<form:errors path="rentalYear" cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline">

													<form:label class="form-label" path="rentalMonth">Rental Month</form:label>
													<br>
													<form:select path="rentalMonth">
														<form:option value="-1">-- Select Month --</form:option>
														<c:if test="${not empty rentalMonthList}">
															<form:options items="${rentalMonthList}" />
														</c:if>
													</form:select>
													<br>
													<form:errors path="rentalMonth" cssClass="error" />

												</div>
											</div>
										</div>


										<div class="row">
											<div class="col-md-6 mb-4">

												<div class="form-outline">

													<form:label class="form-label" path="renterUserId">Renter</form:label>
													<br>
													<form:select path="renterUserId">
														<form:option value="-1">-- Select Renter --</form:option>
														<c:if test="${not empty renterProfileList}">
															<form:options items="${renterProfileList}"
																itemValue="user.id" itemLabel="user.fullName" />
														</c:if>
													</form:select>
													<br>
													<form:errors path="renterUserId" cssClass="error" />

												</div>
											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline">


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








</body>
</html>