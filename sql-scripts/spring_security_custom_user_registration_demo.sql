DROP DATABASE  IF EXISTS `rental-website-db`;

CREATE DATABASE  IF NOT EXISTS `rental-website-db`;
USE `rental-website-db`;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` char(80) NOT NULL,
  `name_prefix` varchar(50),
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `name_suffix` varchar(50),
  `primary_email` varchar(50) NOT NULL,
  `user_creation_date` date,
  `access_level` int ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is available at: https://www.bcryptcalculator.com/encode
--
-- Default passwords here are: fun123
--
INSERT INTO `user` (username,password,name_prefix,first_name,last_name,name_suffix,primary_email,user_creation_date,access_level)
VALUES 
('john','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','','John','Doe','','john@aol.com','2021-06-06',1),
('mary','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','','Mary','Public','','mary@yahoo.com','2021-06-06',1),
('susan','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','','Susan','Adams','','susan@msn.com','2021-06-06',1),
('bill','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','Dr.','Bill','Cotter','','bill@msn.com','2021-06-06',1),
('phil','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','','Phil','Masic','','phil@aol.com','2021-06-06',1),
('amy','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','Dr.','Amy','Meyers','','amy@msn.com','2021-06-06',1),
('paulo','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','','Paulo','Masic','Jr.','paulo@aol.com','2021-06-06',3);

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roles`
--

INSERT INTO `role` (name)
VALUES 
('ROLE_RENTER'),('ROLE_CONTRACTOR'),('ROLE_EMPLOYEE'),('ROLE_MANAGER'),('ROLE_ADMIN'),('ROLE_OWNER');

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;

CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  
  PRIMARY KEY (`user_id`,`role_id`),
  
  KEY `FK_ROLE_idx` (`role_id`),
  
  CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) 
  REFERENCES `role` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` (user_id,role_id)
VALUES 
(1, 2),
(2, 3),
(3, 1),
(4, 3),
(4, 4),
(4, 5),
(5, 1),
(6, 5),
(7, 3),
(7, 6)