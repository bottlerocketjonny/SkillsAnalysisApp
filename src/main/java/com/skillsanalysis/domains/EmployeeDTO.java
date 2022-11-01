package com.skillsanalysis.domains;

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
public class EmployeeDTO {

	private String firstName;
	
	private String lastName;
	
	@Email(message = "This email address is invalid")
	private String email;
	
	private String address;
	
	private String role;
	
	private String companyName;
	
	public EmployeeDTO(Employee employee) {
		this.firstName = employee.getFirstName();
		this.lastName = employee.getLastName();
		this.email = employee.getEmail();
		this.address = employee.getAddress();
		this.role = employee.getRole();
		this.companyName = employee.getCompanyName();
	}
	
}
