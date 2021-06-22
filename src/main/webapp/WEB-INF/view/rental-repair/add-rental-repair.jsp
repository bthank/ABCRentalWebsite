<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page
	import="com.abcrentals.binu.thankachan.entity.StateOrProvince,java.util.List"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>ABC Rental Property Management - Add Rental Repair</title>
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
									<h3 class="mb-4 pb-2">Add Rental Repair</h3>







									<form:form
										action="${pageContext.request.contextPath}/rental-repair/processAddRentalRepairForm"
										modelAttribute="rentalRepair" method="POST">




										<div class="row">
											<div class="col-md-6 mb-4">

												<div class="form-outline">

													<form:label class="form-label" path="submittedDate">Submitted On</form:label>
													<br>
													<form:input type="date" path="submittedDate"
														class="form-control" value="${today}" disabled="true" />
													<br>
													<form:errors path="submittedDate" cssClass="error" />

												</div>

											</div>
											<div class="col-md-6 mb-4">

												<div class="form-outline">

													<form:label class="form-label" path="submittedByUserId">Submitted By</form:label>
													<br>
													<form:input type="text" path="submittedByUserId"
														class="form-control" value="${user.firstAndLastName}"
														disabled="true" />
													<br>
													<form:errors path="submittedByUserId" cssClass="error" />

												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-6 mb-4">
												<div class="form-outline">

													<form:label class="form-label" path="rentalPropertyId">Rental Property Name</form:label>
													<br>
													<form:select path="rentalPropertyId">
														<form:option value="0">-- Select Property --</form:option>
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

													<form:label class="form-label" path="rentalRepairType">Repair Type</form:label>
													<br>
													<form:select path="rentalRepairType">
														<form:option value="0">-- Select Property --</form:option>
														<c:if test="${not empty rentalRepairTypes}">
															<form:options items="${rentalRepairTypes}" />
														</c:if>
													</form:select>
													<br>
													<form:errors path="rentalRepairType" cssClass="error" />

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

													<form:label class="form-label" path="description">Repair description</form:label>
													<br>
													<form:textarea path = "description" rows = "5" cols = "40" />													
													<br>
													<form:errors path="description" cssClass="error" />

												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-12 mb-8">
												<div class="form-outline">
													<br>
													<form:label class="form-label" path="comment">Notes or Comments</form:label>
													<br>
													<form:textarea path = "comment" rows = "5" cols = "40" />													
													<br>
													<form:errors path="comment" cssClass="error" />

												</div>
											</div>
										</div>







										<div class="row">
											<div class="col-12">
											
												<div class="form-outline">
													<div class="mt-4">
														<input class="btn btn-warning btn-lg" type="submit" value="Submit" />
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







</body>
</html>