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
	Rental Property</title>
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
									<h3 class="mb-4 pb-2">Update Rental Property</h3>







									<form:form
										action="${pageContext.request.contextPath}/maintenance/manage-rental-properties/processUpdateRentalPropertyForm"
										modelAttribute="rentalProperty" method="POST">




										<div class="row">

											<div class="col-md-6 mb-4">
												<div class="form-outline">
					 
													<form:input type="text" path="id" class="form-control"
														value="${id}" readonly="true" />
													<form:label class="form-label" path="id">Property Id</form:label>
													<br>
													<form:errors path="id" cssClass="error" />								  

												</div>
											</div>

											<div class="col-md-6 mb-4">
												<div class="form-outline">

													<form:input type="text" path="rentalPropertyName"
														class="form-control" value="${rentalPropertyName}" readonly="true" />
													<form:label class="form-label" path="rentalPropertyName">Property Name</form:label>
													<br>
 													<form:errors path="rentalPropertyName" cssClass="error" /> 

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

													<form:label class="form-label" path="ownerUserId">Property Owner</form:label>
													<br>
													<select name="ownerUserId">
														<c:forEach items="${ownerProfileList}"
															var="owner">
															<option value="${owner.user.id}"
																<c:if test="${owner.user.id eq origOwnerUserId}">selected="selected"</c:if>>${owner.user.firstAndLastName}</option>
														</c:forEach>
													</select>

												</div>
											</div>

											<div class="col-md-6 mb-4">
												<div class="form-outline">

													<form:label class="form-label" path="managerUserId">Property Manager</form:label>
													<br>
													<select name="managerUserId">
														<c:forEach items="${managerProfileList}"
															var="manager">
															<option value="${manager.user.id}"
																<c:if test="${manager.user.id eq origMgrUserId}">selected="selected"</c:if>>${manager.user.firstAndLastName}</option>
														</c:forEach>
													</select>

												</div>
											</div>

										</div>


										<div class="row">

											<div class="col-md-6 mb-4">
												<div class="form-outline">
					 
													<form:input type="text" path="imageUrl" class="form-control"
														value="${imageUrl}" />
													<form:label class="form-label" path="imageUrl">Proprty Image Url</form:label>
													<br>
													<form:errors path="imageUrl" cssClass="error" />								 

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






	<script>
  $( "#privateInfoDob" ).datepicker();  
 
</script>



</body>
</html>