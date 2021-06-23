package com.abcrentals.binu.thankachan.constants;

/*
 * Class to hold constants used by the website application
 * 
 * 
 * 
 */


public final class RentalWebsiteConstants {
	
	
	public static final Boolean[] TRUE_FALSE_VALUES = {
			false,
			true
	};
	
	
	public static final String[] USER_ACCESS_TYPES = { 
			"N/A", 
			"Level 1 - Basic", 
			"Level 2 - Manage",
			"Level 3 - Owner",
			"Level 4 - Admin",
			"Level 5 - Super User"
	}; 
	
	public static final String[] GENDERS       = { "N/A", "Male", "Female", "Other"}; 

	
	public static final String[] CC_EXP_YEARS  = { 
			"2021",  
			"2022",    
			"2023",    
			"2024", 
			"2025", 
			"2026", 
			"2027", 
			"2028", 
			"2029", 
			"2030" 
	}; 

	
	public static final String[] RENTAL_YEARS  = { 
			"2021",  
			"2022",    
			"2023",    
			"2024", 
			"2025", 
			"2026", 
			"2027", 
			"2028", 
			"2029", 
			"2030" 
	}; 	
	
	public static final String[] MONTHS_2DIGIT_NUM  = { 
			"01",  
			"02",    
			"03",    
			"04", 
			"05", 
			"06", 
			"07", 
			"08", 
			"09", 
			"10", 
			"11", 
			"12"
	}; 
	
	public static final String[] MONTHS_SHORT  = { 
			"N/A", 
			"Jan",  
			"Feb",    
			"Mar",    
			"Apr", 
			"May", 
			"Jun", 
			"Jul", 
			"Aug", 
			"Sep", 
			"Oct", 
			"Nov", 
			"Dec"
	}; 
	public static final String[] MONTHS_LONG   = {
			"N/A",
			"January",
			"February",
			"March",
			"April",
			"May",
			"June",
			"July",
			"August",
			"September",
			"October",
			"November",
			"December"
	}; 
	
	public static final String[] MONTHS_2DIGIT_PLUS_NAME   = {
			"01 - January",
			"02 - February",
			"03 - March",
			"04 - April",
			"05 - May",
			"06 - June",
			"07 - July",
			"08 - August",
			"09 - September",
			"10 - October",
			"11 - November",
			"12 - December"
	}; 
	
	public static final String[] ETHNICITIES = {
			"N/A",
			"American Indian or Alaska Native",
			"Asian",
			"Black or African American",
			"Hispanic or Latino",
			"Native Hawaiian or Other Pacific Islander",
			"White"
	};
	 
	
	public static final String[] RENTAL_AMENITY_TYPES = {
			"N/A",
			"Dish Washer",
			"Washer",
			"Dryer",
			"Central A/C",
			"Jacuzzi",
			"Swimming Pool",
			"1 Car Garage",
			"2 Car Garage",
			"Exercise Equipment",
			"Kitchen - Granite Countertops",
			"Concierge"
	};

	
	public static final String[] RENTAL_REPAIR_TYPES = {
			"N/A",
			"KITCHEN",
			"BATHROOM",
			"LIVING_ROOM",
			"BEDROOM",
			"BASEMENT",
			"HEATING",
			"COOLING",
			"ELECTRICAL",
			"DOORS",
			"WINDOWS",
			"OUTSIDE",
			"OTHER"
	};
	
	 
	public static final String[] REPAIR_STATUSES = {
			"N/A",
			"UNASSIGNED",
			"ASSIGNED",
			"REPAIR COMPLETED",
			"ISSUE FOUND AFTER FIX",
			"CLOSED"
	};
	
	
	public static final String[] REPAIR_ROOT_CAUSES = {
			"N/A",
			"RENTER MISUSE OR NEGLIGENCE",
			"OWNER NEGLIGENCE",
			"NORMAL WEAR AND TEAR",
			"LACK OF MAINTENANCE",
			"EXCESSIVE AGE",
			"POOR BUILD QUALITY",
			"INSTALLATION ISSUE",
			"OTHER"			
	};
	
	
	public static final String NOT_FOUND = "ERROR 200: You must be joking!  What do you mean this doesnt exist???  <br><br>";
	public static final String INTERNAL_SERVER_ERROR = "ERROR 500: What just happened?  This is a mess!  <br><br>";
	public static final String RUNTIME_EXCEPTION = "RUNTIME EXCEPTION:  What just happened?  This is a mess!  <br><br>";
	
}
