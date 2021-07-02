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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abcrentals.binu.thankachan.constants.RentalWebsiteConstants;
import com.abcrentals.binu.thankachan.entity.Address;
import com.abcrentals.binu.thankachan.entity.ContactInfo;
import com.abcrentals.binu.thankachan.entity.RenterProfile;
import com.abcrentals.binu.thankachan.entity.Country;
import com.abcrentals.binu.thankachan.entity.EmployerInfo;
import com.abcrentals.binu.thankachan.entity.PrivateInfo;
import com.abcrentals.binu.thankachan.entity.RenterProfile;
import com.abcrentals.binu.thankachan.entity.StateOrProvince;
import com.abcrentals.binu.thankachan.entity.User;
import com.abcrentals.binu.thankachan.service.AddressService;
import com.abcrentals.binu.thankachan.service.ContactInfoService;
import com.abcrentals.binu.thankachan.service.CountryService;
import com.abcrentals.binu.thankachan.service.EmployerInfoService;
import com.abcrentals.binu.thankachan.service.PrivateInfoService;
import com.abcrentals.binu.thankachan.service.RenterProfileService;
import com.abcrentals.binu.thankachan.service.StateOrProvinceService;
import com.abcrentals.binu.thankachan.user.RenterUserProfile;
import com.abcrentals.binu.thankachan.user.RenterUserProfile;

/*
 * Controller class to specify handler methods for users with a role of renter
 * 
 * 
 * 
 */


@Controller
@RequestMapping("/renter")
public class RenterController {

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
	private PrivateInfoService privateInfoService;

	@Autowired
	private RenterProfileService renterProfileService;

	
	// method to load countries list as model attribute and countries and statesOrProvinces lists as session attributes	
	@ModelAttribute("countries")
	public List<Country> initializeCountries(HttpServletRequest request) {

		List<Country> countries = countryService.findAllCountries();
		Country country = countryService.findAllCountries().get(0);

		HttpSession se = request.getSession();
		se.setAttribute("countries", countries);
		List<StateOrProvince> statesOrProvinces = stateOrProvinceService.findByCountry(country.getCountryName());
		se.setAttribute("statesOrProvinces", statesOrProvinces);

		System.out.println("in RenterController class initializeCountry() method:  countries= " + countries.toString());
		System.out.println("In RenterController   initializeCountries() method   country= " + countries);
		System.out.println("In RenterController   initializeCountries() method   country.getCountryName()= "
				+ country.getCountryName());
		System.out.println("In RenterController   initializeCountries() method   statesOrProvinces= "
				+ statesOrProvinces + "\n\n");

		return countries;
	}

	
	
	// handler method to display the add renter profile page
	@GetMapping("/showAddRenterProfilePage")
	public ModelAndView showAddRenterProfilePage(HttpServletRequest request, Model theModel) {

		ModelAndView mv = new ModelAndView("renter/add-renter-profile");
		mv.addObject("renterUserProfile", new RenterUserProfile());

		// theModel.addAttribute("renterUserProfile", new RenterUserProfile());

		HttpSession se = request.getSession();
		List<Country> countries = (List<Country>) se.getAttribute("countries");
		List<StateOrProvince> statesOrProvinces = (List<StateOrProvince>) se.getAttribute("statesOrProvinces");
		mv.addObject("countries", countries);
		mv.addObject("statesOrProvincesForHomeAddress", statesOrProvinces);
		mv.addObject("statesOrProvincesForEmployerAddress", statesOrProvinces);
		mv.addObject("statesOrProvincesForBillingAddress", statesOrProvinces);

		se.setAttribute("countries", countries);
		se.setAttribute("statesOrProvincesForHomeAddress", statesOrProvinces);
		se.setAttribute("statesOrProvincesForEmployerAddress", statesOrProvinces);
		se.setAttribute("statesOrProvincesForBillingAddress", statesOrProvinces);

		System.out.println("In RenterController   showAddRenterProfilePage() method   countries= " + countries);
		System.out.println("In RenterController   showAddRenterProfilePage() method   statesOrProvinces= "
				+ statesOrProvinces + "\n\n");

		// return "add-renter-profile";
		return mv;
	}

	// handler method to process the add renter profile form
	@PostMapping("/processAddRenterProfileForm")
	public ModelAndView processAddRenterProfileForm(HttpServletRequest request,
			@Valid @ModelAttribute("renterUserProfile") RenterUserProfile theRenterUserProfile,
			BindingResult theBindingResult, Model theModel) {

		String contactInfoFirstName = theRenterUserProfile.getContactInfoFirstName();
		String contactInfoLastName = theRenterUserProfile.getContactInfoLastName();
		logger.info("Processing Add Renter Profile form for: " + contactInfoFirstName + " " + contactInfoLastName);
		System.out.println("theRenterUserProfile:   " + theRenterUserProfile.toString());
		HttpSession se = request.getSession();

		// form validation
		if (theBindingResult.hasErrors()) {
			System.out.println(
					"in processAddRenterProfileForm() method:  there are errors  | redirecting to add-renter-profile page");
			System.out.println(
					"in processAddRenterProfileForm() method:  | " + theBindingResult.getAllErrors().toString());
			ModelAndView mv = new ModelAndView("renter/add-renter-profile");
			mv.addObject("statesOrProvincesForHomeAddress", theRenterUserProfile);
			mv.addObject("countries", se.getAttribute("countries"));
			mv.addObject("statesOrProvincesForHomeAddress", se.getAttribute("statesOrProvincesForHomeAddress"));
			mv.addObject("statesOrProvincesForEmployerAddress", se.getAttribute("statesOrProvincesForEmployerAddress"));
			mv.addObject("statesOrProvincesForBillingAddress", se.getAttribute("statesOrProvincesForBillingAddress"));

			return mv;
		}


		System.out.println("In RenterController   processAddRenterProfileForm() method    theRenterUserProfile= "
				+ theRenterUserProfile);
		Address homeAddress = new Address();
		Address employerAddress = new Address();
		Address billingAddress = new Address();

		// save the home address in the db
		if (!"".equals(theRenterUserProfile.getContactInfoHomeAddrLine1())) {
			homeAddress.setAddressType(theRenterUserProfile.getContactInfoHomeAddressType());
			homeAddress.setAddrLine1(theRenterUserProfile.getContactInfoHomeAddrLine1());
			homeAddress.setAddrLine2(theRenterUserProfile.getContactInfoHomeAddrLine2());
			homeAddress.setAddrLine3(theRenterUserProfile.getContactInfoHomeAddrLine3());
			homeAddress.setAddrLine4(theRenterUserProfile.getContactInfoHomeAddrLine4());
			homeAddress.setCity(theRenterUserProfile.getContactInfoHomeCity());
			homeAddress.setState(stateOrProvinceService.findById(theRenterUserProfile.getContactInfoHomeState())
					.getStateOrProvince());

			homeAddress.setPostalCode(theRenterUserProfile.getContactInfoHomePostalCode());
			homeAddress.setCountry(countryService.findByCountryCode(theRenterUserProfile.getContactInfoHomeCountry())
					.getCountryName());

			addressService.save(homeAddress);
		}

		// save the employer address in the db
		if (!"".equals(theRenterUserProfile.getEmployerInfoEmployerAddrLine1())) {
			employerAddress.setAddressType(theRenterUserProfile.getEmployerInfoEmployerAddressType());
			employerAddress.setAddrLine1(theRenterUserProfile.getEmployerInfoEmployerAddrLine1());
			employerAddress.setAddrLine2(theRenterUserProfile.getEmployerInfoEmployerAddrLine2());
			employerAddress.setAddrLine3(theRenterUserProfile.getEmployerInfoEmployerAddrLine3());
			employerAddress.setAddrLine4(theRenterUserProfile.getEmployerInfoEmployerAddrLine4());
			employerAddress.setCity(theRenterUserProfile.getEmployerInfoEmployerCity());
			employerAddress.setState(stateOrProvinceService
					.findById(theRenterUserProfile.getEmployerInfoEmployerState()).getStateOrProvince());

			employerAddress.setPostalCode(theRenterUserProfile.getEmployerInfoEmployerPostalCode());
			employerAddress.setCountry(countryService
					.findByCountryCode(theRenterUserProfile.getEmployerInfoEmployerCountry()).getCountryName());

			addressService.save(employerAddress);
		}

		// save the billing address in the db
		if (!"".equals(theRenterUserProfile.getPrivateInfoCCBillingAddrLine1())) {
			billingAddress.setAddressType(theRenterUserProfile.getPrivateInfoCCBillingAddressType());
			billingAddress.setAddrLine1(theRenterUserProfile.getPrivateInfoCCBillingAddrLine1());
			billingAddress.setAddrLine2(theRenterUserProfile.getPrivateInfoCCBillingAddrLine2());
			billingAddress.setAddrLine3(theRenterUserProfile.getPrivateInfoCCBillingAddrLine3());
			billingAddress.setAddrLine4(theRenterUserProfile.getPrivateInfoCCBillingAddrLine4());
			billingAddress.setCity(theRenterUserProfile.getPrivateInfoCCBillingCity());
			billingAddress.setState(stateOrProvinceService.findById(theRenterUserProfile.getPrivateInfoCCBillingState())
					.getStateOrProvince());

			billingAddress.setPostalCode(theRenterUserProfile.getPrivateInfoCCBillingPostalCode());
			billingAddress.setCountry(countryService
					.findByCountryCode(theRenterUserProfile.getPrivateInfoCCBillingCountry()).getCountryName());

			addressService.save(billingAddress);
		}

		ContactInfo contactInfo = new ContactInfo();
		// save the Contact Info record in the db, while setting home address in the
		// join table
		if (!"".equals(theRenterUserProfile.getContactInfoFirstName())) {

			contactInfo.setFirstName(theRenterUserProfile.getContactInfoFirstName());
			contactInfo.setLastName(theRenterUserProfile.getContactInfoLastName());
			contactInfo.setPrimaryEmail(theRenterUserProfile.getContactInfoPrimaryEmail());
			contactInfo.setSecondaryEmail(theRenterUserProfile.getContactInfoSecondaryEmail());
			contactInfo.setHomePhoneNo(theRenterUserProfile.getContactInfoHomePhoneNo().toString());
			contactInfo.setWorkPhoneNo(theRenterUserProfile.getContactInfoWorkPhoneNo().toString());
			contactInfo.setCellPhoneNo(theRenterUserProfile.getContactInfoCellPhoneNo().toString());
			List<Address> homeAddresses = new ArrayList<Address>();
			homeAddresses.add(homeAddress);
			contactInfo.setHomeAddresses(homeAddresses);

			contactInfoService.save(contactInfo);

		}

		EmployerInfo employerInfo = new EmployerInfo();
		// save the Employer Info record in the db, while setting employer address in
		// the join table
		if (!"".equals(theRenterUserProfile.getEmployerInfoEmployerName())) {

			employerInfo.setEmployerName(theRenterUserProfile.getEmployerInfoEmployerName());
			employerInfo.setEmployerPhoneNo(theRenterUserProfile.getEmployerInfoEmployerPhoneNo().toString());
			List<Address> employerAddresses = new ArrayList<Address>();
			employerAddresses.add(employerAddress);
			employerInfo.setEmployerAddresses(employerAddresses);

			employerInfoService.save(employerInfo);

		}

		PrivateInfo privateInfo = new PrivateInfo();
		// save the Private Info record in the db, while setting billing address in the
		// join table
		if (!"".equals(theRenterUserProfile.getPrivateInfoCCBillingAddrLine1())) {

			privateInfo.setCreditCardNo(theRenterUserProfile.getPrivateInfoCreditCardNo().toString());
			privateInfo.setCreditCardNoExpMonth(theRenterUserProfile.getPrivateInfoCreditCardNoExpMonth());
			privateInfo.setCreditCardNoExpYear(theRenterUserProfile.getPrivateInfoCreditCardNoExpYear());
			privateInfo.setCreditCardNoCCVCode(theRenterUserProfile.getPrivateInfoCreditCardNoCCVCode());
			privateInfo.setGender(theRenterUserProfile.getPrivateInfoGender());
			privateInfo.setEthnicity(theRenterUserProfile.getPrivateInfoEthnicity());
			privateInfo.setSsn(theRenterUserProfile.getPrivateInfoSsn().toString());
			privateInfo.setDob(theRenterUserProfile.getPrivateInfoDob());

			List<Address> creditCardBillingAddresses = new ArrayList<Address>();
			creditCardBillingAddresses.add(billingAddress);
			privateInfo.setCreditCardBillingAddresses(creditCardBillingAddresses);

			privateInfoService.save(privateInfo);

		}

		// get the user from the session and add it to the RenterProfile
		User user = (User) se.getAttribute("user");
		System.out.println("In RenterController   processAddRenterProfileForm() method:   user=    id: " + user.getId()
				+ "  | name: " + user.getFirstName() + " " + user.getLastName() + "  | username: "
				+ user.getUserName());

		RenterProfile renterProfile = renterProfileService.findById(user.getId());
		System.out.println("14a: In RenterProfileController   processAddRenterProfileForm() method:   renterProfile= "
				+ renterProfile + "  | user.getId()= " + user.getId());
		if (renterProfile == null)
			renterProfile = new RenterProfile();
		System.out.println(
				"14b: In RenterController   processAddRenterProfileForm() method:   renterProfile= " + renterProfile);

		// Now save the RenterProfile record to the database

		renterProfile.setTypeOfProfile("RENTER");

		if (user != null) {
			renterProfile.setUser(user);
		}
		if (contactInfo != null) {
			renterProfile.setContactInfo(contactInfo);
		}
		if (employerInfo != null) {
			renterProfile.setEmployerInfo(employerInfo);
		}
		if (privateInfo != null) {
			renterProfile.setPrivateInfo(privateInfo);
		}
		// save the renter profile record
		renterProfileService.save(renterProfile);

		ModelAndView mv = new ModelAndView("renter/add-renter-profile-confirmation");
		mv.addObject("renterUserProfile", theRenterUserProfile);
		return mv;

	}

	
	// handler method to display the update renter profile page
	@GetMapping("/showUpdateRenterProfilePage")
	public ModelAndView showUpdateRenterProfilePage(HttpServletRequest request, Model theModel) {
		System.out.println("a1: Entering RenterController   showUpdateRenterProfilePage() method");
		ModelAndView mv = new ModelAndView("renter/update-renter-profile");
		RenterUserProfile renterUserProfile = new RenterUserProfile();
		mv.addObject("renterUserProfile", new RenterUserProfile());

		HttpSession se = request.getSession();
		User user = (User) se.getAttribute("user");
		System.out.println("a2: ---> In RenterController   showUpdateRenterProfilePage() method   user= " + user.getId()
				+ " | " + user.getUserName() + " | " + user.getFirstName() + " " + user.getLastName());
		mv.addObject("user", user);

		// now that we have the user, use the user id to find the Renter Profile record
		// with that user id
		RenterProfile renterProfile = renterProfileService.findByUserId(user.getId());
		System.out.println("a3: ---> In RenterController   showUpdateRenterProfilePage() method   renterProfile= "
				+ renterProfile);
		mv.addObject("renterProfile", renterProfile);

		// from the renterProfile record, get the Contact Info record and Employer Info
		// record
		System.out.println(
				"a4a: ---> In RenterController   showUpdateRenterProfilePage() method   renterProfile.getUser().getId()= "
						+ renterProfile.getUser().getId());

		System.out.println(
				"a4a: ---> In RenterController   showUpdateRenterProfilePage() method   renterProfile.getContactInfo().getId()= "
						+ renterProfile.getContactInfo().getId());
		ContactInfo contactInfo = contactInfoService.findContactInfoById(renterProfile.getContactInfo().getId());
		System.out.println("a4b: ---> In RenterController   showUpdateRenterProfilePage() method   contactInfo= "
				+ contactInfo.toString());

		System.out.println(
				"a5a: ---> In RenterController   showUpdateRenterProfilePage() method   renterProfile.getEmployerInfo().getId()= "
						+ renterProfile.getEmployerInfo().getId());
		EmployerInfo employerInfo = employerInfoService.findEmployerInfoById(renterProfile.getEmployerInfo().getId());
		System.out.println("a5b: ---> In RenterController   showUpdateRenterProfilePage() method   employerInfo= "
				+ employerInfo.toString());

		

		System.out.println(
				"a6a: ---> In RenterController   showUpdateRenterProfilePage() method   renterProfile.getPrivateInfo().getId()= "
						+ renterProfile.getPrivateInfo().getId());
		PrivateInfo privateInfo = privateInfoService.findPrivateInfoById(renterProfile.getPrivateInfo().getId());
		System.out.println("a6b: ---> In RenterController   showUpdateRenterProfilePage() method   privateInfo= "
				+ privateInfo.toString());
		
		
		
		mv.addObject("contactInfo", contactInfo);
		List<Address> homeAddresses = new ArrayList<Address>();
		homeAddresses.add(contactInfo.getHomeAddresses().get(0));
		mv.addObject("contactInfo_homeAddresses", homeAddresses);
		System.out.println("a7a: ---> In RenterController   showUpdateRenterProfilePage() method   homeAddresses= "
				+ homeAddresses.toString());

		String state_to_find = contactInfo.getHomeAddresses().get(0).getState();
		System.out.println(
				"a7b:In RenterController  in showUpdateRenterProfilePage() method    state_to_find= " + state_to_find);

		int stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("a7c:In RenterController  in showUpdateRenterProfilePage() method    state_to_find= "
				+ state_to_find + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("contactInfoHomeAddressStateIndx", stateOrProvinceStateIndx);

		
		
		mv.addObject("employerInfo", employerInfo);
		List<Address> employerAddresses = new ArrayList<Address>();
		employerAddresses.add(employerInfo.getEmployerAddresses().get(0));
		mv.addObject("employerInfo_employerAddresses", employerAddresses);

		state_to_find = employerInfo.getEmployerAddresses().get(0).getState();
		System.out.println(
				"a8a:In RenterController  in showUpdateRenterProfilePage() method    state_to_find= " + state_to_find);

		stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("a8b:In RenterController  in showUpdateRenterProfilePage() method    state_to_find= "
				+ state_to_find + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("employerInfoEmployerAddressStateIndx", stateOrProvinceStateIndx);

		
		
		mv.addObject("privateInfo", privateInfo);
		List<Address> creditCardBillingAddresses = new ArrayList<Address>();
		creditCardBillingAddresses.add(privateInfo.getCreditCardBillingAddresses().get(0));
		mv.addObject("privateInfo_creditCardBillingAddresses", creditCardBillingAddresses);

		state_to_find = privateInfo.getCreditCardBillingAddresses().get(0).getState();
		System.out.println(
				"a9a:In RenterController  in showUpdateRenterProfilePage() method    state_to_find= " + state_to_find);

		stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("a9b:In RenterController  in showUpdateRenterProfilePage() method    state_to_find= "
				+ state_to_find + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("privateInfoCreditCardBillingStateIndx", stateOrProvinceStateIndx);
		
		
		
		
		
		// get countries and states from the session object and add them to the model
		// and view object
		List<Country> countries = (List<Country>) se.getAttribute("countries");
		System.out.println(
				"a10: ---> In RenterController   showUpdateRenterProfilePage() method   countries= " + countries);

		List<StateOrProvince> statesOrProvinces = (List<StateOrProvince>) se.getAttribute("statesOrProvinces");
		System.out.println("a11: ---> In RenterController   showUpdateRenterProfilePage() method   statesOrProvinces= "
				+ statesOrProvinces);

		mv.addObject("countries", countries);
		mv.addObject("statesOrProvincesForHomeAddress", statesOrProvinces);
		mv.addObject("statesOrProvincesForEmployerAddress", statesOrProvinces);
		mv.addObject("statesOrProvincesForCreditCardBillingAddress", statesOrProvinces);

		// se.setAttribute("countries", countries);
		se.setAttribute("statesOrProvincesForHomeAddress", statesOrProvinces);
		se.setAttribute("statesOrProvincesForEmployerAddress", statesOrProvinces);
		se.setAttribute("statesOrProvincesForCreditCardBillingAddress", statesOrProvinces);
		
		

	    Map<Integer, String> ccExpirationYearList = new HashMap<Integer, String>();
	    int i=0;
	    for(String str: RentalWebsiteConstants.CC_EXP_YEARS) {
	    	ccExpirationYearList.put(Integer.parseInt(str), str);
	    }
		mv.addObject("ccExpirationYearList", ccExpirationYearList);


	    Map<Integer, String> ccExpirationMonthList = new HashMap<Integer, String>();
	    i=1;
	    for(String str: RentalWebsiteConstants.MONTHS_2DIGIT_PLUS_NAME) {
	    	ccExpirationMonthList.put(i++, str);
	    }
		mv.addObject("ccExpirationMonthList", ccExpirationMonthList);
		

	    Map<Integer, String> ethnicityList = new HashMap<Integer, String>();
	    i=0;
	    for(String str: RentalWebsiteConstants.ETHNICITIES) {
	    	ethnicityList.put(i++, str);
	    }
		mv.addObject("ethnicityList", ethnicityList);
		
		//int ccExpirationYearIndx = privateInfo.getCreditCardNoExpYear();
		

		System.out.println(
				"z98: Exiting RenterController   showUpdateRenterProfilePage() method   countries= " + countries);
		System.out.println("z99: Exiting RenterController   showUpdateRenterProfilePage() method   statesOrProvinces= "
				+ statesOrProvinces + "\n\n");

		return mv;
	}
	
	
	// handler method to process the update renter profile form
	@PostMapping("/processUpdateRenterProfileForm")
	public ModelAndView processUpdateRenterProfileForm(HttpServletRequest request,
			@Valid @ModelAttribute("renterUserProfile") RenterUserProfile theRenterUserProfile,
			BindingResult theBindingResult, Model theModel) {

		String contactInfoFirstName = theRenterUserProfile.getContactInfoFirstName();
		String contactInfoLastName = theRenterUserProfile.getContactInfoLastName();
		logger.info("Processing Update Renter Profile form for: " + contactInfoFirstName + " " + contactInfoLastName);
		System.out.println("theRenterUserProfile:   " + theRenterUserProfile.toString());
		HttpSession se = request.getSession();

		// form validation
		if (theBindingResult.hasErrors()) {
			System.out.println(
					"in processUpdateRenterProfileForm() method:  there are errors  | redirecting to update-renter-profile page");
			System.out.println(
					"in processUpdateRenterProfileForm() method:  | " + theBindingResult.getAllErrors().toString());
			ModelAndView mv = new ModelAndView("renter/update-renter-profile");
			mv.addObject("statesOrProvincesForHomeAddress", theRenterUserProfile);
			mv.addObject("countries", se.getAttribute("countries"));
			mv.addObject("statesOrProvincesForHomeAddress", se.getAttribute("statesOrProvincesForHomeAddress"));
			mv.addObject("statesOrProvincesForEmployerAddress", se.getAttribute("statesOrProvincesForEmployerAddress"));
			mv.addObject("statesOrProvincesForCreditCardBillingAddress", se.getAttribute("statesOrProvincesForCreditCardBillingAddress"));

			return mv;
		}

		System.out.println("In RenterController   processUpdateRenterProfileForm() method    theRenterUserProfile= "
				+ theRenterUserProfile);
		Address homeAddress = null;
		Address employerAddress = null;
		;

		// update the home address in the db
		if (!"".equals(theRenterUserProfile.getContactInfoHomeAddrLine1())) {
			homeAddress = addressService.findByAddressId(theRenterUserProfile.getContactInfoHomeAddressId());
			if (homeAddress == null)
				homeAddress = new Address();

			homeAddress.setAddressType(theRenterUserProfile.getContactInfoHomeAddressType());
			homeAddress.setAddrLine1(theRenterUserProfile.getContactInfoHomeAddrLine1());
			homeAddress.setAddrLine2(theRenterUserProfile.getContactInfoHomeAddrLine2());
			homeAddress.setAddrLine3(theRenterUserProfile.getContactInfoHomeAddrLine3());
			homeAddress.setAddrLine4(theRenterUserProfile.getContactInfoHomeAddrLine4());
			homeAddress.setCity(theRenterUserProfile.getContactInfoHomeCity());
			homeAddress.setState(stateOrProvinceService.findById(theRenterUserProfile.getContactInfoHomeState())
					.getStateOrProvince());

			homeAddress.setPostalCode(theRenterUserProfile.getContactInfoHomePostalCode());
			homeAddress.setCountry(countryService.findByCountryCode(theRenterUserProfile.getContactInfoHomeCountry())
					.getCountryName());

			addressService.save(homeAddress);
		}

		// update the employer address in the db
		if (!"".equals(theRenterUserProfile.getEmployerInfoEmployerAddrLine1())) {
			employerAddress = addressService.findByAddressId(theRenterUserProfile.getEmployerInfoEmployerAddressId());
			if (employerAddress == null)
				employerAddress = new Address();

			employerAddress.setAddressType(theRenterUserProfile.getEmployerInfoEmployerAddressType());
			employerAddress.setAddrLine1(theRenterUserProfile.getEmployerInfoEmployerAddrLine1());
			employerAddress.setAddrLine2(theRenterUserProfile.getEmployerInfoEmployerAddrLine2());
			employerAddress.setAddrLine3(theRenterUserProfile.getEmployerInfoEmployerAddrLine3());
			employerAddress.setAddrLine4(theRenterUserProfile.getEmployerInfoEmployerAddrLine4());
			employerAddress.setCity(theRenterUserProfile.getEmployerInfoEmployerCity());
			employerAddress.setState(stateOrProvinceService
					.findById(theRenterUserProfile.getEmployerInfoEmployerState()).getStateOrProvince());

			employerAddress.setPostalCode(theRenterUserProfile.getEmployerInfoEmployerPostalCode());
			employerAddress.setCountry(countryService
					.findByCountryCode(theRenterUserProfile.getEmployerInfoEmployerCountry()).getCountryName());

			addressService.save(employerAddress);
		}

		ContactInfo contactInfo = null;
		// update the Contact Info record in the db
		if (!"".equals(theRenterUserProfile.getContactInfoFirstName())) {
			contactInfo = contactInfoService.findContactInfoById(theRenterUserProfile.getContactInfoId());
			if (contactInfo == null)
				contactInfo = new ContactInfo();

			contactInfo.setFirstName(theRenterUserProfile.getContactInfoFirstName());
			contactInfo.setLastName(theRenterUserProfile.getContactInfoLastName());
			contactInfo.setPrimaryEmail(theRenterUserProfile.getContactInfoPrimaryEmail());
			contactInfo.setSecondaryEmail(theRenterUserProfile.getContactInfoSecondaryEmail());
			contactInfo.setHomePhoneNo(theRenterUserProfile.getContactInfoHomePhoneNo().toString());
			contactInfo.setWorkPhoneNo(theRenterUserProfile.getContactInfoWorkPhoneNo().toString());
			contactInfo.setCellPhoneNo(theRenterUserProfile.getContactInfoCellPhoneNo().toString());
			List<Address> homeAddresses = new ArrayList<Address>();
			homeAddresses.add(homeAddress);
			contactInfo.setHomeAddresses(homeAddresses);

			contactInfoService.save(contactInfo);

		}

		EmployerInfo employerInfo = null;
		// update the Employer Info record in the db
		if (!"".equals(theRenterUserProfile.getEmployerInfoEmployerName())) {
			employerInfo = employerInfoService.findEmployerInfoById(theRenterUserProfile.getEmployerInfoId());
			if (employerInfo == null)
				employerInfo = new EmployerInfo();

			employerInfo.setEmployerName(theRenterUserProfile.getEmployerInfoEmployerName());
			employerInfo.setEmployerPhoneNo(theRenterUserProfile.getEmployerInfoEmployerPhoneNo().toString());
			List<Address> employerAddresses = new ArrayList<Address>();
			employerAddresses.add(employerAddress);
			employerInfo.setEmployerAddresses(employerAddresses);

			employerInfoService.save(employerInfo);

		}

		// get the user from the session and add it to the RenterProfile
		User user = (User) se.getAttribute("user");
		System.out.println("In RenterController   processUpdateRenterProfileForm() method:   user=    id: "
				+ user.getId() + "  | name: " + user.getFirstName() + " " + user.getLastName() + "  | username: "
				+ user.getUserName());

		// Now update the RenterProfile record in the database
		RenterProfile renterProfile = renterProfileService.findByUserId(user.getId());
		System.out.println("14a: In RenterController   processUpdateRenterProfileForm() method:   renterProfile= "
				+ renterProfile + "  | user.getId()= " + user.getId());
		if (renterProfile == null)
			renterProfile = new RenterProfile();
		System.out.println("14b: In RenterController   processUpdateRenterProfileForm() method:   renterProfile= "
				+ renterProfile);

		renterProfile.setTypeOfProfile("RENTER");

		if (user != null) {
			renterProfile.setUser(user);
		}
		if (contactInfo != null) {
			renterProfile.setContactInfo(contactInfo);
		}
		if (employerInfo != null) {
			renterProfile.setEmployerInfo(employerInfo);
		}
		// update the renter profile record
		renterProfileService.save(renterProfile);

		ModelAndView mv = new ModelAndView("renter/update-renter-profile-confirmation");
		mv.addObject("renterUserProfile", theRenterUserProfile);
		return mv;

	}

	
	
	// handler method to display the renter profile page
	@GetMapping("/showDisplayRenterProfilePage")
	public ModelAndView showDisplayRenterProfilePage(HttpServletRequest request, Model theModel) {
		System.out.println("a1: Entering RenterController   showDisplayRenterProfilePage() method");
		ModelAndView mv = new ModelAndView("renter/display-renter-profile");
		RenterUserProfile renterUserProfile = new RenterUserProfile();
		mv.addObject("renterUserProfile", new RenterUserProfile());

		HttpSession se = request.getSession();
		User user = (User) se.getAttribute("user");
		System.out.println("a2: ---> In RenterController   showDisplayRenterProfilePage() method   user= "
				+ user.getId() + " | " + user.getUserName() + " | " + user.getFirstName() + " " + user.getLastName());
		mv.addObject("user", user);

		// now that we have the user, use the user id to find the Renter Profile record
		// with that user id
		RenterProfile renterProfile = renterProfileService.findByUserId(user.getId());
		System.out.println("a3: ---> In RenterController   showDisplayRenterProfilePage() method   renterProfile= "
				+ renterProfile);
		mv.addObject("renterProfile", renterProfile);

		// from the renterProfile record, get the Contact Info record and Employer Info
		// record
		System.out.println(
				"a4a: ---> In RenterController   showDisplayRenterProfilePage() method   renterProfile.getUser().getId()= "
						+ renterProfile.getUser().getId());

		System.out.println(
				"a4a: ---> In RenterController   showDisplayRenterProfilePage() method   renterProfile.getContactInfo().getId()= "
						+ renterProfile.getContactInfo().getId());
		ContactInfo contactInfo = contactInfoService.findContactInfoById(renterProfile.getContactInfo().getId());
		System.out.println("a4b: ---> In RenterController   showDisplayRenterProfilePage() method   contactInfo= "
				+ contactInfo.toString());

		System.out.println(
				"a5a: ---> In RenterController   showDisplayRenterProfilePage() method   renterProfile.getEmployerInfo().getId()= "
						+ renterProfile.getEmployerInfo().getId());
		EmployerInfo employerInfo = employerInfoService.findEmployerInfoById(renterProfile.getEmployerInfo().getId());
		System.out.println("a5b: ---> In RenterController   showDisplayRenterProfilePage() method   employerInfo= "
				+ employerInfo.getEmployerName());

		System.out.println(
				"a5c: ---> In RenterController   showDisplayRenterProfilePage() method   renterProfile.getEmployerInfo().getId()= "
						+ renterProfile.getEmployerInfo().getId());
		PrivateInfo privateInfo = privateInfoService.findPrivateInfoById(renterProfile.getPrivateInfo().getId());
		System.out.println("a5d: ---> In RenterController   showDisplayRenterProfilePage() method   privateInfo= "
				+ privateInfo.getCreditCardNo());

		mv.addObject("contactInfo", contactInfo);
		List<Address> homeAddresses = new ArrayList<Address>();
		homeAddresses.add(contactInfo.getHomeAddresses().get(0));
		mv.addObject("contactInfo_homeAddresses", homeAddresses);
		System.out.println("a5e: ---> In RenterController   showDisplayRenterProfilePage() method   homeAddresses= "
				+ homeAddresses.toString());

		String state_to_find = contactInfo.getHomeAddresses().get(0).getState();
		System.out.println(
				"a6a:In RenterController  in showDisplayRenterProfilePage() method    state_to_find= " + state_to_find);

		int stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("a6b: In RenterController  in showDisplayRenterProfilePage() method    state_to_find= "
				+ state_to_find + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("contactInfoHomeAddressStateIndx", stateOrProvinceStateIndx);

		mv.addObject("employerInfo", employerInfo);
		List<Address> employerAddresses = new ArrayList<Address>();
		employerAddresses.add(employerInfo.getEmployerAddresses().get(0));
		mv.addObject("employerInfo_employerAddresses", employerAddresses);

		state_to_find = employerInfo.getEmployerAddresses().get(0).getState();
		System.out.println("a7a: In RenterController  in showDisplayRenterProfilePage() method    state_to_find= "
				+ state_to_find);

		stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("a7b: In RenterController  in showDisplayRenterProfilePage() method    state_to_find= "
				+ state_to_find + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("employerInfoEmployerAddressStateIndx", stateOrProvinceStateIndx);

		mv.addObject("privateInfo", privateInfo);
		List<Address> creditCardBillingAddresses = new ArrayList<Address>();
		creditCardBillingAddresses.add(privateInfo.getCreditCardBillingAddresses().get(0));
		mv.addObject("privateInfo_creditCardBillingAddresses", creditCardBillingAddresses);
		System.out.println(
				"a8a: ---> In RenterController   showDisplayRenterProfilePage() method   creditCardBillingAddresses= "
						+ creditCardBillingAddresses.toString());

		state_to_find = privateInfo.getCreditCardBillingAddresses().get(0).getState();
		System.out.println(
				"a8b:In RenterController  in showDisplayRenterProfilePage() method    state_to_find= " + state_to_find);

		stateOrProvinceStateIndx = stateOrProvinceService.findStateOrProvinceIndex(state_to_find);
		System.out.println("a8c: In RenterController  in showDisplayRenterProfilePage() method    state_to_find= "
				+ state_to_find + " |  stateOrProvinceStateIndx= " + stateOrProvinceStateIndx);
		mv.addObject("privateInfoCreditCardBillingAddressStateIndx", stateOrProvinceStateIndx);

		// get countries and states from the session object and add them to the model
		// and view object
		List<Country> countries = (List<Country>) se.getAttribute("countries");
		System.out.println( 
				"a10: ---> In RenterController   showDisplayRenterProfilePage() method   countries= " + countries);

		List<StateOrProvince> statesOrProvinces = (List<StateOrProvince>) se.getAttribute("statesOrProvinces");
		System.out.println("a11: ---> In RenterController   showDisplayRenterProfilePage() method   statesOrProvinces= "
				+ statesOrProvinces);

		mv.addObject("countries", countries);
		mv.addObject("statesOrProvincesForHomeAddress", statesOrProvinces);
		mv.addObject("statesOrProvincesForEmployerAddress", statesOrProvinces);

		// se.setAttribute("countries", countries);
		se.setAttribute("statesOrProvincesForHomeAddress", statesOrProvinces);
		se.setAttribute("statesOrProvincesForEmployerAddress", statesOrProvinces);
		System.out.println("a11a: ---> In RenterController   ");
		int genderIndx = privateInfo.getGender();
		System.out.println("a11aa: ---> In RenterController    genderIndx= " + genderIndx);

		String gender = RentalWebsiteConstants.GENDERS[genderIndx];
		mv.addObject("gender", gender);
		System.out.println("a11b: ---> In RenterController   ");

		int ethnicityIndx = privateInfo.getEthnicity();
		String ethnicity = RentalWebsiteConstants.ETHNICITIES[ethnicityIndx];
		mv.addObject("ethnicity", ethnicity);
		System.out.println("a11c: ---> In RenterController   ");

		int creditCardNoExpMonthIndx = privateInfo.getCreditCardNoExpMonth();
		String ccExpMonth = RentalWebsiteConstants.MONTHS_SHORT[creditCardNoExpMonthIndx];
		mv.addObject("ccExpMonth", ccExpMonth);
		System.out.println("a11d1: ---> In RenterController   ");


		//int creditCardNoExpYearIndx = privateInfo.getCreditCardNoExpYear();
		//System.out.println("a11d2: ---> In RenterController   creditCardNoExpYearIndx= " + creditCardNoExpYearIndx);

		String ccExpYear = privateInfo.getCreditCardNoExpYear().toString();
		System.out.println("a11d3: ---> In RenterController   ccExpYear= " + ccExpYear);

		mv.addObject("ccExpYear", ccExpYear);
		System.out.println("a11e: ---> In RenterController   ");

		
		
	//	System.out.println("z96: Exiting RenterController   showDisplayRenterProfilePage() method   privateInfo= " + privateInfo.toString());
	//	System.out.println("z97: Exiting RenterController   showDisplayRenterProfilePage() method   genderIndx= " + genderIndx + "  | ethnicity= " + ethnicity + "  | ccExpMonth= " +  ccExpMonth + "  | ccExpYear= " + ccExpYear);
		
		
		System.out.println(
				"z98: Exiting RenterController   showDisplayRenterProfilePage() method   countries= " + countries);
		System.out.println("z99: Exiting RenterController   showDisplayRenterProfilePage() method   statesOrProvinces= "
				+ statesOrProvinces + "\n\n");

		return mv;
	}
	
	
	// handler method to display the delete renter profile page	
	@PostMapping("/showDeleteRenterProfilePage")
	public ModelAndView showDeleteRenterProfilePage(HttpServletRequest request) {
		
		// TODO -- complete the rest of this method in the future
		
		ModelAndView mv = new ModelAndView();
		return mv;

	}
	
	// TODO --  finish the delete renter profile processing in the future

}
