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
import com.abcrentals.binu.thankachan.entity.ContactInfo;
import com.abcrentals.binu.thankachan.entity.ManagerProfile;
import com.abcrentals.binu.thankachan.entity.Country;
import com.abcrentals.binu.thankachan.entity.EmployerInfo;
import com.abcrentals.binu.thankachan.entity.StateOrProvince;
import com.abcrentals.binu.thankachan.entity.User;
import com.abcrentals.binu.thankachan.service.AddressService;
import com.abcrentals.binu.thankachan.service.ContactInfoService;
import com.abcrentals.binu.thankachan.service.ManagerProfileService;
import com.abcrentals.binu.thankachan.service.CountryService;
import com.abcrentals.binu.thankachan.service.EmployerInfoService;
import com.abcrentals.binu.thankachan.service.StateOrProvinceService;
import com.abcrentals.binu.thankachan.user.ManagerUserProfile;

/*
 * Controller class to specify handler methods for users with a role of Manager
 * 
 * 
 * 
 */

@Controller
@RequestMapping("/manager")
public class ManagerController {


	
    private Logger logger = Logger.getLogger(getClass().getName());

 
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateOrProvinceService stateOrProvinceService; 
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private ContactInfoService contactInfoService;
	
	@Autowired
	private EmployerInfoService employerInfoService;
	

	
	@Autowired
	private ManagerProfileService managerProfileService;

	
	// method to load countries list as model attribute and countries and statesOrProvinces lists as session attributes
	@ModelAttribute("countries")
	public List<Country> initializeCountries(HttpServletRequest request) {

	    List <Country> countries = countryService.findAllCountries();
	    Country country = countryService.findAllCountries().get(0);
	    
	    HttpSession se = request.getSession();
	    se.setAttribute("countries", countries);
		List<StateOrProvince> statesOrProvinces = stateOrProvinceService.findByCountry(country.getCountryName());
		se.setAttribute("statesOrProvinces", statesOrProvinces);
	    
	    System.out.println("a5a: in RenterController class initializeCountry() method:  countries= " + countries.toString());
		System.out.println("a5b: RenterController   initializeCountries() method   country= " + countries);
		System.out.println("a5c: RenterController   initializeCountries() method   country.getCountryName()= " + country.getCountryName());
		System.out.println("a5d: RenterController   initializeCountries() method   statesOrProvinces= " + statesOrProvinces + "\n\n");


	    return countries;
	}  	

    // handler method to display the manager profile page	
	@GetMapping("/showAddManagerProfilePage")
	public ModelAndView showAddManagerProfilePage(HttpServletRequest request,Model theModel) {
		
		ModelAndView mv = new ModelAndView("manager/add-manager-profile");
		mv.addObject("managerUserProfile", new ManagerUserProfile());
		
		
	 
		
		HttpSession se = request.getSession();
		List<Country> countries = (List<Country>) se.getAttribute("countries");
		List<StateOrProvince> statesOrProvinces = (List<StateOrProvince>)se.getAttribute("statesOrProvinces");
		mv.addObject("countries", countries);
		mv.addObject("statesOrProvincesForHomeAddress", statesOrProvinces);
		mv.addObject("statesOrProvincesForEmployerAddress", statesOrProvinces);

		se.setAttribute("countries", countries);
		se.setAttribute("statesOrProvincesForHomeAddress", statesOrProvinces);
		se.setAttribute("statesOrProvincesForEmployerAddress", statesOrProvinces);
		
		
		System.out.println("b5a: In ManagerController   showAddManagerProfilePage() method   countries= " + countries);
		System.out.println("b5b: In ManagerController   showAddManagerProfilePage() method   statesOrProvinces= " + statesOrProvinces + "\n\n");

		 
		return mv;
	}
	
    // handler method to process the add manager profile form
	@PostMapping("/processAddManagerProfileForm")
	public ModelAndView processAddManagerProfileForm(HttpServletRequest request,
				@Valid @ModelAttribute("managerUserProfile") ManagerUserProfile theManagerUserProfile, 
				BindingResult theBindingResult, 
				Model theModel) {
		
		String contactInfoFirstName = theManagerUserProfile.getContactInfoFirstName();
		String contactInfoLastName = theManagerUserProfile.getContactInfoLastName();
		logger.info("Processing Add Manager Profile form for: " + contactInfoFirstName + " " + contactInfoLastName);
		System.out.println("c1a: theManagerUserProfile:   " + theManagerUserProfile.toString());
		HttpSession se = request.getSession();
		
		// form validation
		 if (theBindingResult.hasErrors()){
			 System.out.println("c2a: in processAddManagerProfileForm() method:  there are errors  | redirecting to add-manager-profile page");
			 System.out.println("c2b: in processAddManagerProfileForm() method:  | " + theBindingResult.getAllErrors().toString());
			 ModelAndView mv = new ModelAndView("manager/add-manager-profile");
			 mv.addObject("statesOrProvincesForHomeAddress", theManagerUserProfile);
			 mv.addObject("countries", se.getAttribute("countries"));
			 mv.addObject("statesOrProvincesForHomeAddress",se.getAttribute("statesOrProvincesForHomeAddress"));
			 mv.addObject("statesOrProvincesForEmployerAddress",se.getAttribute("statesOrProvincesForEmployerAddress"));

			 return mv;
	        }

 
		 
		 System.out.println("c3a: In ManagerController   processAddManagerProfileForm() method    theManagerUserProfile= " + theManagerUserProfile);
		 Address homeAddress = new Address();
		 Address employerAddress = new Address();

		 // save the home address in the db
		 if (!"".equals(theManagerUserProfile.getContactInfoHomeAddrLine1())) {
			 homeAddress.setAddressType(theManagerUserProfile.getContactInfoHomeAddressType());
			 homeAddress.setAddrLine1(theManagerUserProfile.getContactInfoHomeAddrLine1());
			 homeAddress.setAddrLine2(theManagerUserProfile.getContactInfoHomeAddrLine2());
			 homeAddress.setAddrLine3(theManagerUserProfile.getContactInfoHomeAddrLine3());
			 homeAddress.setAddrLine4(theManagerUserProfile.getContactInfoHomeAddrLine4());
			 homeAddress.setCity(theManagerUserProfile.getContactInfoHomeCity());
			 homeAddress.setState(stateOrProvinceService.findById(theManagerUserProfile.getContactInfoHomeState()).getStateOrProvince());
			 
			 homeAddress.setPostalCode(theManagerUserProfile.getContactInfoHomePostalCode());
			 homeAddress.setCountry(countryService.findByCountryCode(theManagerUserProfile.getContactInfoHomeCountry()).getCountryName());

			 addressService.save(homeAddress);
		 }
		 
		 // save the employer address in the db
		 if (!"".equals(theManagerUserProfile.getEmployerInfoEmployerAddrLine1())) {			 
			 employerAddress.setAddressType(theManagerUserProfile.getEmployerInfoEmployerAddressType());
			 employerAddress.setAddrLine1(theManagerUserProfile.getEmployerInfoEmployerAddrLine1());
			 employerAddress.setAddrLine2(theManagerUserProfile.getEmployerInfoEmployerAddrLine2());
			 employerAddress.setAddrLine3(theManagerUserProfile.getEmployerInfoEmployerAddrLine3());
			 employerAddress.setAddrLine4(theManagerUserProfile.getEmployerInfoEmployerAddrLine4());
			 employerAddress.setCity(theManagerUserProfile.getEmployerInfoEmployerCity());
			 employerAddress.setState(stateOrProvinceService.findById(theManagerUserProfile.getEmployerInfoEmployerState()).getStateOrProvince());
			 
			 employerAddress.setPostalCode(theManagerUserProfile.getEmployerInfoEmployerPostalCode());
			 employerAddress.setCountry(countryService.findByCountryCode(theManagerUserProfile.getEmployerInfoEmployerCountry()).getCountryName());

			 addressService.save(employerAddress);
		 }
		 

		 
		 ContactInfo contactInfo = new ContactInfo();
		 // save the Contact Info record in the db, while setting home address in the join table
		 if (!"".equals(theManagerUserProfile.getContactInfoFirstName())) {
			 
			 contactInfo.setFirstName(theManagerUserProfile.getContactInfoFirstName());
			 contactInfo.setLastName(theManagerUserProfile.getContactInfoLastName());
			 contactInfo.setPrimaryEmail(theManagerUserProfile.getContactInfoPrimaryEmail());
			 contactInfo.setSecondaryEmail(theManagerUserProfile.getContactInfoSecondaryEmail());
			 contactInfo.setHomePhoneNo(theManagerUserProfile.getContactInfoHomePhoneNo().toString());
			 contactInfo.setWorkPhoneNo(theManagerUserProfile.getContactInfoWorkPhoneNo().toString());
			 contactInfo.setCellPhoneNo(theManagerUserProfile.getContactInfoCellPhoneNo().toString());
			 List<Address> homeAddresses = new ArrayList<Address>();
			 homeAddresses.add(homeAddress);
			 contactInfo.setHomeAddresses(homeAddresses);
			 
			 contactInfoService.save(contactInfo);
			 
		 }
		 
		 EmployerInfo employerInfo = new EmployerInfo();
		 // save the Employer Info record in the db, while setting employer address in the join table
		 if (!"".equals(theManagerUserProfile.getEmployerInfoEmployerName())) {

			 employerInfo.setEmployerName(theManagerUserProfile.getEmployerInfoEmployerName());
			 employerInfo.setEmployerPhoneNo(theManagerUserProfile.getEmployerInfoEmployerPhoneNo().toString());
			 List<Address> employerAddresses = new ArrayList<Address>();
			 employerAddresses.add(employerAddress);
			 employerInfo.setEmployerAddresses(employerAddresses);
			 
			 employerInfoService.save(employerInfo);
			 
		 }
		 

		 // get the user from the session and add it to the ManagerProfile
		 User user = (User)se.getAttribute("user");
		 System.out.println("c8a: In ManagerController   processAddManagerProfileForm() method:   user=    id: " + user.getId() + "  | name: " + user.getFirstName() + " " + user.getLastName()+ "  | username: " + user.getUserName());
	 
		 
		 // Now save the ManagerProfile record to the database
		 ManagerProfile managerProfile = managerProfileService.findByUserId(user.getId());
		 System.out.println("c9a: In ManagerController   processAddManagerProfileForm() method:   managerProfile= " + managerProfile  + "  | user.getId()= " + user.getId());
		 if (managerProfile == null) managerProfile = new ManagerProfile();
		 System.out.println("c9b: In ManagerController   processAddManagerProfileForm() method:   managerProfile= " + managerProfile);
		 
		 managerProfile.setTypeOfProfile("MANAGER");

		 if (user != null) {
			 managerProfile.setUser(user);
		 }		 
		 if (contactInfo!= null) {
			 managerProfile.setContactInfo(contactInfo);
		 }
		 if (employerInfo != null) {
			 managerProfile.setEmployerInfo(employerInfo);
		 }
		 // save the manager profile record
		 managerProfileService.save(managerProfile);
			 
		 ModelAndView mv = new ModelAndView("manager/add-manager-profile-confirmation");
		 mv.addObject("managerUserProfile", theManagerUserProfile);
		 return mv;

	}


	
    // handler method to display the update manager profile page	
	@GetMapping("/showUpdateManagerProfilePage")
	public ModelAndView showUpdateManagerProfilePage(HttpServletRequest request,Model theModel) {
		System.out.println("d1a: Entering ManagerController   showUpdateManagerProfilePage() method");
		ModelAndView mv = new ModelAndView("manager/update-manager-profile");
		ManagerUserProfile managerUserProfile = new ManagerUserProfile();
		mv.addObject("managerUserProfile", new ManagerUserProfile());
		
		
		HttpSession se = request.getSession();
		User user = (User) se.getAttribute("user");
		System.out.println("d2a: ---> In ManagerController   showUpdateManagerProfilePage() method   user= " + user.getId() + " | " + user.getUserName() + " | " + user.getFirstName() + " " + user.getLastName());
		mv.addObject("user", user);
		
		// now that we have the user, use the user id to find the Manager Profile record with that user id
		ManagerProfile managerProfile = managerProfileService.findByUserId(user.getId());
		System.out.println("d3a: ---> In ManagerController   showUpdateManagerProfilePage() method   managerProfile= " + managerProfile);
		mv.addObject("managerProfile",managerProfile);
		
		// from the managerProfile record, get the Contact Info record and Employer Info record
		System.out.println("d4a: ---> In ManagerController   showUpdateManagerProfilePage() method   managerProfile.getUser().getId()= " + managerProfile.getUser().getId());

		System.out.println("d5a: ---> In ManagerController   showUpdateManagerProfilePage() method   managerProfile.getContactInfo().getId()= " + managerProfile.getContactInfo().getId());
		ContactInfo contactInfo = contactInfoService.findContactInfoById(managerProfile.getContactInfo().getId());
		System.out.println("d5b: ---> In ManagerController   showUpdateManagerProfilePage() method   contactInfo= " + contactInfo.toString());

		System.out.println("d6a: ---> In ManagerController   showUpdateManagerProfilePage() method   managerProfile.getEmployerInfo().getId()= " + managerProfile.getEmployerInfo().getId());
		EmployerInfo employerInfo = employerInfoService.findEmployerInfoById(managerProfile.getEmployerInfo().getId());
		System.out.println("d6b: ---> In ManagerController   showUpdateManagerProfilePage() method   employerInfo= " + employerInfo.toString());

		mv.addObject("contactInfo",contactInfo);
		List<Address> homeAddresses = new ArrayList<Address>();
		homeAddresses.add(contactInfo.getHomeAddresses().get(0));
		mv.addObject("contactInfo_homeAddresses", homeAddresses);
		System.out.println("d7a: ---> In ManagerController   showUpdateManagerProfilePage() method   homeAddresses= " + homeAddresses.toString());
		
		
		
		String state_to_find = contactInfo.getHomeAddresses().get(0).getState();
		System.out.println("d8a: In ManagerController  in showUpdateManagerProfilePage() method    state_to_find= " + state_to_find);

		int stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("d9a: In ManagerController  in showUpdateManagerProfilePage() method    state_to_find= " + state_to_find  + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("contactInfoHomeAddressStateIndx", stateOrProvinceStateIndx);
		
		
		
		
		
		mv.addObject("employerInfo",employerInfo);
		List<Address> employerAddresses = new ArrayList<Address>();
		employerAddresses.add(employerInfo.getEmployerAddresses().get(0));
		mv.addObject("employerInfo_employerAddresses",employerAddresses);
		
		
		
		state_to_find = employerInfo.getEmployerAddresses().get(0).getState();
		System.out.println("d11a: In ManagerController  in showUpdateManagerProfilePage() method    state_to_find= " + state_to_find);

		stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("d12a: In ManagerController  in showUpdateManagerProfilePage() method    state_to_find= " + state_to_find  + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("employerInfoEmployerAddressStateIndx", stateOrProvinceStateIndx);
		
		
		
		
		
		
		// get countries and states from the session object and add them to the model and view object
		List<Country> countries = (List<Country>) se.getAttribute("countries");
		System.out.println("d20a: ---> In ManagerController   showUpdateManagerProfilePage() method   countries= " + countries);

		List<StateOrProvince> statesOrProvinces = (List<StateOrProvince>)se.getAttribute("statesOrProvinces");
		System.out.println("d21a: ---> In ManagerController   showUpdateManagerProfilePage() method   statesOrProvinces= " + statesOrProvinces);

		mv.addObject("countries", countries);
		mv.addObject("statesOrProvincesForHomeAddress", statesOrProvinces);
		mv.addObject("statesOrProvincesForEmployerAddress", statesOrProvinces);

		//se.setAttribute("countries", countries);
		se.setAttribute("statesOrProvincesForHomeAddress", statesOrProvinces);
		se.setAttribute("statesOrProvincesForEmployerAddress", statesOrProvinces);
		
		
		System.out.println("d99a: Exiting ManagerController   showUpdateManagerProfilePage() method   countries= " + countries);
		System.out.println("d99b: Exiting ManagerController   showUpdateManagerProfilePage() method   statesOrProvinces= " + statesOrProvinces + "\n\n");

		 
		return mv;
	}

	
	
	
    // handler method to process the update manager profile form	
	@PostMapping("/processUpdateManagerProfileForm")
	public ModelAndView processUpdateManagerProfileForm(HttpServletRequest request,
				@Valid @ModelAttribute("managerUserProfile") ManagerUserProfile theManagerUserProfile, 
				BindingResult theBindingResult, 
				Model theModel) {
		
		String contactInfoFirstName = theManagerUserProfile.getContactInfoFirstName();
		String contactInfoLastName = theManagerUserProfile.getContactInfoLastName();
		logger.info("Processing Update Manager Profile form for: " + contactInfoFirstName + " " + contactInfoLastName);
		System.out.println("e1a: theManagerUserProfile:   " + theManagerUserProfile.toString());
		HttpSession se = request.getSession();
		
		// form validation
		 if (theBindingResult.hasErrors()){
			 System.out.println("e2a: in processUpdateManagerProfileForm() method:  there are errors  | redirecting to update-manager-profile page");
			 System.out.println("e2b: in processUpdateManagerProfileForm() method:  | " + theBindingResult.getAllErrors().toString());
			 ModelAndView mv = new ModelAndView("manager/update-manager-profile");
			 mv.addObject("statesOrProvincesForHomeAddress", theManagerUserProfile);
			 mv.addObject("countries", se.getAttribute("countries"));
			 mv.addObject("statesOrProvincesForHomeAddress",se.getAttribute("statesOrProvincesForHomeAddress"));
			 mv.addObject("statesOrProvincesForEmployerAddress",se.getAttribute("statesOrProvincesForEmployerAddress"));

			 return mv;
	        }

 
		 
		 System.out.println("e3a: In ManagerController   processUpdateManagerProfileForm() method    theManagerUserProfile= " + theManagerUserProfile);
		 Address homeAddress = null;
		 Address employerAddress = null;;

		 // update the home address in the db
		 if (!"".equals(theManagerUserProfile.getContactInfoHomeAddrLine1())) {
			 homeAddress = addressService.findByAddressId(theManagerUserProfile.getContactInfoHomeAddressId());
			 if (homeAddress == null) homeAddress = new Address();
			 
			 homeAddress.setAddressType(theManagerUserProfile.getContactInfoHomeAddressType());
			 homeAddress.setAddrLine1(theManagerUserProfile.getContactInfoHomeAddrLine1());
			 homeAddress.setAddrLine2(theManagerUserProfile.getContactInfoHomeAddrLine2());
			 homeAddress.setAddrLine3(theManagerUserProfile.getContactInfoHomeAddrLine3());
			 homeAddress.setAddrLine4(theManagerUserProfile.getContactInfoHomeAddrLine4());
			 homeAddress.setCity(theManagerUserProfile.getContactInfoHomeCity());
			 homeAddress.setState(stateOrProvinceService.findById(theManagerUserProfile.getContactInfoHomeState()).getStateOrProvince());
			 
			 homeAddress.setPostalCode(theManagerUserProfile.getContactInfoHomePostalCode());
			 homeAddress.setCountry(countryService.findByCountryCode(theManagerUserProfile.getContactInfoHomeCountry()).getCountryName());

			 addressService.save(homeAddress);
		 }
		 
		 // update the employer address in the db
		 if (!"".equals(theManagerUserProfile.getEmployerInfoEmployerAddrLine1())) {		
			 employerAddress = addressService.findByAddressId(theManagerUserProfile.getEmployerInfoEmployerAddressId());
			 if (employerAddress == null) employerAddress = new Address();

			 employerAddress.setAddressType(theManagerUserProfile.getEmployerInfoEmployerAddressType());
			 employerAddress.setAddrLine1(theManagerUserProfile.getEmployerInfoEmployerAddrLine1());
			 employerAddress.setAddrLine2(theManagerUserProfile.getEmployerInfoEmployerAddrLine2());
			 employerAddress.setAddrLine3(theManagerUserProfile.getEmployerInfoEmployerAddrLine3());
			 employerAddress.setAddrLine4(theManagerUserProfile.getEmployerInfoEmployerAddrLine4());
			 employerAddress.setCity(theManagerUserProfile.getEmployerInfoEmployerCity());
			 employerAddress.setState(stateOrProvinceService.findById(theManagerUserProfile.getEmployerInfoEmployerState()).getStateOrProvince());
			 
			 employerAddress.setPostalCode(theManagerUserProfile.getEmployerInfoEmployerPostalCode());
			 employerAddress.setCountry(countryService.findByCountryCode(theManagerUserProfile.getEmployerInfoEmployerCountry()).getCountryName());

			 addressService.save(employerAddress);
		 }
		 

		 
		 ContactInfo contactInfo = null;
		 // update the Contact Info record in the db
		 if (!"".equals(theManagerUserProfile.getContactInfoFirstName())) {
			 contactInfo = contactInfoService.findContactInfoById(theManagerUserProfile.getContactInfoId());
			 if (contactInfo == null) contactInfo = new ContactInfo();
			 
			 contactInfo.setFirstName(theManagerUserProfile.getContactInfoFirstName());
			 contactInfo.setLastName(theManagerUserProfile.getContactInfoLastName());
			 contactInfo.setPrimaryEmail(theManagerUserProfile.getContactInfoPrimaryEmail());
			 contactInfo.setSecondaryEmail(theManagerUserProfile.getContactInfoSecondaryEmail());
			 contactInfo.setHomePhoneNo(theManagerUserProfile.getContactInfoHomePhoneNo().toString());
			 contactInfo.setWorkPhoneNo(theManagerUserProfile.getContactInfoWorkPhoneNo().toString());
			 contactInfo.setCellPhoneNo(theManagerUserProfile.getContactInfoCellPhoneNo().toString());
			 List<Address> homeAddresses = new ArrayList<Address>();
			 homeAddresses.add(homeAddress);
			 contactInfo.setHomeAddresses(homeAddresses);
			 
			 contactInfoService.save(contactInfo);
			 
		 }
		 
		 EmployerInfo employerInfo = null;
		 // update the Employer Info record in the db 
		 if (!"".equals(theManagerUserProfile.getEmployerInfoEmployerName())) {
			 employerInfo = employerInfoService.findEmployerInfoById(theManagerUserProfile.getEmployerInfoId());
			 if (employerInfo == null) employerInfo = new EmployerInfo();

			 employerInfo.setEmployerName(theManagerUserProfile.getEmployerInfoEmployerName());
			 employerInfo.setEmployerPhoneNo(theManagerUserProfile.getEmployerInfoEmployerPhoneNo().toString());
			 List<Address> employerAddresses = new ArrayList<Address>();
			 employerAddresses.add(employerAddress);
			 employerInfo.setEmployerAddresses(employerAddresses);
			 
			 employerInfoService.save(employerInfo);
			 
		 }
		 

		 // get the user from the session and add it to the ManagerProfile
		 User user = (User)se.getAttribute("user");
		 System.out.println("e5a: In ManagerController   processUpdateManagerProfileForm() method:   user=    id: " + user.getId() + "  | name: " + user.getFirstName() + " " + user.getLastName()+ "  | username: " + user.getUserName());
	 
		 
		 // Now update the ManagerProfile record in the database
		 ManagerProfile managerProfile = managerProfileService.findByUserId(user.getId());
		 System.out.println("e6a: In ManagerController   processUpdateManagerProfileForm() method:   managerProfile= " + managerProfile  + "  | user.getId()= " + user.getId());
		 if (managerProfile == null) managerProfile = new ManagerProfile();
		 System.out.println("e6b: In ManagerController   processUpdateManagerProfileForm() method:   managerProfile= " + managerProfile);
		 
		 managerProfile.setTypeOfProfile("MANAGER");

		 if (user != null) {
			 managerProfile.setUser(user);
		 }		 
		 if (contactInfo!= null) {
			 managerProfile.setContactInfo(contactInfo);
		 }
		 if (employerInfo != null) {
			 managerProfile.setEmployerInfo(employerInfo);
		 }
		 // update the manager profile record
		 managerProfileService.save(managerProfile);
			 
		 ModelAndView mv = new ModelAndView("manager/update-manager-profile-confirmation");
		 mv.addObject("managerUserProfile", theManagerUserProfile);
		 return mv;

	}

	
	
	


	
    // handler method to display the manager profile page	
	@GetMapping("/showDisplayManagerProfilePage")
	public ModelAndView showDisplayManagerProfilePage(HttpServletRequest request,Model theModel) {
		System.out.println("f1a: Entering ManagerController   showDisplayManagerProfilePage() method");
		ModelAndView mv = new ModelAndView("manager/display-manager-profile");
		ManagerUserProfile managerUserProfile = new ManagerUserProfile();
		mv.addObject("managerUserProfile", new ManagerUserProfile());
		
		
		HttpSession se = request.getSession();
		User user = (User) se.getAttribute("user");
		System.out.println("f2a: ---> In ManagerController   showDisplayManagerProfilePage() method   user= " + user.getId() + " | " + user.getUserName() + " | " + user.getFirstName() + " " + user.getLastName());
		mv.addObject("user", user);
		
		// now that we have the user, use the user id to find the Manager Profile record with that user id
		ManagerProfile managerProfile = managerProfileService.findByUserId(user.getId());
		System.out.println("f3a: ---> In ManagerController   showDisplayManagerProfilePage() method   managerProfile= " + managerProfile);
		mv.addObject("managerProfile",managerProfile);
		
		// from the managerProfile record, get the Contact Info record and Employer Info record
		System.out.println("f4a: ---> In ManagerController   showDisplayManagerProfilePage() method   managerProfile.getUser().getId()= " + managerProfile.getUser().getId());

		System.out.println("f5a: ---> In ManagerController   showDisplayManagerProfilePage() method   managerProfile.getContactInfo().getId()= " + managerProfile.getContactInfo().getId());
		ContactInfo contactInfo = contactInfoService.findContactInfoById(managerProfile.getContactInfo().getId());
		System.out.println("f5b: ---> In ManagerController   showDisplayManagerProfilePage() method   contactInfo= " + contactInfo.toString());

		System.out.println("f6a: ---> In ManagerController   showDisplayManagerProfilePage() method   managerProfile.getEmployerInfo().getId()= " + managerProfile.getEmployerInfo().getId());
		EmployerInfo employerInfo = employerInfoService.findEmployerInfoById(managerProfile.getEmployerInfo().getId());
		System.out.println("f6b: ---> In ManagerController   showDisplayManagerProfilePage() method   employerInfo= " + employerInfo.toString());

		mv.addObject("contactInfo",contactInfo);
		List<Address> homeAddresses = new ArrayList<Address>();
		homeAddresses.add(contactInfo.getHomeAddresses().get(0));
		mv.addObject("contactInfo_homeAddresses", homeAddresses);
		System.out.println("f8a: ---> In ManagerController   showDisplayManagerProfilePage() method   homeAddresses= " + homeAddresses.toString());
		
		
		
		String state_to_find = contactInfo.getHomeAddresses().get(0).getState();
		System.out.println("f10a: In ManagerController  in showDisplayManagerProfilePage() method    state_to_find= " + state_to_find);

		int stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("f11a: In ManagerController  in showDisplayManagerProfilePage() method    state_to_find= " + state_to_find  + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("contactInfoHomeAddressStateIndx", stateOrProvinceStateIndx);
		
		
		
		
		
		mv.addObject("employerInfo",employerInfo);
		List<Address> employerAddresses = new ArrayList<Address>();
		employerAddresses.add(employerInfo.getEmployerAddresses().get(0));
		mv.addObject("employerInfo_employerAddresses",employerAddresses);
		
		
		
		state_to_find = employerInfo.getEmployerAddresses().get(0).getState();
		System.out.println("f14a: In ManagerController  in showDisplayManagerProfilePage() method    state_to_find= " + state_to_find);

		stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("f15a: In ManagerController  in showDisplayManagerProfilePage() method    state_to_find= " + state_to_find  + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("employerInfoEmployerAddressStateIndx", stateOrProvinceStateIndx);
		
		
		
		
		
		
		// get countries and states from the session object and add them to the model and view object
		List<Country> countries = (List<Country>) se.getAttribute("countries");
		System.out.println("f16a: ---> In ManagerController   showDisplayManagerProfilePage() method   countries= " + countries);

		List<StateOrProvince> statesOrProvinces = (List<StateOrProvince>)se.getAttribute("statesOrProvinces");
		System.out.println("f17a: ---> In ManagerController   showDisplayManagerProfilePage() method   statesOrProvinces= " + statesOrProvinces);

		mv.addObject("countries", countries);
		mv.addObject("statesOrProvincesForHomeAddress", statesOrProvinces);
		mv.addObject("statesOrProvincesForEmployerAddress", statesOrProvinces);

		//se.setAttribute("countries", countries);
		se.setAttribute("statesOrProvincesForHomeAddress", statesOrProvinces);
		se.setAttribute("statesOrProvincesForEmployerAddress", statesOrProvinces);
		
		
		System.out.println("f99a: Exiting ManagerController   showDisplayManagerProfilePage() method   countries= " + countries);
		System.out.println("f99b: Exiting ManagerController   showDisplayManagerProfilePage() method   statesOrProvinces= " + statesOrProvinces + "\n\n");

		 
		return mv;
	}

	

	
	
	
}
