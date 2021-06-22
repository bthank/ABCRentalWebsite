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
    

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
		// return "plain-login";

		return "login-page";
		
	}
	
	// add request mapping for /access-denied
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "access-denied";
		
	}
	
}









