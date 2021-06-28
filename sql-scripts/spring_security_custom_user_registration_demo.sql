# Rental Website DB scripts
# select * from user;


# To create the User table:

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name_prefix` varchar(45),
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `name_suffix` varchar(45),
  `email` varchar(45) NOT NULL,
  `user_creation_date` date,
  `access_level` int,
  `first_and_last_name` varchar(100),
  `full_name` varchar(100),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 


# To create the states_or_provinces table

CREATE TABLE `states_or_provinces` (
  `id` int NOT NULL AUTO_INCREMENT,
  `country` varchar(45) NOT NULL,
  `state_or_province` varchar(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','AL');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','AK');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','AZ');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','AR');

INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','CA');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','CO');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','CT');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','DE');

INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','FL');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','GA');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','HI');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','ID');

INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','IL');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','IN');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','IA');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','KS');

INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','KY');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','LA');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','ME');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','MD');

INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','MA');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','MI');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','MN');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','MS');

INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','MO');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','MT');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','NE');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','NV');

INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','NH');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','NJ');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','NM');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','NY');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','NC');

INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','ND');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','OH');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','OK');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','OR');

INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','PA');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','RI');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','SC');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','SD');

INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','TN');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','TX');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','UT');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','VT');

INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','VA');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','WA');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','WV');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','WI');

INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('USA','WY');




#  Canadian provinces

INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Canada','AB');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Canada','BC');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Canada','MB');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Canada','NB');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Canada','NL');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Canada','NT');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Canada','NS');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Canada','NU');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Canada','ON');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Canada','PE');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Canada','QC');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Canada','SK');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Canada','YT');


#  Puerto Rico doesn't have states or provinces, but they have municipalities

INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Adjuntas');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Aguado');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Aguadilla');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Aguas Buenas');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Aibonito');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Añasco');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Arecibo');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Arroyo');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Barceloneta');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Barranquitas');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Bayamón');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Cabo Rojo');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Caguas');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Camuy');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Canóvanas');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Carolina');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Cataño');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Cayey');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Ceiba');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Cidra');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Coamo');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Comerío');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Corozal');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Culebra');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Dorado');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Fajardo');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Florida');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Guánica');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Guayama');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Guayanilla');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Guaynabo');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Gurabo');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Hatillo');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Hormigueros');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Humacao');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Isabela');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Jayuya');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Juana Díaz');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Juncos');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Lajas');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Lares');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Las Marías');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Las Piedras');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Loíza');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Luquillo');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Manatí');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Maricao');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Maunabo');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Mayagüez');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Moca');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Morovis');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Naguabo');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Naranjito');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Orocovis');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Patillas');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Peñuelas');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Ponce');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Quebradillas');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Rincón');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Río Grande');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Sabana Grande');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Salinas');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','San Germán');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','San Juan');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','San Lorenzo');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','San Sebastián');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Santa Isabel');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Toa Alta');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Toa Baja');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Trujillo Alto');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Utuado');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Vega Alta');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Vega Baja');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Vieques');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Villalba');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Yabucoa');
INSERT INTO `states_or_provinces` (country, state_or_province) VALUES ('Puerto Rico','Yauco');



#  To create the country table

CREATE TABLE `country` (
  `country_code` int NOT NULL AUTO_INCREMENT,
  `country_name` varchar(45) NOT NULL,
  PRIMARY KEY (`country_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

	
INSERT INTO `country` (country_name) VALUES ('USA');
# INSERT INTO `country` (country_name) VALUES ('Canada');
# INSERT INTO `country` (country_name) VALUES ('Puerto Rico');




#  To create the Address table

CREATE TABLE `address` (
  `address_id` int NOT NULL AUTO_INCREMENT,
  `addr_type` int NOT NULL,
  `addr_line1` varchar(50) NOT NULL,
  `addr_line2` varchar(50),
  `addr_line3` varchar(50),
  `addr_line4` varchar(50),
  `city` varchar(50) NOT NULL,
  `state` varchar(2) NOT NULL,
  `postal_code` varchar(5) NOT NULL,
  `country` varchar(50) NOT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# To create the Contact Info table

CREATE TABLE `contact_info` (
  `contact_info_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `primary_email` varchar(50) NOT NULL,
  `secondary_email` varchar(50),
  `home_phone_no` varchar(11) NOT NULL,
  `cell_phone_no` varchar(11) NOT NULL,
  `work_phone_no` varchar(11) NOT NULL,
  PRIMARY KEY (`contact_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





# To create the Employer Info table

CREATE TABLE `employer_info` (
  `employer_info_id` int NOT NULL AUTO_INCREMENT,
  `employer_name` varchar(50) NOT NULL,
  `employer_phone_no` varchar(11) NOT NULL,
  PRIMARY KEY (`employer_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# To create the Private Info table

CREATE TABLE `private_info` (
  `private_info_id` int NOT NULL AUTO_INCREMENT,
  `gender` varchar(10),
  `ethnicity` varchar(50),
  `ssn` varchar(9),
  `credit_card_no` varchar(16),
  `credit_card_no_exp_month` int,
  `credit_card_no_exp_year` int,
  `credit_card_no_ccv_code` int,
  `date_of_birth` date NOT NULL,
  `credit_score` int,
  PRIMARY KEY (`private_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# To create the contact_info_address join table

CREATE TABLE `contact_info_address` (
  `ContactInfo_contact_info_id` int,
  `homeAddresses_address_id` int
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# To create the employer_info_address join table

CREATE TABLE `employer_info_address` (
  `EmployerInfo_employer_info_id` int,
  `employerAddresses_address_id` int
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# To create the private_info_address join table

CREATE TABLE `private_info_address` (
  `PrivateInfo_private_info_id` int,
  `creditCardBillingAddresses_address_id` int
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




#  To create the renter profile table

CREATE TABLE `renter_profile` (
  	`renter_profile_id` int NOT NULL AUTO_INCREMENT,
  	`type_of_profile` varchar(20) NOT NULL,
	`user_id` int,
	`contactInfo_contact_info_id` int,
	`employerInfo_employer_info_id` int,
	`privateInfo_private_info_id` int,
  PRIMARY KEY (`renter_profile_id`),
  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (contactInfo_contact_info_id) REFERENCES contact_info(contact_info_id),
  FOREIGN KEY (employerInfo_employer_info_id) REFERENCES employer_info(employer_info_id),
  FOREIGN KEY (privateInfo_private_info_id) REFERENCES private_info(private_info_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



#  To create the contractor profile table

CREATE TABLE `contractor_profile` (
  	`contractor_profile_id` int NOT NULL AUTO_INCREMENT,
  	`type_of_profile` varchar(20) NOT NULL,
	`user_id` int,
	`contactInfo_contact_info_id` int,
	`employerInfo_employer_info_id` int,
  PRIMARY KEY (`contractor_profile_id`),
  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (contactInfo_contact_info_id) REFERENCES contact_info(contact_info_id),
  FOREIGN KEY (employerInfo_employer_info_id) REFERENCES employer_info(employer_info_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


#  To create the employee profile table

CREATE TABLE `employee_profile` (
  	`employee_profile_id` int NOT NULL AUTO_INCREMENT,
  	`type_of_profile` varchar(20) NOT NULL,
	`user_id` int,
	`contactInfo_contact_info_id` int,
	`employerInfo_employer_info_id` int,
  PRIMARY KEY (`employee_profile_id`),
  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (contactInfo_contact_info_id) REFERENCES contact_info(contact_info_id),
  FOREIGN KEY (employerInfo_employer_info_id) REFERENCES employer_info(employer_info_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


#  To create the manager profile table

CREATE TABLE `manager_profile` (
  	`manager_profile_id` int NOT NULL AUTO_INCREMENT,
  	`type_of_profile` varchar(20) NOT NULL,
	`user_id` int,
	`contactInfo_contact_info_id` int,
	`employerInfo_employer_info_id` int,
  PRIMARY KEY (`manager_profile_id`),
  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (contactInfo_contact_info_id) REFERENCES contact_info(contact_info_id),
  FOREIGN KEY (employerInfo_employer_info_id) REFERENCES employer_info(employer_info_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


#  To create the admin profile table

CREATE TABLE `admin_profile` (
  	`admin_profile_id` int NOT NULL AUTO_INCREMENT,
  	`type_of_profile` varchar(20) NOT NULL,
	`user_id` int,
	`contactInfo_contact_info_id` int,
	`employerInfo_employer_info_id` int,
  PRIMARY KEY (`admin_profile_id`),
  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (contactInfo_contact_info_id) REFERENCES contact_info(contact_info_id),
  FOREIGN KEY (employerInfo_employer_info_id) REFERENCES employer_info(employer_info_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


#  To create the owner profile table

CREATE TABLE `owner_profile` (
  	`owner_profile_id` int NOT NULL AUTO_INCREMENT,
  	`type_of_profile` varchar(20) NOT NULL,
	`user_id` int,
	`contactInfo_contact_info_id` int,
	`employerInfo_employer_info_id` int,
  PRIMARY KEY (`owner_profile_id`),
  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (contactInfo_contact_info_id) REFERENCES contact_info(contact_info_id),
  FOREIGN KEY (employerInfo_employer_info_id) REFERENCES employer_info(employer_info_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





#  To create the Rental Unit Amenity table

CREATE TABLE `rental_unit_amenity` (
  `rental_unit_amenity_id` int NOT NULL AUTO_INCREMENT,
  `rental_unit_id` int NOT NULL,
  `rental_unit_no` int NOT NULL,
  `amenity_type` int NOT NULL,
  `description` varchar(200) NOT NULL,
  `comment` varchar(200) NOT NULL,
  PRIMARY KEY (`rental_unit_amenity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# To create the Rental Property table

CREATE TABLE `rental_property` (
  `rental_property_id` int NOT NULL AUTO_INCREMENT,
  `rentalPropertyAddress_address_id` int NOT NULL,
  `rental_property_name` varchar(50) NOT NULL,
  `owner_user_id` int NOT NULL,
  `manager_user_id` int NOT NULL,
  `image_url` varchar(250),
  PRIMARY KEY (`rental_property_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# To create the rental_unit_rental_unit_amenity join table

CREATE TABLE `rental_unit_rental_unit_amenity` (
  `RentalUnit_rental_unit_id` int,
  `rentalUnitAmenities_rental_unit_amenity_id` int
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


#  To create the rental_repair table

CREATE TABLE `rental_repair` (
  `rental_repair_id` int NOT NULL AUTO_INCREMENT,
  `submitted_by_user_id` int NOT NULL,
  `submitted_date` date  NOT NULL,
  `completion_date` date,
  `rental_property_id` int NOT NULL,
  `rental_unit_no` int NOT NULL,
  `rental_repair_type` int NOT NULL,
  `repair_status` int NOT NULL,
  `description` varchar(200) NOT NULL,
  `comment` varchar(200),
  `root_cause` int,
  `repair_cost_estimate` double,
  `repair_cost_actual` double,
  `assigned_to_contractor_id` int,
  PRIMARY KEY (`rental_repair_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



#  To create the rental_payment table

CREATE TABLE `rental_payment` (
  `rental_payment_id` int NOT NULL AUTO_INCREMENT,
  `renter_user_id` int NOT NULL,
  `rental_property_id` int NOT NULL,
  `rental_unit_no` int NOT NULL,
  `rental_year` varchar(4)  NOT NULL,
  `rental_month` varchar(2)  NOT NULL,
  `payment_made` boolean,
  `date_of_payment` date,
  `monthly_rent_amt` double NOT NULL,
  `note` varchar(200),
  PRIMARY KEY (`rental_payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
