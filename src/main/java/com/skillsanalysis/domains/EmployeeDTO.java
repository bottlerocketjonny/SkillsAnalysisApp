package com.skillsanalysis.domains;

import java.util.List;
import java.util.stream.Collectors;

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

	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	@Email(message = "This email address is invalid")
	private String email;
	
	private String address;
	
	private String role;
	
	private String companyName;
	
	private List<SoftSkillsDTO> softSkills;
	
	public EmployeeDTO(Employee employee) {
		this.id = employee.getId();
		this.firstName = employee.getFirstName();
		this.lastName = employee.getLastName();
		this.email = employee.getEmail();
		this.address = employee.getAddress();
		this.role = employee.getRole();
		this.companyName = employee.getCompanyName();
		this.softSkills = employee.getSoftSkills().stream().map(SoftSkillsDTO::new).collect(Collectors.toList());
	}
	
}
