<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	
<!DOCTYPE html>
<html lang="en">
<head>
  <title>ABC Rental Property Management Home Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
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

.fas{
     
    background: radial-gradient(white 50%, transparent 50%);
}

li {
	font-weight: bold;
	color: white;
}

nav {
	text-align: center;

}

 
  </style>
</head>
<body>

<div class="jumbotron text-center" style="margin-bottom:0">
  <h1>ABC Rental Property Management Home Page</h1>
  <p>Welcome, ${user.firstName}!</p> 
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/">
  	<span class="fa-stack fa-lg">
  		<i class="fa fa-home fa-stack-2x"></i>
	</span>
</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/"></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/">My Profile</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/">Rental Documents</a>
      </li>
      
      
      	<security:authorize access="hasRole('RENTER')">
      
           	<li class="nav-item">
   			<!-- Add a link to point to /renter ... this is for the renters -->
				<a class="nav-link" href="${pageContext.request.contextPath}/renter">Renter Portal&nbsp;</a>
			</li>
		</security:authorize>
        
  		<security:authorize access="hasRole('CONTRACTOR')">
           	<li class="nav-item"> 		
			<!-- Add a link to point to /contractor ... this is for the contractors -->
				<a class="nav-link" href="${pageContext.request.contextPath}/contractor">Contractor Portal&nbsp;</a>
			</li>
		</security:authorize>

		<security:authorize access="hasRole('EMPLOYEE')">
			<li class="nav-item"> 		
			<!-- Add a link to point to /employee ... this is for the employees -->
				<a class="nav-link" href="${pageContext.request.contextPath}/employee">Employee Portal&nbsp;</a>
			</li>
		</security:authorize>

		<security:authorize access="hasRole('MANAGER')">
			<li class="nav-item"> 		
			<!-- Add a link to point to /manager ... this is for the managers -->
				<a class="nav-link" href="${pageContext.request.contextPath}/manager">Manager Portal&nbsp;</a>
			</li>
		</security:authorize>

		<security:authorize access="hasRole('ADMIN')">
			<li class="nav-item"> 		
 			<!-- Add a link to point to /admin ... this is for the admins -->
 				<a class="nav-link" href="${pageContext.request.contextPath}/admin">Admin Portal&nbsp;</a>
			</li>
 		</security:authorize>

		<security:authorize access="hasRole('OWNER')">
			<li class="nav-item"> 		
			<!-- Add a link to point to /owner ... this is for the owners -->
 				<a class="nav-link" href="${pageContext.request.contextPath}/owner">Owner Portal&nbsp;</a>
			</li>
 		</security:authorize>
        
      <li class="nav-item">
        <form:form action="${pageContext.request.contextPath}/logout"
			method="POST">
			&nbsp;<input type="submit" value="Logout" />
		</form:form>
      </li>    

    </ul>
  </div>  
</nav>

<div class="container" style="margin-top:30px">
  <div class="row">
    <div class="col-sm-4">
      <h2>Owner Profile</h2>
      <h5>John Cassivedas:</h5>
      <div class="box box1">
      	      	<img alt="person image" src="https://images.unsplash.com/flagged/photo-1570612861542-284f4c12e75f?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cGVyc29ufGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60">
      	
      	</div>
     	 <p>			
     	 	Rental owner/operater since 2014.
			<br>
			<br> Owns 24 rental units.
			<br>
			<br> Is a licensed Real Estate agent in PA.
			<br>
			<br> if you know of anyone needing a rental property, have them contact me at:
			<br>
			<br> Office #: 1-901-234-1781.
			<br> Email: johncassivedas@abcrentals.com					
		</p>
      
      
      
      
      
      <h3>Renting 101:</h3>
      
      <ul class="nav nav-pills flex-column">
        <li class="nav-item">
          <a class="nav-link active" href="https://www.consumer.gov/articles/1024-renting-apartment-or-house">Things to know about renting an apartment or house</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="https://www.mymove.com/moving/guides/renting-apartment-guide/">Guide to renting an apartment</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="https://www.investopedia.com/financial-edge/1112/reasons-renting-is-better-than-buying.aspx">10 Reasons Why Renting Could Be Better Than Buying</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="https://www.libertymutual.com/property-insurance/renters">Rental Insurance</a>
        </li>
      </ul>
      <hr class="d-sm-none">
    </div>
    <div class="col-sm-8">
      <h2>Our newest property, Willow Woods Apartments</h2>
      <h5>Upscale apartments at 1200 Whistler Way, Devon, PA</h5>
      <div class="box box2"><img alt="apartment complex" src="https://images.unsplash.com/photo-1460317442991-0ec209397118?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8YXBhcnRtZW50fGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"></div>
      <p>


	  </p>
      <p>Situated in the heart of the Main Line, Willow Woods boasts 24 immaculate, ready to move in apartment suites.
         Teeming with state of the art amenities, large floorplans and even a clubhouse and pool, this is one beautiful complex
         that anyone would be proud to call home.
         Minutes from the PA Turnpike and 476, and within a 1/2 hour of Philadelphia, it is centrally located to everything
         one could desire. Don't procrastinate or all of these units will be gone before you know it! 
       </p>
      <br>
      
      
      
      <h2>In March 2021 we purchased 36 units at Remington Suites</h2>
      <h5>Upscale living at it's finest at 900 Eaton Way, Exton PA</h5>
      <div class="box box2"><img alt="apartment complex" src="https://images.unsplash.com/photo-1594484208280-efa00f96fc21?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8YXBhcnRtZW50JTIwYnVpbGRpbmd8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"></div>
      <p> </p>
      <p>Designed by one of the Main Line's premier builders, Remington Suites boasts 36 of the finest, upscale apartment suites money can buy.
         Teeming with state of the art amenities, large floorplans and even a clubhouse and pool, this is one beautiful complex
         that anyone would be proud to call home.
         Minutes from the PA Turnpike and 476, and within a 1/2 hour of Philadelphia, it is centrally located to everything
         one could desire. Don't procrastinate or all of these units will be gone before you know it!       
      </p>
    </div>
  </div>
</div>

<div class="jumbotron text-center" style="margin-bottom:0">
  <p>Terms of Use &nbsp;&nbsp; Privacy Notice&nbsp;&nbsp; © 2021</p>
</div>

</body>
</html>
