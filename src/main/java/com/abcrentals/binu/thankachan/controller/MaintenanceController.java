package com.abcrentals.binu.thankachan.controller;

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
import com.abcrentals.binu.thankachan.entity.ContractorProfile;
import com.abcrentals.binu.thankachan.entity.ManagerProfile;
import com.abcrentals.binu.thankachan.entity.OwnerProfile;
import com.abcrentals.binu.thankachan.entity.RentalProperty;
import com.abcrentals.binu.thankachan.entity.RentalRepair;
import com.abcrentals.binu.thankachan.entity.User;
import com.abcrentals.binu.thankachan.service.ContractorProfileService;
import com.abcrentals.binu.thankachan.service.ManagerProfileService;
import com.abcrentals.binu.thankachan.service.OwnerProfileService;
import com.abcrentals.binu.thankachan.service.RentalPropertyService;
import com.abcrentals.binu.thankachan.service.RentalRepairService;
import com.abcrentals.binu.thankachan.service.UserService;

/*
 * Controller class to specify handler methods for functionality grouped under /maintenance
 * 
 * 
 * 
 */


@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

	
    private Logger logger = Logger.getLogger(getClass().getName());

	
	
    @Autowired
    private UserService userService;
    
	@Autowired
	private RentalPropertyService rentalPropertyService;
	
	
	@Autowired
	private RentalRepairService rentalRepairService;
	
	@Autowired
	private OwnerProfileService ownerProfileService;
	
	@Autowired
	private ManagerProfileService managerProfileService;
	
	@Autowired
	private ContractorProfileService contractorProfileService;
	
	
	
	//  ========================================================= USERS =========================================================================
		
	@GetMapping("/manage-users/showManageUsersPage")
	public ModelAndView showManageUsersPage(HttpServletRequest request,Model theModel) {
		
		System.out.println("a1a: Entering MaintenanceController   showManageUsersPage() method");

		ModelAndView mv = new ModelAndView("maintenance/manage-users/manage-users");
		
			
		System.out.println("a99a: Exiting MaintenanceController   showManageUsersPage() method   ");
		 
		return mv;
	}	
	
	
	
	
	@GetMapping("/manage-users/showDisplayUsersPage")
	public ModelAndView showDisplayUsersPage(HttpServletRequest request,Model theModel) {
		
		System.out.println("a1a: Entering MaintenanceController   showDisplayUsersPage() method");

		ModelAndView mv = new ModelAndView("maintenance/manage-users/display-users");
		List<User> userList = userService.findAllUsers();
		mv.addObject("userList", userList);
		
			
		System.out.println("a99a: Exiting MaintenanceController   showDisplayUsersPage() method   ");
		 
		return mv;
	}
	

	

	
	
	

	
	
	
	
	
	
	
	
	
	//  ==================================================== RENTAL PROPERTIES ==================================================================

	@GetMapping("/manage-rental-properties/showManageRentalPropertiesPage")
	public ModelAndView showManageRentalPropertiesPage(HttpServletRequest request,Model theModel) {
		
		System.out.println("a1a: Entering MaintenanceController   showManageRentalPropertiesPage() method");

		ModelAndView mv = new ModelAndView("maintenance/manage-rental-properties/manage-rental-properties");
		
			
		System.out.println("a99a: Exiting MaintenanceController   showManageRentalPropertiesPage() method   ");
		 
		return mv;
	}	
	
	
	
	
	
	
	
	
	@GetMapping("/manage-rental-properties/showDisplayRentalPropertiesPage")
	public ModelAndView showDisplayRentalPropertiesPage(HttpServletRequest request,Model theModel) {
		
		System.out.println("a1a: Entering MaintenanceController   showManageRentalPropertiesPage() method");

		ModelAndView mv = new ModelAndView("maintenance/manage-rental-properties/display-rental-properties");
		List<RentalProperty> rentalPropertyList = rentalPropertyService.findAllRentalProperties();
		mv.addObject("rentalPropertyList", rentalPropertyList);
		
			
		System.out.println("a99a: Exiting MaintenanceController   showManageRentalPropertiesPage() method   ");
		 
		return mv;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/manage-rental-properties/showSelectRentalPropertyToUpdatePage")
	public ModelAndView showSelectRentalPropertyToUpdatePage(HttpServletRequest request,Model theModel) {
		
		System.out.println("b1a: Entering MaintenanceController   showSelectRentalPropertyToUpdatePage() method");

		ModelAndView mv = new ModelAndView("maintenance/manage-rental-properties/select-rental-property-to-update");
		
		
		HttpSession se = request.getSession();
		List<RentalProperty> rentalProperties = (List<RentalProperty>)rentalPropertyService.findAllRentalProperties();
		
		mv.addObject("rentalProperty", new RentalProperty());    // add form backing object
		mv.addObject("rentalProperties", rentalProperties);      // add for the page dropdown

		se.setAttribute("rentalProperties", rentalProperties);
 
		
		System.out.println("b99a: Exiting MaintenanceController   showSelectRentalPropertyToUpdatePage() method   ");
		 
		return mv;
	}
	
	
	
	
	@PostMapping("/manage-rental-properties/showRentalPropertyToUpdateForm")
	public ModelAndView showRentalPropertyToUpdateForm(HttpServletRequest request,
			@ModelAttribute("rentalProperty") RentalProperty theRentalPropertyToUpdate,BindingResult theBindingResult) {
		
		System.out.println("c1a: Entering MaintenanceController  showRentalPropertyToUpdateForm() method     theRentalPropertyToUpdate= " + theRentalPropertyToUpdate.toString());

		
		ModelAndView mv = new ModelAndView("maintenance/manage-rental-properties/update-rental-property");
		RentalProperty rentalProperty = rentalPropertyService.findById(theRentalPropertyToUpdate.getId());
		/*
		 * rentalProperty.setId(theRentalPropertyToUpdate.getId());
		 * rentalProperty.setRentalPropertyName(rentalProperty.getRentalPropertyName());
		 */		
		mv.addObject("rentalProperty", rentalProperty);
		
		
		
		List<OwnerProfile> ownerProfileList = ownerProfileService.findAllOwnerProfiles();
		mv.addObject("ownerProfileList", ownerProfileList);
		
		List<ManagerProfile> managerProfileList = managerProfileService.findAllManagerProfiles();
		mv.addObject("managerProfileList", managerProfileList);
		
		mv.addObject("origOwnerUserId", rentalProperty.getOwnerUserId());
		mv.addObject("origMgrUserId", rentalProperty.getManagerUserId());

 
		HttpSession se = request.getSession();
		se.setAttribute("theRentalProperty", rentalProperty);
		se.setAttribute("ownerProfileList", ownerProfileList);
		se.setAttribute("managerProfileList", managerProfileList);
		
		System.out.println("c99a: Exiting MaintenanceController   showRentalPropertyToUpdateForm() method   theRentalPropertyToUpdate:  " + theRentalPropertyToUpdate.getId() + "  | property name:  " + theRentalPropertyToUpdate.getRentalPropertyName());
		System.out.println("c99b: Exiting MaintenanceController   showRentalPropertyToUpdateForm() method   ownerProfileList= " + ownerProfileList.toString());
		System.out.println("c99c: Exiting MaintenanceController   showRentalPropertyToUpdateForm() method   managerProfileList= " + managerProfileList.toString());
		 
		return mv;
	}
	
	
	@PostMapping("/manage-rental-properties/processUpdateRentalPropertyForm")
	public ModelAndView processUpdateRentalPropertyForm(HttpServletRequest request,
				@Valid @ModelAttribute("rentalProperty") RentalProperty theRentalPropertyToUpdate, 
				BindingResult theBindingResult, 
				Model theModel) {

		HttpSession se = request.getSession();
		
		RentalProperty theRentalProperty =(RentalProperty) se.getAttribute("theRentalProperty");
		//theRentalPropertyToUpdate.setId(theRentalProperty.getId());
		theRentalPropertyToUpdate.setRentalPropertyAddress(theRentalProperty.getRentalPropertyAddress());
		 
		System.out.println("e1a: Entering MaintenanceController  processUpdateRentalPropertyForm() method   theRentalPropertyToUpdate   user id: " + theRentalPropertyToUpdate.getId() + "  |  " + theRentalPropertyToUpdate.getRentalPropertyName() + "  | mgr user id: " + theRentalPropertyToUpdate.getManagerUserId()  + "  | ower user id:  " + theRentalPropertyToUpdate.getOwnerUserId());
		
		// form validation
		if (theBindingResult.hasErrors()){
			 System.out.println("e2a: in processUpdateRentalPropertyForm() method:  there are errors  | redirecting to update-admin-profile page");
			 System.out.println("e2b: in processUpdateRentalPropertyForm() method:  | " + theBindingResult.getAllErrors().toString());
			 ModelAndView mv = new ModelAndView("maintenance/manage-rental-properties/update-rental-property");
			 mv.addObject("rentalProperty",theRentalPropertyToUpdate);
			 mv.addObject("ownerProfileList",se.getAttribute("ownerProfileList"));
			 mv.addObject("managerProfileList",se.getAttribute("managerProfileList"));

			 return mv;
		}
		 
		logger.info("Processing Update Rental Property form for property id:  " + theRentalPropertyToUpdate.getId() + "  | property name:  " + theRentalPropertyToUpdate.getRentalPropertyName() + "  | owner id:  " + theRentalPropertyToUpdate.getOwnerUserId());

 
		
		ModelAndView mv = null;
		if (theRentalPropertyToUpdate != null) {
			rentalPropertyService.save(theRentalPropertyToUpdate);
			 mv = new ModelAndView("maintenance/manage-rental-properties/update-rental-property-confirmation");
	 	 }	else {
	 		mv = new ModelAndView("maintenance/manage-rental-properties/error-updating-rental property");
	 	 }

			 
		 return mv;

	}

	
	
	@PostMapping("/manage-rental-properties/showSelectRentalPropertyToDeletePage")
	public ModelAndView showSelectRentalPropertyToDeletePage(HttpServletRequest request) {
		

		ModelAndView mv = new ModelAndView();
		return mv;

	}
	
	
	
	
	
	
	
	
	
	//  ==================================================== RENTAL REPAIRS =======================================================================
	
		
	@GetMapping("/manage-rental-repairs/showManageRentalRepairsPage")
	public ModelAndView showManageRentalRepairsPage(HttpServletRequest request,Model theModel) {
		
		System.out.println("a1a: Entering MaintenanceController   showManageRentalRepairsPage() method");

		ModelAndView mv = new ModelAndView("maintenance/manage-rental-repairs/manage-rental-repairs");
		
			
		System.out.println("a99a: Exiting MaintenanceController   showManageRentalRepairsPage() method   ");
		 
		return mv;
	}	
	
	
	
	@GetMapping("/manage-rental-repairs/showAllRentalRepairsPage")
	public ModelAndView showAllRentalRepairsPage(HttpServletRequest request,Model theModel) {
		
		System.out.println("a1a: Entering MaintenanceController   showAllRentalRepairsPage() method");

		ModelAndView mv = new ModelAndView("maintenance/manage-rental-repairs/display-rental-repairs");
		List<RentalRepair> rentalRepairList = rentalRepairService.findAllRentalRepairs();
		mv.addObject("rentalRepairList", rentalRepairList);
		
			
		System.out.println("a99a: Exiting MaintenanceController   showAllRentalRepairsPage() method   ");
		 
		return mv;
	}
	
	
	
	

	
	
	
	
	
	@GetMapping("/manage-rental-repairs/showSelectRentalRepairToUpdatePage")
	public ModelAndView showSelectRentalRepairToUpdatePage(HttpServletRequest request,Model theModel) {
		
		System.out.println("b1a: Entering MaintenanceController   showSelectRentalRepairToUpdatePage() method");

		ModelAndView mv = new ModelAndView("maintenance/manage-rental-repairs/select-rental-repair-to-update");
		
		
		HttpSession se = request.getSession();
		List<RentalRepair> rentalRepairs = (List<RentalRepair>)rentalRepairService.findAllRentalRepairs();
		
		mv.addObject("rentalRepair", new RentalRepair());    // add form backing object
		mv.addObject("rentalRepairs", rentalRepairs);        // add for the page dropdown

		se.setAttribute("rentalRepairs", rentalRepairs);
 
		
		
		
	    Map<Long, String> customRentalRepairList = new HashMap<Long, String>();
	    int i=0;
	    for(RentalRepair repair: rentalRepairs){
	    	
	    	String propertyName = rentalPropertyService.findById(repair.getRentalPropertyId()).getRentalPropertyName();
	    	String repairType   = RentalWebsiteConstants.RENTAL_REPAIR_TYPES[ repair.getRentalRepairType() ];
	    	
	    	String customString = "Repair id: " + repair.getId() + " | " + propertyName + " | Unit #: " + repair.getRentalUnitNo() + " | " + repairType;
	    	
	    	customRentalRepairList.put(repair.getId(), customString);
	    }
	    mv.addObject("customRentalRepairList", customRentalRepairList);

		
		
		
		System.out.println("b99a: Exiting MaintenanceController   showSelectRentalRepairToUpdatePage() method   ");
		 
		return mv;
	}
	
	
	
	
	@PostMapping("/manage-rental-repairs/showRentalRepairToUpdateForm")
	public ModelAndView showRentalRepairToUpdateForm(HttpServletRequest request,
			@ModelAttribute("rentalRepair") RentalRepair theRentalRepairToUpdate,BindingResult theBindingResult) {
		
		System.out.println("c1a: Entering MaintenanceController  showRentalRepairToUpdateForm() method     theRentalRepairToUpdate= " + theRentalRepairToUpdate.toString());

		
		ModelAndView mv = new ModelAndView("maintenance/manage-rental-repairs/update-rental-repair");
		RentalRepair rentalRepair = rentalRepairService.findById(theRentalRepairToUpdate.getId());
		mv.addObject("rentalRepair", rentalRepair);
		System.out.println("c3a: In MaintenanceController  showRentalRepairToUpdateForm() method     rentalRepair= " + rentalRepair.getId() + "  |  " + rentalRepair.getDescription());
		
		
		
		List<RentalProperty> rentalPropertyList = rentalPropertyService.findAllRentalProperties();
		mv.addObject("rentalPropertyList", rentalPropertyList);

	    Map<Integer, String> repairTypeList = new HashMap<Integer, String>();
	    int i=0;
	    for(String str: RentalWebsiteConstants.RENTAL_REPAIR_TYPES) {
	    	repairTypeList.put(i++, str);
	    }
	    mv.addObject("repairTypeList", repairTypeList);
	    
	    Map<Integer, String> repairStatusList = new HashMap<Integer, String>();
	    i=0;
	    for(String str: RentalWebsiteConstants.REPAIR_STATUSES) {
	    	repairStatusList.put(i++, str);
	    }
	    mv.addObject("repairStatusList", repairStatusList);
  
	    Map<Integer, String> repairRootCauseList = new HashMap<Integer, String>();
	    i=0;
	    for(String str: RentalWebsiteConstants.REPAIR_ROOT_CAUSES) {
	    	repairRootCauseList.put(i++, str);
	    }
	    mv.addObject("repairRootCauseList", repairRootCauseList);

		List<ContractorProfile> contractorList = contractorProfileService.findAllContractorProfiles();
		mv.addObject("contractorList", contractorList);
		
		
		
		
		
		
		
		HttpSession se = request.getSession();
		se.setAttribute("theRentalRepair", rentalRepair);
		se.setAttribute("rentalPropertyList", rentalPropertyList);
		se.setAttribute("repairTypeList", repairTypeList);
		se.setAttribute("repairStatusList", repairStatusList);
		se.setAttribute("repairRootCauseList", repairRootCauseList);
		se.setAttribute("contractorList", contractorList);
		
		System.out.println("c99a: Exiting MaintenanceController   showRentalRepairToUpdateForm() method   rentalRepair:  " + rentalRepair.getId() + "  | property id:  " + rentalRepair.getRentalPropertyId() + "  | unit no:  " + rentalRepair.getRentalUnitNo());
		System.out.println("c99b: Exiting MaintenanceController   showRentalRepairToUpdateForm() method   rentalPropertyList= " + rentalPropertyList.toString());
		System.out.println("c99c: Exiting MaintenanceController   showRentalRepairToUpdateForm() method   repairTypeList= " + repairTypeList.toString());
		System.out.println("c99d: Exiting MaintenanceController   showRentalRepairToUpdateForm() method   repairStatusList= " + repairStatusList.toString());
		System.out.println("c99e: Exiting MaintenanceController   showRentalRepairToUpdateForm() method   repairRootCauseList= " + repairRootCauseList.toString());
		System.out.println("c99e: Exiting MaintenanceController   showRentalRepairToUpdateForm() method   contractorList= " + contractorList.toString());
		 
		return mv;
	}
	
	
	@PostMapping("/manage-rental-repairs/processUpdateRentalRepairForm")
	public ModelAndView processUpdateRentalRepairForm(HttpServletRequest request,
				@Valid @ModelAttribute("rentalRepair") RentalRepair theRentalRepairToUpdate, 
				BindingResult theBindingResult, 
				Model theModel) {


		HttpSession se = request.getSession();
		RentalRepair theRentalRepair = (RentalRepair) se.getAttribute("theRentalRepair");
		theRentalRepairToUpdate.setSubmittedByUserId(theRentalRepair.getSubmittedByUserId());
		theRentalRepairToUpdate.setSubmittedDate(theRentalRepair.getSubmittedDate());
		theRentalRepairToUpdate.setSubmittedDate(theRentalRepair.getSubmittedDate());	
		
		System.out.println("e1a: Entering MaintenanceController  processUpdateRentalRepairForm() method   theRentalRepairToUpdate   rental repair id: " + theRentalRepairToUpdate.getId() + "  | property id:  " + theRentalRepairToUpdate.getRentalPropertyId() + "  | unit no: " + theRentalRepairToUpdate.getRentalUnitNo()  + "  | repair status:  " + theRentalRepairToUpdate.getRepairStatus());
		
		// form validation
		if (theBindingResult.hasErrors()){
			 System.out.println("e2a: in processUpdateRentalRepairForm() method:  there are errors  | redirecting to maintenance/manage-rental-repairs/update-rental-repai page");
			 System.out.println("e2b: in processUpdateRentalRepairForm() method:  | " + theBindingResult.getAllErrors().toString());
			 ModelAndView mv = new ModelAndView("maintenance/manage-rental-repairs/update-rental-repair");
			 mv.addObject("rentalRepair",theRentalRepairToUpdate);
			 mv.addObject("rentalPropertyList",se.getAttribute("rentalPropertyList"));
			 mv.addObject("repairTypeList",se.getAttribute("repairTypeList"));
			 mv.addObject("repairStatusList",se.getAttribute("repairStatusList"));
			 mv.addObject("repairRootCauseList",se.getAttribute("repairRootCauseList"));
			 mv.addObject("contractorList",se.getAttribute("contractorList"));

			 return mv;
		}
		 
		logger.info("Processing Update Rental Repair form for repair id:  " + theRentalRepairToUpdate.getId() + "  | property id:  " + theRentalRepairToUpdate.getRentalPropertyId() + "  | unit no:  " + theRentalRepairToUpdate.getRentalUnitNo());

 
		
		ModelAndView mv = null;
		if (theRentalRepairToUpdate != null) {
			rentalRepairService.save(theRentalRepairToUpdate);
			 mv = new ModelAndView("maintenance/manage-rental-repairs/update-rental-repair-confirmation");
	 	 }	else {
	 		mv = new ModelAndView("maintenance/manage-rental-repairs/error-updating-rental-repair");
	 	 }

			 
		 return mv;

	}

	
	
	
	@PostMapping("/manage-rental-repairs/showSelectRentalRepairToDeletePage")
	public ModelAndView showSelectRentalRepairToDeletePage(HttpServletRequest request) {
		

		ModelAndView mv = new ModelAndView();
		return mv;

	}
			
	
	
	
	
	
	
	
}
