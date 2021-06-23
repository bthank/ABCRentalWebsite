# ABCRentalWebsite
 My ABCRentalWebsite Git repository
 by Binu Thankachan
 
 This is a dynamic website Spring MVC project built using the following technologies:
 - Java 8
 - Spring MVC
 - Spring Security using BCrypt password encryption
 - Servlets/JSP
 - HTML5/CSS3
 - JavaScript
 - jQuery
 - SQL utilizing a MySQL database
 - Hibernate ORM
 - JSTL
 - SpEL

 The website was built using the Spring MVC framework utilizing controllers and DAO patterns that communicate with a MySQL backend using a Hibernate ORM framework.  The website
 is secured using Spring Security authentication and authorization functionality utilizing user roles.  The view layer consists of JSP pages that are styled using CSS3.  
 
 A user is initially presented with a landing page where they can login or register for access.  If registering, they are initially given a default role of "RENTER" which is
 the role with the least access.  Administrators may change a user's role to any of 5 other roles: "CONTRACTOR", "EMPLOYEE", "MANAGER", "OWNER" or "ADMIN".  Spring Security
 functionality restricts access to parts of the website and specific functionality based on the user's role.  If a user attempts to access a restricted resource, they are
 presented with a custom access denied error page.
 
  
 
 The ABC Rental Property Management Website Creation project was entailed the following user stories:

 User Stories:
1.	Create standard layout to be shared by most/all website pages
2.	Create common header for website pages to generate similar look and feel for all pages
3.	Create common footer for website page to generate similar look and feel for all pages
4.	Create landing page
5.	Create Login page that is available to everyone, whether logged in or not
6.	Create Registration page that is available to everyone, whether logged in or not
7.	Add Spring Security functionality for authentication and authorization
8.	Add login functionality to the login page
9.	Add registration functionality to the registration page
10.	Add logout button functionality that is available from each user page, which will return user to the landing page.
11.	Create About Us page
12.	Create Contact Us page
13.	Create Privacy Notice page
14.	Create Terms of Use page
15.	Add links for About Us, Contact Us, Privacy Notice and Terms of Use to common footer
16.	Create the database schema.
17.	Create User table
18.	Create Roles table
19.	Create User Roles table
20.	Create Admin Profile table
21.	Create Contractor Profile table
22.	Create Employee Profile table
23.	Create Renter Profile table
24.	Create Manager Profile table
25.	Create Owner Profile table
26.	Create Contact Info table
27.	Create Employer Info table
28.	Create Personal Info table
29.	Create Address table
30.	Create Country table
31.	Create States or Provinces table
32.	Create Rental Properties table
33.	Create Rental Payments table
34.	Create Rental Repairs table
35.	Create Rental Unit Amenities table
36.	Create Renter Portal page
37.	Create Contractor Portal page
38.	Create Employee Portal page
39.	Create Admin Portal page
40.	Create Manager Portal page
41.	Create Owner Portal page
42.	Add ability to display the corresponding portal type page for the type of user role that is logged in
43.	Add a popup message on the landing page that reminds the user to visit their portal page for important information
44.	Create Manage Profiles page and grant access to all logged in users
  a.	Create subpage for Display functionality
  b.	Create subpage for Add functionality
  c.	Create subpage for Update functionality
  d.	Create subpage for Delete functionality	
45.	Create Manage Users page and grant access only to Admin users
  a.	Create subpage for Display functionality
  b.	Create subpage for Update User Access Level functionality
  c.	Create subpage for Delete functionality	
46.	Create Manage Rental Properties page and grant access to Admin and Manager users
  a.	Create subpage for Display functionality
  b.	Create subpage for Add functionality
  c.	Create subpage for Update functionality
  d.	Create subpage for Delete functionality	
47.	Create Manage Rental Payments page and grant access to Admin, Manager and Employee users
  a.	Create subpage for Display All Rental Payments functionality
  b.	Create subpage for Display Specific Rental Payments functionality based on search criteria
  c.	Create subpage for Add functionality
  d.	Create subpage for Update functionality
  e.	Create subpage for Delete functionality	
48.	Create Manage Rental Repairs page and grant access to Admin, Manager and Employee users
  a.	Create subpage for Display functionality
  b.	Create subpage for Add functionality
  c.	Create subpage for Update functionality
  d.	Create subpage for Delete functionality	
  e.	Grant access to the Add page to all users except contractors 
49.	Create Renter page option to allow downloading of renter lease agreement document
50.	Create Renter page option to allow downloading of renter parking agreement document
51.	Create Contractor page option to allow downloading of contractor agreement document

 
 
 
 
