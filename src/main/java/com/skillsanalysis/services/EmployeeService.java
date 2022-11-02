package com.skillsanalysis.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillsanalysis.domains.Employee;
import com.skillsanalysis.domains.EmployeeDTO;
import com.skillsanalysis.exceptions.EmployeeNotFoundException;
import com.skillsanalysis.repos.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo repo;
	
	public Employee createEmployee(Employee employee) {
		return this.repo.save(employee);
	}
	
	public Employee getEmployeeById(Long id) throws EmployeeNotFoundException {
		return this.repo.findById(id).orElseThrow(EmployeeNotFoundException::new);	
	}
	
	public EmployeeDTO getOneByLastName(String lastName) throws EmployeeNotFoundException {
		Optional<Employee> search = repo.findByLastName(lastName);
		if (search.isPresent()) {
			return new EmployeeDTO(search.get());
		}
		throw new EmployeeNotFoundException();
	}
	
	public List<EmployeeDTO> getAllEmployees() {
		return this.repo.findAll().stream().map(EmployeeDTO::new).collect(Collectors.toList());
	}
	
	public Employee updateEmployee(Long id, Employee employee) {
		Employee exists = repo.findById(id).orElseThrow(EmployeeNotFoundException::new);

		exists.setFirstName(employee.getFirstName());
		exists.setLastName(employee.getLastName());
		exists.setEmail(employee.getEmail());
		exists.setAddress(employee.getAddress());
		exists.setRole(employee.getRole());
		exists.setCompanyName(employee.getCompanyName());

		return repo.save(exists);
	}
	
	public boolean deleteEmployee(Long id) {				
		
		repo.deleteById(id);
		return (!repo.existsById(id));
	}
}
