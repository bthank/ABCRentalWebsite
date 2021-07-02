<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>ABC Rental Property Management Contractor Page</title>


<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Reference Bootstrap files -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
 <script 
 	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script> 

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



 <link rel="stylesheet" 
 	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 





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




.error {
	color: red
}
</style>








<!-- <meta charset="utf-8"> -->
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!-- <link rel="stylesheet" -->
<!-- 	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> -->
<!-- <link rel="stylesheet" -->
<!-- 	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> -->
<!-- <script -->
<!-- 	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
<!-- <script -->
<!-- 	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script> -->
<!-- <script -->
<!-- 	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> -->

<style>

body {
  margin: 0;
  font-size: 1.5em;
}

.hero-image {
  background-image: url("https://images.unsplash.com/photo-1566787020216-3e4f973ec5ec?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDd8fGFwYXJ0bWVudHxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60");
  background-color: #cccccc;
  height: 500px;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}

.hero-text {
  text-align: center;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: white;
}



</style>

</head>
<body>

	<%@include file="common/common-header1.jsp"%>


<!--<div class="container" style="margin-top: 30px" >       -->
	<div     class="bg-image h-100"
		style="background-image: url('https://images.unsplash.com/photo-1583135630256-a25ea659d1d7?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTUzfHxob21lfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60');
  background-color: #cccccc;
  height: 500px;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
		">
		<div class="row">
<!-- 			<div class="col-sm-4"> -->
<!-- 				<p></p> -->
<!-- 			</div> -->
			<div class="col-sm-12">
				<p>

						<!--  beginning -->

		<div>

			<div id="loginbox" style="margin-top: 50px;"
				class="mainbox col-md-4 col-md-offset-2 col-sm-8 col-sm-offset-2">

				<div class="panel panel-primary">

					<div class="panel-heading">
						<div class="panel-title">Register New User</div>
					</div>

					<div style="padding-top: 30px" class="panel-body">

						<!-- Registration Form -->
						<form:form
							action="${pageContext.request.contextPath}/register/processRegistrationForm"
							modelAttribute="crmUser" class="form-horizontal">

							<!-- Place for messages: error, alert etc ... -->
							<div class="form-group">
								<div class="col-xs-15">
									<div>

										<!-- Check for registration error -->
										<c:if test="${registrationError != null}">

											<div class="alert alert-danger col-xs-offset-1 col-xs-10">
												${registrationError}</div>

										</c:if>

									</div>
								</div>
							</div>

							<!-- User name -->
							<div style="margin-bottom: 25px" class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span>
								<form:input path="userName" placeholder="username (*)"
									class="form-control" /><br>
								<form:errors path="userName" cssClass="error" />
									
							</div>

							<!-- Password -->
							<div style="margin-bottom: 25px" class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-lock"></i></span>
								<form:password path="password" placeholder="password (*)"
									class="form-control" /><br>
								<form:errors path="password" cssClass="error" />

							</div>

							<!-- Confirm Password -->
							<div style="margin-bottom: 25px" class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-lock"></i></span>
								<form:password path="matchingPassword"
									placeholder="confirm password (*)" class="form-control" /><br>
								<form:errors path="matchingPassword" cssClass="error" />

							</div>


							<!-- name prefix-->
							<div style="margin-bottom: 25px" class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span>
								<form:input path="namePrefix" placeholder="name prefix (*)"
									class="form-control" /><br>
								<form:errors path="namePrefix" cssClass="error" />

							</div>

							<!-- First name -->
							<div style="margin-bottom: 25px" class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span>
								<form:input path="firstName" placeholder="first name (*)"
									class="form-control" /><br>
								<form:errors path="firstName" cssClass="error" />

							</div>

							<!-- Last name -->
							<div style="margin-bottom: 25px" class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span>
								<form:input path="lastName" placeholder="last name (*)"
									class="form-control" /><br>
								<form:errors path="lastName" cssClass="error" />

							</div>

							<!-- name suffix -->
							<div style="margin-bottom: 25px" class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span>
								<form:input path="nameSuffix" placeholder="name suffix (*)"
									class="form-control" /><br>
								<form:errors path="nameSuffix" cssClass="error" />

							</div>

							<!-- Email -->
							<div style="margin-bottom: 25px" class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span>
								<form:input path="email" placeholder="email (*)"
									class="form-control" /><br>
								<form:errors path="email" cssClass="error" />

							</div>



							<!-- Register Button -->
							<div style="margin-top: 10px" class="form-group">
								<div class="col-sm-6 controls">
									<button type="submit" class="btn btn-primary">Register</button>
								</div>
							</div>

						</form:form>

					</div>

				</div>

			</div>

		</div>


					 	<!-- end -->				
					
				</p>
				<br>



			</div>
		</div>
	</div>





	<%@include file="common/common-footer1.jsp"%>



</body>
</html>