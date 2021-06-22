package com.abcrentals.binu.thankachan.controller;

import java.time.LocalDate;
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
import com.abcrentals.binu.thankachan.entity.RentalProperty;
import com.abcrentals.binu.thankachan.entity.RentalRepair;
import com.abcrentals.binu.thankachan.entity.User;
import com.abcrentals.binu.thankachan.service.RentalPropertyService;
import com.abcrentals.binu.thankachan.service.RentalRepairService;

/*
 * Controller class to specify handler methods for processing rental repair functions grouped under /rental-repair path
 * 
 * 
 * 
 */


@Controller
@RequestMapping("rental-repair")
public class RentalRepairController {

    private Logger logger = Logger.getLogger(getClass().getName());

	

	@Autowired
	private RentalRepairService rentalRepairService;

	@Autowired
	private RentalPropertyService rentalPropertyService;



	
	/*
	 * @GetMapping("/showRentalRepairDataTable") public String
	 * showRentalRepairDataTable() {
	 * 
	 * return "rental-repair/display-rental-repair-data-table"; }
	 * 
	 * @GetMapping("/showRentalRepairDataTable2") public String
	 * showRentalRepairDataTable2() {
	 * 
	 * return "rental-repair/display-rental-repair-data-table2"; }
	 */
	

	
	
	@GetMapping("/showAddRentalRepairPage")
	public ModelAndView showAddRentalRepairPage(HttpServletRequest request,Model theModel) {
		
		System.out.println("b1a: Entering RentalRepairController   in showAddRentalRepairPage() method\n\n");

		RentalRepair rentalRepair = new RentalRepair();

		ModelAndView mv = new ModelAndView("rental-repair/add-rental-repair");
		mv.addObject("rentalRepair", rentalRepair);
		
		List<RentalProperty> rentalPropertyList = rentalPropertyService.findAllRentalProperties();
		mv.addObject("rentalPropertyList", rentalPropertyList);

		HttpSession se = request.getSession();
		se.setAttribute("rentalPropertyList", rentalPropertyList);

	    Map<Integer, String> repairTypeList = new HashMap<Integer, String>();
	    int i=0;
	    for(String str: RentalWebsiteConstants.RENTAL_REPAIR_TYPES) {
	    	repairTypeList.put(i++, str);
	    }

	    Map<Integer, String> repairRootCauseList = new HashMap<Integer, String>();
	    i=0;
	    for(String str: RentalWebsiteConstants.REPAIR_ROOT_CAUSES) {
	    	repairRootCauseList.put(i++, str);
	    }

		mv.addObject("rentalRepairTypes", repairTypeList);
		mv.addObject("repairRootCauses", repairRootCauseList);
		
		se.setAttribute("rentalRepairTypes", repairTypeList);
		se.setAttribute("repairRootCauses", repairRootCauseList);
		
		mv.addObject("today", LocalDate.now());
		
		
		System.out.println("b99a: In RentalRepairController   showAddRentalRepairPage() method   rentalPropertyList= " + rentalPropertyList.toString());
		System.out.println("b99b: In RentalRepairController   showAddRentalRepairPage() method   rentalRepairTypes= " + mv.getModelMap().toString() + "\n\n");
		 
		return mv;
	}
	
	
	
	@PostMapping("/processAddRentalRepairForm")
	public ModelAndView processAddRentalRepairForm(HttpServletRequest request,
				@Valid @ModelAttribute("rentalRepair") RentalRepair theRentalRepair, 
				BindingResult theBindingResult, 
				Model theModel) {

		System.out.println("c1a: Entering RentalRepairController  processAddRentalRepairForm() method   :   theRentalRepair: " + theRentalRepair.toString());

		logger.info("Processing Add Rental Repair form for rental property id: " + theRentalRepair.getRentalPropertyId() + "  | unit no: " + theRentalRepair.getRentalUnitNo() + "  | submitted by user id: " + theRentalRepair.getSubmittedByUserId());

		HttpSession se = request.getSession();
		
		// form validation
		if (theBindingResult.hasErrors()){
			System.out.println("c2a: in processAddRentalRepairForm() method:  there are errors  | redirecting to rental-repair/add-rental-repair page");
			System.out.println("c2b: in processAddRentalRepairForm() method:  | " + theBindingResult.getAllErrors().toString());
			ModelAndView mv = new ModelAndView("rental-repair/add-rental-repair");
			mv.addObject("rentalRepair", theRentalRepair);
   			mv.addObject("rentalPropertyList", se.getAttribute("rentalPropertyList"));
   			mv.addObject("rentalRepairTypes", se.getAttribute("rentalRepairTypes"));
   			mv.addObject("repairRootCauses", se.getAttribute("repairRootCauses"));
   					 
			return mv;
		}

 
		 
		// get the user from the session and add it to the RentalRepair
		User user = (User)se.getAttribute("user");
		System.out.println("c8a: In AdminController   processAddAdminProfileForm() method:   user=    id: " + user.getId() + "  | name: " + user.getFirstName() + " " + user.getLastName()+ "  | username: " + user.getUserName());
	 
		theRentalRepair.setSubmittedByUserId(user.getId());
		theRentalRepair.setSubmittedDate(LocalDate.now());
		theRentalRepair.setRepairStatus(0); 
		theRentalRepair.setRootCause(0); 		
		theRentalRepair.setAssignedToContractorId(0);
		
		 
		// Now save the RentalRepair record to the database
		rentalRepairService.save(theRentalRepair);
			 
		ModelAndView mv = new ModelAndView("rental-repair/add-rental-repair-confirmation");
	//	mv.addObject("rentalRepair", theRentalRepair);
		return mv;

	}


	
	
	
	
}
