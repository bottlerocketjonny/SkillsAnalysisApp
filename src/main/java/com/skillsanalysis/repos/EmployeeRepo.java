package com.skillsanalysis.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillsanalysis.domains.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
