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
	User Access</title>
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
									<h3 class="mb-4 pb-2">Update User Access</h3>







									<form:form
										action="${pageContext.request.contextPath}/maintenance/manage-users/processUpdateUserAccessForm"
										modelAttribute="user" method="POST">




										<div class="row">

											<div class="col-md-6 mb-4">
												<div class="form-outline">
					 
													<form:input type="text" path="id" class="form-control"
														value="${id}" disabled="true" />
													<form:label class="form-label" path="id">User Id</form:label>
													<br>
													<form:errors path="id" cssClass="error" />								 

												</div>
											</div>

											<div class="col-md-6 mb-4">
												<div class="form-outline">

													<form:input type="text" path="userName"
														class="form-control" value="${userName}" disabled="true" />
													<form:label class="form-label" path="userName">User Name</form:label>
													<br>
													<form:errors path="userName" cssClass="error" />

												</div>
											</div>

										</div>

										<div class="row">
											<div class="col-md-6 mb-4">
												<div class="form-outline">

													<form:input type="text" path="firstName"
														class="form-control" value="${firstName}" disabled="true" />
													<form:label class="form-label" path="firstName">First Name</form:label>
													<br>
													<form:errors path="firstName" cssClass="error" />

												</div>
											</div>

											<div class="col-md-6 mb-4">
												<div class="form-outline">

													<form:input type="text" path="lastName"
														class="form-control" value="${lastName}" disabled="true" />
													<form:label class="form-label" path="lastName">Last Name</form:label>
													<br>
													<form:errors path="lastName" cssClass="error" />

												</div>
											</div>

										</div>


										<div class="row">

											<div class="col-md-6 mb-4">
												<div class="form-outline">

													<form:input type="email" path="email" class="form-control"
														value="${email}" disabled="true" />
													<form:label class="form-label" path="email">Email</form:label>
													<br>
													<form:errors path="email" cssClass="error" />
												</div>
											</div>

											<div class="col-md-6 mb-4">
												<div class="form-outline"></div>
											</div>

										</div>


										<!-- USER ACCESS SECTION -->
										<div class="row">
											<div class="col-md-12 mb-8">
												<hr>
												<h4 class="col-md-12 mb-8">
													User Access <br>
											</div>
										</div>



										<div class="row">
										
											<div class="col-md-6 mb-4">
												<div class="form-outline">

													<form:label class="form-label" path="accessLevel">User Access Level</form:label>
													<br>
													<form:select path="accessLevel">
														<form:option value="0">-- Select User Access Level --</form:option>
														<c:if test="${not empty userAccessTypeList}">
															<form:options items="${userAccessTypeList}"
																/>
														</c:if>
													</form:select>
													<br>
													<form:errors path="accessLevel" cssClass="error" />

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