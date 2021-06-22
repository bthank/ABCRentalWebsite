package com.abcrentals.binu.thankachan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abcrentals.binu.thankachan.entity.Country;
import com.abcrentals.binu.thankachan.entity.StateOrProvince;
import com.abcrentals.binu.thankachan.user.RenterUserProfile;

/*
 * Controller class to specify handler methods for managing different role based user profiles
 * 
 * 
 * 
 */


@Controller
@RequestMapping("/profile")
public class ProfileController {
	
	
	@GetMapping("/showManageProfilesPage")
	public ModelAndView showManageProfilesPage(HttpServletRequest request,Model theModel) {
		
		ModelAndView mv = new ModelAndView("manage-profiles");
		  
		System.out.println("In ProfileController   showManageProfilesPage() method   ");

		return mv;
	}

	
	

}
