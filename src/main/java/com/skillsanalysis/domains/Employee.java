package com.skillsanalysis.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Min(2)
	private String firstName;
	
	@Min(2)
	private String lastName;
	
	@Email(message = "This email address is invalid")
	private String email;
	
	private String address;
	
	private String role;
	
	private Long employerId;
	
	private String companyName;
	
	

}

