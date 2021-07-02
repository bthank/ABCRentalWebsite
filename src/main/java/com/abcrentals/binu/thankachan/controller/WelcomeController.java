package com.abcrentals.binu.thankachan.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.abcrentals.binu.thankachan.entity.User;

/*
 * Controller class to specify handler methods for nav bar functions and to serve other miscellaneous pages such as "About Us" and "Terms of Use"
 * 
 * 
 * 
 */


@Controller
public class WelcomeController {
	
    private Logger logger = Logger.getLogger(getClass().getName());

	@GetMapping("/")
	public String showHome(HttpServletRequest request) {
		System.out.println("In WelcomeController   showHome() method: ");
		// now place in the session
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
//		System.out.println("In WelcomeController   showHome() method:   user=    id: " + user.getId() + "  | name: " + user.getFirstName() + " " + user.getLastName()+ "  | username: " + user.getUserName());
		return "home";
	}
	
	// add request mapping for /renter

	@GetMapping("/renter")
	public String showRenterPage() {
		
		return "renter/renter-page";
	}
	
	// add request mapping for /contractor
	
	@GetMapping("/contractor")
	public String showContractorPage() {
		
		return "contractor/contractor-page";
	}
	
	// add request mapping for /employee
	
	@GetMapping("/employee")
	public String showEmployeePage() {
		
		return "employee/employee-page";
	}	
	// add request mapping for /manager

	@GetMapping("/manager")
	public String showManagerPage() {
		
		return "manager/manager-page";
	}
	
	// add request mapping for /admin
	
	@GetMapping("/admin")
	public String showAdminPage() {
		
		return "admin/admin-page";
	}	
	
	// add request mapping for /owner
	
	@GetMapping("/owner")
	public String showOwnerPage() {
		
		return "owner/owner-page";
	}	
	
	// add request mapping for /privacy-notice
		
	@GetMapping("/privacy-notice")
	public String showPrivacyNotice() {
		
		return "common/privacy-notice";
	}	
	
	// add request mapping for /terms-of-use
	
	@GetMapping("/terms-of-use")
	public String showTermsOfUse() {
		
		return "common/terms-of-use";
	}	
	
	// add request mapping for /about-us
	
	@GetMapping("/about-us")
	public String showAboutUsPage() {
		
		return "about-us";
	}	

	// add request mapping for /contact-us
	
	@GetMapping("/contact-us")
	public String showContactUs() {
		
		return "contact-us";
	}	

}










