<div id="header" style="background-color: blue; height: 20%;">

	<div class="jumbotron text-center" style="margin-bottom: 0">
		<h1 style="font-weight: bold;">ABC Rental Property Management</h1>
		<br>
		<h5 style="color: red; font-weight: bold; font-size: 2em;">Welcome
			${user.firstName}!</h5>
	</div>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/" style="margin-left: 50px;">
			<span class="fa-stack fa-lg"> <i
				class="fa fa-home fa-stack-2x"></i>
		</span>
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">


				<security:authorize access="hasAnyRole('ADMIN','RENTER','CONTRACTOR','EMPLOYEE','MANAGER','OWNER')">
			
					<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/profile/showManageProfilesPage">Manage
						Profiles </a></li>
				</security:authorize>



				<security:authorize access="hasRole('ADMIN')" var="hasRoleAdmin">
			
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/maintenance/manage-users/showManageUsersPage">Manage
							Users</a></li>

				</security:authorize>


				<security:authorize access="hasAnyRole('ADMIN','MANAGER')">
			
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/maintenance/manage-rental-properties/showManageRentalPropertiesPage">Manage
							Rental Properties</a></li>
	
				</security:authorize>
				

				<security:authorize access="hasAnyRole('ADMIN','MANAGER','EMPLOYEE')">
			
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/maintenance/manage-rental-repairs/showManageRentalRepairsPage">Manage
							Rental Repairs</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/manager/rental-payments/showManageRentalPaymentsPage">Manage
							Rental Payments</a></li>

				</security:authorize>
				
				


				<security:authorize access="hasRole('RENTER')" var="hasRoleRenter">
			
					<li class="nav-item">
						<!-- Add a link to point to /renter ... this is for the renters -->
						<a class="nav-link"
						href="${pageContext.request.contextPath}/renter">Renter
							Portal&nbsp;</a>
					</li>

					<!-- Rental lease agreement download link -->
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/resources/documents/Rental-Agreement.docx"
						download="RentalAgrement.docx">Lease Agreement<br> <span
							class="fa-stack fa-lg"> <i class="fa fa-file fa-stack-1x"></i>

								<!-- <i class="fa fa-file-download fa-stack-1x"></i>	 -->
						</span>
					</a></li>

					<!-- Rental parking agreement download link -->
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/resources/documents/parking-space-rental-agreement.docx"
						download="RentalParkingAgrement.docx">Parking Agreement<br>
							<span class="fa-stack fa-lg"> <i
								class="fa fa-file fa-stack-1x"></i> <!-- <i class="fa fa-file-download fa-stack-1x"></i>	 -->
						</span>
					</a></li>

				</security:authorize>



				<security:authorize access="hasRole('CONTRACTOR')">
			
					<li class="nav-item">
						<!-- Add a link to point to /contractor ... this is for the contractors -->
						<a class="nav-link"
						href="${pageContext.request.contextPath}/contractor">Contractor
							Portal&nbsp;</a>
					</li>

					<!-- Independent contractor agreement download link -->
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/resources/documents/Independent-Contractor-Agreement.docx"
						download="ContractorAgrement.docx">Contractor Agreement<br>
							<span class="fa-stack fa-lg"> <i
								class="fa fa-file fa-stack-1x"></i> <!-- <i class="fa fa-file-download fa-stack-1x"></i>	 -->
						</span>
					</a></li>

				</security:authorize>

				<security:authorize access="hasRole('EMPLOYEE')">
			
					<li class="nav-item">
						<!-- Add a link to point to /employee ... this is for the employees -->
						<a class="nav-link"
						href="${pageContext.request.contextPath}/employee">Employee
							Portal&nbsp;</a>
					</li>


				</security:authorize>

				<security:authorize access="hasRole('MANAGER')">
			
					<li class="nav-item">
						<!-- Add a link to point to /manager ... this is for the managers -->
						<a class="nav-link"
						href="${pageContext.request.contextPath}/manager">Manager
							Portal&nbsp;</a>
					</li>

				</security:authorize>

				<security:authorize access="hasRole('ADMIN')">
					<li class="nav-item">
						<!-- Add a link to point to /admin ... this is for the admins -->
						<a class="nav-link"
						href="${pageContext.request.contextPath}/admin">Admin
							Portal&nbsp;</a>
					</li>
				</security:authorize>

				<security:authorize access="hasRole('OWNER')">
					<li class="nav-item">
						<!-- Add a link to point to /owner ... this is for the owners -->
						<a class="nav-link"
						href="${pageContext.request.contextPath}/owner">Owner
							Portal&nbsp;</a>
					</li>


				</security:authorize>



				<security:authorize access="hasAnyRole('ADMIN','RENTER','EMPLOYEE','MANAGER','OWNER')">
			
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/rental-repair/showAddRentalRepairPage">Add
							Rental Repair </a></li>

				</security:authorize>


				<security:authorize access="hasAnyRole('ADMIN','RENTER','CONTRACTOR','EMPLOYEE','MANAGER','OWNER')">
			        &nbsp;&nbsp;&nbsp;
					<li class="nav-item" style="margin-top: 5px;"><form:form
							action="${pageContext.request.contextPath}/logout" method="POST">
						&nbsp;<input type="submit" value="Logout" />
						</form:form></li>
					
				</security:authorize>











			</ul>
		</div>
	</nav>

</div>




