package com.skillsanalysis.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillsanalysis.domains.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
	Optional<Employee> findByLastName(String lastName);

}
