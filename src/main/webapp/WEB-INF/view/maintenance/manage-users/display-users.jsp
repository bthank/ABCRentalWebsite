<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>ABC Rental Property Management - Display Users</title>
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
	
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/table-display.css" type="text/css"/>


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

<!-- 	<div class="bg-image h-100"
		style="background-image: url('https://mdbootstrap.com/img/Photos/new-templates/search-box/img4.jpg');"> -->
<!-- 	<div class="bg-image h-100"
		style="background-repeat: no-repeat;
  background-size: cover; background-image: url('https://images.unsplash.com/photo-1531835551805-16d864c8d311?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTV8fGFwYXJ0bWVudHxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60');">
 -->
	<div class="bg-image h-100"
		style="background-repeat: no-repeat;
  background-size: cover; background-image: url('https://images.unsplash.com/photo-1539922631499-09155cc609a4?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzJ8fGFwYXJ0bWVudHxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60');">


	<br><br><br><br>
	


<div class="container">
  <h2>ABC Rental Property Management Website Users</h2>

  
  <br><br>
  <div class="table-responsive">          
  <table class="table table-hover table-striped table-dark">
    <thead>
      <tr>
        <th>User Id</th>
        <th>Username</th>
        <th>Password</th>
        <th>Name Prefix</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Name Suffix</th>
        <th>Email</th>
        <th>User Creation Date</th>
        <th>Access Level</th>
        <th>First and Last Name</th>
        <th>Full Name</th>
      </tr>
    </thead>
    <tbody>
    
		<c:forEach var="usr" items="${userList}">
	
 	      <tr>
	        <td>${usr.id}</td>
	        <td>${usr.userName}</td>
	        <td>${usr.password}</td>
	        <td>${usr.namePrefix}</td>
	        <td>${usr.firstName}</td>
	        <td>${usr.lastName}</td>
	        <td>${usr.nameSuffix}</td>
	        <td>${usr.email}</td>
	        <td>${usr.creationDate}</td>
	        <td>${usr.accessLevel}</td>
	        <td>${usr.firstAndLastName}</td>
	        <td>${usr.fullName}</td>
	      </tr>
		</c:forEach>
      
      
    </tbody>
  </table>
  </div>
</div>





	<br><br><br><br>

</div>

	<%@include file="../../common/common-footer1.jsp"%>


</body>
</html>