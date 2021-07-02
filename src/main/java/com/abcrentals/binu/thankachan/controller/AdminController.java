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
import com.abcrentals.binu.thankachan.entity.AdminProfile;
import com.abcrentals.binu.thankachan.entity.Country;
import com.abcrentals.binu.thankachan.entity.EmployerInfo;
import com.abcrentals.binu.thankachan.entity.StateOrProvince;
import com.abcrentals.binu.thankachan.entity.User;
import com.abcrentals.binu.thankachan.service.AddressService;
import com.abcrentals.binu.thankachan.service.ContactInfoService;
import com.abcrentals.binu.thankachan.service.AdminProfileService;
import com.abcrentals.binu.thankachan.service.CountryService;
import com.abcrentals.binu.thankachan.service.EmployerInfoService;
import com.abcrentals.binu.thankachan.service.StateOrProvinceService;
import com.abcrentals.binu.thankachan.user.AdminUserProfile;

/*
 * Controller class to specify handler methods for users with a role of Admin
 * 
 * 
 * 
 */


@Controller
@RequestMapping("/admin")
public class AdminController {


	
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
	private AdminProfileService adminProfileService;

	
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

	// handler method to display the add admin profile page
	@GetMapping("/showAddAdminProfilePage")
	public ModelAndView showAddAdminProfilePage(HttpServletRequest request,Model theModel) {
		
		ModelAndView mv = new ModelAndView("admin/add-admin-profile");
		mv.addObject("adminUserProfile", new AdminUserProfile());
		
		
	 
		
		HttpSession se = request.getSession();
		List<Country> countries = (List<Country>) se.getAttribute("countries");
		List<StateOrProvince> statesOrProvinces = (List<StateOrProvince>)se.getAttribute("statesOrProvinces");
		mv.addObject("countries", countries);
		mv.addObject("statesOrProvincesForHomeAddress", statesOrProvinces);
		mv.addObject("statesOrProvincesForEmployerAddress", statesOrProvinces);

		se.setAttribute("countries", countries);
		se.setAttribute("statesOrProvincesForHomeAddress", statesOrProvinces);
		se.setAttribute("statesOrProvincesForEmployerAddress", statesOrProvinces);
		
		
		System.out.println("b5a: In AdminController   showAddAdminProfilePage() method   countries= " + countries);
		System.out.println("b5b: In AdminController   showAddAdminProfilePage() method   statesOrProvinces= " + statesOrProvinces + "\n\n");

		 
		return mv;
	}
	
	// handler method to process the add for the add admin profile form page
	@PostMapping("/processAddAdminProfileForm")
	public ModelAndView processAddAdminProfileForm(HttpServletRequest request,
				@Valid @ModelAttribute("adminUserProfile") AdminUserProfile theAdminUserProfile, 
				BindingResult theBindingResult, 
				Model theModel) {
		
		String contactInfoFirstName = theAdminUserProfile.getContactInfoFirstName();
		String contactInfoLastName = theAdminUserProfile.getContactInfoLastName();
		logger.info("Processing Add Admin Profile form for: " + contactInfoFirstName + " " + contactInfoLastName);
		System.out.println("c1a: theAdminUserProfile:   " + theAdminUserProfile.toString());
		HttpSession se = request.getSession();
		
		// form validation
		 if (theBindingResult.hasErrors()){
			 System.out.println("c2a: in processAddAdminProfileForm() method:  there are errors  | redirecting to add-admin-profile page");
			 System.out.println("c2b: in processAddAdminProfileForm() method:  | " + theBindingResult.getAllErrors().toString());
			 ModelAndView mv = new ModelAndView("admin/add-admin-profile");
			 mv.addObject("statesOrProvincesForHomeAddress", theAdminUserProfile);
			 mv.addObject("countries", se.getAttribute("countries"));
			 mv.addObject("statesOrProvincesForHomeAddress",se.getAttribute("statesOrProvincesForHomeAddress"));
			 mv.addObject("statesOrProvincesForEmployerAddress",se.getAttribute("statesOrProvincesForEmployerAddress"));

			 return mv;
	        }

 
		 
		 System.out.println("c3a: In AdminController   processAddAdminProfileForm() method    theAdminUserProfile= " + theAdminUserProfile);
		 Address homeAddress = new Address();
		 Address employerAddress = new Address();

		 // save the home address in the db
		 if (!"".equals(theAdminUserProfile.getContactInfoHomeAddrLine1())) {
			 homeAddress.setAddressType(theAdminUserProfile.getContactInfoHomeAddressType());
			 homeAddress.setAddrLine1(theAdminUserProfile.getContactInfoHomeAddrLine1());
			 homeAddress.setAddrLine2(theAdminUserProfile.getContactInfoHomeAddrLine2());
			 homeAddress.setAddrLine3(theAdminUserProfile.getContactInfoHomeAddrLine3());
			 homeAddress.setAddrLine4(theAdminUserProfile.getContactInfoHomeAddrLine4());
			 homeAddress.setCity(theAdminUserProfile.getContactInfoHomeCity());
			 homeAddress.setState(stateOrProvinceService.findById(theAdminUserProfile.getContactInfoHomeState()).getStateOrProvince());
			 
			 homeAddress.setPostalCode(theAdminUserProfile.getContactInfoHomePostalCode());
			 homeAddress.setCountry(countryService.findByCountryCode(theAdminUserProfile.getContactInfoHomeCountry()).getCountryName());

			 addressService.save(homeAddress);
		 }
		 
		 // save the employer address in the db
		 if (!"".equals(theAdminUserProfile.getEmployerInfoEmployerAddrLine1())) {			 
			 employerAddress.setAddressType(theAdminUserProfile.getEmployerInfoEmployerAddressType());
			 employerAddress.setAddrLine1(theAdminUserProfile.getEmployerInfoEmployerAddrLine1());
			 employerAddress.setAddrLine2(theAdminUserProfile.getEmployerInfoEmployerAddrLine2());
			 employerAddress.setAddrLine3(theAdminUserProfile.getEmployerInfoEmployerAddrLine3());
			 employerAddress.setAddrLine4(theAdminUserProfile.getEmployerInfoEmployerAddrLine4());
			 employerAddress.setCity(theAdminUserProfile.getEmployerInfoEmployerCity());
			 employerAddress.setState(stateOrProvinceService.findById(theAdminUserProfile.getEmployerInfoEmployerState()).getStateOrProvince());
			 
			 employerAddress.setPostalCode(theAdminUserProfile.getEmployerInfoEmployerPostalCode());
			 employerAddress.setCountry(countryService.findByCountryCode(theAdminUserProfile.getEmployerInfoEmployerCountry()).getCountryName());

			 addressService.save(employerAddress);
		 }
		 

		 
		 ContactInfo contactInfo = new ContactInfo();
		 // save the Contact Info record in the db, while setting home address in the join table
		 if (!"".equals(theAdminUserProfile.getContactInfoFirstName())) {
			 
			 contactInfo.setFirstName(theAdminUserProfile.getContactInfoFirstName());
			 contactInfo.setLastName(theAdminUserProfile.getContactInfoLastName());
			 contactInfo.setPrimaryEmail(theAdminUserProfile.getContactInfoPrimaryEmail());
			 contactInfo.setSecondaryEmail(theAdminUserProfile.getContactInfoSecondaryEmail());
			 contactInfo.setHomePhoneNo(theAdminUserProfile.getContactInfoHomePhoneNo().toString());
			 contactInfo.setWorkPhoneNo(theAdminUserProfile.getContactInfoWorkPhoneNo().toString());
			 contactInfo.setCellPhoneNo(theAdminUserProfile.getContactInfoCellPhoneNo().toString());
			 List<Address> homeAddresses = new ArrayList<Address>();
			 homeAddresses.add(homeAddress);
			 contactInfo.setHomeAddresses(homeAddresses);
			 
			 contactInfoService.save(contactInfo);
			 
		 }
		 
		 EmployerInfo employerInfo = new EmployerInfo();
		 // save the Employer Info record in the db, while setting employer address in the join table
		 if (!"".equals(theAdminUserProfile.getEmployerInfoEmployerName())) {

			 employerInfo.setEmployerName(theAdminUserProfile.getEmployerInfoEmployerName());
			 employerInfo.setEmployerPhoneNo(theAdminUserProfile.getEmployerInfoEmployerPhoneNo().toString());
			 List<Address> employerAddresses = new ArrayList<Address>();
			 employerAddresses.add(employerAddress);
			 employerInfo.setEmployerAddresses(employerAddresses);
			 
			 employerInfoService.save(employerInfo);
			 
		 }
		 

		 // get the user from the session and add it to the AdminProfile
		 User user = (User)se.getAttribute("user");
		 System.out.println("c8a: In AdminController   processAddAdminProfileForm() method:   user=    id: " + user.getId() + "  | name: " + user.getFirstName() + " " + user.getLastName()+ "  | username: " + user.getUserName());
	 
		 
		 // Now save the AdminProfile record to the database
		 AdminProfile adminProfile = adminProfileService.findByUserId(user.getId());
		 System.out.println("c9a: In AdminController   processAddAdminProfileForm() method:   adminProfile= " + adminProfile  + "  | user.getId()= " + user.getId());
		 if (adminProfile == null) adminProfile = new AdminProfile();
		 System.out.println("c9b: In AdminController   processAddAdminProfileForm() method:   adminProfile= " + adminProfile);
		 
		 adminProfile.setTypeOfProfile("ADMIN");

		 if (user != null) {
			 adminProfile.setUser(user);
		 }		 
		 if (contactInfo!= null) {
			 adminProfile.setContactInfo(contactInfo);
		 }
		 if (employerInfo != null) {
			 adminProfile.setEmployerInfo(employerInfo);
		 }
		 // save the admin profile record
		 adminProfileService.save(adminProfile);
			 
		 ModelAndView mv = new ModelAndView("admin/add-admin-profile-confirmation");
		 mv.addObject("adminUserProfile", theAdminUserProfile);
		 return mv;

	}


	
	// handler method to display the update admin profile page
	@GetMapping("/showUpdateAdminProfilePage")
	public ModelAndView showUpdateAdminProfilePage(HttpServletRequest request,Model theModel) {
		System.out.println("d1a: Entering AdminController   showUpdateAdminProfilePage() method");
		ModelAndView mv = new ModelAndView("admin/update-admin-profile");
		AdminUserProfile adminUserProfile = new AdminUserProfile();
		mv.addObject("adminUserProfile", new AdminUserProfile());
		
		
		HttpSession se = request.getSession();
		User user = (User) se.getAttribute("user");
		System.out.println("d2a: ---> In AdminController   showUpdateAdminProfilePage() method   user= " + user.getId() + " | " + user.getUserName() + " | " + user.getFirstName() + " " + user.getLastName());
		mv.addObject("user", user);
		
		// now that we have the user, use the user id to find the Admin Profile record with that user id
		AdminProfile adminProfile = adminProfileService.findByUserId(user.getId());
		System.out.println("d3a: ---> In AdminController   showUpdateAdminProfilePage() method   adminProfile= " + adminProfile);
		mv.addObject("adminProfile",adminProfile);
		
		// from the adminProfile record, get the Contact Info record and Employer Info record
		System.out.println("d4a: ---> In AdminController   showUpdateAdminProfilePage() method   adminProfile.getUser().getId()= " + adminProfile.getUser().getId());

		System.out.println("d5a: ---> In AdminController   showUpdateAdminProfilePage() method   adminProfile.getContactInfo().getId()= " + adminProfile.getContactInfo().getId());
		ContactInfo contactInfo = contactInfoService.findContactInfoById(adminProfile.getContactInfo().getId());
		System.out.println("d5b: ---> In AdminController   showUpdateAdminProfilePage() method   contactInfo= " + contactInfo.toString());

		System.out.println("d6a: ---> In AdminController   showUpdateAdminProfilePage() method   adminProfile.getEmployerInfo().getId()= " + adminProfile.getEmployerInfo().getId());
		EmployerInfo employerInfo = employerInfoService.findEmployerInfoById(adminProfile.getEmployerInfo().getId());
		System.out.println("d6b: ---> In AdminController   showUpdateAdminProfilePage() method   employerInfo= " + employerInfo.toString());

		mv.addObject("contactInfo",contactInfo);
		List<Address> homeAddresses = new ArrayList<Address>();
		homeAddresses.add(contactInfo.getHomeAddresses().get(0));
		mv.addObject("contactInfo_homeAddresses", homeAddresses);
		System.out.println("d7a: ---> In AdminController   showUpdateAdminProfilePage() method   homeAddresses= " + homeAddresses.toString());
		
		
		
		String state_to_find = contactInfo.getHomeAddresses().get(0).getState();
		System.out.println("d8a: In AdminController  in showUpdateAdminProfilePage() method    state_to_find= " + state_to_find);

		int stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("d9a: In AdminController  in showUpdateAdminProfilePage() method    state_to_find= " + state_to_find  + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("contactInfoHomeAddressStateIndx", stateOrProvinceStateIndx);
		
		
		
		
		
		mv.addObject("employerInfo",employerInfo);
		List<Address> employerAddresses = new ArrayList<Address>();
		employerAddresses.add(employerInfo.getEmployerAddresses().get(0));
		mv.addObject("employerInfo_employerAddresses",employerAddresses);
		
		
		
		state_to_find = employerInfo.getEmployerAddresses().get(0).getState();
		System.out.println("d11a: In AdminController  in showUpdateAdminProfilePage() method    state_to_find= " + state_to_find);

		stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("d12a: In AdminController  in showUpdateAdminProfilePage() method    state_to_find= " + state_to_find  + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("employerInfoEmployerAddressStateIndx", stateOrProvinceStateIndx);
		
		
		
		
		
		
		// get countries and states from the session object and add them to the model and view object
		List<Country> countries = (List<Country>) se.getAttribute("countries");
		System.out.println("d20a: ---> In AdminController   showUpdateAdminProfilePage() method   countries= " + countries);

		List<StateOrProvince> statesOrProvinces = (List<StateOrProvince>)se.getAttribute("statesOrProvinces");
		System.out.println("d21a: ---> In AdminController   showUpdateAdminProfilePage() method   statesOrProvinces= " + statesOrProvinces);

		mv.addObject("countries", countries);
		mv.addObject("statesOrProvincesForHomeAddress", statesOrProvinces);
		mv.addObject("statesOrProvincesForEmployerAddress", statesOrProvinces);

		//se.setAttribute("countries", countries);
		se.setAttribute("statesOrProvincesForHomeAddress", statesOrProvinces);
		se.setAttribute("statesOrProvincesForEmployerAddress", statesOrProvinces);
		
		
		System.out.println("d99a: Exiting AdminController   showUpdateAdminProfilePage() method   countries= " + countries);
		System.out.println("d99b: Exiting AdminController   showUpdateAdminProfilePage() method   statesOrProvinces= " + statesOrProvinces + "\n\n");

		 
		return mv;
	}

	
	
	
	// handler method to process the update for the admin profile form
	@PostMapping("/processUpdateAdminProfileForm")
	public ModelAndView processUpdateAdminProfileForm(HttpServletRequest request,
				@Valid @ModelAttribute("adminUserProfile") AdminUserProfile theAdminUserProfile, 
				BindingResult theBindingResult, 
				Model theModel) {
		
		String contactInfoFirstName = theAdminUserProfile.getContactInfoFirstName();
		String contactInfoLastName = theAdminUserProfile.getContactInfoLastName();
		logger.info("Processing Update Admin Profile form for: " + contactInfoFirstName + " " + contactInfoLastName);
		System.out.println("e1a: theAdminUserProfile:   " + theAdminUserProfile.toString());
		HttpSession se = request.getSession();
		
		// form validation
		 if (theBindingResult.hasErrors()){
			 System.out.println("e2a: in processUpdateAdminProfileForm() method:  there are errors  | redirecting to update-admin-profile page");
			 System.out.println("e2b: in processUpdateAdminProfileForm() method:  | " + theBindingResult.getAllErrors().toString());
			 ModelAndView mv = new ModelAndView("admin/update-admin-profile");
			 mv.addObject("statesOrProvincesForHomeAddress", theAdminUserProfile);
			 mv.addObject("countries", se.getAttribute("countries"));
			 mv.addObject("statesOrProvincesForHomeAddress",se.getAttribute("statesOrProvincesForHomeAddress"));
			 mv.addObject("statesOrProvincesForEmployerAddress",se.getAttribute("statesOrProvincesForEmployerAddress"));

			 return mv;
	        }

 
		 
		 System.out.println("e3a: In AdminController   processUpdateAdminProfileForm() method    theAdminUserProfile= " + theAdminUserProfile);
		 Address homeAddress = null;
		 Address employerAddress = null;;

		 // update the home address in the db
		 if (!"".equals(theAdminUserProfile.getContactInfoHomeAddrLine1())) {
			 homeAddress = addressService.findByAddressId(theAdminUserProfile.getContactInfoHomeAddressId());
			 if (homeAddress == null) homeAddress = new Address();
			 
			 homeAddress.setAddressType(theAdminUserProfile.getContactInfoHomeAddressType());
			 homeAddress.setAddrLine1(theAdminUserProfile.getContactInfoHomeAddrLine1());
			 homeAddress.setAddrLine2(theAdminUserProfile.getContactInfoHomeAddrLine2());
			 homeAddress.setAddrLine3(theAdminUserProfile.getContactInfoHomeAddrLine3());
			 homeAddress.setAddrLine4(theAdminUserProfile.getContactInfoHomeAddrLine4());
			 homeAddress.setCity(theAdminUserProfile.getContactInfoHomeCity());
			 homeAddress.setState(stateOrProvinceService.findById(theAdminUserProfile.getContactInfoHomeState()).getStateOrProvince());
			 
			 homeAddress.setPostalCode(theAdminUserProfile.getContactInfoHomePostalCode());
			 homeAddress.setCountry(countryService.findByCountryCode(theAdminUserProfile.getContactInfoHomeCountry()).getCountryName());

			 addressService.save(homeAddress);
		 }
		 
		 // update the employer address in the db
		 if (!"".equals(theAdminUserProfile.getEmployerInfoEmployerAddrLine1())) {		
			 employerAddress = addressService.findByAddressId(theAdminUserProfile.getEmployerInfoEmployerAddressId());
			 if (employerAddress == null) employerAddress = new Address();

			 employerAddress.setAddressType(theAdminUserProfile.getEmployerInfoEmployerAddressType());
			 employerAddress.setAddrLine1(theAdminUserProfile.getEmployerInfoEmployerAddrLine1());
			 employerAddress.setAddrLine2(theAdminUserProfile.getEmployerInfoEmployerAddrLine2());
			 employerAddress.setAddrLine3(theAdminUserProfile.getEmployerInfoEmployerAddrLine3());
			 employerAddress.setAddrLine4(theAdminUserProfile.getEmployerInfoEmployerAddrLine4());
			 employerAddress.setCity(theAdminUserProfile.getEmployerInfoEmployerCity());
			 employerAddress.setState(stateOrProvinceService.findById(theAdminUserProfile.getEmployerInfoEmployerState()).getStateOrProvince());
			 
			 employerAddress.setPostalCode(theAdminUserProfile.getEmployerInfoEmployerPostalCode());
			 employerAddress.setCountry(countryService.findByCountryCode(theAdminUserProfile.getEmployerInfoEmployerCountry()).getCountryName());

			 addressService.save(employerAddress);
		 }
		 

		 
		 ContactInfo contactInfo = null;
		 // update the Contact Info record in the db
		 if (!"".equals(theAdminUserProfile.getContactInfoFirstName())) {
			 contactInfo = contactInfoService.findContactInfoById(theAdminUserProfile.getContactInfoId());
			 if (contactInfo == null) contactInfo = new ContactInfo();
			 
			 contactInfo.setFirstName(theAdminUserProfile.getContactInfoFirstName());
			 contactInfo.setLastName(theAdminUserProfile.getContactInfoLastName());
			 contactInfo.setPrimaryEmail(theAdminUserProfile.getContactInfoPrimaryEmail());
			 contactInfo.setSecondaryEmail(theAdminUserProfile.getContactInfoSecondaryEmail());
			 contactInfo.setHomePhoneNo(theAdminUserProfile.getContactInfoHomePhoneNo().toString());
			 contactInfo.setWorkPhoneNo(theAdminUserProfile.getContactInfoWorkPhoneNo().toString());
			 contactInfo.setCellPhoneNo(theAdminUserProfile.getContactInfoCellPhoneNo().toString());
			 List<Address> homeAddresses = new ArrayList<Address>();
			 homeAddresses.add(homeAddress);
			 contactInfo.setHomeAddresses(homeAddresses);
			 
			 contactInfoService.save(contactInfo);
			 
		 }
		 
		 EmployerInfo employerInfo = null;
		 // update the Employer Info record in the db 
		 if (!"".equals(theAdminUserProfile.getEmployerInfoEmployerName())) {
			 employerInfo = employerInfoService.findEmployerInfoById(theAdminUserProfile.getEmployerInfoId());
			 if (employerInfo == null) employerInfo = new EmployerInfo();

			 employerInfo.setEmployerName(theAdminUserProfile.getEmployerInfoEmployerName());
			 employerInfo.setEmployerPhoneNo(theAdminUserProfile.getEmployerInfoEmployerPhoneNo().toString());
			 List<Address> employerAddresses = new ArrayList<Address>();
			 employerAddresses.add(employerAddress);
			 employerInfo.setEmployerAddresses(employerAddresses);
			 
			 employerInfoService.save(employerInfo);
			 
		 }
		 

		 // get the user from the session and add it to the AdminProfile
		 User user = (User)se.getAttribute("user");
		 System.out.println("e5a: In AdminController   processUpdateAdminProfileForm() method:   user=    id: " + user.getId() + "  | name: " + user.getFirstName() + " " + user.getLastName()+ "  | username: " + user.getUserName());
	 
		 
		 // Now update the AdminProfile record in the database
		 AdminProfile adminProfile = adminProfileService.findByUserId(user.getId());
		 System.out.println("e6a: In AdminController   processUpdateAdminProfileForm() method:   adminProfile= " + adminProfile  + "  | user.getId()= " + user.getId());
		 if (adminProfile == null) adminProfile = new AdminProfile();
		 System.out.println("e6b: In AdminController   processUpdateAdminProfileForm() method:   adminProfile= " + adminProfile);
		 
		 adminProfile.setTypeOfProfile("ADMIN");

		 if (user != null) {
			 adminProfile.setUser(user);
		 }		 
		 if (contactInfo!= null) {
			 adminProfile.setContactInfo(contactInfo);
		 }
		 if (employerInfo != null) {
			 adminProfile.setEmployerInfo(employerInfo);
		 }
		 // update the admin profile record
		 adminProfileService.save(adminProfile);
			 
		 ModelAndView mv = new ModelAndView("admin/update-admin-profile-confirmation");
		 mv.addObject("adminUserProfile", theAdminUserProfile);
		 return mv;

	}

	
	
	


	
	// handler method to display the display admin profile page
	@GetMapping("/showDisplayAdminProfilePage")
	public ModelAndView showDisplayAdminProfilePage(HttpServletRequest request,Model theModel) {
		System.out.println("f1a: Entering AdminController   showDisplayAdminProfilePage() method");
		ModelAndView mv = new ModelAndView("admin/display-admin-profile");
		AdminUserProfile adminUserProfile = new AdminUserProfile();
		mv.addObject("adminUserProfile", new AdminUserProfile());
		
		
		HttpSession se = request.getSession();
		User user = (User) se.getAttribute("user");
		System.out.println("f2a: ---> In AdminController   showDisplayAdminProfilePage() method   user= " + user.getId() + " | " + user.getUserName() + " | " + user.getFirstName() + " " + user.getLastName());
		mv.addObject("user", user);
		
		// now that we have the user, use the user id to find the Admin Profile record with that user id
		AdminProfile adminProfile = adminProfileService.findByUserId(user.getId());
		System.out.println("f3a: ---> In AdminController   showDisplayAdminProfilePage() method   adminProfile= " + adminProfile);
		mv.addObject("adminProfile",adminProfile);
		
		// from the adminProfile record, get the Contact Info record and Employer Info record
		System.out.println("f4a: ---> In AdminController   showDisplayAdminProfilePage() method   adminProfile.getUser().getId()= " + adminProfile.getUser().getId());

		System.out.println("f5a: ---> In AdminController   showDisplayAdminProfilePage() method   adminProfile.getContactInfo().getId()= " + adminProfile.getContactInfo().getId());
		ContactInfo contactInfo = contactInfoService.findContactInfoById(adminProfile.getContactInfo().getId());
		System.out.println("f5b: ---> In AdminController   showDisplayAdminProfilePage() method   contactInfo= " + contactInfo.toString());

		System.out.println("f6a: ---> In AdminController   showDisplayAdminProfilePage() method   adminProfile.getEmployerInfo().getId()= " + adminProfile.getEmployerInfo().getId());
		EmployerInfo employerInfo = employerInfoService.findEmployerInfoById(adminProfile.getEmployerInfo().getId());
		System.out.println("f6b: ---> In AdminController   showDisplayAdminProfilePage() method   employerInfo= " + employerInfo.toString());

		mv.addObject("contactInfo",contactInfo);
		List<Address> homeAddresses = new ArrayList<Address>();
		homeAddresses.add(contactInfo.getHomeAddresses().get(0));
		mv.addObject("contactInfo_homeAddresses", homeAddresses);
		System.out.println("f8a: ---> In AdminController   showDisplayAdminProfilePage() method   homeAddresses= " + homeAddresses.toString());
		
		
		
		String state_to_find = contactInfo.getHomeAddresses().get(0).getState();
		System.out.println("f10a: In AdminController  in showDisplayAdminProfilePage() method    state_to_find= " + state_to_find);

		int stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("f11a: In AdminController  in showDisplayAdminProfilePage() method    state_to_find= " + state_to_find  + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("contactInfoHomeAddressStateIndx", stateOrProvinceStateIndx);
		
		
		
		
		
		mv.addObject("employerInfo",employerInfo);
		List<Address> employerAddresses = new ArrayList<Address>();
		employerAddresses.add(employerInfo.getEmployerAddresses().get(0));
		mv.addObject("employerInfo_employerAddresses",employerAddresses);
		
		
		
		state_to_find = employerInfo.getEmployerAddresses().get(0).getState();
		System.out.println("f14a: In AdminController  in showDisplayAdminProfilePage() method    state_to_find= " + state_to_find);

		stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("f15a: In AdminController  in showDisplayAdminProfilePage() method    state_to_find= " + state_to_find  + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("employerInfoEmployerAddressStateIndx", stateOrProvinceStateIndx);
		
		
		
		
		
		
		// get countries and states from the session object and add them to the model and view object
		List<Country> countries = (List<Country>) se.getAttribute("countries");
		System.out.println("f16a: ---> In AdminController   showDisplayAdminProfilePage() method   countries= " + countries);

		List<StateOrProvince> statesOrProvinces = (List<StateOrProvince>)se.getAttribute("statesOrProvinces");
		System.out.println("f17a: ---> In AdminController   showDisplayAdminProfilePage() method   statesOrProvinces= " + statesOrProvinces);

		mv.addObject("countries", countries);
		mv.addObject("statesOrProvincesForHomeAddress", statesOrProvinces);
		mv.addObject("statesOrProvincesForEmployerAddress", statesOrProvinces);

		//se.setAttribute("countries", countries);
		se.setAttribute("statesOrProvincesForHomeAddress", statesOrProvinces);
		se.setAttribute("statesOrProvincesForEmployerAddress", statesOrProvinces);
		
		
		System.out.println("f99a: Exiting AdminController   showDisplayAdminProfilePage() method   countries= " + countries);
		System.out.println("f99b: Exiting AdminController   showDisplayAdminProfilePage() method   statesOrProvinces= " + statesOrProvinces + "\n\n");

		 
		return mv;
	}

	
	
	// handler method to display the delete admin profile page
	@PostMapping("/showDeleteAdminProfilePage")
	public ModelAndView showDeleteAdminProfilePage(HttpServletRequest request) {
		
		// TODO -- complete the rest of this method in the future
		
		ModelAndView mv = new ModelAndView();
		return mv;

	}
	
	// TODO --  finish the delete admin profile processing in the future
	
	
	
	
}
