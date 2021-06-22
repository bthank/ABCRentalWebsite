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
import com.abcrentals.binu.thankachan.entity.RentalPayment;
import com.abcrentals.binu.thankachan.entity.RentalProperty;
import com.abcrentals.binu.thankachan.entity.RentalRepair;
import com.abcrentals.binu.thankachan.entity.RenterProfile;
import com.abcrentals.binu.thankachan.entity.User;
import com.abcrentals.binu.thankachan.service.RentalPaymentService;
import com.abcrentals.binu.thankachan.service.RentalPropertyService;
import com.abcrentals.binu.thankachan.service.RenterProfileService;
import com.abcrentals.binu.thankachan.service.UserService;

/*
 * Controller class to specify handler methods for procesing rental payments grouped under /manager/rental-payments path
 * 
 * 
 * 
 */


@Controller
@RequestMapping("/manager/rental-payments")
public class RentalPaymentController {

	
    private Logger logger = Logger.getLogger(getClass().getName());

	
	
    @Autowired
    private UserService userService;
    
    @Autowired
    private RentalPaymentService rentalPaymentService;
    
  	@Autowired
  	private RentalPropertyService rentalPropertyService;
  	
  	@Autowired
  	private RenterProfileService renterProfileService;
    
	
	
	
	
    
	
    // SHOW THE RENTAL PAYMENT MANAGEMENT PAGE =====================================================================================================
    
	@GetMapping("/showManageRentalPaymentsPage")
	public ModelAndView showManageRentalPaymentsPage(HttpServletRequest request,Model theModel) {
		
		System.out.println("a1a: Entering RentalPaymentController   showManageRentalPaymentsPage() method");

		ModelAndView mv = new ModelAndView("manager/rental-payments/manage-rental-payments");
		
		System.out.println("a99a: Exiting RentalPaymentController   showManageRentalPaymentsPage() method   ");
		 
		return mv;
	}	
    
	
	
	
	
    
	
    // SHOW A PAGE DISPLAYING ALL RENTAL PAYMENTS =================================================================================================
	
	@GetMapping("/showAllRentalPaymentsPage")
	public ModelAndView showAllRentalPaymentsPage(HttpServletRequest request,Model theModel) {
		
		System.out.println("a1a: Entering RentalPaymentController   showAllRentalPaymentsPage() method");

		ModelAndView mv = new ModelAndView("manager/rental-payments/display-rental-payments");
		List<RentalPayment> rentalPaymentList = rentalPaymentService.findAllRentalPayments();
		mv.addObject("rentalPaymentList", rentalPaymentList);
		
			
		System.out.println("a99a: Exiting RentalPaymentController   showAllRentalPaymentsPage() method   ");
		 
		return mv;
	}
    
	
	
	
	
    
	
	// ADD RENTAL PAYMENTS HANDLER METHODS ========================================================================================================
	
	@GetMapping("/showAddRentalPaymentPage")
	public ModelAndView showAddRentalPaymentPage(HttpServletRequest request,Model theModel) {
		
		System.out.println("b1a: Entering RentalPaymentController   in showAddRentalPaymentPage() method\n\n");

		RentalPayment rentalPayment = new RentalPayment();

		ModelAndView mv = new ModelAndView("manager/rental-payments/add-rental-payment");
		mv.addObject("rentalPayment", rentalPayment);
		
		
		List<RenterProfile> renterProfileList = renterProfileService.findAllRenterProfiles();
		mv.addObject("renterProfileList", renterProfileList);
	
		
		List<RentalProperty> rentalPropertyList = rentalPropertyService.findAllRentalProperties();
		mv.addObject("rentalPropertyList", rentalPropertyList);

	    Map<Integer, String> rentalYearList = new HashMap<Integer, String>();
	    int i=0;
	    for(String str: RentalWebsiteConstants.RENTAL_YEARS) {
	    	rentalYearList.put(i++, str);
	    }
		mv.addObject("rentalYearList", rentalYearList);
		
	    Map<Integer, String> rentalMonthList = new HashMap<Integer, String>();
	    i=0;
	    for(String str: RentalWebsiteConstants.MONTHS_2DIGIT_NUM) {
	    	rentalMonthList.put(i++, str);
	    }
		mv.addObject("rentalMonthList", rentalMonthList);

		
		HttpSession se = request.getSession();
		se.setAttribute("renterProfileList", renterProfileList);
		se.setAttribute("rentalPropertyList", rentalPropertyList);
		se.setAttribute("rentalYearList", rentalYearList);
		se.setAttribute("rentalMonthList", rentalMonthList);
		
		System.out.println("b99a: In RentalPaymentController   showAddRentalPaymentPage() method   rentalPropertyList= " + rentalPropertyList.toString());
//		System.out.println("b99b: In RentalPaymentController   showAddRentalPaymentPage() method   mv= " + mv.getModelMap().toString() + "\n\n");
		 
		return mv;
	}
	
	
	
	@PostMapping("/processAddRentalPaymentForm")
	public ModelAndView processAddRentalPaymentForm(HttpServletRequest request,
				@Valid @ModelAttribute("rentalPayment") RentalPayment theRentalPayment, 
				BindingResult theBindingResult, 
				Model theModel) {

		System.out.println("c1a: Entering RentalPaymentController  processAddRentalPaymentForm() method   :   theRentalPayment: " + theRentalPayment.toString());

		logger.info("Processing Add Rental Payment form for rental property id: " + theRentalPayment.getRentalPropertyId() + "  | unit no: " + theRentalPayment.getRentalUnitNo() + "  | renter user id: " + theRentalPayment.getRenterUserId());

		HttpSession se = request.getSession();
		
		// form validation
		if (theBindingResult.hasErrors()){
			System.out.println("c2a: in processAddRentalPaymentForm() method:  there are errors  | redirecting to rental-payment/add-rental-payment page");
			System.out.println("c2b: in processAddRentalPaymentForm() method:  | " + theBindingResult.getAllErrors().toString());
			ModelAndView mv = new ModelAndView("manager/rental-payments/add-rental-payment");
			mv.addObject("rentalPayment", theRentalPayment);
   			mv.addObject("renterProfileList", se.getAttribute("renterProfileList"));
   			mv.addObject("rentalPropertyList", se.getAttribute("rentalPropertyList"));
   			mv.addObject("rentalYearList", se.getAttribute("rentalYearList"));
   			mv.addObject("rentalMonthList", se.getAttribute("rentalMonthList"));
   					 
			return mv;
		}

 
		 
		// get the user from the session and add it to the RentalPayment
		User user = (User)se.getAttribute("user");
		System.out.println("c8a: In RentalPaymentController   processAddRentalPaymentForm() method:   user=    id: " + user.getId() + "  | name: " + user.getFirstName() + " " + user.getLastName()+ "  | username: " + user.getUserName());
	 
		//theRentalPayment.setDateOfPayment(null); 
		theRentalPayment.setRentalYear(RentalWebsiteConstants.RENTAL_YEARS[Integer.parseInt(theRentalPayment.getRentalYear())]);
		theRentalPayment.setRentalMonth(RentalWebsiteConstants.MONTHS_2DIGIT_NUM[Integer.parseInt(theRentalPayment.getRentalMonth())]);
		
		 
		// Now save the RentalPayment record to the database
		rentalPaymentService.save(theRentalPayment);
			 
		ModelAndView mv = new ModelAndView("manager/rental-payments/add-rental-payment-confirmation");
	//	mv.addObject("rentalPayment", theRentalPayment);
		return mv;

	}


	
	
	
	
    // SHOW A PAGE FOR THE USER TO SELECT SPECIFIC RENTAL PAYMENTS =================================================================================================
	
	@GetMapping("/showSelectRentalPaymentsToDisplayPage")
	public ModelAndView showSelectRentalPaymentsToDisplayPage(HttpServletRequest request,Model theModel) {
		
		System.out.println("a1a: Entering RentalPaymentController   showSelectRentalPaymentsToDisplayPage() method");

		ModelAndView mv = new ModelAndView("manager/rental-payments/select-rental-payments-to-display");
		RentalPayment rentalPayment = new RentalPayment();
		mv.addObject("rentalPayment", rentalPayment);
		
		List<RenterProfile> renterProfileList = renterProfileService.findAllRenterProfiles();
		mv.addObject("renterProfileList", renterProfileList);
	
		List<RentalProperty> rentalPropertyList = rentalPropertyService.findAllRentalProperties();
		mv.addObject("rentalPropertyList", rentalPropertyList);


	    Map<Integer, String> rentalYearList = new HashMap<Integer, String>();
	    int i=0;
	    for(String str: RentalWebsiteConstants.RENTAL_YEARS) {
	    	rentalYearList.put(i++, str);
	    }
		mv.addObject("rentalYearList", rentalYearList);
		
	    Map<Integer, String> rentalMonthList = new HashMap<Integer, String>();
	    i=0;
	    for(String str: RentalWebsiteConstants.MONTHS_2DIGIT_NUM) {
	    	rentalMonthList.put(i++, str);
	    }
		mv.addObject("rentalMonthList", rentalMonthList);

		
		HttpSession se = request.getSession();
		se.setAttribute("renterProfileList", renterProfileList);
		se.setAttribute("rentalPropertyList", rentalPropertyList);
		se.setAttribute("rentalYearList", rentalYearList);
		se.setAttribute("rentalMonthList", rentalMonthList);
		
			/*
		 * List<RentalPayment> rentalPaymentList =
		 * rentalPaymentService.findAllRentalPayments();
		 * mv.addObject("rentalPaymentList", rentalPaymentList);
		 */
		
			
		System.out.println("a99a: Exiting RentalPaymentController   showSelectRentalPaymentsToDisplayPage() method   ");
		 
		return mv;
	}
    
	
	
	
	
	@PostMapping("/showRentalPaymentsToDisplay")
	public ModelAndView showRentalPaymentsToDisplay(HttpServletRequest request,
			@Valid @ModelAttribute("rentalPayment") RentalPayment theRentalPayment, 
			BindingResult theBindingResult, 
			Model theModel) {
		
		System.out.println("a1a: Entering RentalPaymentController   showRentalPaymentsToDisplay() method");
		System.out.println("a1a: Entering RentalPaymentController   showRentalPaymentsToDisplay() method    theRentalPayment= " + theRentalPayment.toString());

		ModelAndView mv = new ModelAndView("manager/rental-payments/display-rental-payments");
		
		
		Long    rentalProptyId = theRentalPayment.getRentalPropertyId();
		Integer rentalUntNo    = theRentalPayment.getRentalUnitNo();
		String  rentalYr       = theRentalPayment.getRentalYear();
		if (!rentalYr.equals("-1")) rentalYr = RentalWebsiteConstants.RENTAL_YEARS[Integer.parseInt(rentalYr)];
		String  rentalMnth     = theRentalPayment.getRentalMonth();
		if (!rentalMnth.equals("-1")) rentalMnth = RentalWebsiteConstants.MONTHS_2DIGIT_NUM[Integer.parseInt(rentalMnth)];
		Long    renterUsrId    = theRentalPayment.getRenterUserId();
		
		List<RentalPayment> rentalPaymentList = null;
		if (rentalProptyId != -1 && rentalUntNo != null && !rentalYr.equals("-1") && !rentalMnth.equals("-1") && renterUsrId != -1) {
			rentalPaymentList = rentalPaymentService.findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonthAndRenterUserId(rentalProptyId, 
																											rentalUntNo, rentalYr, rentalMnth, renterUsrId);
			
			mv.addObject("rentalPaymentList", rentalPaymentList);
			return mv;			
		}
		if (rentalProptyId != -1 && rentalUntNo != null && !rentalYr.equals("-1") && !rentalMnth.equals("-1")) {
			rentalPaymentList = rentalPaymentService.
									findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonth(	rentalProptyId, 
																											rentalUntNo, 
																											rentalYr, 
																											rentalMnth); 
			mv.addObject("rentalPaymentList", rentalPaymentList);
			return mv;
		}
		if (rentalProptyId != -1 && rentalUntNo != null && !rentalYr.equals("-1")) {
			rentalPaymentList = rentalPaymentService.findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYear(	rentalProptyId, rentalUntNo, 
					rentalYr);			
			mv.addObject("rentalPaymentList", rentalPaymentList);
			return mv;
		}
		if (rentalProptyId != -1 && rentalUntNo != null) {
			rentalPaymentList = rentalPaymentService.findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNo(rentalProptyId, rentalUntNo);
					
			mv.addObject("rentalPaymentList", rentalPaymentList);
			return mv;
		}
		if (!rentalMnth.equals("-1") &&  renterUsrId != -1) {
			rentalPaymentList = rentalPaymentService.findAllRentalPaymentsByMonthAndRenterUserId(rentalMnth, renterUsrId);
					
			mv.addObject("rentalPaymentList", rentalPaymentList);
			return mv;
		}

		if (rentalProptyId != -1) {
			rentalPaymentList = rentalPaymentService.findAllRentalPaymentsByRentalPropertyId(rentalProptyId);		
			
			mv.addObject("rentalPaymentList", rentalPaymentList);
			return mv;
		}
		if (!rentalYr.equals("-1")) {
			rentalPaymentList = rentalPaymentService.findAllRentalPaymentsByYear(rentalYr);	
			
			mv.addObject("rentalPaymentList", rentalPaymentList);
			return mv;
		}
		if (!rentalMnth.equals("-1")) {
			rentalPaymentList = rentalPaymentService.findAllRentalPaymentsByMonth(rentalMnth);
			
			mv.addObject("rentalPaymentList", rentalPaymentList);
			return mv;
		}
		if (rentalUntNo != null) {
			rentalPaymentList = rentalPaymentService.findAllRentalPaymentsByRentalUnitNo(rentalUntNo);
			
			mv.addObject("rentalPaymentList", rentalPaymentList);
			return mv;
		}		
		
		
		
		if (renterUsrId != -1) {
			rentalPaymentList = rentalPaymentService.findAllRentalPaymentsByRenterUserId(renterUsrId);
			
			mv.addObject("rentalPaymentList", rentalPaymentList);
			return mv;
		}

		// Otherwise, just return the entire list
		rentalPaymentList = rentalPaymentService.findAllRentalPayments();
		mv.addObject("rentalPaymentList", rentalPaymentList);

			
		System.out.println("a99a: Exiting RentalPaymentController   showRentalPaymentsToDisplay() method   ");
		 
		return mv;
	}
	
	
	
	
	   // SHOW A PAGE FOR THE USER TO SELECT A SPECIFIC RENTAL PAYMENT TO UPDATE  ==============================================================
	
	
	
	
	@PostMapping("/showSelectRentalPaymentToUpdatePage")
	public ModelAndView showSelectRentalRepairToDeletePage(HttpServletRequest request) {
		

		ModelAndView mv = new ModelAndView();
		return mv;

	}
	
	
	
	
	
    // SHOW A PAGE FOR THE USER TO SELECT A SPECIFIC RENTAL PAYMENT TO DELETE BY ID  ==============================================================
	
	@GetMapping("/showSelectRentalPaymentToDeletePage")
	public ModelAndView showSelectRentalPaymentToDeletePage(HttpServletRequest request,Model theModel) {
		
		System.out.println("a1a: Entering RentalPaymentController   showSelectRentalPaymentToDeletePage() method");

		ModelAndView mv = new ModelAndView("manager/rental-payments/select-rental-payment-to-delete");
		RentalPayment rentalPayment = new RentalPayment();
		mv.addObject("rentalPayment", rentalPayment);
		
		
		List<RentalPayment> rentalPaymentList = rentalPaymentService.findAllRentalPayments();
		mv.addObject("rentalPaymentList", rentalPaymentList);
		
			
		HttpSession se = request.getSession();
		se.setAttribute("rentalPaymentList", rentalPaymentList);
		
 
		
			
		System.out.println("a99a: Exiting RentalPaymentController   showSelectRentalPaymentToDeletePage() method   ");
		 
		return mv;
	}
	
	
	@PostMapping("/showRentalPaymentToDeleteForm")
	public ModelAndView showRentalPaymentToDeleteForm(HttpServletRequest request,
			@Valid @ModelAttribute("rentalPayment") RentalPayment theRentalPayment, 
			BindingResult theBindingResult, 
			Model theModel) {
		
		System.out.println("a1a: Entering RentalPaymentController   showRentalPaymentToDeleteForm() method");

		ModelAndView mv = new ModelAndView("manager/rental-payments/display-rental-payment-to-delete");
		RentalPayment rentalPayment = rentalPaymentService.findById(theRentalPayment.getId());
		mv.addObject("rentalPayment", rentalPayment);
		System.out.println("a2a: In RentalPaymentController   showRentalPaymentToDeleteForm() method    rentalPayment= " + rentalPayment.toString());
		
		

			
		System.out.println("a99a: Exiting RentalPaymentController   showRentalPaymentToDeleteForm() method   ");
		 
		return mv;
	}
	
	
	
	@PostMapping("/processDeleteRentalPaymentForm")
	public ModelAndView processDeleteRentalPaymentForm(HttpServletRequest request,
				@Valid @ModelAttribute("rentalPayment") RentalPayment theRentalPayment, 
				BindingResult theBindingResult, 
				Model theModel) {

		System.out.println("c1a: Entering RentalPaymentController  processDeleteRentalPaymentForm() method   :   theRentalPayment: " + theRentalPayment.toString());

		logger.info("Processing Delete Rental Payment form for rental property id: " + theRentalPayment.getRentalPropertyId() + "  | unit no: " + theRentalPayment.getRentalUnitNo() + "  | renter user id: " + theRentalPayment.getRenterUserId());

		HttpSession se = request.getSession();
		
		// form validation
		if (theBindingResult.hasErrors()){
			System.out.println("c2a: in processDeleteRentalPaymentForm() method:  there are errors  | redirecting to manager/rental-payments/select-rental-payment-to-delete page");
			System.out.println("c2b: in processDeleteRentalPaymentForm() method:  | " + theBindingResult.getAllErrors().toString());
			ModelAndView mv = new ModelAndView("manager/rental-payments/select-rental-payment-to-delete");
   					 
			return mv;
		}		
		 
		// Now delete the RentalPayment record from the database
		rentalPaymentService.delete(theRentalPayment);
			 
		ModelAndView mv = new ModelAndView("manager/rental-payments/delete-rental-payment-confirmation");
		System.out.println("c99a: Exiting RentalPaymentController  processDeleteRentalPaymentForm() method after deleting    theRentalPayment: " + theRentalPayment.toString());
 
		return mv;

	}

	
	
	
	
}
