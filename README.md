# ABCRentalWebsite
 ABCRentalWebsite Git repository <br>
 by Binu Thankachan
  <br> <br>
 This is a dynamic website Spring MVC project built using the following technologies:
 - Java 8
 - Spring MVC
 - Spring Security using BCrypt password encryption
 - Servlets/JSP
 - HTML5/CSS3/Bootstrap
 - JavaScript
 - jQuery
 - SQL utilizing a MySQL database
 - Hibernate ORM
 - JSTL
 - SpEL
 <br>
 The website was built using the Spring MVC framework utilizing controllers and DAO patterns that communicate with a MySQL backend using a Hibernate ORM framework.  The website
 is secured using Spring Security authentication and authorization functionality utilizing user roles.  The view layer consists of JSP pages that are styled using CSS3.  
 <br> <br>
 A user is initially presented with a landing page where they can login or register for access.  If registering, they are initially given a default role of "RENTER" which is
 the role with the least access.  Administrators may change a user's role to any of 5 other roles: "CONTRACTOR", "EMPLOYEE", "MANAGER", "OWNER" or "ADMIN".  Spring Security
 functionality restricts access to parts of the website and specific functionality based on the user's role.  If a user attempts to access a restricted resource, they are
 presented with a custom access denied error page.
 
  
 <br> <br>
 <h2>User Stories:</h2>
<br> <br>
1.	As a property management company I would like to see a common layout for all website pages to give website users a consistent look and feel
2.	As a property management company I would like to see a common header for all website pages for a consistent look and feel throughout the website
3.	As a property management company I would like to see a common footer for all website pages for a consistent look and feel throughout the website
4.	As a user I would like to be greeted by a rental themed landing page
5.	As a property management company I would like to see a login box on the landing page that is accessible by everyone
6.	As a property management company I would like to have a registration button on the landing page that is accessible to everyone
7.	As a property management company I would like to see the website require login and authentication in order to access all pages except the landing page, registration page, About Us and Contact Us page
8.	As a property management company I would like to see a page available to everyone where they can register to gain login access to the website
9.	As a property management company I would like to see a logout button be available on every secured page which will log the user out and redirect them to the landing page
10.	As I user I would like to be able to view an About Us page that details information about the rental management company
11.	As a user I would like to see a Contact Us page which details information related to contacting the rental management company
12.	As a user I would like to see a Privacy Notice page that details privacy information related to the website
13.	As a user I would like to see a Terms of Use page that details website access and restriction information
14.	As a user I would like to see hyperlinks to the About Us, Contact Us, Privacy Notice and Terms of Use page in the website’s common footer
15.	As a property management company I would like newly registered users to be assigned a default role of Renter when they register for the website
16.	As a user I would like to be able to request the Admin to change my default role to 1 of 5 other roles: Contractor, Employee, Manager, Owner or Admin
17.	As a property management company I want Renter users to be able to add profile information applicable for Renter users
18.	As a property management company I want Contractor users to be able to add profile information applicable for Contractor users
19.	As a property management company I want Employee users to be able to add profile information applicable for Employee users
20.	As a property management company I want Manager users to be able to add profile information applicable for Manager users
21.	As a property management company I want Owner users to be able to add profile information applicable for Owner users
22.	As a property management company I want Admin users to be able to add profile information applicable for Admin users
23.	As a property management company I would like all users to enter a common set of contact information when creating their profile
24.	As a property management company I would like all users to enter a common set of employer information when creating their profile
25.	As a property management company I would like Renter users to enter a set of person details when creating their profile
26.	As a property management company I would like the profile contact information to include the individual’s address
27.	As a property management company I would like the profile employer information to include the employer’s address 
28.	As a property management company I would like the Renter profile personal information to include an individual’s credit card billing address  
29.	As a property management company I would like the user to have the ability to select the state for each address from a prepopulated list of US states
30.	As a property management company I want users to have the ability to display, add, update and delete Rental Property information stored in the database
31.	As a property management company I want users to have the ability to display, add, update and delete Rental Payment information stored in the database
32.	As a property management company I want users to have the ability to display, add, update and delete Rental Unit Amenity information stored in the database
33.	As a rental property management company I want Renter users to have their own Renter Portal page
34.	As a rental property management company I want Contractor users to have their own Contractor Portal page
35.	As a rental property management company I want Employee users to have their own Employee Portal page
36.	As a rental property management company I want Manager users to have their own Manager Portal page
37.	As a rental property management company I want Owner users to have their own Owner Portal page
38.	As a rental property management company I want Admin users to have their own Admin Portal page
39.	As a rental property management company I want the website to automatically make available the corresponding portal type page for the user role that is logged in
40.	As a rental property management company I want users to see a popup message on the home page that reminds the logged in user to visit their portal page for important information
41.	As a property management company, I want all logged in users to have access to a Manage Profiles page
42.	From the Manage Profiles page I would like logged in users to be able to access a subpage that will allow them to Display their profile
43.	From the Manage Profiles page I would like logged in users to be able to access a subpage that will allow them the ability to Add a profile
44.	From the Manage Profiles page I would like logged in users to be able to access a subpage that will allow them the ability to Update their profile
45.	From the Manage Profiles page I would like logged in users to be able to access a subpage that will allow them the ability to Update their profile
46.	As a property management company, I want Admin users to have access to an Administrator User Management page
47.	From the Administrator User Management page I would like Admin users to be able to access a subpage that will allow them to Display all users
48.	From the Administrator User Management page I would like Admin users to be able to access a subpage that will allow them to Update the Access Level for specific users
49.	From the Administrator User Management page I would like Admin users to be able to access a subpage that will allow them to Delete specific users
50.	As a property management company I would like Admin and Manager users to have access to a Manage Rental Properties page
51.	From the Manage Rental Properties page I would like them to be able to access a subpage that will allow them to Display rental properties
52.	From the Manage Rental Properties page I would like them to be able to access a subpage that will allow them the ability to Add a rental property
53.	From the Manage Rental Properties page I would like them to be able to access a subpage that will allow them the ability to Update a rental property
54.	From the Manage Rental Properties page I would like them to be able to access a subpage that will allow them the ability to Update a rental property
55.	As a rental property management company, I would like a Renter page option to allow downloading of a renter lease agreement document
56.	As a rental property management company, I would like a Renter page option to allow downloading of a renter parking agreement document
57.	As a rental property management company, I would like a Contractor page option to allow downloading of a contractor agreement document




<h2>Database Schema:</h 2>
 <br><br>
 ![image](https://user-images.githubusercontent.com/28652664/123499172-bcc15e80-d602-11eb-9f27-f357b16ae5c9.png)


 <h2>Workflow Diagram:</h2>
 <br><br>
 ![image](https://user-images.githubusercontent.com/28652664/123499209-10cc4300-d603-11eb-99a5-087b53de12a5.png)


<h2>Website Images:</h2>
<br><br>





 
 
 
 
