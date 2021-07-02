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
import com.abcrentals.binu.thankachan.entity.OwnerProfile;
import com.abcrentals.binu.thankachan.entity.Country;
import com.abcrentals.binu.thankachan.entity.EmployerInfo;
import com.abcrentals.binu.thankachan.entity.StateOrProvince;
import com.abcrentals.binu.thankachan.entity.User;
import com.abcrentals.binu.thankachan.service.AddressService;
import com.abcrentals.binu.thankachan.service.ContactInfoService;
import com.abcrentals.binu.thankachan.service.OwnerProfileService;
import com.abcrentals.binu.thankachan.service.CountryService;
import com.abcrentals.binu.thankachan.service.EmployerInfoService;
import com.abcrentals.binu.thankachan.service.StateOrProvinceService;
import com.abcrentals.binu.thankachan.user.OwnerUserProfile;

/*
 * Controller class to specify handler methods for users with a role of Owner
 * 
 * 
 * 
 */


@Controller
@RequestMapping("/owner")
public class OwnerController {


	
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
	private OwnerProfileService ownerProfileService;

	
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

    // handler method to display the add owner profile page	
	@GetMapping("/showAddOwnerProfilePage")
	public ModelAndView showAddOwnerProfilePage(HttpServletRequest request,Model theModel) {
		
		ModelAndView mv = new ModelAndView("owner/add-owner-profile");
		mv.addObject("ownerUserProfile", new OwnerUserProfile());
		
		
	 
		
		HttpSession se = request.getSession();
		List<Country> countries = (List<Country>) se.getAttribute("countries");
		List<StateOrProvince> statesOrProvinces = (List<StateOrProvince>)se.getAttribute("statesOrProvinces");
		mv.addObject("countries", countries);
		mv.addObject("statesOrProvincesForHomeAddress", statesOrProvinces);
		mv.addObject("statesOrProvincesForEmployerAddress", statesOrProvinces);

		se.setAttribute("countries", countries);
		se.setAttribute("statesOrProvincesForHomeAddress", statesOrProvinces);
		se.setAttribute("statesOrProvincesForEmployerAddress", statesOrProvinces);
		
		
		System.out.println("b5a: In OwnerController   showAddOwnerProfilePage() method   countries= " + countries);
		System.out.println("b5b: In OwnerController   showAddOwnerProfilePage() method   statesOrProvinces= " + statesOrProvinces + "\n\n");

		 
		return mv;
	}
	
    // handler method to process the add owner profile form
	@PostMapping("/processAddOwnerProfileForm")
	public ModelAndView processAddOwnerProfileForm(HttpServletRequest request,
				@Valid @ModelAttribute("ownerUserProfile") OwnerUserProfile theOwnerUserProfile, 
				BindingResult theBindingResult, 
				Model theModel) {
		
		String contactInfoFirstName = theOwnerUserProfile.getContactInfoFirstName();
		String contactInfoLastName = theOwnerUserProfile.getContactInfoLastName();
		logger.info("Processing Add Owner Profile form for: " + contactInfoFirstName + " " + contactInfoLastName);
		System.out.println("c1a: theOwnerUserProfile:   " + theOwnerUserProfile.toString());
		HttpSession se = request.getSession();
		
		// form validation
		 if (theBindingResult.hasErrors()){
			 System.out.println("c2a: in processAddOwnerProfileForm() method:  there are errors  | redirecting to add-owner-profile page");
			 System.out.println("c2b: in processAddOwnerProfileForm() method:  | " + theBindingResult.getAllErrors().toString());
			 ModelAndView mv = new ModelAndView("owner/add-owner-profile");
			 mv.addObject("statesOrProvincesForHomeAddress", theOwnerUserProfile);
			 mv.addObject("countries", se.getAttribute("countries"));
			 mv.addObject("statesOrProvincesForHomeAddress",se.getAttribute("statesOrProvincesForHomeAddress"));
			 mv.addObject("statesOrProvincesForEmployerAddress",se.getAttribute("statesOrProvincesForEmployerAddress"));

			 return mv;
	        }

 
		 
		 System.out.println("c3a: In OwnerController   processAddOwnerProfileForm() method    theOwnerUserProfile= " + theOwnerUserProfile);
		 Address homeAddress = new Address();
		 Address employerAddress = new Address();

		 // save the home address in the db
		 if (!"".equals(theOwnerUserProfile.getContactInfoHomeAddrLine1())) {
			 homeAddress.setAddressType(theOwnerUserProfile.getContactInfoHomeAddressType());
			 homeAddress.setAddrLine1(theOwnerUserProfile.getContactInfoHomeAddrLine1());
			 homeAddress.setAddrLine2(theOwnerUserProfile.getContactInfoHomeAddrLine2());
			 homeAddress.setAddrLine3(theOwnerUserProfile.getContactInfoHomeAddrLine3());
			 homeAddress.setAddrLine4(theOwnerUserProfile.getContactInfoHomeAddrLine4());
			 homeAddress.setCity(theOwnerUserProfile.getContactInfoHomeCity());
			 homeAddress.setState(stateOrProvinceService.findById(theOwnerUserProfile.getContactInfoHomeState()).getStateOrProvince());
			 
			 homeAddress.setPostalCode(theOwnerUserProfile.getContactInfoHomePostalCode());
			 homeAddress.setCountry(countryService.findByCountryCode(theOwnerUserProfile.getContactInfoHomeCountry()).getCountryName());

			 addressService.save(homeAddress);
		 }
		 
		 // save the employer address in the db
		 if (!"".equals(theOwnerUserProfile.getEmployerInfoEmployerAddrLine1())) {			 
			 employerAddress.setAddressType(theOwnerUserProfile.getEmployerInfoEmployerAddressType());
			 employerAddress.setAddrLine1(theOwnerUserProfile.getEmployerInfoEmployerAddrLine1());
			 employerAddress.setAddrLine2(theOwnerUserProfile.getEmployerInfoEmployerAddrLine2());
			 employerAddress.setAddrLine3(theOwnerUserProfile.getEmployerInfoEmployerAddrLine3());
			 employerAddress.setAddrLine4(theOwnerUserProfile.getEmployerInfoEmployerAddrLine4());
			 employerAddress.setCity(theOwnerUserProfile.getEmployerInfoEmployerCity());
			 employerAddress.setState(stateOrProvinceService.findById(theOwnerUserProfile.getEmployerInfoEmployerState()).getStateOrProvince());
			 
			 employerAddress.setPostalCode(theOwnerUserProfile.getEmployerInfoEmployerPostalCode());
			 employerAddress.setCountry(countryService.findByCountryCode(theOwnerUserProfile.getEmployerInfoEmployerCountry()).getCountryName());

			 addressService.save(employerAddress);
		 }
		 

		 
		 ContactInfo contactInfo = new ContactInfo();
		 // save the Contact Info record in the db, while setting home address in the join table
		 if (!"".equals(theOwnerUserProfile.getContactInfoFirstName())) {
			 
			 contactInfo.setFirstName(theOwnerUserProfile.getContactInfoFirstName());
			 contactInfo.setLastName(theOwnerUserProfile.getContactInfoLastName());
			 contactInfo.setPrimaryEmail(theOwnerUserProfile.getContactInfoPrimaryEmail());
			 contactInfo.setSecondaryEmail(theOwnerUserProfile.getContactInfoSecondaryEmail());
			 contactInfo.setHomePhoneNo(theOwnerUserProfile.getContactInfoHomePhoneNo().toString());
			 contactInfo.setWorkPhoneNo(theOwnerUserProfile.getContactInfoWorkPhoneNo().toString());
			 contactInfo.setCellPhoneNo(theOwnerUserProfile.getContactInfoCellPhoneNo().toString());
			 List<Address> homeAddresses = new ArrayList<Address>();
			 homeAddresses.add(homeAddress);
			 contactInfo.setHomeAddresses(homeAddresses);
			 
			 contactInfoService.save(contactInfo);
			 
		 }
		 
		 EmployerInfo employerInfo = new EmployerInfo();
		 // save the Employer Info record in the db, while setting employer address in the join table
		 if (!"".equals(theOwnerUserProfile.getEmployerInfoEmployerName())) {

			 employerInfo.setEmployerName(theOwnerUserProfile.getEmployerInfoEmployerName());
			 employerInfo.setEmployerPhoneNo(theOwnerUserProfile.getEmployerInfoEmployerPhoneNo().toString());
			 List<Address> employerAddresses = new ArrayList<Address>();
			 employerAddresses.add(employerAddress);
			 employerInfo.setEmployerAddresses(employerAddresses);
			 
			 employerInfoService.save(employerInfo);
			 
		 }
		 

		 // get the user from the session and add it to the OwnerProfile
		 User user = (User)se.getAttribute("user");
		 System.out.println("c8a: In OwnerController   processAddOwnerProfileForm() method:   user=    id: " + user.getId() + "  | name: " + user.getFirstName() + " " + user.getLastName()+ "  | username: " + user.getUserName());
	 
		 
		 // Now save the OwnerProfile record to the database
		 OwnerProfile ownerProfile = ownerProfileService.findByUserId(user.getId());
		 System.out.println("c9a: In OwnerController   processAddOwnerProfileForm() method:   ownerProfile= " + ownerProfile  + "  | user.getId()= " + user.getId());
		 if (ownerProfile == null) ownerProfile = new OwnerProfile();
		 System.out.println("c9b: In OwnerController   processAddOwnerProfileForm() method:   ownerProfile= " + ownerProfile);
		 
		 ownerProfile.setTypeOfProfile("OWNER");

		 if (user != null) {
			 ownerProfile.setUser(user);
		 }		 
		 if (contactInfo!= null) {
			 ownerProfile.setContactInfo(contactInfo);
		 }
		 if (employerInfo != null) {
			 ownerProfile.setEmployerInfo(employerInfo);
		 }
		 // save the owner profile record
		 ownerProfileService.save(ownerProfile);
			 
		 ModelAndView mv = new ModelAndView("owner/add-owner-profile-confirmation");
		 mv.addObject("ownerUserProfile", theOwnerUserProfile);
		 return mv;

	}


	
    // handler method to display the owner profile page	
	@GetMapping("/showUpdateOwnerProfilePage")
	public ModelAndView showUpdateOwnerProfilePage(HttpServletRequest request,Model theModel) {
		System.out.println("d1a: Entering OwnerController   showUpdateOwnerProfilePage() method");
		ModelAndView mv = new ModelAndView("owner/update-owner-profile");
		OwnerUserProfile ownerUserProfile = new OwnerUserProfile();
		mv.addObject("ownerUserProfile", new OwnerUserProfile());
		
		
		HttpSession se = request.getSession();
		User user = (User) se.getAttribute("user");
		System.out.println("d2a: ---> In OwnerController   showUpdateOwnerProfilePage() method   user= " + user.getId() + " | " + user.getUserName() + " | " + user.getFirstName() + " " + user.getLastName());
		mv.addObject("user", user);
		
		// now that we have the user, use the user id to find the Owner Profile record with that user id
		OwnerProfile ownerProfile = ownerProfileService.findByUserId(user.getId());
		System.out.println("d3a: ---> In OwnerController   showUpdateOwnerProfilePage() method   ownerProfile= " + ownerProfile);
		mv.addObject("ownerProfile",ownerProfile);
		
		// from the ownerProfile record, get the Contact Info record and Employer Info record
		System.out.println("d4a: ---> In OwnerController   showUpdateOwnerProfilePage() method   ownerProfile.getUser().getId()= " + ownerProfile.getUser().getId());

		System.out.println("d5a: ---> In OwnerController   showUpdateOwnerProfilePage() method   ownerProfile.getContactInfo().getId()= " + ownerProfile.getContactInfo().getId());
		ContactInfo contactInfo = contactInfoService.findContactInfoById(ownerProfile.getContactInfo().getId());
		System.out.println("d5b: ---> In OwnerController   showUpdateOwnerProfilePage() method   contactInfo= " + contactInfo.toString());

		System.out.println("d6a: ---> In OwnerController   showUpdateOwnerProfilePage() method   ownerProfile.getEmployerInfo().getId()= " + ownerProfile.getEmployerInfo().getId());
		EmployerInfo employerInfo = employerInfoService.findEmployerInfoById(ownerProfile.getEmployerInfo().getId());
		System.out.println("d6b: ---> In OwnerController   showUpdateOwnerProfilePage() method   employerInfo= " + employerInfo.toString());

		mv.addObject("contactInfo",contactInfo);
		List<Address> homeAddresses = new ArrayList<Address>();
		homeAddresses.add(contactInfo.getHomeAddresses().get(0));
		mv.addObject("contactInfo_homeAddresses", homeAddresses);
		System.out.println("d7a: ---> In OwnerController   showUpdateOwnerProfilePage() method   homeAddresses= " + homeAddresses.toString());
		
		
		
		String state_to_find = contactInfo.getHomeAddresses().get(0).getState();
		System.out.println("d8a: In OwnerController  in showUpdateOwnerProfilePage() method    state_to_find= " + state_to_find);

		int stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("d9a: In OwnerController  in showUpdateOwnerProfilePage() method    state_to_find= " + state_to_find  + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("contactInfoHomeAddressStateIndx", stateOrProvinceStateIndx);
		
		
		
		
		
		mv.addObject("employerInfo",employerInfo);
		List<Address> employerAddresses = new ArrayList<Address>();
		employerAddresses.add(employerInfo.getEmployerAddresses().get(0));
		mv.addObject("employerInfo_employerAddresses",employerAddresses);
		
		
		
		state_to_find = employerInfo.getEmployerAddresses().get(0).getState();
		System.out.println("d11a: In OwnerController  in showUpdateOwnerProfilePage() method    state_to_find= " + state_to_find);

		stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("d12a: In OwnerController  in showUpdateOwnerProfilePage() method    state_to_find= " + state_to_find  + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("employerInfoEmployerAddressStateIndx", stateOrProvinceStateIndx);
		
		
		
		
		
		
		// get countries and states from the session object and add them to the model and view object
		List<Country> countries = (List<Country>) se.getAttribute("countries");
		System.out.println("d20a: ---> In OwnerController   showUpdateOwnerProfilePage() method   countries= " + countries);

		List<StateOrProvince> statesOrProvinces = (List<StateOrProvince>)se.getAttribute("statesOrProvinces");
		System.out.println("d21a: ---> In OwnerController   showUpdateOwnerProfilePage() method   statesOrProvinces= " + statesOrProvinces);

		mv.addObject("countries", countries);
		mv.addObject("statesOrProvincesForHomeAddress", statesOrProvinces);
		mv.addObject("statesOrProvincesForEmployerAddress", statesOrProvinces);

		//se.setAttribute("countries", countries);
		se.setAttribute("statesOrProvincesForHomeAddress", statesOrProvinces);
		se.setAttribute("statesOrProvincesForEmployerAddress", statesOrProvinces);
		
		
		System.out.println("d99a: Exiting OwnerController   showUpdateOwnerProfilePage() method   countries= " + countries);
		System.out.println("d99b: Exiting OwnerController   showUpdateOwnerProfilePage() method   statesOrProvinces= " + statesOrProvinces + "\n\n");

		 
		return mv;
	}

	
	
	
    // handler method to process the update owner profile form	
	@PostMapping("/processUpdateOwnerProfileForm")
	public ModelAndView processUpdateOwnerProfileForm(HttpServletRequest request,
				@Valid @ModelAttribute("ownerUserProfile") OwnerUserProfile theOwnerUserProfile, 
				BindingResult theBindingResult, 
				Model theModel) {
		
		String contactInfoFirstName = theOwnerUserProfile.getContactInfoFirstName();
		String contactInfoLastName = theOwnerUserProfile.getContactInfoLastName();
		logger.info("Processing Update Owner Profile form for: " + contactInfoFirstName + " " + contactInfoLastName);
		System.out.println("e1a: theOwnerUserProfile:   " + theOwnerUserProfile.toString());
		HttpSession se = request.getSession();
		
		// form validation
		 if (theBindingResult.hasErrors()){
			 System.out.println("e2a: in processUpdateOwnerProfileForm() method:  there are errors  | redirecting to update-owner-profile page");
			 System.out.println("e2b: in processUpdateOwnerProfileForm() method:  | " + theBindingResult.getAllErrors().toString());
			 ModelAndView mv = new ModelAndView("owner/update-owner-profile");
			 mv.addObject("statesOrProvincesForHomeAddress", theOwnerUserProfile);
			 mv.addObject("countries", se.getAttribute("countries"));
			 mv.addObject("statesOrProvincesForHomeAddress",se.getAttribute("statesOrProvincesForHomeAddress"));
			 mv.addObject("statesOrProvincesForEmployerAddress",se.getAttribute("statesOrProvincesForEmployerAddress"));

			 return mv;
	        }

 
		 
		 System.out.println("e3a: In OwnerController   processUpdateOwnerProfileForm() method    theOwnerUserProfile= " + theOwnerUserProfile);
		 Address homeAddress = null;
		 Address employerAddress = null;;

		 // update the home address in the db
		 if (!"".equals(theOwnerUserProfile.getContactInfoHomeAddrLine1())) {
			 homeAddress = addressService.findByAddressId(theOwnerUserProfile.getContactInfoHomeAddressId());
			 if (homeAddress == null) homeAddress = new Address();
			 
			 homeAddress.setAddressType(theOwnerUserProfile.getContactInfoHomeAddressType());
			 homeAddress.setAddrLine1(theOwnerUserProfile.getContactInfoHomeAddrLine1());
			 homeAddress.setAddrLine2(theOwnerUserProfile.getContactInfoHomeAddrLine2());
			 homeAddress.setAddrLine3(theOwnerUserProfile.getContactInfoHomeAddrLine3());
			 homeAddress.setAddrLine4(theOwnerUserProfile.getContactInfoHomeAddrLine4());
			 homeAddress.setCity(theOwnerUserProfile.getContactInfoHomeCity());
			 homeAddress.setState(stateOrProvinceService.findById(theOwnerUserProfile.getContactInfoHomeState()).getStateOrProvince());
			 
			 homeAddress.setPostalCode(theOwnerUserProfile.getContactInfoHomePostalCode());
			 homeAddress.setCountry(countryService.findByCountryCode(theOwnerUserProfile.getContactInfoHomeCountry()).getCountryName());

			 addressService.save(homeAddress);
		 }
		 
		 // update the employer address in the db
		 if (!"".equals(theOwnerUserProfile.getEmployerInfoEmployerAddrLine1())) {		
			 employerAddress = addressService.findByAddressId(theOwnerUserProfile.getEmployerInfoEmployerAddressId());
			 if (employerAddress == null) employerAddress = new Address();

			 employerAddress.setAddressType(theOwnerUserProfile.getEmployerInfoEmployerAddressType());
			 employerAddress.setAddrLine1(theOwnerUserProfile.getEmployerInfoEmployerAddrLine1());
			 employerAddress.setAddrLine2(theOwnerUserProfile.getEmployerInfoEmployerAddrLine2());
			 employerAddress.setAddrLine3(theOwnerUserProfile.getEmployerInfoEmployerAddrLine3());
			 employerAddress.setAddrLine4(theOwnerUserProfile.getEmployerInfoEmployerAddrLine4());
			 employerAddress.setCity(theOwnerUserProfile.getEmployerInfoEmployerCity());
			 employerAddress.setState(stateOrProvinceService.findById(theOwnerUserProfile.getEmployerInfoEmployerState()).getStateOrProvince());
			 
			 employerAddress.setPostalCode(theOwnerUserProfile.getEmployerInfoEmployerPostalCode());
			 employerAddress.setCountry(countryService.findByCountryCode(theOwnerUserProfile.getEmployerInfoEmployerCountry()).getCountryName());

			 addressService.save(employerAddress);
		 }
		 

		 
		 ContactInfo contactInfo = null;
		 // update the Contact Info record in the db
		 if (!"".equals(theOwnerUserProfile.getContactInfoFirstName())) {
			 contactInfo = contactInfoService.findContactInfoById(theOwnerUserProfile.getContactInfoId());
			 if (contactInfo == null) contactInfo = new ContactInfo();
			 
			 contactInfo.setFirstName(theOwnerUserProfile.getContactInfoFirstName());
			 contactInfo.setLastName(theOwnerUserProfile.getContactInfoLastName());
			 contactInfo.setPrimaryEmail(theOwnerUserProfile.getContactInfoPrimaryEmail());
			 contactInfo.setSecondaryEmail(theOwnerUserProfile.getContactInfoSecondaryEmail());
			 contactInfo.setHomePhoneNo(theOwnerUserProfile.getContactInfoHomePhoneNo().toString());
			 contactInfo.setWorkPhoneNo(theOwnerUserProfile.getContactInfoWorkPhoneNo().toString());
			 contactInfo.setCellPhoneNo(theOwnerUserProfile.getContactInfoCellPhoneNo().toString());
			 List<Address> homeAddresses = new ArrayList<Address>();
			 homeAddresses.add(homeAddress);
			 contactInfo.setHomeAddresses(homeAddresses);
			 
			 contactInfoService.save(contactInfo);
			 
		 }
		 
		 EmployerInfo employerInfo = null;
		 // update the Employer Info record in the db 
		 if (!"".equals(theOwnerUserProfile.getEmployerInfoEmployerName())) {
			 employerInfo = employerInfoService.findEmployerInfoById(theOwnerUserProfile.getEmployerInfoId());
			 if (employerInfo == null) employerInfo = new EmployerInfo();

			 employerInfo.setEmployerName(theOwnerUserProfile.getEmployerInfoEmployerName());
			 employerInfo.setEmployerPhoneNo(theOwnerUserProfile.getEmployerInfoEmployerPhoneNo().toString());
			 List<Address> employerAddresses = new ArrayList<Address>();
			 employerAddresses.add(employerAddress);
			 employerInfo.setEmployerAddresses(employerAddresses);
			 
			 employerInfoService.save(employerInfo);
			 
		 }
		 

		 // get the user from the session and add it to the OwnerProfile
		 User user = (User)se.getAttribute("user");
		 System.out.println("e5a: In OwnerController   processUpdateOwnerProfileForm() method:   user=    id: " + user.getId() + "  | name: " + user.getFirstName() + " " + user.getLastName()+ "  | username: " + user.getUserName());
	 
		 
		 // Now update the OwnerProfile record in the database
		 OwnerProfile ownerProfile = ownerProfileService.findByUserId(user.getId());
		 System.out.println("e6a: In OwnerController   processUpdateOwnerProfileForm() method:   ownerProfile= " + ownerProfile  + "  | user.getId()= " + user.getId());
		 if (ownerProfile == null) ownerProfile = new OwnerProfile();
		 System.out.println("e6b: In OwnerController   processUpdateOwnerProfileForm() method:   ownerProfile= " + ownerProfile);
		 
		 ownerProfile.setTypeOfProfile("OWNER");

		 if (user != null) {
			 ownerProfile.setUser(user);
		 }		 
		 if (contactInfo!= null) {
			 ownerProfile.setContactInfo(contactInfo);
		 }
		 if (employerInfo != null) {
			 ownerProfile.setEmployerInfo(employerInfo);
		 }
		 // update the owner profile record
		 ownerProfileService.save(ownerProfile);
			 
		 ModelAndView mv = new ModelAndView("owner/update-owner-profile-confirmation");
		 mv.addObject("ownerUserProfile", theOwnerUserProfile);
		 return mv;

	}

	
	
	


	
    // handler method to display the owner profile page	
	@GetMapping("/showDisplayOwnerProfilePage")
	public ModelAndView showDisplayOwnerProfilePage(HttpServletRequest request,Model theModel) {
		System.out.println("f1a: Entering OwnerController   showDisplayOwnerProfilePage() method");
		ModelAndView mv = new ModelAndView("owner/display-owner-profile");
		OwnerUserProfile ownerUserProfile = new OwnerUserProfile();
		mv.addObject("ownerUserProfile", new OwnerUserProfile());
		
		
		HttpSession se = request.getSession();
		User user = (User) se.getAttribute("user");
		System.out.println("f2a: ---> In OwnerController   showDisplayOwnerProfilePage() method   user= " + user.getId() + " | " + user.getUserName() + " | " + user.getFirstName() + " " + user.getLastName());
		mv.addObject("user", user);
		
		// now that we have the user, use the user id to find the Owner Profile record with that user id
		OwnerProfile ownerProfile = ownerProfileService.findByUserId(user.getId());
		System.out.println("f3a: ---> In OwnerController   showDisplayOwnerProfilePage() method   ownerProfile= " + ownerProfile);
		mv.addObject("ownerProfile",ownerProfile);
		
		// from the ownerProfile record, get the Contact Info record and Employer Info record
		System.out.println("f4a: ---> In OwnerController   showDisplayOwnerProfilePage() method   ownerProfile.getUser().getId()= " + ownerProfile.getUser().getId());

		System.out.println("f5a: ---> In OwnerController   showDisplayOwnerProfilePage() method   ownerProfile.getContactInfo().getId()= " + ownerProfile.getContactInfo().getId());
		ContactInfo contactInfo = contactInfoService.findContactInfoById(ownerProfile.getContactInfo().getId());
		System.out.println("f5b: ---> In OwnerController   showDisplayOwnerProfilePage() method   contactInfo= " + contactInfo.toString());

		System.out.println("f6a: ---> In OwnerController   showDisplayOwnerProfilePage() method   ownerProfile.getEmployerInfo().getId()= " + ownerProfile.getEmployerInfo().getId());
		EmployerInfo employerInfo = employerInfoService.findEmployerInfoById(ownerProfile.getEmployerInfo().getId());
		System.out.println("f6b: ---> In OwnerController   showDisplayOwnerProfilePage() method   employerInfo= " + employerInfo.toString());

		mv.addObject("contactInfo",contactInfo);
		List<Address> homeAddresses = new ArrayList<Address>();
		homeAddresses.add(contactInfo.getHomeAddresses().get(0));
		mv.addObject("contactInfo_homeAddresses", homeAddresses);
		System.out.println("f8a: ---> In OwnerController   showDisplayOwnerProfilePage() method   homeAddresses= " + homeAddresses.toString());
		
		
		
		String state_to_find = contactInfo.getHomeAddresses().get(0).getState();
		System.out.println("f10a: In OwnerController  in showDisplayOwnerProfilePage() method    state_to_find= " + state_to_find);

		int stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("f11a: In OwnerController  in showDisplayOwnerProfilePage() method    state_to_find= " + state_to_find  + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("contactInfoHomeAddressStateIndx", stateOrProvinceStateIndx);
		
		
		
		
		
		mv.addObject("employerInfo",employerInfo);
		List<Address> employerAddresses = new ArrayList<Address>();
		employerAddresses.add(employerInfo.getEmployerAddresses().get(0));
		mv.addObject("employerInfo_employerAddresses",employerAddresses);
		
		
		
		state_to_find = employerInfo.getEmployerAddresses().get(0).getState();
		System.out.println("f14a: In OwnerController  in showDisplayOwnerProfilePage() method    state_to_find= " + state_to_find);

		stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("f15a: In OwnerController  in showDisplayOwnerProfilePage() method    state_to_find= " + state_to_find  + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("employerInfoEmployerAddressStateIndx", stateOrProvinceStateIndx);
		
		
		
		
		
		
		// get countries and states from the session object and add them to the model and view object
		List<Country> countries = (List<Country>) se.getAttribute("countries");
		System.out.println("f16a: ---> In OwnerController   showDisplayOwnerProfilePage() method   countries= " + countries);

		List<StateOrProvince> statesOrProvinces = (List<StateOrProvince>)se.getAttribute("statesOrProvinces");
		System.out.println("f17a: ---> In OwnerController   showDisplayOwnerProfilePage() method   statesOrProvinces= " + statesOrProvinces);

		mv.addObject("countries", countries);
		mv.addObject("statesOrProvincesForHomeAddress", statesOrProvinces);
		mv.addObject("statesOrProvincesForEmployerAddress", statesOrProvinces);

		//se.setAttribute("countries", countries);
		se.setAttribute("statesOrProvincesForHomeAddress", statesOrProvinces);
		se.setAttribute("statesOrProvincesForEmployerAddress", statesOrProvinces);
		
		
		System.out.println("f99a: Exiting OwnerController   showDisplayOwnerProfilePage() method   countries= " + countries);
		System.out.println("f99b: Exiting OwnerController   showDisplayOwnerProfilePage() method   statesOrProvinces= " + statesOrProvinces + "\n\n");

		 
		return mv;
	}

	
	
    // handler method to display the delete owner profile page	
	@PostMapping("/showDeleteOwnerProfilePage")
	public ModelAndView showDeleteOwnerProfilePage(HttpServletRequest request) {
		
		// TODO -- complete the rest of this method in the future
		
		ModelAndView mv = new ModelAndView();
		return mv;

	}
	
	// TODO -- complete the processing of the delete owner profile in the future
	
	
}
