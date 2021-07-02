package com.abcrentals.binu.thankachan.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * Controller class to specify handler methods for user login
 * 
 * 
 * 
 */


@Controller
public class LoginController {

	
    private Logger logger = Logger.getLogger(getClass().getName());
    
    // handler method to display the login page
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
		// return "login-page";

		return "login-page";
		
	}
	
	// add request mapping for /access-denied	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "access-denied";
		
	}
	
}









