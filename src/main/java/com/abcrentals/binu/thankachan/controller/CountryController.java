package com.abcrentals.binu.thankachan.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abcrentals.binu.thankachan.entity.Country;
import com.abcrentals.binu.thankachan.service.CountryService;

/*
 * Controller class to specify handler methods for processing the Country class
 * 
 * 
 * 
 */


@Controller
@RequestMapping("/country")
public class CountryController {
	
	
    private Logger logger = Logger.getLogger(getClass().getName());
    
	@Autowired
	private CountryService countryService;

	// method to load countries list as model attribute
	@ModelAttribute("countries")
	public List<Country> initializeCountries() {

	    List <Country> countries = countryService.findAllCountries();
	    
	    System.out.println("in initializeCountry() method:  countries= " + countries.toString());

	    return countries;
	}  	
	
	
}
