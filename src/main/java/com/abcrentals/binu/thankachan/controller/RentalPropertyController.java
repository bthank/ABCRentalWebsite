package com.abcrentals.binu.thankachan.controller;

import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abcrentals.binu.thankachan.entity.Address;
import com.abcrentals.binu.thankachan.entity.AdminProfile;
import com.abcrentals.binu.thankachan.entity.ContactInfo;
import com.abcrentals.binu.thankachan.entity.Country;
import com.abcrentals.binu.thankachan.entity.EmployerInfo;
import com.abcrentals.binu.thankachan.entity.ManagerProfile;
import com.abcrentals.binu.thankachan.entity.OwnerProfile;
import com.abcrentals.binu.thankachan.entity.RentalProperty;
import com.abcrentals.binu.thankachan.entity.StateOrProvince;
import com.abcrentals.binu.thankachan.entity.User;
import com.abcrentals.binu.thankachan.service.AddressService;
import com.abcrentals.binu.thankachan.service.CountryService;
import com.abcrentals.binu.thankachan.service.ManagerProfileService;
import com.abcrentals.binu.thankachan.service.OwnerProfileService;
import com.abcrentals.binu.thankachan.service.RentalPropertyService;
import com.abcrentals.binu.thankachan.service.StateOrProvinceService;

/*
 * Controller class to specify handler methods for processing rental property functions grouped under /rental-property path
 * 
 * 
 * 
 */


@Controller
@RequestMapping("/rental-property")
public class RentalPropertyController {
	

    private Logger logger = Logger.getLogger(getClass().getName());

 
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateOrProvinceService stateOrProvinceService; 
	

	@Autowired
	private RentalPropertyService rentalPropertyService;

	@Autowired
	private OwnerProfileService ownerProfileService;	

	@Autowired
	private ManagerProfileService managerProfileService;	
	
	@Autowired
	private AddressService addressService;
	
	
	// method to load countries list as model attribute and countries and statesOrProvinces lists as session attributes
	@ModelAttribute("countries")
	public List<Country> initializeCountries(HttpServletRequest request) {

	    List <Country> countries = countryService.findAllCountries();
	    Country country = countryService.findAllCountries().get(0);
	    
	    HttpSession se = request.getSession();
	    se.setAttribute("countries", countries);
		List<StateOrProvince> statesOrProvinces = stateOrProvinceService.findByCountry(country.getCountryName());
		se.setAttribute("statesOrProvinces", statesOrProvinces);
	    
	    System.out.println("a5a: in RentalPropertyController class initializeCountry() method:  countries= " + countries.toString());
		System.out.println("a5b: RentalPropertyController   initializeCountries() method   country= " + countries);
		System.out.println("a5c: RentalPropertyController   initializeCountries() method   country.getCountryName()= " + country.getCountryName());
		System.out.println("a5d: RentalPropertyController   initializeCountries() method   statesOrProvinces= " + statesOrProvinces + "\n\n");


	    return countries;
	}  	

	



	
	// handler method to display the add rental property page	
	@GetMapping("/showAddRentalPropertyPage")
	public ModelAndView showAddRentalPropertyPage(HttpServletRequest request,Model theModel) {
		
		System.out.println("b1a: Entering RentalPropertyController   in showAddRentalPropertyPage() method\n\n");

		RentalProperty rentalProperty = new RentalProperty();
		/*
		 * Address address = new Address();
		 * rentalProperty.setRentalPropertyAddress(address);
		 */				
		ModelAndView mv = new ModelAndView("rental-property/add-rental-property");
		mv.addObject("rentalProperty", rentalProperty);
		
		List<OwnerProfile> ownerProfileList = ownerProfileService.findAllOwnerProfiles();
		mv.addObject("ownerProfileList", ownerProfileList);
		
		List<ManagerProfile> managerProfileList = managerProfileService.findAllManagerProfiles();
		mv.addObject("managerProfileList", managerProfileList);

		HttpSession se = request.getSession();
		List<Country> countries = (List<Country>) se.getAttribute("countries");
		List<StateOrProvince> statesOrProvinces = (List<StateOrProvince>)se.getAttribute("statesOrProvinces");
		mv.addObject("countries", countries);
		mv.addObject("statesOrProvincesForRentalProperty", statesOrProvinces);

		se.setAttribute("countries", countries);
		se.setAttribute("statesOrProvincesForRentalProperty", statesOrProvinces);
		se.setAttribute("ownerProfileList", ownerProfileList);
		se.setAttribute("managerProfileList", managerProfileList);
		
		
		System.out.println("b99a: In RentalPropertyController   showAddRentalPropertyPage() method   countries= " + countries);
		System.out.println("b99b: In RentalPropertyController   showAddRentalPropertyPage() method   statesOrProvinces= " + statesOrProvinces + "\n\n");

			 
		return mv;
	}
	
	
	// handler method to process the add rental property form	
	@PostMapping("/processAddRentalPropertyForm")
	public ModelAndView processAddRentalPropertyForm(HttpServletRequest request,
				@Valid @ModelAttribute("rentalProperty") RentalProperty theRentalProperty, 
				BindingResult theBindingResult, 
				Model theModel) {

		System.out.println("c1a: Entering RentalPropertyController  processAddRentalPropertyForm() method   :   theRentalProperty: " + theRentalProperty.toString());

		logger.info("Processing Add Rental Property form for rental property id: " + theRentalProperty.getId() + "  | owner id: " + theRentalProperty.getOwnerUserId());

		HttpSession se = request.getSession();
		
		// form validation
		if (theBindingResult.hasErrors()){
			 System.out.println("c2a: in processAddAdminProfileForm() method:  there are errors  | redirecting to rental-property/add-rental-property page");
			 System.out.println("c2b: in processAddAdminProfileForm() method:  | " + theBindingResult.getAllErrors().toString());
			 ModelAndView mv = new ModelAndView("rental-property/add-rental-property");
			 mv.addObject("rentalProperty", theRentalProperty);
			 mv.addObject("countries", se.getAttribute("countries"));
			 mv.addObject("statesOrProvincesForRentalProperty",se.getAttribute("statesOrProvincesForRentalProperty"));
			 mv.addObject("ownerProfileList",se.getAttribute("ownerProfileList"));
			 mv.addObject("managerProfileList",se.getAttribute("managerProfileList"));

			 return mv;
	        }

 
		 
		 System.out.println("c3a: In RentalPropertyController   processAddRentalPropertyForm() method    theRentalProperty= " + theRentalProperty);
		 Address rentalAddress = new Address();

		 // save the rental property address in the db
		 if (!"".equals(theRentalProperty.getRentalPropertyAddress().getAddrLine1())) {
			 rentalAddress.setAddressType(theRentalProperty.getRentalPropertyAddress().getAddressType());
			 rentalAddress.setAddrLine1(theRentalProperty.getRentalPropertyAddress().getAddrLine1());
			 rentalAddress.setAddrLine2(theRentalProperty.getRentalPropertyAddress().getAddrLine2());
			 rentalAddress.setAddrLine3(theRentalProperty.getRentalPropertyAddress().getAddrLine3());
			 rentalAddress.setAddrLine4(theRentalProperty.getRentalPropertyAddress().getAddrLine4());
			 rentalAddress.setCity(theRentalProperty.getRentalPropertyAddress().getCity());
			 rentalAddress.setState(theRentalProperty.getRentalPropertyAddress().getState());
			 rentalAddress.setPostalCode(theRentalProperty.getRentalPropertyAddress().getPostalCode());
			 rentalAddress.setCountry(theRentalProperty.getRentalPropertyAddress().getCountry());

			 addressService.save(rentalAddress);
		 }
		 		 
		 theRentalProperty.setRentalPropertyAddress(rentalAddress);

		 // get the user from the session and add it to the RentalProperty
		 User user = (User)se.getAttribute("user");
		 System.out.println("c8a: In RentalPropertyController   processAddRentalPropertyForm() method:   user=    id: " + user.getId() + "  | name: " + user.getFirstName() + " " + user.getLastName()+ "  | username: " + user.getUserName());
	 
		 
		 // Now save the RentalProperty record to the database
		 rentalPropertyService.save(theRentalProperty);
			 
		 ModelAndView mv = new ModelAndView("rental-property/add-rental-property-confirmation");
		// mv.addObject("rentalProperty", theRentalProperty);
		 return mv;

	}

	
	

	
	
}
