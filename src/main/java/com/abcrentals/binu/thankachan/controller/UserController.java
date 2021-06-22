package com.abcrentals.binu.thankachan.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abcrentals.binu.thankachan.constants.RentalWebsiteConstants;
import com.abcrentals.binu.thankachan.entity.Address;
import com.abcrentals.binu.thankachan.entity.AdminProfile;
import com.abcrentals.binu.thankachan.entity.ContactInfo;
import com.abcrentals.binu.thankachan.entity.EmployerInfo;
import com.abcrentals.binu.thankachan.entity.User;
import com.abcrentals.binu.thankachan.service.UserService;
import com.abcrentals.binu.thankachan.user.AdminUserProfile;

/*
 * Controller class to specify handler methods for User class functions
 * 
 * 
 * 
 */


@Controller
public class UserController {


	
    private Logger logger = Logger.getLogger(getClass().getName());

 
	@Autowired
	private UserService userService;

	
	
	

	
	
	
	@GetMapping("/maintenance/manage-users/showSelectUserToUpdateAccessForPage")
	public ModelAndView showSelectUserToUpdateAccessForPage(HttpServletRequest request,Model theModel) {
		
		System.out.println("b1a: Entering UserController   showSelectUserToUpdateAccessForPage() method");

		ModelAndView mv = new ModelAndView("maintenance/manage-users/select-user-to-update-access-for");
		
		
		HttpSession se = request.getSession();
		List<User> users = (List<User>)userService.findAllUsers();
		
		mv.addObject("user", new User());  // add form backing object
		mv.addObject("users", users);      // add for the user dropdown

		se.setAttribute("users", users);
 
		
		System.out.println("b99a: Exiting UserController   showUpdateUserAccessPage() method   ");
		 
		return mv;
	}
	
	
	
	
	@PostMapping("/maintenance/manage-users/showUserToUpdateAccessForForm")
	public ModelAndView showUserToUpdateAccessForForm(HttpServletRequest request,
			@ModelAttribute("user") User theUserToUpdate,BindingResult theBindingResult) {
		
		System.out.println("c1a: Entering UserController  showUserToUpdateAccessForForm() method     theUserToUpdate= " + theUserToUpdate.toString());

		
		ModelAndView mv = new ModelAndView("maintenance/manage-users/update-user-access");
		User user = userService.findByUserId(theUserToUpdate.getId());
		mv.addObject("user", user);
		
		
		HttpSession se = request.getSession();
		se.setAttribute("theUser", user);
		
	    Map<Integer, String> userAccessTypeList = new HashMap<Integer, String>();
	    int i=0;
	    for(String str: RentalWebsiteConstants.USER_ACCESS_TYPES) {
	    	userAccessTypeList.put(i++, str);
	    }

		mv.addObject("userAccessTypeList", userAccessTypeList);

		se.setAttribute("userAccessTypeList", userAccessTypeList);
		
		System.out.println("c99a: Exiting UserController   showUserToUpdateAccessForForm() method   user id:  " + user.getId() + "  | username:  " + user.getUserName());
		System.out.println("c99c: Exiting UserController   showUserToUpdateAccessForForm() method   userAccessTypeList= " + userAccessTypeList.toString());
		 
		return mv;
	}
	
	
	@PostMapping("/maintenance/manage-users/processUpdateUserAccessForm")
	public ModelAndView processUpdateUserAccessForm(HttpServletRequest request,
				@Valid @ModelAttribute("user") User theUserToUpdate, 
				BindingResult theBindingResult, 
				Model theModel) {


		HttpSession se = request.getSession();
		User theUser = (User) se.getAttribute("theUser");
		theUser.setAccessLevel(theUserToUpdate.getAccessLevel());
		System.out.println("e1a: Entering UserController  processUpdateUserAccessForm() method   theUserToUpdate   user id: " + theUserToUpdate.getId() + "  |  " + theUserToUpdate.getUserName() + "  |  " + theUserToUpdate.getFirstAndLastName()  + "  |  " + theUserToUpdate.getAccessLevel());
		System.out.println("e1a: Entering UserController  processUpdateUserAccessForm() method   theUser           user id: " + theUser.getId() + "  |  " + theUser.getUserName() + "  |  " + theUser.getFirstAndLastName()  + "  |  " + theUser.getAccessLevel());
		
		// form validation
		if (theBindingResult.hasErrors()){
			 System.out.println("e2a: in processUpdateAdminProfileForm() method:  there are errors  | redirecting to update-admin-profile page");
			 System.out.println("e2b: in processUpdateAdminProfileForm() method:  | " + theBindingResult.getAllErrors().toString());
			 ModelAndView mv = new ModelAndView("maintenance/manage-users/update-user-access");
			 mv.addObject("user",theUser);
			 mv.addObject("userAccessTypeList",se.getAttribute("userAccessTypeList"));

			 return mv;
		}
		 
		logger.info("Processing Update User Access Level form for: " + theUser.getId() + "  |  " + theUser.getUserName() + "  |  " + theUser.getFirstAndLastName());

 
		
		ModelAndView mv = null;
		if (theUser != null) {
			userService.saveUser(theUser);
			 mv = new ModelAndView("maintenance/manage-users/update-user-access-confirmation");
	 	 }	else {
	 		mv = new ModelAndView("maintenance/manage-users/error-updating-user");
	 	 }

			 
//		 mv.addObject("user", new User());
		 return mv;

	}

	
	
	
	@PostMapping("/maintenance/manage-users/showSelectUserToDeletePage")
	public ModelAndView showSelectUserToDeletePage(HttpServletRequest request) {
		

		ModelAndView mv = new ModelAndView();
		return mv;

	}
	
	
	
	
	
}
