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
<ol>
 <li>As a property management company I would like to see a common layout for all website pages to give website users a consistent look and feel</li>
 <li>As a property management company I would like to see a common header for all website pages for a consistent look and feel throughout the website</li>
  <li>As a property management company I would like to see a common footer for all website pages for a consistent look and feel throughout the website</li>
  <li>As a user I would like to be greeted by a rental themed landing page</li> 
 <li>As a property management company I would like to see a login box on the landing page that is accessible by everyone</li>
 <li>As a property management company I would like to have a registration button on the landing page that is accessible to everyone</li>
<li>As a property management company I would like to see the website require login and authentication in order to access all pages except the landing page, registration page, About Us and Contact Us page</li>
 <li>As a property management company I would like to see a page available to everyone where they can register to gain login access to the website</li>
 <li>As a property management company I would like to see a logout button be available on every secured page which will log the user out and redirect them to the landing page</li>
 <li>As I user I would like to be able to view an About Us page that details information about the rental management company</li>
 <li>As a user I would like to see a Contact Us page which details information related to contacting the rental management company</li>
 <li>As a user I would like to see a Privacy Notice page that details privacy information related to the website</li>
 <li>As a user I would like to see a Terms of Use page that details website access and restriction information</li>
 <li>As a user I would like to see hyperlinks to the About Us, Contact Us, Privacy Notice and Terms of Use page in the website’s common footer</li>
 <li>As a property management company I would like newly registered users to be assigned a default role of Renter when they register for the website</li>
 <li>As a user I would like to be able to request the Admin to change my default role to 1 of 5 other roles: Contractor, Employee, Manager, Owner or Admin</li>
 <li>As a property management company I want Renter users to be able to add profile information applicable for Renter users</li>
 <li>As a property management company I want Contractor users to be able to add profile information applicable for Contractor users</li>
 <li>As a property management company I want Employee users to be able to add profile information applicable for Employee users</li>
 <li>As a property management company I want Manager users to be able to add profile information applicable for Manager users</li>
 <li>As a property management company I want Owner users to be able to add profile information applicable for Owner users</li>
 <li>As a property management company I want Admin users to be able to add profile information applicable for Admin users</li>
 <li>As a property management company I would like all users to enter a common set of contact information when creating their profile</li>
 <li>As a property management company I would like all users to enter a common set of employer information when creating their profile</li>
 <li>As a property management company I would like Renter users to enter a set of person details when creating their profile</li>
 <li>As a property management company I would like the profile contact information to include the individual’s address</li>
 <li>As a property management company I would like the profile employer information to include the employer’s address</li>
 <li>As a property management company I would like the Renter profile personal information to include an individual’s credit card billing address</li>
 <li>As a property management company I would like the user to have the ability to select the state for each address from a prepopulated list of US states</li>
 <li>As a property management company I want users to have the ability to display, add, update and delete Rental Property information stored in the database</li>
 <li>As a property management company I want users to have the ability to display, add, update and delete Rental Payment information stored in the database</li>
 <li>As a property management company I want users to have the ability to display, add, update and delete Rental Unit Amenity information stored in the database</li>
 <li>As a rental property management company I want Renter users to have their own Renter Portal page</li>
 <li>As a rental property management company I want Contractor users to have their own Contractor Portal page</li>
 <li>As a rental property management company I want Employee users to have their own Employee Portal page</li>
 <li>As a rental property management company I want Manager users to have their own Manager Portal page</li>
 <li>As a rental property management company I want Owner users to have their own Owner Portal page</li>
 <li>As a rental property management company I want Admin users to have their own Admin Portal page</li>
 <li>As a rental property management company I want the website to automatically make available the corresponding portal type page for the user role that is logged in</li>
 <li>As a rental property management company I want users to see a popup message on the home page that reminds the logged in user to visit their portal page for important information</li>
 <li>As a property management company, I want all logged in users to have access to a Manage Profiles page</li>
 <li>From the Manage Profiles page I would like logged in users to be able to access a subpage that will allow them to Display their profile</li>
 <li>From the Manage Profiles page I would like logged in users to be able to access a subpage that will allow them the ability to Add a profile</li>
 <li>From the Manage Profiles page I would like logged in users to be able to access a subpage that will allow them the ability to Update their profile</li>
 <li>From the Manage Profiles page I would like logged in users to be able to access a subpage that will allow them the ability to Update their profile</li>
 <li>As a property management company, I want Admin users to have access to an Administrator User Management page</li>
 <li>From the Administrator User Management page I would like Admin users to be able to access a subpage that will allow them to Display all users</li>
 <li>From the Administrator User Management page I would like Admin users to be able to access a subpage that will allow them to Update the Access Level for specific users</li>
 <li>From the Administrator User Management page I would like Admin users to be able to access a subpage that will allow them to Delete specific users</li>
 <li>As a property management company I would like Admin and Manager users to have access to a Manage Rental Properties page</li>
 <li>From the Manage Rental Properties page I would like them to be able to access a subpage that will allow them to Display rental properties</li>
 <li>From the Manage Rental Properties page I would like them to be able to access a subpage that will allow them the ability to Add a rental property</li>
 <li>From the Manage Rental Properties page I would like them to be able to access a subpage that will allow them the ability to Update a rental property</li>
 <li>From the Manage Rental Properties page I would like them to be able to access a subpage that will allow them the ability to Update a rental property</li>
 <li>As a rental property management company, I would like a Renter page option to allow downloading of a renter lease agreement document</li>
 <li>As a rental property management company, I would like a Renter page option to allow downloading of a renter parking agreement document</li>
 <li>As a rental property management company, I would like a Contractor page option to allow downloading of a contractor agreement document</li>


<h2>Database Schema:</h 2>
 <br><br>
 <img src="https://user-images.githubusercontent.com/28652664/123499172-bcc15e80-d602-11eb-9f27-f357b16ae5c9.png"/>



 <h2>Workflow Diagram:</h2>
 <br><br>
 <img src="https://user-images.githubusercontent.com/28652664/123499209-10cc4300-d603-11eb-99a5-087b53de12a5.png"/>



<h2>About the Website:</h2>
 <br><br>
 <h3>Landing Page with Spring Security authentication</h3>
<br><br>
<img src="https://user-images.githubusercontent.com/28652664/123499637-1aa37580-d606-11eb-9591-1673687929e1.png"/>
 <br><br>
 <h3>Registration Page</h3>
<br><br>
<img src="https://user-images.githubusercontent.com/28652664/123499654-3f97e880-d606-11eb-8b91-919275550c3f.png"/><br><br>
 <br><br>
 <h3>Roles Used</h3>
<br><br>
<img src="https://user-images.githubusercontent.com/28652664/123499697-9271a000-d606-11eb-822d-28fa86d0d53d.png"/><br><br>
  <br><br>
 <h3>Home page after successful login for a Renter user</h3>
<br><br>
<img src="https://user-images.githubusercontent.com/28652664/123499714-b634e600-d606-11eb-823f-646d06444648.png"/><br><br>
   <br><br>
 <h3>Add Renter Profile page</h3>
<br><br>
<img src="https://user-images.githubusercontent.com/28652664/123499772-0b70f780-d607-11eb-9c9a-0fd4f0a2db96.png"/><br><br>
   <br><br>
 <h3>Java Server Side form validation</h3>
<br><br>
<img src="https://user-images.githubusercontent.com/28652664/123499811-42dfa400-d607-11eb-9551-cffb57fe031b.png"/><br><br>
    <br><br>
 <h3>Display Renter Profile page</h3>
<br><br>
<img src="https://user-images.githubusercontent.com/28652664/123499825-660a5380-d607-11eb-904a-95344f6e51b5.png"/><br><br>
    <br><br>
 <h3>Update Renter Profile page</h3>
<br><br>
<img src="https://user-images.githubusercontent.com/28652664/123499863-b681b100-d607-11eb-8835-157cbe829abe.png"/><br><br>
   <br><br>
 <h3>Add Rental Repair page</h3>
<br><br>
<img src="https://user-images.githubusercontent.com/28652664/123499914-03658780-d608-11eb-805c-5e5e36caa4cf.png"/><br><br>
   <br><br>
 <h3>About Us page</h3>
<br><br>
<img src="https://user-images.githubusercontent.com/28652664/123500136-d5814280-d609-11eb-9ac9-c0b4ec512a9f.png"/><br><br>
    <br><br>
 <h3>Contact Us page</h3>
<br><br>
<img src="https://user-images.githubusercontent.com/28652664/123500148-f0ec4d80-d609-11eb-80d3-d4e37ef663a2.png"/><br><br>
