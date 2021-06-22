<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>ABC Rental Property Management Admin Page</title>
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
</style>
</head>


<body>

<%@include file="../common/common-header1.jsp" %>






	<div class="container" style="margin-top: 30px">
		<div class="row">
			<div class="col-sm-4">
				<h2>Admin training weekend</h2>
				<h5>October 9-10, 2021</h5>
				<div class="box box3">
					<img alt="Myrtle Beach SC image"
						src="https://images.unsplash.com/photo-1453872302360-eed3c5f8ff66?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NjR8fG15cnRsZSUyMGJlYWNoJTIwc291dGglMjBjYXJvbGluYXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60">

				</div>
				<p>
					See you all at the next Admin training weekend on October 9-10, 2021
					in Myrtle Beach, SC! <br><br> Don't forget to RSVP by July 30th.
				</p>





				<h3>Admin 101:</h3>

				<ul class="nav nav-pills flex-column">
					<li class="nav-item"><a class="nav-link active"
						href="https://www.blackbaud.com/support/howto/coveo/luminate-online/Subsystems/Luminate_CMS/Concepts/Admin_CMS_Website_Administrator_Role.html#:~:text=A%20Website%20Administrator%20has%20a,Create%20and%20manage%20content%20types">Website Administrator Role</a></li>
					<li class="nav-item"><a class="nav-link"
						href="https://www.whitehatsec.com/glossary/content/website-administration">Website Administration - Whitehat Security</a></li>
					<li class="nav-item"><a class="nav-link"
						href="https://owasp.org/www-project-top-ten/">OWASP Top Ten Web Application Security Risks | OWASP</a></li>
					<li class="nav-item"><a class="nav-link"
						href="https://us-cert.cisa.gov/ncas/tips/ST18-006">Website Security | CISA</a></li>
				</ul>
				<hr class="d-sm-none">
			</div>
			<div class="col-sm-8">
				<h2><a href="https://owasp.org/www-project-top-ten/">OWASP Top Ten Web Application Security Risks | OWASP</a></h2>
				<h5>The risks every site administrator should be aware of</h5>
				<div class="box box3">
					<img alt="website"
						src="https://images.unsplash.com/photo-1555949963-ff9fe0c870eb?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTAyfHxjb2RlfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60">
				</div>
				<p></p>
				<p>The OWASP Top 10 is a standard awareness document for developers and web application security. It represents a broad consensus about the most critical security risks to web applications.</p>
				<p>Companies should adopt this document and start the process of ensuring that their web applications minimize these risks. Using the OWASP Top 10 is perhaps the most effective first step towards changing the software development culture within your organization into one that produces more secure code.</p>
				<br>



				<h2><a href="https://www.synopsys.com/glossary/what-is-web-application-security.html">Web Application Security</a></h2>
				<h5>The what and why of web application security</h5>
				<div class="box box3">
					<img alt="computer image"
						src="https://images.unsplash.com/photo-1461749280684-dccba630e2f6?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTF8fHdlYnNpdGUlMjBhZG1pbnxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60">
				</div>
				<p></p>
				<p>Web application security (also known as Web AppSec) is the idea of building websites to function as expected, even when they are under attack. The concept involves a collection of security controls engineered into a Web application to protect its assets from potentially malicious agents.

Web applications, like all software, inevitably contain defects. Some of these defects constitute actual vulnerabilities that can be exploited, introducing risks to organizations. Web application security defends against such defects. It involves leveraging secure development practices and implementing security measures throughout the software development life cycle (SDLC), ensuring that design-level flaws and implementation-level bugs are addressed.</p>
			</div>
		</div>
	</div>




	
	





<%@include file="../common/common-footer1.jsp" %>


</body>

</html>









