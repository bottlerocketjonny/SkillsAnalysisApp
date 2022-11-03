package com.skillsanalysis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.skillsanalysis.domains.Employee;
import com.skillsanalysis.domains.EmployeeDTO;
import com.skillsanalysis.domains.SoftSkills;
import com.skillsanalysis.repos.EmployeeRepo;
import com.skillsanalysis.services.EmployeeService;

@SpringBootTest
public class EmployeeUnitTests {
	
	@Autowired
	private EmployeeService service;
	
	@MockBean
	private EmployeeRepo repo;	

	final long id = 1L;
	private List<SoftSkills> softSkills = new ArrayList<>();
	
	@Test
	void testCreate() {
		softSkills.add(new SoftSkills(id, null, null, 8, 5, 7, 9, 6));
		LocalDate dob = LocalDate.of(1993, 01, 22);
		
		Employee testEmployee = new Employee(id, softSkills, "Jonny", "Coddington", "j.coddington@gmail.com", dob,
				"69 The Road, London, SE23 5RT", "Python Developer", "Peach Ltd");
		
		Mockito.when(this.repo.save(testEmployee)).thenReturn(testEmployee);
		
		assertEquals(testEmployee, this.service.createEmployee(testEmployee));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(testEmployee);
	}
	
	@Test
	void testGetAll() {
	softSkills.add(new SoftSkills(id, null, null, 8, 5, 7, 9, 6));
	LocalDate dob = LocalDate.of(1993, 01, 22);
	Employee testEmployee = new Employee(id, softSkills, "Jonny", "Coddington", "j.coddington@gmail.com", dob,
			"69 The Road, London, SE23 5RT", "Python Developer", "Peach Ltd");
	
	EmployeeDTO testEmployeeDTO = new EmployeeDTO(testEmployee);
	
	Mockito.when(this.repo.findAll()).thenReturn(Collections.singletonList(testEmployee));
	
	assertEquals(List.of(testEmployeeDTO), this.service.getAllEmployees());
	
	Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	void testGetOne() {
		softSkills.add(new SoftSkills(id, null, null, 8, 5, 7, 9, 6));
		LocalDate dob = LocalDate.of(1993, 01, 22);
		Employee testEmployee = new Employee(id, softSkills, "Jonny", "Coddington", "j.coddington@gmail.com", dob,
				"69 The Road, London, SE23 5RT", "Python Developer", "Peach Ltd");
		
		EmployeeDTO testEmployeeDTO = new EmployeeDTO(testEmployee);
		
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(new Employee(id, softSkills, "Jonny", "Coddington", "j.coddington@gmail.com", dob,
				"69 The Road, London, SE23 5RT", "Python Developer", "Peach Ltd")));
		
		assertEquals(testEmployeeDTO, this.service.getEmployeeById(id));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}

	@Test
	void testUpdate() {
		softSkills.add(new SoftSkills(id, null, null, 8, 5, 7, 9, 6));
		LocalDate dob = LocalDate.of(1993, 01, 22);
		
		Employee testEmployee = new Employee(id, softSkills, "Jonny", "Coddington", "j.coddington@gmail.com", dob,
				"69 The Road, London, SE23 5RT", "Python Developer", "Peach Ltd");
		
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(new Employee(id, softSkills, "Jonny", "Coddington", "j.coddington@gmail.com", dob,
				"69 The Road, London, SE23 5RT", "Python Developer", "Peach Ltd")));
		
		Mockito.when(this.repo.save(testEmployee)).thenReturn(testEmployee);
		
		assertEquals(new EmployeeDTO(testEmployee), this.service.updateEmployee(id, testEmployee));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(testEmployee);
	}
	
	@Test 
	void testDelete() {
		
		Mockito.when(this.repo.existsById(id)).thenReturn(true);
		
		assertTrue(this.service.deleteEmployee(id));
		
		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}

}
