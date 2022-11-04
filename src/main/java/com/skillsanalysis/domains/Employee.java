package com.skillsanalysis.domains;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "employee", cascade = {CascadeType.REMOVE})
	private List<SoftSkills> softSkills;
	
	private String firstName;
	
	private String lastName;
	
	@Email(message = "This email address is invalid")
	private String email;
	
	private LocalDate dob;
	
	private String address;
	
	private String role;
	
	private String companyName;
	
	

}
