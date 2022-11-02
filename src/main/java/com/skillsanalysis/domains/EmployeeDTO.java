package com.skillsanalysis.domains;

import java.util.List;

import javax.validation.constraints.Email;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployeeDTO {

	private String firstName;
	
	private String lastName;
	
	@Email(message = "This email address is invalid")
	private String email;
	
	private String address;
	
	private String role;
	
	private String companyName;
	
	private List<SoftSkillsDTO> softSkills;
	
	public EmployeeDTO(Employee employee) {
		this.firstName = employee.getFirstName();
		this.lastName = employee.getLastName();
		this.email = employee.getEmail();
		this.address = employee.getAddress();
		this.role = employee.getRole();
		this.companyName = employee.getCompanyName();
	}
	
}
