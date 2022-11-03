package com.skillsanalysis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.skillsanalysis.domains.Employee;
import com.skillsanalysis.domains.SoftSkills;
import com.skillsanalysis.repos.EmployeeRepo;
import com.skillsanalysis.services.EmployeeService;

@SpringBootTest
public class MockitoTesting {
	
	@Autowired
	private EmployeeService service;
	
	@MockBean
	private EmployeeRepo repo;		
	final long id = 1L;
	
	@Test
	void testUpdate() {
		
		List<SoftSkills> softSkills = new ArrayList<>();
		softSkills.add(new SoftSkills(id, null, null, 8, 5, 7, 9, 6));
		LocalDate dob = LocalDate.of(1993, 01, 22);

		Employee testEmployee = new Employee(id, softSkills, "Jonny", "Coddington", "j.coddington@gmail.com", dob,
				"69 The Road, London, SE23 5RT", "Python Developer", "Peach Ltd");
		
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(new Employee(id, softSkills, "Jonny", "Coddington", "j.coddington@gmail.com", dob,
				"69 The Road, London, SE23 5RT", "Python Developer", "Peach Ltd")));
		
		Mockito.when(this.repo.save(testEmployee)).thenReturn(testEmployee);
		
		assertEquals(testEmployee, this.service.updateEmployee(id, testEmployee));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(testEmployee);
		
	}
	
	@Test 
	void testDelete() {
		
		List<SoftSkills> softSkills = new ArrayList<>();
		softSkills.add(new SoftSkills(id, null, null, 8, 5, 7, 9, 6));
		LocalDate dob = LocalDate.of(1993, 01, 22);

		Employee testEmployee = new Employee(id, softSkills, "Jonny", "Coddington", "j.coddington@gmail.com", dob,
				"69 The Road, London, SE23 5RT", "Python Developer", "Peach Ltd");
		
		Mockito.when(this.repo.existsById(id)).thenReturn(false);
		
		assertTrue(this.service.deleteEmployee(id));
		
		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}

}
