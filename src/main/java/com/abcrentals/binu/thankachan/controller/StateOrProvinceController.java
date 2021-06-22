package com.abcrentals.binu.thankachan.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abcrentals.binu.thankachan.entity.Country;
import com.abcrentals.binu.thankachan.entity.StateOrProvince;
import com.abcrentals.binu.thankachan.service.CountryService;
import com.abcrentals.binu.thankachan.service.StateOrProvinceService;
import com.abcrentals.binu.thankachan.user.RenterUserProfile;

/*
 * Controller class to specify handler methods for StateOrProvince class functions
 * 
 * 
 * 
 */


@Controller
@RequestMapping("/statesOrProvinces")
public class StateOrProvinceController {
	
    private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	private StateOrProvinceService stateOrProvinceService; 
	
	@Autowired
	private CountryService countryService;

	@ModelAttribute("countries")
	public List<Country> initializeCountries() {

	    List <Country> countries = countryService.findAllCountries();
	    
	    System.out.println("\n\nIn StateOrProvinceController  in initializeCountry() method:  countries= " + countries.toString() + "\n\n");

	    return countries;
	}  	

	@RequestMapping("/getStatesOrProvincesForHomeAddress")
	public ModelAndView getStatesOrProvincesForHomeAddress(HttpServletRequest request,@RequestParam("country") int countryCode, 
			@ModelAttribute("renterUserProfile") RenterUserProfile theRenterUserProfile, 
			Model theModel) {
		System.out.println("\n\nIn StateOrProvinceController  getStatesOrProvincesForHomeAddress() method:  countryCode: " + countryCode );

		System.out.println("In StateOrProvinceController  getStatesOrProvincesForHomeAddress() method:  theRenterUserProfile: " + theRenterUserProfile.toString() );
		System.out.println("In StateOrProvinceController  getStatesOrProvincesForHomeAddress() method:  theModel: " + theModel.toString() );

		ModelAndView mv = new ModelAndView("add-renter-profile");
		Country country = countryService.findByCountryCode(countryCode);
		List<StateOrProvince> statesOrProvincesForHomeAddress = stateOrProvinceService.findByCountry(country.getCountryName());
		
		mv.addObject("renterUserProfile", theRenterUserProfile);
		mv.addObject("statesOrProvincesForHomeAddress", statesOrProvincesForHomeAddress);
		mv.addObject("country",countryCode);
		mv.addObject("countryName",country.getCountryName());
		
		
		HttpSession se = request.getSession();
		se.setAttribute("statesOrProvincesForHomeAddress", statesOrProvincesForHomeAddress);
		
		System.out.println("In StateOrProvinceController  getStatesOrProvincesForHomeAddress() method:   using countryName= " + country.getCountryName() + "    statesOrProvincesForHomeAddress: " + statesOrProvincesForHomeAddress.toString() + "\n\n");
				

		
		return mv;
	}
	

	@RequestMapping("/getStatesOrProvincesForEmployerAddress")
	public ModelAndView getStatesOrProvincesForEmployerAddress(HttpServletRequest request,@RequestParam("country") int countryCode, 
			@ModelAttribute("renterUserProfile") RenterUserProfile theRenterUserProfile,  
			Model theModel) {
		System.out.println("\n\nIn StateOrProvinceController  getStatesOrProvincesForEmployerAddress() method:  countryCode: " + countryCode );

		System.out.println("In StateOrProvinceController  getStatesOrProvincesForEmployerAddress() method:  theRenterUserProfile: " + theRenterUserProfile.toString() );
		System.out.println("In StateOrProvinceController  getStatesOrProvincesForEmployerAddress() method:  theModel: " + theModel.toString() );

		ModelAndView mv = new ModelAndView("add-renter-profile");
		mv.addObject("renterUserProfile", theRenterUserProfile);
		Country country = countryService.findByCountryCode(countryCode);
		List<StateOrProvince> statesOrProvincesForEmployerAddress = stateOrProvinceService.findByCountry(country.getCountryName());
		mv.addObject("statesOrProvincesForEmployerAddress", statesOrProvincesForEmployerAddress);
		mv.addObject("country",countryCode);
		mv.addObject("countryName",country.getCountryName());
		
		
		HttpSession se = request.getSession();
		se.setAttribute("statesOrProvincesForEmployerAddress", statesOrProvincesForEmployerAddress);
		
		System.out.println("In StateOrProvinceController  in getStatesOrProvincesForHomeAddress() method:   using countryName= " + country.getCountryName() + "    statesOrProvincesForEmployerAddress: " + statesOrProvincesForEmployerAddress.toString() + "\n\n");
				
		return mv;
	}
	

	@RequestMapping("/getStatesOrProvincesForBillingAddress")
	public ModelAndView getStatesOrProvincesForBillingAddress(HttpServletRequest request,@RequestParam("country") int countryCode, 
			@ModelAttribute("renterUserProfile") RenterUserProfile theRenterUserProfile, 
			Model theModel) {
		System.out.println("\n\nIn StateOrProvinceController  getStatesOrProvincesForBillingAddress() method:  countryCode: " + countryCode );

		System.out.println("In StateOrProvinceController  getStatesOrProvincesForBillingAddress() method:  theRenterUserProfile: " + theRenterUserProfile.toString() );
		System.out.println("In StateOrProvinceController  getStatesOrProvincesForBillingAddress() method:  theModel: " + theModel.toString() );

		ModelAndView mv = new ModelAndView("add-renter-profile");
		mv.addObject("renterUserProfile", theRenterUserProfile);
		Country country = countryService.findByCountryCode(countryCode);
		List<StateOrProvince> statesOrProvincesForBillingAddress = stateOrProvinceService.findByCountry(country.getCountryName());
		mv.addObject("statesOrProvincesForBillingAddress", statesOrProvincesForBillingAddress);
		mv.addObject("country",countryCode);
		mv.addObject("countryName",country.getCountryName());
		
		
		HttpSession se = request.getSession();
		se.setAttribute("statesOrProvincesForBillingAddress", statesOrProvincesForBillingAddress);
		
		System.out.println("In StateOrProvinceController  in getStatesOrProvincesForBillingAddress() method:   using countryName= " + country.getCountryName() + "    statesOrProvincesForBillingAddress: " + statesOrProvincesForBillingAddress.toString() + "\n\n");
				
		return mv;
	}


}
