# ABCRentalWebsite
 My ABCRentalWebsite Git repository
 by Binu Thankachan
 
 This is a dynamic website Spring MVC project built using the following technologies:
 - Java 8
 - Spring MVC
 - Spring Security
 - Servlets/JSP
 - HTML5/CSS3
 - JavaScript
 - SQL utilizing a MySQL database
 - Hibernate ORM
 - JSTL
 - SpEL

 The website was built using the Spring MVC framework utilizing controllers and DAO patterns that communicate with a MySQL backend using a Hibernate ORM framework.  The website
 is secured using Spring Security authentication and authorization functionality utilizing user roles.  The view layer consists of JSP pages that are styled using CSS3.  
 
 A user initially is presented with a landing page where they can login or register for access.  If registering, they are initially given a default role of "RENTER" which is
 the role with the least access.  Administrators may change a user's role to any of 5 other roles: "CONTRACTOR", "EMPLOYEE", "MANAGER", "OWNER" or "ADMIN".  Spring Security
 functionality restricts access to parts of the website and specific functionality based on the user's role.
 
 
 
 
