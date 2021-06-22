package com.abcrentals.binu.thankachan.entity;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Collection;

/*
 * User entity definition for Hibernate ORM mapping to database table
 * 
 * 
 * 
 */


@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;
	
	@Column(name = "name_prefix")
	private String namePrefix;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "name_suffix")
	private String nameSuffix;

	@Column(name = "email")
	private String email;
	
 	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name="user_creation_date")
	private LocalDate creationDate;
	
	@Column(name="access_level")
	private Integer accessLevel; //1=Level 1 - Basic, 2=Level 2 - Manage, 3=Level 3 - Owner, 4=Level 4 - Admin, 5=Level 5 - Super User            

	@Column(name="first_and_last_name")
	private String firstAndLastName;

	@Column(name="full_name")
	private String fullName;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles;

	public User() {
	}

	public User(String userName, String password, String namePrefix, String firstName, String lastName,
			String nameSuffix, String email, LocalDate creationDate) {
		super();
		this.userName = userName;
		this.password = password;
		this.namePrefix = namePrefix;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nameSuffix = nameSuffix;
		this.email = email;
		this.creationDate = creationDate;
	}

	public User(String userName, String password, String namePrefix, String firstName, String lastName,
			String nameSuffix, String email, LocalDate creationDate, Integer accessLevel,
			Collection<Role> roles) {
		super();
		this.userName = userName;
		this.password = password;
		this.namePrefix = namePrefix;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nameSuffix = nameSuffix;
		this.email = email;
		this.creationDate = creationDate;
		this.accessLevel = accessLevel;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNamePrefix() {
		return namePrefix;
	}

	public void setNamePrefix(String namePrefix) {
		this.namePrefix = namePrefix;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNameSuffix() {
		return nameSuffix;
	}

	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(Integer accessLevel) {
		this.accessLevel = accessLevel;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	
	public String getFirstAndLastName() {
		return firstAndLastName;
	}

	public void setFirstAndLastName(String firstAndLastName) {
		this.firstAndLastName = this.firstName + " " + this.lastName;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = this.namePrefix + " " + this.firstName + " " + this.lastName + " " + this.nameSuffix;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + "*********" + ", namePrefix=" + namePrefix
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", nameSuffix=" + nameSuffix
				+ ", email=" + email + ", creationDate=" + creationDate + ", accessLevel=" + accessLevel
				+ ", firstAndLastName=" + firstAndLastName + ", fullName=" + fullName
				+ ", roles=" + roles + "]";
	}

	
	
	
	
	
	
	
	
}
