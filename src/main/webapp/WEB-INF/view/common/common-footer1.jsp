<div style="height: 5%; bottom: 0; position: relative;">

	<div class="jumbotron text-center" style="margin-bottom:0">
	  <p style="font-weight: bold; font-size: 80%;">
	  
	  <a href="${pageContext.request.contextPath}/about-us">About Us</a> &nbsp;&nbsp;&nbsp;
	  <a href="${pageContext.request.contextPath}/contact-us">Contact Us</a> &nbsp;&nbsp;&nbsp;					

	<security:authorize access="hasAnyRole('ADMIN','RENTER','CONTRACTOR','EMPLOYEE','MANAGER','OWNER')">
	  
		  <a href="${pageContext.request.contextPath}/privacy-notice">Privacy Notice</a> &nbsp;&nbsp;&nbsp; 
		  <a href="${pageContext.request.contextPath}/terms-of-use">Terms of Use</a>&nbsp;&nbsp;&nbsp; 
	  </security:authorize>
	  © 2021</p>
	</div>
</div>