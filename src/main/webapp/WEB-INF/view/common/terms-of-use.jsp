<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page
	import="com.abcrentals.binu.thankachan.entity.StateOrProvince,java.util.List"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>ABC Rental Property Management - Terms of Use</title>
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


	<%@include file="common-header1.jsp"%>




	<div class="bg-image h-100"
		style="background-image: url('https://mdbootstrap.com/img/Photos/new-templates/search-box/img4.jpg');">


		<section class="intro">
			<div class="mask d-flex align-items-center h-100 gradient-custom">
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-12 col-lg-9 col-xl-7">
							<div class="card">
								<div class="card-body p-4 p-md-5">
									<h3 class="mb-4 pb-2">Terms of Use</h3>


									<div class="row">
										<div class="col-md-6 mb-4">

											<div class="form-outline">

												<p>Nullam viverra suscipit metus quis fermentum.
													Maecenas lacus est, malesuada non sodales sed, bibendum
													placerat orci. Aenean semper odio sed erat rhoncus, id
													bibendum leo efficitur. Vestibulum ante ipsum primis in
													faucibus orci luctus et ultrices posuere cubilia curae;
													Curabitur fermentum feugiat ante eu vulputate. Nam a
													pretium nisl. Nullam non accumsan nunc. Mauris vitae neque
													nulla. Curabitur finibus eu nisi eget euismod. Nulla eu
													libero in ex vulputate semper. Praesent pellentesque quam
													faucibus, dictum lorem ac, euismod velit.</p>
												<p>Praesent porttitor lectus a augue dapibus ultricies.
													Aliquam odio urna, congue consequat eleifend vitae, mattis
													sodales felis. Duis congue, dolor eu faucibus eleifend, est
													sapien placerat nisl, ac dignissim dui lorem eu eros.
													Suspendisse potenti. Proin tincidunt egestas odio. Vivamus
													at odio vel leo suscipit dignissim. Donec in molestie
													lorem. Praesent velit odio, hendrerit a faucibus nec,
													aliquet id sapien. Ut elit nibh, finibus eu risus non,
													venenatis fringilla metus. In eu dui massa. Sed tristique
													sagittis ligula vel bibendum.</p>


											</div>

										</div>
										<div class="col-md-6 mb-4">

											<div class="form-outline">
												<p>Nullam viverra suscipit metus quis fermentum.
													Maecenas lacus est, malesuada non sodales sed, bibendum
													placerat orci. Aenean semper odio sed erat rhoncus, id
													bibendum leo efficitur. Vestibulum ante ipsum primis in
													faucibus orci luctus et ultrices posuere cubilia curae;
													Curabitur fermentum feugiat ante eu vulputate. Nam a
													pretium nisl. Nullam non accumsan nunc. Mauris vitae neque
													nulla. Curabitur finibus eu nisi eget euismod. Nulla eu
													libero in ex vulputate semper. Praesent pellentesque quam
													faucibus, dictum lorem ac, euismod velit.</p>
												<p>Praesent porttitor lectus a augue dapibus ultricies.
													Aliquam odio urna, congue consequat eleifend vitae, mattis
													sodales felis. Duis congue, dolor eu faucibus eleifend, est
													sapien placerat nisl, ac dignissim dui lorem eu eros.
													Suspendisse potenti. Proin tincidunt egestas odio. Vivamus
													at odio vel leo suscipit dignissim. Donec in molestie
													lorem. Praesent velit odio, hendrerit a faucibus nec,
													aliquet id sapien. Ut elit nibh, finibus eu risus non,
													venenatis fringilla metus. In eu dui massa. Sed tristique
													sagittis ligula vel bibendum.</p>

											</div>

										</div>
									</div>





									<div class="row">
										<div class="col-md-12 mb-8">
											<hr><br><br>
										</div>
										<div class="col-md-6 mb-4">

											<div class="form-outline">

												<p>Nullam viverra suscipit metus quis fermentum.
													Maecenas lacus est, malesuada non sodales sed, bibendum
													placerat orci. Aenean semper odio sed erat rhoncus, id
													bibendum leo efficitur. Vestibulum ante ipsum primis in
													faucibus orci luctus et ultrices posuere cubilia curae;
													Curabitur fermentum feugiat ante eu vulputate. Nam a
													pretium nisl. Nullam non accumsan nunc.  </p>
												<p>  Proin tincidunt egestas odio. Vivamus
													at odio vel leo suscipit dignissim. Donec in molestie
													lorem. Praesent velit odio, hendrerit a faucibus nec,
													aliquet id sapien. Ut elit nibh, finibus eu risus non,
													venenatis fringilla metus. In eu dui massa. Sed tristique
													sagittis ligula vel bibendum.</p>


											</div>

										</div>
										<div class="col-md-6 mb-4">

											<div class="form-outline">
												<p>Nullam viverra suscipit metus quis fermentum.
													Maecenas lacus est, malesuada non sodales sed, bibendum
													placerat orci. Aenean semper odio sed erat rhoncus, id
													bibendum leo efficitur. Vestibulum ante ipsum primis in
													faucibus orci luctus et ultrices posuere cubilia curae;
													Curabitur fermentum feugiat ante eu vulputate.  </p>
												<p>Praesent porttitor lectus a augue dapibus ultricies.
													  Vivamus
													at odio vel leo suscipit dignissim. Donec in molestie
													lorem. Praesent velit odio, hendrerit a faucibus nec,
													aliquet id sapien. Ut elit nibh, finibus eu risus non,
													venenatis fringilla metus. In eu dui massa. Sed tristique
													sagittis ligula vel bibendum.</p>

											</div>

										</div>
									</div>



									<div class="row">
										<div class="col-md-12 mb-8">
											<hr><br><br>
										</div>
										<div class="col-md-6 mb-4">

											<div class="form-outline">

												<p> Aenean semper odio sed erat rhoncus, id
													bibendum leo efficitur. Vestibulum ante ipsum primis in
													faucibus orci luctus et ultrices posuere cubilia curae;
													Curabitur fermentum feugiat ante eu vulputate. Nam a
													pretium nisl. Nullam non accumsan nunc. Mauris vitae neque
													nulla. Curabitur finibus eu nisi eget euismod. Nulla eu
													libero in ex vulputate semper. Praesent pellentesque quam
													faucibus, dictum lorem ac, euismod velit.</p>
												<p>Praesent porttitor lectus a augue dapibus ultricies.
													Aliquam odio urna, congue consequat eleifend vitae, mattis
													sodales felis. Duis congue, dolor eu faucibus eleifend, est
													sapien placerat nisl, ac dignissim dui lorem eu eros.
													Suspendisse potenti. Proin tincidunt egestas odio. Vivamus
													at odio vel leo suscipit dignissim. Donec in molestie
													lorem. Praesent velit odio, hendrerit a faucibus nec,
													aliquet id sapien.   In eu dui massa. Sed tristique
													sagittis ligula vel bibendum.</p>


											</div>

										</div>
										<div class="col-md-6 mb-4">

											<div class="form-outline">
												<p>Nullam viverra suscipit metus quis fermentum.
													Maecenas lacus est, malesuada non sodales sed, bibendum
													placerat orci. Aenean semper odio sed erat rhoncus, id
													bibendum leo efficitur. Vestibulum ante ipsum primis in
													faucibus orci luctus et ultrices posuere cubilia curae;
													Curabitur fermentum feugiat ante eu vulputate. Nam a
													pretium nisl. Nullam non accumsan nunc. Mauris vitae neque
													nulla. Curabitur finibus eu nisi eget euismod. Nulla eu
													libero in ex vulputate semper. Praesent pellentesque quam
													faucibus, dictum lorem ac, euismod velit.</p>
												<p>Praesent porttitor lectus a augue dapibus ultricies.
													Aliquam odio urna, congue consequat eleifend vitae, mattis
													sodales felis. Duis congue, dolor eu faucibus eleifend, est
													sapien placerat nisl, ac dignissim dui lorem eu eros.
													Suspendisse potenti. Proin tincidunt egestas odio. Vivamus
													at odio vel leo suscipit dignissim. Donec in molestie
													lorem. Praesent velit odio, hendrerit a faucibus nec,
													aliquet id sapien. Ut elit nibh, finibus eu risus non,
													venenatis fringilla metus. In eu dui massa. Sed tristique
													sagittis ligula vel bibendum.</p>

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



	<%@include file="common-footer1.jsp"%>





</body>
</html>