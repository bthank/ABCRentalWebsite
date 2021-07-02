package com.abcrentals.binu.thankachan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abcrentals.binu.thankachan.entity.AdminProfile;
import com.abcrentals.binu.thankachan.entity.ContractorProfile;
import com.abcrentals.binu.thankachan.entity.EmployeeProfile;
import com.abcrentals.binu.thankachan.entity.ManagerProfile;
import com.abcrentals.binu.thankachan.entity.OwnerProfile;
import com.abcrentals.binu.thankachan.entity.RenterProfile;
import com.abcrentals.binu.thankachan.entity.User;
import com.abcrentals.binu.thankachan.service.AdminProfileService;
import com.abcrentals.binu.thankachan.service.ContractorProfileService;
import com.abcrentals.binu.thankachan.service.EmployeeProfileService;
import com.abcrentals.binu.thankachan.service.ManagerProfileService;
import com.abcrentals.binu.thankachan.service.OwnerProfileService;
import com.abcrentals.binu.thankachan.service.RenterProfileService;
import com.abcrentals.binu.thankachan.service.UserService;

/*
 * Controller class to specify handler methods for managing different role based user profiles
 * 
 * 
 * 
 */


@Controller
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	AdminProfileService adminProfileService;
	
	@Autowired
	ContractorProfileService contractorProfileService;
	
	@Autowired
	RenterProfileService renterProfileService;	
	
	@Autowired
	EmployeeProfileService employeeProfileService;
	
	@Autowired
	ManagerProfileService managerProfileService;
	
	@Autowired
	OwnerProfileService ownerProfileService;
	
	@Autowired
	UserService userService;
	
	
	
    // handler method to display the manage profile page	
	@GetMapping("/showManageProfilesPage")
	public ModelAndView showManageProfilesPage(HttpServletRequest request,Model theModel) {
		
		ModelAndView mv = new ModelAndView("manage-profiles");
		// determine the user id from the user name
		User theUser = userService.findByUserName(request.getUserPrincipal().getName());
		AdminProfile adminProfile = adminProfileService.findByUserId(theUser.getId());
		ContractorProfile contractorProfile = contractorProfileService.findByUserId(theUser.getId());
		RenterProfile renterProfile = renterProfileService.findByUserId(theUser.getId());
		EmployeeProfile employeeProfile = employeeProfileService.findByUserId(theUser.getId());
		ManagerProfile managerProfile = managerProfileService.findByUserId(theUser.getId());
		OwnerProfile ownerProfile = ownerProfileService.findByUserId(theUser.getId());
		
		mv.addObject("adminProfile", adminProfile);
		mv.addObject("contractorProfile", contractorProfile);
		mv.addObject("renterProfile", renterProfile);
		mv.addObject("employeeProfile", employeeProfile);
		mv.addObject("managerProfile", managerProfile);
		mv.addObject("ownerProfile", ownerProfile);
		
		
		
			  
		System.out.println("In ProfileController   showManageProfilesPage() method   theUser.getId()= " + theUser.getId() + 
				"    adminProfile= " + adminProfile + "     contractorProfile " + contractorProfile + "    renterProfile= " + renterProfile +
				"    employeeProfile= " + employeeProfile + "    managerProfile= " + managerProfile + "    ownerProfile= " + ownerProfile + "\n\n\n");
		
	//	User user = request.getUserPrincipal();
		System.out.println("a5a  In ProfileController   request.getUserPrincipal()= " + request.getUserPrincipal() + "\n\n\n");
		System.out.println("a5a  In ProfileController   request.getUserPrincipal().getName()= " + request.getUserPrincipal().getName() + "\n\n\n");

		
		return mv;
	}

	
	

}
