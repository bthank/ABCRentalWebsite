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
import com.abcrentals.binu.thankachan.entity.Country;
import com.abcrentals.binu.thankachan.entity.EmployeeProfile;
import com.abcrentals.binu.thankachan.entity.EmployerInfo;
import com.abcrentals.binu.thankachan.entity.StateOrProvince;
import com.abcrentals.binu.thankachan.entity.User;
import com.abcrentals.binu.thankachan.service.AddressService;
import com.abcrentals.binu.thankachan.service.ContactInfoService;
import com.abcrentals.binu.thankachan.service.CountryService;
import com.abcrentals.binu.thankachan.service.EmployeeProfileService;
import com.abcrentals.binu.thankachan.service.EmployerInfoService;
import com.abcrentals.binu.thankachan.service.PrivateInfoService;
import com.abcrentals.binu.thankachan.service.StateOrProvinceService;
import com.abcrentals.binu.thankachan.user.EmployeeUserProfile;

/*
 * Controller class to specify handler methods for users with a role of Employee
 * 
 * 
 * 
 */


@Controller
@RequestMapping("/employee")
public class EmployeeController {

	
	
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
	private EmployeeProfileService employeeProfileService;


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

	// handler method to display the add employee profile page
	@GetMapping("/showAddEmployeeProfilePage")
	public ModelAndView showAddEmployeeProfilePage(HttpServletRequest request,Model theModel) {
		
		ModelAndView mv = new ModelAndView("employee/add-employee-profile");
		mv.addObject("employeeUserProfile", new EmployeeUserProfile());
		
		
	 
		
		HttpSession se = request.getSession();
		List<Country> countries = (List<Country>) se.getAttribute("countries");
		List<StateOrProvince> statesOrProvinces = (List<StateOrProvince>)se.getAttribute("statesOrProvinces");
		mv.addObject("countries", countries);
		mv.addObject("statesOrProvincesForHomeAddress", statesOrProvinces);
		mv.addObject("statesOrProvincesForEmployerAddress", statesOrProvinces);

		se.setAttribute("countries", countries);
		se.setAttribute("statesOrProvincesForHomeAddress", statesOrProvinces);
		se.setAttribute("statesOrProvincesForEmployerAddress", statesOrProvinces);
		
		
		System.out.println("b5a:  In EmployeeController   showAddEmployeeProfilePage() method   countries= " + countries);
		System.out.println("b5b:  In EmployeeController   showAddEmployeeProfilePage() method   statesOrProvinces= " + statesOrProvinces + "\n\n");

		 
		return mv;
	}
	
	
	// handler method to process the add employee profile form page
	@PostMapping("/processAddEmployeeProfileForm")
	public ModelAndView processAddEmployeeProfileForm(HttpServletRequest request,
				@Valid @ModelAttribute("employeeUserProfile") EmployeeUserProfile theEmployeeUserProfile, 
				BindingResult theBindingResult, 
				Model theModel) {
		
		String contactInfoFirstName = theEmployeeUserProfile.getContactInfoFirstName();
		String contactInfoLastName = theEmployeeUserProfile.getContactInfoLastName();
		logger.info("Processing Add Employee Profile form for: " + contactInfoFirstName + " " + contactInfoLastName);
		System.out.println("c1a:  theEmployeeUserProfile:   " + theEmployeeUserProfile.toString());
		HttpSession se = request.getSession();
		
		// form validation
		 if (theBindingResult.hasErrors()){
			 System.out.println("c4a:  in processAddEmployeeProfileForm() method:  there are errors  | redirecting to add-employee-profile page");
			 System.out.println("c4b:  in processAddEmployeeProfileForm() method:  | " + theBindingResult.getAllErrors().toString());
			 ModelAndView mv = new ModelAndView("employee/add-employee-profile");
			 mv.addObject("statesOrProvincesForHomeAddress", theEmployeeUserProfile);
			 mv.addObject("countries", se.getAttribute("countries"));
			 mv.addObject("statesOrProvincesForHomeAddress",se.getAttribute("statesOrProvincesForHomeAddress"));
			 mv.addObject("statesOrProvincesForEmployerAddress",se.getAttribute("statesOrProvincesForEmployerAddress"));

			 return mv;
	        }

 
		 
		 System.out.println("c5a:  In EmployeeController   processAddEmployeeProfileForm() method    theEmployeeUserProfile= " + theEmployeeUserProfile);
		 Address homeAddress = new Address();
		 Address employerAddress = new Address();

		 // save the home address in the db
		 if (!"".equals(theEmployeeUserProfile.getContactInfoHomeAddrLine1())) {
			 homeAddress.setAddressType(theEmployeeUserProfile.getContactInfoHomeAddressType());
			 homeAddress.setAddrLine1(theEmployeeUserProfile.getContactInfoHomeAddrLine1());
			 homeAddress.setAddrLine2(theEmployeeUserProfile.getContactInfoHomeAddrLine2());
			 homeAddress.setAddrLine3(theEmployeeUserProfile.getContactInfoHomeAddrLine3());
			 homeAddress.setAddrLine4(theEmployeeUserProfile.getContactInfoHomeAddrLine4());
			 homeAddress.setCity(theEmployeeUserProfile.getContactInfoHomeCity());
			 homeAddress.setState(stateOrProvinceService.findById(theEmployeeUserProfile.getContactInfoHomeState()).getStateOrProvince());
			 
			 homeAddress.setPostalCode(theEmployeeUserProfile.getContactInfoHomePostalCode());
			 homeAddress.setCountry(countryService.findByCountryCode(theEmployeeUserProfile.getContactInfoHomeCountry()).getCountryName());

			 addressService.save(homeAddress);
		 }
		 
		 // save the employer address in the db
		 if (!"".equals(theEmployeeUserProfile.getEmployerInfoEmployerAddrLine1())) {			 
			 employerAddress.setAddressType(theEmployeeUserProfile.getEmployerInfoEmployerAddressType());
			 employerAddress.setAddrLine1(theEmployeeUserProfile.getEmployerInfoEmployerAddrLine1());
			 employerAddress.setAddrLine2(theEmployeeUserProfile.getEmployerInfoEmployerAddrLine2());
			 employerAddress.setAddrLine3(theEmployeeUserProfile.getEmployerInfoEmployerAddrLine3());
			 employerAddress.setAddrLine4(theEmployeeUserProfile.getEmployerInfoEmployerAddrLine4());
			 employerAddress.setCity(theEmployeeUserProfile.getEmployerInfoEmployerCity());
			 employerAddress.setState(stateOrProvinceService.findById(theEmployeeUserProfile.getEmployerInfoEmployerState()).getStateOrProvince());
			 
			 employerAddress.setPostalCode(theEmployeeUserProfile.getEmployerInfoEmployerPostalCode());
			 employerAddress.setCountry(countryService.findByCountryCode(theEmployeeUserProfile.getEmployerInfoEmployerCountry()).getCountryName());

			 addressService.save(employerAddress);
		 }
		 

		 
		 ContactInfo contactInfo = new ContactInfo();
		 // save the Contact Info record in the db, while setting home address in the join table
		 if (!"".equals(theEmployeeUserProfile.getContactInfoFirstName())) {
			 
			 contactInfo.setFirstName(theEmployeeUserProfile.getContactInfoFirstName());
			 contactInfo.setLastName(theEmployeeUserProfile.getContactInfoLastName());
			 contactInfo.setPrimaryEmail(theEmployeeUserProfile.getContactInfoPrimaryEmail());
			 contactInfo.setSecondaryEmail(theEmployeeUserProfile.getContactInfoSecondaryEmail());
			 contactInfo.setHomePhoneNo(theEmployeeUserProfile.getContactInfoHomePhoneNo().toString());
			 contactInfo.setWorkPhoneNo(theEmployeeUserProfile.getContactInfoWorkPhoneNo().toString());
			 contactInfo.setCellPhoneNo(theEmployeeUserProfile.getContactInfoCellPhoneNo().toString());
			 List<Address> homeAddresses = new ArrayList<Address>();
			 homeAddresses.add(homeAddress);
			 contactInfo.setHomeAddresses(homeAddresses);
			 
			 contactInfoService.save(contactInfo);
			 
		 }
		 
		 EmployerInfo employerInfo = new EmployerInfo();
		 // save the Employer Info record in the db, while setting employer address in the join table
		 if (!"".equals(theEmployeeUserProfile.getEmployerInfoEmployerName())) {

			 employerInfo.setEmployerName(theEmployeeUserProfile.getEmployerInfoEmployerName());
			 employerInfo.setEmployerPhoneNo(theEmployeeUserProfile.getEmployerInfoEmployerPhoneNo().toString());
			 List<Address> employerAddresses = new ArrayList<Address>();
			 employerAddresses.add(employerAddress);
			 employerInfo.setEmployerAddresses(employerAddresses);
			 
			 employerInfoService.save(employerInfo);
			 
		 }
		 

		 // get the user from the session and add it to the EmployeeProfile
		 User user = (User)se.getAttribute("user");
		 System.out.println("c10a:  In EmployeeController   processAddEmployeeProfileForm() method:   user=    id: " + user.getId() + "  | name: " + user.getFirstName() + " " + user.getLastName()+ "  | username: " + user.getUserName());
	 
		 
		 // Now save the EmployeeProfile record to the database
		 EmployeeProfile employeeProfile = employeeProfileService.findByUserId(user.getId());
		// System.out.println("c11a:  In EmployeeController   processAddEmployeeProfileForm() method:   employeeProfile= " + employeeProfile  + "  | user.getId()= " + user.getId());
		 if (employeeProfile == null) employeeProfile = new EmployeeProfile();
		 System.out.println("c111b:  In EmployeeController   processAddEmployeeProfileForm() method:   employeeProfile= " + employeeProfile);
		 
		 employeeProfile.setTypeOfProfile("EMPLOYEE");

		 if (user != null) {
			 employeeProfile.setUser(user);
		 }		 
		 if (contactInfo!= null) {
			 employeeProfile.setContactInfo(contactInfo);
		 }
		 if (employerInfo != null) {
			 employeeProfile.setEmployerInfo(employerInfo);
		 }
		 // save the employee profile record
		 employeeProfileService.save(employeeProfile);
			 
		 ModelAndView mv = new ModelAndView("employee/add-employee-profile-confirmation");
		 mv.addObject("employeeUserProfile", theEmployeeUserProfile);
		 return mv;

	}


	
	// method to display the update employee profile page
	@GetMapping("/showUpdateEmployeeProfilePage")
	public ModelAndView showUpdateEmployeeProfilePage(HttpServletRequest request,Model theModel) {
		System.out.println("d1a:  Entering EmployeeController   showUpdateEmployeeProfilePage() method");
		ModelAndView mv = new ModelAndView("employee/update-employee-profile");
		EmployeeUserProfile employeeUserProfile = new EmployeeUserProfile();
		mv.addObject("employeeUserProfile", new EmployeeUserProfile());
		
		
		HttpSession se = request.getSession();
		User user = (User) se.getAttribute("user");
		System.out.println("d3a:  ---> In EmployeeController   showUpdateEmployeeProfilePage() method   user= " + user.getId() + " | " + user.getUserName() + " | " + user.getFirstName() + " " + user.getLastName());
		mv.addObject("user", user);
		
		// now that we have the user, use the user id to find the Employee Profile record with that user id
		EmployeeProfile employeeProfile = employeeProfileService.findByUserId(user.getId());
		System.out.println("d4a:  ---> In EmployeeController   showUpdateEmployeeProfilePage() method   employeeProfile= " + employeeProfile);
		mv.addObject("employeeProfile",employeeProfile);
		
		// from the employeeProfile record, get the Contact Info record and Employer Info record
		System.out.println("d5a:  ---> In EmployeeController   showUpdateEmployeeProfilePage() method   employeeProfile.getUser().getId()= " + employeeProfile.getUser().getId());

		System.out.println("d6a:  ---> In EmployeeController   showUpdateEmployeeProfilePage() method   employeeProfile.getContactInfo().getId()= " + employeeProfile.getContactInfo().getId());
		ContactInfo contactInfo = contactInfoService.findContactInfoById(employeeProfile.getContactInfo().getId());
		System.out.println("d6b:  ---> In EmployeeController   showUpdateEmployeeProfilePage() method   contactInfo= " + contactInfo.toString());

		System.out.println("d7a:  ---> In EmployeeController   showUpdateEmployeeProfilePage() method   employeeProfile.getEmployerInfo().getId()= " + employeeProfile.getEmployerInfo().getId());
		EmployerInfo employerInfo = employerInfoService.findEmployerInfoById(employeeProfile.getEmployerInfo().getId());
		System.out.println("d7b:  ---> In EmployeeController   showUpdateEmployeeProfilePage() method   employerInfo= " + employerInfo.toString());

		
		
		
		mv.addObject("contactInfo",contactInfo);
		List<Address> homeAddresses = new ArrayList<Address>();
		homeAddresses.add(contactInfo.getHomeAddresses().get(0));
		mv.addObject("contactInfo_homeAddresses", homeAddresses);
		System.out.println("d8a:  ---> In EmployeeController   showUpdateEmployeeProfilePage() method   homeAddresses= " + homeAddresses.toString());
		
		
		
		String state_to_find = contactInfo.getHomeAddresses().get(0).getState();
		System.out.println("d9a:  In EmployeeController  in showUpdateEmployeeProfilePage() method    state_to_find= " + state_to_find);

		int stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("d10a:  In EmployeeController  in showUpdateEmployeeProfilePage() method    state_to_find= " + state_to_find  + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("contactInfoHomeAddressStateIndx", stateOrProvinceStateIndx);
		
		
		
		
		
		mv.addObject("employerInfo",employerInfo);
		List<Address> employerAddresses = new ArrayList<Address>();
		employerAddresses.add(employerInfo.getEmployerAddresses().get(0));
		mv.addObject("employerInfo_employerAddresses",employerAddresses);
		
		
		
		state_to_find = employerInfo.getEmployerAddresses().get(0).getState();
		System.out.println("d15a:  In EmployeeController  in showUpdateEmployeeProfilePage() method    state_to_find= " + state_to_find);

		stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("d15b:  In EmployeeController  in showUpdateEmployeeProfilePage() method    state_to_find= " + state_to_find  + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("employerInfoEmployerAddressStateIndx", stateOrProvinceStateIndx);
		
		
		
		
		
		
		// get countries and states from the session object and add them to the model and view object
		List<Country> countries = (List<Country>) se.getAttribute("countries");
		System.out.println("d20a:   ---> In EmployeeController   showUpdateEmployeeProfilePage() method   countries= " + countries);

		List<StateOrProvince> statesOrProvinces = (List<StateOrProvince>)se.getAttribute("statesOrProvinces");
		System.out.println("d21a:  ---> In EmployeeController   showUpdateEmployeeProfilePage() method   statesOrProvinces= " + statesOrProvinces);

		mv.addObject("countries", countries);
		mv.addObject("statesOrProvincesForHomeAddress", statesOrProvinces);
		mv.addObject("statesOrProvincesForEmployerAddress", statesOrProvinces);

		//se.setAttribute("countries", countries);
		se.setAttribute("statesOrProvincesForHomeAddress", statesOrProvinces);
		se.setAttribute("statesOrProvincesForEmployerAddress", statesOrProvinces);
		
		
		System.out.println("d99a:  Exiting EmployeeController   showUpdateEmployeeProfilePage() method   countries= " + countries);
		System.out.println("d99b:  Exiting EmployeeController   showUpdateEmployeeProfilePage() method   statesOrProvinces= " + statesOrProvinces + "\n\n");

		 
		return mv;
	}

	
	
	
	// handler method to process the update employee profile form
	@PostMapping("/processUpdateEmployeeProfileForm")
	public ModelAndView processUpdateEmployeeProfileForm(HttpServletRequest request,
				@Valid @ModelAttribute("employeeUserProfile") EmployeeUserProfile theEmployeeUserProfile, 
				BindingResult theBindingResult, 
				Model theModel) {
		
		String contactInfoFirstName = theEmployeeUserProfile.getContactInfoFirstName();
		String contactInfoLastName = theEmployeeUserProfile.getContactInfoLastName();
		logger.info("Processing Update Employee Profile form for: " + contactInfoFirstName + " " + contactInfoLastName);
		System.out.println("e1a:  theEmployeeUserProfile:   " + theEmployeeUserProfile.toString());
		HttpSession se = request.getSession();
		
		// form validation
		 if (theBindingResult.hasErrors()){
			 System.out.println("e2a:  in processUpdateEmployeeProfileForm() method:  there are errors  | redirecting to update-employee-profile page");
			 System.out.println("e2b:  in processUpdateEmployeeProfileForm() method:  | " + theBindingResult.getAllErrors().toString());
			 ModelAndView mv = new ModelAndView("employee/update-employee-profile");
			 mv.addObject("statesOrProvincesForHomeAddress", theEmployeeUserProfile);
			 mv.addObject("countries", se.getAttribute("countries"));
			 mv.addObject("statesOrProvincesForHomeAddress",se.getAttribute("statesOrProvincesForHomeAddress"));
			 mv.addObject("statesOrProvincesForEmployerAddress",se.getAttribute("statesOrProvincesForEmployerAddress"));

			 return mv;
	        }

 
		 
		 System.out.println("e3a:  In EmployeeController   processUpdateEmployeeProfileForm() method    theEmployeeUserProfile= " + theEmployeeUserProfile);
		 Address homeAddress = null;
		 Address employerAddress = null;;

		 // update the home address in the db
		 if (!"".equals(theEmployeeUserProfile.getContactInfoHomeAddrLine1())) {
			 homeAddress = addressService.findByAddressId(theEmployeeUserProfile.getContactInfoHomeAddressId());
			 if (homeAddress == null) homeAddress = new Address();
			 
			 homeAddress.setAddressType(theEmployeeUserProfile.getContactInfoHomeAddressType());
			 homeAddress.setAddrLine1(theEmployeeUserProfile.getContactInfoHomeAddrLine1());
			 homeAddress.setAddrLine2(theEmployeeUserProfile.getContactInfoHomeAddrLine2());
			 homeAddress.setAddrLine3(theEmployeeUserProfile.getContactInfoHomeAddrLine3());
			 homeAddress.setAddrLine4(theEmployeeUserProfile.getContactInfoHomeAddrLine4());
			 homeAddress.setCity(theEmployeeUserProfile.getContactInfoHomeCity());
			 homeAddress.setState(stateOrProvinceService.findById(theEmployeeUserProfile.getContactInfoHomeState()).getStateOrProvince());
			 
			 homeAddress.setPostalCode(theEmployeeUserProfile.getContactInfoHomePostalCode());
			 homeAddress.setCountry(countryService.findByCountryCode(theEmployeeUserProfile.getContactInfoHomeCountry()).getCountryName());

			 addressService.save(homeAddress);
		 }
		 
		 // update the employer address in the db
		 if (!"".equals(theEmployeeUserProfile.getEmployerInfoEmployerAddrLine1())) {		
			 employerAddress = addressService.findByAddressId(theEmployeeUserProfile.getEmployerInfoEmployerAddressId());
			 if (employerAddress == null) employerAddress = new Address();

			 employerAddress.setAddressType(theEmployeeUserProfile.getEmployerInfoEmployerAddressType());
			 employerAddress.setAddrLine1(theEmployeeUserProfile.getEmployerInfoEmployerAddrLine1());
			 employerAddress.setAddrLine2(theEmployeeUserProfile.getEmployerInfoEmployerAddrLine2());
			 employerAddress.setAddrLine3(theEmployeeUserProfile.getEmployerInfoEmployerAddrLine3());
			 employerAddress.setAddrLine4(theEmployeeUserProfile.getEmployerInfoEmployerAddrLine4());
			 employerAddress.setCity(theEmployeeUserProfile.getEmployerInfoEmployerCity());
			 employerAddress.setState(stateOrProvinceService.findById(theEmployeeUserProfile.getEmployerInfoEmployerState()).getStateOrProvince());
			 
			 employerAddress.setPostalCode(theEmployeeUserProfile.getEmployerInfoEmployerPostalCode());
			 employerAddress.setCountry(countryService.findByCountryCode(theEmployeeUserProfile.getEmployerInfoEmployerCountry()).getCountryName());

			 addressService.save(employerAddress);
		 }
		 

		 
		 ContactInfo contactInfo = null;
		 // update the Contact Info record in the db
		 if (!"".equals(theEmployeeUserProfile.getContactInfoFirstName())) {
			 contactInfo = contactInfoService.findContactInfoById(theEmployeeUserProfile.getContactInfoId());
			 if (contactInfo == null) contactInfo = new ContactInfo();
			 
			 contactInfo.setFirstName(theEmployeeUserProfile.getContactInfoFirstName());
			 contactInfo.setLastName(theEmployeeUserProfile.getContactInfoLastName());
			 contactInfo.setPrimaryEmail(theEmployeeUserProfile.getContactInfoPrimaryEmail());
			 contactInfo.setSecondaryEmail(theEmployeeUserProfile.getContactInfoSecondaryEmail());
			 contactInfo.setHomePhoneNo(theEmployeeUserProfile.getContactInfoHomePhoneNo().toString());
			 contactInfo.setWorkPhoneNo(theEmployeeUserProfile.getContactInfoWorkPhoneNo().toString());
			 contactInfo.setCellPhoneNo(theEmployeeUserProfile.getContactInfoCellPhoneNo().toString());
			 List<Address> homeAddresses = new ArrayList<Address>();
			 homeAddresses.add(homeAddress);
			 contactInfo.setHomeAddresses(homeAddresses);
			 
			 contactInfoService.save(contactInfo);
			 
		 }
		 
		 EmployerInfo employerInfo = null;
		 // update the Employer Info record in the db 
		 if (!"".equals(theEmployeeUserProfile.getEmployerInfoEmployerName())) {
			 employerInfo = employerInfoService.findEmployerInfoById(theEmployeeUserProfile.getEmployerInfoId());
			 if (employerInfo == null) employerInfo = new EmployerInfo();

			 employerInfo.setEmployerName(theEmployeeUserProfile.getEmployerInfoEmployerName());
			 employerInfo.setEmployerPhoneNo(theEmployeeUserProfile.getEmployerInfoEmployerPhoneNo().toString());
			 List<Address> employerAddresses = new ArrayList<Address>();
			 employerAddresses.add(employerAddress);
			 employerInfo.setEmployerAddresses(employerAddresses);
			 
			 employerInfoService.save(employerInfo);
			 
		 }
		 

		 // get the user from the session and add it to the EmployeeProfile
		 User user = (User)se.getAttribute("user");
		 System.out.println("e10a:  In EmployeeController   processUpdateEmployeeProfileForm() method:   user=    id: " + user.getId() + "  | name: " + user.getFirstName() + " " + user.getLastName()+ "  | username: " + user.getUserName());
	 
		 
		 // Now update the EmployeeProfile record in the database
		 EmployeeProfile employeeProfile = employeeProfileService.findByUserId(user.getId());
		 System.out.println("e11a:  In EmployeeController   processUpdateEmployeeProfileForm() method:   employeeProfile= " + employeeProfile  + "  | user.getId()= " + user.getId());
		 if (employeeProfile == null) employeeProfile = new EmployeeProfile();
		 System.out.println("e11b:  In EmployeeController   processUpdateEmployeeProfileForm() method:   employeeProfile= " + employeeProfile);
		 
		 employeeProfile.setTypeOfProfile("EMPLOYEE");

		 if (user != null) {
			 employeeProfile.setUser(user);
		 }		 
		 if (contactInfo!= null) {
			 employeeProfile.setContactInfo(contactInfo);
		 }
		 if (employerInfo != null) {
			 employeeProfile.setEmployerInfo(employerInfo);
		 }
		 // update the employee profile record
		 employeeProfileService.save(employeeProfile);
			 
		 ModelAndView mv = new ModelAndView("employee/update-employee-profile-confirmation");
		 mv.addObject("employeeUserProfile", theEmployeeUserProfile);
		 return mv;

	}

	
	
	

	
	
	


	
	// handler method to display the display employee profile page
	@GetMapping("/showDisplayEmployeeProfilePage")
	public ModelAndView showDisplayEmployeeProfilePage(HttpServletRequest request,Model theModel) {
		System.out.println("f1a:  Entering EmployeeController   showDisplayEmployeeProfilePage() method");
		ModelAndView mv = new ModelAndView("employee/display-employee-profile");
		EmployeeUserProfile employeeUserProfile = new EmployeeUserProfile();
		mv.addObject("employeeUserProfile", new EmployeeUserProfile());
		
		
		HttpSession se = request.getSession();
		User user = (User) se.getAttribute("user");
		System.out.println("f2a:  ---> In EmployeeController   showDisplayEmployeeProfilePage() method   user= " + user.getId() + " | " + user.getUserName() + " | " + user.getFirstName() + " " + user.getLastName());
		mv.addObject("user", user);
		
		// now that we have the user, use the user id to find the Employee Profile record with that user id
		EmployeeProfile employeeProfile = employeeProfileService.findByUserId(user.getId());
		System.out.println("f3a:  ---> In EmployeeController   showDisplayEmployeeProfilePage() method   employeeProfile= " + employeeProfile);
		mv.addObject("employeeProfile",employeeProfile);
		
		// from the employeeProfile record, get the Contact Info record and Employer Info record
		System.out.println("f4a:  ---> In EmployeeController   showDisplayEmployeeProfilePage() method   employeeProfile.getUser().getId()= " + employeeProfile.getUser().getId());

		System.out.println("f5a:  ---> In EmployeeController   showDisplayEmployeeProfilePage() method   employeeProfile.getContactInfo().getId()= " + employeeProfile.getContactInfo().getId());
		ContactInfo contactInfo = contactInfoService.findContactInfoById(employeeProfile.getContactInfo().getId());
		System.out.println("f5b:  ---> In EmployeeController   showDisplayEmployeeProfilePage() method   contactInfo= " + contactInfo.toString());

		System.out.println("f6a:  ---> In EmployeeController   showDisplayEmployeeProfilePage() method   employeeProfile.getEmployerInfo().getId()= " + employeeProfile.getEmployerInfo().getId());
		EmployerInfo employerInfo = employerInfoService.findEmployerInfoById(employeeProfile.getEmployerInfo().getId());
		System.out.println("f6b:  ---> In EmployeeController   showDisplayEmployeeProfilePage() method   employerInfo= " + employerInfo.toString());

		mv.addObject("contactInfo",contactInfo);
		List<Address> homeAddresses = new ArrayList<Address>();
		homeAddresses.add(contactInfo.getHomeAddresses().get(0));
		mv.addObject("contactInfo_homeAddresses", homeAddresses);
		System.out.println("f7a:  ---> In EmployeeController   showDisplayEmployeeProfilePage() method   homeAddresses= " + homeAddresses.toString());
		
		
		
		String state_to_find = contactInfo.getHomeAddresses().get(0).getState();
		System.out.println("f8a:  In EmployeeController  in showDisplayEmployeeProfilePage() method    state_to_find= " + state_to_find);

		int stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("f9a:  In EmployeeController  in showDisplayEmployeeProfilePage() method    state_to_find= " + state_to_find  + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("contactInfoHomeAddressStateIndx", stateOrProvinceStateIndx);
		
		
		
		
		
		mv.addObject("employerInfo",employerInfo);
		List<Address> employerAddresses = new ArrayList<Address>();
		employerAddresses.add(employerInfo.getEmployerAddresses().get(0));
		mv.addObject("employerInfo_employerAddresses",employerAddresses);
		
		
		
		state_to_find = employerInfo.getEmployerAddresses().get(0).getState();
		System.out.println("f11a:  In EmployeeController  in showDisplayEmployeeProfilePage() method    state_to_find= " + state_to_find);

		stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("f12a:  In EmployeeController  in showDisplayEmployeeProfilePage() method    state_to_find= " + state_to_find  + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("employerInfoEmployerAddressStateIndx", stateOrProvinceStateIndx);
		
		
		
		
		
		
		// get countries and states from the session object and add them to the model and view object
		List<Country> countries = (List<Country>) se.getAttribute("countries");
		System.out.println("f14a:  ---> In EmployeeController   showDisplayEmployeeProfilePage() method   countries= " + countries);

		List<StateOrProvince> statesOrProvinces = (List<StateOrProvince>)se.getAttribute("statesOrProvinces");
		System.out.println("f15a:  ---> In EmployeeController   showDisplayEmployeeProfilePage() method   statesOrProvinces= " + statesOrProvinces);

		mv.addObject("countries", countries);
		mv.addObject("statesOrProvincesForHomeAddress", statesOrProvinces);
		mv.addObject("statesOrProvincesForEmployerAddress", statesOrProvinces);

		//se.setAttribute("countries", countries);
		se.setAttribute("statesOrProvincesForHomeAddress", statesOrProvinces);
		se.setAttribute("statesOrProvincesForEmployerAddress", statesOrProvinces);
		
		
		System.out.println("f99a:  Exiting EmployeeController   showDisplayEmployeeProfilePage() method   countries= " + countries);
		System.out.println("f99b:  Exiting EmployeeController   showDisplayEmployeeProfilePage() method   statesOrProvinces= " + statesOrProvinces + "\n\n");

		 
		return mv;
	}

	
	
	
	
	
	
	// handler method to display the delete employee profile page
	@PostMapping("/showDeleteEmployeeProfilePage")
	public ModelAndView showDeleteEmployeeProfilePage(HttpServletRequest request) {
		
		// TODO -- complete the rest of this method in the future

		ModelAndView mv = new ModelAndView();
		return mv;

	}
	
	// TODO --  finish the delete employee profile processing in the future
	
}
