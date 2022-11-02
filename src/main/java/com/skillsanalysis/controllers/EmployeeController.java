package com.skillsanalysis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillsanalysis.domains.Employee;
import com.skillsanalysis.domains.EmployeeDTO;
import com.skillsanalysis.exceptions.EmployeeNotFoundException;
import com.skillsanalysis.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	// create
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee employee) {
		return service.createEmployee(employee);
	}
	
	// get all
	@GetMapping("/getAll")
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}
	
	// get one by id
	@GetMapping("/getOne/{id}")
	public Employee getEmployeebyId(@PathVariable("id") Long id) {			
		return service.getEmployeeById(id);
	}
	
	// get one by last name
	@GetMapping("/getOneByLastName/{lastName}")
	public EmployeeDTO getOneByLastName(@PathVariable String lastName) throws EmployeeNotFoundException {
		return service.getOneByLastName(lastName);
	}
	
	// update
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id) {
		return service.updateEmployee(id, employee);
	}
	
	// delete
	@DeleteMapping("/delete/{id}")
	public Boolean deleteEmployee(@PathVariable("id") Long id) {
		return service.deleteEmployee(id);
	}


	
}
