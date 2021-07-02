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
import com.abcrentals.binu.thankachan.entity.ContractorProfile;
import com.abcrentals.binu.thankachan.entity.Country;
import com.abcrentals.binu.thankachan.entity.EmployerInfo;
import com.abcrentals.binu.thankachan.entity.StateOrProvince;
import com.abcrentals.binu.thankachan.entity.User;
import com.abcrentals.binu.thankachan.service.AddressService;
import com.abcrentals.binu.thankachan.service.ContactInfoService;
import com.abcrentals.binu.thankachan.service.ContractorProfileService;
import com.abcrentals.binu.thankachan.service.CountryService;
import com.abcrentals.binu.thankachan.service.EmployerInfoService;
import com.abcrentals.binu.thankachan.service.StateOrProvinceService;
import com.abcrentals.binu.thankachan.user.ContractorUserProfile;

/*
 * Controller class to specify handler methods for users with a role of Contractor
 * 
 * 
 * 
 */


@Controller
@RequestMapping("/contractor")
public class ContractorController {


	
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
	private ContractorProfileService contractorProfileService;

	
	// method to load countries list as model attribute and countries and statesOrProvinces lists as session attributes
	@ModelAttribute("countries")
	public List<Country> initializeCountries(HttpServletRequest request) {

	    List <Country> countries = countryService.findAllCountries();
	    Country country = countryService.findAllCountries().get(0);
	    
	    HttpSession se = request.getSession();
	    se.setAttribute("countries", countries);
		List<StateOrProvince> statesOrProvinces = stateOrProvinceService.findByCountry(country.getCountryName());
		se.setAttribute("statesOrProvinces", statesOrProvinces);
	    
	    System.out.println("in RenterController class initializeCountry() method:  countries= " + countries.toString());
		System.out.println("In RenterController   initializeCountries() method   country= " + countries);
		System.out.println("In RenterController   initializeCountries() method   country.getCountryName()= " + country.getCountryName());
		System.out.println("In RenterController   initializeCountries() method   statesOrProvinces= " + statesOrProvinces + "\n\n");


	    return countries;
	}  	

	// handler method to display the add contractor profile page
	@GetMapping("/showAddContractorProfilePage")
	public ModelAndView showAddContractorProfilePage(HttpServletRequest request,Model theModel) {
		
		ModelAndView mv = new ModelAndView("contractor/add-contractor-profile");
		mv.addObject("contractorUserProfile", new ContractorUserProfile());
		
		
	 
		
		HttpSession se = request.getSession();
		List<Country> countries = (List<Country>) se.getAttribute("countries");
		List<StateOrProvince> statesOrProvinces = (List<StateOrProvince>)se.getAttribute("statesOrProvinces");
		mv.addObject("countries", countries);
		mv.addObject("statesOrProvincesForHomeAddress", statesOrProvinces);
		mv.addObject("statesOrProvincesForEmployerAddress", statesOrProvinces);

		se.setAttribute("countries", countries);
		se.setAttribute("statesOrProvincesForHomeAddress", statesOrProvinces);
		se.setAttribute("statesOrProvincesForEmployerAddress", statesOrProvinces);
		
		
		System.out.println("In ContractorController   showAddContractorProfilePage() method   countries= " + countries);
		System.out.println("In ContractorController   showAddContractorProfilePage() method   statesOrProvinces= " + statesOrProvinces + "\n\n");

		 
		return mv;
	}
	
	// handler method to process add for the add contractor profile form
	@PostMapping("/processAddContractorProfileForm")
	public ModelAndView processAddContractorProfileForm(HttpServletRequest request,
				@Valid @ModelAttribute("contractorUserProfile") ContractorUserProfile theContractorUserProfile, 
				BindingResult theBindingResult, 
				Model theModel) {
		
		String contactInfoFirstName = theContractorUserProfile.getContactInfoFirstName();
		String contactInfoLastName = theContractorUserProfile.getContactInfoLastName();
		logger.info("Processing Add Contractor Profile form for: " + contactInfoFirstName + " " + contactInfoLastName);
		System.out.println("theContractorUserProfile:   " + theContractorUserProfile.toString());
		HttpSession se = request.getSession();
		
		// form validation
		 if (theBindingResult.hasErrors()){
			 System.out.println("in processAddContractorProfileForm() method:  there are errors  | redirecting to add-contractor-profile page");
			 System.out.println("in processAddContractorProfileForm() method:  | " + theBindingResult.getAllErrors().toString());
			 ModelAndView mv = new ModelAndView("contractor/add-contractor-profile");
			 mv.addObject("statesOrProvincesForHomeAddress", theContractorUserProfile);
			 mv.addObject("countries", se.getAttribute("countries"));
			 mv.addObject("statesOrProvincesForHomeAddress",se.getAttribute("statesOrProvincesForHomeAddress"));
			 mv.addObject("statesOrProvincesForEmployerAddress",se.getAttribute("statesOrProvincesForEmployerAddress"));

			 return mv;
	        }

 
		 
		 System.out.println("In ContractorController   processAddContractorProfileForm() method    theContractorUserProfile= " + theContractorUserProfile);
		 Address homeAddress = new Address();
		 Address employerAddress = new Address();

		 // save the home address in the db
		 if (!"".equals(theContractorUserProfile.getContactInfoHomeAddrLine1())) {
			 homeAddress.setAddressType(theContractorUserProfile.getContactInfoHomeAddressType());
			 homeAddress.setAddrLine1(theContractorUserProfile.getContactInfoHomeAddrLine1());
			 homeAddress.setAddrLine2(theContractorUserProfile.getContactInfoHomeAddrLine2());
			 homeAddress.setAddrLine3(theContractorUserProfile.getContactInfoHomeAddrLine3());
			 homeAddress.setAddrLine4(theContractorUserProfile.getContactInfoHomeAddrLine4());
			 homeAddress.setCity(theContractorUserProfile.getContactInfoHomeCity());
			 homeAddress.setState(stateOrProvinceService.findById(theContractorUserProfile.getContactInfoHomeState()).getStateOrProvince());
			 
			 homeAddress.setPostalCode(theContractorUserProfile.getContactInfoHomePostalCode());
			 homeAddress.setCountry(countryService.findByCountryCode(theContractorUserProfile.getContactInfoHomeCountry()).getCountryName());

			 addressService.save(homeAddress);
		 }
		 
		 // save the employer address in the db
		 if (!"".equals(theContractorUserProfile.getEmployerInfoEmployerAddrLine1())) {			 
			 employerAddress.setAddressType(theContractorUserProfile.getEmployerInfoEmployerAddressType());
			 employerAddress.setAddrLine1(theContractorUserProfile.getEmployerInfoEmployerAddrLine1());
			 employerAddress.setAddrLine2(theContractorUserProfile.getEmployerInfoEmployerAddrLine2());
			 employerAddress.setAddrLine3(theContractorUserProfile.getEmployerInfoEmployerAddrLine3());
			 employerAddress.setAddrLine4(theContractorUserProfile.getEmployerInfoEmployerAddrLine4());
			 employerAddress.setCity(theContractorUserProfile.getEmployerInfoEmployerCity());
			 employerAddress.setState(stateOrProvinceService.findById(theContractorUserProfile.getEmployerInfoEmployerState()).getStateOrProvince());
			 
			 employerAddress.setPostalCode(theContractorUserProfile.getEmployerInfoEmployerPostalCode());
			 employerAddress.setCountry(countryService.findByCountryCode(theContractorUserProfile.getEmployerInfoEmployerCountry()).getCountryName());

			 addressService.save(employerAddress);
		 }
		 

		 
		 ContactInfo contactInfo = new ContactInfo();
		 // save the Contact Info record in the db, while setting home address in the join table
		 if (!"".equals(theContractorUserProfile.getContactInfoFirstName())) {
			 
			 contactInfo.setFirstName(theContractorUserProfile.getContactInfoFirstName());
			 contactInfo.setLastName(theContractorUserProfile.getContactInfoLastName());
			 contactInfo.setPrimaryEmail(theContractorUserProfile.getContactInfoPrimaryEmail());
			 contactInfo.setSecondaryEmail(theContractorUserProfile.getContactInfoSecondaryEmail());
			 contactInfo.setHomePhoneNo(theContractorUserProfile.getContactInfoHomePhoneNo().toString());
			 contactInfo.setWorkPhoneNo(theContractorUserProfile.getContactInfoWorkPhoneNo().toString());
			 contactInfo.setCellPhoneNo(theContractorUserProfile.getContactInfoCellPhoneNo().toString());
			 List<Address> homeAddresses = new ArrayList<Address>();
			 homeAddresses.add(homeAddress);
			 contactInfo.setHomeAddresses(homeAddresses);
			 
			 contactInfoService.save(contactInfo);
			 
		 }
		 
		 EmployerInfo employerInfo = new EmployerInfo();
		 // save the Employer Info record in the db, while setting employer address in the join table
		 if (!"".equals(theContractorUserProfile.getEmployerInfoEmployerName())) {

			 employerInfo.setEmployerName(theContractorUserProfile.getEmployerInfoEmployerName());
			 employerInfo.setEmployerPhoneNo(theContractorUserProfile.getEmployerInfoEmployerPhoneNo().toString());
			 List<Address> employerAddresses = new ArrayList<Address>();
			 employerAddresses.add(employerAddress);
			 employerInfo.setEmployerAddresses(employerAddresses);
			 
			 employerInfoService.save(employerInfo);
			 
		 }
		 

		 // get the user from the session and add it to the ContractorProfile
		 User user = (User)se.getAttribute("user");
		 System.out.println("In ContractorController   processAddContractorProfileForm() method:   user=    id: " + user.getId() + "  | name: " + user.getFirstName() + " " + user.getLastName()+ "  | username: " + user.getUserName());
	 
		 
		 // Now save the ContractorProfile record to the database
		 ContractorProfile contractorProfile = contractorProfileService.findByUserId(user.getId());
		 System.out.println("14a: In ContractorController   processAddContractorProfileForm() method:   contractorProfile= " + contractorProfile  + "  | user.getId()= " + user.getId());
		 if (contractorProfile == null) contractorProfile = new ContractorProfile();
		 System.out.println("14b: In ContractorController   processAddContractorProfileForm() method:   contractorProfile= " + contractorProfile);
		 
		 contractorProfile.setTypeOfProfile("CONTRACTOR");

		 if (user != null) {
			 contractorProfile.setUser(user);
		 }		 
		 if (contactInfo!= null) {
			 contractorProfile.setContactInfo(contactInfo);
		 }
		 if (employerInfo != null) {
			 contractorProfile.setEmployerInfo(employerInfo);
		 }
		 // save the contractor profile record
		 contractorProfileService.save(contractorProfile);
			 
		 ModelAndView mv = new ModelAndView("contractor/add-contractor-profile-confirmation");
		 mv.addObject("contractorUserProfile", theContractorUserProfile);
		 return mv;

	}


	
	// handler method to display the update contractor profile page
	@GetMapping("/showUpdateContractorProfilePage")
	public ModelAndView showUpdateContractorProfilePage(HttpServletRequest request,Model theModel) {
		System.out.println("a1: Entering ContractorController   showUpdateContractorProfilePage() method");
		ModelAndView mv = new ModelAndView("contractor/update-contractor-profile");
		ContractorUserProfile contractorUserProfile = new ContractorUserProfile();
		mv.addObject("contractorUserProfile", new ContractorUserProfile());
		
		
		HttpSession se = request.getSession();
		User user = (User) se.getAttribute("user");
		System.out.println("a2: ---> In ContractorController   showUpdateContractorProfilePage() method   user= " + user.getId() + " | " + user.getUserName() + " | " + user.getFirstName() + " " + user.getLastName());
		mv.addObject("user", user);
		
		// now that we have the user, use the user id to find the Contractor Profile record with that user id
		ContractorProfile contractorProfile = contractorProfileService.findByUserId(user.getId());
		System.out.println("a3: ---> In ContractorController   showUpdateContractorProfilePage() method   contractorProfile= " + contractorProfile);
		mv.addObject("contractorProfile",contractorProfile);
		
		// from the contractorProfile record, get the Contact Info record and Employer Info record
		System.out.println("a4a: ---> In ContractorController   showUpdateContractorProfilePage() method   contractorProfile.getUser().getId()= " + contractorProfile.getUser().getId());

		System.out.println("a4a: ---> In ContractorController   showUpdateContractorProfilePage() method   contractorProfile.getContactInfo().getId()= " + contractorProfile.getContactInfo().getId());
		ContactInfo contactInfo = contactInfoService.findContactInfoById(contractorProfile.getContactInfo().getId());
		System.out.println("a4b: ---> In ContractorController   showUpdateContractorProfilePage() method   contactInfo= " + contactInfo.toString());

		System.out.println("a5a: ---> In ContractorController   showUpdateContractorProfilePage() method   contractorProfile.getEmployerInfo().getId()= " + contractorProfile.getEmployerInfo().getId());
		EmployerInfo employerInfo = employerInfoService.findEmployerInfoById(contractorProfile.getEmployerInfo().getId());
		System.out.println("a5b: ---> In ContractorController   showUpdateContractorProfilePage() method   employerInfo= " + employerInfo.toString());

		mv.addObject("contactInfo",contactInfo);
		List<Address> homeAddresses = new ArrayList<Address>();
		homeAddresses.add(contactInfo.getHomeAddresses().get(0));
		mv.addObject("contactInfo_homeAddresses", homeAddresses);
		System.out.println("a5d: ---> In ContractorController   showUpdateContractorProfilePage() method   homeAddresses= " + homeAddresses.toString());
		
		
		
		String state_to_find = contactInfo.getHomeAddresses().get(0).getState();
		System.out.println("a6a:In ContractorController  in showUpdateContractorProfilePage() method    state_to_find= " + state_to_find);

		int stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("a6b:In ContractorController  in showUpdateContractorProfilePage() method    state_to_find= " + state_to_find  + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("contactInfoHomeAddressStateIndx", stateOrProvinceStateIndx);
		
		
		
		
		
		mv.addObject("employerInfo",employerInfo);
		List<Address> employerAddresses = new ArrayList<Address>();
		employerAddresses.add(employerInfo.getEmployerAddresses().get(0));
		mv.addObject("employerInfo_employerAddresses",employerAddresses);
		
		
		
		state_to_find = employerInfo.getEmployerAddresses().get(0).getState();
		System.out.println("a7a:In ContractorController  in showUpdateContractorProfilePage() method    state_to_find= " + state_to_find);

		stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("a7b:In ContractorController  in showUpdateContractorProfilePage() method    state_to_find= " + state_to_find  + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("employerInfoEmployerAddressStateIndx", stateOrProvinceStateIndx);
		
		
		
		
		
		
		// get countries and states from the session object and add them to the model and view object
		List<Country> countries = (List<Country>) se.getAttribute("countries");
		System.out.println("a10: ---> In ContractorController   showUpdateContractorProfilePage() method   countries= " + countries);

		List<StateOrProvince> statesOrProvinces = (List<StateOrProvince>)se.getAttribute("statesOrProvinces");
		System.out.println("a11: ---> In ContractorController   showUpdateContractorProfilePage() method   statesOrProvinces= " + statesOrProvinces);

		mv.addObject("countries", countries);
		mv.addObject("statesOrProvincesForHomeAddress", statesOrProvinces);
		mv.addObject("statesOrProvincesForEmployerAddress", statesOrProvinces);

		//se.setAttribute("countries", countries);
		se.setAttribute("statesOrProvincesForHomeAddress", statesOrProvinces);
		se.setAttribute("statesOrProvincesForEmployerAddress", statesOrProvinces);
		
		
		System.out.println("z98: Exiting ContractorController   showUpdateContractorProfilePage() method   countries= " + countries);
		System.out.println("z99: Exiting ContractorController   showUpdateContractorProfilePage() method   statesOrProvinces= " + statesOrProvinces + "\n\n");

		 
		return mv;
	}

	
	
	
	// handler method to process the update contractor profile form
	@PostMapping("/processUpdateContractorProfileForm")
	public ModelAndView processUpdateContractorProfileForm(HttpServletRequest request,
				@Valid @ModelAttribute("contractorUserProfile") ContractorUserProfile theContractorUserProfile, 
				BindingResult theBindingResult, 
				Model theModel) {
		
		String contactInfoFirstName = theContractorUserProfile.getContactInfoFirstName();
		String contactInfoLastName = theContractorUserProfile.getContactInfoLastName();
		logger.info("Processing Update Contractor Profile form for: " + contactInfoFirstName + " " + contactInfoLastName);
		System.out.println("theContractorUserProfile:   " + theContractorUserProfile.toString());
		HttpSession se = request.getSession();
		
		// form validation
		 if (theBindingResult.hasErrors()){
			 System.out.println("in processUpdateContractorProfileForm() method:  there are errors  | redirecting to update-contractor-profile page");
			 System.out.println("in processUpdateContractorProfileForm() method:  | " + theBindingResult.getAllErrors().toString());
			 ModelAndView mv = new ModelAndView("contractor/update-contractor-profile");
			 mv.addObject("statesOrProvincesForHomeAddress", theContractorUserProfile);
			 mv.addObject("countries", se.getAttribute("countries"));
			 mv.addObject("statesOrProvincesForHomeAddress",se.getAttribute("statesOrProvincesForHomeAddress"));
			 mv.addObject("statesOrProvincesForEmployerAddress",se.getAttribute("statesOrProvincesForEmployerAddress"));

			 return mv;
	        }

 
		 
		 System.out.println("In ContractorController   processUpdateContractorProfileForm() method    theContractorUserProfile= " + theContractorUserProfile);
		 Address homeAddress = null;
		 Address employerAddress = null;;

		 // update the home address in the db
		 if (!"".equals(theContractorUserProfile.getContactInfoHomeAddrLine1())) {
			 homeAddress = addressService.findByAddressId(theContractorUserProfile.getContactInfoHomeAddressId());
			 if (homeAddress == null) homeAddress = new Address();
			 
			 homeAddress.setAddressType(theContractorUserProfile.getContactInfoHomeAddressType());
			 homeAddress.setAddrLine1(theContractorUserProfile.getContactInfoHomeAddrLine1());
			 homeAddress.setAddrLine2(theContractorUserProfile.getContactInfoHomeAddrLine2());
			 homeAddress.setAddrLine3(theContractorUserProfile.getContactInfoHomeAddrLine3());
			 homeAddress.setAddrLine4(theContractorUserProfile.getContactInfoHomeAddrLine4());
			 homeAddress.setCity(theContractorUserProfile.getContactInfoHomeCity());
			 homeAddress.setState(stateOrProvinceService.findById(theContractorUserProfile.getContactInfoHomeState()).getStateOrProvince());
			 
			 homeAddress.setPostalCode(theContractorUserProfile.getContactInfoHomePostalCode());
			 homeAddress.setCountry(countryService.findByCountryCode(theContractorUserProfile.getContactInfoHomeCountry()).getCountryName());

			 addressService.save(homeAddress);
		 }
		 
		 // update the employer address in the db
		 if (!"".equals(theContractorUserProfile.getEmployerInfoEmployerAddrLine1())) {		
			 employerAddress = addressService.findByAddressId(theContractorUserProfile.getEmployerInfoEmployerAddressId());
			 if (employerAddress == null) employerAddress = new Address();

			 employerAddress.setAddressType(theContractorUserProfile.getEmployerInfoEmployerAddressType());
			 employerAddress.setAddrLine1(theContractorUserProfile.getEmployerInfoEmployerAddrLine1());
			 employerAddress.setAddrLine2(theContractorUserProfile.getEmployerInfoEmployerAddrLine2());
			 employerAddress.setAddrLine3(theContractorUserProfile.getEmployerInfoEmployerAddrLine3());
			 employerAddress.setAddrLine4(theContractorUserProfile.getEmployerInfoEmployerAddrLine4());
			 employerAddress.setCity(theContractorUserProfile.getEmployerInfoEmployerCity());
			 employerAddress.setState(stateOrProvinceService.findById(theContractorUserProfile.getEmployerInfoEmployerState()).getStateOrProvince());
			 
			 employerAddress.setPostalCode(theContractorUserProfile.getEmployerInfoEmployerPostalCode());
			 employerAddress.setCountry(countryService.findByCountryCode(theContractorUserProfile.getEmployerInfoEmployerCountry()).getCountryName());

			 addressService.save(employerAddress);
		 }
		 

		 
		 ContactInfo contactInfo = null;
		 // update the Contact Info record in the db
		 if (!"".equals(theContractorUserProfile.getContactInfoFirstName())) {
			 contactInfo = contactInfoService.findContactInfoById(theContractorUserProfile.getContactInfoId());
			 if (contactInfo == null) contactInfo = new ContactInfo();
			 
			 contactInfo.setFirstName(theContractorUserProfile.getContactInfoFirstName());
			 contactInfo.setLastName(theContractorUserProfile.getContactInfoLastName());
			 contactInfo.setPrimaryEmail(theContractorUserProfile.getContactInfoPrimaryEmail());
			 contactInfo.setSecondaryEmail(theContractorUserProfile.getContactInfoSecondaryEmail());
			 contactInfo.setHomePhoneNo(theContractorUserProfile.getContactInfoHomePhoneNo().toString());
			 contactInfo.setWorkPhoneNo(theContractorUserProfile.getContactInfoWorkPhoneNo().toString());
			 contactInfo.setCellPhoneNo(theContractorUserProfile.getContactInfoCellPhoneNo().toString());
			 List<Address> homeAddresses = new ArrayList<Address>();
			 homeAddresses.add(homeAddress);
			 contactInfo.setHomeAddresses(homeAddresses);
			 
			 contactInfoService.save(contactInfo);
			 
		 }
		 
		 EmployerInfo employerInfo = null;
		 // update the Employer Info record in the db 
		 if (!"".equals(theContractorUserProfile.getEmployerInfoEmployerName())) {
			 employerInfo = employerInfoService.findEmployerInfoById(theContractorUserProfile.getEmployerInfoId());
			 if (employerInfo == null) employerInfo = new EmployerInfo();

			 employerInfo.setEmployerName(theContractorUserProfile.getEmployerInfoEmployerName());
			 employerInfo.setEmployerPhoneNo(theContractorUserProfile.getEmployerInfoEmployerPhoneNo().toString());
			 List<Address> employerAddresses = new ArrayList<Address>();
			 employerAddresses.add(employerAddress);
			 employerInfo.setEmployerAddresses(employerAddresses);
			 
			 employerInfoService.save(employerInfo);
			 
		 }
		 

		 // get the user from the session and add it to the ContractorProfile
		 User user = (User)se.getAttribute("user");
		 System.out.println("In ContractorController   processUpdateContractorProfileForm() method:   user=    id: " + user.getId() + "  | name: " + user.getFirstName() + " " + user.getLastName()+ "  | username: " + user.getUserName());
	 
		 
		 // Now update the ContractorProfile record in the database
		 ContractorProfile contractorProfile = contractorProfileService.findByUserId(user.getId());
		 System.out.println("14a: In ContractorController   processUpdateContractorProfileForm() method:   contractorProfile= " + contractorProfile  + "  | user.getId()= " + user.getId());
		 if (contractorProfile == null) contractorProfile = new ContractorProfile();
		 System.out.println("14b: In ContractorController   processUpdateContractorProfileForm() method:   contractorProfile= " + contractorProfile);
		 
		 contractorProfile.setTypeOfProfile("CONTRACTOR");

		 if (user != null) {
			 contractorProfile.setUser(user);
		 }		 
		 if (contactInfo!= null) {
			 contractorProfile.setContactInfo(contactInfo);
		 }
		 if (employerInfo != null) {
			 contractorProfile.setEmployerInfo(employerInfo);
		 }
		 // update the contractor profile record
		 contractorProfileService.save(contractorProfile);
			 
		 ModelAndView mv = new ModelAndView("contractor/update-contractor-profile-confirmation");
		 mv.addObject("contractorUserProfile", theContractorUserProfile);
		 return mv;

	}

	
	
	


	
	// handler method to display the display contractor profile page
	@GetMapping("/showDisplayContractorProfilePage")
	public ModelAndView showDisplayContractorProfilePage(HttpServletRequest request,Model theModel) {
		System.out.println("a1: Entering ContractorController   showDisplayContractorProfilePage() method");
		ModelAndView mv = new ModelAndView("contractor/display-contractor-profile");
		ContractorUserProfile contractorUserProfile = new ContractorUserProfile();
		mv.addObject("contractorUserProfile", new ContractorUserProfile());
		
		
		HttpSession se = request.getSession();
		User user = (User) se.getAttribute("user");
		System.out.println("a2: ---> In ContractorController   showDisplayContractorProfilePage() method   user= " + user.getId() + " | " + user.getUserName() + " | " + user.getFirstName() + " " + user.getLastName());
		mv.addObject("user", user);
		
		// now that we have the user, use the user id to find the Contractor Profile record with that user id
		ContractorProfile contractorProfile = contractorProfileService.findByUserId(user.getId());
		System.out.println("a3: ---> In ContractorController   showDisplayContractorProfilePage() method   contractorProfile= " + contractorProfile);
		mv.addObject("contractorProfile",contractorProfile);
		
		// from the contractorProfile record, get the Contact Info record and Employer Info record
		System.out.println("a4a: ---> In ContractorController   showDisplayContractorProfilePage() method   contractorProfile.getUser().getId()= " + contractorProfile.getUser().getId());

		System.out.println("a4a: ---> In ContractorController   showDisplayContractorProfilePage() method   contractorProfile.getContactInfo().getId()= " + contractorProfile.getContactInfo().getId());
		ContactInfo contactInfo = contactInfoService.findContactInfoById(contractorProfile.getContactInfo().getId());
		System.out.println("a4b: ---> In ContractorController   showDisplayContractorProfilePage() method   contactInfo= " + contactInfo.toString());

		System.out.println("a5a: ---> In ContractorController   showDisplayContractorProfilePage() method   contractorProfile.getEmployerInfo().getId()= " + contractorProfile.getEmployerInfo().getId());
		EmployerInfo employerInfo = employerInfoService.findEmployerInfoById(contractorProfile.getEmployerInfo().getId());
		System.out.println("a5b: ---> In ContractorController   showDisplayContractorProfilePage() method   employerInfo= " + employerInfo.toString());

		mv.addObject("contactInfo",contactInfo);
		List<Address> homeAddresses = new ArrayList<Address>();
		homeAddresses.add(contactInfo.getHomeAddresses().get(0));
		mv.addObject("contactInfo_homeAddresses", homeAddresses);
		System.out.println("a5d: ---> In ContractorController   showDisplayContractorProfilePage() method   homeAddresses= " + homeAddresses.toString());
		
		
		
		String state_to_find = contactInfo.getHomeAddresses().get(0).getState();
		System.out.println("a6a:In ContractorController  in showDisplayContractorProfilePage() method    state_to_find= " + state_to_find);

		int stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("a6b:In ContractorController  in showDisplayContractorProfilePage() method    state_to_find= " + state_to_find  + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("contactInfoHomeAddressStateIndx", stateOrProvinceStateIndx);
		
		
		
		
		
		mv.addObject("employerInfo",employerInfo);
		List<Address> employerAddresses = new ArrayList<Address>();
		employerAddresses.add(employerInfo.getEmployerAddresses().get(0));
		mv.addObject("employerInfo_employerAddresses",employerAddresses);
		
		
		
		state_to_find = employerInfo.getEmployerAddresses().get(0).getState();
		System.out.println("a7a:In ContractorController  in showDisplayContractorProfilePage() method    state_to_find= " + state_to_find);

		stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("a7b:In ContractorController  in showDisplayContractorProfilePage() method    state_to_find= " + state_to_find  + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("employerInfoEmployerAddressStateIndx", stateOrProvinceStateIndx);
		
		
		
		
		
		
		// get countries and states from the session object and add them to the model and view object
		List<Country> countries = (List<Country>) se.getAttribute("countries");
		System.out.println("a10: ---> In ContractorController   showDisplayContractorProfilePage() method   countries= " + countries);

		List<StateOrProvince> statesOrProvinces = (List<StateOrProvince>)se.getAttribute("statesOrProvinces");
		System.out.println("a11: ---> In ContractorController   showDisplayContractorProfilePage() method   statesOrProvinces= " + statesOrProvinces);

		mv.addObject("countries", countries);
		mv.addObject("statesOrProvincesForHomeAddress", statesOrProvinces);
		mv.addObject("statesOrProvincesForEmployerAddress", statesOrProvinces);

		//se.setAttribute("countries", countries);
		se.setAttribute("statesOrProvincesForHomeAddress", statesOrProvinces);
		se.setAttribute("statesOrProvincesForEmployerAddress", statesOrProvinces);
		
		
		System.out.println("z98: Exiting ContractorController   showDisplayContractorProfilePage() method   countries= " + countries);
		System.out.println("z99: Exiting ContractorController   showDisplayContractorProfilePage() method   statesOrProvinces= " + statesOrProvinces + "\n\n");

		 
		return mv;
	}

	
	
	// handler method to display the delete contractor profile page
	@PostMapping("/showDeleteContractorProfilePage")
	public ModelAndView showDeleteContractorProfilePage(HttpServletRequest request) {
		
		// TODO -- complete the rest of this method in the future

		ModelAndView mv = new ModelAndView();
		return mv;

	}
	
	
	// TODO --  finish the delete contractor profile processing in the future
	
}
