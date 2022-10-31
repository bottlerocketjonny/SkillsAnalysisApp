package com.skillsanalysis.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillsanalysis.domains.Employee;
import com.skillsanalysis.repos.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo repo;
	
	public Employee createEmployee(Employee employee) {
		return this.repo.save(employee);
	}
	
	public Employee getEmployeeById(Long id) {
		return this.repo.findById(id).orElseThrow();					// update with custom exception
	}
	
	public List<Employee> getAllEmployees() {							// update with dto
		List<Employee> output = new ArrayList<Employee>();
		repo.findAll().forEach(e -> output.add(new Employee(e)));
		return output;
	}
	
	public Employee updateEmployee(Long id, Employee employee) {
		Employee exists = repo.findById(id).orElse(new Employee());

		exists.setFirstName(employee.getFirstName());
		exists.setFirstName(employee.getLastName());
		exists.setEmail(employee.getEmail());
		exists.setFirstName(employee.getAddress());
		exists.setRole(employee.getRole());
		exists.setCompanyName(employee.getCompanyName());

		return repo.save(exists);
	}
	
	public boolean deleteEmployee(Long id) {
		repo.deleteById(id);
		return (!repo.existsById(id));
	}
}
