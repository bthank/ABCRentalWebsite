<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">

<head>

<title>Login Page</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Reference Bootstrap files -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


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












<body class="container bg-light hero-image hero-text">

	<div>

		<div id="wrapper">
			<div id="header" style="text-align: center; font-weight: bold;">
				<h1 style="font-weight: bold; font-size: 4.5em;">ABC Rental Property Management</h1>

				
			</div>
		</div>
		<div id="container">

			<div>

				<div id="loginbox" style="margin-top: 50px;"
					class="mainbox col-md-4 col-md-offset-4 col-sm-8 col-sm-offset-2">

					<div class="panel panel-info">

						<div class="panel-heading">
							<div class="panel-title">Sign In</div>
						</div>

						<div style="padding-top: 30px" class="panel-body">

							<!-- Login Form -->
							<form
								action="${pageContext.request.contextPath}/authenticateTheUser"
								method="POST" class="form-horizontal">

								<!-- Place for messages: error, alert etc ... -->
								<div class="form-group">
									<div class="col-xs-15">
										<div>

											<!-- Check for login error -->

											<c:if test="${param.error != null}">

												<div class="alert alert-danger col-xs-offset-1 col-xs-10">
													Invalid username and password.</div>

											</c:if>

											<!-- Check for logout -->

											<c:if test="${param.logout != null}">

												<div class="alert alert-success col-xs-offset-1 col-xs-10">
													You have been logged out.</div>

											</c:if>

										</div>
									</div>
								</div>

								<!-- User name -->
								<div style="margin-bottom: 25px" class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input type="text"
										name="username" placeholder="username" class="form-control">
								</div>

								<!-- Password -->
								<div style="margin-bottom: 25px" class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-lock"></i></span> <input type="password"
										name="password" placeholder="password" class="form-control">
								</div>

								<!-- Login/Submit Button -->
								<div style="margin-top: 10px" class="form-group">
									<div class="col-sm-6 controls">
										<button type="submit" class="btn btn-success">Login</button>
									</div>
								</div>

								<!-- I'm manually adding tokens ... Bro! -->

								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />

							</form>

						</div>

					</div>

					<div>
						<a
							href="${pageContext.request.contextPath}/register/showRegistrationForm"
							class="btn btn-primary" role="button" aria-pressed="true">Register
							New User</a>
					</div>


					<div id="wrapper">
						<div id="footer" style="margin-top: 100px; text-align: center; font-weight: bold;">
							<p>
							<a href="${pageContext.request.contextPath}/about-us">About Us</a> &nbsp;&nbsp;&nbsp;
							<a href="${pageContext.request.contextPath}/contact-us">Contact Us</a> &nbsp;&nbsp;&nbsp;					
							© 2021
							</p>

							
						</div>
					</div>


				</div>




			</div>


		</div>




	</div>

	

<script
	src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</body>
</html>