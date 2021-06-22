<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>ABC Rental Property Management - Display Rental Repairs</title>
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
	href="${pageContext.request.contextPath}/resources/css/table-display.css"
	type="text/css" />


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

h2 {
	font-weight: bold;
}

.intro {
	height: 100%;
	margin: 20px 20px 20px 20px;
}

.gradient-custom {
	/* fallback for old browsers */
	
}
</style>
</head>
<body>

	<%@include file="../../common/common-header1.jsp"%>




	<div class="bg-image h-100"
		style="background-size: fill; background-image: url('https://images.pexels.com/photos/1454805/pexels-photo-1454805.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=1&amp;w=500');">




		<br>
		<br>
		<br>
		<br>



		<div class="container">
			<h2>Rental Repairs</h2>


			<br>
			<br>
			<div class="table-responsive">
				<table class="table table-hover table-striped table-dark">
					<thead>
						<tr>
							<th>Rental Repair Id</th>
							<th>Submitted By Id</th>
							<th>Submitted On</th>
							<th>Rental Property Id</th>
							<th>Rental Unit No</th>
							<th>Repair Type</th>
							<th>Description</th>
							<th>Status</th>
							<th>Completed On</th>
							<th>Root Cause</th>
							<th>Repair Cost Estimate</th>
							<th>Repair Cost Actual</th>
							<th>Assigned to Contractor Id</th>
							<th>Comments</th>


						</tr>
					</thead>
					<tbody>

						<c:forEach var="repair" items="${rentalRepairList}">

							<tr>
								<td>${repair.id}</td>
								<td>${repair.submittedByUserId}</td>
								<td>${repair.submittedDate}</td>
								<td>${repair.rentalPropertyId}</td>
								<td>${repair.rentalUnitNo}</td>
								<td>${repair.rentalRepairType}</td>
								<td>${repair.description}</td>
								<td>${repair.repairStatus}</td>
								<td>${repair.completionDate}</td>
								<td>${repair.rootCause}</td>
								<td>${repair.repairCostEstimate}</td>
								<td>${repair.repairCostActual}</td>
								<td>${repair.assignedToContractorId}</td>
								<td>${repair.comment}</td>

							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>
		</div>





		<br>
		<br>
		<br>
		<br>


	</div>
	<%@include file="../../common/common-footer1.jsp"%>


</body>
</html>