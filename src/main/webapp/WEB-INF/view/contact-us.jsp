<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page
	import="com.abcrentals.binu.thankachan.entity.StateOrProvince,java.util.List"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>ABC Rental Property Management - Contact Us</title>
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


	<%@include file="common/common-header1.jsp"%>




	<div class="bg-image h-100"
		style="background-image: url('https://mdbootstrap.com/img/Photos/new-templates/search-box/img4.jpg');">


		<section class="intro">
			<div class="mask d-flex align-items-center h-100 gradient-custom">
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-12 col-lg-9 col-xl-7">
							<div class="card">
								<div class="card-body p-4 p-md-5">
									<h2 class="mb-4 pb-2">Contact Us</h2>


									<div class="row">
										<div class="col-md-6 mb-4">

											<div class="form-outline">
											
											<p><img alt="Office" src="https://images.unsplash.com/photo-1604328727766-a151d1045ab4?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTU1fHxvZmZpY2V8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"></p>


											<h3>ABC Rental Property Management</h3>
											<p>Suite 300</p>
											<p>127 Westmont Drive</p>
											<p>Flint, MI 39023</p>
											<p>Office #: 1-(382) 349-7700</p>											
	 

											</div>

										</div>
										<div class="col-md-6 mb-4">

											<div class="form-outline">
 
											</div>

										</div>
									</div>








								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>



	</div>



	<%@include file="common/common-footer1.jsp"%>





</body>
</html>